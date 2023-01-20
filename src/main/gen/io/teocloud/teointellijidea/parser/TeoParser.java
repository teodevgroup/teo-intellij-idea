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
  // named_argument | expression
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = named_argument(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PAREN_OPEN (argument (padded_comma argument)* padded_comma?)? PAREN_CLOSE
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

  // (argument (padded_comma argument)* padded_comma?)?
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    argument_list_1_0(b, l + 1);
    return true;
  }

  // argument (padded_comma argument)* padded_comma?
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument(b, l + 1);
    r = r && argument_list_1_0_1(b, l + 1);
    r = r && argument_list_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (padded_comma argument)*
  private static boolean argument_list_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1_0_1", c)) break;
    }
    return true;
  }

  // padded_comma argument
  private static boolean argument_list_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_comma(b, l + 1);
    r = r && argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // padded_comma?
  private static boolean argument_list_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0_2")) return false;
    padded_comma(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_brack_open (expression (padded_comma expression)* padded_comma?)? padded_brack_close
  public static boolean array_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal")) return false;
    if (!nextTokenIs(b, BRACK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_brack_open(b, l + 1);
    r = r && array_literal_1(b, l + 1);
    r = r && padded_brack_close(b, l + 1);
    exit_section_(b, m, ARRAY_LITERAL, r);
    return r;
  }

  // (expression (padded_comma expression)* padded_comma?)?
  private static boolean array_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1")) return false;
    array_literal_1_0(b, l + 1);
    return true;
  }

  // expression (padded_comma expression)* padded_comma?
  private static boolean array_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && array_literal_1_0_1(b, l + 1);
    r = r && array_literal_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (padded_comma expression)*
  private static boolean array_literal_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_literal_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_literal_1_0_1", c)) break;
    }
    return true;
  }

  // padded_comma expression
  private static boolean array_literal_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_comma(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // padded_comma?
  private static boolean array_literal_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_2")) return false;
    padded_comma(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // triple_line_comment_full_line triple_line_comment_full_line* WHITESPACE*
  public static boolean bad_doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_doc_comment")) return false;
    if (!nextTokenIs(b, "<bad doc comment>", TRIPLE_LINE_COMMENT, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BAD_DOC_COMMENT, "<bad doc comment>");
    r = triple_line_comment_full_line(b, l + 1);
    r = r && bad_doc_comment_1(b, l + 1);
    r = r && bad_doc_comment_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // triple_line_comment_full_line*
  private static boolean bad_doc_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_doc_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!triple_line_comment_full_line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bad_doc_comment_1", c)) break;
    }
    return true;
  }

  // WHITESPACE*
  private static boolean bad_doc_comment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_doc_comment_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "bad_doc_comment_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // AT identifier_unit
  public static boolean bad_top_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_top_decorator")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && identifier_unit(b, l + 1);
    exit_section_(b, m, BAD_TOP_DECORATOR, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean bad_top_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_top_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, BAD_TOP_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_AT identifier_unit
  public static boolean block_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_decorator")) return false;
    if (!nextTokenIs(b, DOUBLE_AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_AT);
    r = r && identifier_unit(b, l + 1);
    exit_section_(b, m, BLOCK_DECORATOR, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_LINE_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, DOUBLE_LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_LINE_COMMENT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // padded_block_open (ws_eol? (config_item|comment) NEWLINE)* padded_block_close
  public static boolean config_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_block_open(b, l + 1);
    r = r && config_block_1(b, l + 1);
    r = r && padded_block_close(b, l + 1);
    exit_section_(b, m, CONFIG_BLOCK, r);
    return r;
  }

  // (ws_eol? (config_item|comment) NEWLINE)*
  private static boolean config_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_1", c)) break;
    }
    return true;
  }

  // ws_eol? (config_item|comment) NEWLINE
  private static boolean config_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_block_1_0_0(b, l + 1);
    r = r && config_block_1_0_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean config_block_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  // config_item|comment
  private static boolean config_block_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0_1")) return false;
    boolean r;
    r = config_item(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CONFIG_KEYWORDS (WHITESPACE+ IDENTIFIER)? ws_eol+ config_block
  public static boolean config_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_DEFINITION, "<config definition>");
    r = CONFIG_KEYWORDS(b, l + 1);
    r = r && config_definition_1(b, l + 1);
    r = r && config_definition_2(b, l + 1);
    r = r && config_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WHITESPACE+ IDENTIFIER)?
  private static boolean config_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_1")) return false;
    config_definition_1_0(b, l + 1);
    return true;
  }

  // WHITESPACE+ IDENTIFIER
  private static boolean config_definition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_definition_1_0_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITESPACE+
  private static boolean config_definition_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITESPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "config_definition_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol+
  private static boolean config_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws_eol(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_definition_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment? config_item_name WHITESPACE+ expression
  public static boolean config_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ITEM, "<config item>");
    r = config_item_0(b, l + 1);
    r = r && config_item_name(b, l + 1);
    r = r && config_item_2(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean config_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // WHITESPACE+
  private static boolean config_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITESPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "config_item_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean config_item_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONFIG_ITEM_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // padded_block_open (named_expression (padded_comma named_expression)* padded_comma?)? padded_block_close
  public static boolean dictionary_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_block_open(b, l + 1);
    r = r && dictionary_literal_1(b, l + 1);
    r = r && padded_block_close(b, l + 1);
    exit_section_(b, m, DICTIONARY_LITERAL, r);
    return r;
  }

  // (named_expression (padded_comma named_expression)* padded_comma?)?
  private static boolean dictionary_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal_1")) return false;
    dictionary_literal_1_0(b, l + 1);
    return true;
  }

  // named_expression (padded_comma named_expression)* padded_comma?
  private static boolean dictionary_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_expression(b, l + 1);
    r = r && dictionary_literal_1_0_1(b, l + 1);
    r = r && dictionary_literal_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (padded_comma named_expression)*
  private static boolean dictionary_literal_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dictionary_literal_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_literal_1_0_1", c)) break;
    }
    return true;
  }

  // padded_comma named_expression
  private static boolean dictionary_literal_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_comma(b, l + 1);
    r = r && named_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // padded_comma?
  private static boolean dictionary_literal_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal_1_0_2")) return false;
    padded_comma(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // triple_line_comment_full_line triple_line_comment_full_line* WHITESPACE*
  public static boolean doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment")) return false;
    if (!nextTokenIs(b, "<doc comment>", TRIPLE_LINE_COMMENT, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOC_COMMENT, "<doc comment>");
    r = triple_line_comment_full_line(b, l + 1);
    r = r && doc_comment_1(b, l + 1);
    r = r && doc_comment_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // triple_line_comment_full_line*
  private static boolean doc_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!triple_line_comment_full_line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc_comment_1", c)) break;
    }
    return true;
  }

  // WHITESPACE*
  private static boolean doc_comment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "doc_comment_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DOT IDENTIFIER
  public static boolean enum_choice_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_choice_literal")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, ENUM_CHOICE_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment? item_decorator_list? ENUM_KEYWORD ws_eol enum_name ws_eol? enum_definition_block
  public static boolean enum_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = enum_definition_0(b, l + 1);
    r = r && enum_definition_1(b, l + 1);
    r = r && consumeToken(b, ENUM_KEYWORD);
    r = r && ws_eol(b, l + 1);
    r = r && enum_name(b, l + 1);
    r = r && enum_definition_5(b, l + 1);
    r = r && enum_definition_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean enum_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean enum_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean enum_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_5")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_block_open (block_decorator | enum_value_declaration | comment | ws_eol)* padded_block_close
  public static boolean enum_definition_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_block")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_block_open(b, l + 1);
    r = r && enum_definition_block_1(b, l + 1);
    r = r && padded_block_close(b, l + 1);
    exit_section_(b, m, ENUM_DEFINITION_BLOCK, r);
    return r;
  }

  // (block_decorator | enum_value_declaration | comment | ws_eol)*
  private static boolean enum_definition_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_definition_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_definition_block_1", c)) break;
    }
    return true;
  }

  // block_decorator | enum_value_declaration | comment | ws_eol
  private static boolean enum_definition_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_block_1_0")) return false;
    boolean r;
    r = block_decorator(b, l + 1);
    if (!r) r = enum_value_declaration(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = ws_eol(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean enum_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment? item_decorator_list? ws_eol? IDENTIFIER NEWLINE
  public static boolean enum_value_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_VALUE_DECLARATION, "<enum value declaration>");
    r = enum_value_declaration_0(b, l + 1);
    r = r && enum_value_declaration_1(b, l + 1);
    r = r && enum_value_declaration_2(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean enum_value_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean enum_value_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean enum_value_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration_2")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (nullish_coalescing | literal | IDENTIFIER | group | pipeline) (subscript | "." IDENTIFIER | argument_list)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nullish_coalescing | literal | IDENTIFIER | group | pipeline
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    r = nullish_coalescing(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = group(b, l + 1);
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
    r = subscript(b, l + 1);
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
  // doc_comment? item_decorator_list? field_name WHITESPACE* COLON WHITESPACE* field_type
  public static boolean field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DEFINITION, "<field definition>");
    r = field_definition_0(b, l + 1);
    r = r && field_definition_1(b, l + 1);
    r = r && field_name(b, l + 1);
    r = r && field_definition_3(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && field_definition_5(b, l + 1);
    r = r && field_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean field_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean field_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WHITESPACE*
  private static boolean field_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_3", c)) break;
    }
    return true;
  }

  // WHITESPACE*
  private static boolean field_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean field_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FIELD_NAME, r);
    return r;
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
  // initial_unit_identifier (subscript | DOT IDENTIFIER | argument_list)*
  public static boolean identifier_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_unit")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = initial_unit_identifier(b, l + 1);
    r = r && identifier_unit_1(b, l + 1);
    exit_section_(b, m, IDENTIFIER_UNIT, r);
    return r;
  }

  // (subscript | DOT IDENTIFIER | argument_list)*
  private static boolean identifier_unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier_unit_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifier_unit_1", c)) break;
    }
    return true;
  }

  // subscript | DOT IDENTIFIER | argument_list
  private static boolean identifier_unit_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_unit_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subscript(b, l + 1);
    if (!r) r = parseTokens(b, 0, DOT, IDENTIFIER);
    if (!r) r = argument_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // import_identifiers_block ws_eol? FROM_KEYWORD ws_eol?
  public static boolean import_identifier_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_identifiers_block(b, l + 1);
    r = r && import_identifier_list_1(b, l + 1);
    r = r && consumeToken(b, FROM_KEYWORD);
    r = r && import_identifier_list_3(b, l + 1);
    exit_section_(b, m, IMPORT_IDENTIFIER_LIST, r);
    return r;
  }

  // ws_eol?
  private static boolean import_identifier_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_1")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean import_identifier_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_3")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_block_open (IDENTIFIER (COMMA IDENTIFIER)* COMMA?)? padded_block_close
  public static boolean import_identifiers_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_block_open(b, l + 1);
    r = r && import_identifiers_block_1(b, l + 1);
    r = r && padded_block_close(b, l + 1);
    exit_section_(b, m, IMPORT_IDENTIFIERS_BLOCK, r);
    return r;
  }

  // (IDENTIFIER (COMMA IDENTIFIER)* COMMA?)?
  private static boolean import_identifiers_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block_1")) return false;
    import_identifiers_block_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER (COMMA IDENTIFIER)* COMMA?
  private static boolean import_identifiers_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && import_identifiers_block_1_0_1(b, l + 1);
    r = r && import_identifiers_block_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean import_identifiers_block_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_identifiers_block_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_identifiers_block_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean import_identifiers_block_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean import_identifiers_block_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IMPORT_KEYWORD ((ws_eol? import_identifier_list ws_eol?)|WHITESPACE+) STRING_LITERAL
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

  // (ws_eol? import_identifier_list ws_eol?)|WHITESPACE+
  private static boolean import_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_statement_1_0(b, l + 1);
    if (!r) r = import_statement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol? import_identifier_list ws_eol?
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

  // ws_eol?
  private static boolean import_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean import_statement_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0_2")) return false;
    ws_eol(b, l + 1);
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
  // IDENTIFIER
  public static boolean initial_unit_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initial_unit_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, INITIAL_UNIT_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // import_statement|let_declaration|model_definition|enum_definition|config_definition|comment|bad_doc_comment|NEWLINE|WHITESPACE|bad_top_identifier|bad_top_decorator
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = import_statement(b, l + 1);
    if (!r) r = let_declaration(b, l + 1);
    if (!r) r = model_definition(b, l + 1);
    if (!r) r = enum_definition(b, l + 1);
    if (!r) r = config_definition(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = bad_doc_comment(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, WHITESPACE);
    if (!r) r = bad_top_identifier(b, l + 1);
    if (!r) r = bad_top_decorator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // AT identifier_unit
  public static boolean item_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && identifier_unit(b, l + 1);
    exit_section_(b, m, ITEM_DECORATOR, r);
    return r;
  }

  /* ********************************************************** */
  // item_decorator (ws_eol item_decorator)* ws_eol
  public static boolean item_decorator_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_decorator(b, l + 1);
    r = r && item_decorator_list_1(b, l + 1);
    r = r && ws_eol(b, l + 1);
    exit_section_(b, m, ITEM_DECORATOR_LIST, r);
    return r;
  }

  // (ws_eol item_decorator)*
  private static boolean item_decorator_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_decorator_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "item_decorator_list_1", c)) break;
    }
    return true;
  }

  // ws_eol item_decorator
  private static boolean item_decorator_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws_eol(b, l + 1);
    r = r && item_decorator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment? LET_KEYWORD WHITESPACE+ IDENTIFIER WHITESPACE* EQUAL_SIGN WHITESPACE* expression
  public static boolean let_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LET_DECLARATION, "<let declaration>");
    r = let_declaration_0(b, l + 1);
    r = r && consumeToken(b, LET_KEYWORD);
    r = r && let_declaration_2(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && let_declaration_4(b, l + 1);
    r = r && consumeToken(b, EQUAL_SIGN);
    r = r && let_declaration_6(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean let_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // WHITESPACE+
  private static boolean let_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITESPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITESPACE*
  private static boolean let_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_4", c)) break;
    }
    return true;
  }

  // WHITESPACE*
  private static boolean let_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING_LITERAL | NUMERIC_LITERAL | BOOL_LITERAL | array_literal | dictionary_literal | tuple_literal | RANGE_LITERAL | enum_choice_literal
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, NUMERIC_LITERAL);
    if (!r) r = consumeToken(b, BOOL_LITERAL);
    if (!r) r = array_literal(b, l + 1);
    if (!r) r = dictionary_literal(b, l + 1);
    if (!r) r = tuple_literal(b, l + 1);
    if (!r) r = consumeToken(b, RANGE_LITERAL);
    if (!r) r = enum_choice_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc_comment? item_decorator_list? MODEL_KEYWORD ws_eol model_name ws_eol? model_definition_block
  public static boolean model_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_DEFINITION, "<model definition>");
    r = model_definition_0(b, l + 1);
    r = r && model_definition_1(b, l + 1);
    r = r && consumeToken(b, MODEL_KEYWORD);
    r = r && ws_eol(b, l + 1);
    r = r && model_name(b, l + 1);
    r = r && model_definition_5(b, l + 1);
    r = r && model_definition_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean model_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean model_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean model_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_5")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_block_open (block_decorator | field_definition | comment | ws_eol)* padded_block_close
  public static boolean model_definition_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_block")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_block_open(b, l + 1);
    r = r && model_definition_block_1(b, l + 1);
    r = r && padded_block_close(b, l + 1);
    exit_section_(b, m, MODEL_DEFINITION_BLOCK, r);
    return r;
  }

  // (block_decorator | field_definition | comment | ws_eol)*
  private static boolean model_definition_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_definition_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_definition_block_1", c)) break;
    }
    return true;
  }

  // block_decorator | field_definition | comment | ws_eol
  private static boolean model_definition_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_block_1_0")) return false;
    boolean r;
    r = block_decorator(b, l + 1);
    if (!r) r = field_definition(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = ws_eol(b, l + 1);
    return r;
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
  // IDENTIFIER padded_colon expression
  public static boolean named_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && padded_colon(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, NAMED_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // expression ws_eol* padded_colon ws_eol* expression
  public static boolean named_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED_EXPRESSION, "<named expression>");
    r = expression(b, l + 1);
    r = r && named_expression_1(b, l + 1);
    r = r && padded_colon(b, l + 1);
    r = r && named_expression_3(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ws_eol*
  private static boolean named_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_expression_1", c)) break;
    }
    return true;
  }

  // ws_eol*
  private static boolean named_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_expression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_expression_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // unit (ws_eol* DOUBLE_QUESTION ws_eol* unit)+
  public static boolean nullish_coalescing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NULLISH_COALESCING, "<nullish coalescing>");
    r = unit(b, l + 1);
    r = r && nullish_coalescing_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ws_eol* DOUBLE_QUESTION ws_eol* unit)+
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

  // ws_eol* DOUBLE_QUESTION ws_eol* unit
  private static boolean nullish_coalescing_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nullish_coalescing_1_0_0(b, l + 1);
    r = r && consumeToken(b, DOUBLE_QUESTION);
    r = r && nullish_coalescing_1_0_2(b, l + 1);
    r = r && unit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol*
  private static boolean nullish_coalescing_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nullish_coalescing_1_0_0", c)) break;
    }
    return true;
  }

  // ws_eol*
  private static boolean nullish_coalescing_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nullish_coalescing_1_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ws_eol? BLOCK_CLOSE
  static boolean padded_block_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_block_close")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_block_close_0(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_block_close_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_block_close_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BLOCK_OPEN ws_eol?
  static boolean padded_block_open(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_block_open")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_OPEN);
    r = r && padded_block_open_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_block_open_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_block_open_1")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ws_eol? BRACK_CLOSE
  static boolean padded_brack_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_brack_close")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_brack_close_0(b, l + 1);
    r = r && consumeToken(b, BRACK_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_brack_close_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_brack_close_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BRACK_OPEN ws_eol?
  static boolean padded_brack_open(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_brack_open")) return false;
    if (!nextTokenIs(b, BRACK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACK_OPEN);
    r = r && padded_brack_open_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_brack_open_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_brack_open_1")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ws_eol? COLON ws_eol?
  static boolean padded_colon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_colon")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_colon_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && padded_colon_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_colon_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_colon_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean padded_colon_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_colon_2")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ws_eol? COMMA ws_eol?
  static boolean padded_comma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_comma")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_comma_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && padded_comma_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_comma_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_comma_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  // ws_eol?
  private static boolean padded_comma_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_comma_2")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ws_eol? PAREN_CLOSE
  static boolean padded_paren_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_paren_close")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_paren_close_0(b, l + 1);
    r = r && consumeToken(b, PAREN_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_paren_close_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_paren_close_0")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PAREN_OPEN ws_eol?
  static boolean padded_paren_open(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_paren_open")) return false;
    if (!nextTokenIs(b, PAREN_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_OPEN);
    r = r && padded_paren_open_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws_eol?
  private static boolean padded_paren_open_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_paren_open_1")) return false;
    ws_eol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DOLLAR_SIGN identifier_unit
  public static boolean pipeline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline")) return false;
    if (!nextTokenIs(b, DOLLAR_SIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOLLAR_SIGN);
    r = r && identifier_unit(b, l + 1);
    exit_section_(b, m, PIPELINE, r);
    return r;
  }

  /* ********************************************************** */
  // BRACK_OPEN ws_eol* expression ws_eol* BRACK_CLOSE
  public static boolean subscript(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript")) return false;
    if (!nextTokenIs(b, BRACK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACK_OPEN);
    r = r && subscript_1(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && subscript_3(b, l + 1);
    r = r && consumeToken(b, BRACK_CLOSE);
    exit_section_(b, m, SUBSCRIPT, r);
    return r;
  }

  // ws_eol*
  private static boolean subscript_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subscript_1", c)) break;
    }
    return true;
  }

  // ws_eol*
  private static boolean subscript_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws_eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subscript_3", c)) break;
    }
    return true;
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
  // WHITESPACE* TRIPLE_LINE_COMMENT NEWLINE
  public static boolean triple_line_comment_full_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "triple_line_comment_full_line")) return false;
    if (!nextTokenIs(b, "<triple line comment full line>", TRIPLE_LINE_COMMENT, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLE_LINE_COMMENT_FULL_LINE, "<triple line comment full line>");
    r = triple_line_comment_full_line_0(b, l + 1);
    r = r && consumeTokens(b, 0, TRIPLE_LINE_COMMENT, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITESPACE*
  private static boolean triple_line_comment_full_line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "triple_line_comment_full_line_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "triple_line_comment_full_line_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // padded_paren_open (padded_comma | (expression padded_comma (expression (padded_comma expression)* padded_comma?)*)) padded_paren_close
  public static boolean tuple_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal")) return false;
    if (!nextTokenIs(b, PAREN_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_paren_open(b, l + 1);
    r = r && tuple_literal_1(b, l + 1);
    r = r && padded_paren_close(b, l + 1);
    exit_section_(b, m, TUPLE_LITERAL, r);
    return r;
  }

  // padded_comma | (expression padded_comma (expression (padded_comma expression)* padded_comma?)*)
  private static boolean tuple_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_comma(b, l + 1);
    if (!r) r = tuple_literal_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression padded_comma (expression (padded_comma expression)* padded_comma?)*
  private static boolean tuple_literal_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && padded_comma(b, l + 1);
    r = r && tuple_literal_1_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (padded_comma expression)* padded_comma?)*
  private static boolean tuple_literal_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_literal_1_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_literal_1_1_2", c)) break;
    }
    return true;
  }

  // expression (padded_comma expression)* padded_comma?
  private static boolean tuple_literal_1_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && tuple_literal_1_1_2_0_1(b, l + 1);
    r = r && tuple_literal_1_1_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (padded_comma expression)*
  private static boolean tuple_literal_1_1_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1_1_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_literal_1_1_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_literal_1_1_2_0_1", c)) break;
    }
    return true;
  }

  // padded_comma expression
  private static boolean tuple_literal_1_1_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1_1_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_comma(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // padded_comma?
  private static boolean tuple_literal_1_1_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_1_1_2_0_2")) return false;
    padded_comma(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (group | NULL_LITERAL | BOOL_LITERAL | NUMERIC_LITERAL | STRING_LITERAL | enum_choice_literal | tuple_literal | IDENTIFIER) (subscript | DOT IDENTIFIER | argument_list)*
  public static boolean unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNIT, "<unit>");
    r = unit_0(b, l + 1);
    r = r && unit_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // group | NULL_LITERAL | BOOL_LITERAL | NUMERIC_LITERAL | STRING_LITERAL | enum_choice_literal | tuple_literal | IDENTIFIER
  private static boolean unit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_0")) return false;
    boolean r;
    r = group(b, l + 1);
    if (!r) r = consumeToken(b, NULL_LITERAL);
    if (!r) r = consumeToken(b, BOOL_LITERAL);
    if (!r) r = consumeToken(b, NUMERIC_LITERAL);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = enum_choice_literal(b, l + 1);
    if (!r) r = tuple_literal(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  // (subscript | DOT IDENTIFIER | argument_list)*
  private static boolean unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unit_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unit_1", c)) break;
    }
    return true;
  }

  // subscript | DOT IDENTIFIER | argument_list
  private static boolean unit_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subscript(b, l + 1);
    if (!r) r = parseTokens(b, 0, DOT, IDENTIFIER);
    if (!r) r = argument_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NEWLINE | WHITESPACE)+
  static boolean ws_eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ws_eol")) return false;
    if (!nextTokenIs(b, "", NEWLINE, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws_eol_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ws_eol_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ws_eol", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE | WHITESPACE
  private static boolean ws_eol_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ws_eol_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, WHITESPACE);
    return r;
  }

}
