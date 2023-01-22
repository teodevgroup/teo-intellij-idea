package io.teocloud.teointellijidea.lang.std;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.lang.std.argument.types.TeoStdArgumentTypes;
import org.jetbrains.annotations.Nullable;

public class TeoEnvObject extends TeoSubscriptableObject<String> {

    private static final TeoStdArgument returnType = new TeoStdArgument(TeoStdArgumentTypes.STRING, true);

    @Override
    public @Nullable TeoStdArgument getReturnType(String key) {
        return returnType;
    }
}
