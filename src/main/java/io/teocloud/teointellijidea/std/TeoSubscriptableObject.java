package io.teocloud.teointellijidea.std;

import io.teocloud.teointellijidea.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.std.argument.types.TeoStdArgumentTypes;
import org.jetbrains.annotations.Nullable;
import java.util.Map;

public class TeoSubscriptableObject<T> extends TeoObject {

    public @Nullable TeoStdArgument getReturnType(T key) {
        return new TeoStdArgument(TeoStdArgumentTypes.NULL, false);
    }
}
