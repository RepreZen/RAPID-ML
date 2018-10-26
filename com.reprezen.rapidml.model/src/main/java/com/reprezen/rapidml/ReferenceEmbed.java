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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Embed</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceEmbed()
 * @model
 * @generated
 */
public interface ReferenceEmbed extends ReferenceTreatment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return all nested reference treatments, 
	 * this includes directly contained reference treatments and reference treatments transitively contained by nested (directly and transitively) reference embeds,
	 * 
	 * For example, for "referenceEmbed > Orders" from 
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
	 * the result will be - [referenceEmbed >LineItems, referenceLink > Product]
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getReferenceRealization() == null) {\n    return ECollections.emptyEList();\n}\nList&lt;ReferenceTreatment&gt; allReferenceTreatments = Lists.newArrayList(getReferenceRealization().getReferenceTreatments());\nIterable&lt;ReferenceEmbed&gt; referenceEmbeds = Iterables.filter(allReferenceTreatments, ReferenceEmbed.class);\nIterable&lt;List&lt;ReferenceTreatment&gt;&gt; nestedReferenceTreatmentsAsList = Iterables.transform(referenceEmbeds,\n        new Function&lt;ReferenceEmbed, List&lt;ReferenceTreatment&gt;&gt;() {\n\n            @Override\n            public List&lt;ReferenceTreatment&gt; apply(ReferenceEmbed input) {\n                return input.getAllNestedReferenceTreatments();\n            }\n        });\nIterable&lt;ReferenceTreatment&gt; flatNestedReferenceTreatments = Iterables.concat(nestedReferenceTreatmentsAsList);\nallReferenceTreatments.addAll(Lists.newArrayList(flatNestedReferenceTreatments));\nreturn ECollections.unmodifiableEList(allReferenceTreatments);'"
	 * @generated
	 */
	EList<ReferenceTreatment> getAllNestedReferenceTreatments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getReferenceRealization() == null) {\n    return ECollections.emptyEList();\n}\nreturn getReferenceRealization().getReferenceTreatments();'"
	 * @generated
	 */
	EList<ReferenceTreatment> getNestedReferenceTreatments();

} // ReferenceEmbed
