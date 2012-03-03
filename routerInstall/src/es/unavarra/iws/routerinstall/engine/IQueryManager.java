package es.unavarra.iws.routerinstall.engine;

import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Itziar
 */
public interface IQueryManager {
    
    String executeQueryBasicConcepts(String searchString);

    String getComment(String id);
    String getSeeAlso(String id);
    String getManualURL(String id);
    String getGuideURL(String id);
    String getVideoURL(String id);
    String getImage(String id);
    String getLogo(String id);
    String getTitle(String id);


    List<String> getAvailableRouters();
     List<InstallationError> getFrequentErrors();

    String initInstallationByModelName(String routerModel);
    QueryResult initInstallationByCharacteristics(String searchString);

    String getNextStepOK();
    InstallationError getError();
    String getPrevStep();
    String getCurrentStepDescription();
    String getCurrentStepName();
    String getCurrentStepTitle();
    

    boolean isFirstStep();
    boolean isLastStep();





}
