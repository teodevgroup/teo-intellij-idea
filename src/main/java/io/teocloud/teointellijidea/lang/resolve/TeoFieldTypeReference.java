package io.teocloud.teointellijidea.lang.resolve;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import io.teocloud.teointellijidea.lang.TeoUtil;
import io.teocloud.teointellijidea.psi.TeoFieldType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class TeoFieldTypeReference extends PsiReferenceBase<TeoFieldType> {

    public TeoFieldTypeReference(@NotNull TeoFieldType psiElement, TextRange textRange) {
        super(psiElement, textRange);
    }

    @Override
    protected TextRange calculateDefaultRangeInElement() {
        PsiElement userType = getElement().getUserType();
        if (userType != null) {
            return userType.getTextRange();
        } else {
            return null;
        }
        //return Objects.requireNonNullElseGet(userType, () -> Objects.requireNonNull(getElement().getBuiltinType())).getTextRange();
    }

    @Override
    public @Nullable PsiElement resolve() {
        if (getElement().getBuiltinType() != null) {
            return null;
        }
        String name = Objects.requireNonNull(getElement().getUserType()).getText();
        return TeoUtil.findModelOrEnumDefinitionByName(getElement().getProject(), name);
    }
}
