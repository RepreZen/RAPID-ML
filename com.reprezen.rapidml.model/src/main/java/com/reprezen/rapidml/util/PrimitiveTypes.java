/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.util;

import com.reprezen.rapidml.PrimitiveType;

@SuppressWarnings("nls")
public enum PrimitiveTypes {
	ANYURI("anyURI"), DURATION("duration"), BASE64BINARY("base64Binary"), BOOLEAN("boolean"), DATE("date"), DATETIME(
			"dateTime"), DECIMAL("decimal"), DOUBLE("double"), FLOAT("float"), GMONTH("gMonth"), GMONTHDAY(
					"gMonthDay"), GDAY("gDay"), GYEARMONTH("gYearMonth"), GYEAR("gYear"), QNAME("QName"), TIME(
							"time"), STRING("string"), NCNAME("NCName"), INT("int"), INTEGER("integer"), LONG("long");

	private String typeName;

	private PrimitiveTypes(String name) {
		this.typeName = name;
	}

	public String typeName() {
		return typeName;
	}

	public static boolean isPrimitiveType(String type) {
		return getByTypeName(type) != null;
	}

	public static boolean isOneOf(String type, PrimitiveTypes... types) {
		for (PrimitiveTypes pt : types) {
			if (pt.typeName().equals(type)) {
				return true;
			}
		}
		return false;
	}

	public static PrimitiveTypes getByTypeName(String type) {
		for (PrimitiveTypes pt : values()) {
			if (pt.typeName().equals(type)) {
				return pt;
			}
		}
		return null;
	}

	@SuppressWarnings("incomplete-switch")
	public static boolean isStringBaseType(PrimitiveType type) {
		PrimitiveTypes pt = getByTypeName(type.getName());
		switch (pt) {
		case ANYURI:
		case BASE64BINARY:
		case DATE:
		case DATETIME:
		case GMONTH:
		case GMONTHDAY:
		case GDAY:
		case GYEARMONTH:
		case GYEAR:
		case QNAME:
		case TIME:
		case STRING:
		case NCNAME:
		case DURATION:
			return true;
		}
		return false;
	}

	@SuppressWarnings("incomplete-switch")
	public static boolean isNumberBaseType(PrimitiveType type) {
		PrimitiveTypes pt = getByTypeName(type.getName());
		switch (pt) {
		case DECIMAL:
		case DOUBLE:
		case FLOAT:
		case INT:
		case INTEGER:
		case LONG:
			return true;
		}
		return false;
	}
}