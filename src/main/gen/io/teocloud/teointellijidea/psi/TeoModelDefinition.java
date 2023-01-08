// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoModelDefinition extends PsiElement {

  @NotNull
  List<TeoBlockDecorator> getBlockDecoratorList();

  @NotNull
  List<TeoFieldDefinition> getFieldDefinitionList();

  @NotNull
  List<TeoItemDecorator> getItemDecoratorList();

}
