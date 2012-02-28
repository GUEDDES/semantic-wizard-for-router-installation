/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unavarra.iws.routerinstall.engine.utils;

import java.util.List;

/**
 *
 * @author Itziar
 */
public class QueryResult {
    private List<List<String>> results;
    private int matchLength;

    public QueryResult(List<List<String>> results, int matchLength) {
        this.results = results;
        this.matchLength = matchLength;
    }

    public int getMatchLength() {
        return matchLength;
    }

    public void setMatchLength(int matchLength) {
        this.matchLength = matchLength;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
    }
}
