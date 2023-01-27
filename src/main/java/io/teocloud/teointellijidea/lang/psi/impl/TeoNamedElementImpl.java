package io.teocloud.teointellijidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.IncorrectOperationException;
import io.teocloud.teointellijidea.lang.presentation.TeoPresentationUtils;
import io.teocloud.teointellijidea.lang.psi.TeoElementFactory;
import io.teocloud.teointellijidea.lang.psi.TeoNameIdentifierOwner;
import io.teocloud.teointellijidea.lang.resolve.TeoReference;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TeoNamedElementImpl extends TeoElementImpl implements TeoNameIdentifierOwner {

    public TeoNamedElementImpl(ASTNode node) {
        super(node);
    }

    @Override
    public @Nullable String getName() {
        PsiElement child = getNameIdentifier();
        if (child != null) {
            return child.getText();
        } else {
            return null;
        }
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        PsiElement identifier = findChildByType(TeoTypes.IDENTIFIER);
        if (identifier != null) {
            identifier.replace(TeoElementFactory.createIdentifier(name, getProject()));
        }
//        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.KEY);
//        if (keyNode != null) {
//            SimpleProperty property = SimpleElementFactory.createProperty(element.getProject(), newName);
//            ASTNode newKeyNode = property.getFirstChild().getNode();
//            element.getNode().replaceChild(keyNode, newKeyNode);
//        }
//        return element;
        return null;
    }

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return findChildByType(TeoTypes.IDENTIFIER);
    }

    @Override
    public ItemPresentation getPresentation() {
        return TeoPresentationUtils.INSTANCE.getPresentation(this);
    }

    @Override
    public @Nullable Icon getIcon(int flags) {
        return TeoPresentationUtils.INSTANCE.getIcon(this);
    }

    @Override
    public @NotNull SearchScope getUseScope() {
        return new LocalSearchScope(getContainingFile());
    }
}
