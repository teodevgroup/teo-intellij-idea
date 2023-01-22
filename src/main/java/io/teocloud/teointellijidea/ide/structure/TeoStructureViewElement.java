package io.teocloud.teointellijidea.ide.structure;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.lang.psi.TeoFile;
import io.teocloud.teointellijidea.psi.*;
import io.teocloud.teointellijidea.psi.impl.TeoConfigBlockImpl;
import io.teocloud.teointellijidea.psi.impl.TeoEnumDefinitionBlockImpl;
import io.teocloud.teointellijidea.psi.impl.TeoModelDefinitionBlockImpl;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeoStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private final NavigatablePsiElement element;

    public TeoStructureViewElement(NavigatablePsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public @NotNull String getAlphaSortKey() {
        return element.getName() != null ? element.getName() : "";
    }

    @Override
    public @NotNull ItemPresentation getPresentation() {
        PresentationData data = new PresentationData();
        if (element instanceof TeoFile) {
            return Objects.requireNonNull(element.getPresentation());
        }
        return data;
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        if (element instanceof TeoFile) {
            List<TeoStructureViewElement> eles = PsiTreeUtil.findChildrenOfAnyType(element,
                    TeoModelDefinitionBlockImpl.class,
                    TeoEnumDefinitionBlockImpl.class,
                    TeoConfigBlockImpl.class).stream().map(TeoStructureViewElement::new).collect(Collectors.toList());
            TeoStructureViewElement[] array = new TeoStructureViewElement[eles.size()];
            return eles.toArray(array);
        } else if (element instanceof TeoModelDefinition) {
            return new TreeElement[]{};
        } else if (element instanceof TeoEnumDefinition) {
            return new TreeElement[]{};
        } else {
            return new TreeElement[]{};
        }
    }

    @Override
    public void navigate(boolean requestFocus) {
        element.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return element.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element.canNavigateToSource();
    }
}
