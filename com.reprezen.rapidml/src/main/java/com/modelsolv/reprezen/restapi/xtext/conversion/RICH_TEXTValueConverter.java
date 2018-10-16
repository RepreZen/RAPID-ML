/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.conversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class RICH_TEXTValueConverter extends AbstractLexerBasedConverter<String> {

    private Pattern javaDocRegex = Pattern.compile("'''(.*)'''", Pattern.DOTALL);

    @Override
    protected String toEscapedString(String value) {
        // consider using https://code.google.com/p/xeger/
        return "'''" + value + "'''";
    }

    @Override
    protected void assertValidValue(String value) {
        super.assertValidValue(value);
        if (javaDocRegex.matcher(value).matches()) {
            throw new ValueConverterException(getRuleName()
                    + "-value should start with a \"'''\" and end with a \"'''\" (value: " + value + ").", null, null);
        }
    }

    public String toValue(String string, INode node) {
        if (Strings.isEmpty(string))
            throw new ValueConverterException("Couldn't convert empty string to an example value.", node, null);
        Matcher matcher = javaDocRegex.matcher(string);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new ValueConverterException(getRuleName()
                + "-value should start with a \"'''\" and end with a \"'''\" (value: " + string + ").", null, null);
    }
}