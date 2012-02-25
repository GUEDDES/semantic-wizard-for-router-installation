/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.engine;

import es.unavarra.iws.routerinstall.engine.utils.StringUtils;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Itziar
 */
public class Engine {

    private static final Logger logger = Logger.getLogger(Engine.class);
    private static final String owlFilePath = "/es/unavarra/iws/routerinstall/resources/owl/RouterInstall.owl";
    private static final String defaultNameSpace = "http://www.owl-ontologies.com/Ontology1325175471.owl#";
    private OntModel model;
    private Vocabulary vocabulary;
    private Individual myRouter;

    public Engine() {
    }

    public void init() {
        InputStream in = Engine.class.getResourceAsStream(owlFilePath);

        //Create an empty model
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        //Read the RDF/XML file
        model.read(in, "");
        vocabulary = new Vocabulary(model);

        myRouter = createRouter("routerA");

        logger.info("Engine init");

    }

    public Individual createRouter(String id) {
        Individual router = model.createIndividual(Vocabulary.getURI() + id, vocabulary.router);
        router.addProperty(vocabulary.instanceOf, vocabulary.router);
        router.addProperty(vocabulary.hasPort, vocabulary.puertoCorriente);
        router.addProperty(vocabulary.hasComponent, vocabulary.botonEncendido);
        router.addProperty(vocabulary.hasComponent, vocabulary.botonReset);
        router.addProperty(vocabulary.hasComponent, vocabulary.ledEncendido);
        router.addProperty(vocabulary.pasoActual, vocabulary.PASO_ENCENDIDO);

        return router;

    }

    public void test() {
        //  Individual r = createRouter("prueba");
        //  r.addProperty(vocabulary.hasComponent, vocabulary.antena);
        //  r.addProperty(vocabulary.isOfModel, vocabulary.TG585v7);
        //  checkTipo(r);
        //  String result = executeQueryBasicConcepts("enrutador wifi");
        //  System.out.println(result);
        //searchCharacteristics("wifi");
         String pasoActual = getCurrentStep();
         logger.info(pasoActual);
 
    }

    public synchronized List<String> querySPARQL(String queryString, String param) {
        ArrayList<String> list = new ArrayList<String>();
        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet rs = qe.execSelect();
        while (rs.hasNext()) {
            QuerySolution binding = rs.nextSolution();
            list.add(binding.get(param).toString());
        }
        qe.close();

        return list;
    }

    public synchronized List<List<String>> querySPARQL(String queryString, List<String> params) {
        List<List<String>> list = new ArrayList<List<String>>();

        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet rs = qe.execSelect();
        while (rs.hasNext()) {
            QuerySolution binding = rs.nextSolution();
            List<String> inside = new ArrayList<String>();

            Iterator<String> it = params.iterator();
            while (it.hasNext()) {
                String param = it.next();
                if (param.isEmpty()) {
                    inside.add("");
                } else {
                    inside.add(binding.get(param).toString());
                }
            }
            list.add(inside);
        }
        qe.close();

        return list;
    }

    public Resource getTipo(Individual router) {
        Resource tipo = null;
        if (router.hasProperty(vocabulary.hasComponent, vocabulary.antena)) {
            tipo = vocabulary.INALAMBRICO;
        } else if (router.hasProperty(vocabulary.hasComponent, vocabulary.puertoUSB)) {
            tipo = vocabulary.USB;
        } else {
            tipo = vocabulary.MONOPUERTO;
            router.addProperty(vocabulary.isOfTipo, vocabulary.MONOPUERTO);
        }
        router.addProperty(vocabulary.isOfTipo, tipo);
        return tipo;
    }

    private void checkTipo(Individual router) {
        Resource modeloRouter = router.getPropertyResourceValue(vocabulary.isOfModel);

        if (router.hasProperty(vocabulary.hasComponent, vocabulary.antena)
                || modeloRouter.equals(vocabulary.TG585v7)
                || modeloRouter.equals(vocabulary.fast2604)
                || modeloRouter.equals(vocabulary.x7028r)
                || modeloRouter.equals(vocabulary.HG556)) {
            router.addProperty(vocabulary.isOfTipo, vocabulary.INALAMBRICO);
        } else if (modeloRouter.equals(vocabulary.CT_5071)) {
            router.addProperty(vocabulary.isOfTipo, vocabulary.MONOPUERTO);
        } else if (modeloRouter.equals(vocabulary.CT_351)||
                router.hasProperty(vocabulary.hasComponent, vocabulary.puertoUSB)) {
            router.addProperty(vocabulary.isOfTipo, vocabulary.USB);
        }
    }

    public String executeQueryBasicConcepts(String searchString) {
        List<List<String>> queryResults = fullSearchByLabel(searchString);
        String basePage = null;

        if (!queryResults.isEmpty()) {
            //Buscar la página asociada con el recurso encontrado de mayor prioridad
            basePage = getBasePageWithMaxPriority(queryResults);
        }
        return basePage;
    }

