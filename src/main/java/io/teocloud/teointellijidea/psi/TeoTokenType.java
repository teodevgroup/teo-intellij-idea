package io.teocloud.teointellijidea.psi;

import com.intellij.psi.tree.IElementType;
import io.teocloud.teointellijidea.TeoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class TeoTokenType extends IElementType {

    public TeoTokenType(@NotNull @NonNls String debugName) {
        super(debugName, TeoLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "TeoTokenType." + super.toString();
    }
}
