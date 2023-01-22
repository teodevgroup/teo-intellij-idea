package io.teocloud.teointellijidea.ide.editor;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import io.teocloud.teointellijidea.lang.psi.TeoTokenSets;

public class TeoQuoteHandler extends SimpleTokenSetQuoteHandler {
    public TeoQuoteHandler() {
        super(TeoTokenSets.STRING_LITERAL);
    }
}
