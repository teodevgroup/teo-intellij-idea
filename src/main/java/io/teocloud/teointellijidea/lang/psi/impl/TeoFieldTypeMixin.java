package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import io.teocloud.teointellijidea.lang.psi.TeoFieldTypeInterface;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import io.teocloud.teointellijidea.lang.resolve.TeoFieldTypeReference;
import io.teocloud.teointellijidea.lang.std.type.TeoStdTypeUtils;
import io.teocloud.teointellijidea.psi.TeoFieldType;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

public abstract class TeoFieldTypeMixin extends TeoElementImpl implements TeoNamedElement, TeoFieldTypeInterface {
    public TeoFieldTypeMixin(@NotNull ASTNode node) {
        super(node);
    }

    public boolean isUserType() {
        return true;
    }

    public boolean isBuiltinType() {
        return Arrays.stream(TeoStdTypeUtils.builtinTypeNames).anyMatch((String s) -> s.equals(getTypeText()));
    }

    public String getTypeText() {
        return Objects.requireNonNull(getNode().findChildByType(TeoTypes.IDENTIFIER)).getText();
    }

    public TextRange getTypeTextRange() {
        return Objects.requireNonNull(getNode().findChildByType(TeoTypes.IDENTIFIER)).getTextRange();
    }

    @Override
    public @Nullable PsiReference getReference() {
        if (this.isUserType()) {
            return new TeoFieldTypeReference((TeoFieldType) this, new TextRange(0, this.getTypeText().length()));
        } else {
            return null;
        }
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return null;
    }

    @Override
    public int getTextOffset() {
        if (this.isUserType()) {
            return super.getTextOffset();
        } else {
            return -1;
        }
    }
}
