package io.teocloud.teointellijidea.lang.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.impl.PsiElementFactoryImpl;
import io.teocloud.teointellijidea.lang.TeoFileType;
import io.teocloud.teointellijidea.psi.TeoLetDeclaration;

import java.util.List;

public class TeoElementFactory {
    public static PsiElement createIdentifier(String name, Project project) {
        final TeoFile file = (TeoFile) PsiFileFactory.getInstance(project)
                .createFileFromText("_dummy.teo", TeoFileType.INSTANCE, "let " + name + " = 2");
        final List<TeoDeclaration> declarations = file.getDeclarations();
        final TeoLetDeclaration let = (TeoLetDeclaration) declarations.get(0);
        return let.getIdentifyingElement();
    }
}
