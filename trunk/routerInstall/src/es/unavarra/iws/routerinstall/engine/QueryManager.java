    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Statement;
import es.unavarra.iws.routerinstall.engine.utils.MatchingResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Itziar
 */
public class QueryManager implements IQueryManager {

    private Engine engine;
    private Individual router;
    private Individual currentStep;
    private List<Individual> prevSteps;
    private static final Logger logger = Logger.getLogger(QueryManager.class);

    public QueryManager() {
        engine = new Engine();
        engine.init();

    }

    public String executeQueryBasicConcepts(String searchString) {
        List<MatchingResult> queryResults = engine.fullSearchByLabel(searchString);
        String chosenResource = null;

        if (!queryResults.isEmpty()) {
            //Buscar la página asociada con el recurso encontrado de mayor prioridad
            chosenResource = engine.getResourceWithMaxPriority(queryResults);
        }
        return chosenResource;
    }

    public String getSeeAlso(String id) {
        Statement stmt = engine.getModel().getOntResource(Vocabulary.uri + id).getProperty(engine.getVocabulary().seeAlso);

        if (stmt != null) {
            String seeAlso = stmt.getString();

            if (seeAlso.startsWith(Vocabulary.uri)) {
                return engine.getModel().getResource(seeAlso).getLocalName();
            } else {
                return seeAlso;
            }
        } else {
            return null;
        }
    }

    public String getComment(String id) {
        return engine.getModel().getOntResource(Vocabulary.uri + id).getComment(null);
    }

    public String initInstallationByModelName(String routerModel) {
        engine.init();
        router = engine.getModel().getIndividual(Vocabulary.uri + routerModel);

        String firstStepName = Vocabulary.uri + routerModel + "_START";
        currentStep = engine.getModel().getIndividual(firstStepName);
        if (currentStep == null) {
            currentStep = engine.getModel().createIndividual(firstStepName, engine.getVocabulary().pasoInstalacion);
        }
        prevSteps = new ArrayList<Individual>();
        return currentStep.getLocalName().toUpperCase();
    }

    public String getNextStepOK() {
        currentStep.addProperty(engine.getVocabulary().isPasoHecho, "true");

        prevSteps.add(currentStep);
        currentStep = engine.getNextStep(router, currentStep);
        if (currentStep != null) {
            return getCurrentStepName();
        } else {
            return (router.getLocalName() + "_FINISH").toUpperCase();
        }
    }

    public InstallationError getError() {
       if (currentStep != null) {
           Individual error = currentStep.getProperty(engine.getVocabulary().hasProblema).getObject().as(Individual.class);
           return engine.createInstallationError(error);
       } else {
           return null;
       }
     //   return engine.getModel().getIndividual(currentStep.getProperty(engine.getVocabulary().pasoSiguienteError).getString()).getLocalName();

    }

    public String getPrevStep() {
        if (!isFirstStep()) {
            currentStep = prevSteps.remove(prevSteps.size() - 1);
            currentStep.removeAll(engine.getVocabulary().isPasoHecho);
            return (router.getLocalName() + "_" + currentStep.getLocalName()).toUpperCase();
        } else {
            return (router.getLocalName() + "_START").toUpperCase();
        }
    }

    public boolean isFirstStep() {
        return prevSteps.isEmpty();
    }

    public boolean isLastStep() {
        return currentStep == null;
    }

    public String getCurrentStepDescription() {
        if (!isLastStep()) {
            return currentStep.getProperty(engine.getVocabulary().descrPaso).getString();
        } else {
            return "";
        }
    }

    public String getCurrentStepName() {
        return (router.getLocalName() + "_" + currentStep.getLocalName()).toUpperCase();
    }

    public String getCurrentStepTitle() {
        if (currentStep != null) {
            return getTitle(currentStep.getLocalName());
        } else {
            return "";
        }
    }

    public QueryResult initInstallationByCharacteristics(String searchString) {
        engine.init();
        QueryResult qr = new QueryResult(null, null);
        List<MatchingResult> queryResults = engine.fullSearchByLabel(searchString);
        List<String> routers = engine.tryToGetRouters(queryResults);
        if (routers.size() == engine.searchAvailableRouters().size()) {
            logger.info("look for steps");
            currentStep = engine.searchInstallSteps(searchString);
            if (currentStep != null) {
                String stepID = ("_" + currentStep.getLocalName()).toUpperCase();
                qr = new QueryResult(stepID, null);
            }
        } else {
            logger.info("look for routers " + routers);
            qr = new QueryResult(null, routers);
        }
        return qr;
    }

    public List<String> getAvailableRouters() {
        return engine.searchAvailableRouters();
    }

    public List<InstallationError> getFrequentErrors() {
        return engine.searchFrequentErrors();
    }

    public String getManualURL(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().manualURL);
    }

    public String getVideoURL(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().videoURL);
    }

    public String getImage(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().image);
    }

    ;

    public String getLogo(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().logo);
    }

    ;

    public String getTitle(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().title);
    }

    ;

    public String getGuideURL(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().guideURL);
    }

    public static void main(String[] args) {
        QueryManager qm = new QueryManager();
        String[] s = {"Router", "Switch", "HUB", 
        "CT-351", "CT-5071", "SagemFast_2604", "x7028r", "TG585v7", "HG556",
        "Inalambrico", "USB", "Monopuerto",
            "Movistar", "Orange", "Vodafone", "TarjetaDeRed", "TarjetaDeRed", "Microfiltro", "Ordenador",
            "PuertoADSL", "PuertoCorriente", "PuertoEthernet", "PuertoUSB", "PuertoWLAN"};

      /*  for (int i = 0; i < s.length; i++) {
            String test = s[i];
            logger.info("------ ID: "+test+"-----");
            logger.info("title: "+qm.getTitle(test));
            logger.info("comment: "+qm.getComment(test));
            logger.info("guide"+qm.getGuideURL(test));
            logger.info("img: "+qm.getImage(test));
            logger.info("logo: "+qm.getLogo(test));
            logger.info("manual: "+qm.getManualURL(test));
            logger.info("video: "+qm.getVideoURL(test));
            logger.info("seeAlso: "+qm.getSeeAlso(test));
        }
        * */
     

        String step = qm.initInstallationByModelName("x7028r");
      /*  while(!qm.isLastStep()) {
           
            step = qm.getNextStepOK();
             logger.info("-------------");
             logger.info(step);
            logger.info(qm.getCurrentStepDescription());
            logger.info(qm.getCurrentStepName());
            logger.info(qm.getCurrentStepTitle());

        }
        */

        QueryResult qr = qm.initInstallationByCharacteristics("sim");
        logger.info("list: "+qr.getRouterList());
        logger.info("step: "+qr.getStepID());
        logger.info(qm.getError().getTitle());

         
        
    }
    
}
