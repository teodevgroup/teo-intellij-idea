package io.teocloud.teointellijidea.lang.resolve;


import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import io.teocloud.teointellijidea.lang.TeoUtil;
import io.teocloud.teointellijidea.lang.psi.TeoNameIdentifierOwner;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import io.teocloud.teointellijidea.psi.TeoFieldType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class TeoSelfReference extends PsiReferenceBase<TeoNameIdentifierOwner> {

    public TeoSelfReference(@NotNull TeoNameIdentifierOwner psiElement, TextRange textRange) {
        super(psiElement, textRange);
    }

    @Override
    protected TextRange calculateDefaultRangeInElement() {
        PsiElement ele = getElement().getNameIdentifier();
        if (ele != null) {
            return ele.getTextRange();
        }
        return null;
    }

    @Override
    public @Nullable PsiElement resolve() {
        return getElement();
    }
}
