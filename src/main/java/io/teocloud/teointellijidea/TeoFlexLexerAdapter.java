package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexAdapter;
import org.jetbrains.annotations.NotNull;

public class TeoFlexLexerAdapter extends FlexAdapter {
    public TeoFlexLexerAdapter() {
        super(new TeoFlexLexer());
    }

}
