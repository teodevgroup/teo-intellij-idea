package io.teocloud.teointellijidea.ide.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import io.teocloud.teointellijidea.ide.completion.providers.*;
import io.teocloud.teointellijidea.psi.*;

public class TeoCompletionContributor extends CompletionContributor {
    public TeoCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(TeoTypes.STRING_LITERAL).withParent(TeoImportStatement.class),
                new TeoFileNameCompletionProvider());
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
        extend(CompletionType.BASIC,
                PlatformPatterns.or(
                        PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).andOr(
                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoExpression.class)
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withSuperParent(2, TeoExpression.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withSuperParent(3, TeoExpression.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withSuperParent(4, TeoExpression.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(GeneratedParserUtilBase.DummyBlock.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(DummyHolder.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoUnit.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoGroup.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoArgument.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withParent(TeoNamedArgument.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withSuperParent(2, TeoUnit.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withSuperParent(2, TeoGroup.class),
//                                PlatformPatterns.psiElement(TeoTypes.IDENTIFIER).withSuperParent(2, TeoNamedArgument.class)
                        )
                ), new TeoIdentifierCompletionProvider());
    }
}
