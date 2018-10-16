/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.resource;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.modelsolv.reprezen.restapi.Documentation;
import com.modelsolv.reprezen.restapi.ZenModel;
import com.modelsolv.reprezen.restapi.xtext.services.RapidMLGrammarAccess;

/**
 * @author Konstantin Zaitsev
 * @date Dec 23, 2014
 */
public class RepreZenLocationInFileProvider extends DefaultLocationInFileProvider {

    @Inject
    private RapidMLGrammarAccess grammarAccess;

    private Collection<Keyword> beginRules = null;

    @Override
    protected boolean isHidden(INode node) {
        if (node.getGrammarElement() instanceof RuleCall) {
            AbstractRule rule = ((RuleCall) node.getGrammarElement()).getRule();
            if (rule == grammarAccess.getNLRule() || rule == grammarAccess.getBEGINRule()
                    || rule == grammarAccess.getENDRule() || rule == grammarAccess.getJAVADOC_COMMENTRule()) {
                return true;
            }
        }
        if (node.getSemanticElement() instanceof Documentation) {
            return true;
        }
        return super.isHidden(node);
    }

    @Override
    protected ITextRegion doGetTextRegion(EObject obj, RegionDescription query) {
        ICompositeNode node = findNodeFor(obj);
        boolean useBeginRule = false;

        // use "zenModel" keyword as start rule because it contains "import" and
        // "namespace" before required region
        if (obj instanceof ZenModel) {
            useBeginRule = true;
        }

        // in this case we need return region that will visible after fold and
        // also this region will selected from
        // outline. we try find all nodes before BEGIN rule
        if (query == RegionDescription.SIGNIFICANT) {
            return getTextRegionByRuleRange(node, useBeginRule, grammarAccess.getBEGINRule());
        }
        // return full region
        return getTextRegionByRuleRange(node, useBeginRule, null);
    }

    /**
     * @param node
     *            composite node
     * @param beginRule
     *            begin rule can be <code>null</code>
     * @param endRule
     *            end rule
     * @return text region within begin and and rule
     */
    private ITextRegion getTextRegionByRuleRange(ICompositeNode node, boolean useBeginRule, EObject endRule) {
        ITextRegion result = ITextRegion.EMPTY_REGION;
        boolean isInRange = !useBeginRule;
        for (INode child : node.getChildren()) {
            EObject rule = child.getGrammarElement() instanceof RuleCall ? ((RuleCall) child.getGrammarElement())
                    .getRule() : child.getGrammarElement();
            if (getBeginRules().contains(rule)) {
                isInRange = true;
            }
            if (rule == endRule) {
                return result;
            }
            if (!isHidden(child) && isInRange) {
                int length = getNodeLength(child);
                if (length != 0) {
                    result = result.merge(new TextRegionWithLineInformation(child.getOffset(), length, child
                            .getStartLine() - 1, child.getEndLine() - 1));
                }
            }
        }
        return result;
    }
    
    private Collection<Keyword> getBeginRules() {
        if (beginRules == null) {
            beginRules = Lists.newArrayList(grammarAccess.getZenModelAccess().getRapidModelKeyword_4_1());
        }
        return beginRules;
    }

    /**
     * Modified version of node.getLenght that exclude NL, END and BEGIN rules
     * from calculation.
     * 
     * @param node
     *            node
     * @return node length
     */
    private int getNodeLength(INode node) {
        BidiTreeIterator<INode> iter = node.getAsTreeIterable().iterator();
        while (iter.hasPrevious()) {
            INode prev = iter.previous();
            if (prev instanceof ILeafNode && !isHidden(prev)) {
                int offset = node.getOffset();
                return prev.getTotalEndOffset() - offset;
            }
        }
        return node.getTotalLength();
    }
}
