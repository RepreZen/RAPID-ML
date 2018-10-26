/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.core.util;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Preconditions;

/**
 * Utility methods around the EMF {@link org.eclipse.emf.common.util.URI} object.
 * 
 * @author jimleroyer
 * @since 2013/05/10
 */
public abstract class EmfUtils {

    private EmfUtils() {
    }

    /**
     * Inspired by {@link org.eclipse.emf.common.util.URI#isPlatform()}, the method returns TRUE if the given URI can be
     * resolved by the {@link com.reprezen.core.workspace.Workspace}. The URIs that cannot be resolved are the ones in
     * plug-ins or in archives.
     * 
     * @param uri
     *            {@link org.eclipse.emf.common.util.URI} to verify
     * @return True if the URI targets the {@link com.reprezen.core.workspace.Workspace} else false.
     */
    public static Boolean isWorkspace(URI uri) {
        Preconditions.checkArgument(uri != null, "The URI is null.");
        if (uri.isPlatformPlugin() || uri.isArchive()) {
            return FALSE;
        } else {
            return TRUE;
        }
    }

}

