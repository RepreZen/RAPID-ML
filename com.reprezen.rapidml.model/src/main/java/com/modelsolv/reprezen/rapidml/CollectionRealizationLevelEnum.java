/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Collection Realization Level Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionRealizationLevelEnum()
 * @model
 * @generated
 */
public enum CollectionRealizationLevelEnum implements Enumerator {
	/**
	 * The '<em><b>ITEM LEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITEM_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	ITEM_LEVEL(0, "ITEM_LEVEL", "itemLevel"),

	/**
	 * The '<em><b>COLLECTION LEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLECTION_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	COLLECTION_LEVEL(0, "COLLECTION_LEVEL", "CollectionLevel");

	/**
	 * The '<em><b>ITEM LEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITEM LEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ITEM_LEVEL
	 * @model literal="itemLevel"
	 * @generated
	 * @ordered
	 */
	public static final int ITEM_LEVEL_VALUE = 0;

	/**
	 * The '<em><b>COLLECTION LEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLLECTION LEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLLECTION_LEVEL
	 * @model literal="CollectionLevel"
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_LEVEL_VALUE = 0;

	/**
	 * An array of all the '<em><b>Collection Realization Level Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollectionRealizationLevelEnum[] VALUES_ARRAY =
		new CollectionRealizationLevelEnum[] {
			ITEM_LEVEL,
			COLLECTION_LEVEL,
		};

	/**
	 * A public read-only list of all the '<em><b>Collection Realization Level Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CollectionRealizationLevelEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Realization Level Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CollectionRealizationLevelEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionRealizationLevelEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Realization Level Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CollectionRealizationLevelEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionRealizationLevelEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Realization Level Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CollectionRealizationLevelEnum get(int value) {
		switch (value) {
			case ITEM_LEVEL_VALUE: return ITEM_LEVEL;
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
	private CollectionRealizationLevelEnum(int value, String name, String literal) {
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
	
} //CollectionRealizationLevelEnum
