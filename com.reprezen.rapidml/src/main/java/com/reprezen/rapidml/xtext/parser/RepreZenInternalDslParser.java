/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.parser;

import static com.reprezen.rapidml.xtext.parser.RepreZenParserUtils.getNodeBySemanticClass;
import static com.reprezen.rapidml.xtext.parser.RepreZenParserUtils.matchGrammarRule;
import static com.reprezen.rapidml.xtext.parser.RepreZenParserUtils.matchKeyword;

import java.util.Collection;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslParser;
import com.reprezen.rapidml.xtext.services.XtextDslGrammarAccess;

/**
 * @author Konstantin Zaitsev, Tatiana Fesenko
 * @date Oct 29, 2014
 */
public class RepreZenInternalDslParser extends InternalXtextDslParser {
	private static final String MEDIA_TYPES_KEYWORD = RapidmlPackage.Literals.RESOURCE_DEFINITION__MEDIA_TYPES
			.getName();
	private final Collection<String> includedPropertiesKeywords;

	/**
	 * @param input
	 * @param grammarAccess
	 */
	public RepreZenInternalDslParser(TokenStream input, XtextDslGrammarAccess grammarAccess) {
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
						RapidmlPackage.Literals.TYPED_MESSAGE, RapidmlPackage.Literals.RESOURCE_DEFINITION);
				if (parent.isPresent()) {
					if (Iterables.any(parent.get().getChildren(), matchKeyword(MEDIA_TYPES_KEYWORD))) {
						reportError(new DuplicateTokenException(token, getTokenStream()));
					}
				}
			}
			if (includedPropertiesKeywords.contains(key)) {
				Optional<ICompositeNode> parent = getNodeBySemanticClass(getLastLeafNode(),
						RapidmlPackage.Literals.TYPED_MESSAGE, RapidmlPackage.Literals.RESOURCE_DEFINITION);
				if (parent.isPresent()) {
					if (Iterables.size(Iterables.filter(parent.get().getChildren(), matchGrammarRule(
							getGrammarAccess().getIncludedPropertiesAccess().getObjectRealizationAction_0()))) > 1) {
						reportError(new DuplicateTokenException(token, getTokenStream()));
					}
				}
			}
		}
		super.newLeafNode(token, grammarElement);
	}
}
