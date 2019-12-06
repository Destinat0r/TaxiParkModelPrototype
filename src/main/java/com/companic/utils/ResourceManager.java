package com.companic.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle localeBundle;
    private ResourceBundle configBundle;
    private final String localeResourceName = "locale";

    private ResourceManager() {
        localeBundle = ResourceBundle.getBundle(localeResourceName, new Locale("en"), new UTF8Control());
        configBundle = ResourceBundle.getBundle("config");
    }

    public void setLocale(Locale locale) {
        localeBundle = ResourceBundle.getBundle(localeResourceName, locale, new UTF8Control());
    }

    public String getLocaleProperty(String key) {
        return localeBundle.getString(key);
    }

    public String getConfigProperty(String param) {
        return configBundle.getString(param);
    }
}