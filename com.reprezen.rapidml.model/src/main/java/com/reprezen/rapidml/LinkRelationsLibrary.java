/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Link
 * Relations Library</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.LinkRelationsLibrary#getDefinedLinkRelations
 * <em>Defined Link Relations</em>}</li>
 * <li>{@link com.reprezen.rapidml.LinkRelationsLibrary#getName
 * <em>Name</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getLinkRelationsLibrary()
 * @model
 * @generated
 */
public interface LinkRelationsLibrary extends EObject {
	/**
	 * Returns the value of the '<em><b>Defined Link Relations</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link com.reprezen.rapidml.LinkRelation}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Link Relations</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Defined Link Relations</em>' containment
	 *         reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getLinkRelationsLibrary_DefinedLinkRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkRelation> getDefinedLinkRelations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getLinkRelationsLibrary_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.LinkRelationsLibrary#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // LinkRelationsLibrary
