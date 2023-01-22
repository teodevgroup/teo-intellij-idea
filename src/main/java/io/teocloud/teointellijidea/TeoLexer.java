package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class TeoLexer extends FlexAdapter {
    public TeoLexer() {
        super(new _TeoLexer());
    }

    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        if (buffer.length() != 0) {
            super.start(buffer, 0, buffer.length(), 0);
        }
    }
}
