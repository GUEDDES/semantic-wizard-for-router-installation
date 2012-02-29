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

/**
 *
 * @author Itziar
 */
public class Vocabulary {

    protected static final String uri = "http://www.owl-ontologies.com/Ontology1325175471.owl#";
    protected static final String uriRDFDatatype = "http://www.w3.org/2001/XMLSchema#";
    protected static final String uriRDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    protected static final String uriRDFS = "http://www.w3.org/2000/01/rdf-schema#";
   
    /** returns the URI for this schema
     * @return the URI for this schema
     */
    public static String getURI() {
        return uri;
    }
    /** Classes */
    public final OntClass router;
    public final OntClass antena;
    public final OntClass proveedor;
    public final OntClass tipoRouter;
    public final OntClass cable;
    public final OntClass componente;
    public final OntClass boton;
    public final OntClass botonEncendido;
    public final OntClass botonReset;
    public final OntClass led;
    public final OntClass ledEncendido;
    public final OntClass ledEstadoConexion;
    public final OntClass ledEstadoLAN;
    public final OntClass ledEstadoSistema;
    public final OntClass ledWifi;
    public final OntClass microfiltro;
    public final OntClass ordenador;
    public final OntClass puerto;
    public final OntClass puertoADSL;
    public final OntClass puertoCorriente;
    public final OntClass puertoEthernet;
    public final OntClass puertoUSB;
    public final OntClass puertoWLAN;
    public final OntClass tarjetaDeRed;

    public final OntClass pasoConectarCorriente;

    /** Properties */
    public final Property hasComponent;
    public final Property isComponentOf;
    public final Property hasMicrofiltro;
    public final Property isOfCable;
    public final Property hasPort;
    public final Property isPortOf;
    public final Property hasTarjetaDeRed;
    public final Property isTarjetaDeRedOf;
    public final Property isOfProveedor;
    public final Property proveedorOfModelo;
    public final Property isOfTipo;
    public final Property tipoOfRouter;


    public final Property hasPriority;
    public final Property instanceOf;
    public final Property estaConectado;
    public final Property estaActivado;
    public final Property estaEncendido;
    public final Property siguientePasoOK;
    public final Property siguientePasoError;
    public final Property seeAlso;
    public final Property manualURL;
    public final Property videoURL;

    
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

        /**Classes*/
        router = model.getOntClass(uri + "Router");
        antena = model.getOntClass(uri + "Antena");
        proveedor = model.getOntClass(uri + "Proveedor");
        tipoRouter = model.getOntClass(uri + "TipoRouter");
        cable = model.getOntClass(uri + "Cable");
        componente = model.getOntClass(uri + "Componente");
        boton = model.getOntClass(uri + "Boton");
        botonEncendido = model.getOntClass(uri + "BotonEncendido");
        botonReset = model.getOntClass(uri + "BotonReset");
        led = model.getOntClass(uri + "Led");
        ledEncendido = model.getOntClass(uri + "LedEncendido");
        ledEstadoConexion = model.getOntClass(uri + "LedEstadoConexion");
        ledEstadoLAN = model.getOntClass(uri + "LedEstadoLAN");
        ledEstadoSistema = model.getOntClass(uri + "LedEstadoSistema");
        ledWifi = model.getOntClass(uri + "LedWifi");
        microfiltro = model.getOntClass(uri + "Microfiltro");
        ordenador = model.getOntClass(uri + "Ordenador");
        puerto = model.getOntClass(uri + "Puerto");
        puertoADSL = model.getOntClass(uri + "PuertoADSL");
        puertoCorriente = model.getOntClass(uri + "PuertoCorriente");
        puertoEthernet = model.getOntClass(uri + "PuertoEthernet");
        puertoUSB = model.getOntClass(uri + "PuertoUSB");
        puertoWLAN = model.getOntClass(uri + "PuertoWLAN");
        tarjetaDeRed = model.getOntClass(uri+"TarjetaDeRed");

        pasoConectarCorriente = model.createClass(uri+"ConectarCorriente");


        /**Properties*/
       hasComponent = model.getProperty(uri + "hasComponent");
       isComponentOf = model.getProperty(uri+"isComponentOf");

       //TODO: inversed
        hasMicrofiltro = model.getProperty(uri+"hasMicrofiltro");
        isOfCable = model.getProperty(uri+"isOfCable");

