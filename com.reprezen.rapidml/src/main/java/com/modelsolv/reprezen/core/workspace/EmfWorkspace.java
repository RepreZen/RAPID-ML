/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.core.workspace;

import java.io.File;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.modelsolv.reprezen.core.util.EmfUtils;

/**
 * Eclipse implementation for an Eclipse plug-in {@link com.modelsolv.reprezen.core.workspace.Workspace}.
 * 
 * @author jimleroyer
 * @since 2013/04/29
 */
public class EmfWorkspace implements Workspace {

    protected IWorkspaceRoot workspaceRoot;

    public EmfWorkspace(IWorkspaceRoot workspaceRoot) {
        this.workspaceRoot = workspaceRoot;
    }

    /**
     * Gets the root workspace directory.
     * 
     * @return {@link java.io.File} of the root directory.
     */
    @Override
    public File getWorkspaceDirectory() {
        IPath workspacePath = workspaceRoot.getFullPath();
        return workspacePath.toFile();
    }

    /**
     * Gets the given file relative to the workspace. Make sure the provided URI can be part of the workspace (not part
     * of a plug-in or archive) before calling this method, else a {@link com.modelsolv.reprezen.core.workspace.WorkspaceException}
     * will be thrown.
     * 
     * @param fileUri
     *            File URI to search.
     * @return Found {@link java.io.File} if part of the workspace else {@link com.google.common.base.Absent}
     * @throws {@link com.modelsolv.reprezen.core.workspace.WorkspaceException} If a URI part of a plug-in is provided.
     * @see {@link com.modelsolv.util.EmfUtils}
     */
    public Optional<File> getWorkspaceFile(URI fileUri) {
        Preconditions.checkArgument(fileUri != null, "The file location should not be null.");
        if (!EmfUtils.isWorkspace(fileUri)) {
            throw new RuntimeException("The workspace cannot contain a file with this URI.");
        }
        IPath workspacePath = workspaceRoot.getFile(new Path(fileUri.toPlatformString(true))).getLocation();
        return Optional.fromNullable(workspacePath.toFile());
    }

    /**
     * Gets the given file relative to the workspace.
     * 
     * @param fileLocation
     *            File location to search.
     * @return Found {@link java.io.File} if existing else {@link com.google.common.base.Absent}
     */
    public Optional<File> getWorkspaceFile(String fileLocation) {
        Preconditions.checkArgument(fileLocation != null, "The file location should not be null.");
        Preconditions.checkArgument(fileLocation.length() > 0, "The file location should not be empty.");
        return Optional.of(new File(fileLocation));
    }

}
