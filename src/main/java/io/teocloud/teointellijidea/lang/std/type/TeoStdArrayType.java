package io.teocloud.teointellijidea.lang.std.type;

import org.jetbrains.annotations.NotNull;

public class TeoStdArrayType extends TeoStdType {
    public TeoStdArrayType(@NotNull TeoStdType itemType) {
        super(new TeoStdType[]{itemType});
    }
}
