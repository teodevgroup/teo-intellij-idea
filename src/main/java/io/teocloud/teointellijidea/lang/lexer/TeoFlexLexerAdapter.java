package io.teocloud.teointellijidea.lang.lexer;

import com.intellij.lexer.FlexAdapter;
import io.teocloud.teointellijidea.TeoFlexLexer;
import org.jetbrains.annotations.NotNull;

public class TeoFlexLexerAdapter extends FlexAdapter {
    public TeoFlexLexerAdapter() {
        super(new TeoFlexLexer());
    }

}
