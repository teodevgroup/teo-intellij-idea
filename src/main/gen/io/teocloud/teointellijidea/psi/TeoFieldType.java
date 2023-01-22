// This is a generated file. Not intended for manual editing.
package io.teocloud.teointellijidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeoFieldType extends PsiElement {

  @Nullable
  TeoArity getArity();

  @Nullable
  TeoCollectionOptional getCollectionOptional();

  @Nullable
  TeoItemOptional getItemOptional();

  @Nullable
  TeoBuiltinType getBuiltinType();

  @Nullable
  TeoUserType getUserType();

}
