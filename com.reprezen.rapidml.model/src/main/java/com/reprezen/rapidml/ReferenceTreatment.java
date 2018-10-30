/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

import com.reprezen.rapidml.ReferenceElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Treatment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.ReferenceTreatment#getReferenceElement <em>Reference Element</em>}</li>
 *   <li>{@link com.reprezen.rapidml.ReferenceTreatment#getReferenceRealization <em>Reference Realization</em>}</li>
 *   <li>{@link com.reprezen.rapidml.ReferenceTreatment#getOwnedReferenceRealization <em>Owned Reference Realization</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceTreatment()
 * @model
 * @generated
 */
public interface ReferenceTreatment extends Extensible {
	/**
	 * Returns the value of the '<em><b>Reference Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Element</em>' reference.
	 * @see #setReferenceElement(com.reprezen.rapidml.ReferenceElement)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceTreatment_ReferenceElement()
	 * @model
	 * @generated
	 */
	com.reprezen.rapidml.ReferenceElement getReferenceElement();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceTreatment#getReferenceElement <em>Reference Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Element</em>' reference.
	 * @see #getReferenceElement()
	 * @generated
	 */
	void setReferenceElement(com.reprezen.rapidml.ReferenceElement value);

	/**
	 * Returns the value of the '<em><b>Reference Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Realization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Realization</em>' reference.
	 * @see #setReferenceRealization(ReferenceRealization)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceTreatment_ReferenceRealization()
	 * @model
	 * @generated
	 */
	ReferenceRealization getReferenceRealization();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceTreatment#getReferenceRealization <em>Reference Realization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Realization</em>' reference.
	 * @see #getReferenceRealization()
	 * @generated
	 */
	void setReferenceRealization(ReferenceRealization value);

	/**
	 * Returns the value of the '<em><b>Owned Reference Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Reference Realization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Reference Realization</em>' containment reference.
	 * @see #setOwnedReferenceRealization(ReferenceRealization)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceTreatment_OwnedReferenceRealization()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceRealization getOwnedReferenceRealization();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceTreatment#getOwnedReferenceRealization <em>Owned Reference Realization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Reference Realization</em>' containment reference.
	 * @see #getOwnedReferenceRealization()
	 * @generated
	 */
	void setOwnedReferenceRealization(ReferenceRealization value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Containment hierarchy of a reference treatment includes all containing reference embeds. 
	 * For example, for "referenceLink > Product " from 
	 * <pre> <code>
	 * referenceEmbed > Orders {
	 * 	referenceEmbed > LineItems {
	 * 		referenceLink > Product {
	 * 			targetResource ProductObject
	 * 		}
	 * 	}
	 *  } 
	 * </code> </pre>
	 * 
	 * the embed hierarchy will consist of two reference embeds - [>Orders, >LineItems]
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EObject container = eContainer();\nif (container instanceof ReferenceRealization) {\n    // use containers of the parent ReferenceRealization\n    container = container.eContainer();\n}\nif (container instanceof ReferenceEmbed) {\n    ReferenceEmbed parentEmbed = (ReferenceEmbed)container;\n    List&lt;ReferenceEmbed&gt; hierarchy = Lists.newArrayList(parentEmbed.getEmbedHierarchy());\n    hierarchy.add(parentEmbed);\n    return ECollections.unmodifiableEList(hierarchy);\n}\nreturn ECollections.emptyEList();'"
	 * @generated
	 */
	EList<ReferenceEmbed> getEmbedHierarchy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ObjectRealization getLinkDescriptor();

} // ReferenceTreatment
