package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import io.teocloud.teointellijidea.lang.psi.TeoElement;
import org.jetbrains.annotations.NotNull;

public abstract class TeoElementImpl extends ASTWrapperPsiElement implements TeoElement {
    public TeoElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
