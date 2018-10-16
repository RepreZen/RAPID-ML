package com.modelsolv.reprezen.restapi.xtext.ui.contentassist;

/*******************************************************************************
 * Copyright (c) 2009, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.modelsolv.reprezen.restapi.xtext.services.RapidMLGrammarAccess;

/**
 * Modified version of {@link ParserBasedContentAssistContextFactory}. Performed modification are the following:
 * <ul>
 * <li>modified
 * {@link com.modelsolv.reprezen.restapi.xtext.ui.contentassist.ParserBasedContentAssistContextFactoryEx.StatefulFactory #doCreateContexts(int)}
 * <li>added
 * {@link com.modelsolv.reprezen.restapi.xtext.ui.contentassist.ParserBasedContentAssistContextFactoryEx.StatefulFactory #indentLevel}
 * <li>added
 * {@link com.modelsolv.reprezen.restapi.xtext.ui.contentassist.ParserBasedContentAssistContextFactoryEx.StatefulFactory #nextZenModelKeyword()}
 * <li>modified
 * {@link com.modelsolv.reprezen.restapi.xtext.ui.contentassist.ParserBasedContentAssistContextFactoryEx.StatefulFactory #initializeNodeAndModelData()}
 * <p>
 * the rest content leave without any changes.
 * </ul>
 * 
 * @author Konstantin Zaitsev
 * @date Dec 5, 2014
 */
public class RepreZenContentAssistContextFactory extends AbstractContentAssistContextFactory {

    @Inject
    private Provider<StatefulFactory> statefulFactoryProvider;

    public Provider<StatefulFactory> getStatefulFactoryProvider() {
        return statefulFactoryProvider;
    }

    public void setStatefulFactoryProvider(Provider<StatefulFactory> statefulFactoryProvider) {
        this.statefulFactoryProvider = statefulFactoryProvider;
    }

    public static class StatefulFactory extends ParserBasedContentAssistContextFactory.StatefulFactory {
        @Inject
        private RapidMLGrammarAccess grammarAccess;

        /** Current indentation level in case of cursor on start line */
        private int indentLevel = -1;

        @Override
        protected ContentAssistContext[] doCreateContexts(int offset) throws BadLocationException {
            // initialize data,
            // datatypeNode - is a syntax node corresponding to the rule which contains the currentNode.
            // datatypeNode is used to define Antlr alternatives
            initializeFromViewerAndResource(offset);
            if (indentLevel >= 0) {
                String completeInput = viewer.getDocument().get(0, offset);
                String prefix = getPrefix(lastCompleteNode);
                Collection<FollowElement> followElements = parser.getFollowElements(completeInput, false);
                if (!followElements.isEmpty()) {
                    INode lastCompleteNodeBeforeDatatype = getLastCompleteNodeByOffset(rootNode, datatypeNode.getTotalOffset());
                    // equivalent of super.handleLastCompleteNodeAsPartOfDatatypeNode() 
                    doCreateContexts(lastCompleteNodeBeforeDatatype, datatypeNode, prefix, currentModel, followElements);
                } else {
                    ContentAssistContext.Builder contextBuilder = doCreateContext(lastCompleteNode, currentModel,
                            currentModel, currentNode, ""); //$NON-NLS-1$
                    ICompositeNode parentNode = NodeModelUtils.getNode(currentModel);
                    boolean bodyBlock = false;
                    FollowElementCalculator calc = new FollowElementCalculator();
                    calc.setAcceptor(contextBuilder);

                    for (AbstractElement element : GrammarUtil
                            .containedAbstractElements(parentNode.getGrammarElement().eContainer())) {
                        if (element instanceof RuleCall
                                && ((RuleCall) element).getRule() == grammarAccess.getENDRule()) {
                            bodyBlock = false;
                        }

                        if (bodyBlock) {
                            calc.doSwitch(element);
                        }
                        if (element instanceof RuleCall
                                && ((RuleCall) element).getRule() == grammarAccess.getBEGINRule()) {
                            bodyBlock = true;
                        }
                    }
                    contextBuilders.add(contextBuilder);
                }
            } else if (lastCompleteNode.getGrammarElement() != grammarAccess.getSL_COMMENTRule()
                    || nextZenModelKeyword()) {
                return super.doCreateContexts(offset);
            }
            return Lists.transform(contextBuilders, this).toArray(new ContentAssistContext[contextBuilders.size()]);
        }
        
        @Override
        protected void initializeNodeAndModelData() {
            super.initializeNodeAndModelData();
            int offset = lastCompleteNode.getTotalEndOffset() - completionOffset;
            String indentString = lastCompleteNode.getText().substring(0, lastCompleteNode.getText().length() - offset);
            if (indentString.contains("\n")) { //$NON-NLS-1$
                // correct model according to indent for body block
                indentLevel = indentString.indexOf('\t') >= 0 ? (indentString.length() - indentString.indexOf('\t'))
                        : -1;
                if (indentLevel > 0) {
                    while (currentModel.eContainer() != null && getIndentLevel(currentModel) >= indentLevel) {
                        currentModel = currentModel.eContainer();
                    }

                    // ignore in case of line comment
                    if (!isCommentNode(currentNode)) {

                        currentNode = NodeModelUtils.findActualNodeFor(currentModel);
                        for (ILeafNode node : currentNode.getLeafNodes()) {
                            if (node.getGrammarElement() instanceof RuleCall && ((RuleCall) node.getGrammarElement())
                                    .getRule() == grammarAccess.getBEGINRule()) {
                                lastCompleteNode = node;
                                currentNode = node.getNextSibling();
                                // in case of node after completionOffset get the latest node before offset
                                while (completionOffset < lastCompleteNode.getTotalEndOffset()) {
                                    lastCompleteNode = lastCompleteNode.getPreviousSibling();
                                }
                                break;
                            }
                        }
                    }
                }
            } 
        }

        private boolean nextZenModelKeyword() {
            return lastCompleteNode != null && lastCompleteNode.hasNextSibling() && (lastCompleteNode.getNextSibling()
                    .getGrammarElement() == grammarAccess.getZenModelAccess().getRapidModelKeyword_4_1());
        }

        private boolean isCommentNode(INode node) {
            return node.getGrammarElement() == grammarAccess.getSL_COMMENTRule()
                    || (node.getGrammarElement() == grammarAccess.getWSRule()
                            && node.getNextSibling().getGrammarElement() == grammarAccess.getSL_COMMENTRule());
        }

        private int getIndentLevel(EObject obj) {
            int level = 0;
            while (obj.eContainer() != null) {
                obj = obj.eContainer();
                level++;
            }
            return level;
        }
        
        @Override
        protected void setPool(ExecutorService pool) {
            // to make it visible for the #create() method
            super.setPool(pool);
        }

    }

    @Override
    public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
        try { 
            StatefulFactory factory = statefulFactoryProvider.get();
            ExecutorService pool = Executors.newFixedThreadPool(3);
            factory.setPool(pool);
            return factory.create(viewer, offset, resource);
        }
        catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    public static class FollowElementCalculator extends ParserBasedContentAssistContextFactory.FollowElementCalculator {
        protected void setAcceptor(IFollowElementAcceptor acceptor) {
            this.acceptor = acceptor;
        }
    }

}
