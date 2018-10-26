/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.implicit;

import java.util.regex.Pattern;

import com.google.common.base.Strings;
import com.reprezen.rapidml.Documentation;

public class DocumentationSpaceProcessor {
    public final Pattern pattern = Pattern.compile("\\s+$", Pattern.MULTILINE);

    public void process(final Documentation documentation) {
        String doc = documentation.getText();
        if (Strings.isNullOrEmpty(doc)) {
            return;
        }
        doc = process(doc);
        documentation.setText(doc);
    }

    public String process(String doc) {
        doc = doc.trim();
        doc = doc.replaceAll("\r\n", "\n");
        doc = removeTrailingSpaces(doc);
        return doc;
    }

    public String removeTrailingSpaces(String doc) {
        return pattern.matcher(doc).replaceAll("");
    }
}
