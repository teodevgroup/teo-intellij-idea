package io.teocloud.teointellijidea;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.psi.*;
import io.teocloud.teointellijidea.psi.impl.*;
import org.jetbrains.annotations.NotNull;

public class TeoAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
//        if (element instanceof TeoEnumChoiceLiteral) {
//            holder
//                .newSilentAnnotation(HighlightSeverity.INFORMATION)
//                .range(element.getTextRange())
//                .textAttributes(TeoSyntaxHighlighter.ENUM_MEMBER).create();
//        }
    }
}
