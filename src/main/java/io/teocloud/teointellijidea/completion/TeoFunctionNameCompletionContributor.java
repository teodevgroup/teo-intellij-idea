package io.teocloud.teointellijidea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.completion.providers.TeoModelDecoratorCompletionProvider;
import io.teocloud.teointellijidea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeoFunctionNameCompletionContributor extends CompletionContributor {
    public TeoFunctionNameCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                        .withParent(TeoInitialUnitIdentifier.class)
                        .withSuperParent(2, TeoIdentifierUnit.class)
                        .andOr(
                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                                        .withSuperParent(5, TeoModelDefinition.class),
                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                                        .withSuperParent(3, TeoBlockDecorator.class)),
                new TeoModelDecoratorCompletionProvider());
    }

    @Override
    public @Nullable AutoCompletionDecision handleAutoCompletionPossibility(@NotNull AutoCompletionContext context) {
        System.out.println("HANDLE");
        Project project = context.getParameters().getOriginalFile().getProject();
        Editor editor = context.getParameters().getEditor();
        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        int start = primaryCaret.getSelectionStart();
        Document document = editor.getDocument();
        WriteCommandAction.runWriteCommandAction(project, () ->
                document.insertString(start, "()")
        );
        return super.handleAutoCompletionPossibility(context);
    }
}
