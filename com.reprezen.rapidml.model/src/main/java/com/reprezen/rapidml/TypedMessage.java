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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Typed
 * Message</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.TypedMessage#getParameters
 * <em>Parameters</em>}</li>
 * <li>{@link com.reprezen.rapidml.TypedMessage#getResourceType <em>Resource
 * Type</em>}</li>
 * <li>{@link com.reprezen.rapidml.TypedMessage#isUseParentTypeReference <em>Use
 * Parent Type Reference</em>}</li>
 * <li>{@link com.reprezen.rapidml.TypedMessage#getMediaTypes <em>Media
 * Types</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getTypedMessage()
 * @model abstract="true"
 * @generated
 */
public interface TypedMessage extends RealizationContainer, RESTElement, WithExamples {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.reprezen.rapidml.MessageParameter}. It is bidirectional and its
	 * opposite is
	 * '{@link com.reprezen.rapidml.MessageParameter#getContainingMessage
	 * <em>Containing Message</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedMessage_Parameters()
	 * @see com.reprezen.rapidml.MessageParameter#getContainingMessage
	 * @model opposite="containingMessage" containment="true"
	 * @generated
	 */
	EList<MessageParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Resource Type</em>' reference.
	 * @see #setResourceType(ResourceDefinition)
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedMessage_ResourceType()
	 * @model
	 * @generated
	 */
	ResourceDefinition getResourceType();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.TypedMessage#getResourceType <em>Resource
	 * Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Resource Type</em>' reference.
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(ResourceDefinition value);

	/**
	 * Returns the value of the '<em><b>Use Parent Type Reference</b></em>'
	 * attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Parent Type Reference</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use Parent Type Reference</em>' attribute.
	 * @see #setUseParentTypeReference(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedMessage_UseParentTypeReference()
	 * @model
	 * @generated
	 */
	boolean isUseParentTypeReference();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.TypedMessage#isUseParentTypeReference <em>Use
	 * Parent Type Reference</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Use Parent Type Reference</em>'
	 *            attribute.
	 * @see #isUseParentTypeReference()
	 * @generated
	 */
	void setUseParentTypeReference(boolean value);

	/**
	 * Returns the value of the '<em><b>Media Types</b></em>' reference list. The
	 * list contents are of type {@link com.reprezen.rapidml.MediaType}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Media Types</em>' reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedMessage_MediaTypes()
	 * @model
	 * @generated
	 */
	EList<MediaType> getMediaTypes();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='return
	 *        com.reprezen.rapidml.util.ExampleUtils.getAllExamples(this);'"
	 * @generated
	 */
	EList<Example> getAllExamples();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return
	 *        com.reprezen.rapidml.util.RapidmlModelUtils.isFeatureIncluded(this,
	 *        feature);'"
	 * @generated
	 */
	boolean isIncluded(com.reprezen.rapidml.Feature feature);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	EList<PropertyRealization> getIncludedProperties();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='Structure structure = getDataType();\nif (structure == null
	 *        &amp;&amp; getResourceType() instanceof
	 *        com.reprezen.rapidml.ServiceDataResource) {\n structure =
	 *        ((com.reprezen.rapidml.ServiceDataResource)
	 *        getResourceType()).getDataType();\n}\nreturn structure;\r\n'"
	 * @generated
	 */
	com.reprezen.rapidml.Structure getActualType();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='Collection&lt;ReferenceLink&gt; referenceTreatments =
	 *        com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getReferenceTreatments(),
	 *        ReferenceLink.class));\r\nreturn new
	 *        org.eclipse.emf.common.util.BasicEList&lt;ReferenceLink&gt;(referenceTreatments);'"
	 * @generated
	 */
	EList<ReferenceLink> getReferenceLinks();

} // TypedMessage
