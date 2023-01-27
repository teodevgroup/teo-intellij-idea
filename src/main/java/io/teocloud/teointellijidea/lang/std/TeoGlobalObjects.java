package io.teocloud.teointellijidea.lang.std;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;
import io.teocloud.teointellijidea.lang.std.type.TeoStdType;
import io.teocloud.teointellijidea.lang.std.type.TeoStdTypes;
import io.teocloud.teointellijidea.lang.std.type.TeoStdArrayType;

import java.util.List;
import java.util.Map;

public class TeoGlobalObjects {

    public static final Map<String, TeoModelDecoratorObject> MODEL_DECORATORS = Map.of(
        "map", new TeoModelDecoratorObject("map", new TeoStdArgumentList[]{
                new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdTypes.STRING, false)))
            }),
            "url", new TeoModelDecoratorObject("url", new TeoStdArgumentList[]{
                new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdTypes.STRING, false)))
            }),
            "identity", new TeoModelDecoratorObject("identity", new TeoStdArgumentList[]{
                    new TeoStdArgumentList()
            }),
            "id", new TeoModelDecoratorObject("id", new TeoStdArgumentList[]{
                    new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdTypes.SCALAR_FIELD_ENUM, false))),
                    new TeoStdArgumentList(List.of(new TeoStdArgument(new TeoStdArrayType(TeoStdTypes.SCALAR_FIELD_ENUM), false)))
            }),
            "unique", new TeoModelDecoratorObject("unique", new TeoStdArgumentList[]{
                    new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdTypes.SCALAR_FIELD_ENUM, false))),
                    new TeoStdArgumentList(List.of(new TeoStdArgument(new TeoStdArrayType(TeoStdTypes.SCALAR_FIELD_ENUM), false))),
            }),
            "index", new TeoModelDecoratorObject("index", new TeoStdArgumentList[]{
                    new TeoStdArgumentList(List.of(new TeoStdArgument(TeoStdTypes.SCALAR_FIELD_ENUM, false))),
                    new TeoStdArgumentList(List.of(new TeoStdArgument(new TeoStdArrayType(TeoStdTypes.SCALAR_FIELD_ENUM), false))),
            }),
            "virtual", new TeoModelDecoratorObject("virtual", new TeoStdArgumentList[]{})
    );
}
