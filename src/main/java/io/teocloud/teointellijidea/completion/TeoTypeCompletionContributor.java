package io.teocloud.teointellijidea.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import io.teocloud.teointellijidea.completion.providers.TeoFieldTypeCompletionProvider;
import io.teocloud.teointellijidea.psi.TeoFieldType;
import io.teocloud.teointellijidea.psi.TeoTypes;

public class TeoTypeCompletionContributor extends CompletionContributor {
    public TeoTypeCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoFieldType.class),
                new TeoFieldTypeCompletionProvider());
    }
}
