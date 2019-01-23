/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.parser;

import org.antlr.runtime.Token;

import com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslLexer;
import com.reprezen.rapidml.xtext.parser.antlr.internal.InternalXtextDslParser;

/**
 * @author Konstantin Zaitsev
 * @date Dec 3, 2014
 */
public class IndentTokenSource extends AbstractIndentTokenSource {

	@Override
	protected String[] getTokenNames() {
		return InternalXtextDslParser.tokenNames;
	}

	@Override
	protected int getBeginTokenType() {
		return InternalXtextDslLexer.RULE_BEGIN;
	}

	@Override
	protected int getEndTokenType() {
		return InternalXtextDslLexer.RULE_END;
	}

	@Override
	protected int getWSTokenType() {
		return InternalXtextDslLexer.RULE_WS;
	}

	@Override
	protected boolean handleEOF() {
		return true;
	}

	@Override
	protected boolean isCommentToken(Token token) {
		return token.getType() == InternalXtextDslLexer.RULE_ML_COMMENT
				|| token.getType() == InternalXtextDslLexer.RULE_ML_COMMENT_NL
				|| token.getType() == InternalXtextDslLexer.RULE_SL_COMMENT;
	}

	@Override
	protected boolean isNLToken(Token token) {
		return token.getType() == InternalXtextDslLexer.RULE_NL || token == Token.EOF_TOKEN;
	}
}
