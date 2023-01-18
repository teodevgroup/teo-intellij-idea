package io.teocloud.teointellijidea.completion.handler;

import com.intellij.codeInsight.AutoPopupController;
import com.intellij.codeInsight.completion.AddSpaceInsertHandler;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import org.jetbrains.annotations.NotNull;

public class TeoInsertHandler {
    static public InsertHandler<LookupElement> PARENS = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(@NotNull InsertionContext context, @NotNull LookupElement item) {
            ParenthesesInsertHandler.WITH_PARAMETERS.handleInsert(context, item);
            AutoPopupController.getInstance(context.getProject()).scheduleAutoPopup(context.getEditor());
        }
    };
}
