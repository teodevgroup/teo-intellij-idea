package io.teocloud.teointellijidea;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TeoSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD = createTextAttributesKey("TEO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey MODEL_NAME = createTextAttributesKey("TEO_MODEL_NAME", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey BOOL_LITERAL =
            createTextAttributesKey("TEO_BOOL_LITERAL", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey STRING_LITERAL =
            createTextAttributesKey("TEO_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER_LITERAL =
            createTextAttributesKey("TEO_NUMBER_LITERAL", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("TEO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("TEO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] BOOL_KEYS = new TextAttributesKey[]{BOOL_LITERAL};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER_LITERAL};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING_LITERAL};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] MODEL_NAME_KEYS = new TextAttributesKey[]{MODEL_NAME};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new TeoLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(TeoTypes.ENUM_KEYWORD) ||
                tokenType.equals(TeoTypes.MODEL_KEYWORD) ||
                tokenType.equals(TeoTypes.IMPORT_KEYWORD) ||
                tokenType.equals(TeoTypes.CONFIG_KEYWORDS) ||
                tokenType.equals(TeoTypes.LET_KEYWORD) ||
                tokenType.equals(TeoTypes.FROM_KEYWORD)) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(TeoTypes.MODEL_NAME)) {
            return MODEL_NAME_KEYS;
        }
        if (tokenType.equals(TeoTypes.BOOL_LITERAL)) {
            return BOOL_KEYS;
        }
        if (tokenType.equals(TeoTypes.NUMBER_LITERAL)) {
            return NUMBER_KEYS;
        }
        if (tokenType.equals(TeoTypes.STRING_LITERAL)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(TeoTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}
