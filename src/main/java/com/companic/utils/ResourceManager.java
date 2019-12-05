package com.companic.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle localeBundle;
    private ResourceBundle configBundle;
    private final String localeResourceName = "locale";

    private ResourceManager() {
        Locale locale = new Locale("en");
        localeBundle = ResourceBundle.getBundle(localeResourceName, locale, new UTF8Control());
        configBundle = ResourceBundle.getBundle("config", locale);
    }

    public void changeLocale(Locale locale) {
        localeBundle = ResourceBundle.getBundle(localeResourceName, locale, new UTF8Control());
    }

    public String getString(String key) {
        return localeBundle.getString(key);
    }

    public String getParameter(String param) {
        return configBundle.getString(param);
    }
}