package io.teocloud.teointellijidea.completion.providers;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import com.intellij.icons.AllIcons;


public class TeoFieldTypeCompletionProvider extends CompletionProvider<CompletionParameters> {
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        for (LookupElementBuilder element : builtinTypes) {
            result.addElement(element);
        }
    }

    static LookupElementBuilder[] builtinTypes = new LookupElementBuilder[]{
            createBuiltinType("String"),
            createBuiltinType("Bool"),
            createBuiltinType("Int"),
            createBuiltinType("Int32"),
            createBuiltinType("Int64"),
            createBuiltinType("Float"),
            createBuiltinType("Float32"),
            createBuiltinType("Float64"),
            createBuiltinType("Date"),
            createBuiltinType("DateTime"),
    };

    static LookupElementBuilder createBuiltinType(String name) {
        return LookupElementBuilder
                .create(name)
                .withPresentableText(name)
                .withTypeText("builtin", true)
                .withIcon(AllIcons.Nodes.Type)
                .bold();
    }
}
