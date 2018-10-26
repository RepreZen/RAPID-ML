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
package com.modelsolv.reprezen.rapidml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.modelsolv.reprezen.rapidml.Parameter;
import com.modelsolv.reprezen.rapidml.PrimitiveType;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.SourceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.SourceReferenceImpl#getContainingParameter <em>Containing Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SourceReferenceImpl extends EObjectImpl implements SourceReference {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SourceReferenceImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.SOURCE_REFERENCE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Parameter getContainingParameter() {
		if (eContainerFeatureID() != RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER) return null;
		return (Parameter)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetContainingParameter(Parameter newContainingParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingParameter, RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContainingParameter(Parameter newContainingParameter) {
		if (newContainingParameter != eInternalContainer() || (eContainerFeatureID() != RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER && newContainingParameter != null)) {
			if (EcoreUtil.isAncestor(this, newContainingParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingParameter != null)
				msgs = ((InternalEObject)newContainingParameter).eInverseAdd(this, RapidmlPackage.PARAMETER__SOURCE_REFERENCE, Parameter.class, msgs);
			msgs = basicSetContainingParameter(newContainingParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER, newContainingParameter, newContainingParameter));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.rapidml.SingleValueType getType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.modelsolv.reprezen.rapidml.Constraint> getConstraints() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

    /**
     * @generated NOT
     */
    public PrimitiveType getPrimitiveType() {
        return getType().getPrimitiveType();
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingParameter((Parameter)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				return basicSetContainingParameter(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				return eInternalContainer().eInverseRemove(this, RapidmlPackage.PARAMETER__SOURCE_REFERENCE, Parameter.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				return getContainingParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				setContainingParameter((Parameter)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				setContainingParameter((Parameter)null);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RapidmlPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER:
				return getContainingParameter() != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceReferenceImpl
