package io.teocloud.teointellijidea;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.psi.TeoFile;
import io.teocloud.teointellijidea.psi.TeoProperty;
import org.jetbrains.annotations.NotNull;
import java.util.*;

public class TeoUtil {

    /**
     * Searches the entire project for Simple language files with instances of the Simple property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<TeoProperty> findProperties(Project project, String key) {
        List<TeoProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile simpleFile = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                TeoProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, TeoProperty.class);
                if (properties != null) {
                    for (TeoProperty property : properties) {
                        if (key.equals(property.getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<TeoProperty> findProperties(Project project) {
        List<TeoProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile simpleFile = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                TeoProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, TeoProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}
