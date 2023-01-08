package io.teocloud.teointellijidea.psi;

import com.intellij.psi.tree.TokenSet;

public interface TeoTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(TeoTypes.IDENTIFIER);

    TokenSet COMMENTS = TokenSet.create(TeoTypes.COMMENT);

}
