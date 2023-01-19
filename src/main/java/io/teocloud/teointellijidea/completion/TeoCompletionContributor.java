package io.teocloud.teointellijidea.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import io.teocloud.teointellijidea.completion.providers.TeoFieldTypeCompletionProvider;
import io.teocloud.teointellijidea.completion.providers.TeoKeywordCompletionProvider;
import io.teocloud.teointellijidea.completion.providers.TeoModelDecoratorCompletionProvider;
import io.teocloud.teointellijidea.psi.*;

public class TeoCompletionContributor extends CompletionContributor {
    public TeoCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoFieldType.class),
                new TeoFieldTypeCompletionProvider());
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                        .withParent(TeoInitialUnitIdentifier.class)
                        .withSuperParent(2, TeoIdentifierUnit.class)
                        .andOr(
                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                                        .withSuperParent(5, TeoModelDefinition.class),
                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                                        .withSuperParent(3, TeoBlockDecorator.class),
                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                                        .withSuperParent(3, TeoBadTopDecorator.class)),
                new TeoModelDecoratorCompletionProvider());
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER)
                        .withParent(TeoBadTopIdentifier.class), new TeoKeywordCompletionProvider());
    }
}
