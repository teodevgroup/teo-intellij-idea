package io.teocloud.teointellijidea.editor;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import io.teocloud.teointellijidea.psi.TeoTokenSets;

public class TeoQuoteHandler extends SimpleTokenSetQuoteHandler {
    public TeoQuoteHandler() {
        super(TeoTokenSets.STRING_LITERAL);
    }
}
