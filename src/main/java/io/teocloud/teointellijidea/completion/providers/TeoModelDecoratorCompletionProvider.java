package io.teocloud.teointellijidea.completion.providers;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.util.ProcessingContext;
import io.teocloud.teointellijidea.std.TeoGlobalObjects;
import io.teocloud.teointellijidea.std.TeoModelDecoratorObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TeoModelDecoratorCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        result.addAllElements(getGlobalModelDecoratorCandidates());
    }

    private static ArrayList<LookupElementBuilder> getGlobalModelDecoratorCandidates() {
        ArrayList<LookupElementBuilder> elements = new ArrayList<>();
        for (TeoModelDecoratorObject object : TeoGlobalObjects.MODEL_DECORATORS.values()) {
            elements.add(LookupElementBuilder
                    .create(object.getName())
                    .withTypeText("builtin")
                    .withIcon(AllIcons.Nodes.Function)
                    .bold());
        }
        return elements;
    }

}
