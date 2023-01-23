package io.teocloud.teointellijidea.lang.psi;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface TeoBlock extends TeoElement {

    List<TeoElement> getMembers();

    List<TeoMemberDeclaration> getMemberDeclarations();

    @Nullable TeoNamedElement findMemberByName(String name);
}
