/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeContentProvider;

/**
 * This class override default OutlineNodeContentProvider to fix issue when outline display expandable node in case of
 * children nodes are filtered
 * 
 * @see <a href="https://modelsolv.atlassian.net/browse/ZEN-465?focusedCommentId=16020"> ZEN-465</a>
 * 
 * @author Konstantin Zaitsev
 * @date Sep 25, 2014
 */
public class RepreZenOutlineNodeContentProvider extends OutlineNodeContentProvider {

    @Override
    public boolean hasChildren(Object element) {
        return super.hasChildren(element) && getChildren(element).length > 0;
    }
}
