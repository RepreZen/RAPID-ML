/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;

import com.google.common.collect.Lists;

/**
 * @author Konstantin Zaitsev
 */
public class SelectionUtils {

    public static Optional<IResource> getSelectedResource() {
        return getSelectedResource(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
    }

    public static Optional<IResource> getSelectedResource(IWorkbenchWindow window) {
        Collection<IResource> selectedResources = getSelectedResources(window);
        if (selectedResources.isEmpty()) {
            IResource activeEditorResource = getActiveEditorResource(window);
            if (activeEditorResource!= null) {
                selectedResources = Collections.singletonList(activeEditorResource);
            }
        }
        return selectedResources.isEmpty() ? Optional.empty()
                : Optional.of(selectedResources.iterator().next());
    }

    public static Collection<IResource> getSelectedResources() {
        return getSelectedResources(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
    }

    public static Collection<IResource> getSelectedResources(IWorkbenchWindow window) {
        List<IResource> results = Lists.newArrayList();
        ISelectionService service = window.getSelectionService();
        ISelection selection = service.getSelection();
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structured = (IStructuredSelection) selection;
            for (Iterator<?> iter = structured.iterator(); iter.hasNext();) {
                Object next = iter.next();
                if (next instanceof IResource) {
                    results.add((IResource) next);
                }
            }
        }
        return results;
    }

    public static IResource getActiveEditorResource(IWorkbenchWindow window) {
        IEditorPart editor = window.getActivePage().getActiveEditor();
        if (editor instanceof TextEditor) {
            IEditorInput editorInput = ((TextEditor) editor).getEditorInput();
            if (editorInput instanceof FileEditorInput) {
                return ((FileEditorInput) editorInput).getFile();
            }
        }
        return null;
    }

}
