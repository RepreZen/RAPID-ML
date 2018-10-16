/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Collection Realization Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getCollectionRealizationEnum()
 * @model
 * @generated
 */
public enum CollectionRealizationEnum implements Enumerator {
	/**
	 * The '<em><b>EMBEDDED OBJECT LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMBEDDED_OBJECT_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	EMBEDDED_OBJECT_LIST(0, "EMBEDDED_OBJECT_LIST", "EMBEDDED_OBJECT_LIST"),

	/**
	 * The '<em><b>REFERENCE LINK LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_LINK_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE_LINK_LIST(1, "REFERENCE_LINK_LIST", "REFERENCE_LINK_LIST");

	/**
	 * The '<em><b>EMBEDDED OBJECT LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EMBEDDED OBJECT LIST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EMBEDDED_OBJECT_LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EMBEDDED_OBJECT_LIST_VALUE = 0;

	/**
	 * The '<em><b>REFERENCE LINK LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFERENCE LINK LIST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_LINK_LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_LINK_LIST_VALUE = 1;

	/**
	 * An array of all the '<em><b>Collection Realization Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollectionRealizationEnum[] VALUES_ARRAY =
		new CollectionRealizationEnum[] {
			EMBEDDED_OBJECT_LIST,
			REFERENCE_LINK_LIST,
		};

	/**
	 * A public read-only list of all the '<em><b>Collection Realization Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CollectionRealizationEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Realization Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CollectionRealizationEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionRealizationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Realization Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CollectionRealizationEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionRealizationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Realization Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CollectionRealizationEnum get(int value) {
		switch (value) {
			case EMBEDDED_OBJECT_LIST_VALUE: return EMBEDDED_OBJECT_LIST;
			case REFERENCE_LINK_LIST_VALUE: return REFERENCE_LINK_LIST;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CollectionRealizationEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CollectionRealizationEnum
