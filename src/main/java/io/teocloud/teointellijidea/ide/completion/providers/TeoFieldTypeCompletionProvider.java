package io.teocloud.teointellijidea.ide.completion.providers;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.util.ProcessingContext;
import io.teocloud.teointellijidea.lang.TeoUtil;
import io.teocloud.teointellijidea.psi.TeoEnumDefinition;
import io.teocloud.teointellijidea.psi.TeoModelDefinition;
import io.teocloud.teointellijidea.psi.TeoTypes;
import org.jetbrains.annotations.NotNull;
import com.intellij.icons.AllIcons;

import java.util.ArrayList;
import java.util.List;


public class TeoFieldTypeCompletionProvider extends CompletionProvider<CompletionParameters> {
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        result.addAllElements(List.of(builtinTypes));
        Project project = parameters.getOriginalFile().getProject();
        result.addAllElements(getModelTypeCandidates(project));
        result.addAllElements(getEnumTypeCandidates(project));
    }

    static LookupElementBuilder[] builtinTypes = new LookupElementBuilder[]{
            createBuiltinType("String"),
            createBuiltinType("Bool"),
            createBuiltinType("Int"),
            createBuiltinType("Int32"),
            createBuiltinType("Int64"),
            createBuiltinType("Float"),
            createBuiltinType("Float32"),
            createBuiltinType("Float64"),
            createBuiltinType("Date"),
            createBuiltinType("DateTime"),
            createBuiltinType("ObjectId"), // todo: remove for non mongodb
    };

    private static LookupElementBuilder createBuiltinType(String name) {
        return LookupElementBuilder
                .create(name)
                .withPresentableText(name)
                .withTypeText("builtin", true)
                .withIcon(AllIcons.Nodes.Type)
                .bold();
    }

    private static ArrayList<LookupElementBuilder> getModelTypeCandidates(Project project) {
        final List<TeoModelDefinition> modelDefinitions = TeoUtil.findModelDefinitions(project);
        ArrayList<LookupElementBuilder> elements = new ArrayList<>();
//        for (TeoModelDefinition modelDefinition : modelDefinitions) {
//            elements.add(LookupElementBuilder
//                    .create(modelDefinition.getNode().findChildByType(TeoTypes.MODEL_NAME).getText())
//                    .withTypeText(modelDefinition.getContainingFile().getName())
//                    .withIcon(AllIcons.Nodes.ModelClass)
//                    .bold());
//        }
        return elements;
    }

    private static ArrayList<LookupElementBuilder> getEnumTypeCandidates(Project project) {
        final List<TeoEnumDefinition> enumDefinitions = TeoUtil.findEnumDefinitions(project);
        ArrayList<LookupElementBuilder> elements = new ArrayList<>();
//        for (TeoEnumDefinition enumDefinition : enumDefinitions) {
//            elements.add(LookupElementBuilder
//                    .create(enumDefinition.getNode().findChildByType(TeoTypes.ENUM_NAME).getText())
//                    .withTypeText(enumDefinition.getContainingFile().getName())
//                    .withIcon(AllIcons.Nodes.Enum)
//                    .bold());
//        }
        return elements;
    }
}
