package io.teocloud.teointellijidea.ide.snippets;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiElement;
import io.teocloud.teointellijidea.lang.TeoLanguage;
import io.teocloud.teointellijidea.psi.impl.TeoBadTopIdentifierImpl;
import org.jetbrains.annotations.NotNull;

public class TeoTopLevelTemplateProvider extends TemplateContextType {

    protected TeoTopLevelTemplateProvider() {
        super("TEO_TOP", "Teo");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        if (!TeoLanguage.INSTANCE.is(templateActionContext.getFile().getLanguage())) {
            return false;
        }
        if (templateActionContext.getEditor() != null) {
            int offset = templateActionContext.getEditor().getCaretModel().getOffset();
            PsiElement element = templateActionContext.getFile().findElementAt(offset);
            PsiElement parent = element.getParent();
            return parent instanceof TeoBadTopIdentifierImpl;
        }
        return false;
    }
}
