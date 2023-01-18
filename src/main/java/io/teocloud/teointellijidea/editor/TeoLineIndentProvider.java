package io.teocloud.teointellijidea.editor;

import com.intellij.lang.Language;
import com.google.common.collect.ImmutableMap;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.source.codeStyle.SemanticEditorPosition;
import com.intellij.psi.impl.source.codeStyle.lineIndent.JavaLikeLangLineIndentProvider;
import com.intellij.psi.tree.IElementType;
import io.teocloud.teointellijidea.TeoLanguage;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeoLineIndentProvider extends JavaLikeLangLineIndentProvider {

    @Override
    public SemanticEditorPosition getPosition(@NotNull Editor editor, int offset) {
        SemanticEditorPosition pos = super.getPosition(editor, offset);
        System.out.println(pos);
        return pos;
    }

    private static final ImmutableMap<IElementType, SemanticEditorPosition.SyntaxElement> SYNTAX_MAP = ImmutableMap.<IElementType, SemanticEditorPosition.SyntaxElement>builder()
            .put(TokenType.WHITE_SPACE, JavaLikeElement.Whitespace)
            .put(TeoTypes.WHITESPACE, JavaLikeElement.Whitespace)
            .put(TeoTypes.NEWLINE, JavaLikeElement.Whitespace)
            .put(TeoTypes.BLOCK_OPEN, JavaLikeElement.BlockOpeningBrace)
            .put(TeoTypes.BLOCK_CLOSE, JavaLikeElement.BlockClosingBrace)
            .put(TeoTypes.BRACK_OPEN, JavaLikeElement.BlockOpeningBrace)
            .put(TeoTypes.BRACK_CLOSE, JavaLikeElement.BlockClosingBrace)
            .put(TeoTypes.COMMA, JavaLikeElement.Comma)
            .put(TeoTypes.DOC_COMMENT, JavaLikeElement.BlockComment)
            .put(TeoTypes.DOUBLE_LINE_COMMENT, JavaLikeElement.LineComment)
            .build();

    @Nullable @Override
    protected SemanticEditorPosition.@Nullable SyntaxElement mapType(@NotNull IElementType tokenType) {
        return SYNTAX_MAP.get(tokenType);
    }

    @Override
    public boolean isSuitableForLanguage(@NotNull Language language) {
        return language.isKindOf(TeoLanguage.INSTANCE);
    }
}
