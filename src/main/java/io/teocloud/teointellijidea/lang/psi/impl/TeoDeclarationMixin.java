package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.psi.TeoBlock;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoTokenSets;
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
        return null;
//        if (getBlock() != null) {
//            getBlock().getMembers().filterIsInstance
//        }
//        getBlock()?.getMembers()?.filterIsInstance<PrismaMemberDeclaration>() ?: emptyList()
    }

    @Override
    public TeoMemberDeclaration findMemberByName(String name) {
        return null;
    }
}
