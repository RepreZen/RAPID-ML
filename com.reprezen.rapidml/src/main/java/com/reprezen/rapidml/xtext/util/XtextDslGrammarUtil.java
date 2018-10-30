/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.util;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;

public class XtextDslGrammarUtil {
    private XtextDslGrammarUtil() {
        super();
    }

    /**
     * return true if the keyword is optional
     * 
     * @param keyword
     * @return
     */
    public static boolean isKeywordOptional(Keyword keyword) {
        return GrammarUtil.isOptionalCardinality(keyword) || ((keyword.eContainer() instanceof AbstractElement)
                && GrammarUtil.isOptionalCardinality((AbstractElement) keyword.eContainer()));
    }

    public static boolean isRule(Keyword keyword) {
        return keyword.getValue().matches("\\w{2,}");
    }
}
