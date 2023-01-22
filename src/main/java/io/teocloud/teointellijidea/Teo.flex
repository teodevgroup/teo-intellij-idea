package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.psi.TokenType.*;
import java.util.Stack;

%%

%{
    public TeoFlexLexer() {
        this((java.io.Reader)null);
    }
%}

%class TeoFlexLexer
%public
%implements FlexLexer
%unicode
%function advance
%type IElementType
// %debug

// whitespaces
EOL="\r"|"\n"|"\r\n"
WSC=[\ \t\f]

// names and literals
STRING_LITERAL   = \"([^\\\"\r\n]|\\[^\r\n])*\"?
DIGIT            = [:digit:]
NUMERIC_LITERAL  = "-"? {DIGIT}+ ("." {DIGIT}+)?
BOOL_LITERAL     = "true" | "false"
NULL_LITERAL     = "null"
NAME_START       = [a-zA-Z]
NAME_BODY        = [a-zA-Z0-9_]
IDENTIFIER       = {NAME_START} ({NAME_BODY})*

// comments
DOC_COMMENT="///" .*
LINE_COMMENT="//" .*

%state BLOCK

%%

<YYINITIAL> {
    "model"            { return MODEL_KEYWORD; }
    "enum"             { return ENUM_KEYWORD; }
    "config"           { return CONFIG_KEYWORD; }
    "connector"        { return CONNECTOR_KEYWORD; }
    "client"           { return CLIENT_KEYWORD; }
    "entity"           { return ENTITY_KEYWORD; }
    "import"           { return IMPORT_KEYWORD; }
    "from"             { return FROM_KEYWORD; }
    "let"              { return LET_KEYWORD; }
}

"{"                { yybegin(BLOCK); return LBRACE; }
"}"                { yybegin(YYINITIAL); return RBRACE; }
"("                { yybegin(BLOCK); return LPAREN; }
")"                { yybegin(YYINITIAL); return RPAREN; }
"["                { yybegin(BLOCK); return LBRACKET; }
"]"                { yybegin(YYINITIAL); return RBRACKET; }
"="                { return EQ; }
"."                { return DOT; }
":"                { return COLON; }
"??"               { return QMQM; }
"?"                { return QM; }
"!"                { return EXCL; }
"@@"               { return ATAT; }
"@"                { return AT; }
","                { return COMMA; }
"..."              { return CRANGE; }
".."               { return ORANGE; }
"$"                { return DOLLAR; }

{NULL_LITERAL}     { return NULL_LITERAL; }
{BOOL_LITERAL}     { return BOOL_LITERAL; }
{NUMERIC_LITERAL}  { return NUMERIC_LITERAL; }
{STRING_LITERAL}   { return STRING_LITERAL; }
{EOL}              { return EOL; }
{WSC}              { return WSC; }

{DOC_COMMENT}      { return DOC_COMMENT; }
{LINE_COMMENT}     { return LINE_COMMENT; }

{IDENTIFIER}       { return IDENTIFIER; }

[^]                { return BAD_CHARACTER; }
