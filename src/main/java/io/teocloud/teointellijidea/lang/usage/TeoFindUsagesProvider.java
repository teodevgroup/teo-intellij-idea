package io.teocloud.teointellijidea.lang.usage;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import io.teocloud.teointellijidea.lang.lexer.TeoFlexLexerAdapter;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoTokenSets;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeoFindUsagesProvider implements FindUsagesProvider {

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new TeoFlexLexerAdapter(),
                TeoTokenSets.IDENTIFIERS,
                TeoTokenSets.COMMENTS,
                TokenSet.EMPTY);
    }
    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return true;
        //return psiElement.getNode().getElementType() == TeoTypes.;
    }

    @Override
    public @Nullable @NonNls String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @Override
    public @Nls @NotNull String getType(@NotNull PsiElement element) {
        return "Type";
    }

    @Override
    public @Nls @NotNull String getDescriptiveName(@NotNull PsiElement element) {
        return element.getText();
    }

    @Override
    public @Nls @NotNull String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return "Node text";
    }
}