    public void searchCharacteristics(String searchString) {
        List<List<String>> queryResults = fullSearchByLabel(searchString);

        if (!queryResults.isEmpty()) {
            //Buscar que los recursos sean características
            Iterator<List<String>> it = queryResults.iterator();
            while (it.hasNext()) {
                List<String> list1 = it.next();
                String resourceName = list1.get(0);
               
                //Comprobar instancias
                OntClass ontClass = getClassOfIndividual(resourceName);
                if (ontClass != null) {
                    if (ontClass.equals(vocabulary.tipoRouter)) {
                        myRouter.addProperty(vocabulary.isOfTipo, model.getIndividual(resourceName));
                    } else if (ontClass.equals(vocabulary.modeloRouter)) {
                        myRouter.addProperty(vocabulary.isOfModel, model.getIndividual(resourceName));
                        checkTipo(myRouter);
                    } else if (ontClass.equals(vocabulary.proveedor)) {
                        myRouter.addProperty(vocabulary.isOfProveedor, model.getIndividual(resourceName));
                    }
                }
                else {
                    //Comprobar componentes
                    ontClass = getClass(resourceName);
                    if (ontClass != null) {
                        OntClass parent = ontClass.getSuperClass();
                        if (parent.equals(vocabulary.componente) || parent.getSuperClass().equals(vocabulary.componente)) {
                            myRouter.addProperty(vocabulary.hasComponent, ontClass);
                       } else if (parent.equals(vocabulary.puerto)) {
                             myRouter.addProperty(vocabulary.hasPort, ontClass);
                        }
                    }
                }
            }
        }
    }

    private OntClass getClassOfIndividual(String individualName) {
        OntClass ontClass = null;
        try {
            Individual individual = model.getIndividual(individualName);
            ontClass = individual.getOntClass();
        } catch (Exception ex) {
            logger.info("Not an individual");
        }
        return ontClass;
    }

    private OntClass getClass(String className) {
        OntClass ontClass = null;
        try {
            ontClass = model.getOntClass(className);
        } catch (Exception ex) {
            logger.info("Not a class");
        }
        return ontClass;

    }

    private List<List<String>> fullSearchByLabel(String searchString) {
        //Buscar por label en toda la cadena de entrada
        List<List<String>> queryResults = searchByLabel(searchString);

        searchString = StringUtils.prepareSearchString(searchString);
        if (queryResults.isEmpty()) {
            //Repetir la búsqueda haciendo un split de la cadena de entrada
            String[] splittedString = searchString.split(" ");
            for (int i = 0; i < splittedString.length; i++) {
                String s = splittedString[i];
                queryResults.addAll(searchByLabel(s));
            }
        }
        return queryResults;
    }

    private static String getBasePageWithMaxPriority(List<List<String>> queryResults) {
        double maxP = 0;
        String chosenBasePage = null;
        Iterator<List<String>> it = queryResults.iterator();
        while (it.hasNext()) {
            List<String> list1 = it.next();
            int priority = Integer.parseInt(list1.get(1));
            if (priority > maxP) {
                maxP = priority;
                chosenBasePage = list1.get(2);
            }
        }

        return chosenBasePage;
    }

    private List<List<String>> searchByLabel(String searchString) {
        String queryString = "PREFIX foaf:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl:    <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX fn: <http://www.w3.org/2005/xpath-functions#>"
                + " SELECT ?resource ?priority ?basePage"
                + " WHERE {"
                + "   ?resource rdfs:label ?label ."
                + "   ?resource foaf:hasPriority ?priority ."
                + "   ?resource foaf:hasBasePage ?basePage ."
                + "FILTER (regex(fn:lower-case(?label), \"" + searchString + "\")) "
                + "}";

        List<String> params = new ArrayList<String>();
        params.add("?resource");
        params.add("?priority");
        params.add("?basePage");

        List<List<String>> list = querySPARQL(queryString, params);
        return list;
    }
    
        private String getCurrentStep() {
        String queryString = "PREFIX foaf:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl:    <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX fn: <http://www.w3.org/2005/xpath-functions#>"
                + " SELECT ?pasoActual  "
                + " WHERE {"
                + "   ?resource rdf:instanceOf foaf:Router ."
                + "   ?resource foaf:pasoActual ?pasoActual ."
                 + "}";

        List<String> params = new ArrayList<String>();
        params.add("?resource");
        params.add("?priority");
        params.add("?basePage");

        List<String> list = querySPARQL(queryString, "?pasoActual");
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }




    public synchronized void saveOntology(String file, String type) {
        try {
            model.write(new FileWriter(file), type);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public synchronized OntModel getModel() {
        return model;
    }

    public static void main(String[] args) {
        Engine e = new Engine();
        e.init();
        e.test();
    }
}
