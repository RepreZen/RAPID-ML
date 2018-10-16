/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import com.modelsolv.reprezen.restapi.DataModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource API</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getVersion <em>Version</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getBaseURI <em>Base URI</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getOwnedResourceDefinitions <em>Owned Resource Definitions</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getServiceDataModels <em>Service Data Models</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getFormats <em>Formats</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getDefinedMediaTypes <em>Defined Media Types</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getDefinedLinkRelations <em>Defined Link Relations</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getDefaultReferenceRealizations <em>Default Reference Realizations</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ResourceAPI#getAutoRealizations <em>Auto Realizations</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI()
 * @model
 * @generated
 */
public interface ResourceAPI extends RESTElement, HasSecurityValue, HasTitle {
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
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Base URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base URI</em>' attribute.
	 * @see #setBaseURI(String)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_BaseURI()
	 * @model
	 * @generated
	 */
	String getBaseURI();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getBaseURI <em>Base URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base URI</em>' attribute.
	 * @see #getBaseURI()
	 * @generated
	 */
	void setBaseURI(String value);

	/**
	 * Returns the value of the '<em><b>Owned Resource Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.ResourceDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Resource Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Resource Definitions</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_OwnedResourceDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceDefinition> getOwnedResourceDefinitions();

	/**
	 * Returns the value of the '<em><b>Service Data Models</b></em>' reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.DataModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Data Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Data Models</em>' reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_ServiceDataModels()
	 * @model
	 * @generated
	 */
	EList<com.modelsolv.reprezen.restapi.DataModel> getServiceDataModels();

	/**
	 * Returns the value of the '<em><b>Formats</b></em>' reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formats</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formats</em>' reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_Formats()
	 * @model
	 * @generated
	 */
	EList<MediaType> getFormats();

	/**
	 * Returns the value of the '<em><b>Defined Media Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Media Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Media Types</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_DefinedMediaTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<MediaType> getDefinedMediaTypes();

	/**
	 * Returns the value of the '<em><b>Defined Link Relations</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.LinkRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Link Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Link Relations</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_DefinedLinkRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkRelation> getDefinedLinkRelations();

	/**
	 * Returns the value of the '<em><b>Default Reference Realizations</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.ReferenceRealization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Reference Realizations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Reference Realizations</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_DefaultReferenceRealizations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceRealization> getDefaultReferenceRealizations();

	/**
	 * Returns the value of the '<em><b>Auto Realizations</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.RealizationModelLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Realizations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Realizations</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getResourceAPI_AutoRealizations()
	 * @model containment="true"
	 * @generated
	 */
	EList<RealizationModelLocation> getAutoRealizations();

} // ResourceAPI
