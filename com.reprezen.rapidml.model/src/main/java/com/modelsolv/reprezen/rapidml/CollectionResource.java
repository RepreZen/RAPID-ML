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
 * A representation of the model object '<em><b>Collection Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.CollectionResource#getCollectionParameters <em>Collection Parameters</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.CollectionResource#getReferenceElements <em>Reference Elements</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.CollectionResource#getResourceRealizationKind <em>Resource Realization Kind</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionResource()
 * @model
 * @generated
 */
public interface CollectionResource extends ServiceDataResource {
	/**
	 * Returns the value of the '<em><b>Collection Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.CollectionParameter}.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.CollectionParameter#getContainingResourceDefinition <em>Containing Resource Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Parameters</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionResource_CollectionParameters()
	 * @see com.modelsolv.reprezen.rapidml.CollectionParameter#getContainingResourceDefinition
	 * @model opposite="containingResourceDefinition" containment="true"
	 * @generated
	 */
	EList<CollectionParameter> getCollectionParameters();

	/**
	 * Returns the value of the '<em><b>Reference Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.CollectionReferenceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Elements</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionResource_ReferenceElements()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<CollectionReferenceElement> getReferenceElements();

	/**
	 * Returns the value of the '<em><b>Resource Realization Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.modelsolv.reprezen.rapidml.CollectionRealizationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Realization Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Realization Kind</em>' attribute.
	 * @see com.modelsolv.reprezen.rapidml.CollectionRealizationEnum
	 * @see #setResourceRealizationKind(CollectionRealizationEnum)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionResource_ResourceRealizationKind()
	 * @model transient="true"
	 * @generated
	 */
	CollectionRealizationEnum getResourceRealizationKind();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.CollectionResource#getResourceRealizationKind <em>Resource Realization Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Realization Kind</em>' attribute.
	 * @see com.modelsolv.reprezen.rapidml.CollectionRealizationEnum
	 * @see #getResourceRealizationKind()
	 * @generated
	 */
	void setResourceRealizationKind(CollectionRealizationEnum value);

} // CollectionResource
