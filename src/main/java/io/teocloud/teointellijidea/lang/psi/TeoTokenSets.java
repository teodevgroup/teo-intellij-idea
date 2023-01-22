package io.teocloud.teointellijidea.lang.psi;

import com.intellij.psi.tree.TokenSet;
import io.teocloud.teointellijidea.psi.TeoTypes;

public interface TeoTokenSets {

    TokenSet COMMENTS = TokenSet.create(TeoTypes.LINE_COMMENT);

    TokenSet STRING_LITERAL = TokenSet.create(TeoTypes.STRING_LITERAL);

    TokenSet DECORATOR_SET = TokenSet.create(TeoTypes.AT, TeoTypes.ATAT, TeoTypes.INITIAL_UNIT_IDENTIFIER, TeoTypes.IDENTIFIER);
    TokenSet PIPELINE_SET = TokenSet.create(TeoTypes.DOLLAR, TeoTypes.INITIAL_UNIT_IDENTIFIER, TeoTypes.IDENTIFIER);

}
