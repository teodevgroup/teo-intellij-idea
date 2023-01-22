package io.teocloud.teointellijidea.ide.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class TeoFoldingBuilder extends FoldingBuilderEx {
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descs = PsiTreeUtil.findChildrenOfAnyType(
                        root,
                        TeoModelDefinitionBlock.class,
                        TeoEnumDefinitionBlock.class,
                        TeoConfigBlock.class,
                        TeoImportIdentifiersBlock.class,
                        TeoArrayLiteral.class,
                        TeoTupleLiteral.class,
                        TeoDictionaryLiteral.class)
                .stream()
                .map((PsiElement element) -> new FoldingDescriptor(element, element.getTextRange()))
                .collect(Collectors.toList());
        FoldingDescriptor[] array = new FoldingDescriptor[descs.size()];
        descs.toArray(array);
        return array;
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getElementType() == TeoTypes.ARRAY_LITERAL) {
            return "[...]";
        } else if (node.getElementType() == TeoTypes.TUPLE_LITERAL) {
            return "(...)";
        } else {
            return "{...}";
        }
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
