package io.teocloud.teointellijidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.psi.TokenType.*;
import com.intellij.openapi.util.text.StringUtil;
import java.util.Stack;

%%

%{

    private Stack<Integer> stack = new Stack<Integer>();

    private Stack<Integer> blockStack = new Stack<Integer>();

    private boolean previousTokenIsIdentifier = false;

    public void yypushState(int newState) {
        System.out.format("CURRENT %s <<< ", stack.toString());
        System.out.format("will push %d\n", yystate());
        stack.push(newState);
        yybegin(newState);
    }

    public void yypushStateWhenDifferent(int newState) {
        if (yystate() != newState) {
            yypushState(newState);
        }
    }

    public void yypopState() {
        if (stack.empty()) {
            System.out.format("OVERPOP 1\n");
            yybegin(YYINITIAL);
        } else {
            System.out.format("CURRENT %s >>> ", stack.toString());
            int a = stack.pop();
            System.out.format("will pop %d\n", a);
            if (stack.empty()) {
                System.out.format("OVERPOP 2\n");
                yybegin(YYINITIAL);
            } else {
                yybegin(stack.peek());
            }
        }
    }

    public void yypopToState(int state) {
        if (yystate() == ENUM_MEMBER) {
            if (stack.empty()) {
                yybegin(YYINITIAL);
            } else {
                yybegin(stack.peek());
            }
        }
        if (yystate() == state) {
            yypopState();
        } else if (stack.empty()) {
            yypopToState(YYINITIAL);
        } else {
            yypopState();
            yypopToState(state);
        }
    }

    public _TeoLexer() {
        this((java.io.Reader)null);
        stack.push(YYINITIAL);
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

    private void recordIdentifier() {
        previousTokenIsIdentifier = true;
    }

    private void recordNotIdentifier() {
        previousTokenIsIdentifier = false;
    }

    private void intoEnumMemberModeIfNeeded() {
        if (!previousTokenIsIdentifier) {
            yybegin(ENUM_MEMBER);
        }
    }

    private void cancelEnumMemberMode() {
        if (stack.empty()) {
            yybegin(YYINITIAL);
        } else {
            yybegin(stack.peek());
        }
    }
%}

//%{
//  private static String zzToPrintable(CharSequence cs) {
//    return zzToPrintable(cs.toString());
//  }
//%}

%class _TeoLexer
%public
%implements FlexLexer
%unicode
%function advance
%type IElementType
%debug

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

%state DECORATOR, PPL, BLOCK, DECL, ENUM, ENUM_DECL, MODEL, MODEL_DECL, LET_DECL, CONFIG, CONFIG_DECL, TYPE, ENUM_MEMBER

%%

<YYINITIAL> {
    "model"            { yybegin(MODEL_DECL); recordNotIdentifier(); return MODEL_KEYWORD; }
    "enum"             { yybegin(ENUM_DECL); recordNotIdentifier(); return ENUM_KEYWORD; }
    "config"           { yybegin(CONFIG_DECL); recordNotIdentifier(); return CONFIG_KEYWORD; }
    "connector"        { yybegin(CONFIG_DECL); recordNotIdentifier(); return CONNECTOR_KEYWORD; }
    "client"           { yybegin(CONFIG_DECL); recordNotIdentifier(); return CLIENT_KEYWORD; }
    "entity"           { yybegin(CONFIG_DECL); recordNotIdentifier(); return ENTITY_KEYWORD; }
    "import"           { recordNotIdentifier(); return IMPORT_KEYWORD; }
    "from"             { recordNotIdentifier(); return FROM_KEYWORD; }
    "let"              { yybegin(LET_DECL); recordNotIdentifier(); return LET_KEYWORD; }
}

"{"                { pushBlock(); recordNotIdentifier(); return LBRACE; }
"}"                { recordIdentifier(); yypopToCurrentBlock(); return RBRACE; }
"("                { yypushState(YYINITIAL); recordNotIdentifier(); return LPAREN; }
")"                { recordIdentifier(); yypopToState(YYINITIAL); return RPAREN; }
"["                { yypushState(YYINITIAL); recordNotIdentifier(); return LBRACKET; }
"]"                { yypopToState(YYINITIAL); recordIdentifier(); return RBRACKET; }
"="                { cancelDeclState(); recordNotIdentifier(); return EQ; }
"."                { intoEnumMemberModeIfNeeded(); return DOT; }
":"                { intoTypeMode(); recordNotIdentifier(); return COLON; }
"??"               { recordNotIdentifier(); return QMQM; }
"?"                { recordNotIdentifier(); return QM; }
"!"                { recordNotIdentifier(); return EXCL; }
"@@"               { yypushStateWhenDifferent(DECORATOR); recordNotIdentifier(); return ATAT; }
"@"                { yypushStateWhenDifferent(DECORATOR); recordNotIdentifier(); return AT; }
","                { recordNotIdentifier(); return COMMA; }
"..."              { recordNotIdentifier(); return CRANGE; }
".."               { recordNotIdentifier(); return ORANGE; }
"$"                { yypushState(PPL); recordNotIdentifier(); return DOLLAR; }

{NULL_LITERAL}     { recordIdentifier(); return NULL_LITERAL; }
{BOOL_LITERAL}     { recordIdentifier(); return BOOL_LITERAL; }
{NUMERIC_LITERAL}  { recordIdentifier(); return NUMERIC_LITERAL; }
{STRING_LITERAL}   { recordIdentifier(); return STRING_LITERAL; }
{EOL}              { cancelDeclState(); handleNewLine(); return EOL; }
{WSC}              { handleWhiteSpace(); return WSC; }

{DOC_COMMENT}      { recordNotIdentifier(); return DOC_COMMENT; }
{LINE_COMMENT}     { recordNotIdentifier(); return LINE_COMMENT; }

<DECORATOR> {
    {IDENTIFIER}  { recordIdentifier(); return DECO_IDENTIFIER; }
}

<PPL> {
    {IDENTIFIER}  { recordIdentifier(); return PPL_IDENTIFIER; }
}

<MODEL_DECL> {
    {IDENTIFIER}  { recordIdentifier(); return MODEL_NAME; }
}

<ENUM_DECL> {
    {IDENTIFIER}  { recordIdentifier(); return ENUM_NAME; }
}

<CONFIG_DECL> {
    {IDENTIFIER}  { recordIdentifier(); return CONFIG_NAME; }
}

<ENUM> {
    {IDENTIFIER}  { recordIdentifier(); return ENUM_IDENTIFIER; }
}

<CONFIG> {
    {IDENTIFIER}  { recordNotIdentifier(); handleConfigItemDetected(); return CONFIG_ITEM_NAME; }
}

<MODEL> {
    {IDENTIFIER}  { recordIdentifier(); return FIELD_NAME; }
}

<ENUM_MEMBER> {
    {IDENTIFIER}  { recordIdentifier(); cancelEnumMemberMode(); return ENUM_MEMBER_NAME; }
}

<TYPE> {
    "String"      { return BUILTIN_TYPE; }
    "Bool"        { return BUILTIN_TYPE; }
    "Int"         { return BUILTIN_TYPE; }
    "Int32"       { return BUILTIN_TYPE; }
    "Int64"       { return BUILTIN_TYPE; }
    "Float"       { return BUILTIN_TYPE; }
    "Float32"     { return BUILTIN_TYPE; }
    "Float64"     { return BUILTIN_TYPE; }
    "Date"        { return BUILTIN_TYPE; }
    "DateTime"    { return BUILTIN_TYPE; }
    "ObjectId"    { return BUILTIN_TYPE; }
    {IDENTIFIER}  { return USER_TYPE; }
}

{IDENTIFIER}      { recordIdentifier(); return IDENTIFIER; }

[^]               { return BAD_CHARACTER; }
