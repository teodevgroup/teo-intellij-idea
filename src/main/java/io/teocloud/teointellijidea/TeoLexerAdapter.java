package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexAdapter;

public class TeoLexerAdapter extends FlexAdapter {

    public TeoLexerAdapter() {
        super(new TeoLexer(null));
    }

}
