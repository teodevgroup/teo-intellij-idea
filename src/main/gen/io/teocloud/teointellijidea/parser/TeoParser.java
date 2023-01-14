// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TeoParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return teoFile(b, l + 1);
  }

  /* ********************************************************** */
  // (BLOCK_OPEN BLOCK_CLOSE)|(BRACK_OPEN BRACK_CLOSE)
  public static boolean ARITY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARITY")) return false;
    if (!nextTokenIs(b, "<arity>", BLOCK_OPEN, BRACK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARITY, "<arity>");
    r = ARITY_0(b, l + 1);
    if (!r) r = ARITY_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BLOCK_OPEN BLOCK_CLOSE
  private static boolean ARITY_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARITY_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BLOCK_OPEN, BLOCK_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // BRACK_OPEN BRACK_CLOSE
  private static boolean ARITY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARITY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BRACK_OPEN, BRACK_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // QUESTION
  public static boolean COLLECTION_OPTIONAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COLLECTION_OPTIONAL")) return false;
    if (!nextTokenIs(b, QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUESTION);
    exit_section_(b, m, COLLECTION_OPTIONAL, r);
    return r;
  }

  /* ********************************************************** */
  // CONFIG_KEYWORD | CONNECTOR_KEYWORD | CLIENT_KEYWORD | ENTITY_KEYWORD
  public static boolean CONFIG_KEYWORDS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONFIG_KEYWORDS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_KEYWORDS, "<config keywords>");
    r = consumeToken(b, CONFIG_KEYWORD);
    if (!r) r = consumeToken(b, CONNECTOR_KEYWORD);
    if (!r) r = consumeToken(b, CLIENT_KEYWORD);
    if (!r) r = consumeToken(b, ENTITY_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QUESTION
  public static boolean ITEM_OPTIONAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_OPTIONAL")) return false;
    if (!nextTokenIs(b, QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUESTION);
    exit_section_(b, m, ITEM_OPTIONAL, r);
    return r;
  }

  /* ********************************************************** */
  // (NEWLINE | WHITESPACE)+
  public static boolean WS_EOL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WS_EOL")) return false;
    if (!nextTokenIs(b, "<ws eol>", NEWLINE, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WS_EOL, "<ws eol>");
    r = WS_EOL_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS_EOL_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "WS_EOL", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEWLINE | WHITESPACE
  private static boolean WS_EOL_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WS_EOL_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, WHITESPACE);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PAREN_OPEN (argument | named_argument)* PAREN_CLOSE
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    if (!nextTokenIs(b, PAREN_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_OPEN);
    r = r && argument_list_1(b, l + 1);
    r = r && consumeToken(b, PAREN_CLOSE);
    exit_section_(b, m, ARGUMENT_LIST, r);
    return r;
  }

  // (argument | named_argument)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // argument | named_argument
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    r = argument(b, l + 1);
    if (!r) r = named_argument(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_AT unit
  public static boolean block_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_decorator")) return false;
    if (!nextTokenIs(b, DOUBLE_AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_AT);
    r = r && unit(b, l + 1);
    exit_section_(b, m, BLOCK_DECORATOR, r);
    return r;
  }

  /* ********************************************************** */
  // CONFIG_KEYWORDS (WHITESPACE+ IDENTIFIER)? WS_EOL+ BLOCK_OPEN WS_EOL* (config_item WS_EOL*)* WS_EOL* BLOCK_CLOSE
  public static boolean config_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BLOCK, "<config block>");
    r = CONFIG_KEYWORDS(b, l + 1);
    r = r && config_block_1(b, l + 1);
    r = r && config_block_2(b, l + 1);
    r = r && consumeToken(b, BLOCK_OPEN);
    r = r && config_block_4(b, l + 1);
    r = r && config_block_5(b, l + 1);
    r = r && config_block_6(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WHITESPACE+ IDENTIFIER)?
  private static boolean config_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1")) return false;
    config_block_1_0(b, l + 1);
    return true;
  }

  // WHITESPACE+ IDENTIFIER
  private static boolean config_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_block_1_0_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITESPACE+
  private static boolean config_block_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITESPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "config_block_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_EOL+
  private static boolean config_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS_EOL(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS_EOL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_EOL*
  private static boolean config_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS_EOL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_4", c)) break;
    }
    return true;
  }

  // (config_item WS_EOL*)*
  private static boolean config_block_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_block_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_5", c)) break;
    }
    return true;
  }

  // config_item WS_EOL*
  private static boolean config_block_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_item(b, l + 1);
    r = r && config_block_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_EOL*
  private static boolean config_block_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS_EOL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_5_0_1", c)) break;
    }
    return true;
  }

  // WS_EOL*
  private static boolean config_block_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS_EOL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER expression
  public static boolean config_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONFIG_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // item_decorator* ENUM_KEYWORD IDENTIFIER { (ENUM_MEMBER_DEFINITION)* }
  public static boolean enum_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition")) return false;
    if (!nextTokenIs(b, "<enum definition>", AT, ENUM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = enum_definition_0(b, l + 1);
    r = r && consumeTokens(b, 0, ENUM_KEYWORD, IDENTIFIER);
    r = r && enum_definition_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item_decorator*
  private static boolean enum_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_decorator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_definition_0", c)) break;
    }
    return true;
  }

  // (ENUM_MEMBER_DEFINITION)*
  private static boolean enum_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, ENUM_MEMBER_DEFINITION)) break;
      if (!empty_element_parsed_guard_(b, "enum_definition_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (literal | IDENTIFIER | group | nullish_coalescing | pipeline) (subscript | "." IDENTIFIER | argument_list)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // literal | IDENTIFIER | group | nullish_coalescing | pipeline
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    r = literal(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = group(b, l + 1);
    if (!r) r = nullish_coalescing(b, l + 1);
    if (!r) r = pipeline(b, l + 1);
    return r;
  }

  // (subscript | "." IDENTIFIER | argument_list)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // subscript | "." IDENTIFIER | argument_list
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUBSCRIPT);
    if (!r) r = expression_1_0_1(b, l + 1);
    if (!r) r = argument_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "." IDENTIFIER
  private static boolean expression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // item_decorator_list? IDENTIFIER WHITESPACE* COLON WHITESPACE* field_type
  public static boolean field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition")) return false;
    if (!nextTokenIs(b, "<field definition>", AT, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DEFINITION, "<field definition>");
    r = field_definition_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && field_definition_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && field_definition_4(b, l + 1);
    r = r && field_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item_decorator_list?
  private static boolean field_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_0")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WHITESPACE*
  private static boolean field_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_2", c)) break;
    }
    return true;
  }

  // WHITESPACE*
  private static boolean field_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER ITEM_OPTIONAL? (ARITY COLLECTION_OPTIONAL?)?
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && field_type_1(b, l + 1);
    r = r && field_type_2(b, l + 1);
    exit_section_(b, m, FIELD_TYPE, r);
    return r;
  }

  // ITEM_OPTIONAL?
  private static boolean field_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_1")) return false;
    ITEM_OPTIONAL(b, l + 1);
    return true;
  }

  // (ARITY COLLECTION_OPTIONAL?)?
  private static boolean field_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_2")) return false;
    field_type_2_0(b, l + 1);
    return true;
  }

  // ARITY COLLECTION_OPTIONAL?
  private static boolean field_type_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ARITY(b, l + 1);
    r = r && field_type_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLLECTION_OPTIONAL?
  private static boolean field_type_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_2_0_1")) return false;
    COLLECTION_OPTIONAL(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "(" expression ")"
  public static boolean group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUP, "<group>");
    r = consumeToken(b, "(");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_OPEN WS_EOL? (IDENTIFIER (COMMA IDENTIFIER)* COMMA?)? WS_EOL? BLOCK_CLOSE WS_EOL? FROM_KEYWORD WS_EOL?
  public static boolean import_identifier_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_OPEN);
    r = r && import_identifier_list_1(b, l + 1);
    r = r && import_identifier_list_2(b, l + 1);
    r = r && import_identifier_list_3(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    r = r && import_identifier_list_5(b, l + 1);
    r = r && consumeToken(b, FROM_KEYWORD);
    r = r && import_identifier_list_7(b, l + 1);
    exit_section_(b, m, IMPORT_IDENTIFIER_LIST, r);
    return r;
  }

  // WS_EOL?
  private static boolean import_identifier_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_1")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // (IDENTIFIER (COMMA IDENTIFIER)* COMMA?)?
  private static boolean import_identifier_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_2")) return false;
    import_identifier_list_2_0(b, l + 1);
    return true;
  }

  // IDENTIFIER (COMMA IDENTIFIER)* COMMA?
  private static boolean import_identifier_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && import_identifier_list_2_0_1(b, l + 1);
    r = r && import_identifier_list_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean import_identifier_list_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_identifier_list_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_identifier_list_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean import_identifier_list_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean import_identifier_list_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // WS_EOL?
  private static boolean import_identifier_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_3")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // WS_EOL?
  private static boolean import_identifier_list_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_5")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // WS_EOL?
  private static boolean import_identifier_list_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_7")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IMPORT_KEYWORD ((WS_EOL? import_identifier_list WS_EOL?)|WHITESPACE+) STRING_LITERAL
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    if (!nextTokenIs(b, IMPORT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT_KEYWORD);
    r = r && import_statement_1(b, l + 1);
    r = r && consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  // (WS_EOL? import_identifier_list WS_EOL?)|WHITESPACE+
  private static boolean import_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_statement_1_0(b, l + 1);
    if (!r) r = import_statement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_EOL? import_identifier_list WS_EOL?
  private static boolean import_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_statement_1_0_0(b, l + 1);
    r = r && import_identifier_list(b, l + 1);
    r = r && import_statement_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_EOL?
  private static boolean import_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0_0")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // WS_EOL?
  private static boolean import_statement_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0_2")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // WHITESPACE+
  private static boolean import_statement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITESPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "import_statement_1_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // import_statement|let_declaration|model_definition|enum_definition|config_block|COMMENT|NEWLINE|WHITESPACE
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = import_statement(b, l + 1);
    if (!r) r = let_declaration(b, l + 1);
    if (!r) r = model_definition(b, l + 1);
    if (!r) r = enum_definition(b, l + 1);
    if (!r) r = config_block(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, WHITESPACE);
    return r;
  }

  /* ********************************************************** */
  // AT unit
  public static boolean item_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && unit(b, l + 1);
    exit_section_(b, m, ITEM_DECORATOR, r);
    return r;
  }

  /* ********************************************************** */
  // item_decorator (WS_EOL item_decorator)* WS_EOL
  public static boolean item_decorator_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_decorator(b, l + 1);
    r = r && item_decorator_list_1(b, l + 1);
    r = r && WS_EOL(b, l + 1);
    exit_section_(b, m, ITEM_DECORATOR_LIST, r);
    return r;
  }

  // (WS_EOL item_decorator)*
  private static boolean item_decorator_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_decorator_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "item_decorator_list_1", c)) break;
    }
    return true;
  }

  // WS_EOL item_decorator
  private static boolean item_decorator_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS_EOL(b, l + 1);
    r = r && item_decorator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LET_KEYWORD WHITESPACE+ IDENTIFIER WHITESPACE* EQUAL_SIGN WHITESPACE* expression
  public static boolean let_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration")) return false;
    if (!nextTokenIs(b, LET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET_KEYWORD);
    r = r && let_declaration_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && let_declaration_3(b, l + 1);
    r = r && consumeToken(b, EQUAL_SIGN);
    r = r && let_declaration_5(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, LET_DECLARATION, r);
    return r;
  }

  // WHITESPACE+
  private static boolean let_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITESPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITESPACE*
  private static boolean let_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_3", c)) break;
    }
    return true;
  }

  // WHITESPACE*
  private static boolean let_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING_LITERAL | NUMBER_LITERAL | BOOL_LITERAL | ARRAY_LITERAL | DICTIONARY_LITERAL | TUPLE_LITERAL | RANGE_LITERAL
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, NUMBER_LITERAL);
    if (!r) r = consumeToken(b, BOOL_LITERAL);
    if (!r) r = consumeToken(b, ARRAY_LITERAL);
    if (!r) r = consumeToken(b, DICTIONARY_LITERAL);
    if (!r) r = consumeToken(b, TUPLE_LITERAL);
    if (!r) r = consumeToken(b, RANGE_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // item_decorator_list? MODEL_KEYWORD WS_EOL model_name WS_EOL? BLOCK_OPEN WS_EOL? (block_decorator | field_definition)* WS_EOL? BLOCK_CLOSE
  public static boolean model_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition")) return false;
    if (!nextTokenIs(b, "<model definition>", AT, MODEL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_DEFINITION, "<model definition>");
    r = model_definition_0(b, l + 1);
    r = r && consumeToken(b, MODEL_KEYWORD);
    r = r && WS_EOL(b, l + 1);
    r = r && model_name(b, l + 1);
    r = r && model_definition_4(b, l + 1);
    r = r && consumeToken(b, BLOCK_OPEN);
    r = r && model_definition_6(b, l + 1);
    r = r && model_definition_7(b, l + 1);
    r = r && model_definition_8(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item_decorator_list?
  private static boolean model_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_0")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WS_EOL?
  private static boolean model_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_4")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // WS_EOL?
  private static boolean model_definition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_6")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  // (block_decorator | field_definition)*
  private static boolean model_definition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_definition_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_definition_7", c)) break;
    }
    return true;
  }

  // block_decorator | field_definition
  private static boolean model_definition_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_7_0")) return false;
    boolean r;
    r = block_decorator(b, l + 1);
    if (!r) r = field_definition(b, l + 1);
    return r;
  }

  // WS_EOL?
  private static boolean model_definition_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_8")) return false;
    WS_EOL(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean model_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODEL_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER WHITESPACE* COLON WS_EOL* expression
  public static boolean named_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && named_argument_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && named_argument_3(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, NAMED_ARGUMENT, r);
    return r;
  }

  // WHITESPACE*
  private static boolean named_argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_argument_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "named_argument_1", c)) break;
    }
    return true;
  }

  // WS_EOL*
  private static boolean named_argument_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_argument_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS_EOL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_argument_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression ("??" expression)+
  public static boolean nullish_coalescing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NULLISH_COALESCING, "<nullish coalescing>");
    r = expression(b, l + 1);
    r = r && nullish_coalescing_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("??" expression)+
  private static boolean nullish_coalescing_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nullish_coalescing_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!nullish_coalescing_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nullish_coalescing_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // "??" expression
  private static boolean nullish_coalescing_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "??");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOLLAR_SIGN unit
  public static boolean pipeline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline")) return false;
    if (!nextTokenIs(b, DOLLAR_SIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOLLAR_SIGN);
    r = r && unit(b, l + 1);
    exit_section_(b, m, PIPELINE, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean teoFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "teoFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "teoFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER (subscript | "." IDENTIFIER | argument_list)*
  public static boolean unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && unit_1(b, l + 1);
    exit_section_(b, m, UNIT, r);
    return r;
  }

  // (subscript | "." IDENTIFIER | argument_list)*
  private static boolean unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unit_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unit_1", c)) break;
    }
    return true;
  }

  // subscript | "." IDENTIFIER | argument_list
  private static boolean unit_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUBSCRIPT);
    if (!r) r = unit_1_0_1(b, l + 1);
    if (!r) r = argument_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "." IDENTIFIER
  private static boolean unit_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

}
