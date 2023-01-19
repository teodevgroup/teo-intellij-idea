package io.teocloud.teointellijidea.snippets;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class TeoTemplateProvider extends TemplateContextType {

    protected TeoTemplateProvider() {
        super("TEO", "Teo");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        String name = templateActionContext.getFile().getName();
        return name.endsWith(".teo");
    }
}
