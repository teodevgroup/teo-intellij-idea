package io.teocloud.teointellijidea.lang.presentation;

import com.intellij.icons.AllIcons;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.NlsSafe;
import io.teocloud.teointellijidea.lang.psi.TeoElement;
import io.teocloud.teointellijidea.lang.psi.TeoNamedElement;
import io.teocloud.teointellijidea.lang.psi.impl.TeoNamedElementImpl;
import io.teocloud.teointellijidea.psi.TeoConfigDefinition;
import io.teocloud.teointellijidea.psi.TeoEnumDefinition;
import io.teocloud.teointellijidea.psi.TeoModelDefinition;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class TeoPresentationUtils {

    public static final TeoPresentationUtils INSTANCE = new TeoPresentationUtils();

    public ItemPresentation getPresentation(TeoElement element) {
        return new ItemPresentation() {
            @Override
            public @Nullable String getPresentableText() {
                System.out.format("see element: %s\n", element);
                if (TeoNamedElement.class.isAssignableFrom(element.getClass())) {
                    System.out.format("see name: %s\n", ((TeoNamedElement) element).getName());
                    return ((TeoNamedElement) element).getName();
                }
                return "HERE";
                // return null;
            }

            @Override
            public String getLocationString() {
                return "here location";
                // return element.getContainingFile().getName();
            }

            @Override
            public @Nullable Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

    public @Nullable Icon getIcon(TeoNamedElement element) {
        if (element instanceof TeoModelDefinition) {
            return AllIcons.Nodes.ModelClass;
        } else if (element instanceof TeoEnumDefinition) {
            return AllIcons.Nodes.Enum;
        } else if (element instanceof TeoConfigDefinition) {
            return AllIcons.Nodes.ConfigFolder;
        }
        return null;
    }
}
