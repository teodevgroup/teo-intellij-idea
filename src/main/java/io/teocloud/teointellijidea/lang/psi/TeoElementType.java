package io.teocloud.teointellijidea.lang.psi;

import com.intellij.psi.tree.IElementType;
import io.teocloud.teointellijidea.lang.TeoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class TeoElementType extends IElementType {

    public TeoElementType(@NotNull @NonNls String debugName) {
        super(debugName, TeoLanguage.INSTANCE);
    }
}
