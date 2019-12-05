package com.companic.locale_util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private final String resourceName = "messages";

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, new Locale("en"), new UTF8Control());
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale, new UTF8Control());
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}