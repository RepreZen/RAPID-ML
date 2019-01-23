/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.importing.help;

import org.eclipse.emf.common.util.URI;

import com.google.common.io.Resources;

public class DataModelImport {

	private final static String XTEXT_RESOURCES_FOLDER = //
			Resources.getResource(DataModelImport.class, "/dsl/").getFile();

	private final String fqn;
	private final String modelFileFromModelsDslPath;
	private final String label;

	public DataModelImport(String fqn, String modelFileFromModelsDslPath, String label) {
		this.fqn = fqn;
		this.modelFileFromModelsDslPath = modelFileFromModelsDslPath;
		this.label = label;
	}

	public String importString() {
		return "import " + fqn + " from \"" //$NON-NLS-1$ //$NON-NLS-2$
				+ URI.createFileURI(XTEXT_RESOURCES_FOLDER + modelFileFromModelsDslPath) + "\""; //$NON-NLS-1$
	}

	public String fqn(String type) {
		return fqn + "." + type; //$NON-NLS-1$
	}

	@Override
	public String toString() {
		return "DataModelImport [fqn=" + fqn + "]"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public String getFqn() {
		return fqn;
	}

	public String getLabel() {
		return label;
	}
}
