package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class TeoLexer extends FlexAdapter {
    public TeoLexer() {
        super(new _TeoLexer());
    }

}
