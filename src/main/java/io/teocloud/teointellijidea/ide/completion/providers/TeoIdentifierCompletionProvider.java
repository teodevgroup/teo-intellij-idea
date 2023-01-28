package io.teocloud.teointellijidea.ide.completion.providers;

import com.intellij.codeInsight.completion.AddSpaceInsertHandler;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TeoIdentifierCompletionProvider extends CompletionProvider<CompletionParameters> {
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        result.addAllElements(List.of(keywords));
    }

    static LookupElementBuilder[] keywords = new LookupElementBuilder[]{
            createKeyword("var1"),
            createKeyword("var2"),
            createKeyword("var3"),
            createKeyword("var4"),
            createKeyword("var5"),
            createKeyword("var6"),
            createKeyword("var7"),
            createKeyword("var8"),
    };

    private static LookupElementBuilder createKeyword(String name) {
        return LookupElementBuilder
                .create(name)
                .withPresentableText(name);
    }
}
