package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.lang.psi.TeoBlock;
import io.teocloud.teointellijidea.lang.psi.TeoElement;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Objects;

public class TeoBlockMixin extends TeoElementImpl implements TeoBlock {

    public TeoBlockMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public List<TeoElement> getMembers() {
        TeoElement[] elements = PsiTreeUtil.getChildrenOfType(this, TeoElement.class);
        return List.of(Objects.requireNonNullElseGet(elements, () -> new TeoElement[]{}));
    }

    @Override
    public List<TeoMemberDeclaration> getMemberDeclarations() {
        TeoMemberDeclaration[] elements = PsiTreeUtil.getChildrenOfType(this, TeoMemberDeclaration.class);
        return List.of(Objects.requireNonNullElseGet(elements, () -> new TeoMemberDeclaration[]{}));
    }

    @Override
    public @Nullable TeoNamedElement findMemberByName(String name) {
        return null;
    }
}
