package br.cefetmg.inf.sisloc.util;

import java.text.DateFormat;
import java.util.*;


public class MyDate {
    Date today;
    DateFormat dateFormatter;

    public MyDate() {
        this.today = new Date();
    }

    public String getDate() {
        if (this.dateFormatter == null)
            throw new RuntimeException("Necessário informar localização (setLocale).");
        
        return this.dateFormatter.format(today);
    }

    public void setLocale(Locale locale) {
        this.dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
    }
}
