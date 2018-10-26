/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.modelpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.internal.WorkbenchImages;

import com.modelsolv.reprezen.rapidml.xtext.modelpath.ModelPath;

public class ModelPathWidget {
    private ComboViewer modelPathViewer;
    private String activeModelPath;
    private List<ModelPathListener> modelPathListeners = new ArrayList<>();

    public void setModelPaths(String[] modelPaths) {
        modelPathViewer.setInput(modelPaths);
    }

    public void select(String element) {
        StructuredSelection selection = element != null ? new StructuredSelection(element) : StructuredSelection.EMPTY;
        modelPathViewer.setSelection(selection);
    }

    public String getActiveModelPath() {
        return activeModelPath;
    }

    protected Composite createComposite(Composite parent2) {
        Composite parent = new Composite(parent2, SWT.NONE);
        parent.setLayout(new RowLayout());
        parent.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

        Label label = new Label(parent, SWT.NONE);
        label.setText("Model Path:");
        modelPathViewer = new ComboViewer(parent, SWT.READ_ONLY);
        modelPathViewer.getCombo().setLayoutData(new RowData(200, SWT.DEFAULT));

        modelPathViewer.setContentProvider(ArrayContentProvider.getInstance());
        modelPathViewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof ModelPath) {
                    ModelPath person = (ModelPath) element;
                    return person.getName();
                }
                return super.getText(element);
            }
        });

        modelPathViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                String selectedElement = getSelectedElement();
                String oldModelPath = activeModelPath;
                activeModelPath = selectedElement;
                for (ModelPathListener l : modelPathListeners) {
                    l.onModelPathSelect(selectedElement, oldModelPath);
                }
            }
        });

        Composite modelPathButtons = new Composite(parent, SWT.NONE);
        modelPathButtons.setLayout(new RowLayout());
        modelPathButtons.setFont(parent.getFont());

        Button addModelPathButton = new Button(modelPathButtons, SWT.PUSH | SWT.FLAT);
        addModelPathButton.setImage(WorkbenchImages.getImage(ISharedImages.IMG_OBJ_ADD));
        addModelPathButton.setToolTipText("Create a New Model Path");
        addModelPathButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                onAdd();
            }
        });

        Button editModelPathButton = new Button(modelPathButtons, SWT.PUSH | SWT.FLAT);
        editModelPathButton.setImage(WorkbenchImages.getImage(ISharedImages.IMG_OBJ_ELEMENT));
        editModelPathButton.setToolTipText("Edit a Model Path");
        editModelPathButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                onRename();
            }
        });

        Button deleteModelPathButton = new Button(modelPathButtons, SWT.PUSH | SWT.FLAT);
        deleteModelPathButton.setImage(WorkbenchImages.getImage(ISharedImages.IMG_TOOL_DELETE));
        deleteModelPathButton.setToolTipText("Delete a Model Path");
        deleteModelPathButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                onDelete();
            }
        });

        return parent;

    }

    private void onDelete() {
        String deleted = getSelectedElement();
        activeModelPath = null;
        for (ModelPathListener l : modelPathListeners) {
            l.onModelPathNameChanged(null, deleted);
        }
    }

    private void onRename() {
        String edited = getSelectedElement();
        ModelPathInputDialog dialog = new ModelPathInputDialog(modelPathViewer.getControl().getShell(), edited,
                Arrays.asList((String[]) modelPathViewer.getInput()));
        if (dialog.open() == Window.OK) {
            String newElement = dialog.getResult();
            String oldModelPath = activeModelPath;
            activeModelPath = newElement;
            for (ModelPathListener l : modelPathListeners) {
                l.onModelPathNameChanged(newElement, oldModelPath);
            }
        }
    }

    private void onAdd() {
        String edited = null;
        ModelPathInputDialog dialog = new ModelPathInputDialog(modelPathViewer.getControl().getShell(), edited,
                Arrays.asList((String[]) modelPathViewer.getInput()));
        if (dialog.open() == Window.OK) {
            String newElement = dialog.getResult();
            for (ModelPathListener l : modelPathListeners) {
                l.onModelPathNameChanged(newElement, null);
            }
        }
    }

    private String getSelectedElement() {
        IStructuredSelection selection = modelPathViewer.getStructuredSelection();
        if (!selection.isEmpty()) {
            return (String) selection.getFirstElement();
        }
        return null;
    }

    public void addModelPathListener(ModelPathListener modelPathListener) {
        modelPathListeners.add(modelPathListener);
    }

    public boolean removeModelPathListener(ModelPathListener modelPathListener) {
        return modelPathListeners.remove(modelPathListener);
    }

    public interface ModelPathListener {
        void onModelPathSelect(String newModelPathName, String oldModelPathName);

        void onModelPathNameChanged(String newModelPathName, String oldModelPathName);
    }

}