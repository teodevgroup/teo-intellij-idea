package io.teocloud.teointellijidea.completion.providers;

import com.intellij.codeInsight.completion.AddSpaceInsertHandler;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TeoKeywordCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        result.addAllElements(List.of(keywords));
    }

    static LookupElementBuilder[] keywords = new LookupElementBuilder[]{
            createKeyword("let"),
            createKeyword("import"),
            createKeyword("model"),
            createKeyword("enum"),
            createKeyword("connector"),
            createKeyword("config"),
            createKeyword("client"),
            createKeyword("entity"),
    };

    private static LookupElementBuilder createKeyword(String name) {
        return LookupElementBuilder
                .create(name)
                .withPresentableText(name)
                .withInsertHandler(AddSpaceInsertHandler.INSTANCE)
                .bold();
    }
}
