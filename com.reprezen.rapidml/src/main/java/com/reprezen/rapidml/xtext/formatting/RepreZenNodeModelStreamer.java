/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.formatting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.xtext.formatting.impl.NodeModelStreamer;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;
import com.reprezen.rapidml.xtext.services.XtextDslGrammarAccess;

/**
 * Restores the canonical order of a resource on formatting. <br>
 * 
 * @see <a href="https://modelsolv.atlassian.net/browse/ZEN-752">ZEN-752 Formatter for properties specified in any
 *      order<a/>
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class RepreZenNodeModelStreamer extends NodeModelStreamer {

    @Inject
    private ResourceContentSorter resourceSorter;

    // @Inject
    // private IPreferenceStoreAccess preferenceStoreAccess;

    @Inject
    private XtextDslGrammarAccess grammarAccess;

    @Override
    protected List<INode> getLeafs(ICompositeNode root, int fromOffset, int toOffset) {
        // this is a modification of the super#getLeafs()
        List<INode> result = new ArrayList<INode>();
        TreeIterator<INode> iterator = root.getAsTreeIterable().iterator();

        // seek to fromOffset
        if (fromOffset > 0)
            while (iterator.hasNext()) {
                INode node = iterator.next();
                if (tokenUtil.isToken(node) || tokenUtil.isCommentNode(node)) {
                    iterator.prune();
                    if (node.getOffset() + node.getLength() >= fromOffset) {
                        result.add(node);
                        break;
                    }
                }
            }
        // add tokens within the range
        while (iterator.hasNext()) {
            INode node = iterator.next();
            if (node.getOffset() > toOffset)
                break;
            // BEGINNING OF THE MODIFICATION
            // TODO
            boolean modify = false; // preferenceStoreAccess.getWritablePreferenceStore()
            // .getBoolean(Messages.FormatterPreferencePage_incorrect_order_pref_key); // if the preference setting
            // is true
            if (modify && resourceSorter.isApplicable(node)) {
                Iterator<INode> canonicalOrderIter = resourceSorter.getCanonicalOrder((ICompositeNode) node).iterator();
                iterator.prune();
                while (canonicalOrderIter.hasNext()) {
                    INode child = canonicalOrderIter.next();
                    processChild(result, child);
                }
            } else // END OF MODIFICATION
            if (node instanceof ILeafNode || tokenUtil.isToken(node)) {
                if (node.getOffset() > toOffset)
                    break;
                else {
                    if (node instanceof ILeafNode)
                        result.add(node);
                    else {
                        iterator.prune();
                        Pair<List<ILeafNode>, List<ILeafNode>> surround = tokenUtil
                                .getLeadingAndTrailingHiddenTokens(node);
                        result.addAll(surround.getFirst());
                        result.add(node);
                        result.addAll(surround.getSecond());
                    }
                }
            }
        }

        // remove tailing hidden leafs
        for (int i = result.size() - 1; i >= 0; i--)
            if (tokenUtil.isWhitespaceNode(result.get(i)))
                result.remove(i);
            else
                break;
        return result;
    }

    protected boolean processChild(List<INode> result, INode child) {
        if (child instanceof ILeafNode || tokenUtil.isToken(child)) {
            if (child instanceof ILeafNode) {
                result.add(child);
                BidiTreeIterator<INode> iter = child.getAsTreeIterable().iterator();
                iter.next();
                while (iter.hasNext()) {
                    processChild(result, iter.next());
                }
                return false;
            } else {
                // canonicalOrderIter.prune();
                Pair<List<ILeafNode>, List<ILeafNode>> surround = tokenUtil.getLeadingAndTrailingHiddenTokens(child);
                result.addAll(surround.getFirst());
                result.add(child);
                result.addAll(surround.getSecond());
                return true;
            }
        }
        BidiIterator<INode> iter = ((ICompositeNode) child).getChildren().iterator();
        while (iter.hasNext()) {
            processChild(result, iter.next());
        }
        return false;
    }

    @Override
    protected void writeSemantic(ITokenStream out, ILeafNode node) throws IOException {
        if (tokenUtil.getTokenRule(node) == grammarAccess.getBEGINRule()
                || tokenUtil.getTokenRule(node) == grammarAccess.getENDRule()) {
            out.writeHidden(node.getGrammarElement(), ""); //$NON-NLS-1$
            return;
        }
        super.writeSemantic(out, node);
    }

    @Override
    protected void writeHidden(ITokenStream out, ILeafNode node) throws IOException {
        String value = node.getText();
        if (node.getGrammarElement() == grammarAccess.getML_COMMENTRule()
                || node.getGrammarElement() == grammarAccess.getML_COMMENT_NLRule()
                || node.getGrammarElement() == grammarAccess.getSL_COMMENTRule()) {
            // avoid insert indent on first line
            if (node.hasPreviousSibling()
                    && node.getPreviousSibling().getGrammarElement() != grammarAccess.getZenModelRule()) {
                INode prevNode = node.getPreviousSibling();
                // preserve original nl with indent
                if (prevNode.getGrammarElement() == grammarAccess.getWSRule()) {
                    value = prevNode.getText() + value;
                }
            }
        }
        out.writeHidden(node.getGrammarElement(), value);
    }
}
