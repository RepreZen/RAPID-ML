/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.LastSegmentFinder;

import com.google.common.base.Strings;

/**
 * Get last segment of delimiter-separated qualified name.
 * 
 * Default LastSegmentFinder realization
 * {@link org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.DefaultLastSegmentFinder} also crops name on upper
 * case letter (not only delimiter).
 * */
public class RepreZenLastSegmentFinder implements LastSegmentFinder {
    @Override
    public String getLastSegment(String fqn, char delimiter) {
        if (Strings.isNullOrEmpty(fqn)) {
            return null;
        }
        return fqn.substring(fqn.lastIndexOf(delimiter) + 1);
    }
}
