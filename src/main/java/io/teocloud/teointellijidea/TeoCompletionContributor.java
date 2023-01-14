package io.teocloud.teointellijidea;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;

public class TeoCompletionContributor extends CompletionContributor {

    public TeoCompletionContributor() {

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(TeoTypes.IDENTIFIER),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("String"));
                        resultSet.addElement(LookupElementBuilder.create("Bool"));
                        resultSet.addElement(LookupElementBuilder.create("Int"));
                        resultSet.addElement(LookupElementBuilder.create("Int32"));
                        resultSet.addElement(LookupElementBuilder.create("Int64"));
                        resultSet.addElement(LookupElementBuilder.create("Float"));
                        resultSet.addElement(LookupElementBuilder.create("Float32"));
                        resultSet.addElement(LookupElementBuilder.create("Float64"));
                        resultSet.addElement(LookupElementBuilder.create("Date"));
                        resultSet.addElement(LookupElementBuilder.create("DateTime"));
                    }
                }
        );
    }

}
