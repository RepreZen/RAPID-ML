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
package com.modelsolv.reprezen.restapi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.modelsolv.reprezen.restapi.Parameter;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.SourceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl#getFixed <em>Fixed</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl#getSourceReference <em>Source Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ParameterImpl extends RESTElementImpl implements Parameter {
    /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected static final String NAME_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected String name = NAME_EDEFAULT;

    /**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
    protected static final boolean REQUIRED_EDEFAULT = false;

    /**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
    protected boolean required = REQUIRED_EDEFAULT;

    /**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
    protected static final String DEFAULT_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
    protected String default_ = DEFAULT_EDEFAULT;

    /**
	 * The default value of the '{@link #getFixed() <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFixed()
	 * @generated
	 * @ordered
	 */
    protected static final String FIXED_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getFixed() <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFixed()
	 * @generated
	 * @ordered
	 */
    protected String fixed = FIXED_EDEFAULT;

    /**
	 * The cached value of the '{@link #getSourceReference() <em>Source Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSourceReference()
	 * @generated
	 * @ordered
	 */
    protected SourceReference sourceReference;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ParameterImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.PARAMETER;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
		return name;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.PARAMETER__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isRequired() {
		return required;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.PARAMETER__REQUIRED, oldRequired, required));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDefault() {
		return default_;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.PARAMETER__DEFAULT, oldDefault, default_));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getFixed() {
		return fixed;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFixed(String newFixed) {
		String oldFixed = fixed;
		fixed = newFixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.PARAMETER__FIXED, oldFixed, fixed));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SourceReference getSourceReference() {
		return sourceReference;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSourceReference(SourceReference newSourceReference, NotificationChain msgs) {
		SourceReference oldSourceReference = sourceReference;
		sourceReference = newSourceReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RestapiPackage.PARAMETER__SOURCE_REFERENCE, oldSourceReference, newSourceReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSourceReference(SourceReference newSourceReference) {
		if (newSourceReference != sourceReference) {
			NotificationChain msgs = null;
			if (sourceReference != null)
				msgs = ((InternalEObject)sourceReference).eInverseRemove(this, RestapiPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER, SourceReference.class, msgs);
			if (newSourceReference != null)
				msgs = ((InternalEObject)newSourceReference).eInverseAdd(this, RestapiPackage.SOURCE_REFERENCE__CONTAINING_PARAMETER, SourceReference.class, msgs);
			msgs = basicSetSourceReference(newSourceReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.PARAMETER__SOURCE_REFERENCE, newSourceReference, newSourceReference));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.modelsolv.reprezen.restapi.SingleValueType getType() {
		return getSourceReference().getType();
	}
	
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.PrimitiveType getPrimitiveType() {
		return getType().getPrimitiveType();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.modelsolv.reprezen.restapi.Constraint> getConstraints() {
		return getSourceReference().getConstraints();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestapiPackage.PARAMETER__SOURCE_REFERENCE:
				if (sourceReference != null)
					msgs = ((InternalEObject)sourceReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.PARAMETER__SOURCE_REFERENCE, null, msgs);
				return basicSetSourceReference((SourceReference)otherEnd, msgs);
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
			case RestapiPackage.PARAMETER__SOURCE_REFERENCE:
				return basicSetSourceReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RestapiPackage.PARAMETER__NAME:
				return getName();
			case RestapiPackage.PARAMETER__REQUIRED:
				return isRequired();
			case RestapiPackage.PARAMETER__DEFAULT:
				return getDefault();
			case RestapiPackage.PARAMETER__FIXED:
				return getFixed();
			case RestapiPackage.PARAMETER__SOURCE_REFERENCE:
				return getSourceReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RestapiPackage.PARAMETER__NAME:
				setName((String)newValue);
				return;
			case RestapiPackage.PARAMETER__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case RestapiPackage.PARAMETER__DEFAULT:
				setDefault((String)newValue);
				return;
			case RestapiPackage.PARAMETER__FIXED:
				setFixed((String)newValue);
				return;
			case RestapiPackage.PARAMETER__SOURCE_REFERENCE:
				setSourceReference((SourceReference)newValue);
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
			case RestapiPackage.PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RestapiPackage.PARAMETER__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case RestapiPackage.PARAMETER__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case RestapiPackage.PARAMETER__FIXED:
				setFixed(FIXED_EDEFAULT);
				return;
			case RestapiPackage.PARAMETER__SOURCE_REFERENCE:
				setSourceReference((SourceReference)null);
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
			case RestapiPackage.PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RestapiPackage.PARAMETER__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case RestapiPackage.PARAMETER__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case RestapiPackage.PARAMETER__FIXED:
				return FIXED_EDEFAULT == null ? fixed != null : !FIXED_EDEFAULT.equals(fixed);
			case RestapiPackage.PARAMETER__SOURCE_REFERENCE:
				return sourceReference != null;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", required: ");
		result.append(required);
		result.append(", default: ");
		result.append(default_);
		result.append(", fixed: ");
		result.append(fixed);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
