package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.psi.TokenType.*;
import com.intellij.openapi.util.text.StringUtil;

%%

%{
  public TeoLexer() {
    this((java.io.Reader)null);
  }

  private void handleNewLine() {
      if ((yystate() == DECL || yystate() == DECORATOR) && StringUtil.containsLineBreak(yytext())) {
          yybegin(YYINITIAL);
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
DECO_IDENTIFIER  = {NAME_START} ({NAME_BODY})*
STRING_LITERAL   = \"([^\\\"\r\n]|\\[^\r\n])*\"?
NUMERIC_LITERAL  = "-"? {DIGIT}+ ("." {DIGIT}+)?
BOOL_LITERAL="true" | "false"
NULL_LITERAL="null"

// comments
DOC_COMMENT="///" .*
LINE_COMMENT="//" .*

%state DECL, BLOCK, DECORATOR

%%

<YYINITIAL> {
    "model"            { yybegin(DECL); return MODEL_KEYWORD; }
    "enum"             { yybegin(DECL); return ENUM_KEYWORD; }
    "config"           { yybegin(DECL); return CONFIG_KEYWORD; }
    "connector"        { yybegin(DECL); return CONNECTOR_KEYWORD; }
    "client"           { yybegin(DECL); return CLIENT_KEYWORD; }
    "entity"           { yybegin(DECL); return ENTITY_KEYWORD; }
    "import"           { yybegin(DECL); return IMPORT_KEYWORD; }
    "from"             { yybegin(DECL); return FROM_KEYWORD; }
    "let"              { yybegin(DECL); return LET_KEYWORD; }
}

<DECORATOR> {
    {DECO_IDENTIFIER}  { return DECO_IDENTIFIER; }
}

"{"                { yybegin(BLOCK); return LBRACE; }
"}"                { yybegin(YYINITIAL); return RBRACE; }
"("                { yybegin(YYINITIAL); return LPAREN; }
")"                { yybegin(YYINITIAL); return RPAREN; }
"["                { yybegin(YYINITIAL); return LBRACKET; }
"]"                { yybegin(YYINITIAL); return RBRACKET; }
"="                { return EQ; }
"."                { return DOT; }
":"                { return COLON; }
"??"               { return QMQM; }
"?"                { return QM; }
"!"                { return EXCL; }
"@@"               { yybegin(DECORATOR); return ATAT; }
"@"                { yybegin(DECORATOR); return AT; }
","                { return COMMA; }
"..."              { return CRANGE; }
".."               { return ORANGE; }
"$"                { return DOLLAR; }

{IDENTIFIER}       { return IDENTIFIER; }
{NULL_LITERAL}     { return NULL_LITERAL; }
{BOOL_LITERAL}     { return TeoTypes.BOOL_LITERAL; }
{NUMERIC_LITERAL}  { return NUMERIC_LITERAL; }
{STRING_LITERAL}   { return STRING_LITERAL; }
{EOL}              { handleNewLine(); return EOL; }
{WSC}              { return WSC; }

{DOC_COMMENT}      { return DOC_COMMENT; }
{LINE_COMMENT}     { return LINE_COMMENT; }

[^]                { return BAD_CHARACTER; }
