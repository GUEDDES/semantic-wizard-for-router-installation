/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine;

/**
 * Includes the information related to an installation error.
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

    /**
     * Returns the error ID.
     * @return 
     */
    public String getErrorID() {
        return errorID;
    }
    
    /**
     * Returns the description of the problem.
     * @return 
     */
    public String getProblemDescription() {
        return problemDescription;
    }

    /**
     * Returns the description of the problem solution.
     * @return 
     */
    public String getProblemSolution() {
        return problemSolution;
    }

    /**
     * Returns the title associated to the error screen.
     * @return 
     */
    public String getTitle() {
        return title;
    }

    

}
