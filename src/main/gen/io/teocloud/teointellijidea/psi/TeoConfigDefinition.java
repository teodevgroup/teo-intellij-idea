// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoKeyValuePairDeclaration;

public interface TeoConfigDefinition extends TeoDeclaration, TeoKeyValuePairDeclaration {

  @NotNull
  List<TeoWs> getWsList();

  @NotNull
  TeoConfigBlock getConfigBlock();

}
