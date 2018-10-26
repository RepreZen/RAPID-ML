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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.modelsolv.reprezen.rapidml.CollectionRealizationLevelEnum;
import com.modelsolv.reprezen.rapidml.CollectionResource;
import com.modelsolv.reprezen.rapidml.LinkRelation;
import com.modelsolv.reprezen.rapidml.ReferenceLink;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ReferenceLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ReferenceLinkImpl#getLinkRelation <em>Link Relation</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ReferenceLinkImpl#getCollectionRealizationLevel <em>Collection Realization Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceLinkImpl extends ReferenceTreatmentImpl implements ReferenceLink {
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
	 * The cached value of the '{@link #getLinkRelation() <em>Link Relation</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLinkRelation()
	 * @generated
	 * @ordered
	 */
    protected LinkRelation linkRelation;

    /**
	 * The default value of the '{@link #getCollectionRealizationLevel() <em>Collection Realization Level</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCollectionRealizationLevel()
	 * @generated
	 * @ordered
	 */
    protected static final CollectionRealizationLevelEnum COLLECTION_REALIZATION_LEVEL_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getCollectionRealizationLevel() <em>Collection Realization Level</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCollectionRealizationLevel()
	 * @generated
	 * @ordered
	 */
    protected CollectionRealizationLevelEnum collectionRealizationLevel = COLLECTION_REALIZATION_LEVEL_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ReferenceLinkImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.REFERENCE_LINK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_LINK__NAME, oldName, name));
	}


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ResourceDefinition getTargetResource() {
        if (getReferenceRealization() != null) {
            return getReferenceRealization().getTargetResource();
        }
        return null;
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public LinkRelation getLinkRelation() {
		if (linkRelation != null && linkRelation.eIsProxy()) {
			InternalEObject oldLinkRelation = (InternalEObject)linkRelation;
			linkRelation = (LinkRelation)eResolveProxy(oldLinkRelation);
			if (linkRelation != oldLinkRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.REFERENCE_LINK__LINK_RELATION, oldLinkRelation, linkRelation));
			}
		}
		return linkRelation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public LinkRelation basicGetLinkRelation() {
		return linkRelation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLinkRelation(LinkRelation newLinkRelation) {
		LinkRelation oldLinkRelation = linkRelation;
		linkRelation = newLinkRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_LINK__LINK_RELATION, oldLinkRelation, linkRelation));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CollectionRealizationLevelEnum getCollectionRealizationLevelGen() {
		return collectionRealizationLevel;
	}
    
    public CollectionRealizationLevelEnum getCollectionRealizationLevel() {
        if (!eIsSet(RapidmlPackage.REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL)) {
            boolean isCollectionLevel = getReferenceElement().isMultiValued()
                    && (getTargetResource() instanceof CollectionResource);
            setCollectionRealizationLevel(isCollectionLevel ? CollectionRealizationLevelEnum.COLLECTION_LEVEL
                    : CollectionRealizationLevelEnum.ITEM_LEVEL);
        }
        return getCollectionRealizationLevelGen();
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setCollectionRealizationLevel(CollectionRealizationLevelEnum newCollectionRealizationLevel) {
		CollectionRealizationLevelEnum oldCollectionRealizationLevel = collectionRealizationLevel;
		collectionRealizationLevel = newCollectionRealizationLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL, oldCollectionRealizationLevel, collectionRealizationLevel));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.REFERENCE_LINK__NAME:
				return getName();
			case RapidmlPackage.REFERENCE_LINK__LINK_RELATION:
				if (resolve) return getLinkRelation();
				return basicGetLinkRelation();
			case RapidmlPackage.REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL:
				return getCollectionRealizationLevel();
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
			case RapidmlPackage.REFERENCE_LINK__NAME:
				setName((String)newValue);
				return;
			case RapidmlPackage.REFERENCE_LINK__LINK_RELATION:
				setLinkRelation((LinkRelation)newValue);
				return;
			case RapidmlPackage.REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL:
				setCollectionRealizationLevel((CollectionRealizationLevelEnum)newValue);
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
			case RapidmlPackage.REFERENCE_LINK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RapidmlPackage.REFERENCE_LINK__LINK_RELATION:
				setLinkRelation((LinkRelation)null);
				return;
			case RapidmlPackage.REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL:
				setCollectionRealizationLevel(COLLECTION_REALIZATION_LEVEL_EDEFAULT);
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
			case RapidmlPackage.REFERENCE_LINK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RapidmlPackage.REFERENCE_LINK__LINK_RELATION:
				return linkRelation != null;
			case RapidmlPackage.REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL:
				return COLLECTION_REALIZATION_LEVEL_EDEFAULT == null ? collectionRealizationLevel != null : !COLLECTION_REALIZATION_LEVEL_EDEFAULT.equals(collectionRealizationLevel);
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
		result.append(", collectionRealizationLevel: ");
		result.append(collectionRealizationLevel);
		result.append(')');
		return result.toString();
	}

} //ReferenceLinkImpl
