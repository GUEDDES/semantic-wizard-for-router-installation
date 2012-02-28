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
    String getVideoURL(String id);

    String initInstallationByModelName(String routerModel);
    String initInstallationByCharacteristics(String searchString);

    String getNextStepOK();
    String getNextStepError();
    String getPrevStep();

    List<String> getAvailableRouters();


}
