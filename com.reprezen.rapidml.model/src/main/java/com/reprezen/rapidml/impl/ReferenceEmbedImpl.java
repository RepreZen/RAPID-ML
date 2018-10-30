/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
/**
 */
package com.reprezen.rapidml.impl;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Embed</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ReferenceEmbedImpl extends ReferenceTreatmentImpl implements ReferenceEmbed {
    
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ReferenceEmbedImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.REFERENCE_EMBED;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ReferenceTreatment> getAllNestedReferenceTreatments() {
		if (getReferenceRealization() == null) {
		    return ECollections.emptyEList();
		}
		List<ReferenceTreatment> allReferenceTreatments = Lists.newArrayList(getReferenceRealization().getReferenceTreatments());
		Iterable<ReferenceEmbed> referenceEmbeds = Iterables.filter(allReferenceTreatments, ReferenceEmbed.class);
		Iterable<List<ReferenceTreatment>> nestedReferenceTreatmentsAsList = Iterables.transform(referenceEmbeds,
		        new Function<ReferenceEmbed, List<ReferenceTreatment>>() {
		
		            @Override
		            public List<ReferenceTreatment> apply(ReferenceEmbed input) {
		                return input.getAllNestedReferenceTreatments();
		            }
		        });
		Iterable<ReferenceTreatment> flatNestedReferenceTreatments = Iterables.concat(nestedReferenceTreatmentsAsList);
		allReferenceTreatments.addAll(Lists.newArrayList(flatNestedReferenceTreatments));
		return ECollections.unmodifiableEList(allReferenceTreatments);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ReferenceTreatment> getNestedReferenceTreatments() {
		if (getReferenceRealization() == null) {
		    return ECollections.emptyEList();
		}
		return getReferenceRealization().getReferenceTreatments();
	}
} // ReferenceEmbedImpl
