package io.teocloud.teointellijidea.std;

import io.teocloud.teointellijidea.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.std.argument.types.TeoStdArgumentTypes;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TeoDictionaryObject extends TeoSubscriptableObject<String> {

    private final Map<String, TeoStdArgument> map;

    public TeoDictionaryObject(Map<String, TeoStdArgument> map) {
        this.map = map;
    }

    public Map<String, TeoStdArgument> getMap() {
        return map;
    }

    public @Nullable TeoStdArgument getReturnType(String key) {
        return map.get(key);
    }

}
