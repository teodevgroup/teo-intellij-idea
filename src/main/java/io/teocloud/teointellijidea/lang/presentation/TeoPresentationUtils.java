package io.teocloud.teointellijidea.lang.presentation;

import com.intellij.icons.AllIcons;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import io.teocloud.teointellijidea.lang.psi.TeoElement;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import io.teocloud.teointellijidea.psi.*;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TeoPresentationUtils {

    public static final TeoPresentationUtils INSTANCE = new TeoPresentationUtils();

    public ItemPresentation getPresentation(TeoElement element) {
        return new ItemPresentation() {
            @Override
            public @Nullable String getPresentableText() {
                if (element instanceof TeoNamedElement) {
                    return ((TeoNamedElement) element).getName();
                }
                return null;
            }

            @Override
            public String getLocationString() {
                PsiFile file = element.getContainingFile();
                if (file == null) {
                    return null;
                }
                Project project = file.getProject();
                String projectPath = project.getBasePath();
                VirtualFile virtualFile = file.getOriginalFile().getVirtualFile();
                String path = virtualFile.getPath();
                Path pathAbsolute = Paths.get(path);
                assert projectPath != null;
                Path pathBase = Paths.get(projectPath);
                Path pathRelative = pathBase.relativize(pathAbsolute);
                return pathRelative.toString();
            }

            @Override
            public @Nullable Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

    public @Nullable Icon getIcon(TeoNamedElement element) {
        if (element instanceof TeoModelDefinition) {
            return AllIcons.Nodes.Method;
        } else if (element instanceof TeoEnumDefinition) {
            return AllIcons.Nodes.Enum;
        } else if (element instanceof TeoConfigDefinition) {
            return AllIcons.Nodes.Plugin;
        } else if (element instanceof TeoLetDeclaration) {
            return AllIcons.Nodes.Constant;
        } else if (element instanceof TeoFieldDefinition) {
            return AllIcons.Nodes.Field;
        } else if (element instanceof TeoEnumValueDeclaration) {
            return AllIcons.Nodes.Variable;
        } else if (element instanceof TeoConfigItem) {
            return AllIcons.Nodes.Variable;
        }
        return null;
    }
}
