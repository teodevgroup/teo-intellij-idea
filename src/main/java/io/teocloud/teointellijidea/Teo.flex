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

EOL="\r"|"\n"|"\r\n"
WS=[\ \t\f]
WS_EOL=({WS}|{EOL})+

COMMENT="//" .*

ALPHA=[:letter:]

DIGIT=[:digit:]

HEX={DIGIT} | [aAbBcCdDeEfF]

IDENTIFIER={ALPHA}

BOOL_LITERAL="true"|"false"

NUMBER_LITERAL={DIGIT}+

ESC="\\" ( [^] | "u" {HEX}{HEX}{HEX}{HEX} )
CHAR=[^\r\n\'\"\\]
STRING_BAD=\" ({CHAR} | {ESC} | \') *
STRING_LITERAL={STRING_BAD} \"

%state WAITING_VALUE

%%

{EOL} {yybegin(YYINITIAL); return TokenType.EOL; }
{WS} {yybegin(YYINITIAL); return TokenType.WS; }
{WS_EOL} {yybegin(YYINITIAL); return TokenType.WS_EOL; }
{COMMENT} {yybegin(YYINITIAL); return TokenType.COMMENT; }
{STRING_LITERAL} {yybegin(YYINITIAL); return TokenType.STRING_LITERAL; }
{NUMBER_LITERAL} {yybegin(YYINITIAL); return TokenType.NUMBER_LITERAL; }
{BOOL_LITERAL} {yybegin(YYINITIAL); return TokenType.BOOL_LITERAL; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
