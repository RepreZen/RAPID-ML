/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.ReferenceLink#getName <em>Name</em>}</li>
 *   <li>{@link com.reprezen.rapidml.ReferenceLink#getLinkRelation <em>Link Relation</em>}</li>
 *   <li>{@link com.reprezen.rapidml.ReferenceLink#getCollectionRealizationLevel <em>Collection Realization Level</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceLink()
 * @model
 * @generated
 */
public interface ReferenceLink extends ReferenceTreatment {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceLink_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceLink#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Link Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Relation</em>' reference.
	 * @see #setLinkRelation(LinkRelation)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceLink_LinkRelation()
	 * @model
	 * @generated
	 */
	LinkRelation getLinkRelation();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceLink#getLinkRelation <em>Link Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Relation</em>' reference.
	 * @see #getLinkRelation()
	 * @generated
	 */
	void setLinkRelation(LinkRelation value);

	/**
	 * Returns the value of the '<em><b>Collection Realization Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Realization Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Realization Level</em>' attribute.
	 * @see #setCollectionRealizationLevel(CollectionRealizationLevelEnum)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceLink_CollectionRealizationLevel()
	 * @model dataType="com.reprezen.rapidml.CollectionRealizationLevelObject"
	 * @generated
	 */
	CollectionRealizationLevelEnum getCollectionRealizationLevel();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceLink#getCollectionRealizationLevel <em>Collection Realization Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Realization Level</em>' attribute.
	 * @see #getCollectionRealizationLevel()
	 * @generated
	 */
	void setCollectionRealizationLevel(CollectionRealizationLevelEnum value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ResourceDefinition getTargetResource();

} // ReferenceLink
