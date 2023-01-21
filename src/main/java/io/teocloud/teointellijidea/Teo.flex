package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.psi.TokenType.*;
import com.intellij.openapi.util.text.StringUtil;
import java.util.Stack;

%%

%{

    private Stack<Integer> stack = new Stack<Integer>(){};

    private Stack<Integer> blockStack = new Stack<Integer>();

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
        if (!blockStack.empty()) {
            if (blockStack.peek() == CONFIG) {
                if (yystate() == YYINITIAL) {
                    yybegin(CONFIG);
                }
            } else if (blockStack.peek() == MODEL) {
                if (yystate() == TYPE) {
                    yybegin(MODEL);
                }
            }
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
        if (yystate() == MODEL_DECL) {
            yypopState();
        }
        if (yystate() == ENUM_DECL) {
            yypopState();
        }
        if (yystate() == LET_DECL) {
            yypopState();
        }
        if (yystate() == CONFIG_DECL) {
            yypopState();
        }
    }

    private void pushBlock() {
        if (yystate() == ENUM_DECL) {
            blockStack.push(ENUM);
            cancelDeclState();
            yypushState(ENUM);
        } else if (yystate() == MODEL_DECL) {
            blockStack.push(MODEL);
            cancelDeclState();
            yypushState(MODEL);
        } else if (yystate() == CONFIG_DECL) {
            blockStack.push(CONFIG);
            cancelDeclState();
            yypushState(CONFIG);
        } else {
            blockStack.push(BLOCK);
            cancelDeclState();
            yypushState(BLOCK);
        }
    }

    private void yypopToCurrentBlock() {
        if (blockStack.peek() == ENUM) {
            yypopToState(ENUM);
            blockStack.pop();
        } else if (blockStack.peek() == MODEL) {
            yypopToState(MODEL);
            blockStack.pop();
        } else if (blockStack.peek() == CONFIG) {
            yypopToState(CONFIG);
            blockStack.pop();
        } else if (blockStack.peek() == BLOCK) {
            yypopToState(BLOCK);
            blockStack.pop();
        }
    }

    private void handleConfigItemDetected() {
        yybegin(YYINITIAL);
    }

    private void intoTypeMode() {
        if (yystate() == MODEL) {
            if (!blockStack.empty() && blockStack.peek() == MODEL) {
                yybegin(TYPE);
            }
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

// names and literals
STRING_LITERAL   = \"([^\\\"\r\n]|\\[^\r\n])*\"?
DIGIT            = [:digit:]
NUMERIC_LITERAL  = "-"? {DIGIT}+ ("." {DIGIT}+)?
BOOL_LITERAL="true" | "false"
NULL_LITERAL="null"
NAME_START       = [a-zA-Z]
NAME_BODY        = [a-zA-Z0-9_]
IDENTIFIER       = {NAME_START} ({NAME_BODY})*

// comments
DOC_COMMENT="///" .*
LINE_COMMENT="//" .*

%state DECORATOR, PPL, BLOCK, DECL, ENUM, ENUM_DECL, MODEL, MODEL_DECL, LET_DECL, CONFIG, CONFIG_DECL, TYPE

%%

<YYINITIAL> {
    "model"            { yybegin(MODEL_DECL); return MODEL_KEYWORD; }
    "enum"             { yybegin(ENUM_DECL); return ENUM_KEYWORD; }
    "config"           { yybegin(CONFIG_DECL); return CONFIG_KEYWORD; }
    "connector"        { yybegin(CONFIG_DECL); return CONNECTOR_KEYWORD; }
    "client"           { yybegin(CONFIG_DECL); return CLIENT_KEYWORD; }
    "entity"           { yybegin(CONFIG_DECL); return ENTITY_KEYWORD; }
    "import"           { return IMPORT_KEYWORD; }
    "from"             { return FROM_KEYWORD; }
    "let"              { yybegin(LET_DECL); return LET_KEYWORD; }
}

"{"                { pushBlock(); return LBRACE; }
"}"                { yypopToCurrentBlock(); return RBRACE; }
"("                { yypushState(YYINITIAL); return LPAREN; }
")"                { yypopToState(YYINITIAL); return RPAREN; }
"["                { yypushState(YYINITIAL); return LBRACKET; }
"]"                { yypopToState(YYINITIAL); return RBRACKET; }
"="                { cancelDeclState(); return EQ; }
"."                { return DOT; }
":"                { intoTypeMode(); return COLON; }
"??"               { return QMQM; }
"?"                { return QM; }
"!"                { return EXCL; }
"@@"               { yypushStateWhenDifferent(DECORATOR); return ATAT; }
"@"                { yypushStateWhenDifferent(DECORATOR); return AT; }
","                { return COMMA; }
"..."              { return CRANGE; }
".."               { return ORANGE; }
"$"                { yypushState(PPL); return DOLLAR; }

{NULL_LITERAL}     { return NULL_LITERAL; }
{BOOL_LITERAL}     { return BOOL_LITERAL; }
{NUMERIC_LITERAL}  { return NUMERIC_LITERAL; }
{STRING_LITERAL}   { return STRING_LITERAL; }
{EOL}              { cancelDeclState(); handleNewLine(); return EOL; }
{WSC}              { handleWhiteSpace(); return WSC; }

{DOC_COMMENT}      { return DOC_COMMENT; }
{LINE_COMMENT}     { return LINE_COMMENT; }

<DECORATOR> {
    {IDENTIFIER}  { return DECO_IDENTIFIER; }
}

<PPL> {
    {IDENTIFIER}  { return PPL_IDENTIFIER; }
}

<MODEL_DECL> {
    {IDENTIFIER}  { return MODEL_NAME; }
}

<ENUM_DECL> {
    {IDENTIFIER}  { return ENUM_NAME; }
}

<CONFIG_DECL> {
    {IDENTIFIER}  { return CONFIG_NAME; }
}

<ENUM> {
    {IDENTIFIER}  { return ENUM_IDENTIFIER; }
}

<CONFIG> {
    {IDENTIFIER}  { handleConfigItemDetected(); return CONFIG_ITEM_NAME; }
}

<MODEL> {
    {IDENTIFIER}  { return FIELD_NAME; }
}

<TYPE> {
    {IDENTIFIER}  { return FIELD_TYPE_BASE; }
}

{IDENTIFIER}      { return IDENTIFIER; }

[^]               { return BAD_CHARACTER; }
