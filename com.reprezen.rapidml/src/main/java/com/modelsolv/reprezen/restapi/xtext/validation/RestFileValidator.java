/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.validation;

import static java.lang.String.format;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Optional;
import com.modelsolv.reprezen.core.workspace.Workspace;
import com.modelsolv.reprezen.core.util.EmfUtils;

/**
 * File utilities template around RESTApi models. These are specific to the latter and aren't general to files, due to
 * their exception management.
 * 
 * @author jimleroyer
 * @since 2013/04/26
 */
public class RestFileValidator {

    protected Workspace workspace;

    public RestFileValidator(Workspace workspace) {
        this.workspace = workspace;
    }

    /**
     * Validates a directory and throws a {@link com.modelsolv.reprezen.restapi.xtext.RestApiException} if invalid.
     * 
     * @param directory
     *            The directory to validate.
     * @throws {@link com.modelsolv.reprezen.restapi.xtext.RestApiException}
     */
    public void validateDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            throw new RuntimeException(format("The directory '%s' does not exist.", directory));
        }
        if (!dir.isDirectory()) {
            throw new RuntimeException(format("The '%s' path is not a directory.", directory));
        }
    }

    /**
     * Validates a file and throws a {@link com.modelsolv.reprezen.restapi.xtext.RestApiException} if invalid.
     * 
     * @param modelFile
     *            The model file location to validate.
     * @throws {@link com.modelsolv.reprezen.restapi.xtext.RestApiException}
     */
    public void validateFile(File modelFile) {
        if (!modelFile.exists()) {
            throw new RuntimeException(format("The model file '%s' does not exist.", modelFile));
        }
        if (!modelFile.isFile()) {
            throw new RuntimeException(format("The '%s' path is not a file.", modelFile));
        }
    }

    /**
     * Validates a file and throws a {@link com.modelsolv.reprezen.restapi.xtext.RestApiException} if invalid.
     * 
     * @param modelLocation
     *            The model file location to validate.
     * @throws {@link com.modelsolv.reprezen.restapi.xtext.RestApiException}
     */
    public void validateFile(String modelLocation) {
        Optional<File> optional = workspace.getWorkspaceFile(modelLocation);
        if (!optional.isPresent()) {
            throw new RuntimeException(format("The model file '%s' was not found in the workspace.", modelLocation));
        }
        validateFile(optional.get());
    }

    /**
     * Validates a file and throws a {@link com.modelsolv.reprezen.restapi.xtext.RestApiException} if invalid.
     * 
     * @param modelLocation
     *            The model file location to validate.
     * @throws {@link com.modelsolv.reprezen.restapi.xtext.RestApiException}
     */
    public void validateFile(URI modelLocation) {
        // We don't need to validate URIs part of a plug-in or archives.
        if (!EmfUtils.isWorkspace(modelLocation)) {
            return;
        }
        Optional<File> optional = workspace.getWorkspaceFile(modelLocation);
        if (!optional.isPresent()) {
            throw new RuntimeException(format("The model file '%s' was not found in the workspace.", modelLocation));
        }
        validateFile(optional.get());
    }

}
