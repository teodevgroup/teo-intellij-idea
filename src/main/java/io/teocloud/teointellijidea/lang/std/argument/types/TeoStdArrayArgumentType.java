package io.teocloud.teointellijidea.lang.std.argument.types;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;
import org.jetbrains.annotations.Nullable;

public class TeoStdArrayArgumentType extends TeoStdArgumentType {
    public TeoStdArrayArgumentType(@Nullable TeoStdArgument[] itemArguments) {
        super("ARRAY", itemArguments);
    }
}
