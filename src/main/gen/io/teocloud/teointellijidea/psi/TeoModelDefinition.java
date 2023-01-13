// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoModelDefinition extends PsiElement {

  @NotNull
  List<TeoWsEol> getWsEolList();

  @NotNull
  List<TeoBlockDecorator> getBlockDecoratorList();

  @NotNull
  List<TeoFieldDefinition> getFieldDefinitionList();

  @Nullable
  TeoItemDecoratorList getItemDecoratorList();

  @NotNull
  TeoModelName getModelName();

}
