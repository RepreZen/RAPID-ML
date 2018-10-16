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

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Filesystem implementation of a {@link com.modelsolv.reprezen.core.workspace.Workspace}.
 * 
 * @author jimleroyer
 * @since 2013/04/29
 */
public class FilesystemWorkspace implements Workspace {

    public FilesystemWorkspace() {
    }

    /**
     * Gets the root workspace directory.
     * 
     * @return {@link java.io.File} of the root directory.
     */
    @Override
    public File getWorkspaceDirectory() {
        String userDir = System.getProperty("user.dir");
        return new File(userDir);
    }

    /**
     * Gets the given file relative to the workspace.
     * 
     * @param fileLocation
     *            File location to search as a {@link String}.
     * @return Found {@link java.io.File} if existing
     */
    @Override
    public Optional<File> getWorkspaceFile(String fileLocation) {
        Preconditions.checkArgument(fileLocation != null, "The file location should not be null.");
        Preconditions.checkArgument(fileLocation.length() > 0, "The file location should not be empty.");
        return Optional.of(new File(fileLocation));
    }

    /**
     * Gets the given file relative to the workspace.
     * 
     * @param fileLocation
     *            File location to search.
     * @return Found {@link java.io.File} if existing else {@link com.google.common.base.Absent}
     */
    public Optional<File> getWorkspaceFile(URI fileLocation) {
        Preconditions.checkArgument(fileLocation != null, "The file location should not be null.");
        if (!fileLocation.isFile()) {
            throw new RuntimeException("The URI is not a file location.");
        }
        String path = fileLocation.toFileString();
        return Optional.of(new File(path));
    }

}
