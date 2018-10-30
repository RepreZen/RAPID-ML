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
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * This class duplicates functionality of
 * {@link org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution.DefaultComparator} and provides additional
 * default sorting by node position in text.
 * 
 * @author Konstantin Zaitsev
 * @date Sep 15, 2014
 */
public class OutlineComparator implements IComparator {

    @Inject
    private IPreferenceStoreAccess preferenceStoreAccess;

    @Override
    public int compare(IOutlineNode o1, IOutlineNode o2) {
        // in case of toogle "Sorting" toolbar button we execute alphabetic ordering
        if (preferenceStoreAccess.getPreferenceStore().getBoolean(SortOutlineContribution.PREFERENCE_KEY)) {
            int category1 = getCategory(o1);
            int category2 = getCategory(o2);
            if (category1 != category2) {
                return category1 - category2;
            }
            return o1.getText().toString().compareTo(o2.getText().toString());
        }
        // in default case if use position in text for ordering
        return o1.getFullTextRegion().getOffset() - o2.getFullTextRegion().getOffset();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getCategory(IOutlineNode node) {
        return 0;
    }
}
