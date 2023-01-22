// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.teocloud.teointellijidea.lang.psi.TeoElementType;
import io.teocloud.teointellijidea.lang.psi.TeoTokenType;
import io.teocloud.teointellijidea.psi.impl.*;

public interface TeoTypes {

  IElementType ARGUMENT = new TeoElementType("ARGUMENT");
  IElementType ARGUMENT_LIST = new TeoElementType("ARGUMENT_LIST");
  IElementType ARITY = new TeoElementType("ARITY");
  IElementType ARRAY_LITERAL = new TeoElementType("ARRAY_LITERAL");
  IElementType BAD_DOC_COMMENT = new TeoElementType("BAD_DOC_COMMENT");
  IElementType BAD_TOP_DECORATOR = new TeoElementType("BAD_TOP_DECORATOR");
  IElementType BAD_TOP_IDENTIFIER = new TeoElementType("BAD_TOP_IDENTIFIER");
  IElementType BLOCK_DECORATOR = new TeoElementType("BLOCK_DECORATOR");
  IElementType BUILTIN_TYPE = new TeoElementType("BUILTIN_TYPE");
  IElementType COLLECTION_OPTIONAL = new TeoElementType("COLLECTION_OPTIONAL");
  IElementType COMMENT = new TeoElementType("COMMENT");
  IElementType CONFIG_BLOCK = new TeoElementType("CONFIG_BLOCK");
  IElementType CONFIG_DEFINITION = new TeoElementType("CONFIG_DEFINITION");
  IElementType CONFIG_ITEM = new TeoElementType("CONFIG_ITEM");
  IElementType CONFIG_ITEM_NAME = new TeoElementType("CONFIG_ITEM_NAME");
  IElementType CONFIG_KEYWORDS = new TeoElementType("CONFIG_KEYWORDS");
  IElementType CONFIG_NAME = new TeoElementType("CONFIG_NAME");
  IElementType DICTIONARY_LITERAL = new TeoElementType("DICTIONARY_LITERAL");
  IElementType DOC_COMMENT_BLOCK = new TeoElementType("DOC_COMMENT_BLOCK");
  IElementType ENUM_CHOICE_LITERAL = new TeoElementType("ENUM_CHOICE_LITERAL");
  IElementType ENUM_DEFINITION = new TeoElementType("ENUM_DEFINITION");
  IElementType ENUM_DEFINITION_BLOCK = new TeoElementType("ENUM_DEFINITION_BLOCK");
  IElementType ENUM_IDENTIFIER = new TeoElementType("ENUM_IDENTIFIER");
  IElementType ENUM_MEMBER_NAME = new TeoElementType("ENUM_MEMBER_NAME");
  IElementType ENUM_NAME = new TeoElementType("ENUM_NAME");
  IElementType ENUM_VALUE_DECLARATION = new TeoElementType("ENUM_VALUE_DECLARATION");
  IElementType EOL_WSC = new TeoElementType("EOL_WSC");
  IElementType EXPRESSION = new TeoElementType("EXPRESSION");
  IElementType FIELD_DEFINITION = new TeoElementType("FIELD_DEFINITION");
  IElementType FIELD_NAME = new TeoElementType("FIELD_NAME");
  IElementType FIELD_TYPE = new TeoElementType("FIELD_TYPE");
  IElementType GROUP = new TeoElementType("GROUP");
  IElementType IDENTIFIER_UNIT = new TeoElementType("IDENTIFIER_UNIT");
  IElementType IMPORT_IDENTIFIERS_BLOCK = new TeoElementType("IMPORT_IDENTIFIERS_BLOCK");
  IElementType IMPORT_IDENTIFIER_LIST = new TeoElementType("IMPORT_IDENTIFIER_LIST");
  IElementType IMPORT_STATEMENT = new TeoElementType("IMPORT_STATEMENT");
  IElementType INITIAL_UNIT_IDENTIFIER = new TeoElementType("INITIAL_UNIT_IDENTIFIER");
  IElementType ITEM_DECORATOR = new TeoElementType("ITEM_DECORATOR");
  IElementType ITEM_DECORATOR_LIST = new TeoElementType("ITEM_DECORATOR_LIST");
  IElementType ITEM_OPTIONAL = new TeoElementType("ITEM_OPTIONAL");
  IElementType LET_DECLARATION = new TeoElementType("LET_DECLARATION");
  IElementType LITERAL = new TeoElementType("LITERAL");
  IElementType MODEL_DEFINITION = new TeoElementType("MODEL_DEFINITION");
  IElementType MODEL_DEFINITION_BLOCK = new TeoElementType("MODEL_DEFINITION_BLOCK");
  IElementType MODEL_NAME = new TeoElementType("MODEL_NAME");
  IElementType NAMED_ARGUMENT = new TeoElementType("NAMED_ARGUMENT");
  IElementType NAMED_EXPRESSION = new TeoElementType("NAMED_EXPRESSION");
  IElementType NULLISH_COALESCING = new TeoElementType("NULLISH_COALESCING");
  IElementType PADDED_DOC_COMMENT = new TeoElementType("PADDED_DOC_COMMENT");
  IElementType PIPELINE = new TeoElementType("PIPELINE");
  IElementType SUBSCRIPT = new TeoElementType("SUBSCRIPT");
  IElementType TUPLE_LITERAL = new TeoElementType("TUPLE_LITERAL");
  IElementType UNIT = new TeoElementType("UNIT");
  IElementType USER_TYPE = new TeoElementType("USER_TYPE");
  IElementType WS = new TeoElementType("WS");

