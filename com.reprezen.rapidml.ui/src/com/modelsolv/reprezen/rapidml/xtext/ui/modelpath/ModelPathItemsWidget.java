/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.modelpath;

import java.util.List;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.DialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IListAdapter;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.ListDialogField;

import com.modelsolv.reprezen.rapidml.xtext.modelpath.ModelPathItem;

public class ModelPathItemsWidget {
    private static final int IDX_ADD = 0;
    private static final int IDX_EDIT = 1;
    private static final int IDX_UP = 2;
    private static final int IDX_DOWN = 3;
    private static final int IDX_REMOVE = 4;

    private ListDialogField modelPathItems;

    public Composite createComposite(Composite innerParent, List<ModelPathItem> pathItems) {
        PathItemListAdapter adapter = new PathItemListAdapter();
        String[] buttons = new String[] { "Add...", //
                "Edit...", //
                "Move Up", //
                "Move Down", //
                "Remove" };

        modelPathItems = new ListDialogField(adapter, buttons, new PathItemLabelProvider());
        modelPathItems.setDialogFieldListener(adapter);
        modelPathItems.setUpButtonIndex(IDX_UP);
        modelPathItems.setDownButtonIndex(IDX_DOWN);
        modelPathItems.setRemoveButtonIndex(IDX_REMOVE);

        String[] columnsHeaders = new String[] { "Name", "URL Template" };

        modelPathItems.setTableColumns(new ListDialogField.ColumnsDescription(columnsHeaders, true));
        modelPathItems.setElements(pathItems);

        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.numColumns = 2;

        PixelConverter conv = new PixelConverter(innerParent);

        Composite modelPathItemComposite = new Composite(innerParent, SWT.NULL);
        modelPathItemComposite.setLayout(layout);
        modelPathItemComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
        modelPathItemComposite.setFont(innerParent.getFont());

        GridData data = new GridData(GridData.FILL_BOTH);
        data.widthHint = conv.convertWidthInCharsToPixels(50);
        Control listControl = modelPathItems.getListControl(modelPathItemComposite);
        listControl.setLayoutData(data);

        Control buttonsControl = modelPathItems.getButtonBox(modelPathItemComposite);
        buttonsControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_BEGINNING));

        return modelPathItemComposite;
    }

    public void setElements(List<ModelPathItem> modelPathItems2) {
        modelPathItems.setElements(modelPathItems2);
    }

    public void setEnabled(boolean enabled) {
        modelPathItems.setEnabled(enabled);
    }

    private class PathItemListAdapter implements IListAdapter, IDialogFieldListener {

        private boolean canEdit(List<ModelPathItem> selectedElements) {
            return selectedElements.size() == 1;
        }

        @Override
        public void customButtonPressed(ListDialogField field, int index) {
            pathItemButtonPressed(index, field.getTableViewer().getControl().getShell());
        }

        @Override
        public void selectionChanged(ListDialogField field) {
            @SuppressWarnings("unchecked")
            List<ModelPathItem> selectedElements = field.getSelectedElements();
            field.enableButton(IDX_EDIT, canEdit(selectedElements));
        }

        @Override
        public void doubleClicked(ListDialogField field) {
            @SuppressWarnings("unchecked")
            List<ModelPathItem> selectedElements = field.getSelectedElements();

            if (canEdit(selectedElements)) {
                pathItemButtonPressed(IDX_EDIT, field.getTableViewer().getControl().getShell());
            }
        }

        @Override
        public void dialogFieldChanged(DialogField field) {
            // updateModel(field);
        }

        private void pathItemButtonPressed(int index, Shell parent) {
            ModelPathItem edited = null;
            if (index != IDX_ADD) {
                edited = (ModelPathItem) modelPathItems.getSelectedElements().get(0);
            }
            if (index == IDX_ADD || index == IDX_EDIT) {
                @SuppressWarnings("unchecked")
                PathItemInputDialog dialog = new PathItemInputDialog(parent, edited, modelPathItems.getElements());
                if (dialog.open() == Window.OK) {
                    if (edited != null) {
                        modelPathItems.replaceElement(edited, dialog.getResult());
                    } else {
                        modelPathItems.addElement(dialog.getResult());
                    }
                }
            }
        }

    }

    private class PathItemLabelProvider extends LabelProvider implements ITableLabelProvider, IFontProvider {

        @Override
        public Image getImage(Object element) {
            return null;
        }

        @Override
        public String getText(Object element) {
            return getColumnText(element, 0);
        }

        @Override
        public Image getColumnImage(Object element, int columnIndex) {
            return null;
        }

        @Override
        public String getColumnText(Object element, int columnIndex) {
            ModelPathItem pathItem = (ModelPathItem) element;
            if (columnIndex == 0) {
                return pathItem.getName();
            } else {
                return pathItem.getUriTemplate();
            }
        }

        @Override
        public Font getFont(Object element) {
            return null;
        }

    }

    public List<ModelPathItem> getElements() {
        return modelPathItems.getElements();
    }

}