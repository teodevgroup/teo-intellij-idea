package io.teocloud.teointellijidea.lang.std.argument;

import io.teocloud.teointellijidea.lang.std.type.TeoStdType;
import org.jetbrains.annotations.Nullable;

public class TeoStdArgument {

    private final TeoStdType type;

    private final boolean optional;

    private @Nullable final String name;

    public TeoStdArgument(TeoStdType type, boolean optional) {
        this.type = type;
        this.optional = optional;
        this.name = null;
    }

    public TeoStdArgument(TeoStdType type, boolean optional, @Nullable String name) {
        this.type = type;
        this.optional = optional;
        this.name = name;
    }

    public TeoStdType getType() {
        return this.type;
    }

    public boolean getOptional() {
        return this.optional;
    }

    public @Nullable String getName() {
        return this.name;
    }
}
