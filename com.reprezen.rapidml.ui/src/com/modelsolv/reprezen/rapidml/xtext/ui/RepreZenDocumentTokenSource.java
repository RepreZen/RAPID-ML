/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui;

import java.util.List;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;

/**
 * @author Konstantin Zaitsev
 * @date May 8, 2015
 */
public class RepreZenDocumentTokenSource extends DocumentTokenSource {

    /**
     * Workaround for ZEN-312: Adding comment delimiters doesn't format text as comment, doesn't stop code assist Due
     * Xtext cannot correctly calculate damaged region we recalculate whole document in case of count of token changed
     * (it appears when comments broken or repared)
     * 
     * Please note this workaround apply additional performance penalty for editing huge files.
     */
    @Override
    protected IRegion computeDamageRegion(DocumentEvent e) {
        if (!getInternalModifyableTokenInfos().isEmpty()) {
            List<TokenInfo> tokens = createTokenInfos(e.fDocument.get());
            // check that amount of token different we will recalculate all document instead of damaged region only
            if (tokens.size() != getInternalModifyableTokenInfos().size()) {
                setTokens(tokens);
                return new Region(0, e.getDocument().getLength());
            }
        }
        return super.computeDamageRegion(e);
    }
}
