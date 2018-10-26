/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IFilter;

import com.reprezen.rapidml.RapidmlPackage;

/**
 * Filter documentation nodes from outline.
 * 
 * @author Konstantin Zaitsev
 * @date Sep 18, 2014
 */
public class DocumentationNodeFilter implements IFilter {

    @Override
    public boolean apply(IOutlineNode input) {
        return !(input instanceof EObjectNode && ((EObjectNode) input).getEClass() == RapidmlPackage.Literals.DOCUMENTATION);
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
