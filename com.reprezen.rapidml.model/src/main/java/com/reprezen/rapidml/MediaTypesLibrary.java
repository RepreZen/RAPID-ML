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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Media
 * Types Library</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.MediaTypesLibrary#getMediaTypes <em>Media
 * Types</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getMediaTypesLibrary()
 * @model
 * @generated
 */
public interface MediaTypesLibrary extends EObject {
	/**
	 * Returns the value of the '<em><b>Media Types</b></em>' containment reference
	 * list. The list contents are of type {@link com.reprezen.rapidml.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media Types</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Media Types</em>' containment reference list.
	 * @see #isSetMediaTypes()
	 * @see #unsetMediaTypes()
	 * @see com.reprezen.rapidml.RapidmlPackage#getMediaTypesLibrary_MediaTypes()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<MediaType> getMediaTypes();

	/**
	 * Unsets the value of the
	 * '{@link com.reprezen.rapidml.MediaTypesLibrary#getMediaTypes <em>Media
	 * Types</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isSetMediaTypes()
	 * @see #getMediaTypes()
	 * @generated
	 */
	void unsetMediaTypes();

	/**
	 * Returns whether the value of the
	 * '{@link com.reprezen.rapidml.MediaTypesLibrary#getMediaTypes <em>Media
	 * Types</em>}' containment reference list is set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Media Types</em>' containment reference
	 *         list is set.
	 * @see #unsetMediaTypes()
	 * @see #getMediaTypes()
	 * @generated
	 */
	boolean isSetMediaTypes();

} // MediaTypesLibrary
