package io.teocloud.teointellijidea.ide.symbols;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import io.teocloud.teointellijidea.lang.TeoUtil;
import org.jetbrains.annotations.NotNull;

public class GoToSymbolContributor implements ChooseByNameContributor {
    @Override
    public String @NotNull [] getNames(Project project, boolean includeNonProjectItems) {
        return TeoUtil.collectSymbolNames(project);
    }

    @Override
    public NavigationItem @NotNull [] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        return TeoUtil.collectNavigatableElementsByName(project, name);
    }
}
