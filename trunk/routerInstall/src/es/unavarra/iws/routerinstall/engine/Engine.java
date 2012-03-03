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
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Statement;
import es.unavarra.iws.routerinstall.engine.utils.MatchingResult;


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

    public Engine() {
    }

    public void init() {
        InputStream in = Engine.class.getResourceAsStream(owlFilePath);

        //Create an empty model
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        //Read the RDF/XML file
        model.read(in, "");
        vocabulary = new Vocabulary(model);

        logger.info("Engine init");
    }

    /**
     * Execute an SPARQL query with one single argument.
     * @param queryString
     * @param param
     * @return 
     */
    private synchronized List<String> querySPARQL(String queryString, String param) {
        ArrayList<String> list = new ArrayList<String>();
        Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet rs = qe.execSelect();

        while (rs.hasNext()) {
            QuerySolution binding = rs.nextSolution();
            list.add(binding.get(param).toString());
        }
        qe.close();
        return list;
    }

    /**
     * Execute an SPARQL query with multiple arguments.
     * @param queryString
     * @param params
     * @return 
     */
    private synchronized List<List<String>> querySPARQL(String queryString, List<String> params) {
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

 
    /**
     * Perform an extensive search and return a list of matching results.
     * @param searchString
     * @return 
     */
    public List<MatchingResult> fullSearchByLabel(String searchString) {
        List<MatchingResult> queryResults = new ArrayList<MatchingResult>();

        //Prepare the string for performing the query.
        searchString = StringUtils.prepareSearchString(searchString);
        
        //Search on the full string
        MatchingResult res = searchByLabel(searchString);

        if (!res.getResults().isEmpty()) {
            queryResults.add(res);
        } else {
            //<aqm des="solo si la cadena tiene " ", sino se repetira la busqueda"/>
            
            //If no results were found, split the search string and repeat the search
            //on each substring.
            String[] splittedString = searchString.split(" ");
            
            if (splittedString.length > 1) {
                for (int i = 0; i < splittedString.length; i++) {
                    String s = splittedString[i];
                    res = searchByLabel(s);
                    if (!res.getResults().isEmpty()) {
                        queryResults.add(res);
                    }
                }
            }
        }
        return queryResults;
    }

    /**
     * Search for basic concepts whose label matches the search string.
     * @param searchString
     * @return 
     */
    private MatchingResult searchByLabel(String searchString) {
        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX fn: <http://www.w3.org/2005/xpath-functions#>"
                + " SELECT ?resource ?priority"
                + " WHERE {"
                + "   ?resource rdfs:label ?label ."
                + "   ?resource RouterInstall:hasPriority ?priority "
                + "FILTER (regex(fn:lower-case(?label), \"" + searchString + "\")) "
                + "}";

        List<String> params = new ArrayList<String>();
        params.add("?resource");
        params.add("?priority");

        List<List<String>> list = querySPARQL(queryString, params);
        return new MatchingResult(list, searchString.length());
    }
    
    /**
     * Obtain the list of all routers supported by the model
     * @return 
     */
      private List<String> getAllRouters() {
        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + " SELECT ?routerName "
                + " WHERE {"
                + "   ?routerName rdf:instanceOf <" + vocabulary.router.getURI() + ">  "
                + "}";
        List<String> allRouters = querySPARQL(queryString, "?routerName");
        return allRouters;
    }

    /**
     * Obtain the list of all errors included in the model.
     * @return 
     */
    public List<InstallationError> searchFrequentErrors() {
        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + " SELECT ?error ?title ?descr ?solProb"
                + " WHERE {"
                + "   ?error rdf:instanceOf <" + vocabulary.problemaInstalacion.getURI() + "> . "
                + "   ?error RouterInstall:title ?title . "
                + "   ?error RouterInstall:Problema ?descr . "
                + "   ?error RouterInstall:SolucionProblema ?solProb "
                + "}";
        List<String> params = new ArrayList<String>();
        params.add("?error");
        List<List<String>> allErrors = querySPARQL(queryString, params);

        List<InstallationError> problems = new ArrayList<InstallationError>();

        Iterator<List<String>> it = allErrors.iterator();
        while (it.hasNext()) {
            List<String> list = it.next();
            Individual error = model.getIndividual(list.get(0));  
            problems.add(createInstallationError(error));
        }
        return problems;
    }
    

    /**
     * Return the list of all router names supported in the model.
     * @return 
     */
    public List<String> searchAvailableRouters() {
        List<String> resources = getAllRouters();
        List<String> routerNames = new ArrayList<String>();
        Iterator<String> it = resources.iterator();

        while (it.hasNext()) {
            String rURI = it.next();
            if (!rURI.contains("new")) {
                routerNames.add(model.getResource(rURI).getLocalName());
            }
        }
        return routerNames;
    }
    
    
     private Individual createRouter(String id) {
        Individual router = model.createIndividual(Vocabulary.getURI() + id, vocabulary.router);
        router.addProperty(vocabulary.instanceOf, vocabulary.router);
        router.addProperty(vocabulary.hasPort, vocabulary.puertoCorriente);
        router.addProperty(vocabulary.hasComponent, vocabulary.botonEncendido);
        router.addProperty(vocabulary.hasComponent, vocabulary.botonReset);
        router.addProperty(vocabulary.hasComponent, vocabulary.ledEncendido);

        return router;
    }

    public InstallationError createInstallationError(Individual error) {
        logger.info(error);
        String id = "ERROR_" + error.getProperty(vocabulary.isProblemOf).getObject().asResource().getLocalName().toUpperCase();
        String title = error.getProperty(vocabulary.title).getString();
        String descr = error.getProperty(vocabulary.problemDescr).getString();
        String solution = error.getProperty(vocabulary.problemSolution).getString();
        InstallationError p = new InstallationError(id, title, descr, solution);
        return p;
    }

    /**
     * Return the most specific query result depending on its priority and its level in the class hierarchy.
     * @param queryResults
     * @return 
     */
    public String getResourceWithMaxPriority(List<MatchingResult> queryResults) {
        double maxP = 0;
        int maxLength = 0;
        String chosenResource = null;
        Iterator<MatchingResult> itQ = queryResults.iterator();
        OntClass chosenClass = null;

        while (itQ.hasNext()) {
            MatchingResult qRes = itQ.next();
            Iterator<List<String>> it = qRes.getResults().iterator();

            while (it.hasNext()) {
                List<String> list1 = it.next();

                int priority = Integer.parseInt(list1.get(1));

                if (priority > maxP) {
                    maxP = priority;
                    maxLength = qRes.getMatchLength();
                    chosenResource = list1.get(0);
                    OntClass c = model.getOntClass(chosenResource);

                    if (c != null) {
                        chosenClass = c;
                    }
                } else if (priority == maxP) {
                    if (qRes.getMatchLength() > maxLength) {
                        maxLength = qRes.getMatchLength();
                        chosenResource = list1.get(0);
                        OntClass c = model.getOntClass(chosenResource);
                        if (c != null) {
                            chosenClass = c;
                        }
                    }
                } else if (chosenResource != null) {
                    if (chosenClass != null) {
                        OntClass subClass = model.getOntClass(list1.get(0));
                        if (subClass != null && chosenClass.hasSubClass(subClass)) {
                            maxLength = qRes.getMatchLength();
                            chosenResource = list1.get(0);
                            maxP = priority + 10;
                        }
                    }
                }
            }
        }

        chosenResource = model.getResource(chosenResource).getLocalName();
        return chosenResource;
    }

    /**
     * Returns the value of a property for a given resource.
     * @param rId
     * @param property
     * @return 
     */
    public String getPropertyValue(String rId, Property property) {
        Statement stmt = model.getOntResource(Vocabulary.uri + rId).getProperty(property);
        String value = "";

        if (stmt != null) {
            value = stmt.getString();
        }
        return value;
    }
    
    /**
     * Determines the next installation step according to the current step and the router model being installed.
     * @param router
     * @param currentStep
     * @return 
     */
    public Individual getNextStep(Individual router, Individual currentStep) {
        if (currentStep.hasProperty(vocabulary.pasoSiguienteOK)) {
            currentStep.addProperty(vocabulary.isPasoHecho, "true");
            return model.getIndividual(currentStep.getProperty(vocabulary.pasoSiguienteOK).getString());
        } else if (!currentStep.equals(vocabulary.PASO_VERIFICACION_FINAL)) {
            if (!vocabulary.PASO_CONECTAR_ROUTER.hasProperty(vocabulary.isPasoHecho)) {
                List<String> steps = searchStepsBeforePowerOn(router);
                return model.getIndividual(steps.get(0));
            } else {
                List<String> steps = searchStepsAfterPowerOn(router);
                return model.getIndividual(steps.get(0));
            }
        } else {
            return null;
        }
    }

    /**
     * Returns the list of installation steps that must be executed before turning on the router 
     * (they can be executed in any order).
     * @param router
     * @return 
     */
    public List<String> searchStepsBeforePowerOn(Individual router) {
        String isStepPending = "?pasoInstalacion rdf:instanceOf <" + vocabulary.pasoInstalacion.getURI() + "> . "
                + "NOT EXISTS { ?pasoInstalacion RouterInstall:isPasoHecho ?hecho }. ";

        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + " SELECT ?pasoInstalacion  "
                + " WHERE {"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:hasMicrofiltroRouter ?microfiltro ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_M_LOCALIZAR_ADSL + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:hasComponent <" + vocabulary.tarjetaInalambricaI + "> ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_CONECTAR_TARJETA_INALAMBRICA + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:hasComponent <" + vocabulary.modemUSBI + "> ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_CONECTAR_MODEM_USB + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:hasCD <" + vocabulary.cdI + "> ."
                + "<" + router.getURI() + "> RouterInstall:isOfProveedor <" + vocabulary.ORANGE + "> ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_INSTALAR_CD + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_CONECTAR_ROUTER + ">))}"
                + "}";

        List<String> steps = querySPARQL(queryString, "?pasoInstalacion");
        return steps;

    }

    /**
     * Returns the list of installation steps that must be executed in order after turning on the router.
     * @param router
     * @return 
     */
    private List<String> searchStepsAfterPowerOn(Individual router) {
        String isStepPending = "?pasoInstalacion rdf:instanceOf <" + vocabulary.pasoInstalacion.getURI() + "> . "
                + "NOT EXISTS { ?pasoInstalacion RouterInstall:isPasoHecho ?hecho }. ";

        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + " SELECT ?pasoInstalacion  "
                + " WHERE {"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:hasCD <" + vocabulary.cdI + "> ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_INSTALAR_CD + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:isOfTipo <" + vocabulary.MONOPUERTO + "> ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_CONECTAR_PC_RJ45 + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "<" + router.getURI() + "> RouterInstall:isOfTipo <" + vocabulary.USB + "> ."
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_CONECTAR_PC_USB + ">))}"
                + "OPTIONAL{"
                + isStepPending
                + "FILTER(sameTerm(?pasoInstalacion, <" + vocabulary.PASO_VERIFICACION_FINAL + ">))}"
                + "}";

        List<String> steps = querySPARQL(queryString, "?pasoInstalacion");
        return steps;

    }

    /**
     * Tries to find a set of routers that match the query results.
     * @param queryResults
     * @return 
     */
    public List<String> tryToGetRouters(List<MatchingResult> queryResults) {
        List<String> routerIndividuals = new ArrayList<String>();
        Individual newRouter = null;
        Iterator<MatchingResult> it = queryResults.iterator();

        boolean filterByProvider = false;
        boolean filterByType = false;

        while (it.hasNext()) {
            MatchingResult queryResult = it.next();
            Iterator<List<String>> it2 = queryResult.getResults().iterator();

            while (it2.hasNext()) {
                List<String> list1 = it2.next();
                String resourceName = list1.get(0);
                OntClass ontClass = getClassOfIndividual(resourceName);

                if (ontClass != null) {
                    
                    //Add a specific router model
                    if (ontClass.equals(vocabulary.router)) {
                        routerIndividuals.add(model.getIndividual(resourceName).getURI());
                    
                     //Filter by router type
                    } else if (ontClass.equals(vocabulary.tipoRouter)) {
                        filterByType = true;
                        if (newRouter == null) {
                            newRouter = createRouter("newRouter");
                        }
                        newRouter.addProperty(vocabulary.isOfTipo, model.getIndividual(resourceName));

                    //Filter by router provider
                    } else if (ontClass.equals(vocabulary.proveedor)) {
                        filterByProvider = true;
                        if (newRouter == null) {
                            newRouter = createRouter("newRouter");
                        }
                        newRouter.addProperty(vocabulary.isOfProveedor, model.getIndividual(resourceName));
                    }
                } else {
                    //Comprobar componentes
                  /*  ontClass = getClass(resourceName);

                    if (ontClass != null) {
                    OntClass parent = ontClass.getSuperClass();
                    if (vocabulary.componente.equals(parent) || vocabulary.componente.equals(parent.getSuperClass())) {
                    newRouter.addProperty(vocabulary.hasComponent, ontClass);

                    } else if (vocabulary.puerto.equals(parent) || vocabulary.puerto.equals(parent.getSuperClass())) {
                    newRouter.addProperty(vocabulary.hasPort, ontClass);
                    }
                    }*/
                }
            }
        }

        List<String> availableRouters = getAllRouters();
        
        //Filter by provider
        if (filterByProvider) {
            availableRouters.retainAll(filterByProvider(newRouter));
        }

        //Filter by type
        if (filterByType) {
            availableRouters.retainAll(filterByType(newRouter));
        }

        //Filter by specific router models
        if (!routerIndividuals.isEmpty()) {
            availableRouters.retainAll(routerIndividuals);
        }

        return availableRouters;
    }


    private List<String> filterByProvider(Individual newRouter) {

        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + " SELECT ?routerName  "
                + " WHERE {"
                + " ?routerName rdf:instanceOf <" + vocabulary.router.getURI() + "> . "
                + "FILTER(!sameTerm(?routerName, <" + newRouter.getURI() + ">)) ."
                + "?routerName RouterInstall:isOfProveedor ?proveedor ."
                + "<" + newRouter.getURI() + "> RouterInstall:isOfProveedor ?proveedor"
                + "}";

        List<String> matchingRouters = querySPARQL(queryString, "?routerName");
        return matchingRouters;

    }

    private List<String> filterByType(Individual newRouter) {

        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + " SELECT ?routerName  "
                + " WHERE {"
                + " ?routerName rdf:instanceOf <" + vocabulary.router.getURI() + "> . "
                + "FILTER(!sameTerm(?routerName, <" + newRouter.getURI() + ">)) ."
                + "?routerName RouterInstall:isOfTipo ?tipo ."
                + "<" + newRouter.getURI() + "> RouterInstall:isOfTipo ?tipo"
                + "}";

        List<String> matchingRouters = querySPARQL(queryString, "?routerName");

        return matchingRouters;

    }

    /**
     * Looks for installation steps whose description matches the search query.
     * @param searchString
     * @return 
     */
    public Individual searchInstallSteps(String searchString) {
        List<MatchingResult> queryResults = new ArrayList<MatchingResult>();

        searchString = StringUtils.prepareSearchString(searchString);
        MatchingResult res = searchStepsByLabel(searchString);

        if (!res.getResults().isEmpty()) {
            queryResults.add(res);

        } else {
            //<aqm des="solo si la cadena tiene " ", sino se repetira la busqueda"/>
            
            //If no results were found, split the string and repeat the search for 
            //each substring
            String[] splittedString = searchString.split(" ");

            if (splittedString.length > 1) {
                for (int i = 0; i < splittedString.length; i++) {
                    String s = splittedString[i];
                    res = searchStepsByLabel(s);
                    if (!res.getResults().isEmpty()) {
                        queryResults.add(res);
                    }
                }
            }
        }
        String chosenStep = getResourceWithMaxPriority(queryResults);

        return model.getIndividual(Vocabulary.uri + chosenStep);
    }

    private MatchingResult searchStepsByLabel(String searchString) {
        String queryString = "PREFIX RouterInstall:<" + defaultNameSpace + ">"
                + "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX fn: <http://www.w3.org/2005/xpath-functions#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + " SELECT ?step ?priority"
                + " WHERE {"
                + "   ?step rdf:instanceOf <" + vocabulary.pasoInstalacion + ">  ."
                + "   ?step RouterInstall:hasStepPriority ?priority ."
                + "   ?step rdfs:label ?label ."
                + "FILTER (regex(fn:lower-case(?label), \"" + searchString + "\")) "
                + "}";

        List<String> params = new ArrayList<String>();
        params.add("?step");
        params.add("?priority");

        List<List<String>> list = querySPARQL(queryString, params);
        return new MatchingResult(list, searchString.length());
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

    Vocabulary getVocabulary() {
        return this.vocabulary;
    }
}
