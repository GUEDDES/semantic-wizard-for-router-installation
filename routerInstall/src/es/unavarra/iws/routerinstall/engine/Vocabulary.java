/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.datatypes.BaseDatatype;
import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Property;

/**
 * Includes the vocabulary supported by the OWL model.
 *
 * @author Itziar
 */
public class Vocabulary {

    protected static final String uri = "http://www.owl-ontologies.com/Ontology1325175471.owl#";
    protected static final String uriRDFDatatype = "http://www.w3.org/2001/XMLSchema#";
    protected static final String uriRDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    protected static final String uriRDFS = "http://www.w3.org/2000/01/rdf-schema#";

    /**
     * Returns the URI for this schema.
     *
     * @return the URI for this schema
     */
    public static String getURI() {
        return uri;
    }
    /**
     * Classes
     */
    public final OntClass dSwitch;
    public final OntClass dHub;
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
    public final OntClass pasoInstalacion;
    public final OntClass problemaInstalacion;
   
    /**
     * Properties
     */
    public final Property hasComponent;
    public final Property hasMicrofiltro;
    public final Property hasPort;
    public final Property hasTarjetaDeRed;
    public final Property isOfProveedor;
    public final Property proveedorOfModelo;
    public final Property isOfTipo;
    public final Property tipoOfRouter;
    public final Property hasPriority;
    public final Property instanceOf;
    public final Property siguientePasoError;
    public final Property seeAlso;
    public final Property manualURL;
    public final Property videoURL;
    public final Property image;
    public final Property logo;
    public final Property title;
    public final Property guideURL;
    public final Property descrPaso;
    public final Property pasoSiguienteOK;
    public final Property isPasoHecho;
    public final Property hasCDInstalacion;
    public final Property hasStepPriority;
    public final Property problemDescr;
    public final Property problemSolution;
    public final Property isProblemOf;
    public final Property hasProblema;
    
    /**
     * Individuals
     */
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
    public final Individual PASO_M_LOCALIZAR_ADSL;
    public final Individual PASO_CONECTAR_ROUTER;
    public final Individual PASO_CONECTAR_TARJETA_INALAMBRICA;
    public final Individual PASO_CONECTAR_MODEM_USB;
    public final Individual PASO_CONECTAR_PC_USB;
    public final Individual PASO_VERIFICACION_FINAL;
    public final Individual PASO_CONECTAR_PC_RJ45;
    public final Individual PASO_INSTALAR_CD;
    public final Individual ERROR_LLAMADAS;
    public final Individual ERROR_ECO;
    public final Individual ERROR_ENCENDER;
    public final Individual ERROR_SOFTWARE;
    public final Individual ERROR_ETHERNET;
    public final Individual ERROR_USB;
    public final Individual ERROR_CONFIGURACION;
    public final Individual ERROR_TARJETA_INALAMBRICA;
    public final Individual ERROR_SIM;
    public final Individual ERROR_MODEMUSB;
    public final Individual tarjetaInalambricaI;
    public final Individual modemUSBI;
    public final Individual cdI;

