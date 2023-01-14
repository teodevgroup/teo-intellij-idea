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

public class TeoUnitImpl extends ASTWrapperPsiElement implements TeoUnit {

  public TeoUnitImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TeoVisitor visitor) {
    visitor.visitUnit(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TeoVisitor) accept((TeoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TeoArgumentList> getArgumentListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeoArgumentList.class);
  }

  @Override
  @Nullable
  public TeoEnumChoiceLiteral getEnumChoiceLiteral() {
    return findChildByClass(TeoEnumChoiceLiteral.class);
  }

  @Override
  @Nullable
  public TeoGroup getGroup() {
    return findChildByClass(TeoGroup.class);
  }

  @Override
  @NotNull
  public List<TeoSubscript> getSubscriptList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeoSubscript.class);
  }

  @Override
  @Nullable
  public TeoTupleLiteral getTupleLiteral() {
    return findChildByClass(TeoTupleLiteral.class);
  }

}
