/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.preferences;

import org.eclipse.xtext.validation.SeverityConverter;

public class DefaultRapidMLPreferences implements RapidMLPreferences {

	@Override
	public String getString(String name) {
		return SeverityConverter.SEVERITY_IGNORE;
	}

	@Override
	public boolean getBoolean(String name) {
		return false;
	}

}
