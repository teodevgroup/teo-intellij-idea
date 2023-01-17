package io.teocloud.teointellijidea.std;

import io.teocloud.teointellijidea.std.argument.TeoStdArgument;

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
