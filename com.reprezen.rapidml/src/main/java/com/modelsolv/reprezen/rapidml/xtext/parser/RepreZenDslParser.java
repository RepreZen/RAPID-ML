/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.parser;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.modelsolv.reprezen.rapidml.xtext.parser.antlr.RapidMLParser;
import com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLParser;

/**
 * @author Konstantin Zaitsev
 * @date Oct 29, 2014
 */
public class RepreZenDslParser extends RapidMLParser {

    @Override
    protected TokenSource createLexer(CharStream stream) {
        IndentTokenSource tokenSource = new IndentTokenSource();
        tokenSource.setDelegate(super.createLexer(stream));
        return tokenSource;
    }

    @Override
    protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
        super.createTokenStream(tokenSource);
        XtextTokenStream stream = new XtextTokenStream(tokenSource, getTokenDefProvider());
        stream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_ML_COMMENT_NL", "RULE_SL_COMMENT"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        return stream;
    }

    @Override
    protected InternalRapidMLParser createParser(XtextTokenStream stream) {
        return new RepreZenInternalDslParser(stream, getGrammarAccess());
    }
}
