package io.teocloud.teointellijidea.lang.std;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import io.teocloud.teointellijidea.ide.completion.handler.TeoInsertHandler;
import org.jetbrains.annotations.Nullable;

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
