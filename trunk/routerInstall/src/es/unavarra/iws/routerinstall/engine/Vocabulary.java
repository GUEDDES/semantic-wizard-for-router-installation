/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.datatypes.*;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import java.util.Collection;
import java.util.HashSet;


/**
 *
 * @author Itziar
 */
public class Vocabulary {

    protected static final String uri = "http://www.owl-ontologies.com/Ontology1325175471.owl#";
    protected static final String uriRDFDatatype = "http://www.w3.org/2001/XMLSchema#";
    protected static final String uriRDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final Collection<Individual> proveedores = new HashSet<Individual>();

    /** returns the URI for this schema
     * @return the URI for this schema
     */
    public static String getURI() {
        return uri;
    }
    /** Resources */
    public final OntClass router;
    public final OntClass antena;
    public final OntClass puertoUSB;
    public final OntClass proveedor;
    public final OntClass tipoRouter;
    public final OntClass modeloRouter;
    
    /** Properties */
    public final Property hasComponent;
    public final Property isOfTipo;
    public final Property isOfModel;
    public final Property isOfProveedor;
    public final Property hasBasePage;
    public final Property hasPriority;

    public final Property instanceOf;
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
    public final Individual HG556;

    public Vocabulary(OntModel model) {
        router = model.getOntClass(uri + "Router");
        antena = model.getOntClass(uri + "Antena");
        puertoUSB = model.getOntClass(uri + "PuertoUSB");
        proveedor = model.getOntClass(uri + "Proveedor");
        tipoRouter = model.getOntClass(uri+ "TipoRouter");
        modeloRouter = model.getOntClass(uri+"modelo");

        hasComponent = model.getProperty(uri + "hasComponent");
        isOfTipo = model.getProperty(uri + "isOfTipo");
        isOfModel = model.getProperty(uri + "isOfModel");
        isOfProveedor = model.getProperty(uri + "isOfProveedor");

        instanceOf = model.getProperty(uriRDF+"instanceOf");

        INALAMBRICO = model.getIndividual(uri + "Inalámbrico");
        USB = model.getIndividual(uri + "USB");
        MONOPUERTO = model.getIndividual(uri + "Monopuerto");

        MOVISTAR = model.getIndividual(uri + "Movistar");
        ORANGE = model.getIndividual(uri + "Orange");
        VODAFONE = model.getIndividual(uri + "Vodafone");


        CT_351 = model.getIndividual(uri + "CT-351");
        CT_5071 = model.getIndividual(uri + "CT-5071");
        x7028r = model.getIndividual(uri + "x7028r");
        TG585v7 = model.getIndividual(uri + "ThompsonTG585v7");
        fast2604 = model.getIndividual(uri + "SagemFast2604");
        HG556 = model.getIndividual(uri+"HG556");

        //Otras propiedades
        MOVISTAR.addProperty(instanceOf, proveedor);
        ORANGE.addProperty(instanceOf, proveedor);
        VODAFONE.addProperty(instanceOf, proveedor);


       
        

        //Añadir propiedades
        hasBasePage = model.createProperty(uri + "hasBasePage");
        hasPriority = model.createProperty(uri + "hasPriority");



        //Añadir páginas y valores a todo
        router.addProperty(hasBasePage, "paginaDeRoutersCacosa");
        INALAMBRICO.addProperty(hasBasePage, "wiiifii");

        router.addProperty(hasPriority, "5");
        INALAMBRICO.addProperty(hasPriority, "100");

        proveedores.add(MOVISTAR);
        proveedores.add(ORANGE);
        proveedores.add(VODAFONE);
    }

    /** RDFDataTypes */
    public static RDFDatatype getRDFDatatype(String type) {
        return new BaseDatatype(uriRDFDatatype + type);
    }

    public static String getUri() {
        return uri;
    }
}
