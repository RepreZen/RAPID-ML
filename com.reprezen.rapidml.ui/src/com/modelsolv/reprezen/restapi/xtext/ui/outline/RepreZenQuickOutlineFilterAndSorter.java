/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;

/**
 * Custom quick outline filter with predefined documentation nodes filter.
 * 
 * @author Konstantin Zaitsev
 * @date Sep 18, 2014
 */
public class RepreZenQuickOutlineFilterAndSorter extends QuickOutlineFilterAndSorter {

    /**
     * Construct class with predefiend
     */
    public RepreZenQuickOutlineFilterAndSorter() {
        addFilter(new DocumentationNodeFilter());
    }
}
