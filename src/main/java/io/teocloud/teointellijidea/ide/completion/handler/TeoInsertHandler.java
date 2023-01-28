package io.teocloud.teointellijidea.ide.completion.handler;

import com.intellij.codeInsight.AutoPopupController;
import com.intellij.codeInsight.completion.AddSpaceInsertHandler;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class TeoInsertHandler {
    static public InsertHandler<LookupElement> PARENS = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(@NotNull InsertionContext context, @NotNull LookupElement item) {
            ParenthesesInsertHandler.WITH_PARAMETERS.handleInsert(context, item);
            AutoPopupController.getInstance(context.getProject()).scheduleAutoPopup(context.getEditor());
        }
    };

    static public InsertHandler<LookupElement> CLEAR_STRING = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(@NotNull InsertionContext context, @NotNull LookupElement item) {
            Editor editor = context.getEditor();
            Document doc = context.getDocument();
            int offset = editor.getCaretModel().getCurrentCaret().getOffset();
            PsiElement element = context.getFile().findElementAt(offset);
            if (element != null) {
                TextRange range = element.getTextRange();
                doc.deleteString(range.getStartOffset(), range.getEndOffset());
                doc.insertString(range.getStartOffset(), "\"" + item.getLookupString() + "\"");
                editor.getCaretModel().moveToOffset(range.getStartOffset() + 1 + item.getLookupString().length());
            }
        }
    };
}
