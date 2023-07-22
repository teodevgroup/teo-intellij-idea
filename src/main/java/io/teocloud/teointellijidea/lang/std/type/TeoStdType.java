package io.teocloud.teointellijidea.lang.std.type;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;


public class TeoStdType {
    private final boolean optional;
    @Nullable private final TeoStdType[] itemTypes;

    public TeoStdType(boolean optional, @Nullable TeoStdType[] itemTypes) {
        this.optional = optional;
        this.itemTypes = itemTypes;
    }

    public TeoStdType(@Nullable TeoStdType[] itemTypes) {
        this.optional = false;
        this.itemTypes = itemTypes;
    }

    public TeoStdType(boolean optional) {
        this.optional = optional;
        this.itemTypes = null;
    }

    public TeoStdType() {
        this.optional = false;
        this.itemTypes = null;
    }

    public TeoStdType[] getItemTypes() {
        return this.itemTypes;
    }

    public boolean getOptional() {
        return this.optional;
    }
}
