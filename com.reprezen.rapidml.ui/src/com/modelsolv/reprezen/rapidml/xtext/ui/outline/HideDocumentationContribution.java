/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IFilter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

/**
 * @author Konstantin Zaitsev
 * @date Sep 18, 2014
 */
public class HideDocumentationContribution implements IOutlineContribution {
    private final IFilter filter = new DocumentationNodeFilter();

    @Override
    public void initialize(IPreferenceStoreAccess access) {
    }

    @Override
    public void register(OutlinePage outlinePage) {
        outlinePage.getFilterAndSorter().addFilter(filter);
    }

    @Override
    public void deregister(OutlinePage outlinePage) {
        outlinePage.getFilterAndSorter().removeFilter(filter);
    }
}
