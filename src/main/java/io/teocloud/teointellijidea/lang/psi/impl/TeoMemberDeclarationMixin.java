package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;

public class TeoMemberDeclarationMixin extends TeoNamedElementImpl implements TeoMemberDeclaration {

    public TeoMemberDeclarationMixin(ASTNode node) {
        super(node);
    }

    @Override
    public TeoDeclaration getContainingDeclaration() {
        return PsiTreeUtil.getParentOfType(this, TeoDeclaration.class);
    }
}
