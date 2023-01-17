package io.teocloud.teointellijidea.psi;

import com.intellij.psi.tree.TokenSet;

public interface TeoTokenSets {

    TokenSet COMMENTS = TokenSet.create(TeoTypes.DOUBLE_LINE_COMMENT);

    TokenSet STRING_LITERAL = TokenSet.create(TeoTypes.STRING_LITERAL);

    TokenSet DECORATOR_SET = TokenSet.create(TeoTypes.AT, TeoTypes.DOUBLE_AT, TeoTypes.INITIAL_UNIT_IDENTIFIER, TeoTypes.IDENTIFIER);
    TokenSet PIPELINE_SET = TokenSet.create(TeoTypes.DOLLAR_SIGN, TeoTypes.IDENTIFIER);

}
