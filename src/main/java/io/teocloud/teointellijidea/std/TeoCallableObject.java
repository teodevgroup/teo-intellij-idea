package io.teocloud.teointellijidea.std;

import java.util.ArrayList;

public class TeoCallableObject extends TeoObject {

    private final TeoStdArgumentList[] allowedArgumentLists;

    public TeoCallableObject(TeoStdArgumentList[] argumentLists) {
        super();
        this.allowedArgumentLists = argumentLists;
    }

    public TeoStdArgumentList[] getAllowedArgumentLists() {
        return allowedArgumentLists;
    }
}
