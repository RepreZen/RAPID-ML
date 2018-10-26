/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.parser;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

/**
 * @author Konstantin Zaitsev
 * @date Oct 29, 2014
 */
public class RepreZenParserUtils {

    /**
     * @param node
     *            syntax node
     * @param eclass
     *            expected class of semantic element
     * @return composite node that related to model object of the expected classes.
     */
    public static Optional<ICompositeNode> getNodeBySemanticClass(INode node, EClass... eclasses) {
        INode n = node;
        while (n != null) {
            if (n instanceof CompositeNodeWithSemanticElement && n.getSemanticElement() != null) {
                for (int i = 0; i < eclasses.length; i++) {
                    if (eclasses[i].isSuperTypeOf(n.getSemanticElement().eClass())) {
                        return Optional.fromNullable((ICompositeNode) n);
                    }
                }
            }
            n = n.getParent();
        }

        return Optional.fromNullable((ICompositeNode) n);
    }

    /**
     * Predicate to filter only keyword node by specified value.
     * 
     * @param keyword
     *            keyword value
     * @return predicate
     */
    public static Predicate<INode> matchKeyword(final String keyword) {
        return new Predicate<INode>() {

            @Override
            public boolean apply(INode node) {
                if (node.getGrammarElement() != null && node.getGrammarElement() instanceof Keyword) {
                    return keyword.equals(((Keyword) node.getGrammarElement()).getValue());
                }
                return false;
            }

        };
    }

    public static Predicate<INode> matchGrammarRule(final EObject rule) {
        return new Predicate<INode>() {

            @Override
            public boolean apply(INode node) {
                return node.getGrammarElement() == rule;
            }

        };
    }
}
