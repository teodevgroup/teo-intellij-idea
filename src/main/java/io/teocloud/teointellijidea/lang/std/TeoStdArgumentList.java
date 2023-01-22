package io.teocloud.teointellijidea.lang.std;

import io.teocloud.teointellijidea.lang.std.argument.TeoStdArgument;

import java.util.ArrayList;
import java.util.List;

public class TeoStdArgumentList extends ArrayList<TeoStdArgument> {
    public TeoStdArgumentList(List<TeoStdArgument> arguments) {
        super();
        addAll(arguments);
    }

    public TeoStdArgumentList() {
        super();
    }
}
