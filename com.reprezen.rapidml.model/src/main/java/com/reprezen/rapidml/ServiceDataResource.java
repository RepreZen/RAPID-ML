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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Service
 * Data Resource</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ServiceDataResource#isDefault
 * <em>Default</em>}</li>
 * <li>{@link com.reprezen.rapidml.ServiceDataResource#getDefinedLinkDescriptors
 * <em>Defined Link Descriptors</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getServiceDataResource()
 * @model
 * @generated
 */
public interface ServiceDataResource extends RealizationContainer, ResourceDefinition {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getServiceDataResource_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ServiceDataResource#isDefault <em>Default</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Defined Link Descriptors</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link com.reprezen.rapidml.NamedLinkDescriptor}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Link Descriptors</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Defined Link Descriptors</em>' containment
	 *         reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getServiceDataResource_DefinedLinkDescriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedLinkDescriptor> getDefinedLinkDescriptors();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='return
	 *        com.reprezen.rapidml.util.RapidmlModelUtils.getDefaultLinkDescriptor(this);'"
	 * @generated
	 */
	NamedLinkDescriptor getDefaultLinkDescriptor();

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
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='Collection&lt;ReferenceLink&gt; referenceTreatments =
	 *        Lists.newArrayList(Iterables.filter(getReferenceTreatments(),
	 *        ReferenceLink.class));\nreturn new
	 *        BasicEList&lt;ReferenceLink&gt;(referenceTreatments);'"
	 * @generated
	 */
	EList<ReferenceLink> getReferenceLinks();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Return
	 * all nested reference treatments, this includes directly contained reference
	 * treatments and reference treatments transitively contained by nested
	 * (directly and transitively) reference embeds,
	 * 
	 * For example, for a service data resource containing
	 * 
	 * <pre>
	 *  <code>
	 * referenceEmbed > Orders {
	 * 	referenceEmbed > LineItems {
	 * 		referenceLink > Product {
	 * 			targetResource ProductObject
	 * 		}
	 * 	}
	 *  } 
	 * </code>
	 * </pre>
	 * 
	 * the result will be [referenceEmbed >Orders, referenceEmbed >LineItems,
	 * referenceLink > Product] <!-- end-model-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='List&lt;ReferenceTreatment&gt; allReferenceTreatments =
	 *        Lists.newArrayList(getReferenceTreatments());\nIterable&lt;ReferenceEmbed&gt;
	 *        referenceEmbeds = Iterables.filter(allReferenceTreatments,
	 *        ReferenceEmbed.class);\nIterable&lt;List&lt;ReferenceTreatment&gt;&gt;
	 *        nestedReferenceTreatmentsAsList =
	 *        Iterables.transform(referenceEmbeds,\n new Function&lt;ReferenceEmbed,
	 *        List&lt;ReferenceTreatment&gt;&gt;() {\n\n @Override\n public
	 *        List&lt;ReferenceTreatment&gt; apply(ReferenceEmbed input) {\n return
	 *        input.getAllNestedReferenceTreatments();\n }\n
	 *        });\nIterable&lt;ReferenceTreatment&gt; flatNestedReferenceTreatments
	 *        =
	 *        Iterables.concat(nestedReferenceTreatmentsAsList);\nallReferenceTreatments.addAll(Lists.newArrayList(flatNestedReferenceTreatments));\nreturn
	 *        ECollections.unmodifiableEList(allReferenceTreatments);'"
	 * @generated
	 */
	EList<ReferenceTreatment> getAllReferenceTreatments();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	EList<PropertyRealization> getIncludedProperties();

} // ServiceDataResource
