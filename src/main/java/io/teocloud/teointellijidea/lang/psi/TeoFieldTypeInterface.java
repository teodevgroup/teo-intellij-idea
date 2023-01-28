package io.teocloud.teointellijidea.lang.psi;

import com.intellij.openapi.util.TextRange;
import io.teocloud.teointellijidea.psi.TeoFieldType;

public interface TeoFieldTypeInterface extends TeoElement {

    boolean isUserType();

    boolean isBuiltinType();

    String getTypeText();

    TextRange getTypeTextRange();
}
