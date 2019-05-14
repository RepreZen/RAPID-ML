/** 
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.RapidmlFactory
import com.reprezen.rapidml.xtext.parser.CustomSyntaxErrorMessageProvider
import com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslParser
import org.antlr.runtime.ClassicToken
import org.antlr.runtime.CommonTokenStream
import org.antlr.runtime.MissingTokenException
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.Token
import org.antlr.runtime.TokenSource
import org.antlr.runtime.UnwantedTokenException
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IParserErrorContext
import org.junit.Assert
import org.junit.Test

import static com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslParser.RULE_ID

/** 
 * @author Konstantin Zaitsev
 * @date Oct 28, 2014
 */
class SyntaxErrorMessagesTests {

	val OBJECT_RESOURCE = RapidmlFactory.eINSTANCE.createObjectResource()

	@Test
	def void testUnwantedToken() {
		Assert.assertEquals("Unexpected token 'default' found in objectResource, expecting name", // $NON-NLS-1$
		getErrorMessage(new UnwantedTokenException(RULE_ID, getStream(getTokenByName("'default'"))), // $NON-NLS-1$
		OBJECT_RESOURCE))
		Assert.assertEquals("Unexpected token 'default' found in objectResource, expecting 'only'", // $NON-NLS-1$
		getErrorMessage(new UnwantedTokenException(getTokenByName("'only'"), // $NON-NLS-1$
		getStream(getTokenByName("'default'"))), OBJECT_RESOURCE))
		// $NON-NLS-1$
		Assert.assertEquals("Unexpected token 'RULE_ID' found in objectResource, expecting 'only'", // $NON-NLS-1$
		getErrorMessage(new UnwantedTokenException(getTokenByName("'only'"), getStream(RULE_ID)), // $NON-NLS-1$
		OBJECT_RESOURCE))
	}

	@Test
	def void testMissingToken() {
		Assert.assertEquals("Missing name in objectResource before 'default'", // $NON-NLS-1$
		getErrorMessage(new MissingTokenException(RULE_ID, getStream(getTokenByName("'default'")), // $NON-NLS-1$
		OBJECT_RESOURCE), OBJECT_RESOURCE))
		Assert.assertEquals("Missing token 'only' in objectResource before 'default'", // $NON-NLS-1$
		getErrorMessage(new MissingTokenException(getTokenByName("'only'"), // $NON-NLS-1$
		getStream(getTokenByName("'default'")), OBJECT_RESOURCE), OBJECT_RESOURCE)) // $NON-NLS-1$
	}

	def private static String getErrorMessage(RecognitionException ex, EObject ctx) {
		return new CustomSyntaxErrorMessageProvider().getSyntaxErrorMessage(new ParserErrorContext(ex, ctx)).
			getMessage()
	}

	def private static CommonTokenStream getStream(int... tokenTypes) {
		return new CommonTokenStream(new TokenSource() {
			int cnt = 0

			override Token nextToken() {
				if (cnt < tokenTypes.length) {
					var Token token = new ClassicToken({
						val _rdIndx_tokenTypes = cnt
						tokenTypes.get(_rdIndx_tokenTypes)
					}, {
						val _rdIndx_tmpNode = {
							val _rdIndx_tokenTypes = cnt
							tokenTypes.get(_rdIndx_tokenTypes)
						}
						InternalXtextDslParser.tokenNames.get(_rdIndx_tmpNode)
					})
					cnt++
					return token
				}
				return Token.EOF_TOKEN
			}

			override String getSourceName() {
				return "Test Source" // $NON-NLS-1$
			}
		})
	}

	def private int getTokenByName(String name) {
		var String[] tokennames = InternalXtextDslParser.tokenNames
		for (var int i = 0; i < tokennames.length; i++) {
			if ({
				val _rdIndx_tokennames = i
				tokennames.get(_rdIndx_tokennames)
			}.equals(name)) {
				return i
			}
		}
		return -1
	}

	private static class ParserErrorContext implements IParserErrorContext {
		RecognitionException ex
		EObject ctx

		new(RecognitionException ex, EObject ctx) {
			this.ex = ex
			this.ctx = ctx
		}

		override String getDefaultMessage() {
			return "" // $NON-NLS-1$
		}

		override EObject getCurrentContext() {
			return ctx
		}

		override INode getCurrentNode() {
			return null
		}

		override RecognitionException getRecognitionException() {
			return ex
		}

		override String[] getTokenNames() {
			return null
		}
	}
}
