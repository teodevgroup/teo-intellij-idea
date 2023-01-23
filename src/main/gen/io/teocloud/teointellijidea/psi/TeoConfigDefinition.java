// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;

public interface TeoConfigDefinition extends TeoDeclaration {

  @NotNull
  TeoConfigKeywords getConfigKeywords();

  @NotNull
  List<TeoWs> getWsList();

  @NotNull
  TeoConfigBlock getConfigBlock();

}
