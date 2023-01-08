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
  // "(" (argument | named_argument)* ")"
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = consumeToken(b, "(");
    r = r && argument_list_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
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
  // "@@"unit
  public static boolean block_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_decorator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_DECORATOR, "<block decorator>");
    r = consumeToken(b, "@@");
    r = r && unit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONFIG_KEYWORDS IDENTIFIER? { <pair>* }
  public static boolean config_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block")) return false;
    if (!nextTokenIs(b, CONFIG_KEYWORDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONFIG_KEYWORDS);
    r = r && config_block_1(b, l + 1);
    r = r && config_block_2(b, l + 1);
    exit_section_(b, m, CONFIG_BLOCK, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean config_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  // <pair>*
  private static boolean config_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, _PAIR_)) break;
      if (!empty_element_parsed_guard_(b, "config_block_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LET_KEYWORD IDENTIFIER EQUAL_SIGN expression
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    if (!nextTokenIs(b, LET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LET_KEYWORD, IDENTIFIER, EQUAL_SIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // item_decorator* ENUM_KEYWORD IDENTIFIER { (ENUM_MEMBER_DEFINITION)* }
  public static boolean enum_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition")) return false;
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
  // (literal | IDENTIFIER | group | nullish_coalescing | pipeline) (subscript | "." identifier | argument_list)*
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

  // (subscript | "." identifier | argument_list)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // subscript | "." identifier | argument_list
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

  // "." identifier
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
  // item_decorator* IDENTIFIER ":" type
  public static boolean field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DEFINITION, "<field definition>");
    r = field_definition_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ":");
    r = r && type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item_decorator*
  private static boolean field_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_decorator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_0", c)) break;
    }
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
  // IMPORT_KEYWORD { IDENTIFIER * } FROM_KEYWORD STRING_LITERAL
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, IMPORT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT_KEYWORD);
    r = r && import_1(b, l + 1);
    r = r && consumeTokens(b, 0, FROM_KEYWORD, STRING_LITERAL);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  // IDENTIFIER *
  private static boolean import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IDENTIFIER)) break;
      if (!empty_element_parsed_guard_(b, "import_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // import|constant|model_definition|enum_definition|config_block|COMMENT|EOL|WS|WS_EOL|
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_$(b, l + 1);
    if (!r) r = constant(b, l + 1);
    if (!r) r = model_definition(b, l + 1);
    if (!r) r = enum_definition(b, l + 1);
    if (!r) r = config_block(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, WS);
    if (!r) r = consumeToken(b, WS_EOL);
    if (!r) r = consumeToken(b, ITEM__9_0);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "@"unit
  public static boolean item_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM_DECORATOR, "<item decorator>");
    r = consumeToken(b, "@");
    r = r && unit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // item_decorator* MODEL_KEYWORD IDENTIFIER { (block_decorator | field_definition)+ }
  public static boolean model_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_DEFINITION, "<model definition>");
    r = model_definition_0(b, l + 1);
    r = r && consumeTokens(b, 0, MODEL_KEYWORD, IDENTIFIER);
    r = r && model_definition_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item_decorator*
  private static boolean model_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_decorator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_definition_0", c)) break;
    }
    return true;
  }

  // (block_decorator | field_definition)+
  private static boolean model_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = model_definition_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!model_definition_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_definition_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // block_decorator | field_definition
  private static boolean model_definition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_3_0")) return false;
    boolean r;
    r = block_decorator(b, l + 1);
    if (!r) r = field_definition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ":" expression
  public static boolean named_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ":");
    r = r && expression(b, l + 1);
    exit_section_(b, m, NAMED_ARGUMENT, r);
    return r;
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
  // "$"unit
  public static boolean pipeline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PIPELINE, "<pipeline>");
    r = consumeToken(b, "$");
    r = r && unit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // IDENTIFIER ITEM_OPTIONAL? (ARITY COLLECTION_OPTIONAL?)?
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && type_1(b, l + 1);
    r = r && type_2(b, l + 1);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  // ITEM_OPTIONAL?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    consumeToken(b, ITEM_OPTIONAL);
    return true;
  }

  // (ARITY COLLECTION_OPTIONAL?)?
  private static boolean type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_2")) return false;
    type_2_0(b, l + 1);
    return true;
  }

  // ARITY COLLECTION_OPTIONAL?
  private static boolean type_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARITY);
    r = r && type_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLLECTION_OPTIONAL?
  private static boolean type_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_2_0_1")) return false;
    consumeToken(b, COLLECTION_OPTIONAL);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER (subscript | "." identifier | argument_list)*
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

  // (subscript | "." identifier | argument_list)*
  private static boolean unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unit_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unit_1", c)) break;
    }
    return true;
  }

  // subscript | "." identifier | argument_list
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

  // "." identifier
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
