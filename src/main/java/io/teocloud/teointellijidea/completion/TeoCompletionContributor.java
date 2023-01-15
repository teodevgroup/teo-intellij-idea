package io.teocloud.teointellijidea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.IconLoader;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.intellij.openapi.util.Iconable;
import io.teocloud.teointellijidea.completion.providers.TeoFieldTypeCompletionProvider;
import io.teocloud.teointellijidea.psi.TeoFieldType;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;

public class TeoCompletionContributor extends CompletionContributor {

    public TeoCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoFieldType.class),
                new TeoFieldTypeCompletionProvider());
    }
}
