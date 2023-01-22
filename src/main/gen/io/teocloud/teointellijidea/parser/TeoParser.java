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
  // (LBRACE RBRACE)|(LBRACKET RBRACKET)
  public static boolean ARITY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARITY")) return false;
    if (!nextTokenIs(b, "<arity>", LBRACE, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARITY, "<arity>");
    r = ARITY_0(b, l + 1);
    if (!r) r = ARITY_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE RBRACE
  private static boolean ARITY_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARITY_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACE, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET RBRACKET
  private static boolean ARITY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARITY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // QM
  public static boolean COLLECTION_OPTIONAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COLLECTION_OPTIONAL")) return false;
    if (!nextTokenIs(b, QM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QM);
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
  // EOL | WSC
  public static boolean EOL_WSC(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EOL_WSC")) return false;
    if (!nextTokenIs(b, "<eol wsc>", EOL, WSC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EOL_WSC, "<eol wsc>");
    r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, WSC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QM
  public static boolean ITEM_OPTIONAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_OPTIONAL")) return false;
    if (!nextTokenIs(b, QM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QM);
    exit_section_(b, m, ITEM_OPTIONAL, r);
    return r;
  }

  /* ********************************************************** */
  // EOL_WSC+
  public static boolean WS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WS")) return false;
    if (!nextTokenIs(b, "<ws>", EOL, WSC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WS, "<ws>");
    r = EOL_WSC(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!EOL_WSC(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "WS", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
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
  // LPAREN (argument (padded_comma argument)* padded_comma?)? RPAREN
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && argument_list_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
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
  // padded_lbracket (expression (padded_comma expression)* padded_comma?)? padded_rbracket
  public static boolean array_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lbracket(b, l + 1);
    r = r && array_literal_1(b, l + 1);
    r = r && padded_rbracket(b, l + 1);
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
  // padded_doc_comment padded_doc_comment* WS*
  public static boolean bad_doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_doc_comment")) return false;
    if (!nextTokenIs(b, "<bad doc comment>", DOC_COMMENT, WSC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BAD_DOC_COMMENT, "<bad doc comment>");
    r = padded_doc_comment(b, l + 1);
    r = r && bad_doc_comment_1(b, l + 1);
    r = r && bad_doc_comment_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // padded_doc_comment*
  private static boolean bad_doc_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_doc_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!padded_doc_comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bad_doc_comment_1", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean bad_doc_comment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_doc_comment_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
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
  // ATAT identifier_unit
  public static boolean block_decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_decorator")) return false;
    if (!nextTokenIs(b, ATAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATAT);
    r = r && identifier_unit(b, l + 1);
    exit_section_(b, m, BLOCK_DECORATOR, r);
    return r;
  }

  /* ********************************************************** */
  // "String" | "ObjectId" | "Int" | "Float" | "Date" | "DateTime"
  public static boolean builtin_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_TYPE, "<builtin type>");
    r = consumeToken(b, "String");
    if (!r) r = consumeToken(b, "ObjectId");
    if (!r) r = consumeToken(b, "Int");
    if (!r) r = consumeToken(b, "Float");
    if (!r) r = consumeToken(b, "Date");
    if (!r) r = consumeToken(b, "DateTime");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LINE_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // padded_lbrace (WS? (config_item|comment) EOL)* padded_rbrace
  public static boolean config_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lbrace(b, l + 1);
    r = r && config_block_1(b, l + 1);
    r = r && padded_rbrace(b, l + 1);
    exit_section_(b, m, CONFIG_BLOCK, r);
    return r;
  }

  // (WS? (config_item|comment) EOL)*
  private static boolean config_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_1", c)) break;
    }
    return true;
  }

  // WS? (config_item|comment) EOL
  private static boolean config_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_block_1_0_0(b, l + 1);
    r = r && config_block_1_0_1(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean config_block_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_1_0_0")) return false;
    WS(b, l + 1);
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
  // CONFIG_KEYWORDS (WS+ config_name)? WS+ config_block
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

  // (WS+ config_name)?
  private static boolean config_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_1")) return false;
    config_definition_1_0(b, l + 1);
    return true;
  }

  // WS+ config_name
  private static boolean config_definition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_definition_1_0_0(b, l + 1);
    r = r && config_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS+
  private static boolean config_definition_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_definition_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WS+
  private static boolean config_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_definition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_definition_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment_block? config_item_name WS+ expression
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

  // doc_comment_block?
  private static boolean config_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item_0")) return false;
    doc_comment_block(b, l + 1);
    return true;
  }

  // WS+
  private static boolean config_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
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
  // IDENTIFIER
  public static boolean config_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONFIG_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // padded_lbrace (named_expression (padded_comma named_expression)* padded_comma?)? padded_rbrace
  public static boolean dictionary_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_literal")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lbrace(b, l + 1);
    r = r && dictionary_literal_1(b, l + 1);
    r = r && padded_rbrace(b, l + 1);
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
  // padded_doc_comment padded_doc_comment* WS*
  public static boolean doc_comment_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_block")) return false;
    if (!nextTokenIs(b, "<doc comment block>", DOC_COMMENT, WSC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOC_COMMENT_BLOCK, "<doc comment block>");
    r = padded_doc_comment(b, l + 1);
    r = r && doc_comment_block_1(b, l + 1);
    r = r && doc_comment_block_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // padded_doc_comment*
  private static boolean doc_comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!padded_doc_comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc_comment_block_1", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean doc_comment_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc_comment_block_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DOT enum_member_name
  public static boolean enum_choice_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_choice_literal")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && enum_member_name(b, l + 1);
    exit_section_(b, m, ENUM_CHOICE_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment_block? item_decorator_list? ENUM_KEYWORD WS enum_name WS? enum_definition_block
  public static boolean enum_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = enum_definition_0(b, l + 1);
    r = r && enum_definition_1(b, l + 1);
    r = r && consumeToken(b, ENUM_KEYWORD);
    r = r && WS(b, l + 1);
    r = r && enum_name(b, l + 1);
    r = r && enum_definition_5(b, l + 1);
    r = r && enum_definition_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment_block?
  private static boolean enum_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_0")) return false;
    doc_comment_block(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean enum_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WS?
  private static boolean enum_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_5")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_lbrace (block_decorator | enum_value_declaration | comment | WS)* padded_rbrace
  public static boolean enum_definition_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lbrace(b, l + 1);
    r = r && enum_definition_block_1(b, l + 1);
    r = r && padded_rbrace(b, l + 1);
    exit_section_(b, m, ENUM_DEFINITION_BLOCK, r);
    return r;
  }

  // (block_decorator | enum_value_declaration | comment | WS)*
  private static boolean enum_definition_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_definition_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_definition_block_1", c)) break;
    }
    return true;
  }

  // block_decorator | enum_value_declaration | comment | WS
  private static boolean enum_definition_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_block_1_0")) return false;
    boolean r;
    r = block_decorator(b, l + 1);
    if (!r) r = enum_value_declaration(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = WS(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean enum_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean enum_member_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_member_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_MEMBER_NAME, r);
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
  // doc_comment_block? item_decorator_list? WS? enum_identifier EOL
  public static boolean enum_value_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_VALUE_DECLARATION, "<enum value declaration>");
    r = enum_value_declaration_0(b, l + 1);
    r = r && enum_value_declaration_1(b, l + 1);
    r = r && enum_value_declaration_2(b, l + 1);
    r = r && enum_identifier(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment_block?
  private static boolean enum_value_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration_0")) return false;
    doc_comment_block(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean enum_value_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WS?
  private static boolean enum_value_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_declaration_2")) return false;
    WS(b, l + 1);
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
  // doc_comment_block? item_decorator_list? FIELD_NAME WS* COLON WS* field_type
  public static boolean field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DEFINITION, "<field definition>");
    r = field_definition_0(b, l + 1);
    r = r && field_definition_1(b, l + 1);
    r = r && consumeToken(b, FIELD_NAME);
    r = r && field_definition_3(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && field_definition_5(b, l + 1);
    r = r && field_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment_block?
  private static boolean field_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_0")) return false;
    doc_comment_block(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean field_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WS*
  private static boolean field_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_3", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean field_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_definition_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (builtin_type | user_type) ITEM_OPTIONAL? (ARITY COLLECTION_OPTIONAL?)?
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE, "<field type>");
    r = field_type_0(b, l + 1);
    r = r && field_type_1(b, l + 1);
    r = r && field_type_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // builtin_type | user_type
  private static boolean field_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_0")) return false;
    boolean r;
    r = builtin_type(b, l + 1);
    if (!r) r = user_type(b, l + 1);
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
  // import_identifiers_block WS? FROM_KEYWORD WS?
  public static boolean import_identifier_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_identifiers_block(b, l + 1);
    r = r && import_identifier_list_1(b, l + 1);
    r = r && consumeToken(b, FROM_KEYWORD);
    r = r && import_identifier_list_3(b, l + 1);
    exit_section_(b, m, IMPORT_IDENTIFIER_LIST, r);
    return r;
  }

  // WS?
  private static boolean import_identifier_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_1")) return false;
    WS(b, l + 1);
    return true;
  }

  // WS?
  private static boolean import_identifier_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifier_list_3")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_lbrace (IDENTIFIER (COMMA IDENTIFIER)* COMMA?)? padded_rbrace
  public static boolean import_identifiers_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_identifiers_block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lbrace(b, l + 1);
    r = r && import_identifiers_block_1(b, l + 1);
    r = r && padded_rbrace(b, l + 1);
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
  // IMPORT_KEYWORD ((WS? import_identifier_list WS?)|WS+) STRING_LITERAL
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

  // (WS? import_identifier_list WS?)|WS+
  private static boolean import_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_statement_1_0(b, l + 1);
    if (!r) r = import_statement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS? import_identifier_list WS?
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

  // WS?
  private static boolean import_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0_0")) return false;
    WS(b, l + 1);
    return true;
  }

  // WS?
  private static boolean import_statement_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_0_2")) return false;
    WS(b, l + 1);
    return true;
  }

  // WS+
  private static boolean import_statement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
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
  // import_statement|let_declaration|model_definition|enum_definition|config_definition|comment|bad_doc_comment|EOL|WSC|EXCL|CRANGE|ORANGE|bad_top_identifier|bad_top_decorator
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
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, WSC);
    if (!r) r = consumeToken(b, EXCL);
    if (!r) r = consumeToken(b, CRANGE);
    if (!r) r = consumeToken(b, ORANGE);
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
  // item_decorator (WS item_decorator)* WS
  public static boolean item_decorator_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_decorator(b, l + 1);
    r = r && item_decorator_list_1(b, l + 1);
    r = r && WS(b, l + 1);
    exit_section_(b, m, ITEM_DECORATOR_LIST, r);
    return r;
  }

  // (WS item_decorator)*
  private static boolean item_decorator_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_decorator_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "item_decorator_list_1", c)) break;
    }
    return true;
  }

  // WS item_decorator
  private static boolean item_decorator_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_decorator_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS(b, l + 1);
    r = r && item_decorator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_comment_block? LET_KEYWORD WS+ IDENTIFIER WS* EQ WS* expression
  public static boolean let_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LET_DECLARATION, "<let declaration>");
    r = let_declaration_0(b, l + 1);
    r = r && consumeToken(b, LET_KEYWORD);
    r = r && let_declaration_2(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && let_declaration_4(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && let_declaration_6(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment_block?
  private static boolean let_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_0")) return false;
    doc_comment_block(b, l + 1);
    return true;
  }

  // WS+
  private static boolean let_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WS(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WS*
  private static boolean let_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_4", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean let_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
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
  // doc_comment_block? item_decorator_list? MODEL_KEYWORD WS model_name WS? model_definition_block
  public static boolean model_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_DEFINITION, "<model definition>");
    r = model_definition_0(b, l + 1);
    r = r && model_definition_1(b, l + 1);
    r = r && consumeToken(b, MODEL_KEYWORD);
    r = r && WS(b, l + 1);
    r = r && model_name(b, l + 1);
    r = r && model_definition_5(b, l + 1);
    r = r && model_definition_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment_block?
  private static boolean model_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_0")) return false;
    doc_comment_block(b, l + 1);
    return true;
  }

  // item_decorator_list?
  private static boolean model_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_1")) return false;
    item_decorator_list(b, l + 1);
    return true;
  }

  // WS?
  private static boolean model_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_5")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // padded_lbrace (block_decorator | field_definition | comment | WS)* padded_rbrace
  public static boolean model_definition_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lbrace(b, l + 1);
    r = r && model_definition_block_1(b, l + 1);
    r = r && padded_rbrace(b, l + 1);
    exit_section_(b, m, MODEL_DEFINITION_BLOCK, r);
    return r;
  }

  // (block_decorator | field_definition | comment | WS)*
  private static boolean model_definition_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_definition_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_definition_block_1", c)) break;
    }
    return true;
  }

  // block_decorator | field_definition | comment | WS
  private static boolean model_definition_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_definition_block_1_0")) return false;
    boolean r;
    r = block_decorator(b, l + 1);
    if (!r) r = field_definition(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = WS(b, l + 1);
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
  // expression WS* padded_colon WS* expression
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

  // WS*
  private static boolean named_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_expression_1", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean named_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_expression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_expression_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // unit (WS* QMQM WS* unit)+
  public static boolean nullish_coalescing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NULLISH_COALESCING, "<nullish coalescing>");
    r = unit(b, l + 1);
    r = r && nullish_coalescing_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WS* QMQM WS* unit)+
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

  // WS* QMQM WS* unit
  private static boolean nullish_coalescing_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nullish_coalescing_1_0_0(b, l + 1);
    r = r && consumeToken(b, QMQM);
    r = r && nullish_coalescing_1_0_2(b, l + 1);
    r = r && unit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS*
  private static boolean nullish_coalescing_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nullish_coalescing_1_0_0", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean nullish_coalescing_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullish_coalescing_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nullish_coalescing_1_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // WS? COLON WS?
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

  // WS?
  private static boolean padded_colon_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_colon_0")) return false;
    WS(b, l + 1);
    return true;
  }

  // WS?
  private static boolean padded_colon_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_colon_2")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WS? COMMA WS?
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

  // WS?
  private static boolean padded_comma_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_comma_0")) return false;
    WS(b, l + 1);
    return true;
  }

  // WS?
  private static boolean padded_comma_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_comma_2")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WSC* DOC_COMMENT EOL?
  public static boolean padded_doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_doc_comment")) return false;
    if (!nextTokenIs(b, "<padded doc comment>", DOC_COMMENT, WSC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PADDED_DOC_COMMENT, "<padded doc comment>");
    r = padded_doc_comment_0(b, l + 1);
    r = r && consumeToken(b, DOC_COMMENT);
    r = r && padded_doc_comment_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WSC*
  private static boolean padded_doc_comment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_doc_comment_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WSC)) break;
      if (!empty_element_parsed_guard_(b, "padded_doc_comment_0", c)) break;
    }
    return true;
  }

  // EOL?
  private static boolean padded_doc_comment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_doc_comment_2")) return false;
    consumeToken(b, EOL);
    return true;
  }

  /* ********************************************************** */
  // LBRACE WS?
  static boolean padded_lbrace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_lbrace")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && padded_lbrace_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean padded_lbrace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_lbrace_1")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACKET WS?
  static boolean padded_lbracket(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_lbracket")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && padded_lbracket_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean padded_lbracket_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_lbracket_1")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LPAREN WS?
  static boolean padded_lparen(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_lparen")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && padded_lparen_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean padded_lparen_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_lparen_1")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WS? RBRACE
  static boolean padded_rbrace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_rbrace")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_rbrace_0(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean padded_rbrace_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_rbrace_0")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WS? RBRACKET
  static boolean padded_rbracket(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_rbracket")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_rbracket_0(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean padded_rbracket_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_rbracket_0")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WS? RPAREN
  static boolean padded_rparen(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_rparen")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_rparen_0(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS?
  private static boolean padded_rparen_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "padded_rparen_0")) return false;
    WS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DOLLAR identifier_unit
  public static boolean pipeline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline")) return false;
    if (!nextTokenIs(b, DOLLAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOLLAR);
    r = r && identifier_unit(b, l + 1);
    exit_section_(b, m, PIPELINE, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET WS* expression WS* RBRACKET
  public static boolean subscript(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && subscript_1(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && subscript_3(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, SUBSCRIPT, r);
    return r;
  }

  // WS*
  private static boolean subscript_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subscript_1", c)) break;
    }
    return true;
  }

  // WS*
  private static boolean subscript_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WS(b, l + 1)) break;
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
  // padded_lparen (padded_comma | (expression padded_comma (expression (padded_comma expression)* padded_comma?)*)) padded_rparen
  public static boolean tuple_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = padded_lparen(b, l + 1);
    r = r && tuple_literal_1(b, l + 1);
    r = r && padded_rparen(b, l + 1);
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
  // IDENTIFIER
  public static boolean user_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, USER_TYPE, r);
    return r;
  }

}
