package br.cefetmg.projeto4.core;

public final class StringHelper {
    private StringHelper() {}
    
    public static String removePrefix(String str, String prefix) {
        if (str.startsWith(prefix)) {
            return str.substring(prefix.length());
        } else {
            return str;
        }
    }
}