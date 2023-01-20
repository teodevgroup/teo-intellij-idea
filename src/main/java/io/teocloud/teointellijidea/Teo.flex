package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.psi.TokenType.*;

%%

%{
  public _TeoLexer() {
    this((java.io.Reader)null);
  }

  private void handleNewLine() {
      if (yystate() == DECL && StringUtil.containsLineBreak(yytext())) {
          yybegin(YYINITIAL);
      }
  }
%}

%class _TeoLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

// whitespaces
EOL="\r"|"\n"|"\r\n"
WS=[\ \t\f]
WHITE_SPACE_CHAR = {EOL} | {WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+
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

%state DECL, BLOCK

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

"{"                { yybegin(BLOCK); return LBRACE; }
"}"                { yybegin(YYINITIAL); return RBRACE; }
"("                { return LPAREN; }
")"                { return RPAREN; }
"["                { return LBRACKET; }
"]"                { return RBRACKET; }
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

{IDENTIFIER}       { return IDENTIFIER; }
{NULL_LITERAL}     { return NULL_LITERAL; }
{BOOL_LITERAL}     { return TeoTypes.BOOL_LITERAL; }
{NUMERIC_LITERAL}  { return NUMERIC_LITERAL; }
{STRING_LITERAL}   { return STRING_LITERAL; }
{WHITE_SPACE}      { handleNewLine(); return WHITE_SPACE; }

{DOC_COMMENT}      { return DOC_COMMENT; }
{LINE_COMMENT}     { return LINE_COMMENT; }

[^]                { return BAD_CHARACTER; }
