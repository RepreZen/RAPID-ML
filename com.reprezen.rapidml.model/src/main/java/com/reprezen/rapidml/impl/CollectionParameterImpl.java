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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.reprezen.rapidml.CollectionParameter;
import com.reprezen.rapidml.CollectionResource;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Collection Parameter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.CollectionParameterImpl#getContainingResourceDefinition
 * <em>Containing Resource Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionParameterImpl extends ParameterImpl implements CollectionParameter {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CollectionParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.COLLECTION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionResource getContainingResourceDefinition() {
		if (eContainerFeatureID() != RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION)
			return null;
		return (CollectionResource) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContainingResourceDefinition(CollectionResource newContainingResourceDefinition,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingResourceDefinition,
				RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainingResourceDefinition(CollectionResource newContainingResourceDefinition) {
		if (newContainingResourceDefinition != eInternalContainer()
				|| (eContainerFeatureID() != RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION
						&& newContainingResourceDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newContainingResourceDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingResourceDefinition != null)
				msgs = ((InternalEObject) newContainingResourceDefinition).eInverseAdd(this,
						RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS, CollectionResource.class, msgs);
			msgs = basicSetContainingResourceDefinition(newContainingResourceDefinition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION,
					newContainingResourceDefinition, newContainingResourceDefinition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingResourceDefinition((CollectionResource) otherEnd, msgs);
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
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			return basicSetContainingResourceDefinition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			return eInternalContainer().eInverseRemove(this, RapidmlPackage.COLLECTION_RESOURCE__COLLECTION_PARAMETERS,
					CollectionResource.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			return getContainingResourceDefinition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			setContainingResourceDefinition((CollectionResource) newValue);
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
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			setContainingResourceDefinition((CollectionResource) null);
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
		case RapidmlPackage.COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION:
			return getContainingResourceDefinition() != null;
		}
		return super.eIsSet(featureID);
	}

} // CollectionParameterImpl
