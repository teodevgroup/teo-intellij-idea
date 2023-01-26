package io.teocloud.teointellijidea.lang.resolve;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.ResolveResult;
import io.teocloud.teointellijidea.lang.TeoUtil;
import io.teocloud.teointellijidea.psi.TeoModelDefinition;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeoReference extends PsiPolyVariantReferenceBase<PsiElement> {

    public TeoReference(@NotNull PsiElement element, TextRange range, boolean soft) {
        super(element, range, soft);
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        PsiElement element = getElement();
        Project project = element.getProject();
        String text = element.getText();
        List<TeoModelDefinition> defs = TeoUtil.findModelDefinitions(project).stream().filter((model) -> Objects.equals(model.getName(), text)).collect(Collectors.toList());
        List<ResolveResult> results = new ArrayList<>();
        for (TeoModelDefinition def : defs) {
            results.add(new PsiElementResolveResult(def));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = getElement().getProject();
        List<TeoModelDefinition> defs = TeoUtil.findModelDefinitions(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final TeoModelDefinition def : defs) {
            variants.add(LookupElementBuilder
                    .create(def).withIcon(AllIcons.Nodes.Class)
                    .withTypeText("Model")
            );
        }
        return variants.toArray();
    }
}
