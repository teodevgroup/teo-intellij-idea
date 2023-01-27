package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import io.teocloud.teointellijidea.lang.psi.TeoBlock;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoTokenSets;
import io.teocloud.teointellijidea.lang.resolve.TeoSelfReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeoDeclarationMixin extends TeoNamedElementImpl implements TeoDeclaration {

    public TeoDeclarationMixin(ASTNode node) {
        super(node);
    }


    @Override
    public PsiElement getKeywordElement() {
        return findChildByType(TeoTokenSets.DECLARATION_KEYWORDS);
    }

    @Override
    public @Nullable TeoBlock getBlock() {
        return findChildByClass(TeoBlock.class);
    }

    @Override
    public List<TeoMemberDeclaration> getMembers() {
        TeoBlock block = getBlock();
        if (block != null) {
            return block.getMemberDeclarations();
        }
        return List.of(new TeoMemberDeclaration[]{});
    }

    @Override
    public TeoMemberDeclaration findMemberByName(String name) {
        return null;
    }

    @Override
    public int getTextOffset() {
        PsiElement identifier = getNameIdentifier();
        if (identifier != null) {
            return identifier.getTextOffset();
        } else {
            return 0;
        }
    }

    @Override
    public PsiReference getReference() {
        PsiElement ele = this.getNameIdentifier();
        if (ele == null) {
            return null;
        }
        return new TeoSelfReference(this, ele.getTextRange());
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        PsiReference ref = getReference();
        if (ref == null) {
            return new PsiReference[]{};
        } else {
            return new PsiReference[]{ref};
        }
    }
}
