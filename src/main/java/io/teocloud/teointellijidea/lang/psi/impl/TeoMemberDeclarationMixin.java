package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;
import io.teocloud.teointellijidea.lang.resolve.TeoSelfReference;

public class TeoMemberDeclarationMixin extends TeoNamedElementImpl implements TeoMemberDeclaration {

    public TeoMemberDeclarationMixin(ASTNode node) {
        super(node);
    }

    @Override
    public TeoDeclaration getContainingDeclaration() {
        return PsiTreeUtil.getParentOfType(this, TeoDeclaration.class);
    }

    @Override
    public int getTextOffset() {
        PsiElement identifier = getNameIdentifier();
        if (identifier != null) {
            return identifier.getTextOffset();
        }
        return -1;
    }

    @Override
    public PsiReference getReference() {
        PsiElement identifier = getNameIdentifier();
        return new TeoSelfReference(this, identifier.getTextRange());
    }
}
