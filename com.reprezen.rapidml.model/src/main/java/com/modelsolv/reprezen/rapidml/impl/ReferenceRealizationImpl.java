/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.modelsolv.reprezen.rapidml.ObjectRealization;
import com.modelsolv.reprezen.rapidml.ReferenceLink;
import com.modelsolv.reprezen.rapidml.ReferenceRealization;
import com.modelsolv.reprezen.rapidml.ReferenceRealizationEnum;
import com.modelsolv.reprezen.rapidml.ReferenceTreatment;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Realization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ReferenceRealizationImpl#getTargetResource <em>Target Resource</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ReferenceRealizationImpl#getRealizationType <em>Realization Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ReferenceRealizationImpl#isMultiValued <em>Multi Valued</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceRealizationImpl extends RealizationContainerImpl implements ReferenceRealization {
    /**
	 * The cached value of the '{@link #getTargetResource() <em>Target Resource</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTargetResource()
	 * @generated
	 * @ordered
	 */
    protected ResourceDefinition targetResource;

    /**
	 * The default value of the '{@link #getRealizationType() <em>Realization Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRealizationType()
	 * @generated
	 * @ordered
	 */
    protected static final ReferenceRealizationEnum REALIZATION_TYPE_EDEFAULT = ReferenceRealizationEnum.EMBED;

    /**
	 * The cached value of the '{@link #getRealizationType() <em>Realization Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRealizationType()
	 * @generated
	 * @ordered
	 */
    protected ReferenceRealizationEnum realizationType = REALIZATION_TYPE_EDEFAULT;

    /**
	 * The default value of the '{@link #isMultiValued() <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isMultiValued()
	 * @generated
	 * @ordered
	 */
    protected static final boolean MULTI_VALUED_EDEFAULT = false;

    /**
	 * The cached value of the '{@link #isMultiValued() <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isMultiValued()
	 * @generated
	 * @ordered
	 */
    protected boolean multiValued = MULTI_VALUED_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ReferenceRealizationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.REFERENCE_REALIZATION;
	}
    
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @NOT-generated
     */
    @Override
    public Structure getDataType() {
        Structure result = super.getDataType();
        if (result != null) {
            return result;
        }
        if (eContainer() instanceof ReferenceTreatment && ((ReferenceTreatment)eContainer()).getReferenceElement() != null) {
            return ((ReferenceTreatment)eContainer()).getReferenceElement().getDataType();
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ObjectRealization getLinkDescriptor() {
        return getProperties();
    }
    
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDefinition getTargetResource() {
		if (targetResource != null && targetResource.eIsProxy()) {
			InternalEObject oldTargetResource = (InternalEObject)targetResource;
			targetResource = (ResourceDefinition)eResolveProxy(oldTargetResource);
			if (targetResource != oldTargetResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.REFERENCE_REALIZATION__TARGET_RESOURCE, oldTargetResource, targetResource));
			}
		}
		return targetResource;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDefinition basicGetTargetResource() {
		return targetResource;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTargetResource(ResourceDefinition newTargetResource) {
		ResourceDefinition oldTargetResource = targetResource;
		targetResource = newTargetResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_REALIZATION__TARGET_RESOURCE, oldTargetResource, targetResource));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ReferenceRealizationEnum getRealizationTypeGen() {
		return realizationType;
	}
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ReferenceRealizationEnum getRealizationType() {
        if (getRealizationTypeGen() == REALIZATION_TYPE_EDEFAULT && this.eContainer() instanceof ReferenceLink) {
            setRealizationType(ReferenceRealizationEnum.LINK);
        }
        return getRealizationTypeGen();
    }
    

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRealizationType(ReferenceRealizationEnum newRealizationType) {
		ReferenceRealizationEnum oldRealizationType = realizationType;
		realizationType = newRealizationType == null ? REALIZATION_TYPE_EDEFAULT : newRealizationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_REALIZATION__REALIZATION_TYPE, oldRealizationType, realizationType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isMultiValued() {
		return multiValued;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setMultiValued(boolean newMultiValued) {
		boolean oldMultiValued = multiValued;
		multiValued = newMultiValued;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_REALIZATION__MULTI_VALUED, oldMultiValued, multiValued));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.REFERENCE_REALIZATION__TARGET_RESOURCE:
				if (resolve) return getTargetResource();
				return basicGetTargetResource();
			case RapidmlPackage.REFERENCE_REALIZATION__REALIZATION_TYPE:
				return getRealizationType();
			case RapidmlPackage.REFERENCE_REALIZATION__MULTI_VALUED:
				return isMultiValued();
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
			case RapidmlPackage.REFERENCE_REALIZATION__TARGET_RESOURCE:
				setTargetResource((ResourceDefinition)newValue);
				return;
			case RapidmlPackage.REFERENCE_REALIZATION__REALIZATION_TYPE:
				setRealizationType((ReferenceRealizationEnum)newValue);
				return;
			case RapidmlPackage.REFERENCE_REALIZATION__MULTI_VALUED:
				setMultiValued((Boolean)newValue);
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
			case RapidmlPackage.REFERENCE_REALIZATION__TARGET_RESOURCE:
				setTargetResource((ResourceDefinition)null);
				return;
			case RapidmlPackage.REFERENCE_REALIZATION__REALIZATION_TYPE:
				setRealizationType(REALIZATION_TYPE_EDEFAULT);
				return;
			case RapidmlPackage.REFERENCE_REALIZATION__MULTI_VALUED:
				setMultiValued(MULTI_VALUED_EDEFAULT);
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
			case RapidmlPackage.REFERENCE_REALIZATION__TARGET_RESOURCE:
				return targetResource != null;
			case RapidmlPackage.REFERENCE_REALIZATION__REALIZATION_TYPE:
				return realizationType != REALIZATION_TYPE_EDEFAULT;
			case RapidmlPackage.REFERENCE_REALIZATION__MULTI_VALUED:
				return multiValued != MULTI_VALUED_EDEFAULT;
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
		result.append(" (realizationType: ");
		result.append(realizationType);
		result.append(", multiValued: ");
		result.append(multiValued);
		result.append(')');
		return result.toString();
	}

} //ReferenceRealizationImpl
