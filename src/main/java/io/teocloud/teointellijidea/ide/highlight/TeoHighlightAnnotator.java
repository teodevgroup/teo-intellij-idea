package io.teocloud.teointellijidea.ide.highlight;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoDecorator;
import io.teocloud.teointellijidea.lang.psi.TeoTokenSets;
import io.teocloud.teointellijidea.psi.*;
import io.teocloud.teointellijidea.psi.impl.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TeoHighlightAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof TeoModelDefinitionImpl) {
            highlightModelDeclarationName((TeoModelDefinitionImpl) element, holder);
        } else if (element instanceof TeoEnumDefinitionImpl) {
            highlightEnumDeclarationName((TeoEnumDefinitionImpl) element, holder);
        } else if (element instanceof TeoConfigDefinitionImpl) {
            highlightConfigDeclarationName((TeoConfigDefinitionImpl) element, holder);
        } else if (element instanceof TeoFieldDefinitionImpl) {
            highlightFieldDeclarationName((TeoFieldDefinitionImpl) element, holder);
        } else if (element instanceof TeoConfigItemImpl) {
            highlightConfigItemName((TeoConfigItemImpl) element, holder);
        } else if (element instanceof TeoEnumValueDeclarationImpl) {
            highlightEnumMemberDeclarationName((TeoEnumValueDeclarationImpl) element, holder);
        } else if (element instanceof TeoEnumChoiceLiteralImpl) {
            highlightEnumMemberLiteral((TeoEnumChoiceLiteralImpl) element, holder);
        } else if (element instanceof TeoUserTypeImpl) {
            highlightUserType((TeoUserTypeImpl) element, holder);
        } else if (element instanceof TeoBuiltinTypeImpl) {
            highlightBuiltinType((TeoBuiltinTypeImpl) element, holder);
        } else if (element instanceof TeoDecorator) {
            highlightDecorator((TeoDecorator) element, holder);
        } else if (element instanceof TeoPipelineImpl) {
            highlightPipeline((TeoPipelineImpl) element, holder);
        }

//        }else if (element instanceof TeoBlockDecoratorImpl || element instanceof TeoItemDecoratorImpl || element instanceof TeoBadTopDecoratorImpl) {
//            ASTNode node = element.getNode();
//            @NotNull ASTNode identifierUnit = Objects.requireNonNull(element.getNode().findChildByType(TeoTypes.IDENTIFIER_UNIT));
//            decoratorHighlight(node, holder);
//            decoratorHighlight(identifierUnit, holder);

    }

    private void highlightModelDeclarationName(@NotNull TeoModelDefinitionImpl model, @NotNull AnnotationHolder holder) {
        PsiElement nameElement = model.getNameIdentifier();
        if (nameElement != null) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(nameElement.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.MODEL_NAME).create();
        }
    }

    private void highlightEnumDeclarationName(@NotNull TeoEnumDefinitionImpl element, @NotNull AnnotationHolder holder) {
        PsiElement nameElement = element.getNameIdentifier();
        if (nameElement != null) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(nameElement.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.ENUM_NAME).create();
        }
    }

    private void highlightConfigDeclarationName(@NotNull TeoConfigDefinitionImpl element, @NotNull AnnotationHolder holder) {
        PsiElement nameElement = element.getNameIdentifier();
        if (nameElement != null) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(nameElement.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.CONFIG_NAME).create();
        }
    }

    private void highlightConfigItemName(@NotNull TeoConfigItemImpl element, @NotNull AnnotationHolder holder) {
        PsiElement nameElement = element.getNameIdentifier();
        if (nameElement != null) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(nameElement.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.CONFIG_ITEM_NAME).create();
        }
    }

    private void highlightEnumMemberDeclarationName(@NotNull TeoEnumValueDeclarationImpl element, @NotNull AnnotationHolder holder) {
        PsiElement nameElement = element.getNameIdentifier();
        if (nameElement != null) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(nameElement.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.ENUM_MEMBER).create();
        }
    }

    private void highlightEnumMemberLiteral(@NotNull TeoEnumChoiceLiteralImpl element, @NotNull AnnotationHolder holder) {
        holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.ENUM_MEMBER).create();
    }

    private void highlightFieldDeclarationName(@NotNull TeoFieldDefinitionImpl element, @NotNull AnnotationHolder holder) {
        PsiElement nameElement = element.getNameIdentifier();
        if (nameElement != null) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(nameElement.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.FIELD_NAME).create();
        }
    }

    private void highlightUserType(@NotNull TeoUserTypeImpl element, @NotNull AnnotationHolder holder) {
        holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.USER_TYPE).create();
    }

    private void highlightBuiltinType(@NotNull TeoBuiltinTypeImpl element, @NotNull AnnotationHolder holder) {
        holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.BUILTIN_TYPE).create();

    }

    private void highlightDecorator(@NotNull TeoDecorator element, @NotNull AnnotationHolder holder) {
        ASTNode node = element.getNode();
        decoratorHighlight(node, holder);
        ASTNode identifierUnit = element.getNode().findChildByType(TeoTypes.IDENTIFIER_UNIT);
        if (identifierUnit != null) {
            decoratorHighlight(identifierUnit, holder);
        }
    }

    private void highlightPipeline(@NotNull TeoPipelineImpl element, @NotNull AnnotationHolder holder) {
        ASTNode node = element.getNode();
        @NotNull ASTNode identifierUnit = Objects.requireNonNull(element.getNode().findChildByType(TeoTypes.IDENTIFIER_UNIT));
        pipelineHighlight(node, holder);
        pipelineHighlight(identifierUnit, holder);
    }

    private void decoratorHighlight(@NotNull ASTNode node, @NotNull AnnotationHolder holder) {
        @NotNull ASTNode[] children = node.getChildren(TeoTokenSets.DECORATOR_SET);
        for (ASTNode child : children) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(child.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.DECORATOR).create();
        }
    }

    private void pipelineHighlight(@NotNull ASTNode node, @NotNull AnnotationHolder holder) {
        @NotNull ASTNode[] children = node.getChildren(TeoTokenSets.PIPELINE_SET);
        for (ASTNode child : children) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(child.getTextRange())
                    .textAttributes(TeoSyntaxHighlighter.PIPELINE).create();
        }
    }
}
