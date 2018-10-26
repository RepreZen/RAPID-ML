/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.modelpath;

import static com.reprezen.rapidml.xtext.ui.internal.RepreZenDslActivator.createErrorStatus;

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

import com.reprezen.rapidml.xtext.modelpath.ModelPathItem;

public class PathItemInputDialog extends StatusDialog {

    public static final String ENABLED = "true";
    public static final String DISABLED = "false";

    private class PathItemInputAdapter implements IDialogFieldListener {
        @Override
        public void dialogFieldChanged(DialogField field) {
            doValidation();
        }
    }

    private StringDialogField nameField;
    private StringDialogField modelPatternField;
    private StringDialogField pathPatternField;
    private StringDialogField urlTemplateField;
    private List<String> existingNames;

    public PathItemInputDialog(Shell parent, ModelPathItem modelPathItem, List<ModelPathItem> existingEntries) {
        super(parent);

        existingNames = new ArrayList<String>(existingEntries.size());
        for (int i = 0; i < existingEntries.size(); i++) {
            ModelPathItem curr = existingEntries.get(i);
            if (!curr.equals(modelPathItem)) {
                existingNames.add(curr.getName());
            }
        }

        if (modelPathItem == null) {
            setTitle("New ModelPathItem");
        } else {
            setTitle("Edit a ModelPathItem");
        }

        PathItemInputAdapter adapter = new PathItemInputAdapter();

        nameField = new StringDialogField();
        nameField.setLabelText("Name*");
        nameField.setDialogFieldListener(adapter);

        modelPatternField = new StringDialogField();
        modelPatternField.setLabelText("Model Pattern");
        modelPatternField.setDialogFieldListener(adapter);

        pathPatternField = new StringDialogField();
        pathPatternField.setLabelText("Path Pattern");
        pathPatternField.setDialogFieldListener(adapter);

        urlTemplateField = new StringDialogField();
        urlTemplateField.setLabelText("URL Template*");
        urlTemplateField.setDialogFieldListener(adapter);

        nameField.setText((modelPathItem != null && modelPathItem.getName() != null) ? modelPathItem.getName() : ""); //$NON-NLS-1$
        modelPatternField.setText((modelPathItem != null && modelPathItem.getModelPattern() != null)
                ? Objects.toString(modelPathItem.getModelPattern(), "") : ""); //$NON-NLS-1$
        pathPatternField.setText((modelPathItem != null && modelPathItem.getPathPattern() != null)
                ? Objects.toString(modelPathItem.getPathPattern(), "") : ""); //$NON-NLS-1$
        urlTemplateField.setText((modelPathItem != null && modelPathItem.getUriTemplate() != null)
                ? Objects.toString(modelPathItem.getUriTemplate(), "") : ""); //$NON-NLS-1$

    }

    public ModelPathItem getResult() {
        ModelPathItem pathItem = new ModelPathItem(modelPatternField.getText().trim(),
                pathPatternField.getText().trim(), urlTemplateField.getText().trim());
        pathItem.setName(nameField.getText().trim());
        return pathItem;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite inner = new Composite(composite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.numColumns = 2;
        inner.setLayout(layout);

        nameField.doFillIntoGrid(inner, 2);
        LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));
        LayoutUtil.setWidthHint(nameField.getTextControl(null), convertWidthInCharsToPixels(45));
        nameField.postSetFocusOnDialogField(parent.getDisplay());

        modelPatternField.doFillIntoGrid(inner, 2);
        LayoutUtil.setHorizontalGrabbing(modelPatternField.getTextControl(null));
        LayoutUtil.setWidthHint(modelPatternField.getTextControl(null), convertWidthInCharsToPixels(45));

        pathPatternField.doFillIntoGrid(inner, 2);
        LayoutUtil.setHorizontalGrabbing(pathPatternField.getTextControl(null));
        LayoutUtil.setWidthHint(pathPatternField.getTextControl(null), convertWidthInCharsToPixels(45));

        urlTemplateField.doFillIntoGrid(inner, 2);
        LayoutUtil.setHorizontalGrabbing(urlTemplateField.getTextControl(null));
        LayoutUtil.setWidthHint(urlTemplateField.getTextControl(null), convertWidthInCharsToPixels(45));

        applyDialogFont(composite);

        return composite;
    }

    private void doValidation() {
        IStatus status = Status.OK_STATUS;
        // check name
        String newText = nameField.getText();
        if (newText.length() == 0) {
            status = createErrorStatus("Enter a non-empty name");
        } else if (existingNames.contains(newText)) {
            status = createErrorStatus("A Model Path with this name already exists.\nChoose a different name");
        }
        if (!status.isOK()) {
            updateStatus(status);
            return;
        }
        // check URL Template
        newText = urlTemplateField.getText();
//        if (newText.length() == 0) {
//            status = createErrorStatus("Enter a non-empty URL template");
//        } else {
////            try {
////                new URL(newText);
////            } catch (MalformedURLException e) {
////                status = createErrorStatus("Enter a valid URL in URL template:\n" + e.getMessage());
////            }
//        }
        updateStatus(status);
    }
}