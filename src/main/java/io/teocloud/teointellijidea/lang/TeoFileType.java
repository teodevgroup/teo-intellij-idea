package io.teocloud.teointellijidea.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TeoFileType extends LanguageFileType {

    public static final TeoFileType INSTANCE = new TeoFileType();

    private TeoFileType() {
        super(TeoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Teo File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Teo model schema file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "teo";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TeoIcons.FILE;
    }
}
