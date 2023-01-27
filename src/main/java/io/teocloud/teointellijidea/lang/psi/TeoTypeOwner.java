package io.teocloud.teointellijidea.lang.psi;

import io.teocloud.teointellijidea.lang.std.type.TeoStdType;

public interface TeoTypeOwner extends TeoElement {
    TeoStdType getType();
}
