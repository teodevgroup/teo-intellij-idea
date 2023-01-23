package io.teocloud.teointellijidea.ide.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import io.teocloud.teointellijidea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeoStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

    public TeoStructureViewModel(@NotNull PsiFile psiFile, @Nullable Editor editor) {
        super(psiFile, editor, new TeoStructureViewElement(psiFile));
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public Sorter @NotNull [] getSorters() {
        return new Sorter[]{ Sorter.ALPHA_SORTER };
    }

    @Override
    protected Class @NotNull [] getSuitableClasses() {
        return new Class[]{
                TeoLetDeclaration.class,
                TeoModelDefinition.class,
                TeoEnumDefinition.class,
                TeoConfigDefinition.class,
                TeoFieldDefinition.class,
                TeoEnumValueDeclaration.class,
        };
    }
}
