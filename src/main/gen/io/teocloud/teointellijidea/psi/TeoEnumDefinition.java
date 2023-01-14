// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoEnumDefinition extends PsiElement {

  @NotNull
  List<TeoBlockDecorator> getBlockDecoratorList();

  @NotNull
  List<TeoComment> getCommentList();

  @Nullable
  TeoDocComment getDocComment();

  @NotNull
  TeoEnumName getEnumName();

  @NotNull
  List<TeoEnumValueDeclaration> getEnumValueDeclarationList();

  @Nullable
  TeoItemDecoratorList getItemDecoratorList();

}
