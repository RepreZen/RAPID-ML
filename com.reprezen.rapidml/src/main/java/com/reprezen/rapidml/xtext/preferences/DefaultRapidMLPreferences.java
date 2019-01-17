/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.preferences;

import java.util.Map;

import javax.inject.Singleton;

import org.eclipse.xtext.validation.SeverityConverter;

import com.google.common.collect.Maps;

@Singleton
public class DefaultRapidMLPreferences implements RapidMLPreferences {

	private final Map<String, Object> values = Maps.newHashMap();

	@Override
	public String getString(String name) {		
		if (values.containsKey(name)) {
			return (String) values.get(name);
		}

		return SeverityConverter.SEVERITY_WARNING;
	}

	@Override
	public boolean getBoolean(String name) {		
		if (values.containsKey(name)) {
			return (boolean) values.get(name);
		}

		return true;
	}

	public void setValue(String key, Object value) {
		values.put(key, value);
	}

}
