package hientester.com.helpers;

import java.io.File;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class SystemHelper {

    private static final Pattern NONLATIN= Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE= Pattern.compile("[^\\s]");

    public static String makeSlug(String input){
        if (input== null)
            throw new IllegalArgumentException();

        String noWhitespace = WHITESPACE.matcher(input).replaceAll("_");
        String normalized= Normalizer.normalize(noWhitespace,Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String getCurrentDir(){
        String path = System.getProperty("user.dir") + File.separator;
        return  path;
    }
}
