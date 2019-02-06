/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.PrimitiveProperty;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.implicit.ConstraintProcessor;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Property Realization</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.PropertyRealizationImpl#getExtensions
 * <em>Extensions</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.PropertyRealizationImpl#getConstraints
 * <em>Constraints</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.PropertyRealizationImpl#getBaseProperty
 * <em>Base Property</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.PropertyRealizationImpl#getCardinality
 * <em>Cardinality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyRealizationImpl extends EObjectImpl implements PropertyRealization {
	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Extension> extensions;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<com.reprezen.rapidml.Constraint> constraints;

	/**
	 * The cached value of the '{@link #getBaseProperty() <em>Base Property</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseProperty()
	 * @generated
	 * @ordered
	 */
	protected com.reprezen.rapidml.Feature baseProperty;

	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CARDINALITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected int[] cardinality = CARDINALITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PropertyRealizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.PROPERTY_REALIZATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this,
					RapidmlPackage.PROPERTY_REALIZATION__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<com.reprezen.rapidml.Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<com.reprezen.rapidml.Constraint>(
					com.reprezen.rapidml.Constraint.class, this, RapidmlPackage.PROPERTY_REALIZATION__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.Feature getBaseProperty() {
		if (baseProperty != null && baseProperty.eIsProxy()) {
			InternalEObject oldBaseProperty = (InternalEObject) baseProperty;
			baseProperty = (com.reprezen.rapidml.Feature) eResolveProxy(oldBaseProperty);
			if (baseProperty != oldBaseProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RapidmlPackage.PROPERTY_REALIZATION__BASE_PROPERTY, oldBaseProperty, baseProperty));
			}
		}
		return baseProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.Feature basicGetBaseProperty() {
		return baseProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseProperty(com.reprezen.rapidml.Feature newBaseProperty) {
		com.reprezen.rapidml.Feature oldBaseProperty = baseProperty;
		baseProperty = newBaseProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.PROPERTY_REALIZATION__BASE_PROPERTY,
					oldBaseProperty, baseProperty));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int[] getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCardinality(int[] newCardinality) {
		int[] oldCardinality = cardinality;
		cardinality = newCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.PROPERTY_REALIZATION__CARDINALITY,
					oldCardinality, cardinality));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getMinOccurs() {
		if (getCardinality() == null || getCardinality().length != 2) {
			return getBaseProperty().getMinOccurs();
		}
		return getCardinality()[0];
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getMaxOccurs() {
		if (getCardinality() == null || getCardinality().length != 2) {
			return getBaseProperty().getMaxOccurs();
		}
		return getCardinality()[1];
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.PrimitiveType getPrimitiveType() {
		if (getBaseProperty() instanceof PrimitiveProperty) {
			return ((PrimitiveProperty) getBaseProperty()).getPrimitiveType();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.ConstrainableType getConstrainableParent() {
		return com.reprezen.rapidml.datatypes.util.ConstraintsUtils.getConstrainableParent(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<com.reprezen.rapidml.Constraint> getAllConstraints() {
		ConstraintProcessor.addParentConstraints(this);
		return getConstraints();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.PROPERTY_REALIZATION__EXTENSIONS:
			return ((InternalEList<?>) getExtensions()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.PROPERTY_REALIZATION__CONSTRAINTS:
			return ((InternalEList<?>) getConstraints()).basicRemove(otherEnd, msgs);
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
		case RapidmlPackage.PROPERTY_REALIZATION__EXTENSIONS:
			return getExtensions();
		case RapidmlPackage.PROPERTY_REALIZATION__CONSTRAINTS:
			return getConstraints();
		case RapidmlPackage.PROPERTY_REALIZATION__BASE_PROPERTY:
			if (resolve)
				return getBaseProperty();
			return basicGetBaseProperty();
		case RapidmlPackage.PROPERTY_REALIZATION__CARDINALITY:
			return getCardinality();
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
		case RapidmlPackage.PROPERTY_REALIZATION__EXTENSIONS:
			getExtensions().clear();
			getExtensions().addAll((Collection<? extends Extension>) newValue);
			return;
		case RapidmlPackage.PROPERTY_REALIZATION__CONSTRAINTS:
			getConstraints().clear();
			getConstraints().addAll((Collection<? extends com.reprezen.rapidml.Constraint>) newValue);
			return;
		case RapidmlPackage.PROPERTY_REALIZATION__BASE_PROPERTY:
			setBaseProperty((com.reprezen.rapidml.Feature) newValue);
			return;
		case RapidmlPackage.PROPERTY_REALIZATION__CARDINALITY:
			setCardinality((int[]) newValue);
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
		case RapidmlPackage.PROPERTY_REALIZATION__EXTENSIONS:
			getExtensions().clear();
			return;
		case RapidmlPackage.PROPERTY_REALIZATION__CONSTRAINTS:
			getConstraints().clear();
			return;
		case RapidmlPackage.PROPERTY_REALIZATION__BASE_PROPERTY:
			setBaseProperty((com.reprezen.rapidml.Feature) null);
			return;
		case RapidmlPackage.PROPERTY_REALIZATION__CARDINALITY:
			setCardinality(CARDINALITY_EDEFAULT);
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
		case RapidmlPackage.PROPERTY_REALIZATION__EXTENSIONS:
			return extensions != null && !extensions.isEmpty();
		case RapidmlPackage.PROPERTY_REALIZATION__CONSTRAINTS:
			return constraints != null && !constraints.isEmpty();
		case RapidmlPackage.PROPERTY_REALIZATION__BASE_PROPERTY:
			return baseProperty != null;
		case RapidmlPackage.PROPERTY_REALIZATION__CARDINALITY:
			return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
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
		result.append(" (cardinality: ");
		result.append(cardinality);
		result.append(')');
		return result.toString();
	}

} // PropertyRealizationImpl
