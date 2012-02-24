/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.engine.utils;

import es.unavarra.iws.routerinstall.engine.Engine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Itziar
 */
public class StringUtils {

    private static final Logger logger = Logger.getLogger(StringUtils.class);
    private static final String commonWordsFilePath = "/es/unavarra/iws/routerinstall/resources/commonWords.txt";
    private static Collection<String> commonWords = prepareCommonWords();

    private static Collection<String> prepareCommonWords() {
        final Collection<String> collection = new ArrayList<String>();
        try {
            InputStream in = Engine.class.getResourceAsStream(commonWordsFilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String commonWord;
            while ((commonWord = br.readLine()) != null) {
                collection.add(commonWord);
            }
        } catch (IOException ex) {
            logger.error(ex);
        }
        return collection;
    }

    private static String removeCommonWords(String searchString) {
        searchString = " " + searchString + " ";
        Iterator<String> it = commonWords.iterator();
        while (it.hasNext()) {
            String commonWord = it.next();
            searchString = searchString.replace(commonWord, " ");
        }

        searchString = searchString.trim();
        return searchString;

    }

    public static String prepareSearchString(String searchString) {
        searchString = searchString.trim();
        searchString = searchString.toLowerCase();
        searchString = searchString.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        searchString = searchString.replaceAll("( )+", " ");

        searchString = removeCommonWords(searchString);

        return searchString;
    }

}