        hasPort = model.getProperty(uri+"hasPort");
        isPortOf = model.getProperty(uri+"isPortOf");

        hasTarjetaDeRed = model.getProperty(uri+"hasTarjetaDeRed");
        isTarjetaDeRedOf = model.getProperty(uri+"isTarjetaDeRedOf");

        isOfProveedor = model.getProperty(uri + "isOfProveedor");
        proveedorOfModelo = model.getProperty(uri+"proveedorOfModelo");

        isOfTipo = model.getProperty(uri + "isOfTipo");
        tipoOfRouter = model.getProperty(uri+"tipoOfRouter");

        hasPriority = model.createProperty(uri + "hasPriority");
        instanceOf = model.getProperty(uriRDF + "instanceOf");
        seeAlso = model.getProperty(uriRDFS+"seeAlso");

        estaConectado = model.createProperty(uri+"estaConectado");
        estaActivado = model.createProperty(uri+"estaActivado");
        estaEncendido = model.createProperty(uri+"estaEncendido");
        siguientePasoOK = model.createProperty(uri, "siguientePasoOK");
        siguientePasoError = model.createProperty(uri, "siguientePasoError");

        manualURL = model.getProperty(uri+"manualURL");
        videoURL = model.getProperty(uri+"videoURL");

        /**Instances*/
        INALAMBRICO = model.getIndividual(uri + "Inalambrico");
        USB = model.getIndividual(uri + "USB");
        MONOPUERTO = model.getIndividual(uri + "Monopuerto");

        MOVISTAR = model.getIndividual(uri + "Movistar");
        ORANGE = model.getIndividual(uri + "Orange");
        VODAFONE = model.getIndividual(uri + "Vodafone");

        CT_351 = model.getIndividual(uri + "CT-351");
        CT_5071 = model.getIndividual(uri + "CT-5071");
        x7028r = model.getIndividual(uri + "x7028r");
        TG585v7 = model.getIndividual(uri + "TG585v7");
        fast2604 = model.getIndividual(uri + "SagemFast_2604");
        HG556 = model.getIndividual(uri + "HG556");

        //Establecer instancias
        INALAMBRICO.addProperty(instanceOf, tipoRouter);
        USB.addProperty(instanceOf, tipoRouter);
        MONOPUERTO.addProperty(instanceOf, tipoRouter);

        MOVISTAR.addProperty(instanceOf, proveedor);
        ORANGE.addProperty(instanceOf, proveedor);
        VODAFONE.addProperty(instanceOf, proveedor);

         CT_351.addProperty(instanceOf, router);
         CT_5071.addProperty(instanceOf, router);
        x7028r.addProperty(instanceOf, router);
        TG585v7.addProperty(instanceOf, router);
        fast2604.addProperty(instanceOf, router);
        HG556.addProperty(instanceOf, router);     
       
        //Añadir propiedades
      
         //Añadir prioridades
        router.addProperty(hasPriority, "1");
       
        microfiltro.addProperty(hasPriority, "5");
        ordenador.addProperty(hasPriority, "5");
        tarjetaDeRed.addProperty(hasPriority, "9");

        puertoADSL.addProperty(hasPriority, "8");
        puertoCorriente.addProperty(hasPriority, "8");
        puertoEthernet.addProperty(hasPriority, "8");
        puertoUSB.addProperty(hasPriority, "8");
        puertoWLAN.addProperty(hasPriority, "8");
       
        INALAMBRICO.addProperty(hasPriority, "5");
        USB.addProperty(hasPriority, "5");
        MONOPUERTO.addProperty(hasPriority, "5");

        MOVISTAR.addProperty(hasPriority, "9");
        ORANGE.addProperty(hasPriority, "9");
        VODAFONE.addProperty(hasPriority, "9");

        CT_351.addProperty(hasPriority, "10");
        CT_5071.addProperty(hasPriority, "10");
        x7028r.addProperty(hasPriority, "10");
        TG585v7.addProperty(hasPriority, "10");
        fast2604.addProperty(hasPriority, "10");
        HG556.addProperty(hasPriority, "10");
    }

    /** RDFDataTypes */
    public static RDFDatatype getRDFDatatype(String type) {
        return new BaseDatatype(uriRDFDatatype + type);
    }

    public static String getUri() {
        return uri;
    }
}