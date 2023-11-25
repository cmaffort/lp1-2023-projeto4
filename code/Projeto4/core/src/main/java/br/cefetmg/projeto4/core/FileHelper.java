package br.cefetmg.projeto4.core;

public final class FileHelper {
    private FileHelper() {}

    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
    }
}