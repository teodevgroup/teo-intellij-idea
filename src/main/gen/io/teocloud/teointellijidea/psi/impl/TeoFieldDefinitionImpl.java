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

public class TeoFieldDefinitionImpl extends ASTWrapperPsiElement implements TeoFieldDefinition {

  public TeoFieldDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TeoVisitor visitor) {
    visitor.visitFieldDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TeoVisitor) accept((TeoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TeoWs> getWsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeoWs.class);
  }

  @Override
  @Nullable
  public TeoDocCommentBlock getDocCommentBlock() {
    return findChildByClass(TeoDocCommentBlock.class);
  }

  @Override
  @NotNull
  public TeoFieldName getFieldName() {
    return findNotNullChildByClass(TeoFieldName.class);
  }

  @Override
  @NotNull
  public TeoFieldType getFieldType() {
    return findNotNullChildByClass(TeoFieldType.class);
  }

  @Override
  @Nullable
  public TeoItemDecoratorList getItemDecoratorList() {
    return findChildByClass(TeoItemDecoratorList.class);
  }

}
