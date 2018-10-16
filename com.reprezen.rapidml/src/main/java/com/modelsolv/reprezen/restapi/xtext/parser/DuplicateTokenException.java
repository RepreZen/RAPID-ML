/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.parser;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

/**
 * ANTLR Recognition exception for case when token should be only one in parent node.
 * 
 * @author Konstantin Zaitsev
 * @date Oct 29, 2014
 */
class DuplicateTokenException extends RecognitionException {

    private static final long serialVersionUID = 5068911265710240288L;
    private Token duplicateToken;

    public DuplicateTokenException() {
    }

    public DuplicateTokenException(Token duplicateToken, IntStream input) {
        super(input);
        this.duplicateToken = duplicateToken;
    }

    @Override
    public String getMessage() {
        return "Duplicate '" + duplicateToken.getText() + "' token"; //$NON-NLS-1$//$NON-NLS-2$
    }
}