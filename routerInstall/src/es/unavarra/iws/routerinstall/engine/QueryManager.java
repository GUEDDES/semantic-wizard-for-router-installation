/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import es.unavarra.iws.routerinstall.engine.utils.QueryResult;
import java.util.ArrayList;
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
         List<QueryResult> queryResults = engine.fullSearchByLabel(searchString);
        String chosenResource = null;

        if (!queryResults.isEmpty()) {
            //Buscar la página asociada con el recurso encontrado de mayor prioridad
            chosenResource = engine.getResourceWithMaxPriority(queryResults);
        }
        return chosenResource;
    }
    
    public String getSeeAlso(String id) {
        Statement stmt = engine.getModel().getOntResource(Vocabulary.uri+id).getProperty(engine.getVocabulary().seeAlso);
       
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
        return engine.getModel().getOntResource(Vocabulary.uri+id).getComment(null);
    }

    public String initInstallationByModelName(String routerModel) {
        router = engine.getModel().getIndividual(Vocabulary.uri+routerModel);
        currentStep = engine.getFirstStep(router);
        prevSteps = new ArrayList<Individual>();
        return currentStep.getLocalName();
    }

    public String getNextStepOK() {
        prevSteps.add(currentStep);
        currentStep = engine.getNextStep(router, currentStep, true);
        return currentStep.getLocalName();       
    }

    public String getNextStepError() {
        prevSteps.add(currentStep);
        currentStep = engine.getNextStep(router, currentStep, false);
        return currentStep.getLocalName();
    }

    public String getPrevStep() {
        currentStep = prevSteps.remove(prevSteps.size()-1);
        return currentStep.getLocalName();     
    }

    public String initInstallationByCharacteristics(String searchString) {
        router = engine.searchCharacteristics(searchString);
        currentStep = engine.getFirstStep(router);
        prevSteps = new ArrayList<Individual>();
        return currentStep.getLocalName();
    }

    public List<String> getAvailableRouters() {
        return engine.searchAvailableRouters();
    }

    public static void main(String[] args) {
        QueryManager qm = new QueryManager();
        logger.info(qm.getAvailableRouters());
    }

}
