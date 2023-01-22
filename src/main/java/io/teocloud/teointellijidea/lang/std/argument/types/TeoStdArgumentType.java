package io.teocloud.teointellijidea.lang.std.argument.types;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;

import javax.annotation.Nullable;

public class TeoStdArgumentType {
    private final String identifier;
    @Nullable private final TeoStdArgument[] itemArguments;

    protected TeoStdArgumentType(String identifier, @Nullable TeoStdArgument[] itemArguments) {
        this.identifier = identifier;
        this.itemArguments = itemArguments;
    }

    protected TeoStdArgumentType(String identifier) {
        this.identifier = identifier;
        this.itemArguments = null;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public TeoStdArgument[] getItemArguments() {
        return this.itemArguments;
    }
}
