package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.psi.TokenType.*;
import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;import java.util.Stack;

%%

%{

    private Stack<Integer> stack = new Stack<Integer>(){};

    public void yypushState(int newState) {
        stack.push(yystate());
        yybegin(newState);
    }

    public void yypushStateWhenDifferent(int newState) {
        if (yystate() != newState) {
            yypushState(newState);
        }
    }

    public void yypopState() {
        if (stack.empty()) {
            System.out.format("will just be initial\n");
            yybegin(YYINITIAL);
        } else {
            System.out.format("SEE CURRENT STATE %s  -- ", stack.toString());
            int a = stack.pop();
            System.out.format("will pop %d\n", a);
            yybegin(a);
        }
    }

    public void yypopToState(int state) {
        if (yystate() == state) {
            yypopState();
        } else if (stack.empty()) {
            yypopToState(YYINITIAL);
        } else {
            yypopState();
            yypopToState(state);
        }
    }

    public TeoLexer() {
        this((java.io.Reader)null);
    }

    private void handleNewLine() {
        if ((yystate() == DECORATOR) || (yystate() == PPL)) {
            yypopState();
        }
    }

    private void handleWhiteSpace() {
        if (yystate() == DECORATOR) {
            yypopState();
        }
    }

    private void cancelDeclState() {
        if (yystate() == DECL) {
            yypopState();
        }
    }
%}

%class TeoLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

// whitespaces
EOL="\r"|"\n"|"\r\n"
WSC=[\ \t\f]
DIGIT            = [:digit:]

// names and literals
NAME_START       = [a-zA-Z]
NAME_BODY        = [a-zA-Z0-9_]
IDENTIFIER       = {NAME_START} ({NAME_BODY})*
STRING_LITERAL   = \"([^\\\"\r\n]|\\[^\r\n])*\"?
NUMERIC_LITERAL  = "-"? {DIGIT}+ ("." {DIGIT}+)?
BOOL_LITERAL="true" | "false"
NULL_LITERAL="null"

// comments
DOC_COMMENT="///" .*
LINE_COMMENT="//" .*

%state DECL, BLOCK, DECORATOR, PPL

%%

<YYINITIAL> {
    "model"            { yybegin(DECL); return MODEL_KEYWORD; }
    "enum"             { yybegin(DECL); return ENUM_KEYWORD; }
    "config"           { yybegin(DECL); return CONFIG_KEYWORD; }
    "connector"        { yybegin(DECL); return CONNECTOR_KEYWORD; }
    "client"           { yybegin(DECL); return CLIENT_KEYWORD; }
    "entity"           { yybegin(DECL); return ENTITY_KEYWORD; }
    "import"           { return IMPORT_KEYWORD; }
    "from"             { return FROM_KEYWORD; }
    "let"              { yybegin(DECL); return LET_KEYWORD; }
}

<DECORATOR> {
    {IDENTIFIER}  { return DECO_IDENTIFIER; }
}

<PPL> {
    {IDENTIFIER}  { return PPL_IDENTIFIER; }
}

"{"                { cancelDeclState(); yypushState(BLOCK); return LBRACE; }
"}"                { yypopToState(BLOCK); return RBRACE; }
"("                { yypushState(YYINITIAL); return LPAREN; }
")"                { yypopToState(YYINITIAL); return RPAREN; }
"["                { yypushState(YYINITIAL); return LBRACKET; }
"]"                { yypopToState(YYINITIAL); return RBRACKET; }
"="                { cancelDeclState(); return EQ; }
"."                { return DOT; }
":"                { return COLON; }
"??"               { return QMQM; }
"?"                { return QM; }
"!"                { return EXCL; }
"@@"               { yypushStateWhenDifferent(DECORATOR); return ATAT; }
"@"                { yypushStateWhenDifferent(DECORATOR); return AT; }
","                { return COMMA; }
"..."              { return CRANGE; }
".."               { return ORANGE; }
"$"                { yypushState(PPL); return DOLLAR; }

{IDENTIFIER}       { return IDENTIFIER; }
{NULL_LITERAL}     { return NULL_LITERAL; }
{BOOL_LITERAL}     { return BOOL_LITERAL; }
{NUMERIC_LITERAL}  { return NUMERIC_LITERAL; }
{STRING_LITERAL}   { return STRING_LITERAL; }
{EOL}              { cancelDeclState(); handleNewLine(); return EOL; }
{WSC}              { handleWhiteSpace(); return WSC; }

{DOC_COMMENT}      { return DOC_COMMENT; }
{LINE_COMMENT}     { return LINE_COMMENT; }

[^]                { return BAD_CHARACTER; }
