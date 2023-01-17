package io.teocloud.teointellijidea.std.argument;

import io.teocloud.teointellijidea.std.argument.types.TeoStdArgumentType;
import org.jetbrains.annotations.Nullable;

public class TeoStdArgument {

    private final TeoStdArgumentType type;

    private final boolean optional;

    private @Nullable final String name;

    public TeoStdArgument(TeoStdArgumentType type, boolean optional) {
        this.type = type;
        this.optional = optional;
        this.name = null;
    }

    public TeoStdArgument(TeoStdArgumentType type, boolean optional, @Nullable String name) {
        this.type = type;
        this.optional = optional;
        this.name = name;
    }

    public TeoStdArgumentType getType() {
        return this.type;
    }

    public boolean getOptional() {
        return this.optional;
    }

    public @Nullable String getName() {
        return this.name;
    }
}
