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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Object
 * Realization</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ObjectRealization#getExclusivePropertyList
 * <em>Exclusive Property List</em>}</li>
 * <li>{@link com.reprezen.rapidml.ObjectRealization#getOverriddenPropertyList
 * <em>Overridden Property List</em>}</li>
 * <li>{@link com.reprezen.rapidml.ObjectRealization#getExcludedProperties
 * <em>Excluded Properties</em>}</li>
 * <li>{@link com.reprezen.rapidml.ObjectRealization#getRealizationContainer
 * <em>Realization Container</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getObjectRealization()
 * @model
 * @generated
 */
public interface ObjectRealization extends Extensible {
	/**
	 * Returns the value of the '<em><b>Exclusive Property List</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link com.reprezen.rapidml.PropertyRealization}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive Property List</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exclusive Property List</em>' containment
	 *         reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getObjectRealization_ExclusivePropertyList()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyRealization> getExclusivePropertyList();

	/**
	 * Returns the value of the '<em><b>Overridden Property List</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link com.reprezen.rapidml.PropertyRealization}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden Property List</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Overridden Property List</em>' containment
	 *         reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getObjectRealization_OverriddenPropertyList()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyRealization> getOverriddenPropertyList();

	/**
	 * Returns the value of the '<em><b>Excluded Properties</b></em>' reference
	 * list. The list contents are of type {@link com.reprezen.rapidml.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Properties</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Excluded Properties</em>' reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getObjectRealization_ExcludedProperties()
	 * @model
	 * @generated
	 */
	EList<com.reprezen.rapidml.Feature> getExcludedProperties();

	/**
	 * Returns the value of the '<em><b>Realization Container</b></em>' container
	 * reference. It is bidirectional and its opposite is
	 * '{@link com.reprezen.rapidml.RealizationContainer#getInlineObjectRealization
	 * <em>Inline Object Realization</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realization Container</em>' container reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Realization Container</em>' container
	 *         reference.
	 * @see #setRealizationContainer(RealizationContainer)
	 * @see com.reprezen.rapidml.RapidmlPackage#getObjectRealization_RealizationContainer()
	 * @see com.reprezen.rapidml.RealizationContainer#getInlineObjectRealization
	 * @model opposite="inlineObjectRealization"
	 * @generated
	 */
	RealizationContainer getRealizationContainer();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ObjectRealization#getRealizationContainer
	 * <em>Realization Container</em>}' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Realization Container</em>' container
	 *            reference.
	 * @see #getRealizationContainer()
	 * @generated
	 */
	void setRealizationContainer(RealizationContainer value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='if (eContainer() instanceof ServiceDataResource) {\n return
	 *        ((ServiceDataResource) eContainer()).getDataType();\n}\nif
	 *        (eContainer() instanceof TypedMessage) {\n return ((TypedMessage)
	 *        eContainer()).getActualType();\n}\nif (eContainer() instanceof
	 *        ReferenceRealization) {\n ReferenceRealization realization =
	 *        (ReferenceRealization) eContainer();\n ReferenceTreatment treatment =
	 *        realization != null ? (ReferenceTreatment) realization.eContainer() :
	 *        null;\n \n return treatment != null ?
	 *        treatment.getReferenceElement().getDataType() : null;\n}\nif
	 *        (eContainer() instanceof ReferenceTreatment) {\n return
	 *        ((ReferenceTreatment)
	 *        eContainer()).getReferenceElement().getDataType();\n}\nreturn null;'"
	 * @generated
	 */
	com.reprezen.rapidml.Structure getDataType();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='EList&lt;PropertyRealization&gt; allIncludedProperties = new
	 *        org.eclipse.emf.common.util.BasicEList&lt;PropertyRealization&gt;();\n\nRealizationContainer
	 *        container = getRealizationContainer();\nif (container instanceof
	 *        ReferenceRealization) {\n\tReferenceRealization referenceRealization =
	 *        (ReferenceRealization) container;\n\tStructure dataType =
	 *        referenceRealization.getDataType();\n\n\tif
	 *        (!getExclusivePropertyList().isEmpty())
	 *        {\n\t\tallIncludedProperties.addAll(getExclusivePropertyList());\n\t}\n\n\tif
	 *        (referenceRealization.getRealizationType() ==
	 *        com.reprezen.rapidml.ReferenceRealizationEnum.EMBED) {\n\t\tif
	 *        (dataType != null) {\n\t\t\tfor (final Feature feature :
	 *        dataType.getOwnedFeatures()) {\n\t\t\t\tPropertyRealization
	 *        includedProperty =
	 *        com.reprezen.rapidml.RapidmlFactory.eINSTANCE.createPropertyRealization();\n\t\t\t\tincludedProperty.setBaseProperty(feature);\n\t\t\t\tallIncludedProperties.add(includedProperty);\n\t\t\t}\n\t\t}\n\t}\n\treturn
	 *        allIncludedProperties;\n}\n\nif
	 *        (!getExclusivePropertyList().isEmpty())
	 *        {\n\tallIncludedProperties.addAll(getExclusivePropertyList());\n\treturn
	 *        allIncludedProperties;\n}\n\nStructure dataType = getDataType();\nif
	 *        (dataType == null) {\n\treturn allIncludedProperties;\n}\n\nfor (final
	 *        Feature feature : dataType.getOwnedFeatures()) {\n\tboolean isExcluded
	 *        =
	 *        !com.google.common.collect.Collections2\n\t\t.filter(getExcludedProperties(),
	 *        new com.google.common.base.Predicate&lt;Feature&gt;()
	 *        {\n\t\t\t@Override\n\t\t\tpublic boolean apply(Feature input)
	 *        {\n\t\t\t\treturn
	 *        com.reprezen.rapidml.util.InheritanceUtils.sameOrOverrides(input,
	 *        feature);\n\t\t\t}\n\t\t}).isEmpty();\n\n\tif (isExcluded)
	 *        {\n\t\tcontinue;\n\t}\n\n\tCollection&lt;PropertyRealization&gt;
	 *        overridden =
	 *        com.google.common.collect.Collections2.filter(\n\t\tgetOverriddenPropertyList(),\n\t\tnew
	 *        com.google.common.base.Predicate&lt;PropertyRealization&gt;()
	 *        {\n\t\t\t@Override\n\t\t\tpublic boolean apply(PropertyRealization
	 *        input) {\n\t\t\t\treturn
	 *        com.reprezen.rapidml.util.InheritanceUtils.sameOrOverrides(input.getBaseProperty(),
	 *        feature);\n\t\t\t}\n\t\t});\n\n\tif (!overridden.isEmpty())
	 *        {\n\t\tallIncludedProperties.add(com.google.common.collect.Iterables.getFirst(overridden,
	 *        null));\n\t} else {\n\t\tPropertyRealization includedProperty =
	 *        com.reprezen.rapidml.RapidmlFactory.eINSTANCE.createPropertyRealization();\n\t\tincludedProperty.setBaseProperty(feature);\n\t\tallIncludedProperties.add(includedProperty);\n\t}\n}\nreturn
	 *        allIncludedProperties;'"
	 * @generated
	 */
	EList<PropertyRealization> getAllIncludedProperties();

} // ObjectRealization
