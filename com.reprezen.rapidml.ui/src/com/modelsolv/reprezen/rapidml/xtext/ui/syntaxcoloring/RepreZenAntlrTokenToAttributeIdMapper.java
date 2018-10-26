/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.syntaxcoloring;

import static com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLParser.RULE_JAVADOC_COMMENT;
import static com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLParser.RULE_RAW_STRING;
import static com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLParser.tokenNames;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

/**
 * This class provide mapping between Antlr grammars tokens and coloring tokens that specified in
 * {@link RepreZenHighlightingConfiguration}.
 * 
 * @author Konstantin Zaitsev
 * @date Oct 21, 2014
 */
public class RepreZenAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

    @Override
    protected String calculateId(String tokenName, int tokenType) {
        if (tokenNames[RULE_JAVADOC_COMMENT].equals(tokenName)) {
            return RepreZenHighlightingConfiguration.JAVADOC_ID;
        }
        if (tokenNames[RULE_RAW_STRING].equals(tokenName)) {
            return RepreZenHighlightingConfiguration.RAW_STRING_ID;
        }
        return super.calculateId(tokenName, tokenType);
    }
}
