package io.teocloud.teointellijidea.ide.completion.handler;

import com.intellij.codeInsight.AutoPopupController;
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import io.teocloud.teointellijidea.lang.psi.TeoFile;
import org.jetbrains.annotations.NotNull;

public class TeoTypedHandler extends TypedHandlerDelegate {
    @Override
    public @NotNull Result checkAutoPopup(char charTyped, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        if (!(file instanceof TeoFile)) {
            return Result.CONTINUE;
        }
        if (charTyped == '@' || charTyped == '.' || charTyped == '$' || charTyped == '"') {
            AutoPopupController.getInstance(project).scheduleAutoPopup(editor);
            return Result.STOP;
        }
        return super.checkAutoPopup(charTyped, project, editor, file);
    }
}
