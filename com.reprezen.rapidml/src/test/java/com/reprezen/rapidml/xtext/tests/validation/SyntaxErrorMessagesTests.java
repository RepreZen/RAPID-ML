/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation;

import static com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslParser.RULE_ID;

import org.antlr.runtime.ClassicToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.UnwantedTokenException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IParserErrorContext;
import org.junit.Assert;
import org.junit.Test;

import com.reprezen.rapidml.ObjectResource;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.xtext.parser.CustomSyntaxErrorMessageProvider;
import com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslParser;

/**
 * @author Konstantin Zaitsev
 * @date Oct 28, 2014
 */
public class SyntaxErrorMessagesTests {
	private static final ObjectResource OBJECT_RESOURCE = RapidmlFactory.eINSTANCE.createObjectResource();

	@Test
	public void testUnwantedToken() {
		Assert.assertEquals("Unexpected token 'default' found in objectResource, expecting name", //$NON-NLS-1$
				getErrorMessage(new UnwantedTokenException(RULE_ID, getStream(getTokenByName("'default'"))), //$NON-NLS-1$
						OBJECT_RESOURCE));

		Assert.assertEquals("Unexpected token 'default' found in objectResource, expecting 'only'", //$NON-NLS-1$
				getErrorMessage(new UnwantedTokenException(getTokenByName("'only'"), //$NON-NLS-1$
						getStream(getTokenByName("'default'"))), OBJECT_RESOURCE)); //$NON-NLS-1$

		Assert.assertEquals("Unexpected token 'RULE_ID' found in objectResource, expecting 'only'", //$NON-NLS-1$
				getErrorMessage(new UnwantedTokenException(getTokenByName("'only'"), getStream(RULE_ID)), //$NON-NLS-1$
						OBJECT_RESOURCE));
	}

	@Test
	public void testMissingToken() {
		Assert.assertEquals("Missing name in objectResource before 'default'", //$NON-NLS-1$
				getErrorMessage(new MissingTokenException(RULE_ID, getStream(getTokenByName("'default'")), //$NON-NLS-1$
						OBJECT_RESOURCE), OBJECT_RESOURCE));

		Assert.assertEquals("Missing token 'only' in objectResource before 'default'", //$NON-NLS-1$
				getErrorMessage(new MissingTokenException(getTokenByName("'only'"), //$NON-NLS-1$
						getStream(getTokenByName("'default'")), OBJECT_RESOURCE), OBJECT_RESOURCE)); //$NON-NLS-1$
	}

	private static String getErrorMessage(RecognitionException ex, EObject ctx) {
		return new CustomSyntaxErrorMessageProvider().getSyntaxErrorMessage(new ParserErrorContext(ex, ctx))
				.getMessage();
	}

	private static CommonTokenStream getStream(final int... tokenTypes) {
		return new CommonTokenStream(new TokenSource() {
			private int cnt = 0;

			@Override
			public Token nextToken() {
				if (cnt < tokenTypes.length) {
					Token token = new ClassicToken(tokenTypes[cnt], InternalXtextDslParser.tokenNames[tokenTypes[cnt]]);
					cnt++;
					return token;
				}
				return Token.EOF_TOKEN;
			}

			@Override
			public String getSourceName() {
				return "Test Source"; //$NON-NLS-1$
			}

		});
	}

	private int getTokenByName(String name) {
		String[] tokennames = InternalXtextDslParser.tokenNames;
		for (int i = 0; i < tokennames.length; i++) {
			if (tokennames[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}

	private static class ParserErrorContext implements IParserErrorContext {
		private RecognitionException ex;
		private EObject ctx;

		public ParserErrorContext(RecognitionException ex, EObject ctx) {
			this.ex = ex;
			this.ctx = ctx;
		}

		@Override
		public String getDefaultMessage() {
			return ""; //$NON-NLS-1$
		}

		@Override
		public EObject getCurrentContext() {
			return ctx;
		}

		@Override
		public INode getCurrentNode() {
			return null;
		}

		@Override
		public RecognitionException getRecognitionException() {
			return ex;
		}

		@Override
		public String[] getTokenNames() {
			return null;
		}
	}
}
