package io.teocloud.teointellijidea.psi;

import com.intellij.psi.tree.TokenSet;

public interface TeoTokenSets {

    TokenSet COMMENTS = TokenSet.create(TeoTypes.COMMENT);

    TokenSet STRING_LITERAL = TokenSet.create(TeoTypes.STRING_LITERAL);
}
