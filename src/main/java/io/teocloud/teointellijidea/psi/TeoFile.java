package io.teocloud.teointellijidea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import io.teocloud.teointellijidea.TeoFileType;
import io.teocloud.teointellijidea.TeoLanguage;
import org.jetbrains.annotations.NotNull;

public class TeoFile extends PsiFileBase {

    public TeoFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, TeoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TeoFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Teo File";
    }

}
