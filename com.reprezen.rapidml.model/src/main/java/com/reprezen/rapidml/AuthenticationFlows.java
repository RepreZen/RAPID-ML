/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Authentication Flows</b></em>', and utility methods for working with
 * them. <!-- end-user-doc -->
 * 
 * @see com.reprezen.rapidml.RapidmlPackage#getAuthenticationFlows()
 * @model
 * @generated
 */
public enum AuthenticationFlows implements Enumerator {
	/**
	 * The '<em><b>IMPLICIT</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #IMPLICIT_VALUE
	 * @generated
	 * @ordered
	 */
	IMPLICIT(0, "IMPLICIT", "Implicit"),

	/**
	 * The '<em><b>PASSWORD</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #PASSWORD_VALUE
	 * @generated
	 * @ordered
	 */
	PASSWORD(1, "PASSWORD", "Password"),

	/**
	 * The '<em><b>APPLICATION</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #APPLICATION_VALUE
	 * @generated
	 * @ordered
	 */
	APPLICATION(2, "APPLICATION", "Application"),

	/**
	 * The '<em><b>ACCESS CODE</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #ACCESS_CODE_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESS_CODE(3, "ACCESS_CODE", "AccessCode");

	/**
	 * The '<em><b>IMPLICIT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPLICIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #IMPLICIT
	 * @model literal="Implicit"
	 * @generated
	 * @ordered
	 */
	public static final int IMPLICIT_VALUE = 0;

	/**
	 * The '<em><b>PASSWORD</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PASSWORD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PASSWORD
	 * @model literal="Password"
	 * @generated
	 * @ordered
	 */
	public static final int PASSWORD_VALUE = 1;

	/**
	 * The '<em><b>APPLICATION</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>APPLICATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #APPLICATION
	 * @model literal="Application"
	 * @generated
	 * @ordered
	 */
	public static final int APPLICATION_VALUE = 2;

	/**
	 * The '<em><b>ACCESS CODE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCESS CODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ACCESS_CODE
	 * @model literal="AccessCode"
	 * @generated
	 * @ordered
	 */
	public static final int ACCESS_CODE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Authentication Flows</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final AuthenticationFlows[] VALUES_ARRAY = new AuthenticationFlows[] { IMPLICIT, PASSWORD,
			APPLICATION, ACCESS_CODE, };

	/**
	 * A public read-only list of all the '<em><b>Authentication Flows</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<AuthenticationFlows> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Authentication Flows</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AuthenticationFlows get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AuthenticationFlows result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Authentication Flows</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AuthenticationFlows getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AuthenticationFlows result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Authentication Flows</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AuthenticationFlows get(int value) {
		switch (value) {
		case IMPLICIT_VALUE:
			return IMPLICIT;
		case PASSWORD_VALUE:
			return PASSWORD;
		case APPLICATION_VALUE:
			return APPLICATION;
		case ACCESS_CODE_VALUE:
			return ACCESS_CODE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private AuthenticationFlows(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // AuthenticationFlows
