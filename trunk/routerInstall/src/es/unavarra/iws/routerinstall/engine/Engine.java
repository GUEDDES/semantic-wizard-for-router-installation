/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.ontology.Individual;
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
import com.hp.hpl.jena.rdf.model.Statement;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author Itziar
 */
public class Engine {
    private static final Logger logger = Logger.getLogger(Engine.class);

    private static final String owlFilePath = "/es/unavarra/iws/routerinstall/owl/RouterInstall.owl";
    private static final String defaultNameSpace = "http://www.owl-ontologies.com/Ontology1325175471.owl#";


    private OntModel model;
    private Vocabulary vocabulary;

     
    public Engine() {}

    public void init() {
        InputStream in = Engine.class.getResourceAsStream(owlFilePath);

        //Create an empty model
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        //Read the RDF/XML file
        model.read(in, "");
        vocabulary = new Vocabulary(model);

        logger.info("Engine init");

    }
    
    public Individual createRouter(String id) {
         return model.createIndividual(Vocabulary.getURI() + id, vocabulary.router);

        
    }

   public void test() {
        Individual r = createRouter("prueba");
        r.addProperty(vocabulary.hasComponent, vocabulary.antena);
        r.addProperty(vocabulary.isOfModel, vocabulary.TG585v7);
        checkTipo(r);
        this.executeQueryBasicConcepts();


        if (r.hasProperty(vocabulary.isOfTipo)) {
            logger.info("Tiene propiedad: "+r.getProperty(vocabulary.isOfTipo));
        } else {
            logger.info("NO tiene propiedad");
        } 
    }

    public synchronized  List<String> querySPARQL(String queryString, String param) {
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

    public synchronized List<List<String>> querySPARQL(String queryString, String param1, String param2) {
        List<List<String>> list = new ArrayList<List<String>>();

        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet rs = qe.execSelect();
        while (rs.hasNext()) {
            QuerySolution binding = rs.nextSolution();
            List<String> inside = new ArrayList<String>();
            if (param1.isEmpty()) {
                inside.add("");
            } else {
                inside.add(binding.get(param1).toString());
            }
            if (param2.isEmpty()) {
                inside.add("");
            } else {
                inside.add(binding.get(param2).toString());
            }
            list.add(inside);
        }
        qe.close();

        return list;
    }

    public String prepareQuery(boolean subjectCheck, boolean objectCheck, String subject, String predicate, String object, String filter, String condition, String value) {
        String p = new String();
        if (predicate.equals("Vecino")) {
            p = "foaf:isVecinoOf";
        } else if (predicate.equals("Temperatura")) {
            p = "foaf:hasTemperatura";
        } else if (predicate.equals("Humedad")) {
            p = "foaf:hasHumedad";
        } else if (predicate.equals("Inclinacion")) {
            p = "foaf:hasInclinacion";
        } else if (predicate.equals("Tipo")) {
            p = "foaf:isOfTipo";
        }

        String f = new String();
        if (!filter.isEmpty() && !value.isEmpty()) {
            f = " FILTER (" + filter + " " + condition + " " + value + ") ";
        } else {
            f = "";
        }

        String subjectSelect = subject;
        String objectSelect = object;
        if (!subjectCheck) {
            subjectSelect = "";
        }
        if (!objectCheck) {
            objectSelect = "";
        }

        String queryString = "PREFIX foaf: <" + defaultNameSpace + ">"
            + " \nSELECT " + subjectSelect + " " + objectSelect
            + " \nWHERE { "
            + " \n\t " + subject + " " + p + " " + object
            + f
            + " \n}";

        return queryString;
    }


    public Resource getTipo(Individual router) {
        Resource tipo = null;
        if (router.hasProperty(vocabulary.hasComponent, vocabulary.antena)) {
            tipo = vocabulary.INALAMBRICO;
        } else if (router.hasProperty(vocabulary.hasComponent, vocabulary.puertoUSB)) {
            tipo = vocabulary.USB;
        } else {
            tipo = vocabulary.MONOPUERTO;  router.addProperty(vocabulary.isOfTipo, vocabulary.MONOPUERTO);
        }
         router.addProperty(vocabulary.isOfTipo, tipo);
         return tipo;
    }

      public Resource getProveedor(Individual router) {
           Resource proveedor = null;
           Statement modelo = router.getProperty(vocabulary.isOfModel);
           if (modelo != null) {
                proveedor = modelo.getProperty(vocabulary.isOfProveedor).getObject().asResource();
            }
            return proveedor;
        }

      public Resource getModelo(Individual router) {
          return router.getProperty(vocabulary.isOfModel).getObject().asResource();
      }

      public void setModelo(Individual router, Individual model) {
          router.addProperty(vocabulary.isOfModel, model);
          checkTipo(router);
      }

      private void checkTipo(Individual router) {
          Resource modelo = router.getPropertyResourceValue(vocabulary.isOfModel);
          
          if (modelo.equals(vocabulary.TG585v7) || modelo.equals(vocabulary.fast2604) || modelo.equals(vocabulary.x7028r)) {
              router.addProperty(vocabulary.isOfTipo, vocabulary.INALAMBRICO);
          } else if (modelo.equals(vocabulary.CT_5071)) {
              router.addProperty(vocabulary.isOfTipo, vocabulary.MONOPUERTO);
          } else if (modelo.equals(vocabulary.CT_351)) {
              router.addProperty(vocabulary.isOfTipo, vocabulary.USB);
          }
      }


 /*   public boolean isOfTipo() {
        String queryString = "PREFIX foaf:<" + defaultNameSpace + ">"
            + " SELECT ?r1 ?c1"
            + " WHERE {"
            + "     ?r1 foaf:isComponentOf ?c1 ."
            + "}";

        List<String> list = querySPARQL(queryString, "r1");
        return !list.isEmpty();
    }*/

    public String executeQueryBasicConcepts() {
        
         String queryString = "PREFIX foaf:<" + defaultNameSpace + ">" +
                 "PREFIX  rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                 "PREFIX owl:    <http://www.w3.org/2002/07/owl#>" +
                 "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
                 "PREFIX fn: <http://www.w3.org/2005/xpath-functions#>"
            + " SELECT ?resource ?label"
             + " WHERE {"
           + "   ?resource rdfs:label ?label "
           + "FILTER (regex(fn:lower-case(?label), \"wifi\"))"
            + "}";

        List<String> list = querySPARQL(queryString, "?resource");
        logger.info(list);
        logger.info(list.size());
        return list.get(0);

    }

    

    public synchronized void saveOntology(String file, String type) {
        try {
            model.write(new FileWriter(file), type);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public synchronized OntModel getModel(){
        return model;
    }

    public static void main(String[] args) {
        Engine e = new Engine();
        e.init();
        e.test();

    }
   

}