    public Vocabulary(OntModel model) {

        /**
         * Classes
         */
        dHub = model.getOntClass(uri + "HUB");
        dSwitch = model.getOntClass(uri + "Switch");
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
        tarjetaDeRed = model.getOntClass(uri + "TarjetaDeRed");
        pasoInstalacion = model.getOntClass(uri + "PasoInstalacion");
        problemaInstalacion = model.getOntClass(uri + "Problemas");

        /**
         * Properties
         */
        hasComponent = model.getProperty(uri + "hasComponent");
        hasMicrofiltro = model.getProperty(uri + "hasMicrofiltroRouter");
        hasPort = model.getProperty(uri + "hasPort");
        hasTarjetaDeRed = model.getProperty(uri + "hasTarjetaDeRed");
        isOfProveedor = model.getProperty(uri + "isOfProveedor");
        proveedorOfModelo = model.getProperty(uri + "proveedorOfModelo");
        isOfTipo = model.getProperty(uri + "isOfTipo");
        tipoOfRouter = model.getProperty(uri + "tipoOfRouter");
        hasPriority = model.createProperty(uri + "hasPriority");
        hasStepPriority = model.createProperty(uri + "hasStepPriority");
        instanceOf = model.getProperty(uriRDF + "instanceOf");
        seeAlso = model.getProperty(uriRDFS + "seeAlso");
        siguientePasoError = model.createProperty(uri, "siguientePasoError");
        hasCDInstalacion = model.getProperty(uri + "hasCDInstalacion");
        manualURL = model.getProperty(uri + "manual");
        videoURL = model.getProperty(uri + "video");
        image = model.getProperty(uri + "imagen");
        guideURL = model.getProperty(uri + "guia");
        title = model.getProperty(uri + "title");
        logo = model.getProperty(uri + "logo");
        descrPaso = model.getProperty(uri + "DesPaso");
        pasoSiguienteOK = model.getProperty(uri + "pasoSiguiente");
        isPasoHecho = model.getProperty(uri + "isPasoHecho");
        problemDescr = model.getProperty(uri + "Problema");
        problemSolution = model.getProperty(uri + "SolucionProblema");
        isProblemOf = model.getProperty(uri + "isProblemaOf");
        hasProblema = model.getProperty(uri + "hasProblema");

        /**
         * Instances
         */
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

        //Set priorities
        dHub.addProperty(hasPriority, "3");
        dSwitch.addProperty(hasPriority, "3");
        router.addProperty(hasPriority, "1");
        microfiltro.addProperty(hasPriority, "5");
        ordenador.addProperty(hasPriority, "5");
        tarjetaDeRed.addProperty(hasPriority, "9");
        puerto.addProperty(hasPriority, "3");
        puertoADSL.addProperty(hasPriority, "7");
        puertoCorriente.addProperty(hasPriority, "7");
        puertoEthernet.addProperty(hasPriority, "7");
        puertoUSB.addProperty(hasPriority, "7");
        puertoWLAN.addProperty(hasPriority, "7");
        INALAMBRICO.addProperty(hasPriority, "8");
        USB.addProperty(hasPriority, "8");
        MONOPUERTO.addProperty(hasPriority, "3");
        MOVISTAR.addProperty(hasPriority, "9");
        ORANGE.addProperty(hasPriority, "9");
        VODAFONE.addProperty(hasPriority, "9");
        CT_351.addProperty(hasPriority, "10");
        CT_5071.addProperty(hasPriority, "10");
        x7028r.addProperty(hasPriority, "10");
        TG585v7.addProperty(hasPriority, "10");
        fast2604.addProperty(hasPriority, "10");
        HG556.addProperty(hasPriority, "10");
        
        tarjetaInalambricaI = model.getIndividual(uri + "TarjetaInalambrica_1");
        modemUSBI = model.getIndividual(uri + "ModemUSB_1");
        cdI = model.getIndividual(uri + "CDInstalacion_1");
        
        PASO_M_LOCALIZAR_ADSL = model.getIndividual(uri + "MicrofiltroLocalizarADSL");
        PASO_CONECTAR_ROUTER = model.getIndividual(uri + "EncenderRouter");
        PASO_CONECTAR_TARJETA_INALAMBRICA = model.getIndividual(uri + "CTarjetaInalambrica_1");
        PASO_CONECTAR_MODEM_USB = model.getIndividual(uri + "CModemUSBInsertarSIM_Modem");
        PASO_CONECTAR_PC_USB = model.getIndividual(uri + "ConectarRouterPC_USB_1");
        PASO_VERIFICACION_FINAL = model.getIndividual(uri + "VerificarTransmisionDatos_1");
        PASO_CONECTAR_PC_RJ45 = model.getIndividual(uri + "ConectarRouterPC_Ethernet_1");
        PASO_INSTALAR_CD = model.getIndividual(uri + "InstalacionSoftware_1");
       
        ERROR_LLAMADAS = model.getIndividual(uri + "RecepcioLLamadas");
        ERROR_ECO = model.getIndividual(uri + "Eco");
        ERROR_ETHERNET = model.getIndividual(uri + "ProblemasEthernet_1");
        ERROR_USB = model.getIndividual(uri + "ProblemasConectarRouterUSB_1");
        ERROR_ENCENDER = model.getIndividual(uri + "ProblemaEncendido");
        ERROR_SOFTWARE = model.getIndividual(uri + "ProblemaSoftware");
        ERROR_CONFIGURACION = model.getIndividual(uri + "ProblemasConfiguracionRouter_1");
        ERROR_TARJETA_INALAMBRICA = model.getIndividual(uri + "ProblemasTarjetaInalambrica");
        ERROR_SIM = model.getIndividual(uri+"ProblemaSIM");
        ERROR_MODEMUSB = model.getIndividual(uri+"ProblemaModemUSB");

        
        PASO_M_LOCALIZAR_ADSL.addProperty(instanceOf, pasoInstalacion);
        PASO_CONECTAR_ROUTER.addProperty(instanceOf, pasoInstalacion);
        PASO_CONECTAR_TARJETA_INALAMBRICA.addProperty(instanceOf, pasoInstalacion);
        PASO_CONECTAR_MODEM_USB.addProperty(instanceOf, pasoInstalacion);
        PASO_CONECTAR_PC_USB.addProperty(instanceOf, pasoInstalacion);
        PASO_VERIFICACION_FINAL.addProperty(instanceOf, pasoInstalacion);
        PASO_CONECTAR_PC_RJ45.addProperty(instanceOf, pasoInstalacion);
        PASO_INSTALAR_CD.addProperty(instanceOf, pasoInstalacion);
              
        ERROR_LLAMADAS.addProperty(instanceOf, problemaInstalacion);
        ERROR_ECO.addProperty(instanceOf, problemaInstalacion);
        ERROR_ETHERNET.addProperty(instanceOf, problemaInstalacion);
        ERROR_USB.addProperty(instanceOf, problemaInstalacion);
        ERROR_ENCENDER.addProperty(instanceOf, problemaInstalacion);
        ERROR_SOFTWARE.addProperty(instanceOf, problemaInstalacion);
        ERROR_CONFIGURACION.addProperty(instanceOf, problemaInstalacion);
        ERROR_TARJETA_INALAMBRICA.addProperty(instanceOf, problemaInstalacion);
        ERROR_SIM.addProperty(instanceOf, problemaInstalacion);
        ERROR_MODEMUSB.addProperty(instanceOf, problemaInstalacion);
       
        
        //Set step priorities
        PASO_M_LOCALIZAR_ADSL.addProperty(hasStepPriority, "6");
        PASO_CONECTAR_ROUTER.addProperty(hasStepPriority, "5");
        PASO_CONECTAR_TARJETA_INALAMBRICA.addProperty(hasStepPriority, "5");
        PASO_CONECTAR_MODEM_USB.addProperty(hasStepPriority, "5");
        PASO_CONECTAR_PC_USB.addProperty(hasStepPriority, "5");
        PASO_VERIFICACION_FINAL.addProperty(hasStepPriority, "5");
        PASO_CONECTAR_PC_RJ45.addProperty(hasStepPriority, "5");
        PASO_INSTALAR_CD.addProperty(hasStepPriority, "4");
    }

    /**
     * RDFDataTypes
     */
    public static RDFDatatype getRDFDatatype(String type) {
        return new BaseDatatype(uriRDFDatatype + type);
    }

    public static String getUri() {
        return uri;
    }
}
