/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine;

import java.util.List;

/**
 *
 * @author Itziar
 */
public class QueryResult {
    private final String stepID;
    private final List<String> routerList;

    public QueryResult(String stepID, List<String> routerList) {
        this.stepID = stepID;
        this.routerList = routerList;
    }

    public List<String> getRouterList() {
        return routerList;
    }

    public String getStepID() {
        return stepID;
    }

    

}
