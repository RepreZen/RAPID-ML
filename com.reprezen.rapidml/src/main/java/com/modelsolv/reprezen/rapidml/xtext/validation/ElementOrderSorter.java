/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.modelsolv.reprezen.rapidml.xtext.services.RapidMLGrammarAccess;
import com.modelsolv.reprezen.rapidml.xtext.util.XtextDslGrammarUtil;

/**
 * this class constructs the grammar priority tree of grammar elements that potentially could have random order of
 * subelements
 * 
 * @author annano
 */
public class ElementOrderSorter {

    @Inject
    public RapidMLGrammarAccess grammarAccess;

    private Map<EClassifier, Map<Keyword, Integer>> grammarTree = Maps.newHashMap();

    /**
     * inits the grammar order tree
     */
    @Inject
    private void init() {
        if (grammarTree.isEmpty()) {
            grammarTree.clear();
            List<ParserRule> parserRules = GrammarUtil.allParserRules(grammarAccess.getGrammar());
            for (ParserRule rule : parserRules) {
                List<Action> action = GrammarUtil.containedActions(rule);
                List<Alternatives> alternatives = EcoreUtil2.getAllContentsOfType(rule.getAlternatives(),
                        Alternatives.class);
                if (action.size() == 1 && alternatives.size() > 0) {
                    grammarTree.put(action.get(0).getType().getClassifier(), getPriorityTree(alternatives.get(0)));
                }
            }
        }
    }

    /**
     * returns the list of elements which are not in correct order
     * 
     * @param object
     * @return
     */
    public List<INode> getIncorrectOrderChildren(EObject object) {
        List<INode> result = Lists.newArrayList();
        if (hasPriorityTree(object.eClass())) {
            final Map<Keyword, Integer> priorities = getPriorityTree(object.eClass());
            Comparator<INode> comparator = new Comparator<INode>() {
                @Override
                public int compare(final INode node1, final INode node2) {
                    Integer pr1 = priorities.get(node1.getGrammarElement());
                    Integer pr2 = priorities.get(node2.getGrammarElement());
                    return pr1.compareTo(pr2);

                }

            };
            ICompositeNode root = NodeModelUtils.getNode(object);
            if (null != root) {
                List<INode> sortable = new ArrayList<>();
                for (INode node : root.getChildren()) {
                    Optional<INode> child = getPrioritiesNode(priorities, node);
                    if (child.isPresent()) {
                        sortable.add(child.get());
                    }
                }
                List<INode> sorted = Lists.newArrayList(sortable);
                Collections.sort(sorted, comparator);
                for (int i = 0; i < sortable.size() && i < sorted.size(); i++) {
                    if (sorted.get(i) != sortable.get(i)) {
                        result.add(sortable.get(i));
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param priorities
     *            priorities map
     * @param node
     *            root node to traverse
     * @return child node that exists in priorities map
     */
    private Optional<INode> getPrioritiesNode(Map<Keyword, Integer> priorities, INode node) {
        if (priorities.containsKey(node.getGrammarElement())) {
            return Optional.of(node);
        }
        if (node instanceof ICompositeNode) {
            for (INode child : ((ICompositeNode) node).getChildren()) {
                Optional<INode> result = getPrioritiesNode(priorities, child);
                if (result.isPresent()) {
                    return result;
                }
            }
        }
        return Optional.absent();
    }

    /**
     * returns the list of sorted subelements which could be in random order
     * 
     * @param parent
     * @return
     */
    public List<Keyword> getChildren(EClass parent) {
        final Map<Keyword, Integer> children = getPriorityTree(parent);
        if (null != children) {
            List<Keyword> result = Lists.newArrayList(children.keySet());
            Comparator<Keyword> comparator = new Comparator<Keyword>() {

                @Override
                public int compare(Keyword o1, Keyword o2) {
                    Integer pr1 = children.get(o1);
                    Integer pr2 = children.get(o2);
                    return pr1.compareTo(pr2);
                }
            };
            Collections.sort(result, comparator);
            return result;
        }
        return Lists.newArrayList();
    }

    /**
     * return the map of children and their priorities for the class
     * 
     * @param eClass
     * @return
     */
    public Map<Keyword, Integer> getPriorityTree(EClass eClass) {
        return grammarTree.get(eClass);
    }

    /**
     * returns true if the class has children which can be in random order
     * 
     * @param eClass
     * @return
     */
    public boolean hasPriorityTree(EClass eClass) {
        return grammarTree.containsKey(eClass);
    }

    /**
     * return the map of elements with corresponding priority inside parent element
     * 
     * @param alternatives
     * @return
     */
    private Map<Keyword, Integer> getPriorityTree(Alternatives alternatives) {
        Map<Keyword, Integer> priorityTree = Maps.newHashMap();
        int priority = 0;
        for (EObject obj : getRules(alternatives)) {
            acceptGrammar(priority++, priorityTree, false, Lists.<EObject> newArrayList(),
                    Lists.<EObject> newArrayList(obj));
        }
        return priorityTree;
    }

    private boolean acceptGrammar(int priority, Map<Keyword, Integer> priorityTree, boolean found,
            List<EObject> visited, List<EObject> toVisit) {
        if (toVisit.isEmpty()) {
            return false;
        }
        EObject rule = toVisit.remove(0);
        if (!visited.contains(rule)) {
            visited.add(rule);
            List<Keyword> keywords = GrammarUtil.containedKeywords(rule);
            for (Keyword keyword : keywords) {
                if (!found && !XtextDslGrammarUtil.isKeywordOptional(keyword) && XtextDslGrammarUtil.isRule(keyword)) {
                    priorityTree.put(keyword, priority);
                    found = true;
                }
            }
            if (!found) {
                if (rule instanceof Alternatives) {
                    for (EObject o : getRules(rule)) {
                        List<EObject> v = Lists.newArrayList(o);
                        v.addAll(toVisit);
                        acceptGrammar(priority, priorityTree, found, Lists.newArrayList(visited), v);
                    }
                } else {
                    toVisit.addAll(0, getRules(rule));
                    acceptGrammar(priority, priorityTree, found, visited, toVisit);
                }
            }
        }

        return found;
    }

    /**
     * returns list of subrules
     * 
     * @param rule
     * @return
     */
    private List<EObject> getRules(EObject rule) {
        if (rule instanceof RuleCall) {
            return getRules(((RuleCall) rule).getRule());
        }
        if (rule instanceof Assignment) {
            return getRules(((Assignment) rule).getTerminal());
        }
        return rule.eContents();
    }
}
