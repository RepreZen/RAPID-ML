/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import static java.lang.String.format;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.reprezen.rapidml.ZenModel;

/**
 * Loader for the ModelSolv RESTApi metamodel.
 * 
 * @author jimleroyer
 * @since 2013/04/25
 */
public abstract class RestModelLoader {

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelPath
     *            {@link org.eclipse.emf.common.util.URI} of the RESTApi metamodel.
     * @return {@link com.reprezen.rapidml.ZenModel}
     */
    public abstract ZenModel load(URI modelPath);

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelLocation
     *            Location of the model, as a {@link String}.
     * @return {@link com.reprezen.rapidml.ZenModel}
     */
    public abstract ZenModel load(String modelLocation);

    public static void validateFile(URI modelPath) {
        if (modelPath.isPlatformResource()) {
            IFile file;
            try {
                file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelPath.toPlatformString(true)));
            } catch (Exception e) {
                throw new RuntimeException(format("The model file '%s' does not exist.", modelPath));
            }
            if (file == null || !file.exists()) {
                throw new RuntimeException(format("The model file '%s' does not exist.", modelPath));
            }
            if (file.getType() != IResource.FILE) {
                throw new RuntimeException(format("The '%s' path is not a file.", modelPath));
            }
        }
    }

    public static void validateFile(String modelPath) {
        File file;
        try {
            file = Paths.get(new java.net.URI(modelPath)).toFile();
        } catch (Exception e) {
            throw new RuntimeException(format("The model file '%s' does not exist.", modelPath));
        }
        if (file == null || !file.exists()) {
            throw new RuntimeException(format("The model file '%s' does not exist.", modelPath));
        }
        if (!file.isFile()) {
            throw new RuntimeException(format("The '%s' path is not a file.", modelPath));
        }
    }

}
