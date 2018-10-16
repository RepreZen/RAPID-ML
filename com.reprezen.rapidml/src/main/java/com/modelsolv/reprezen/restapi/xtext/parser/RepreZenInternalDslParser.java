/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.parser;

import static com.modelsolv.reprezen.restapi.xtext.parser.RepreZenParserUtils.getNodeBySemanticClass;
import static com.modelsolv.reprezen.restapi.xtext.parser.RepreZenParserUtils.matchGrammarRule;
import static com.modelsolv.reprezen.restapi.xtext.parser.RepreZenParserUtils.matchKeyword;

import java.util.Collection;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.xtext.parser.antlr.internal.InternalRapidMLParser;
import com.modelsolv.reprezen.restapi.xtext.services.RapidMLGrammarAccess;

/**
 * @author Konstantin Zaitsev, Tatiana Fesenko
 * @date Oct 29, 2014
 */
public class RepreZenInternalDslParser extends InternalRapidMLParser {
    private static final String MEDIA_TYPES_KEYWORD = RestapiPackage.Literals.RESOURCE_DEFINITION__MEDIA_TYPES
            .getName();
    private final Collection<String> includedPropertiesKeywords;

    /**
     * @param input
     * @param grammarAccess
     */
    public RepreZenInternalDslParser(TokenStream input, RapidMLGrammarAccess grammarAccess) {
        super(input, grammarAccess);
        includedPropertiesKeywords = Sets.newHashSet( //
                grammarAccess.getIncludedPropertiesAccess().getPropertiesKeyword_2_1_2().getValue());
    }

    @Override
    protected void newLeafNode(Token token, EObject grammarElement) {
        if (grammarElement != null && grammarElement instanceof Keyword) {
            String key = ((Keyword) grammarElement).getValue();
            if (key.equals(MEDIA_TYPES_KEYWORD)) {
                Optional<ICompositeNode> parent = getNodeBySemanticClass(getLastLeafNode(),
                        RestapiPackage.Literals.TYPED_MESSAGE, RestapiPackage.Literals.RESOURCE_DEFINITION);
                if (parent.isPresent()) {
                    if (Iterables.any(parent.get().getChildren(), matchKeyword(MEDIA_TYPES_KEYWORD))) {
                        reportError(new DuplicateTokenException(token, getTokenStream()));
                    }
                }
            }
            if (includedPropertiesKeywords.contains(key)) {
                Optional<ICompositeNode> parent = getNodeBySemanticClass(getLastLeafNode(),
                        RestapiPackage.Literals.TYPED_MESSAGE, RestapiPackage.Literals.RESOURCE_DEFINITION);
                if (parent.isPresent()) {
                    if (Iterables.size(Iterables.filter(parent.get().getChildren(), matchGrammarRule(getGrammarAccess()
                            .getIncludedPropertiesAccess().getObjectRealizationAction_0()))) > 1) {
                        reportError(new DuplicateTokenException(token, getTokenStream()));
                    }
                }
            }
        }
        super.newLeafNode(token, grammarElement);
    }
}
