package io.teocloud.teointellijidea.ide.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.teocloud.teointellijidea.lang.lexer.TeoFlexLexerAdapter;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TeoSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD = createTextAttributesKey("TEO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey CONFIG_ITEM_NAME = createTextAttributesKey("TEO_CONFIG_ITEM_NAME", DefaultLanguageHighlighterColors.CONSTANT);

    public static final TextAttributesKey MODEL_NAME = createTextAttributesKey("TEO_MODEL_NAME", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey FIELD_NAME = createTextAttributesKey("TEO_FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey BUILTIN_TYPE = createTextAttributesKey("TEO_BUILTIN_TYPE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey USER_TYPE = createTextAttributesKey("TEO_USER_TYPE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey ENUM_MEMBER = createTextAttributesKey("TEO_ENUM_MEMBER", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

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
    public static final TextAttributesKey DECORATOR = createTextAttributesKey("TEO_DECORATOR", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey PIPELINE = createTextAttributesKey("TEO_PIPELINE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey DOT = createTextAttributesKey("TEO_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("TEO_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BRACES = createTextAttributesKey("TEO_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("TEO_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("TEO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] BOOL_KEYS = new TextAttributesKey[]{BOOL_LITERAL};
    private static final TextAttributesKey[] NUMERIC_KEYS = new TextAttributesKey[]{NUMERIC_LITERAL};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING_LITERAL};
    private static final TextAttributesKey[] NULL_KEYS = new TextAttributesKey[]{NULL_LITERAL};
    private static final TextAttributesKey[] CONFIG_ITEM_KEYS = new TextAttributesKey[]{CONFIG_ITEM_NAME};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] MODEL_NAME_KEYS = new TextAttributesKey[]{MODEL_NAME};
    private static final TextAttributesKey[] DECORATOR_KEYS = new TextAttributesKey[]{DECORATOR};

    private static final TextAttributesKey[] PIPELINE_KEYS = new TextAttributesKey[]{PIPELINE};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DOT};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKETS};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACES};
    private static final TextAttributesKey[] ENUM_MEMBER_KEYS = new TextAttributesKey[]{ENUM_MEMBER};
    private static final TextAttributesKey[] FIELD_NAME_KEYS = new TextAttributesKey[]{FIELD_NAME};
    private static final TextAttributesKey[] USER_TYPE_KEYS = new TextAttributesKey[]{USER_TYPE};
    private static final TextAttributesKey[] BUILTIN_TYPE_KEYS = new TextAttributesKey[]{BUILTIN_TYPE};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new TeoFlexLexerAdapter();
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
        if (tokenType.equals(TeoTypes.LINE_COMMENT) || tokenType.equals(TeoTypes.DOC_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TeoTypes.AT) || tokenType.equals(TeoTypes.ATAT)) {
            return DECORATOR_KEYS;
        }
        if (tokenType.equals(TeoTypes.DOLLAR)) {
            return PIPELINE_KEYS;
        }
        if (tokenType.equals(TeoTypes.DOT)) {
            return DOT_KEYS;
        }
        if (tokenType.equals(TeoTypes.COMMA)) {
            return COMMA_KEYS;
        }
        if (tokenType.equals(TeoTypes.LBRACKET) || tokenType.equals(TeoTypes.RBRACKET)) {
            return BRACKET_KEYS;
        }
        if (tokenType.equals(TeoTypes.LBRACE) || tokenType.equals(TeoTypes.RBRACE)) {
            return BRACE_KEYS;
        }
        if (tokenType.equals(TeoTypes.USER_TYPE)) {
            return USER_TYPE_KEYS;
        }
        if (tokenType.equals(TeoTypes.BUILTIN_TYPE)) {
            return BUILTIN_TYPE_KEYS;
        }
        if (tokenType.equals(TeoTypes.ENUM_MEMBER_NAME)) {
            return ENUM_MEMBER_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}
