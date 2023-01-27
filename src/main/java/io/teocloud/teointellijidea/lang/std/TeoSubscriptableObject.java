package io.teocloud.teointellijidea.lang.std;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.lang.std.type.TeoStdTypes;
import org.jetbrains.annotations.Nullable;

public class TeoSubscriptableObject<T> extends TeoObject {

    public @Nullable TeoStdArgument getReturnType(T key) {
        return new TeoStdArgument(TeoStdTypes.NULL, false);
    }
}
