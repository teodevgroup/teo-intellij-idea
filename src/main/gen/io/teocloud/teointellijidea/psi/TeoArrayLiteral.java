// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoArrayLiteral extends PsiElement {

  @NotNull
  List<TeoExpression> getExpressionList();

  @NotNull
  TeoPaddedBrackClose getPaddedBrackClose();

  @NotNull
  TeoPaddedBrackOpen getPaddedBrackOpen();

  @NotNull
  List<TeoPaddedComma> getPaddedCommaList();

}
