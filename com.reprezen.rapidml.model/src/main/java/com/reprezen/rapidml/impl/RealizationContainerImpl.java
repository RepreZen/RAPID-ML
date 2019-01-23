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
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.RealizationContainer;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.realization.processor.EffectiveRealization;
import com.reprezen.rapidml.util.TagUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Realization Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getExtensions
 * <em>Extensions</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#isWithDefaultRealization
 * <em>With Default Realization</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getInlineObjectRealization
 * <em>Inline Object Realization</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getProperties
 * <em>Properties</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getReferenceTreatments
 * <em>Reference Treatments</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getDataType
 * <em>Data Type</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getRealizationName
 * <em>Realization Name</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.RealizationContainerImpl#getEffectiveRealization
 * <em>Effective Realization</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RealizationContainerImpl extends EObjectImpl implements RealizationContainer {

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
	 * The default value of the '{@link #isWithDefaultRealization() <em>With Default
	 * Realization</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isWithDefaultRealization()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_DEFAULT_REALIZATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithDefaultRealization() <em>With Default
	 * Realization</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isWithDefaultRealization()
	 * @generated
	 * @ordered
	 */
	protected boolean withDefaultRealization = WITH_DEFAULT_REALIZATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInlineObjectRealization() <em>Inline
	 * Object Realization</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getInlineObjectRealization()
	 * @generated
	 * @ordered
	 */
	protected ObjectRealization inlineObjectRealization;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected ObjectRealization properties;

	/**
	 * The cached value of the '{@link #getReferenceTreatments() <em>Reference
	 * Treatments</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getReferenceTreatments()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceTreatment> referenceTreatments;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected com.reprezen.rapidml.Structure dataType;

	/**
	 * The default value of the '{@link #getRealizationName() <em>Realization
	 * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealizationName()
	 * @generated
	 * @ordered
	 */
	protected static final String REALIZATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRealizationName() <em>Realization
	 * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealizationName()
	 * @generated
	 * @ordered
	 */
	protected String realizationName = REALIZATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEffectiveRealization() <em>Effective
	 * Realization</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEffectiveRealization()
	 * @generated
	 * @ordered
	 */
	protected static final EffectiveRealization EFFECTIVE_REALIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEffectiveRealization() <em>Effective
	 * Realization</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEffectiveRealization()
	 * @generated
	 * @ordered
	 */
	protected EffectiveRealization effectiveRealization = EFFECTIVE_REALIZATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RealizationContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.REALIZATION_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this,
					RapidmlPackage.REALIZATION_CONTAINER__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isWithDefaultRealization() {
		return withDefaultRealization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWithDefaultRealization(boolean newWithDefaultRealization) {
		boolean oldWithDefaultRealization = withDefaultRealization;
		withDefaultRealization = newWithDefaultRealization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION, oldWithDefaultRealization,
					withDefaultRealization));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectRealization getInlineObjectRealization() {
		return inlineObjectRealization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInlineObjectRealization(ObjectRealization newInlineObjectRealization,
			NotificationChain msgs) {
		ObjectRealization oldInlineObjectRealization = inlineObjectRealization;
		inlineObjectRealization = newInlineObjectRealization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION, oldInlineObjectRealization,
					newInlineObjectRealization);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInlineObjectRealization(ObjectRealization newInlineObjectRealization) {
		if (newInlineObjectRealization != inlineObjectRealization) {
			NotificationChain msgs = null;
			if (inlineObjectRealization != null)
				msgs = ((InternalEObject) inlineObjectRealization).eInverseRemove(this,
						RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER, ObjectRealization.class, msgs);
			if (newInlineObjectRealization != null)
				msgs = ((InternalEObject) newInlineObjectRealization).eInverseAdd(this,
						RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER, ObjectRealization.class, msgs);
			msgs = basicSetInlineObjectRealization(newInlineObjectRealization, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION, newInlineObjectRealization,
					newInlineObjectRealization));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectRealization getPropertiesGen() {
		if (properties != null && properties.eIsProxy()) {
			InternalEObject oldProperties = (InternalEObject) properties;
			properties = (ObjectRealization) eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RapidmlPackage.REALIZATION_CONTAINER__PROPERTIES, oldProperties, properties));
			}
		}
		return properties;
	}

	/**
	 * @generated NOT
	 */
	public ObjectRealization getProperties() {
		if (getEffectiveRealization() != null) {
			ObjectRealization result = getEffectiveRealization().getPropertiesAsObjectRealization();
			if (result != getPropertiesGen()) {
				setInlineObjectRealization(result);
				setProperties(result);
			}
		}
		if (getPropertiesGen() != null) {
			return getPropertiesGen();
		}
		if (getInlineObjectRealization() != null) {
			setProperties(getInlineObjectRealization());
		} else {
			ObjectRealization propertyList = RapidmlFactory.eINSTANCE.createObjectRealization();
			TagUtils.addTag(propertyList, TagUtils.GENERATED);
			setInlineObjectRealization(propertyList);
			setProperties(propertyList);
		}
		return getPropertiesGen();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectRealization basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProperties(ObjectRealization newProperties) {
		ObjectRealization oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REALIZATION_CONTAINER__PROPERTIES,
					oldProperties, properties));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ReferenceTreatment> getReferenceTreatmentsGen() {
		if (referenceTreatments == null) {
			referenceTreatments = new EObjectContainmentEList<ReferenceTreatment>(ReferenceTreatment.class, this,
					RapidmlPackage.REALIZATION_CONTAINER__REFERENCE_TREATMENTS);
		}
		return referenceTreatments;
	}

	public EList<ReferenceTreatment> getReferenceTreatments() {
		if (getEffectiveRealization() != null) {
			EList<ReferenceTreatment> result = getEffectiveRealization().getReferenceTreatments();
			if (result != getReferenceTreatmentsGen()) {
				// setting referenceTreatments directly without eNotifications
				// using getReferenceTreatmentsGen() may cause a StackOverflowError because of
				// eNotifications and inverse properties
				referenceTreatments = result;
			}
		}
		return getReferenceTreatmentsGen();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.Structure getDataType() {
		if (dataType != null && dataType.eIsProxy()) {
			InternalEObject oldDataType = (InternalEObject) dataType;
			dataType = (com.reprezen.rapidml.Structure) eResolveProxy(oldDataType);
			if (dataType != oldDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RapidmlPackage.REALIZATION_CONTAINER__DATA_TYPE, oldDataType, dataType));
			}
		}
		return dataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.Structure basicGetDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDataType(com.reprezen.rapidml.Structure newDataType) {
		com.reprezen.rapidml.Structure oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REALIZATION_CONTAINER__DATA_TYPE,
					oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getRealizationNameGen() {
		return realizationName;
	}

	public String getRealizationName() {
		if (getEffectiveRealization() != null) {
			return getEffectiveRealization().getName();
		}
		return getRealizationNameGen();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRealizationName(String newRealizationName) {
		String oldRealizationName = realizationName;
		realizationName = newRealizationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.REALIZATION_CONTAINER__REALIZATION_NAME, oldRealizationName, realizationName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectiveRealization getEffectiveRealization() {
		return effectiveRealization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEffectiveRealization(EffectiveRealization newEffectiveRealization) {
		EffectiveRealization oldEffectiveRealization = effectiveRealization;
		effectiveRealization = newEffectiveRealization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.REALIZATION_CONTAINER__EFFECTIVE_REALIZATION, oldEffectiveRealization,
					effectiveRealization));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Structure getActualType() {
		return getDataType();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION:
			if (inlineObjectRealization != null)
				msgs = ((InternalEObject) inlineObjectRealization).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION, null,
						msgs);
			return basicSetInlineObjectRealization((ObjectRealization) otherEnd, msgs);
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
		case RapidmlPackage.REALIZATION_CONTAINER__EXTENSIONS:
			return ((InternalEList<?>) getExtensions()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION:
			return basicSetInlineObjectRealization(null, msgs);
		case RapidmlPackage.REALIZATION_CONTAINER__REFERENCE_TREATMENTS:
			return ((InternalEList<?>) getReferenceTreatments()).basicRemove(otherEnd, msgs);
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
		case RapidmlPackage.REALIZATION_CONTAINER__EXTENSIONS:
			return getExtensions();
		case RapidmlPackage.REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION:
			return isWithDefaultRealization();
		case RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION:
			return getInlineObjectRealization();
		case RapidmlPackage.REALIZATION_CONTAINER__PROPERTIES:
			if (resolve)
				return getProperties();
			return basicGetProperties();
		case RapidmlPackage.REALIZATION_CONTAINER__REFERENCE_TREATMENTS:
			return getReferenceTreatments();
		case RapidmlPackage.REALIZATION_CONTAINER__DATA_TYPE:
			if (resolve)
				return getDataType();
			return basicGetDataType();
		case RapidmlPackage.REALIZATION_CONTAINER__REALIZATION_NAME:
			return getRealizationName();
		case RapidmlPackage.REALIZATION_CONTAINER__EFFECTIVE_REALIZATION:
			return getEffectiveRealization();
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
		case RapidmlPackage.REALIZATION_CONTAINER__EXTENSIONS:
			getExtensions().clear();
			getExtensions().addAll((Collection<? extends Extension>) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION:
			setWithDefaultRealization((Boolean) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION:
			setInlineObjectRealization((ObjectRealization) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__PROPERTIES:
			setProperties((ObjectRealization) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__REFERENCE_TREATMENTS:
			getReferenceTreatments().clear();
			getReferenceTreatments().addAll((Collection<? extends ReferenceTreatment>) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__DATA_TYPE:
			setDataType((com.reprezen.rapidml.Structure) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__REALIZATION_NAME:
			setRealizationName((String) newValue);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__EFFECTIVE_REALIZATION:
			setEffectiveRealization((EffectiveRealization) newValue);
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
		case RapidmlPackage.REALIZATION_CONTAINER__EXTENSIONS:
			getExtensions().clear();
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION:
			setWithDefaultRealization(WITH_DEFAULT_REALIZATION_EDEFAULT);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION:
			setInlineObjectRealization((ObjectRealization) null);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__PROPERTIES:
			setProperties((ObjectRealization) null);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__REFERENCE_TREATMENTS:
			getReferenceTreatments().clear();
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__DATA_TYPE:
			setDataType((com.reprezen.rapidml.Structure) null);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__REALIZATION_NAME:
			setRealizationName(REALIZATION_NAME_EDEFAULT);
			return;
		case RapidmlPackage.REALIZATION_CONTAINER__EFFECTIVE_REALIZATION:
			setEffectiveRealization(EFFECTIVE_REALIZATION_EDEFAULT);
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
		case RapidmlPackage.REALIZATION_CONTAINER__EXTENSIONS:
			return extensions != null && !extensions.isEmpty();
		case RapidmlPackage.REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION:
			return withDefaultRealization != WITH_DEFAULT_REALIZATION_EDEFAULT;
		case RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION:
			return inlineObjectRealization != null;
		case RapidmlPackage.REALIZATION_CONTAINER__PROPERTIES:
			return properties != null;
		case RapidmlPackage.REALIZATION_CONTAINER__REFERENCE_TREATMENTS:
			return referenceTreatments != null && !referenceTreatments.isEmpty();
		case RapidmlPackage.REALIZATION_CONTAINER__DATA_TYPE:
			return dataType != null;
		case RapidmlPackage.REALIZATION_CONTAINER__REALIZATION_NAME:
			return REALIZATION_NAME_EDEFAULT == null ? realizationName != null
					: !REALIZATION_NAME_EDEFAULT.equals(realizationName);
		case RapidmlPackage.REALIZATION_CONTAINER__EFFECTIVE_REALIZATION:
			return EFFECTIVE_REALIZATION_EDEFAULT == null ? effectiveRealization != null
					: !EFFECTIVE_REALIZATION_EDEFAULT.equals(effectiveRealization);
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
		result.append(" (withDefaultRealization: ");
		result.append(withDefaultRealization);
		result.append(", realizationName: ");
		result.append(realizationName);
		result.append(", effectiveRealization: ");
		result.append(effectiveRealization);
		result.append(')');
		return result.toString();
	}

} // RealizationContainerImpl
