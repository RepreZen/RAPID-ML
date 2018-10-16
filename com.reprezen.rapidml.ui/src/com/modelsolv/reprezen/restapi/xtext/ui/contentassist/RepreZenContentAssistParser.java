/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.contentassist;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;

import com.modelsolv.reprezen.restapi.xtext.ide.contentassist.antlr.RapidMLParser;

/**
 * @author Konstantin Zaitsev
 * @date 29 Nov 2014
 */
public class RepreZenContentAssistParser extends RapidMLParser {

    @Override
    protected TokenSource createLexer(CharStream stream) {
        IndentTokenSource tokenSource = new IndentTokenSource();
        tokenSource.setDelegate(super.createLexer(stream));
        return tokenSource;
    }

    @Override
    protected String[] getInitialHiddenTokens() {
        return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_ML_COMMENT_NL", "RULE_SL_COMMENT" }; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
    }
}
