package io.teocloud.teointellijidea;

import com.intellij.lang.Language;

public class TeoLanguage extends Language {

    public static final TeoLanguage INSTANCE = new TeoLanguage();

    private TeoLanguage() {
        super("Teo");
    }
}
