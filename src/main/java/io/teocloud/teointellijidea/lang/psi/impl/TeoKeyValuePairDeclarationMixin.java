package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoKeyValuePairDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoTokenSets;
import org.jetbrains.annotations.Nullable;

public class TeoKeyValuePairDeclarationMixin extends TeoDeclarationMixin implements TeoDeclaration, TeoKeyValuePairDeclaration {

    public TeoKeyValuePairDeclarationMixin(ASTNode node) {
        super(node);
    }

    @Override
    public @Nullable String getName() {
        String name = super.getName();
        if (name != null) {
            return name;
        }
        PsiElement element = findChildByType(TeoTokenSets.DECLARATION_KEYWORDS);
        if (element != null) {
            String text = element.getText();
            return text.substring(0, 1).toUpperCase() + text.substring(1);
        }
        return null;
    }
}
