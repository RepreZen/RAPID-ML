/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.modelpath;

import static com.modelsolv.reprezen.restapi.xtext.ui.internal.RepreZenDslActivator.createErrorStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.DialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.LayoutUtil;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.StringDialogField;

public class ModelPathInputDialog extends StatusDialog {

    private class ModelPathInputAdapter implements IDialogFieldListener {
        @Override
        public void dialogFieldChanged(DialogField field) {
            doValidation();
        }
    }

    private StringDialogField nameField;

    private List<String> existingNames;

    public ModelPathInputDialog(Shell parent, String modelPath, List<String> existingEntries) {
        super(parent);
        setHelpAvailable(false);

        existingNames = new ArrayList<String>(existingEntries.size());
        for (int i = 0; i < existingEntries.size(); i++) {
            String curr = existingEntries.get(i);
            if (!curr.equals(modelPath)) {
                existingNames.add(curr);
            }
        }

        if (modelPath == null) {
            setTitle("New ModelPath");
        } else {
            setTitle("Rename Model Path");
        }

        ModelPathInputAdapter adapter = new ModelPathInputAdapter();

        nameField = new StringDialogField();

        if (modelPath == null) {
            nameField.setLabelText("Enter a name for the new model path:");
        } else {
            nameField.setLabelText("Enter a name for the model path:");
        }
        nameField.setDialogFieldListener(adapter);
        nameField.setText(Objects.toString(modelPath, "")); //$NON-NLS-1$

    }

    public String getResult() {
        return nameField.getText().trim();
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite inner = new Composite(composite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.numColumns = 1;
        inner.setLayout(layout);

        nameField.doFillIntoGrid(inner, 2);
        LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));
        LayoutUtil.setWidthHint(nameField.getTextControl(null), convertWidthInCharsToPixels(45));
        nameField.postSetFocusOnDialogField(parent.getDisplay());

        applyDialogFont(composite);

        return composite;
    }

    private void doValidation() {
        IStatus status = Status.OK_STATUS;
        String newText = nameField.getText();
        if (newText.length() == 0) {
            status = createErrorStatus("Enter a non-empty name");
        } else if (newText.indexOf(',') != -1) {
            // we store them in a comma-separated list
            status = createErrorStatus("The name cannot contain a comma");
        } else if (existingNames.contains(newText)) {
            status = createErrorStatus("A Model Path with this name already exists.\nChoose a different name");
        }
        updateStatus(status);
    }

}