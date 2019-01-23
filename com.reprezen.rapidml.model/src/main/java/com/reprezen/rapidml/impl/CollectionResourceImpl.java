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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.CollectionParameter;
import com.reprezen.rapidml.CollectionRealizationEnum;
import com.reprezen.rapidml.CollectionReferenceElement;
import com.reprezen.rapidml.CollectionResource;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Collection Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.CollectionResourceImpl#getCollectionParameters
 * <em>Collection Parameters</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.CollectionResourceImpl#getReferenceElements
 * <em>Reference Elements</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.CollectionResourceImpl#getResourceRealizationKind
 * <em>Resource Realization Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionResourceImpl extends ServiceDataResourceImpl implements CollectionResource {
	/**
	 * The cached value of the '{@link #getCollectionParameters() <em>Collection
	 * Parameters</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCollectionParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionParameter> collectionParameters;

	/**
	 * The cached value of the '{@link #getReferenceElements() <em>Reference
	 * Elements</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getReferenceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionReferenceElement> referenceElements;

	/**
	 * The default value of the '{@link #getResourceRealizationKind() <em>Resource
	 * Realization Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getResourceRealizationKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionRealizationEnum RESOURCE_REALIZATION_KIND_EDEFAULT = CollectionRealizationEnum.EMBEDDED_OBJECT_LIST;

	/**
	 * The cached value of the '{@link #getResourceRealizationKind() <em>Resource
	 * Realization Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getResourceRealizationKind()
	 * @generated
	 * @ordered
	 */
	protected CollectionRealizationEnum resourceRealizationKind = RESOURCE_REALIZATION_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CollectionResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.COLLECTION_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<CollectionParameter> getCollectionParameters() {
		if (collectionParameters == null) {
			collectionParameters = new EObjectContainmentWithInverseEList<CollectionParameter>(
					CollectionParameter.class, this, RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS,
					RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION);
		}
		return collectionParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<CollectionReferenceElement> getReferenceElements() {
		if (referenceElements == null) {
			referenceElements = new EObjectContainmentEList<CollectionReferenceElement>(
					CollectionReferenceElement.class, this, RapidmlPackage.COLLECTION_RESOURCE__REFERENCE_ELEMENTS);
		}
		return referenceElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionRealizationEnum getResourceRealizationKind() {
		return resourceRealizationKind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setResourceRealizationKind(CollectionRealizationEnum newResourceRealizationKind) {
		CollectionRealizationEnum oldResourceRealizationKind = resourceRealizationKind;
		resourceRealizationKind = newResourceRealizationKind == null ? RESOURCE_REALIZATION_KIND_EDEFAULT
				: newResourceRealizationKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND, oldResourceRealizationKind,
					resourceRealizationKind));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCollectionParameters()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS:
			return ((InternalEList<?>) getCollectionParameters()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.COLLECTION_RESOURCE__REFERENCE_ELEMENTS:
			return ((InternalEList<?>) getReferenceElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS:
			return getCollectionParameters();
		case RapidmlPackage.COLLECTION_RESOURCE__REFERENCE_ELEMENTS:
			return getReferenceElements();
		case RapidmlPackage.COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND:
			return getResourceRealizationKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS:
			getCollectionParameters().clear();
			getCollectionParameters().addAll((Collection<? extends CollectionParameter>) newValue);
			return;
		case RapidmlPackage.COLLECTION_RESOURCE__REFERENCE_ELEMENTS:
			getReferenceElements().clear();
			getReferenceElements().addAll((Collection<? extends CollectionReferenceElement>) newValue);
			return;
		case RapidmlPackage.COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND:
			setResourceRealizationKind((CollectionRealizationEnum) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS:
			getCollectionParameters().clear();
			return;
		case RapidmlPackage.COLLECTION_RESOURCE__REFERENCE_ELEMENTS:
			getReferenceElements().clear();
			return;
		case RapidmlPackage.COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND:
			setResourceRealizationKind(RESOURCE_REALIZATION_KIND_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS:
			return collectionParameters != null && !collectionParameters.isEmpty();
		case RapidmlPackage.COLLECTION_RESOURCE__REFERENCE_ELEMENTS:
			return referenceElements != null && !referenceElements.isEmpty();
		case RapidmlPackage.COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND:
			return resourceRealizationKind != RESOURCE_REALIZATION_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (resourceRealizationKind: ");
		result.append(resourceRealizationKind);
		result.append(')');
		return result.toString();
	}

} // CollectionResourceImpl
