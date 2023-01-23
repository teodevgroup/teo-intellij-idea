// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;

public interface TeoFieldDefinition extends TeoMemberDeclaration {

  @NotNull
  List<TeoWs> getWsList();

  @Nullable
  TeoDocCommentBlock getDocCommentBlock();

  @NotNull
  TeoFieldType getFieldType();

  @Nullable
  TeoItemDecoratorList getItemDecoratorList();

}
