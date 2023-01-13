package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import io.teocloud.teointellijidea.psi.TeoTypes;
import com.intellij.psi.TokenType;

%%

%class TeoLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

NEWLINE="\r"|"\n"|"\r\n"
WHITESPACE=[\ \t\f]
BLOCK_OPEN="{"
BLOCK_CLOSE="}"
COMMA=","
EQUAL_SIGN="="
ENUM_KEYWORD="enum"
MODEL_KEYWORD="model"
CONFIG_KEYWORD="config"
CONNECTOR_KEYWORD="connector"
CLIENT_KEYWORD="client"
ENTITY_KEYWORD="entity"
IMPORT_KEYWORD="import"
FROM_KEYWORD="from"
LET_KEYWORD="let"
COLON=":"
TRAILING_COMMA=","
RANGE_OPEN=".."
RANGE_CLOSE="..."
AT="@"
DOUBLE_AT="@@"
DOLLAR_SIGN="$"
COMMENT="//" .*

ALPHA=[:letter:]

DIGIT=[:digit:]

HEX={DIGIT} | [aAbBcCdDeEfF]

IDENTIFIER=([:letter:] ([:letter:]|[:digit:]|"_")*)

BOOL_LITERAL="true"|"false"

NUMBER_LITERAL="-"?{DIGIT}+ ("." {DIGIT}+)?

ESC="\\" ( [^] | "u" {HEX}{HEX}{HEX}{HEX} )
CHAR=[^\r\n\'\"\\]
STRING_BAD=\" ({CHAR} | {ESC} | \') *
STRING_LITERAL={STRING_BAD} \"

%%

{NEWLINE} {yybegin(YYINITIAL); return TeoTypes.NEWLINE; }
{WHITESPACE} {yybegin(YYINITIAL); return TeoTypes.WHITESPACE; }
{BLOCK_OPEN} {yybegin(YYINITIAL); return TeoTypes.BLOCK_OPEN; }
{BLOCK_CLOSE} {yybegin(YYINITIAL); return TeoTypes.BLOCK_CLOSE; }
{MODEL_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.MODEL_KEYWORD; }
{ENUM_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.ENUM_KEYWORD; }
{LET_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.LET_KEYWORD; }
{IMPORT_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.IMPORT_KEYWORD; }
{FROM_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.FROM_KEYWORD; }
{EQUAL_SIGN} {yybegin(YYINITIAL); return TeoTypes.EQUAL_SIGN; }
{COMMA} {yybegin(YYINITIAL); return TeoTypes.COMMA; }
{IDENTIFIER} {yybegin(YYINITIAL); return TeoTypes.IDENTIFIER; }
{DOUBLE_AT} {yybegin(YYINITIAL); return TeoTypes.DOUBLE_AT; }
{AT} {yybegin(YYINITIAL); return TeoTypes.AT; }
{COMMENT} {yybegin(YYINITIAL); return TeoTypes.COMMENT; }
{STRING_LITERAL} {yybegin(YYINITIAL); return TeoTypes.STRING_LITERAL; }
{NUMBER_LITERAL} {yybegin(YYINITIAL); return TeoTypes.NUMBER_LITERAL; }
{BOOL_LITERAL} {yybegin(YYINITIAL); return TeoTypes.BOOL_LITERAL; }
{DOLLAR_SIGN} {yybegin(YYINITIAL); return TeoTypes.DOLLAR_SIGN; }

[^] { return TokenType.BAD_CHARACTER; }
