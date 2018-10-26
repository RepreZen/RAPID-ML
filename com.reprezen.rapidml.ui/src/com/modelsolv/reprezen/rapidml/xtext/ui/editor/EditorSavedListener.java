/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.editor;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartConstants;

public abstract class EditorSavedListener implements IPropertyListener {
    private IEditorPart editor;

    public EditorSavedListener(IEditorPart editor) {
        this.editor = editor;
        editor.addPropertyListener(this);
    }

    protected abstract void editorSaved(IEditorPart editor);

    @Override
    public void propertyChanged(Object source, int propId) {
        if (editor == null) {
            return;
        }
        if (propId != IWorkbenchPartConstants.PROP_DIRTY) {
            return;
        }
        if (editor.isDirty()) {
            return;
        }
        editorSaved(editor);
    }

    public void dispose() {
        if (editor != null) {
            editor.removePropertyListener(this);
            editor = null;
        }
    }

}
