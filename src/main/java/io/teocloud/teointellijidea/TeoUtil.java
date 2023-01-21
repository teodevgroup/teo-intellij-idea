package io.teocloud.teointellijidea;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.psi.TeoEnumDefinition;
import io.teocloud.teointellijidea.psi.TeoFile;
import io.teocloud.teointellijidea.psi.TeoModelDefinition;
import java.util.*;

public class TeoUtil {

    public static List<TeoModelDefinition> findModelDefinitions(Project project) {
        List<TeoModelDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile simpleFile = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                TeoModelDefinition[] models = PsiTreeUtil.getChildrenOfType(simpleFile, TeoModelDefinition.class);
                if (models != null) {
                    result.addAll(List.of(models));
                }
            }
        }
        return result;
    }

    public static List<TeoEnumDefinition> findEnumDefinitions(Project project) {
        List<TeoEnumDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile simpleFile = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                TeoEnumDefinition[] enums = PsiTreeUtil.getChildrenOfType(simpleFile, TeoEnumDefinition.class);
                if (enums != null) {
                    result.addAll(List.of(enums));
                }
            }
        }
        return result;
    }
}
