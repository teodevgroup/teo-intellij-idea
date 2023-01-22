package io.teocloud.teointellijidea.ide.settings;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import io.teocloud.teointellijidea.ide.highlight.TeoSyntaxHighlighter;
import io.teocloud.teointellijidea.lang.TeoIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class TeoColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Bool literal", TeoSyntaxHighlighter.BOOL_LITERAL),
            new AttributesDescriptor("Numeric literal", TeoSyntaxHighlighter.NUMERIC_LITERAL),
            new AttributesDescriptor("String literal", TeoSyntaxHighlighter.STRING_LITERAL),
            new AttributesDescriptor("Comment", TeoSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad value", TeoSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return TeoIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new TeoSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// Teo model schema\n" +
                "model Cat {\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Teo";
    }

}
