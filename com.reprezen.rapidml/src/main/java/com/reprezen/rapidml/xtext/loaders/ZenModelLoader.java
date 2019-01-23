/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.xtext.XtextDslStandaloneSetup;

/**
 * A utility class to load ZenModel in headless mode.
 * 
 * @author Tatiana Fesenko
 *
 */
public class ZenModelLoader {

	private final ResourceSet resourceSet;
	private final IResourceValidator validator;

	private final String errorMessage = "Selected RepreZen model contains errors: %s";

	/*
	 * This constructor should be used only in tests where the resourceSet is
	 * injected and cleaned up by the XtextRunner.
	 */
	@Inject
	public ZenModelLoader(ResourceSet resourceSet, IResourceValidator validator) {
		this.resourceSet = resourceSet;
		this.validator = validator;
	}

	/*
	 * This is the default constructor that injects the resourceSet from the
	 * language standalone setup. This should be used to load models in headless
	 * mode.
	 */
	public ZenModelLoader() {
		Injector injector = XtextDslStandaloneSetup.doSetup();
		this.resourceSet = injector.getInstance(ResourceSet.class);
		this.validator = injector.getInstance(IResourceValidator.class);
	}

	public ZenModel loadModel(File modelFile) {
		return loadModel(URI.createFileURI(modelFile.getAbsolutePath()));
	}

	public ZenModel loadModel(URI modelUri) {
		Resource resource = getResource(modelUri);
		ZenModel model = (ZenModel) resource.getContents().get(0);

		return model;
	}

	public ZenModel loadAndValidateModel(File modelFile) {
		return loadAndValidateModel(URI.createFileURI(modelFile.getAbsolutePath()));
	}

	public ZenModel loadAndValidateModel(URI modelUri) {
		Resource resource = getResource(modelUri);

		if (validator != null) {
			List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!issues.isEmpty()) {
				throw new RuntimeException(String.format(errorMessage, issues.get(0).getMessage()));
			}
		} else if (!resource.getErrors().isEmpty()) {
			throw new RuntimeException(String.format(errorMessage, resource.getErrors().get(0).getMessage()));
		}

		return (ZenModel) resource.getContents().get(0);
	}

	private Resource getResource(URI modelUri) {
		Resource resource = this.resourceSet.getResource(modelUri, true);
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);

		return resource;
	}

}
