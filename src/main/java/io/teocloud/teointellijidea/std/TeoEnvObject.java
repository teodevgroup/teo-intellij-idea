package io.teocloud.teointellijidea.std;

import io.teocloud.teointellijidea.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.std.argument.types.TeoStdArgumentTypes;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TeoEnvObject extends TeoSubscriptableObject<String> {

    private static final TeoStdArgument returnType = new TeoStdArgument(TeoStdArgumentTypes.STRING, true);

    @Override
    public @Nullable TeoStdArgument getReturnType(String key) {
        return returnType;
    }
}
