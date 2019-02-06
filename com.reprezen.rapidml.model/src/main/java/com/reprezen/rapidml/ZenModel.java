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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Zen
 * Model</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ZenModel#getName <em>Name</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getNamespace
 * <em>Namespace</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getResourceAPIs <em>Resource AP
 * Is</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getDataModels <em>Data
 * Models</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getMediaTypesLibrary <em>Media Types
 * Library</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getLinkRelationsLibrary <em>Link
 * Relations Library</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getPrimitiveTypesLibrary
 * <em>Primitive Types Library</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getImports <em>Imports</em>}</li>
 * <li>{@link com.reprezen.rapidml.ZenModel#getSecuritySchemesLibrary
 * <em>Security Schemes Library</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel()
 * @model
 * @generated
 */
public interface ZenModel extends Documentable, Extensible, HasTitle {
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
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ZenModel#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ZenModel#getNamespace
	 * <em>Namespace</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Resource AP Is</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link com.reprezen.rapidml.ResourceAPI}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource AP Is</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Resource AP Is</em>' containment reference
	 *         list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_ResourceAPIs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceAPI> getResourceAPIs();

	/**
	 * Returns the value of the '<em><b>Data Models</b></em>' containment reference
	 * list. The list contents are of type {@link com.reprezen.rapidml.DataModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Models</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Data Models</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_DataModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<com.reprezen.rapidml.DataModel> getDataModels();

	/**
	 * Returns the value of the '<em><b>Media Types Library</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media Types Library</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Media Types Library</em>' containment
	 *         reference.
	 * @see #setMediaTypesLibrary(com.reprezen.rapidml.MediaTypesLibrary)
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_MediaTypesLibrary()
	 * @model containment="true"
	 * @generated
	 */
	com.reprezen.rapidml.MediaTypesLibrary getMediaTypesLibrary();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ZenModel#getMediaTypesLibrary <em>Media Types
	 * Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Media Types Library</em>' containment
	 *            reference.
	 * @see #getMediaTypesLibrary()
	 * @generated
	 */
	void setMediaTypesLibrary(com.reprezen.rapidml.MediaTypesLibrary value);

	/**
	 * Returns the value of the '<em><b>Link Relations Library</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Relations Library</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Relations Library</em>' containment
	 *         reference.
	 * @see #setLinkRelationsLibrary(com.reprezen.rapidml.LinkRelationsLibrary)
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_LinkRelationsLibrary()
	 * @model containment="true"
	 * @generated
	 */
	com.reprezen.rapidml.LinkRelationsLibrary getLinkRelationsLibrary();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ZenModel#getLinkRelationsLibrary <em>Link
	 * Relations Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Link Relations Library</em>' containment
	 *            reference.
	 * @see #getLinkRelationsLibrary()
	 * @generated
	 */
	void setLinkRelationsLibrary(com.reprezen.rapidml.LinkRelationsLibrary value);

	/**
	 * Returns the value of the '<em><b>Primitive Types Library</b></em>'
	 * containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Types Library</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Primitive Types Library</em>' containment
	 *         reference.
	 * @see #setPrimitiveTypesLibrary(com.reprezen.rapidml.PrimitiveTypesLibrary)
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_PrimitiveTypesLibrary()
	 * @model containment="true"
	 * @generated
	 */
	com.reprezen.rapidml.PrimitiveTypesLibrary getPrimitiveTypesLibrary();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ZenModel#getPrimitiveTypesLibrary <em>Primitive
	 * Types Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Primitive Types Library</em>'
	 *            containment reference.
	 * @see #getPrimitiveTypesLibrary()
	 * @generated
	 */
	void setPrimitiveTypesLibrary(com.reprezen.rapidml.PrimitiveTypesLibrary value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.reprezen.rapidml.ImportDeclaration}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportDeclaration> getImports();

	/**
	 * Returns the value of the '<em><b>Security Schemes Library</b></em>'
	 * containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Schemes Library</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Security Schemes Library</em>' containment
	 *         reference.
	 * @see #setSecuritySchemesLibrary(SecuritySchemeLibrary)
	 * @see com.reprezen.rapidml.RapidmlPackage#getZenModel_SecuritySchemesLibrary()
	 * @model containment="true"
	 * @generated
	 */
	SecuritySchemeLibrary getSecuritySchemesLibrary();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ZenModel#getSecuritySchemesLibrary <em>Security
	 * Schemes Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Security Schemes Library</em>'
	 *            containment reference.
	 * @see #getSecuritySchemesLibrary()
	 * @generated
	 */
	void setSecuritySchemesLibrary(SecuritySchemeLibrary value);

} // ZenModel
