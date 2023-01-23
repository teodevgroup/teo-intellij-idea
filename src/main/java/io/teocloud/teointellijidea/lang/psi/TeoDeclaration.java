package io.teocloud.teointellijidea.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public interface TeoDeclaration extends TeoNameIdentifierOwner {

    PsiElement getKeywordElement();

    @Nullable TeoBlock getBlock();

    List<TeoMemberDeclaration> getMembers();

    TeoMemberDeclaration findMemberByName(String name);
}
