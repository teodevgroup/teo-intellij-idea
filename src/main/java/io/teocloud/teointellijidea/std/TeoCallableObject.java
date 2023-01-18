package io.teocloud.teointellijidea.std;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import io.teocloud.teointellijidea.completion.handler.TeoInsertHandler;
import io.teocloud.teointellijidea.psi.TeoArgumentList;
import org.jetbrains.annotations.Nullable;

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

    public @Nullable InsertHandler<LookupElement> matchedInsertHandler() {
        if (this.allowedArgumentLists.length == 0) {
            return null;
        }
        for (TeoStdArgumentList list: this.allowedArgumentLists) {
            if (list.isEmpty()) {
                return null;
            }
        }
        return TeoInsertHandler.PARENS;
    }
}
