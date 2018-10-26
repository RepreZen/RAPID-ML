/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml.impl;

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

import com.modelsolv.reprezen.rapidml.LinkRelation;
import com.modelsolv.reprezen.rapidml.LinkRelationsLibrary;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Relations Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.LinkRelationsLibraryImpl#getDefinedLinkRelations <em>Defined Link Relations</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.LinkRelationsLibraryImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkRelationsLibraryImpl extends EObjectImpl implements LinkRelationsLibrary {
	/**
	 * The cached value of the '{@link #getDefinedLinkRelations() <em>Defined Link Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedLinkRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkRelation> definedLinkRelations;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkRelationsLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.LINK_RELATIONS_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LinkRelation> getDefinedLinkRelations() {
		if (definedLinkRelations == null) {
			definedLinkRelations = new EObjectContainmentEList<LinkRelation>(LinkRelation.class, this, RapidmlPackage.LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS);
		}
		return definedLinkRelations;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.LINK_RELATIONS_LIBRARY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS:
				return ((InternalEList<?>)getDefinedLinkRelations()).basicRemove(otherEnd, msgs);
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
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS:
				return getDefinedLinkRelations();
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__NAME:
				return getName();
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
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS:
				getDefinedLinkRelations().clear();
				getDefinedLinkRelations().addAll((Collection<? extends LinkRelation>)newValue);
				return;
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__NAME:
				setName((String)newValue);
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
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS:
				getDefinedLinkRelations().clear();
				return;
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__NAME:
				setName(NAME_EDEFAULT);
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
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS:
				return definedLinkRelations != null && !definedLinkRelations.isEmpty();
			case RapidmlPackage.LINK_RELATIONS_LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(')');
		return result.toString();
	}

} //LinkRelationsLibraryImpl
