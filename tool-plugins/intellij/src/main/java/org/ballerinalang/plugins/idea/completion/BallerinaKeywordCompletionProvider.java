package org.ballerinalang.plugins.idea.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.ballerinalang.plugins.idea.psi.BallerinaAssignmentStatement;
import org.ballerinalang.plugins.idea.psi.BallerinaBlock;
import org.ballerinalang.plugins.idea.psi.BallerinaCompositeElement;
import org.ballerinalang.plugins.idea.psi.BallerinaDefinition;
import org.ballerinalang.plugins.idea.psi.BallerinaEndpointDefinition;
import org.ballerinalang.plugins.idea.psi.BallerinaExpression;
import org.ballerinalang.plugins.idea.psi.BallerinaExpressionStmt;
import org.ballerinalang.plugins.idea.psi.BallerinaFiniteType;
import org.ballerinalang.plugins.idea.psi.BallerinaForeachStatement;
import org.ballerinalang.plugins.idea.psi.BallerinaGlobalVariableDefinition;
import org.ballerinalang.plugins.idea.psi.BallerinaParameter;
import org.ballerinalang.plugins.idea.psi.BallerinaParameterList;
import org.ballerinalang.plugins.idea.psi.BallerinaResourceParameterList;
import org.ballerinalang.plugins.idea.psi.BallerinaReturnType;
import org.ballerinalang.plugins.idea.psi.BallerinaSimpleVariableReference;
import org.ballerinalang.plugins.idea.psi.BallerinaStatement;
import org.ballerinalang.plugins.idea.psi.BallerinaTransactionStatement;
import org.ballerinalang.plugins.idea.psi.BallerinaTypeDefinition;
import org.ballerinalang.plugins.idea.psi.BallerinaTypeName;
import org.ballerinalang.plugins.idea.psi.BallerinaTypes;
import org.ballerinalang.plugins.idea.psi.BallerinaUserDefineTypeName;
import org.ballerinalang.plugins.idea.psi.BallerinaVariableDefinitionStatement;
import org.ballerinalang.plugins.idea.psi.BallerinaVariableReferenceList;
import org.ballerinalang.plugins.idea.psi.BallerinaWhileStatement;
import org.ballerinalang.plugins.idea.psi.BallerinaWorkerBody;
import org.ballerinalang.plugins.idea.psi.BallerinaWorkerDefinition;
import org.ballerinalang.plugins.idea.psi.BallerinaXmlAttrib;
import org.ballerinalang.plugins.idea.psi.impl.BallerinaPsiImplUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Keyword completion provider.
 */
public class BallerinaKeywordCompletionProvider extends CompletionProvider<CompletionParameters> {

