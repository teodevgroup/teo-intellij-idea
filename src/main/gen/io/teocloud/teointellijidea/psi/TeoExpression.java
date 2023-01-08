// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoExpression extends PsiElement {

  @NotNull
  List<TeoArgumentList> getArgumentListList();

  @Nullable
  TeoGroup getGroup();

  @Nullable
  TeoLiteral getLiteral();

  @Nullable
  TeoNullishCoalescing getNullishCoalescing();

}
