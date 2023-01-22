package io.teocloud.teointellijidea.ide.formatter;

import com.intellij.application.options.GenerationCodeStylePanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import io.teocloud.teointellijidea.lang.TeoLanguage;

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
