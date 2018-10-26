/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;

/*
 * A modified IStorage2UriMapper implementation that creates URI from file schemes instead of
 * platform schemes (file system vs workspace).
 */
public class Storage2FileUriMapperImpl extends Storage2UriMapperImpl {

    @Override
    public URI getUri(IStorage storage) {
        URI uri = internalGetUri(storage);
        if (uri != null && isValidUri(uri, storage))
            return uri;
        return null;
    }

    /*
     * ZEN-3726 RAPID-ML editor accepts incorrect import paths, shows errors on correct paths.
     * 
     * Make sure we are using OS based file paths and not workspace based file paths.
     */
    private URI internalGetUri(/* @NonNull */ IStorage storage) {
        if (storage instanceof IFile) {
            IPath location = ((IFile) storage).getLocation();
            if (location != null) {
                return URI.createFileURI(location.toString());
            }
        }
        return null;
    }
}