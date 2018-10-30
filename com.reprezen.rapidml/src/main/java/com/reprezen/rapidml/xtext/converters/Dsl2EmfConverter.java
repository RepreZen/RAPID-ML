/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.converters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Preconditions;
import com.reprezen.core.workspace.Workspace;
import com.reprezen.core.workspace.WorkspaceUtils;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.xtext.loaders.DslRestModelLoader;
import com.reprezen.rapidml.xtext.serializers.EmfRestModelSerializer;
import com.reprezen.rapidml.xtext.validation.RestFileValidator;

/**
 * A REST DSL to EMF XMI converter.
 * 
 * @author tfensenko
 * @author jimleroyer
 */
public class Dsl2EmfConverter {

    protected RestFileValidator validator;
    protected Workspace workspace;
    private final String modelFile;
    private final String modelPath;

    public Dsl2EmfConverter(String modelFile, Workspace workspace) throws IOException {
        Preconditions.checkArgument(modelFile != null, "The model path should not be null");
        Preconditions.checkArgument(WorkspaceUtils.isZenExtension(getFileExtension(modelFile)),
                "The model path should end with the 'rest' extension.");
        validator = new RestFileValidator(workspace);
        validator.validateFile(modelFile);

        this.workspace = workspace;
        this.modelFile = modelFile;
        this.modelPath = getDirectory(modelFile);

        // EPackage Initialization
        RapidmlPackage.eINSTANCE.eClass();
        new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(modelPath);
    }

    public void dslToEmf(String outputDirectory) throws IOException {
        Preconditions.checkArgument(outputDirectory != null, "The output directory should not be null.");
        validator.validateDirectory(outputDirectory);
        ZenModel model = loadDslModel(this.modelFile);
        String dslFilePath = new File(outputDirectory, getEmfFilename(this.modelFile)).getPath();
        saveEmfModel(dslFilePath, model);
    }

    private String getEmfFilename(String dslFilename) {
        return FilenameUtils.getBaseName(dslFilename) + ".xmi";
    }

    private String getFileExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    private String getDirectory(String modelPath) {
        return new File(modelPath).getParent();
    }

    private ZenModel loadDslModel(String path) {
        URI uri = URI.createFileURI(path);
        return new DslRestModelLoader(workspace).load(uri);
    }

    private void saveEmfModel(String path, ZenModel model) throws IOException {
        new EmfRestModelSerializer().serialize(path, model);
    }

}