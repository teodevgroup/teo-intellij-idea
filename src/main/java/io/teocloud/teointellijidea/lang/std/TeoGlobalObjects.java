package io.teocloud.teointellijidea.lang.std;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.lang.std.argument.types.TeoStdArgumentTypes;
import io.teocloud.teointellijidea.lang.std.argument.types.TeoStdArrayArgumentType;

import java.util.List;
import java.util.Map;

public class TeoGlobalObjects {

    public static final Map<String, TeoModelDecoratorObject> MODEL_DECORATORS = Map.of(
        "map", new TeoModelDecoratorObject("map", new TeoStdArgumentList[]{
                new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdArgumentTypes.STRING, false)))
            }),
            "url", new TeoModelDecoratorObject("url", new TeoStdArgumentList[]{
                new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdArgumentTypes.STRING, false)))
            }),
            "identity", new TeoModelDecoratorObject("identity", new TeoStdArgumentList[]{
                    new TeoStdArgumentList()
            }),
            "id", new TeoModelDecoratorObject("id", new TeoStdArgumentList[]{
                    new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdArgumentTypes.ENUM_MODEL_SCALAR_FIELDS, false))),
                    new TeoStdArgumentList(List.of(new TeoStdArgument(new TeoStdArrayArgumentType(new TeoStdArgument[]{new TeoStdArgument(TeoStdArgumentTypes.ENUM_MODEL_SCALAR_FIELDS, false)}), false))),
            }),
            "unique", new TeoModelDecoratorObject("unique", new TeoStdArgumentList[]{
                    new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdArgumentTypes.ENUM_MODEL_SCALAR_FIELDS, false))),
                    new TeoStdArgumentList(List.of(new TeoStdArgument(new TeoStdArrayArgumentType(new TeoStdArgument[]{new TeoStdArgument(TeoStdArgumentTypes.ENUM_MODEL_SCALAR_FIELDS, false)}), false))),
            }),
            "index", new TeoModelDecoratorObject("index", new TeoStdArgumentList[]{
                    new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdArgumentTypes.ENUM_MODEL_SCALAR_FIELDS, false))),
                    new TeoStdArgumentList(List.of(new TeoStdArgument(new TeoStdArrayArgumentType(new TeoStdArgument[]{new TeoStdArgument(TeoStdArgumentTypes.ENUM_MODEL_SCALAR_FIELDS, false)}), false))),
            }),
            "virtual", new TeoModelDecoratorObject("virtual", new TeoStdArgumentList[]{})
    );
}
