/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

public class RepreZenResourceForIEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {

    /*
     * ZEN-3726 RAPID-ML editor accepts incorrect import paths, shows errors on correct paths.
     * 
     * This method was overridden to fix an issue when project paths do not match workspace paths. Instead of making use
     * of platform based URI we make sure Xtext resources for RAPID-ML models use the OS file path. Thus imported models
     * paths are resolved according to the OS file system and not the workspace file system. That way both generators
     * and editors use the same mechanism to resolved model files.
     */
    @Override
    protected Resource createResourceFor(IStorage storage) throws CoreException {
        ResourceSet resourceSet = getResourceSet(storage);
        URI uri;
        if (storage instanceof IFile) {
            uri = URI.createFileURI(((IFile) storage).getRawLocation().toOSString());
        } else {
            uri = URI.createFileURI(storage.getFullPath().toString());
        }

        configureResourceSet(resourceSet, uri);
        XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
        resourceSet.getResources().add(resource);
        resource.setValidationDisabled(isValidationDisabled(uri, storage));
        return resource;
    }
}
