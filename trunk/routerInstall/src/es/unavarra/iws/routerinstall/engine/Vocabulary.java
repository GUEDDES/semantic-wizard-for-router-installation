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
    public final OntClass modeloRouter;
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


    public final OntClass pasoInstalacion;

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
    public final Property isOfModel;
    public final Property modeloOfRouter;


    public final Property hasBasePage;
    public final Property hasPriority;
    public final Property instanceOf;
    public final Property estaConectado;
    public final Property estaActivado;
    public final Property estaEncendido;
    public final Property siguientePasoOK;
    public final Property siguientePasoError;
    public final Property pasoActual;

    
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

    public final Individual PASO_ENCENDIDO;
    public final Individual PASO_CONEXION_RED;
    public final Individual PASO_CONTACTE_PROVEEDOR;

    public Vocabulary(OntModel model) {

        /**Classes*/
        router = model.getOntClass(uri + "Router");
        antena = model.getOntClass(uri + "Antena");
        proveedor = model.getOntClass(uri + "Proveedor");
        tipoRouter = model.getOntClass(uri + "TipoRouter");
        modeloRouter = model.getOntClass(uri + "Modelo");
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

        pasoInstalacion = model.createClass(uri+"PasoInstalacion");


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

        isOfModel = model.getProperty(uri + "isOfModel");
        modeloOfRouter = model.getProperty(uri+"modeloOfRouter");

        hasBasePage = model.createProperty(uri + "hasBasePage");
        hasPriority = model.createProperty(uri + "hasPriority");
        instanceOf = model.getProperty(uriRDF + "instanceOf");

        estaConectado = model.createProperty(uri+"estaConectado");
        estaActivado = model.createProperty(uri+"estaActivado");
        estaEncendido = model.createProperty(uri+"estaEncendido");
        siguientePasoOK = model.createProperty(uri, "siguientePasoOK");
        siguientePasoError = model.createProperty(uri, "siguientePasoError");
        pasoActual = model.createProperty(uri,"pasoActual");

        /**Instances*/
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
        HG556 = model.getIndividual(uri + "HG556");

        //Establecer instancias
        INALAMBRICO.addProperty(instanceOf, tipoRouter);
        USB.addProperty(instanceOf, tipoRouter);
        MONOPUERTO.addProperty(instanceOf, tipoRouter);

        MOVISTAR.addProperty(instanceOf, proveedor);
        ORANGE.addProperty(instanceOf, proveedor);
        VODAFONE.addProperty(instanceOf, proveedor);

        CT_351.addProperty(instanceOf, modeloRouter);
        CT_5071.addProperty(instanceOf, modeloRouter);
        x7028r.addProperty(instanceOf, modeloRouter);
        TG585v7.addProperty(instanceOf, modeloRouter);
        fast2604.addProperty(instanceOf, modeloRouter);
        HG556.addProperty(instanceOf, modeloRouter);


        PASO_ENCENDIDO = model.createIndividual(uri+"pasoEncendido", pasoInstalacion);
        PASO_CONEXION_RED = model.createIndividual(uri+"pasoConexionRed", pasoInstalacion);
        PASO_CONTACTE_PROVEEDOR = model.createIndividual(uri+"pasoContacteProveedor", pasoInstalacion);

        PASO_ENCENDIDO.addProperty(siguientePasoOK, PASO_CONEXION_RED);
        PASO_ENCENDIDO.addProperty(siguientePasoOK, PASO_CONTACTE_PROVEEDOR);

        //Añadir propiedades
        router.addProperty(hasBasePage, "");
        antena.addProperty(hasBasePage, "");
        proveedor.addProperty(hasBasePage, "");
        tipoRouter.addProperty(hasBasePage, "");
        modeloRouter.addProperty(hasBasePage, "");
        cable.addProperty(hasBasePage, "");
        componente.addProperty(hasBasePage, "");
        boton.addProperty(hasBasePage, "");
        botonEncendido.addProperty(hasBasePage, "");
        botonReset.addProperty(hasBasePage, "");
        led.addProperty(hasBasePage, "");
        ledEncendido.addProperty(hasBasePage, "");
        ledEstadoConexion.addProperty(hasBasePage, "");
        ledEstadoLAN.addProperty(hasBasePage, "");
        ledEstadoSistema.addProperty(hasBasePage, "");
        ledWifi.addProperty(hasBasePage, "");
        microfiltro.addProperty(hasBasePage, "");
        ordenador.addProperty(hasBasePage, "");
        puerto.addProperty(hasBasePage, "");
        puertoADSL.addProperty(hasBasePage, "");
        puertoCorriente.addProperty(hasBasePage, "");
        puertoEthernet.addProperty(hasBasePage, "");
        puertoUSB.addProperty(hasBasePage, "");
        puertoWLAN.addProperty(hasBasePage, "");
        tarjetaDeRed.addProperty(hasBasePage, "");

        INALAMBRICO.addProperty(hasBasePage, "");
        USB.addProperty(hasBasePage, "");
        MONOPUERTO.addProperty(hasBasePage, "");

        MOVISTAR.addProperty(hasBasePage, "");
        ORANGE.addProperty(hasBasePage, "");
        VODAFONE.addProperty(hasBasePage, "");

        CT_351.addProperty(hasBasePage, "");
        CT_5071.addProperty(hasBasePage, "");
        x7028r.addProperty(hasBasePage, "");
        TG585v7.addProperty(hasBasePage, "");
        fast2604.addProperty(hasBasePage, "");
        HG556.addProperty(hasBasePage, "");

         //Añadir prioridades
        router.addProperty(hasPriority, "1");
        antena.addProperty(hasPriority, "1");
        proveedor.addProperty(hasPriority, "1");
        tipoRouter.addProperty(hasPriority, "1");
        modeloRouter.addProperty(hasPriority, "1");
        cable.addProperty(hasPriority, "1");
        componente.addProperty(hasPriority, "1");
        boton.addProperty(hasPriority, "1");
        botonEncendido.addProperty(hasPriority, "1");
        botonReset.addProperty(hasPriority, "1");
        led.addProperty(hasPriority, "1");
        ledEncendido.addProperty(hasPriority, "1");
        ledEstadoConexion.addProperty(hasPriority, "1");
        ledEstadoLAN.addProperty(hasPriority, "1");
        ledEstadoSistema.addProperty(hasPriority, "1");
        ledWifi.addProperty(hasPriority, "1");
        microfiltro.addProperty(hasPriority, "1");
        ordenador.addProperty(hasPriority, "1");
        puerto.addProperty(hasPriority, "1");
        puertoADSL.addProperty(hasPriority, "1");
        puertoCorriente.addProperty(hasPriority, "1");
        puertoEthernet.addProperty(hasPriority, "1");
        puertoUSB.addProperty(hasPriority, "1");
        puertoWLAN.addProperty(hasPriority, "1");
        tarjetaDeRed.addProperty(hasPriority, "1");

        INALAMBRICO.addProperty(hasPriority, "5");
        USB.addProperty(hasPriority, "5");
        MONOPUERTO.addProperty(hasPriority, "5");

        MOVISTAR.addProperty(hasPriority, "5");
        ORANGE.addProperty(hasPriority, "5");
        VODAFONE.addProperty(hasPriority, "5");

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
