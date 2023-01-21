package io.teocloud.teointellijidea;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.psi.*;
import io.teocloud.teointellijidea.psi.impl.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TeoAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof TeoConfigItemName) {
            holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.CONFIG_ITEM_NAME).create();
        } else if (element instanceof TeoEnumChoiceLiteral) {
            holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.ENUM_MEMBER).create();
        } else if (element instanceof TeoFieldName) {
            holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.FIELD_NAME).create();
        } else if (element instanceof TeoFieldTypeImpl) {
            holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.FIELD_TYPE).create();
        }
//        else if (element instanceof TeoPipelineImpl) {
//            ASTNode node = element.getNode();
//            @NotNull ASTNode identifierUnit = Objects.requireNonNull(element.getNode().findChildByType(TeoTypes.IDENTIFIER_UNIT));
//            pipelineHighlight(node, holder);
//            pipelineHighlight(identifierUnit, holder);
//        }
    }

//    private void decoratorHighlight(@NotNull ASTNode node, @NotNull AnnotationHolder holder) {
//        @NotNull ASTNode[] children = node.getChildren(TeoTokenSets.DECORATOR_SET);
//        for (ASTNode child : children) {
//            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//                .range(child.getTextRange())
//                .textAttributes(TeoSyntaxHighlighter.DECORATOR).create();
//        }
//    }
//
//    private void pipelineHighlight(@NotNull ASTNode node, @NotNull AnnotationHolder holder) {
//        @NotNull ASTNode[] children = node.getChildren(TeoTokenSets.PIPELINE_SET);
//        for (ASTNode child : children) {
//            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//                    .range(child.getTextRange())
//                    .textAttributes(TeoSyntaxHighlighter.PIPELINE).create();
//        }
//    }
}
