/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.datatypes.util;

import com.reprezen.rapidml.ConstrainableType;
import com.reprezen.rapidml.PrimitiveProperty;
import com.reprezen.rapidml.PrimitiveType;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.SimpleType;
import com.reprezen.rapidml.SingleValueType;
import com.reprezen.rapidml.UserDefinedType;

/**
 * @author Konstantin Zaitsev
 * @date Mar 10, 2015
 */
public class ConstraintsUtils {

	/**
	 * Returns appropriate constrainable parent type.
	 *
	 * @param constrainableType
	 *            the constrainable type
	 * @return the constrainable parent
	 */
	public static ConstrainableType getConstrainableParent(ConstrainableType constrainableType) {
		if (constrainableType instanceof PropertyRealization) {
			PropertyRealization includedProperty = (PropertyRealization) constrainableType;
			if (includedProperty.getBaseProperty() instanceof PrimitiveProperty) {
				return (PrimitiveProperty) includedProperty.getBaseProperty();
			}
		} else if (constrainableType instanceof PrimitiveProperty) {
			PrimitiveProperty primitiveProperty = (PrimitiveProperty) constrainableType;
			if (primitiveProperty.getType() instanceof UserDefinedType) {
				return (UserDefinedType) primitiveProperty.getType();
			}
		} else if (constrainableType instanceof UserDefinedType) {
			UserDefinedType userDefinedType = (UserDefinedType) constrainableType;
			if (userDefinedType.getBaseType() instanceof UserDefinedType
					&& !isCircularBaseTypeReference(userDefinedType)) {
				// check for cycle
				return (ConstrainableType) userDefinedType.getBaseType();
			}
		}
		return null;
	}

	/**
	 * Gets the base primitive type in type hierarchy of user defined types or from
	 * included properties. If type not primitive it returns <code>null</code>.
	 *
	 * @param constrainableType
	 *            the constrainable type
	 * @return the base primitive type or <code>null</code> if type not primitive
	 */
	public static PrimitiveType getBasePrimitiveType(ConstrainableType constrainableType) {
		if (constrainableType instanceof PrimitiveProperty) {
			SingleValueType type = ((PrimitiveProperty) constrainableType).getType();
			if (type instanceof UserDefinedType) {
				return getBasePrimitiveType((UserDefinedType) type);
			} else if (type instanceof PrimitiveType) {
				return (PrimitiveType) type;
			}
		} else if (constrainableType instanceof PropertyRealization) {
			PropertyRealization includedProperty = (PropertyRealization) constrainableType;
			if (includedProperty.getBaseProperty() instanceof PrimitiveProperty) {
				return getBasePrimitiveType((PrimitiveProperty) includedProperty.getBaseProperty());
			}
		} else if (constrainableType instanceof UserDefinedType) {
			UserDefinedType userDefinedType = (UserDefinedType) constrainableType;
			if (!isCircularBaseTypeReference(userDefinedType)) {
				SimpleType type = userDefinedType.getBaseType();
				while (type != null && type instanceof UserDefinedType) {
					type = ((UserDefinedType) type).getBaseType();
				}
				if (type instanceof PrimitiveType) {
					return (PrimitiveType) type;
				}
			}
		}
		return null;
	}

	public static boolean isCircularBaseTypeReference(UserDefinedType userDefinedType) {
		SimpleType baseType = userDefinedType.getBaseType();
		while (baseType instanceof UserDefinedType) {
			if (baseType == userDefinedType) {
				return true;
			}
			baseType = ((UserDefinedType) baseType).getBaseType();
		}
		return false;
	}
}
