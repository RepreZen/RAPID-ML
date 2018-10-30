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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.google.common.collect.Lists;
import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Treatment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.ReferenceTreatmentImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ReferenceTreatmentImpl#getReferenceElement <em>Reference Element</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ReferenceTreatmentImpl#getReferenceRealization <em>Reference Realization</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ReferenceTreatmentImpl#getOwnedReferenceRealization <em>Owned Reference Realization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceTreatmentImpl extends EObjectImpl implements ReferenceTreatment {
    /**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
    protected EList<Extension> extensions;

    /**
	 * The cached value of the '{@link #getReferenceElement() <em>Reference Element</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferenceElement()
	 * @generated
	 * @ordered
	 */
    protected com.reprezen.rapidml.ReferenceElement referenceElement;

    /**
	 * The cached value of the '{@link #getReferenceRealization() <em>Reference Realization</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferenceRealization()
	 * @generated
	 * @ordered
	 */
    protected ReferenceRealization referenceRealization;

    /**
	 * The cached value of the '{@link #getOwnedReferenceRealization() <em>Owned Reference Realization</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOwnedReferenceRealization()
	 * @generated
	 * @ordered
	 */
    protected ReferenceRealization ownedReferenceRealization;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ReferenceTreatmentImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.REFERENCE_TREATMENT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this, RapidmlPackage.REFERENCE_TREATMENT__EXTENSIONS);
		}
		return extensions;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ReferenceEmbed> getEmbedHierarchy() {
		EObject container = eContainer();
		if (container instanceof ReferenceRealization) {
		    // use containers of the parent ReferenceRealization
		    container = container.eContainer();
		}
		if (container instanceof ReferenceEmbed) {
		    ReferenceEmbed parentEmbed = (ReferenceEmbed)container;
		    List<ReferenceEmbed> hierarchy = Lists.newArrayList(parentEmbed.getEmbedHierarchy());
		    hierarchy.add(parentEmbed);
		    return ECollections.unmodifiableEList(hierarchy);
		}
		return ECollections.emptyEList();
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ObjectRealization getLinkDescriptor() {
        if (getReferenceRealization() != null) {
            return getReferenceRealization().getLinkDescriptor();
        }
        return null;
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.ReferenceElement getReferenceElement() {
		if (referenceElement != null && referenceElement.eIsProxy()) {
			InternalEObject oldReferenceElement = (InternalEObject)referenceElement;
			referenceElement = (com.reprezen.rapidml.ReferenceElement)eResolveProxy(oldReferenceElement);
			if (referenceElement != oldReferenceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_ELEMENT, oldReferenceElement, referenceElement));
			}
		}
		return referenceElement;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.ReferenceElement basicGetReferenceElement() {
		return referenceElement;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceElement(com.reprezen.rapidml.ReferenceElement newReferenceElement) {
		com.reprezen.rapidml.ReferenceElement oldReferenceElement = referenceElement;
		referenceElement = newReferenceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_ELEMENT, oldReferenceElement, referenceElement));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ReferenceRealization getReferenceRealizationGen() {
		if (referenceRealization != null && referenceRealization.eIsProxy()) {
			InternalEObject oldReferenceRealization = (InternalEObject)referenceRealization;
			referenceRealization = (ReferenceRealization)eResolveProxy(oldReferenceRealization);
			if (referenceRealization != oldReferenceRealization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_REALIZATION, oldReferenceRealization, referenceRealization));
			}
		}
		return referenceRealization;
	}
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @NOT-generated
     */
    public ReferenceRealization getReferenceRealization() {
        if (getReferenceRealizationGen() != null) {
            return getReferenceRealizationGen();
        }
        return getOwnedReferenceRealization();
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ReferenceRealization basicGetReferenceRealization() {
		return referenceRealization;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setReferenceRealization(ReferenceRealization newReferenceRealization) {
		ReferenceRealization oldReferenceRealization = referenceRealization;
		referenceRealization = newReferenceRealization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_REALIZATION, oldReferenceRealization, referenceRealization));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ReferenceRealization getOwnedReferenceRealization() {
		return ownedReferenceRealization;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOwnedReferenceRealization(ReferenceRealization newOwnedReferenceRealization, NotificationChain msgs) {
		ReferenceRealization oldOwnedReferenceRealization = ownedReferenceRealization;
		ownedReferenceRealization = newOwnedReferenceRealization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION, oldOwnedReferenceRealization, newOwnedReferenceRealization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOwnedReferenceRealization(ReferenceRealization newOwnedReferenceRealization) {
		if (newOwnedReferenceRealization != ownedReferenceRealization) {
			NotificationChain msgs = null;
			if (ownedReferenceRealization != null)
				msgs = ((InternalEObject)ownedReferenceRealization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION, null, msgs);
			if (newOwnedReferenceRealization != null)
				msgs = ((InternalEObject)newOwnedReferenceRealization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION, null, msgs);
			msgs = basicSetOwnedReferenceRealization(newOwnedReferenceRealization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION, newOwnedReferenceRealization, newOwnedReferenceRealization));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.REFERENCE_TREATMENT__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION:
				return basicSetOwnedReferenceRealization(null, msgs);
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
			case RapidmlPackage.REFERENCE_TREATMENT__EXTENSIONS:
				return getExtensions();
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_ELEMENT:
				if (resolve) return getReferenceElement();
				return basicGetReferenceElement();
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_REALIZATION:
				if (resolve) return getReferenceRealization();
				return basicGetReferenceRealization();
			case RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION:
				return getOwnedReferenceRealization();
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
			case RapidmlPackage.REFERENCE_TREATMENT__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_ELEMENT:
				setReferenceElement((com.reprezen.rapidml.ReferenceElement)newValue);
				return;
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_REALIZATION:
				setReferenceRealization((ReferenceRealization)newValue);
				return;
			case RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION:
				setOwnedReferenceRealization((ReferenceRealization)newValue);
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
			case RapidmlPackage.REFERENCE_TREATMENT__EXTENSIONS:
				getExtensions().clear();
				return;
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_ELEMENT:
				setReferenceElement((com.reprezen.rapidml.ReferenceElement)null);
				return;
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_REALIZATION:
				setReferenceRealization((ReferenceRealization)null);
				return;
			case RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION:
				setOwnedReferenceRealization((ReferenceRealization)null);
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
			case RapidmlPackage.REFERENCE_TREATMENT__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_ELEMENT:
				return referenceElement != null;
			case RapidmlPackage.REFERENCE_TREATMENT__REFERENCE_REALIZATION:
				return referenceRealization != null;
			case RapidmlPackage.REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION:
				return ownedReferenceRealization != null;
		}
		return super.eIsSet(featureID);
	}

} // ReferenceTreatmentImpl
