package main.java.com.wiar.utils;

import java.util.Collection;

public class StringUtils {

    public static String formatListSimple(Collection a) {
        return a.toString().
                replace("[", "").
                replace("]", "").
                replace(",", "");
    }
}
