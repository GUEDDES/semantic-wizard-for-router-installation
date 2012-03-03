package es.unavarra.iws.routerinstall.engine;

import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface that handles queries to the OWL model.
 * @author Itziar
 */
public interface IQueryManager {
    
    /**
     * Looks for basic concepts matching the search string.
     * @param searchString
     * @return 
     */
    String executeQueryBasicConcepts(String searchString);

    /**
     * Returns the comment associated to a basic comment.
     * @param id
     * @return 
     */
    String getComment(String id);
    
    /**
     * Returns the URL related to the basic concept.
     * @param id
     * @return 
     */
    String getSeeAlso(String id);
    
    
    /**
     * Returns the image associated to a basic concept.
     * @param id
     * @return 
     */
    String getImage(String id);
    
    /**
     * Returns the logo associated to a basic concept.
     * @param id
     * @return 
     */
    String getLogo(String id);
    
    /**
     * Returns the title corresponding to the page of a basic concept.
     * @param id
     * @return 
     */
    String getTitle(String id);
    
     /**
     * Returns the manual URL associated to a specific router.
     * @param id
     * @return 
     */
    String getManualURL(String id);
    
    /**
     * Returns the fast guide URL associated to a specific router.
     * @param id
     * @return 
     */
    String getGuideURL(String id);
    
    /**
     * Returns the video URL associated to a specific router.
     * @param id
     * @return 
     */
    String getVideoURL(String id);

    /**
     * Returns the list of routers supported by the model.
     * @return 
     */
    List<String> getAvailableRouters();
    
    /**
     * Returns the list of frequent errors included in the model.
     * @return 
     */
     List<InstallationError> getFrequentErrors();

     /**
      * Returns the first installation step corresponding to a given router.
      * @param routerModel
      * @return 
      */
    String initInstallationByModelName(String routerModel);
        
    /**
     * Returns a QueryResult object that contains either the list of routers that match
     * the search string, or a general installation step according to the request
     * contained in the search string.
     * @param searchString
     * @return 
     */
    QueryResult initInstallationByCharacteristics(String searchString);

    /**
     * Determines the following installation step.
     * @return 
     */
    String getNextStepOK();
    
    /**
     * Returns the installation error corresponding to the current installation step.
     * @return 
     */
    InstallationError getError();
    
    /**
     * Returns the previous installation step executed during the running installation step.
     * @return 
     */
    String getPrevStep();
    
    /**
     * Returns the description of the current installation step.
     * @return 
     */
    String getCurrentStepDescription();
    
    /**
     * Returns the name of the current installation step.
     * @return 
     */
    String getCurrentStepName();
    
    /**
     * Returns the title of the current installation step.
     * @return 
     */
    String getCurrentStepTitle();

    /**
     * States whether the current step is the first step of the running installation process.
     * @return 
     */
    boolean isFirstStep();
    
    /**
     * States whether the current step is the last step of the running installation process.
     * @return 
     */
    boolean isLastStep();





}
