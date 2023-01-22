package io.teocloud.teointellijidea.lang.std;

public class TeoDecoratorObject extends TeoCallableObject {

    private final String name;

    public TeoDecoratorObject(String name, TeoStdArgumentList[] argumentLists) {
        super(argumentLists);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