    BallerinaKeywordCompletionProvider() {

    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context,
                                  @NotNull CompletionResultSet result) {
        PsiElement position = parameters.getPosition();
        PsiElement parent = position.getParent();

        BallerinaReturnType returnType = PsiTreeUtil.getParentOfType(parent, BallerinaReturnType.class);
        if (returnType != null) {
            BallerinaCompletionUtils.addValueTypesAsLookups(result, false);
            BallerinaCompletionUtils.addReferenceTypesAsLookups(result, false);
        }

        BallerinaVariableReferenceList referenceList = PsiTreeUtil.getParentOfType(position,
                BallerinaVariableReferenceList.class);
        BallerinaForeachStatement foreachStatement = PsiTreeUtil.getParentOfType(referenceList,
                BallerinaForeachStatement.class, true);
        if (foreachStatement != null) {
            result.stopHere();
            return;
        }

        // Todo - Add bind
        //        if (parent instanceof BallerinaServiceEndpointAttachments) {
        //            if (parent.getFirstChild().equals(position)) {
        //                BallerinaCompletionUtils.addBindAsLookup(result);
        //                return;
        //            }
        //        }

        BallerinaExpression expression = PsiTreeUtil.getParentOfType(position, BallerinaExpression.class);
        if (expression != null) {
            BallerinaSimpleVariableReference simpleVariableReference = PsiTreeUtil.getParentOfType(position,
                    BallerinaSimpleVariableReference.class);
            if (simpleVariableReference != null) {
                PsiElement tempParent = parent;
                while (tempParent != null) {
                    PsiElement superParent = tempParent.getParent();
                    if (!superParent.getFirstChild().equals(tempParent)) {
                        break;
                    }
                    tempParent = superParent;
                }

                // Todo - 'but' keyword in matching
                if (tempParent != null && tempParent.equals(expression)) {
                    PsiElement superParent = tempParent.getParent();
                    if (BallerinaPsiImplUtil.isObjectInitializer(superParent)) {
                        PsiElement type =
                                BallerinaPsiImplUtil.getType((BallerinaVariableDefinitionStatement) superParent);
                        if (type != null) {
                            BallerinaCompletionUtils.addNewAsLookup(result, (BallerinaTypeDefinition) type.getParent());
                            if (tempParent.getChildren().length == 1) {
                                BallerinaCompletionUtils.addExpressionKeywordsAsLookups(result);
                            }
                            return;
                        }
                    }
                    // If we are in a xml attribute, we don't need to suggest keywords.
                    BallerinaXmlAttrib xmlAttrib = PsiTreeUtil.getParentOfType(position, BallerinaXmlAttrib.class);
                    if (xmlAttrib == null) {
                        BallerinaCompletionUtils.addExpressionKeywordsAsLookups(result);
                    }
                    return;
                }
            }
        }

        BallerinaStatement statement = PsiTreeUtil.getParentOfType(position, BallerinaStatement.class);
        if (statement != null) {
            BallerinaSimpleVariableReference simpleVariableReference = PsiTreeUtil.getParentOfType(position,
                    BallerinaSimpleVariableReference.class);
            if (simpleVariableReference != null) {
                PsiElement tempParent = parent;
                while (tempParent != null && !tempParent.equals(statement)) {
                    PsiElement superParent = tempParent.getParent();
                    if (!superParent.getFirstChild().equals(tempParent)) {
                        break;
                    }
                    tempParent = superParent;
                }
                if (tempParent != null && tempParent.equals(statement)) {
                    PsiElement prevVisibleLeaf = PsiTreeUtil.prevVisibleLeaf(position);
                    if (!(prevVisibleLeaf instanceof LeafPsiElement
                            && (((LeafPsiElement) prevVisibleLeaf).getElementType() == BallerinaTypes.RARROW
                            || ((LeafPsiElement) prevVisibleLeaf).getElementType() ==
                            BallerinaTypes.DECIMAL_INTEGER_LITERAL
                            || ((LeafPsiElement) prevVisibleLeaf).getElementType() == BallerinaTypes.COLON))) {

                        BallerinaTransactionStatement transactionStatement = PsiTreeUtil.getParentOfType(position,
                                BallerinaTransactionStatement.class);
                        if (transactionStatement != null) {
                            BallerinaCompletionUtils.addTransactionKeywordsAsLookups(result);
                        }

                        BallerinaCompositeElement loopTypes = PsiTreeUtil.getParentOfType(position,
                                BallerinaWhileStatement.class, BallerinaForeachStatement.class);
                        if (loopTypes != null) {
                            BallerinaCompletionUtils.addLoopKeywordsAsLookups(result);
                        }

                        // Inside an empty function body.
                        BallerinaBlock ballerinaBlock = PsiTreeUtil.getParentOfType(position, BallerinaBlock.class);
                        BallerinaWorkerDefinition workerDefinition = PsiTreeUtil.getParentOfType(position,
                                BallerinaWorkerDefinition.class);
                        if (ballerinaBlock != null && workerDefinition == null) {
                            List<BallerinaEndpointDefinition> endpointDefinitions =
                                    PsiTreeUtil.getChildrenOfTypeAsList(ballerinaBlock,
                                            BallerinaEndpointDefinition.class);
                            List<BallerinaWorkerDefinition> workerDefinitions =
                                    PsiTreeUtil.getChildrenOfTypeAsList(ballerinaBlock,
                                            BallerinaWorkerDefinition.class);
                            if (endpointDefinitions.isEmpty() && workerDefinitions.isEmpty()) {
                                BallerinaCompletionUtils.addEndpointAsLookup(result);
                                BallerinaCompletionUtils.addWorkerKeywordsAsLookups(result);
                            }
                        }

                        // After an endpoint declaration.
                        BallerinaEndpointDefinition endpointDefinition = PsiTreeUtil.getPrevSiblingOfType(statement,
                                BallerinaEndpointDefinition.class);
                        if (endpointDefinition != null) {
                            BallerinaCompletionUtils.addEndpointAsLookup(result);
                            BallerinaCompletionUtils.addWorkerKeywordsAsLookups(result);
                        }

                        // Handle "but" keyword completion.
                        BallerinaStatement prevStatement = PsiTreeUtil.getPrevSiblingOfType(statement,
                                BallerinaStatement.class);
                        if (prevStatement != null) {
                            BallerinaExpressionStmt expressionStmt = prevStatement.getExpressionStmt();
                            if (expressionStmt != null) {
                                PsiElement semicolon = expressionStmt.getSemicolon();
                                if (semicolon == null) {
                                    BallerinaCompletionUtils.addButKeywordsAsLookups(result);
                                }
                            }
                            BallerinaAssignmentStatement assignmentStatement = prevStatement.getAssignmentStatement();
                            if (assignmentStatement != null) {
                                PsiElement semicolon = assignmentStatement.getSemicolon();
                                if (semicolon == null) {
                                    BallerinaCompletionUtils.addButKeywordsAsLookups(result);
                                }
                            }
                            BallerinaVariableDefinitionStatement variableDefinitionStatement =
                                    prevStatement.getVariableDefinitionStatement();
                            if (variableDefinitionStatement != null) {
                                PsiElement semicolon = variableDefinitionStatement.getSemicolon();
                                if (semicolon == null) {
                                    BallerinaCompletionUtils.addButKeywordsAsLookups(result);
                                }
                            }
                        }

                        // Add other keywords.
                        BallerinaCompletionUtils.addValueTypesAsLookups(result, true);
                        BallerinaCompletionUtils.addReferenceTypesAsLookups(result, true);
                        BallerinaCompletionUtils.addVarAsLookup(result);
                        BallerinaCompletionUtils.addReturnAsLookup(result);
                        BallerinaCompletionUtils.addLockAsLookup(result);
                        BallerinaCompletionUtils.addCommonKeywords(result);
                        return;
                    }
                }
            }
            // Handle "but" keyword completion.
            BallerinaStatement prevStatement = PsiTreeUtil.getPrevSiblingOfType(statement, BallerinaStatement.class);
            if (prevStatement != null) {
                BallerinaVariableDefinitionStatement variableDefinitionStatement =
                        prevStatement.getVariableDefinitionStatement();
                if (variableDefinitionStatement != null) {
                    PsiElement semicolon = variableDefinitionStatement.getSemicolon();
                    if (semicolon == null) {
                        BallerinaCompletionUtils.addButKeywordsAsLookups(result);
                    }
                }
            }
        }

        BallerinaGlobalVariableDefinition globalVariableDefinition = PsiTreeUtil.getParentOfType(position,
                BallerinaGlobalVariableDefinition.class);
        if (globalVariableDefinition != null) {

            // Todo - Consider situations where import statement is added after.
            BallerinaUserDefineTypeName userDefineTypeName = PsiTreeUtil.getParentOfType(position,
                    BallerinaUserDefineTypeName.class);
            if (userDefineTypeName != null) {
                PsiElement tempParent = parent;
                while (tempParent != null) {
                    PsiElement superParent = tempParent.getParent();
                    if (!superParent.getFirstChild().equals(tempParent)) {
                        break;
                    }
                    tempParent = superParent;
                    if (superParent.equals(globalVariableDefinition)) {
                        break;
                    }
                }

                if (tempParent != null && tempParent.equals(globalVariableDefinition)) {
                    PsiElement prevVisibleLeaf = PsiTreeUtil.prevVisibleLeaf(position);
                    if (!(prevVisibleLeaf instanceof LeafPsiElement
                            && (((LeafPsiElement) prevVisibleLeaf).getElementType() ==
                            BallerinaTypes.DECIMAL_INTEGER_LITERAL))) {
                        BallerinaCompletionUtils.addValueTypesAsLookups(result, true);
                        BallerinaCompletionUtils.addReferenceTypesAsLookups(result, true);
                        BallerinaCompletionUtils.addTopLevelDefinitionsAsLookups(result);
                    }
                }
            }

            BallerinaDefinition prevDefinition = PsiTreeUtil.getPrevSiblingOfType(globalVariableDefinition.getParent(),
                    BallerinaDefinition.class);

            if (prevDefinition == null) {
                BallerinaCompletionUtils.addPublicAsLookup(result);
                BallerinaCompletionUtils.addImportAsLookup(result);
                return;
            }
        }

        BallerinaFiniteType ballerinaFiniteType = PsiTreeUtil.getParentOfType(position, BallerinaFiniteType.class);
        if (ballerinaFiniteType != null) {
            BallerinaUserDefineTypeName userDefineTypeName = PsiTreeUtil.getParentOfType(position,
                    BallerinaUserDefineTypeName.class);
            if (userDefineTypeName != null) {
                PsiElement tempParent = parent;
                while (tempParent != null) {
                    PsiElement superParent = tempParent.getParent();
                    if (!superParent.getFirstChild().equals(tempParent)) {
                        break;
                    }
                    tempParent = superParent;
                    if (superParent.equals(ballerinaFiniteType)) {
                        break;
                    }
                }

                if (tempParent != null && tempParent.equals(ballerinaFiniteType)) {
                    BallerinaCompletionUtils.addEObjectAsLookup(result);
                    result.stopHere();
                    return;
                }
            }
        }

        BallerinaResourceParameterList resourceParameterList = PsiTreeUtil.getParentOfType(parent,
                BallerinaResourceParameterList.class);
        if (resourceParameterList != null) {
            BallerinaParameterList ballerinaParameterList = resourceParameterList.getParameterList();
            if (ballerinaParameterList != null) {
                List<BallerinaParameter> parameterList = ballerinaParameterList.getParameterList();
                if (parameterList.size() == 1) {
                    BallerinaCompletionUtils.addEndpointWithoutTemplateAsLookup(result);
                    return;
                }
            }
        }

        // Add keywords in parameters.
        BallerinaParameter ballerinaParameter = PsiTreeUtil.getParentOfType(parent, BallerinaParameter.class);
        if (ballerinaParameter != null) {
            BallerinaTypeName ballerinaTypeName = PsiTreeUtil.getParentOfType(parent, BallerinaTypeName.class);
            if (ballerinaTypeName != null) {
                BallerinaCompletionUtils.addValueTypesAsLookups(result, true);
                BallerinaCompletionUtils.addReferenceTypesAsLookups(result, true);
                return;
            }
        }

        BallerinaBlock ballerinaBlock = PsiTreeUtil.getParentOfType(position, BallerinaBlock.class);
        if (ballerinaBlock != null) {
            BallerinaWorkerBody workerBody = PsiTreeUtil.getPrevSiblingOfType(position.getParent(),
                    BallerinaWorkerBody.class);
            if (workerBody != null) {
                BallerinaCompletionUtils.addWorkerKeywordsAsLookups(result);
            }
        }
    }
}
