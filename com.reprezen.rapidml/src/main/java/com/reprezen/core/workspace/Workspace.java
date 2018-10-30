/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.core.workspace;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Optional;

/**
 * Workspace abstraction meant to be on top of specialized environments such as Eclipse, servlets or unit-tests.
 * 
 * @author jimleroyer
 * @since 2013/04/29
 * 
 *        <Location> : Represents the location mechanism used to locate a file (URI, String file location, etc...)
 */
public interface Workspace {

    /**
     * Gets the root workspace directory.
     * 
     * @return {@link java.io.File} of the root directory.
     */
    public File getWorkspaceDirectory();

    /**
     * Gets the given file relative to the workspace.
     * 
     * @param fileLocation
     *            File location to search.
     * @return Found {@link java.io.File} if existing else {@link com.google.common.base.Absent}
     */
    public Optional<File> getWorkspaceFile(String fileLocation);

    /**
     * Gets the given file relative to the workspace.
     * 
     * @param fileLocation
     *            File location to search.
     * @return Found {@link java.io.File} if existing else {@link com.google.common.base.Absent}
     */
    public Optional<File> getWorkspaceFile(URI fileLocation);

}
