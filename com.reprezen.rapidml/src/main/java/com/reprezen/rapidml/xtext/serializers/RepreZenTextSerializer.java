/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.serializers;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;

import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.xtext.loaders.RepreZenXtextResourceSet;

/**
 * Serializer a RepreZen EMF to a textual form according to the Xtext grammar
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class RepreZenTextSerializer {
	private static final String CRLF = System.getProperty("line.separator");

	@Inject
	private ISerializer serializer;

	public String serializeToDslString(ZenModel zenModel) {
		// Xtext serializer needs both a resource with non-null URL and a resource set
		XtextResourceSet resourceSet = new RepreZenXtextResourceSet();
		XtextResource resource = ((XtextResource) resourceSet.createResource(URI.createURI("dummy.rapid")));
		resource.getContents().add(zenModel);
		// serialize
		return serializer.serialize(zenModel);

	}

	public String serializeToDslString(ZenModel zenModel, Iterable<String> additionalComments) {
		String zenCode = serializeToDslString(zenModel);
		if (additionalComments.iterator().hasNext()) {
			zenCode = insertZenModelCodeComments(zenCode, toCodeComments(additionalComments));
		}
		return zenCode;
	}

	public static String toCodeComments(Iterable<String> comments) {
		StringBuilder result = new StringBuilder();
		for (String next : comments) {
			result.append(next).append(CRLF); // additional one
		}
		return result.toString();
	}

	public static String insertZenModelCodeComments(String zenCode, String codeComments) {
		int modelStart = zenCode.indexOf("rapidModel");
		if (modelStart < 0) {
			throw new IllegalStateException("RAPID Model serialized without 'rapidModel': " + zenCode);
		}
		StringBuilder result = new StringBuilder();
		String beforeComment = zenCode.substring(0, modelStart);
		result.append(beforeComment);
		if (beforeComment.length() > 0 && !beforeComment.endsWith(CRLF)) {
			result.append(CRLF);
		}
		result.append("/* ").append(CRLF);
		result.append(codeComments);
		result.append("*/").append(CRLF);
		result.append(zenCode.substring(modelStart));
		return result.toString();
	}
}
