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
    public static final TextAttributesKey NULL_LITERAL =
            createTextAttributesKey("TEO_NULL_LITERAL", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey STRING_LITERAL =
            createTextAttributesKey("TEO_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMERIC_LITERAL =
            createTextAttributesKey("TEO_NUMERIC_LITERAL", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("TEO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey DECORATOR = createTextAttributesKey("TEO_DECORATOR", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("TEO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] BOOL_KEYS = new TextAttributesKey[]{BOOL_LITERAL};
    private static final TextAttributesKey[] NUMERIC_KEYS = new TextAttributesKey[]{NUMERIC_LITERAL};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING_LITERAL};
    private static final TextAttributesKey[] NULL_KEYS = new TextAttributesKey[]{NULL_LITERAL};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] MODEL_NAME_KEYS = new TextAttributesKey[]{MODEL_NAME};
    private static final TextAttributesKey[] DECORATOR_KEYS = new TextAttributesKey[]{DECORATOR};
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
                tokenType.equals(TeoTypes.FROM_KEYWORD) ||
                tokenType.equals(TeoTypes.LET_KEYWORD) ||
                tokenType.equals(TeoTypes.CONFIG_KEYWORD) ||
                tokenType.equals(TeoTypes.CONNECTOR_KEYWORD) ||
                tokenType.equals(TeoTypes.CLIENT_KEYWORD) ||
                tokenType.equals(TeoTypes.ENTITY_KEYWORD)) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(TeoTypes.MODEL_NAME)) {
            return MODEL_NAME_KEYS;
        }
        if (tokenType.equals(TeoTypes.BOOL_LITERAL)) {
            return BOOL_KEYS;
        }
        if (tokenType.equals(TeoTypes.NUMERIC_LITERAL)) {
            return NUMERIC_KEYS;
        }
        if (tokenType.equals(TeoTypes.STRING_LITERAL)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(TeoTypes.NULL_LITERAL)) {
            return NULL_KEYS;
        }
        if (tokenType.equals(TeoTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TeoTypes.AT) || tokenType.equals(TeoTypes.DOUBLE_AT)) {
            return DECORATOR_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}
