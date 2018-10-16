/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.parser;

import org.antlr.runtime.Token;

import com.modelsolv.reprezen.restapi.xtext.parser.antlr.internal.InternalRapidMLLexer;
import com.modelsolv.reprezen.restapi.xtext.parser.antlr.internal.InternalRapidMLParser;

/**
 * @author Konstantin Zaitsev
 * @date Dec 3, 2014
 */
public class IndentTokenSource extends AbstractIndentTokenSource {

    @Override
    protected String[] getTokenNames() {
        return InternalRapidMLParser.tokenNames;
    }

    @Override
    protected int getBeginTokenType() {
        return InternalRapidMLLexer.RULE_BEGIN;
    }

    @Override
    protected int getEndTokenType() {
        return InternalRapidMLLexer.RULE_END;
    }

    @Override
    protected int getWSTokenType() {
        return InternalRapidMLLexer.RULE_WS;
    }

    @Override
    protected boolean handleEOF() {
        return true;
    }

    @Override
    protected boolean isCommentToken(Token token) {
        return token.getType() == InternalRapidMLLexer.RULE_ML_COMMENT
                || token.getType() == InternalRapidMLLexer.RULE_ML_COMMENT_NL
                || token.getType() == InternalRapidMLLexer.RULE_SL_COMMENT;
    }

    @Override
    protected boolean isNLToken(Token token) {
        return token.getType() == InternalRapidMLLexer.RULE_NL || token == Token.EOF_TOKEN;
    }
}
