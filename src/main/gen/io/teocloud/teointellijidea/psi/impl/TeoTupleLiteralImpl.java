// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.teocloud.teointellijidea.psi.TeoTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.teocloud.teointellijidea.psi.*;

public class TeoTupleLiteralImpl extends ASTWrapperPsiElement implements TeoTupleLiteral {

  public TeoTupleLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TeoVisitor visitor) {
    visitor.visitTupleLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TeoVisitor) accept((TeoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TeoWsEol> getWsEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeoWsEol.class);
  }

  @Override
  @NotNull
  public List<TeoExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeoExpression.class);
  }

  @Override
  @NotNull
  public List<TeoPaddedComma> getPaddedCommaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeoPaddedComma.class);
  }

}
