/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.quickfix;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.reprezen.rapidml.xtext.formatting.ResourceContentSorter;
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator;

public class XtextDslQuickfixProvider extends DefaultQuickfixProvider {

    @Inject
    private ResourceContentSorter sorter;

    @Fix(XtextDslJavaValidator.INCORRECT_ELEMENT_ORDER)
    public void fixIncorrectOrder(final Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(issue, "Set correct order", String.format("Set correct order to '%s'", issue.getData()[0]), //$NON-NLS-1$ //$NON-NLS-2$
                null, new ISemanticModification() {

                    @Override
                    public void apply(EObject element, IModificationContext context) throws Exception {
                        ICompositeNode root = getResourceNode(element);
                        if (null != root) {
                            List<INode> nodes = Lists.newArrayList(sorter.getCanonicalOrder(root));
                            StringBuilder builder = new StringBuilder();
                            for (INode node : processNodes(nodes, root)) {
                                String nodeText = getNodeText(node);
                                builder.append(nodeText);
                            }
                            IXtextDocument document = context.getXtextDocument();
                            document.replace(root.getOffset(), getNodeLenght(root), builder.toString());
                        }
                    }

                    private int getNodeLenght(INode node) {
                        int nodeLength = node.getLength();

                        // If last leaf node is 'END' terminal (it is inserted manually by lexer and it isn't in text)
                        // that it needs to correct length
                        if (node instanceof ICompositeNode) {
                            INode latestChild = getLatestChildNode((ICompositeNode) node);
                            if (latestChild instanceof LeafNode) {
                                if (isENDRuleCall((LeafNode) latestChild)) {
                                    nodeLength = nodeLength - 1;
                                }
                            }
                        }

                        return nodeLength;
                    }

                    private String getNodeText(INode node) {
                        String nodeText = node.getText();

                        // If last leaf node is 'END' terminal (it is inserted manually by lexer and it isn't in text)
                        // that it needs to correct text
                        if (node instanceof ICompositeNode) {
                            INode latestChild = getLatestChildNode((ICompositeNode) node);
                            if (latestChild instanceof LeafNode) {
                                if (isENDRuleCall((LeafNode) latestChild)) {
                                    nodeText = nodeText.substring(0, nodeText.length() - 1);
                                }
                            }
                        } else if (node instanceof LeafNode) {
                            if (isENDRuleCall((LeafNode) node)) {
                                nodeText = nodeText.substring(0, nodeText.length() - 1);
                            }
                        }
                        return nodeText;
                    }

                    boolean isENDRuleCall(LeafNode leafNode) {
                        if (leafNode.getGrammarElement() instanceof RuleCall) {
                            RuleCall ruleCall = (RuleCall) leafNode.getGrammarElement();
                            if ("END".equals(ruleCall.getRule().getName())) { //$NON-NLS-1$
                                return true;
                            }
                        }
                        return false;
                    }

                    private INode getLatestChildNode(ICompositeNode node) {
                        if (node.getLastChild() instanceof ICompositeNode) {
                            return getLatestChildNode((ICompositeNode) node.getLastChild());
                        }
                        return node.getLastChild();
                    }
                });
    }

    protected ICompositeNode getResourceNode(EObject element) {
        ICompositeNode root = NodeModelUtils.findActualNodeFor(element);
        for (INode n : root.getAsTreeIterable()) {
            if (sorter.isApplicable(n) && n instanceof ICompositeNode) {
                return (ICompositeNode) n;
            }
        }
        return null;
    }

    /**
     * <p>
     * removes nodes out of scope (mostly comments)
     * </p>
     * <p>
     * adds eols, whitespaces
     * </p>
     * 
     * @param nodes
     * @param root
     * @return
     */
    protected List<INode> processNodes(List<INode> nodes, ICompositeNode root) {
        List<INode> children = Lists.newArrayList(root.getChildren());
        for (int i = 0; i < children.size(); i++) {
            INode n = children.get(i);
            if (n.getOffset() < root.getOffset() || n.getOffset() > root.getOffset() + root.getLength()) {
                nodes.remove(n);
            } else if (!nodes.contains(n)) {
                insert(nodes, n, children);
            }
        }
        return nodes;
    }

    protected boolean insert(List<INode> list, INode node, List<INode> children) {
        int start = children.indexOf(node);
        boolean inserted = false;
        // if possible insert before
        for (int i = start + 1; i < children.size() && !inserted; i++) {
            int pos = list.indexOf(children.get(i));
            if (pos >= 0) {
                if (pos < list.size()) {
                    list.add(pos, node);
                } else {
                    list.add(node);
                }
                inserted = true;
            }
        }
        // if possible insert after
        for (int i = start - 1; i >= 0 && !inserted; i--) {
            int pos = list.indexOf(children.get(i)) + 1;
            if (pos > 0) {
                if (pos < list.size()) {
                    list.add(pos, node);
                } else {
                    list.add(node);
                }
                inserted = true;
            }
        }
        return inserted;
    }
}
