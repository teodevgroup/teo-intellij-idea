package io.teocloud.teointellijidea.lang.psi;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public interface TeoDeclaration extends TeoNameIdentifierOwner {
    @Nullable TeoBlock getBlock();

    List<TeoMemberDeclaration> getMembers();

    TeoMemberDeclaration findMemberByName(String name);
}
