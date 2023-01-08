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

{EOL} {yybegin(YYINITIAL); return TeoTypes.EOL; }
{WS} {yybegin(YYINITIAL); return TeoTypes.WS; }
{WS_EOL} {yybegin(YYINITIAL); return TeoTypes.WS_EOL; }
{COMMENT} {yybegin(YYINITIAL); return TeoTypes.COMMENT; }
{STRING_LITERAL} {yybegin(YYINITIAL); return TeoTypes.STRING_LITERAL; }
{NUMBER_LITERAL} {yybegin(YYINITIAL); return TeoTypes.NUMBER_LITERAL; }
{BOOL_LITERAL} {yybegin(YYINITIAL); return TeoTypes.BOOL_LITERAL; }

[^] { return TokenType.BAD_CHARACTER; }
