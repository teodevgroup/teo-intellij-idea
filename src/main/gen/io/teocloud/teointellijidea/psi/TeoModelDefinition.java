// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoModelDefinition extends PsiElement {

  @NotNull
  List<TeoWs> getWsList();

  @Nullable
  TeoDocCommentBlock getDocCommentBlock();

  @Nullable
  TeoItemDecoratorList getItemDecoratorList();

  @NotNull
  TeoModelDefinitionBlock getModelDefinitionBlock();

  @NotNull
  TeoModelName getModelName();

}
