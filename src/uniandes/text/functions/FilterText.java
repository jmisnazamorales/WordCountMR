package uniandes.text.functions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import uniandes.constants.Expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tools to extract text clear from the text
 */
public final class FilterText {

    private static final Log log = LogFactory.getLog(FilterText.class);
    /**
     *
     * @param pattern
     *        Patter that i want filter
     * @param text
     *        Text
     * @param initString
     *        init tag
     * @param endString
     *        end tag
     * @return
     *        List word filtered by tag
     */
    public static List<String> getClearText(Pattern pattern, String text,
                                            int initString, int endString){
        List<String> words = new ArrayList();
        Matcher matcher = pattern.matcher(text);
        try {
            while (matcher.find()){
                int finalLetter = matcher.group().length() - endString;
                String [] splitWords = matcher.group().substring(initString, finalLetter)
                        .toLowerCase().split(Expressions.PATTERN_TEXT);
                Arrays.stream(splitWords).forEach(x -> words.add( x.toLowerCase()));
            }

        }catch (Exception e ){
            log.error("Cause : " + e.getMessage());
            System.out.println("Bad news ");
        }
        return words;
    }
}
