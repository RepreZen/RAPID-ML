/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.contentassist;

import org.antlr.runtime.Token;

import com.modelsolv.reprezen.restapi.xtext.ide.contentassist.antlr.internal.InternalRapidMLLexer;
import com.modelsolv.reprezen.restapi.xtext.ide.contentassist.antlr.internal.InternalRapidMLParser;
import com.modelsolv.reprezen.restapi.xtext.parser.AbstractIndentTokenSource;

/**
 * @author Konstantin Zaitsev
 * @date Dec 4, 2014
 */
public class IndentTokenSource extends AbstractIndentTokenSource {

    @Override
    protected void trace(Token token) {
        System.out.println("ContentAssist: ");
        super.trace(token);
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
    protected String[] getTokenNames() {
        return InternalRapidMLParser.tokenNames;
    }

    @Override
    protected boolean handleEOF() {
        return false;
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
