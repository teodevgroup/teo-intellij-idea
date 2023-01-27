package io.teocloud.teointellijidea.lang;

import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import io.teocloud.teointellijidea.lang.psi.TeoDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoMemberDeclaration;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import io.teocloud.teointellijidea.psi.TeoConfigDefinition;
import io.teocloud.teointellijidea.psi.TeoEnumDefinition;
import io.teocloud.teointellijidea.lang.psi.TeoFile;
import io.teocloud.teointellijidea.psi.TeoLetDeclaration;
import io.teocloud.teointellijidea.psi.TeoModelDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    public static @Nullable TeoDeclaration findModelOrEnumDefinitionByName(Project project, String name) {
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile file = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            List<TeoDeclaration> decls = PsiTreeUtil.getChildrenOfAnyType(file, TeoModelDefinition.class, TeoEnumDefinition.class);
            for (TeoDeclaration decl : decls) {
                if (Objects.equals(decl.getName(), name)) {
                    return decl;
                }
            }
        }
        return null;
    }

    public static @NotNull String[] collectSymbolNames(Project project) {
        Set<String> names = new HashSet<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile file = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            List<TeoDeclaration> decls = PsiTreeUtil.getChildrenOfAnyType(file, TeoModelDefinition.class, TeoEnumDefinition.class, TeoLetDeclaration.class, TeoConfigDefinition.class);
            for (TeoDeclaration decl : decls) {
                names.add(decl.getName());
                if (decl.getBlock() != null) {
                    List<TeoMemberDeclaration> members = decl.getMembers();
                    for (TeoMemberDeclaration member : members) {
                        names.add(member.getName());
                    }
                }
            }
        }
        return names.toArray(String[]::new);
    }

    public static NavigationItem @NotNull [] collectNavigatableElementsByName(Project project, String name) {
        ArrayList<TeoNamedElement> elements = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            TeoFile file = (TeoFile) PsiManager.getInstance(project).findFile(virtualFile);
            List<TeoDeclaration> decls = PsiTreeUtil.getChildrenOfAnyType(file, TeoModelDefinition.class, TeoEnumDefinition.class, TeoLetDeclaration.class, TeoConfigDefinition.class);
            for (TeoDeclaration decl : decls) {
                if (name.equals(decl.getName())) {
                    elements.add(decl);
                }
                if (decl.getBlock() != null) {
                    List<TeoMemberDeclaration> members = decl.getMembers();
                    for (TeoMemberDeclaration member : members) {
                        if (name.equals(member.getName())) {
                            elements.add(member);
                        }
                    }
                }
            }
        }
        return elements.toArray(TeoNamedElement[]::new);
    }
}
