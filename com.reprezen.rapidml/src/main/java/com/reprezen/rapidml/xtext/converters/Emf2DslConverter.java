/*******************************************************************************
 * Copyright © 2013, 2016 , Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of , Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.converters;

import static com.reprezen.core.RapidFileExtensions.RAPID;
import static com.reprezen.core.XmiFileExtensions.XMI;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Preconditions;
import com.reprezen.core.workspace.Workspace;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.xtext.loaders.EmfRestModelLoader;
import com.reprezen.rapidml.xtext.serializers.DslRestModelSerializer;
import com.reprezen.rapidml.xtext.validation.RestFileValidator;

/**
 * A REST EMF XMI to DSL converter.
 * 
 * @author tfensenko
 * @author jimleroyer
 */
public class Emf2DslConverter {

    protected RestFileValidator validator;
    protected Workspace workspace;
    protected final String modelFile;
    protected final String modelPath;

    public Emf2DslConverter(String modelFile, Workspace workspace) throws IOException {
        Preconditions.checkArgument(modelFile != null, "The model path should not be null");
        Preconditions.checkArgument(XMI.extensionEquals(getFileExtension(modelFile)),
                "The model path should end with the 'xmi' extension.");
        validator = new RestFileValidator(workspace);
        validator.validateFile(modelFile);

        this.workspace = workspace;
        this.modelFile = modelFile;
        this.modelPath = getDirectory(modelFile);

        // EPackage Initialization
        RapidmlPackage.eINSTANCE.eClass();
        new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(modelPath);
    }

    public void emfToDsl(String outputDirectory) throws IOException {
        Preconditions.checkArgument(outputDirectory != null, "The output directory should not be null.");
        validator.validateDirectory(outputDirectory);
        ZenModel model = loadEmfModel(this.modelFile);
        String emfFilePath = new File(outputDirectory, getDslFilename(this.modelFile)).getPath();
        saveDslModel(emfFilePath, model);
    }

    private String getDslFilename(String emfFilename) {
        return FilenameUtils.getBaseName(emfFilename) + "." + RAPID;
    }

    private String getFileExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    private String getDirectory(String modelPath) {
        return new File(modelPath).getParent();
    }

    private ZenModel loadEmfModel(String path) {
        URI uri = URI.createFileURI(path);
        return new EmfRestModelLoader(workspace).load(uri);
    }

    public void saveDslModel(String path, ZenModel model) throws IOException {
        new DslRestModelSerializer().serialize(path, model);
    }

}