/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.datatypes.*;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;

/**
 *
 * @author Itziar
 */
public class Vocabulary {

    protected static final String uri ="http://www.owl-ontologies.com/Ontology1325175471.owl#";
    protected static final String uriRDFDatatype ="http://www.w3.org/2001/XMLSchema#";

    /** returns the URI for this schema
     * @return the URI for this schema
     */
    public static String getURI() {
          return uri;
    }

    /** Resources */
    public final Resource router;
    public final Resource antena;
    public final Resource puertoUSB;

    /** Properties */
   public final Property hasComponent;
   public final Property isOfTipo;
   public final Property isOfModel;
   public final Property isOfProveedor;

   /** Individuals */
   public final Individual INALAMBRICO;
   public final Individual USB;
   public final Individual MONOPUERTO;
   
   public final Individual MOVISTAR;
   public final Individual ORANGE;
   public final Individual VODAFONE;

   public final Individual CT_351;
   public final Individual CT_5071;
   public final Individual x7028r;
   public final Individual TG585v7;
   public final Individual fast2604;





  

   public Vocabulary(OntModel model) {
       router = model.getResource(uri+"Router");
       antena = model.getResource(uri+"Antena");
       puertoUSB = model.getResource(uri+"PuertoUSB");


       hasComponent = model.getProperty(uri+"hasComponent");
       isOfTipo = model.getProperty(uri+"isOfTipo");
       isOfModel = model.getProperty(uri+"isOfModel");
       isOfProveedor = model.getProperty(uri+"isOfProveedor");

       INALAMBRICO = model.getIndividual(uri+"Inalámbrico");
       USB = model.getIndividual(uri+"USB");
       MONOPUERTO = model.getIndividual(uri+"Monopuerto");
       
       MOVISTAR = model.getIndividual(uri+"Movistar");
       ORANGE = model.getIndividual(uri+"Orange");
       VODAFONE = model.getIndividual(uri+"Vodafone");


       CT_351 = model.getIndividual(uri+"CT-351");
       CT_5071 = model.getIndividual(uri+"CT-5071");
       x7028r = model.getIndividual(uri+"x7028r");
       TG585v7 = model.getIndividual(uri+"ThompsonTG585v7");
       fast2604 = model.getIndividual(uri+"SagemFast2604");

       initModels();


   }

   private void initModels() {
       CT_351.addProperty(isOfProveedor, ORANGE);
       CT_5071.addProperty(isOfProveedor, ORANGE);
       x7028r.addProperty(isOfProveedor, ORANGE);
       TG585v7.addProperty(isOfProveedor, MOVISTAR);
       fast2604.addProperty(isOfProveedor, MOVISTAR);
   }

 
    /** RDFDataTypes */
    public static RDFDatatype getRDFDatatype(String type) {
          return new BaseDatatype(uriRDFDatatype + type);
    }

    public static String getUri() {
        return uri;
    }

}
