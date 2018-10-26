/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.formatting;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.GrammarUtil.containingParserRule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;

/**
 * Sorts the contents of a resource definition to achieve the canonical order. <br>
 * 
 * @see <a href="https://modelsolv.atlassian.net/browse/ZEN-752">ZEN-752
 *      Formatter for properties specified in any order<a/>
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class ResourceContentSorter {

    @Inject
    private TokenUtil tokenUtil;

    private final Map<ParserRule, List<EObject>> parserRule2sortingRule = new HashMap<>();
    private final Map<ParserRule, Set<AbstractElement>> parserRule2listSeparators = new HashMap<>();

    public boolean isApplicable(INode input) {
        return input instanceof CompositeNodeWithSemanticElement
                && ((ICompositeNode) input).getSemanticElement() instanceof ResourceDefinition;
    }

    /**
     * @param resourceNode
     * @return child nodes of the resource placed using the canonical order
     */
    public List<INode> getCanonicalOrder(final ICompositeNode resourceNode) {
        ParserRule parserRule = GrammarUtil.containingParserRule(resourceNode.getGrammarElement());

        final List<EObject> sortingRule = getSortingRule(parserRule);
        final Set<AbstractElement> attachToPrevious = getListSeparators(parserRule);

        List<INode> subnodes = newArrayList(filter(resourceNode.getChildren(), new Predicate<INode>() {

            @Override
            public boolean apply(INode node) {
                return !tokenUtil.isWhitespaceNode(node);
            }
        }));
        Collections.sort(subnodes, new Comparator<INode>() {

            private final Map<INode, EObject> node2grammarRule = new HashMap<>();

            @Override
            public int compare(final INode node1, final INode node2) {
                int result = 0;
                EObject grammarElement1 = getRelevantGrammarRule(node1);
                EObject grammarElement2 = getRelevantGrammarRule(node2);
                if (attachToPrevious.contains(node1.getGrammarElement())) {
                    if (node2 == getPreviousNonWSSibling(node1)) {
                        return 1;
                    }
                }
                if (attachToPrevious.contains(node2.getGrammarElement())) {
                    if (node1 == getPreviousNonWSSibling(node2)) {
                        return -1;
                    }
                }
                if (sortingRule.contains(grammarElement1) && sortingRule.contains(grammarElement2)) {
                    result = sortingRule.indexOf(grammarElement1) - sortingRule.indexOf(grammarElement2);
                    if (result == 0) {
                        result = node1.getTotalOffset() - node2.getTotalOffset();
                    }
                }
                return result;

            }

            protected INode getPreviousNonWSSibling(final INode node) {
                INode prev = node.getPreviousSibling();
                if (prev == null) {
                    return null;
                }
                if (!tokenUtil.isWhitespaceNode(prev)) {
                    return prev;
                }
                return getPreviousNonWSSibling(prev);
            }

            private EObject getRelevantGrammarRule(final INode node) {
                if (!node2grammarRule.containsKey(node)) {
                    EObject grammarElement = node.getGrammarElement();
                    if (attachToPrevious.contains(grammarElement)) {
                        INode prev = getPreviousNonWSSibling(node);
                        grammarElement = prev.getGrammarElement();
                    }
                    // RuleCalls invoking a rule which creates an element will
                    // become an Action
                    if (grammarElement instanceof Action) {
                        grammarElement = containingParserRule(grammarElement);
                    }
                    node2grammarRule.put(node, grammarElement);
                }
                return node2grammarRule.get(node);

            }

        });
        return Collections.unmodifiableList(subnodes);
    }

    /**
     * @param grammarElement
     *            the parser rule
     * @return the sets of list element separators for a given grammar element, usually they are commas.
     */
    protected Set<AbstractElement> getListSeparators(ParserRule grammarElement) {
        if (!parserRule2listSeparators.containsKey(grammarElement)) {
            parserRule2listSeparators.put(grammarElement, calculateListSeparators(grammarElement));
        }
        return parserRule2listSeparators.get(grammarElement);
    }

    protected Set<AbstractElement> calculateListSeparators(ParserRule grammarElement) {
        final Predicate<Group> isRepeatableGroup = new Predicate<Group>() {
            @Override
            public boolean apply(Group input) {
                return "+".equals(input.getCardinality()) || "*".equals(input.getCardinality()); //$NON-NLS-1$ //$NON-NLS-2$
            }
        };
        
        Collection<Group> groups = EcoreUtil2.getAllContentsOfType(grammarElement, Group.class);
        groups = filter(groups, isRepeatableGroup);
        
        final Function<Group, AbstractElement> getLastElement = new Function<Group, AbstractElement>() {

            @Override
            public AbstractElement apply(Group input) {
                return Iterables.getLast(input.getElements(), null);
            }
        };
        final Function<Group, AbstractElement> getFirstElement = new Function<Group, AbstractElement>() {

            @Override
            public AbstractElement apply(Group input) {
                return Iterables.getFirst(input.getElements(), null);
            }
        };
        final Predicate<AbstractElement> isCommaKeyword = new Predicate<AbstractElement>() {
            @Override
            public boolean apply(AbstractElement input) {
                return input instanceof Keyword && ",".equals(((Keyword) input).getValue()); //$NON-NLS-1$
            }
        };
        final Predicate<AbstractElement> isNLTermianl = new Predicate<AbstractElement>() {

            @Override
            public boolean apply(AbstractElement input) {
                return input instanceof RuleCall && "NL".equals(((RuleCall) input).getRule().getName()); //$NON-NLS-1$
            }
        };
        Collection<AbstractElement> lastElementsOfGroups = transform(groups, getLastElement);
        Collection<AbstractElement> firstElementsOfGroups = transform(groups, getFirstElement);
        Collection<AbstractElement> groupSurrounds = new ArrayList<>(lastElementsOfGroups);
        groupSurrounds.addAll(firstElementsOfGroups);

        Set<AbstractElement> els = new HashSet<AbstractElement>();
        for (AbstractElement el : groupSurrounds) {
            if (el instanceof Alternatives) {
                els.addAll(((Alternatives)el).getElements());
            } else {
                els.add(el);
            }
        }
        
        Collection<AbstractElement> listSeparators = filter(els, Predicates.or(isCommaKeyword, isNLTermianl));

        return Collections.unmodifiableSet(new HashSet<>(listSeparators));
    }

    /**
     * 
     * Define sorting rule for nodes
     * 
     * @param node
     *            the node
     * @return grammarElements sorted in canonical order
     */
    protected List<EObject> getSortingRule(final ParserRule grammarElement) {
        if (!parserRule2sortingRule.containsKey(grammarElement)) {
            List<EObject> sortingRule = calculateSortingRule(grammarElement);
            parserRule2sortingRule.put(grammarElement, sortingRule);
        }
        return parserRule2sortingRule.get(grammarElement);
    }

    protected List<EObject> calculateSortingRule(ParserRule grammarElement) {
        final List<EObject> sortingRule = Lists.newArrayList(grammarElement.eAllContents());
        // for each RuleCall add a corresponding ParserRule
        for (EObject next : Lists.newArrayList(sortingRule)) {
            if (next instanceof RuleCall) {
                AbstractRule rule = ((RuleCall) next).getRule();
                sortingRule.add(sortingRule.indexOf(next) + 1, rule);
            }
        }
        return Collections.unmodifiableList(sortingRule);
    }

}
