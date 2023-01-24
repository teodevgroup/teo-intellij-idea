package io.teocloud.teointellijidea.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.lang.TeoFileType;
import io.teocloud.teointellijidea.lang.TeoLanguage;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    public List<TeoDeclaration> getDeclarations() {
        return List.of(findChildrenByClass(TeoDeclaration.class));
    }
}
