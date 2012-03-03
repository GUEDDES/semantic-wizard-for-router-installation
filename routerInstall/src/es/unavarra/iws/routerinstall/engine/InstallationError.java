/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine;

/**
 *
 * @author Itziar
 */
public class InstallationError {
    private final String errorID;
    private final String title;
    private final String problemDescription;
    private final String problemSolution;

    public InstallationError(String errorID, String title, String problemDescription, String problemSolution) {
        this.errorID = errorID;
        this.title = title;
        this.problemDescription = problemDescription;
        this.problemSolution = problemSolution;
    }

    public String getErrorID() {
        return errorID;
    }
    public String getProblemDescription() {
        return problemDescription;
    }

    public String getProblemSolution() {
        return problemSolution;
    }

    public String getTitle() {
        return title;
    }

    

}
