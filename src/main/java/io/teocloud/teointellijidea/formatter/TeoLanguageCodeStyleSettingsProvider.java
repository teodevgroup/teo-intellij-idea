package io.teocloud.teointellijidea.formatter;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.codeInsight.editorActions.smartEnter.PlainEnterProcessor;
import com.intellij.lang.Language;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.codeStyle.*;
import io.teocloud.teointellijidea.TeoLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeoLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @Override
    public @Nullable @NlsContexts.ConfigurableName String getConfigurableDisplayName() {
        return TeoLanguage.INSTANCE.getDisplayName();
    }

    @Override
    public @NotNull CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings baseSettings, @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(baseSettings, modelSettings, this.getConfigurableDisplayName()) {

            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new TeoCodeStyleMainPanel(this.getCurrentSettings(), settings);
            }
        };
    }

    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings, CommonCodeStyleSettings.@NotNull IndentOptions indentOptions) {
        commonSettings.LINE_COMMENT_AT_FIRST_COLUMN = false;
        commonSettings.LINE_COMMENT_ADD_SPACE = true;
        commonSettings.LINE_COMMENT_ADD_SPACE_ON_REFORMAT = true;
        commonSettings.KEEP_LINE_BREAKS = false;
        commonSettings.KEEP_BLANK_LINES_IN_DECLARATIONS = 1;
        commonSettings.KEEP_BLANK_LINES_IN_CODE = 1;
        indentOptions.INDENT_SIZE = 2;
        indentOptions.CONTINUATION_INDENT_SIZE = 2;
        indentOptions.TAB_SIZE = 2;
    }

    @Override
    public @Nullable IndentOptionsEditor getIndentOptionsEditor() {
        return new IndentOptionsEditor();
    }

    @Override
    public @Nullable CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return super.createCustomSettings(settings);
    }

    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {

        return "connector {\n" +
                "    provider .mongo\n" +
                "    url ENV[\"MONGO_URL\"]\n" +
                "}\n" +
                "\n" +
                "config {\n" +
                "    bind (\"0.0.0.0\", 5100)\n" +
                "    jwtSecret ENV[\"JWT_SECRET\"]\n" +
                "}\n" +
                "\n" +
                "/// @name Auth Code\n" +
                "/// @description The auth code is used for authentication.\n" +
                "model AuthCode {\n" +
                "\n" +
                "@id @readonly @auto @map(\"_id\")\n" +
                "id: ObjectId\n" +
                "\n" +
                "@unique @onSet($isEmail)\n" +
                "email: String\n" +
                "\n" +
                "@internal @onSave($randomDigits(4))\n" +
                "code: String\n" +
                "\n" +
                "@readonly @onSave($when(.create, $now))\n" +
                "createdAt: DateTime\n" +
                "\n" +
                "@readonly @onSave($now)\n" +
                "updatedAt: DateTime\n" +
                "}";
    }

    @Override
    public @NotNull Language getLanguage() {
        return TeoLanguage.INSTANCE;
    }


}
