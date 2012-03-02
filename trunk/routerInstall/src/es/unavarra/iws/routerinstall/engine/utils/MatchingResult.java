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
public class MatchingResult {
    private List<List<String>> results;
    private int matchLength;

    public MatchingResult(List<List<String>> results, int matchLength) {
        this.results = results;
        this.matchLength = matchLength;
    }

    /**
     * Returns the length of matching characters.
     * @return
     */
    public int getMatchLength() {
        return matchLength;
    }

    public void setMatchLength(int matchLength) {
        this.matchLength = matchLength;
    }

    /**
     * Returns the list of results returned by the query.
     * @return
     */
    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
    }
}
