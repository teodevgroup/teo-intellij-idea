package io.teocloud.teointellijidea.formatter;

import com.intellij.application.options.GenerationCodeStylePanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import io.teocloud.teointellijidea.TeoLanguage;
import org.jetbrains.annotations.Nullable;

public class TeoCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
    protected TeoCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
        super(TeoLanguage.INSTANCE, currentSettings, settings);
    }

    @Override
    protected void initTabs(CodeStyleSettings settings) {
        addIndentOptionsTab(settings);
        addTab(new GenerationCodeStylePanel(settings, TeoLanguage.INSTANCE));
    }
}