  IElementType AT = new TeoTokenType("AT");
  IElementType ATAT = new TeoTokenType("ATAT");
  IElementType BOOL_LITERAL = new TeoTokenType("BOOL_LITERAL");
  IElementType CLIENT_KEYWORD = new TeoTokenType("CLIENT_KEYWORD");
  IElementType COLON = new TeoTokenType("COLON");
  IElementType COMMA = new TeoTokenType("COMMA");
  IElementType CONFIG_KEYWORD = new TeoTokenType("CONFIG_KEYWORD");
  IElementType CONNECTOR_KEYWORD = new TeoTokenType("CONNECTOR_KEYWORD");
  IElementType CRANGE = new TeoTokenType("CRANGE");
  IElementType DOC_COMMENT = new TeoTokenType("DOC_COMMENT");
  IElementType DOLLAR = new TeoTokenType("DOLLAR");
  IElementType DOT = new TeoTokenType("DOT");
  IElementType ENTITY_KEYWORD = new TeoTokenType("ENTITY_KEYWORD");
  IElementType ENUM_KEYWORD = new TeoTokenType("ENUM_KEYWORD");
  IElementType EOL = new TeoTokenType("EOL");
  IElementType EQ = new TeoTokenType("EQ");
  IElementType EXCL = new TeoTokenType("EXCL");
  IElementType FROM_KEYWORD = new TeoTokenType("FROM_KEYWORD");
  IElementType IDENTIFIER = new TeoTokenType("IDENTIFIER");
  IElementType IMPORT_KEYWORD = new TeoTokenType("IMPORT_KEYWORD");
  IElementType LBRACE = new TeoTokenType("LBRACE");
  IElementType LBRACKET = new TeoTokenType("LBRACKET");
  IElementType LET_KEYWORD = new TeoTokenType("LET_KEYWORD");
  IElementType LINE_COMMENT = new TeoTokenType("LINE_COMMENT");
  IElementType LPAREN = new TeoTokenType("LPAREN");
  IElementType MODEL_KEYWORD = new TeoTokenType("MODEL_KEYWORD");
  IElementType NULL_LITERAL = new TeoTokenType("NULL_LITERAL");
  IElementType NUMERIC_LITERAL = new TeoTokenType("NUMERIC_LITERAL");
  IElementType ORANGE = new TeoTokenType("ORANGE");
  IElementType QM = new TeoTokenType("QM");
  IElementType QMQM = new TeoTokenType("QMQM");
  IElementType RANGE_LITERAL = new TeoTokenType("RANGE_LITERAL");
  IElementType RBRACE = new TeoTokenType("RBRACE");
  IElementType RBRACKET = new TeoTokenType("RBRACKET");
  IElementType RPAREN = new TeoTokenType("RPAREN");
  IElementType STRING_LITERAL = new TeoTokenType("STRING_LITERAL");
  IElementType WSC = new TeoTokenType("WSC");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new TeoArgumentImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new TeoArgumentListImpl(node);
      }
      else if (type == ARITY) {
        return new TeoArityImpl(node);
      }
      else if (type == ARRAY_LITERAL) {
        return new TeoArrayLiteralImpl(node);
      }
      else if (type == BAD_DOC_COMMENT) {
        return new TeoBadDocCommentImpl(node);
      }
      else if (type == BAD_TOP_DECORATOR) {
        return new TeoBadTopDecoratorImpl(node);
      }
      else if (type == BAD_TOP_IDENTIFIER) {
        return new TeoBadTopIdentifierImpl(node);
      }
      else if (type == BLOCK_DECORATOR) {
        return new TeoBlockDecoratorImpl(node);
      }
      else if (type == BUILTIN_TYPE) {
        return new TeoBuiltinTypeImpl(node);
      }
      else if (type == COLLECTION_OPTIONAL) {
        return new TeoCollectionOptionalImpl(node);
      }
      else if (type == COMMENT) {
        return new TeoCommentImpl(node);
      }
      else if (type == CONFIG_BLOCK) {
        return new TeoConfigBlockImpl(node);
      }
      else if (type == CONFIG_DEFINITION) {
        return new TeoConfigDefinitionImpl(node);
      }
      else if (type == CONFIG_ITEM) {
        return new TeoConfigItemImpl(node);
      }
      else if (type == CONFIG_ITEM_NAME) {
        return new TeoConfigItemNameImpl(node);
      }
      else if (type == CONFIG_KEYWORDS) {
        return new TeoConfigKeywordsImpl(node);
      }
      else if (type == CONFIG_NAME) {
        return new TeoConfigNameImpl(node);
      }
      else if (type == DICTIONARY_LITERAL) {
        return new TeoDictionaryLiteralImpl(node);
      }
      else if (type == DOC_COMMENT_BLOCK) {
        return new TeoDocCommentBlockImpl(node);
      }
      else if (type == ENUM_CHOICE_LITERAL) {
        return new TeoEnumChoiceLiteralImpl(node);
      }
      else if (type == ENUM_DEFINITION) {
        return new TeoEnumDefinitionImpl(node);
      }
      else if (type == ENUM_DEFINITION_BLOCK) {
        return new TeoEnumDefinitionBlockImpl(node);
      }
      else if (type == ENUM_IDENTIFIER) {
        return new TeoEnumIdentifierImpl(node);
      }
      else if (type == ENUM_MEMBER_NAME) {
        return new TeoEnumMemberNameImpl(node);
      }
      else if (type == ENUM_NAME) {
        return new TeoEnumNameImpl(node);
      }
      else if (type == ENUM_VALUE_DECLARATION) {
        return new TeoEnumValueDeclarationImpl(node);
      }
      else if (type == EOL_WSC) {
        return new TeoEolWscImpl(node);
      }
      else if (type == EXPRESSION) {
        return new TeoExpressionImpl(node);
      }
      else if (type == FIELD_DEFINITION) {
        return new TeoFieldDefinitionImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new TeoFieldNameImpl(node);
      }
      else if (type == FIELD_TYPE) {
        return new TeoFieldTypeImpl(node);
      }
      else if (type == GROUP) {
        return new TeoGroupImpl(node);
      }
      else if (type == IDENTIFIER_UNIT) {
        return new TeoIdentifierUnitImpl(node);
      }
      else if (type == IMPORT_IDENTIFIERS_BLOCK) {
        return new TeoImportIdentifiersBlockImpl(node);
      }
      else if (type == IMPORT_IDENTIFIER_LIST) {
        return new TeoImportIdentifierListImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new TeoImportStatementImpl(node);
      }
      else if (type == INITIAL_UNIT_IDENTIFIER) {
        return new TeoInitialUnitIdentifierImpl(node);
      }
      else if (type == ITEM_DECORATOR) {
        return new TeoItemDecoratorImpl(node);
      }
      else if (type == ITEM_DECORATOR_LIST) {
        return new TeoItemDecoratorListImpl(node);
      }
      else if (type == ITEM_OPTIONAL) {
        return new TeoItemOptionalImpl(node);
      }
      else if (type == LET_DECLARATION) {
        return new TeoLetDeclarationImpl(node);
      }
      else if (type == LITERAL) {
        return new TeoLiteralImpl(node);
      }
      else if (type == MODEL_DEFINITION) {
        return new TeoModelDefinitionImpl(node);
      }
      else if (type == MODEL_DEFINITION_BLOCK) {
        return new TeoModelDefinitionBlockImpl(node);
      }
      else if (type == MODEL_NAME) {
        return new TeoModelNameImpl(node);
      }
      else if (type == NAMED_ARGUMENT) {
        return new TeoNamedArgumentImpl(node);
      }
      else if (type == NAMED_EXPRESSION) {
        return new TeoNamedExpressionImpl(node);
      }
      else if (type == NULLISH_COALESCING) {
        return new TeoNullishCoalescingImpl(node);
      }
      else if (type == PADDED_DOC_COMMENT) {
        return new TeoPaddedDocCommentImpl(node);
      }
      else if (type == PIPELINE) {
        return new TeoPipelineImpl(node);
      }
      else if (type == SUBSCRIPT) {
        return new TeoSubscriptImpl(node);
      }
      else if (type == TUPLE_LITERAL) {
        return new TeoTupleLiteralImpl(node);
      }
      else if (type == UNIT) {
        return new TeoUnitImpl(node);
      }
      else if (type == USER_TYPE) {
        return new TeoUserTypeImpl(node);
      }
      else if (type == WS) {
        return new TeoWsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
