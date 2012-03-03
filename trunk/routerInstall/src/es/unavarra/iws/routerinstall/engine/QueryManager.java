    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Statement;
import es.unavarra.iws.routerinstall.engine.utils.MatchingResult;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Implements IQueryManager.
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
        //Start the engine
        engine.init();
        
        //Get the individual corresponding to the router
        router = engine.getModel().getIndividual(Vocabulary.uri + routerModel);
        
        //Initialize the list of previous steps
        prevSteps = new ArrayList<Individual>();

        //Create the first installation step
        String firstStepName = Vocabulary.uri + routerModel + "_START";
        currentStep = engine.getModel().getIndividual(firstStepName);
        if (currentStep == null) {
            currentStep = engine.getModel().createIndividual(firstStepName, engine.getVocabulary().pasoInstalacion);
        }
        
        return currentStep.getLocalName().toUpperCase();
    }

    public String getNextStepOK() {
        
        //Mark the step as done
        currentStep.addProperty(engine.getVocabulary().isPasoHecho, "true");
        
        prevSteps.add(currentStep);
        
        //Look for the next step
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
    }

    public String getPrevStep() {
        if (!isFirstStep()) {
            //Go back to the previous step
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
        if (currentStep != null && router != null) {
        return (router.getLocalName() + "_" + currentStep.getLocalName()).toUpperCase();
        } else {
            return "";
        }
    }

    public String getCurrentStepTitle() {
        if (currentStep != null) {
            return getTitle(currentStep.getLocalName());
        } else {
            return "";
        }
    }

    public QueryResult initInstallationByCharacteristics(String searchString) {
        //Start the engine
        engine.init();
        
        QueryResult qr = new QueryResult(null, null);
        
        //Try to get a list of routers whose characteristics match the search string.
        List<MatchingResult> queryResults = engine.fullSearchByLabel(searchString);
        List<String> routers = engine.tryToGetRouters(queryResults);
        
        //If a set of routers has not been found, search an installation step
        //that matches the query
        if (routers.size() == engine.searchAvailableRouters().size()) {
            currentStep = engine.searchInstallSteps(searchString);
            if (currentStep != null) {
                String stepID = ("_" + currentStep.getLocalName()).toUpperCase();
                qr = new QueryResult(stepID, null);
            }
        //Otherwise, return the list of matching routers.
        } else {
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

    public String getLogo(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().logo);
    }

    public String getTitle(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().title);
    }

    public String getGuideURL(String id) {
        return engine.getPropertyValue(id, engine.getVocabulary().guideURL);
    }
        
}
