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

public class RawStringValueConverter extends AbstractLexerBasedConverter<String> {

    private Pattern rawStringRegex = Pattern.compile("r((['\"])(.*)\\2)", Pattern.DOTALL);

    @Override
    protected String toEscapedString(String value) {
        return "r\"" + value + "\"";
    }

    @Override
    protected void assertValidValue(String value) {
        super.assertValidValue(value);
        if (rawStringRegex.matcher(value).matches()) {
            throw new ValueConverterException(getRuleName()
                    + "-value should start with an `r\"` (or `r'`) and end with a `\"` (or `'`) (value: " + value
                    + ").", null, null);
        }
    }

    public String toValue(String string, INode node) {
        if (Strings.isEmpty(string))
            throw new ValueConverterException("Couldn't convert empty string to an example value.", node, null);
        Matcher matcher = rawStringRegex.matcher(string);
        if (matcher.find()) {
            // 3 is used to get the value without " in "value" or ' in 'value'
            String result = matcher.group(3);
            return result;
        }
        throw new ValueConverterException(getRuleName()
                + "-value should start with an `r\"` (or `r'`) and end with a `\"` (or `'`) (value: " + string + ").",
                null, null);
    }
}