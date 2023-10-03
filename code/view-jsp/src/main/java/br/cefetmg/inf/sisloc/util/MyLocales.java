package br.cefetmg.inf.sisloc.util;

import java.util.*;
import java.text.DateFormat;


public class MyLocales {
    ArrayList<String> localeNames;
    HashMap<String, Locale> locales;
    Locale selectedLocale;
    String selectedLocaleString;

    public MyLocales() {
        this.locales = new HashMap<>();
        this.localeNames = new ArrayList<>();

        Locale[] list = DateFormat.getAvailableLocales();

        for (Locale locale : list) {
            String localeName = locale.getDisplayName();
            this.locales.put(localeName, locale);
            this.localeNames.add(localeName);
        }
        
        Collections.sort(this.localeNames);
        this.selectedLocale = null;
        this.selectedLocaleString = null;
    }

    public static boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }

    public Collection getLocaleNames() {
        return this.localeNames;
    }

    public void setSelectedLocaleString(String displayName) {
        this.selectedLocaleString = displayName;
        this.selectedLocale = (Locale) this.locales.get(displayName);
    }

    public Locale getSelectedLocale() {
        return selectedLocale;
    }

    public String getSelectedLocaleString() {
        return selectedLocaleString;
    }
}
