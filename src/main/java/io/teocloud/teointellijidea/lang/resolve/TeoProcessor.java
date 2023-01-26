package io.teocloud.teointellijidea.lang.resolve;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.SmartList;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import org.jetbrains.annotations.NotNull;

interface TeoProcessorFilter {
    boolean invoke(PsiElement element);
}

public class TeoProcessor implements PsiScopeProcessor {

    private SmartList<TeoNamedElement> variants = new SmartList<>();

    protected boolean multiple;
    protected TeoProcessorFilter filter;

    public TeoProcessor(boolean multiple, TeoProcessorFilter filter) {
        this.multiple = multiple;
        this.filter = filter;
    }

    @Override
    public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
        if (!(element instanceof TeoNamedElement)) {
            return true;
        }
        if (accepts(element) && filter.invoke(element)) {
            variants.add((TeoNamedElement) element);
            return multiple;
        }
        return false;
    }


    public boolean accepts(PsiElement element) {
        return true;
    }

    SmartList<TeoNamedElement> getResults() {
        return variants;
    }
}
