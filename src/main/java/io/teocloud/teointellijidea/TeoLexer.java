package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexAdapter;
import org.jetbrains.annotations.NotNull;

public class TeoLexer extends FlexAdapter {
    public TeoLexer() {
        super(new _TeoLexer());
    }

}
