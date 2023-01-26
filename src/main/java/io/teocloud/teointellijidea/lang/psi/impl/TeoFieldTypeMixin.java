package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import io.teocloud.teointellijidea.lang.resolve.TeoFieldTypeReference;
import io.teocloud.teointellijidea.psi.TeoFieldType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public abstract class TeoFieldTypeMixin extends TeoElementImpl implements TeoNamedElement, TeoFieldType {
    public TeoFieldTypeMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public @Nullable PsiReference getReference() {
        if (this.getBuiltinType() == null) {
            return new TeoFieldTypeReference(this, new TextRange(0, Objects.requireNonNull(this.getUserType()).getTextLength()));
        } else {
            return null;
        }
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return null;
    }

}
