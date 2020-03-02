package uniandes.constants;

import java.util.regex.Pattern;

public final class Expressions {

    public static final String PATTERN_TEXT = "([(),!?:;'\\\"-]|\\s)+";
    ////s = value.toString().split("([().,!?:;'\"-]|\\s)+");
    public static final String EXCLUDE_CHARACTERS = "([()<>,&!?:;'\\\"-]|\\s)+";
    public static final  Pattern REGEX_TITLE = Pattern.compile("<TITLE>(.*?)</TITLE>", Pattern.DOTALL);
    public static final  String INIT_TITLE = "<TITLE>";
    public static final  String END_TITLE = "</TITLE>";
    public static final  Pattern REGEX_BODY = Pattern.compile("<BODY>(.*?)</BODY>", Pattern.DOTALL);
    public static final  String INIT_BODY = "<BODY>";
    public static final  String END_BODY = "</BODY>";
}
