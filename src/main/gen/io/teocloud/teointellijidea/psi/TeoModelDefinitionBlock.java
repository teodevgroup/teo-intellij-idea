// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoModelDefinitionBlock extends PsiElement {

  @NotNull
  List<TeoWs> getWsList();

  @NotNull
  List<TeoBlockDecorator> getBlockDecoratorList();

  @NotNull
  List<TeoComment> getCommentList();

  @NotNull
  List<TeoFieldDefinition> getFieldDefinitionList();

}
