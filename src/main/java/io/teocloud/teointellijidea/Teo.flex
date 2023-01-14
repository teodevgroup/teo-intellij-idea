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

// whitespaces
NEWLINE="\r"|"\n"|"\r\n"
WHITESPACE=[\ \t\f]
// puncs
BLOCK_OPEN="{"
BLOCK_CLOSE="}"
PAREN_OPEN="("
PAREN_CLOSE=")"
BRACK_OPEN="["
BRACK_CLOSE="]"
DOT="."
COMMA=","
DOUBLE_QUESTION="??"
QUESTION="?"
EQUAL_SIGN="="
COLON=":"
RANGE_CLOSE="..."
RANGE_OPEN=".."
DOUBLE_AT="@@"
AT="@"
DOLLAR_SIGN="$"
// keywords
ENUM_KEYWORD="enum"
MODEL_KEYWORD="model"
CONFIG_KEYWORD="config"
CONNECTOR_KEYWORD="connector"
CLIENT_KEYWORD="client"
ENTITY_KEYWORD="entity"
IMPORT_KEYWORD="import"
FROM_KEYWORD="from"
LET_KEYWORD="let"

// literals
TRIPLE_LINE_COMMENT="///" .*
DOUBLE_LINE_COMMENT="//" .*

ALPHA=[:letter:]

DIGIT=[:digit:]

HEX={DIGIT} | [aAbBcCdDeEfF]

IDENTIFIER=([:letter:] ([:letter:]|[:digit:]|"_")*)

BOOL_LITERAL="true"|"false"

NULL_LITERAL="null"

NUMERIC_LITERAL="-"?{DIGIT}+ ("." {DIGIT}+)?

ESC="\\" ( [^] | "u" {HEX}{HEX}{HEX}{HEX} )
CHAR=[^\r\n\'\"\\]
STRING_BAD=\" ({CHAR} | {ESC} | \') *
STRING_LITERAL={STRING_BAD} \"

%%

// whitespaces
{NEWLINE} {yybegin(YYINITIAL); return TeoTypes.NEWLINE; }
{WHITESPACE} {yybegin(YYINITIAL); return TeoTypes.WHITESPACE; }
// puncs
{BLOCK_OPEN} {yybegin(YYINITIAL); return TeoTypes.BLOCK_OPEN; }
{BLOCK_CLOSE} {yybegin(YYINITIAL); return TeoTypes.BLOCK_CLOSE; }
{PAREN_OPEN} {yybegin(YYINITIAL); return TeoTypes.PAREN_OPEN; }
{PAREN_CLOSE} {yybegin(YYINITIAL); return TeoTypes.PAREN_CLOSE; }
{BRACK_OPEN} {yybegin(YYINITIAL); return TeoTypes.BRACK_OPEN; }
{BRACK_CLOSE} {yybegin(YYINITIAL); return TeoTypes.BRACK_CLOSE; }
{DOT} {yybegin(YYINITIAL); return TeoTypes.DOT; }
{COMMA} {yybegin(YYINITIAL); return TeoTypes.COMMA; }
{DOUBLE_QUESTION} {yybegin(YYINITIAL); return TeoTypes.DOUBLE_QUESTION; }
{QUESTION} {yybegin(YYINITIAL); return TeoTypes.QUESTION; }
{EQUAL_SIGN} {yybegin(YYINITIAL); return TeoTypes.EQUAL_SIGN; }
{COLON} {yybegin(YYINITIAL); return TeoTypes.COLON; }
{DOUBLE_AT} {yybegin(YYINITIAL); return TeoTypes.DOUBLE_AT; }
{AT} {yybegin(YYINITIAL); return TeoTypes.AT; }
{DOLLAR_SIGN} {yybegin(YYINITIAL); return TeoTypes.DOLLAR_SIGN; }

// identifiers
{ENUM_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.ENUM_KEYWORD; }
{MODEL_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.MODEL_KEYWORD; }
{CONFIG_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.CONFIG_KEYWORD; }
{CONNECTOR_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.CONNECTOR_KEYWORD; }
{CLIENT_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.CLIENT_KEYWORD; }
{ENTITY_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.ENTITY_KEYWORD; }
{IMPORT_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.IMPORT_KEYWORD; }
{FROM_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.FROM_KEYWORD; }
{LET_KEYWORD} {yybegin(YYINITIAL); return TeoTypes.LET_KEYWORD; }
{IDENTIFIER} {yybegin(YYINITIAL); return TeoTypes.IDENTIFIER; }

// comments
{TRIPLE_LINE_COMMENT} {yybegin(YYINITIAL); return TeoTypes.TRIPLE_LINE_COMMENT; }
{DOUBLE_LINE_COMMENT} {yybegin(YYINITIAL); return TeoTypes.DOUBLE_LINE_COMMENT; }
// literals
{NULL_LITERAL} {yybegin(YYINITIAL); return TeoTypes.NULL_LITERAL; }
{STRING_LITERAL} {yybegin(YYINITIAL); return TeoTypes.STRING_LITERAL; }
{NUMERIC_LITERAL} {yybegin(YYINITIAL); return TeoTypes.NUMERIC_LITERAL; }
{BOOL_LITERAL} {yybegin(YYINITIAL); return TeoTypes.BOOL_LITERAL; }

[^] { return TokenType.BAD_CHARACTER; }
