package io.teocloud.teointellijidea.std;

public class TeoPipelineModifierObject extends TeoCallableObject {

    private final String name;

    public TeoPipelineModifierObject(String name, TeoStdArgumentList[] argumentLists) {
        super(argumentLists);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
