// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoConfigBlock extends PsiElement {

  @NotNull
  TeoConfigKeywords getConfigKeywords();

  @NotNull
  List<TeoComment> getCommentList();

  @NotNull
  List<TeoConfigItem> getConfigItemList();

}
