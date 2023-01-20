package io.teocloud.teointellijidea.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import org.jetbrains.annotations.NotNull;

public class TeoStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private final NavigatablePsiElement element;

    public TeoStructureViewElement(NavigatablePsiElement element) {
        this.element = element;
    }

    public NavigatablePsiElement getElement() {
        return element;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public @NotNull String getAlphaSortKey() {
        return null;
    }

    @Override
    public @NotNull ItemPresentation getPresentation() {
        return null;
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        return new TreeElement[0];
    }

    @Override
    public void navigate(boolean requestFocus) {

    }

    @Override
    public boolean canNavigate() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return false;
    }
}
