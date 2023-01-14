package io.teocloud.teointellijidea;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.psi.TeoConfigItemName;
import io.teocloud.teointellijidea.psi.TeoEnumChoiceLiteral;
import io.teocloud.teointellijidea.psi.TeoFieldName;
import io.teocloud.teointellijidea.psi.impl.TeoConfigItemImpl;
import io.teocloud.teointellijidea.psi.impl.TeoFieldTypeImpl;
import io.teocloud.teointellijidea.psi.impl.TeoModelNameImpl;
import org.jetbrains.annotations.NotNull;

public class TeoAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof TeoModelNameImpl) {
            holder
                .newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(TeoSyntaxHighlighter.MODEL_NAME).create();
        } else if (element instanceof TeoConfigItemName) {
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
    }
}
