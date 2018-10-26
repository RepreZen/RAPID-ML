/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Structure#getOwnedFeatures <em>Owned Features</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Structure#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Structure#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Structure#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Structure#getAllSupertypes <em>All Supertypes</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getStructure()
 * @model
 * @generated
 */
public interface Structure extends DataType, WithDataExamples, Inheritable {
	/**
	 * Returns the value of the '<em><b>Owned Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.Feature}.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.Feature#getContainingDataType <em>Containing Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Features</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getStructure_OwnedFeatures()
	 * @see com.modelsolv.reprezen.rapidml.Feature#getContainingDataType
	 * @model opposite="containingDataType" containment="true"
	 * @generated
	 */
	EList<Feature> getOwnedFeatures();

	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.Structure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getStructure_OwnedElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Structure> getOwnedElements();

	/**
	 * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operations</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getStructure_OwnedOperations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOwnedOperations();

	/**
	 * Returns the value of the '<em><b>Supertypes</b></em>' reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.Inheritable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A structure extend one or more supertypes.
	 * An individual primitive property from a subtype can restrict a corresponding property from its super type by adding a constraint. It's handled by the tooling. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Supertypes</em>' reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getStructure_Supertypes()
	 * @model
	 * @generated
	 */
	EList<Inheritable> getSupertypes();

	/**
	 * Returns the value of the '<em><b>All Supertypes</b></em>' reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.Inheritable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Supertypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Supertypes</em>' reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getStructure_AllSupertypes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Inheritable> getAllSupertypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Collection&lt;ReferenceProperty&gt; referenceProperties = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getOwnedFeatures(), com.modelsolv.reprezen.rapidml.datatypes.ReferenceProperty.class));\nreturn new BasicEList&lt;ReferenceProperty&gt;(referenceProperties);\n'"
	 * @generated
	 */
	EList<ReferenceProperty> getReferenceProperties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Collection&lt;PrimitiveProperty&gt; primitiveProperties = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getOwnedFeatures(), com.modelsolv.reprezen.rapidml.datatypes. PrimitiveProperty.class));\nreturn new BasicEList&lt;PrimitiveProperty&gt;(primitiveProperties);\n'"
	 * @generated
	 */
	EList<PrimitiveProperty> getPrimitiveProperties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Collection&lt;PrimitiveProperty&gt; primitiveProperties = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getOwnedFeatures(), com.modelsolv.reprezen.rapidml.datatypes. PrimitiveProperty.class));\nreturn new BasicEList&lt;PrimitiveProperty&gt;(primitiveProperties);\n'"
	 * @generated
	 */
	EList<PrimitiveProperty> getAllPrimitiveProperties();

} // Structure
