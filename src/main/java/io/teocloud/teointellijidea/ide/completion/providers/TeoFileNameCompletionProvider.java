package io.teocloud.teointellijidea.ide.completion.providers;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ProcessingContext;
import io.teocloud.teointellijidea.ide.completion.handler.TeoInsertHandler;
import io.teocloud.teointellijidea.lang.TeoFileType;
import io.teocloud.teointellijidea.lang.TeoIcons;
import org.jetbrains.annotations.NotNull;
import java.nio.file.Paths;
import java.util.Collection;


public class TeoFileNameCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        PsiFile originalFile = parameters.getOriginalFile();
        VirtualFile thisVirtualFile = originalFile.getVirtualFile();
        String thisVirtualFilePath = thisVirtualFile.getPath();
        String thisVirtualFileDir = Paths.get(thisVirtualFilePath).getParent().toString();
        Project project = originalFile.getProject();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(TeoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile file : virtualFiles) {
            String thatPath = file.getPath();
            if (!thatPath.equals(thisVirtualFilePath)) {
                String name = Paths.get(thisVirtualFileDir).relativize(Paths.get(thatPath)).toString();
                if (name.endsWith("index.teo")) {
                    name = name.substring(0, 9);
                }
                if (name.endsWith(".teo")) {
                    name = name.substring(0, name.length() - 4);
                }
                if (name.startsWith(".")) {
                    result.addElement(createFilePath(name));
                } else {
                    result.addElement(createFilePath("./" + name));
                }
            }
        }
    }

    private static LookupElementBuilder createFilePath(String name) {
        return LookupElementBuilder
                .create(name)
                .withPresentableText(name)
                .withIcon(TeoIcons.FILE)
                .withTypeText("Teo schema file")
                .withInsertHandler(TeoInsertHandler.CLEAR_STRING);
    }
}
