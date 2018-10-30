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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.RealizationContainer;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceRealizationEnum;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.TypedMessage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Object Realization</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.ObjectRealizationImpl#getExtensions <em>Extensions</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ObjectRealizationImpl#getExclusivePropertyList <em>Exclusive Property
 * List</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ObjectRealizationImpl#getOverriddenPropertyList <em>Overridden
 * Property List</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ObjectRealizationImpl#getExcludedProperties <em>Excluded
 * Properties</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ObjectRealizationImpl#getRealizationContainer <em>Realization
 * Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectRealizationImpl extends EObjectImpl implements ObjectRealization {
    /**
     * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExtensions()
     * @generated
     * @ordered
     */
    protected EList<Extension> extensions;

    /**
	 * The cached value of the '{@link #getExclusivePropertyList() <em>Exclusive Property List</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExclusivePropertyList()
	 * @generated
	 * @ordered
	 */
    protected EList<PropertyRealization> exclusivePropertyList;

    /**
	 * The cached value of the '{@link #getOverriddenPropertyList() <em>Overridden Property List</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOverriddenPropertyList()
	 * @generated
	 * @ordered
	 */
    protected EList<PropertyRealization> overriddenPropertyList;

    /**
     * The cached value of the '{@link #getExcludedProperties() <em>Excluded Properties</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExcludedProperties()
     * @generated
     * @ordered
     */
    protected EList<com.reprezen.rapidml.Feature> excludedProperties;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected ObjectRealizationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.OBJECT_REALIZATION;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this, RapidmlPackage.OBJECT_REALIZATION__EXTENSIONS);
		}
		return extensions;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<PropertyRealization> getExclusivePropertyList() {
		if (exclusivePropertyList == null) {
			exclusivePropertyList = new EObjectContainmentEList<PropertyRealization>(PropertyRealization.class, this, RapidmlPackage.OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST);
		}
		return exclusivePropertyList;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<PropertyRealization> getOverriddenPropertyList() {
		if (overriddenPropertyList == null) {
			overriddenPropertyList = new EObjectContainmentEList<PropertyRealization>(PropertyRealization.class, this, RapidmlPackage.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST);
		}
		return overriddenPropertyList;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.reprezen.rapidml.Feature> getExcludedProperties() {
		if (excludedProperties == null) {
			excludedProperties = new EObjectResolvingEList<com.reprezen.rapidml.Feature>(com.reprezen.rapidml.Feature.class, this, RapidmlPackage.OBJECT_REALIZATION__EXCLUDED_PROPERTIES);
		}
		return excludedProperties;
	}

    private EList<PropertyRealization> allIncludedProperties = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<PropertyRealization> getAllIncludedProperties() {
        if (allIncludedProperties != null) {
            return allIncludedProperties;
        }

        allIncludedProperties = new BasicEList<PropertyRealization>();

        Structure dataType;

        RealizationContainer container = getRealizationContainer();
        if (container instanceof ReferenceRealization) {
            ReferenceRealization referenceRealization = (ReferenceRealization) container;
            dataType = referenceRealization.getDataType();
        } else {
            dataType = getDataType();
        }

        if (!getExclusivePropertyList().isEmpty()) {
            allIncludedProperties.addAll(getExclusivePropertyList());
            return allIncludedProperties;
        }

        if (dataType == null) {
            return allIncludedProperties;
        }
        if (container instanceof ReferenceRealization && ((ReferenceRealization)container).getRealizationType() == ReferenceRealizationEnum.LINK) {
            // reference link are "naked" if "exclusivePropertyList" is not specified
            // they cannot override or exclude feature (not now)
            return allIncludedProperties;
        }

        for (final Feature feature : dataType.getOwnedFeatures()) {
            boolean isExcluded = !com.google.common.collect.Collections2
                    .filter(getExcludedProperties(), new com.google.common.base.Predicate<Feature>() {
                        @Override
                        public boolean apply(Feature input) {
                            return com.reprezen.rapidml.util.InheritanceUtils.sameOrOverrides(input, feature);
                        }
                    }).isEmpty();

            
            if (isExcluded) {
                continue;
            }

            Collection<PropertyRealization> overridden = com.google.common.collect.Collections2
                    .filter(getOverriddenPropertyList(), new com.google.common.base.Predicate<PropertyRealization>() {
                        @Override
                        public boolean apply(PropertyRealization input) {
                            return com.reprezen.rapidml.util.InheritanceUtils
                                    .sameOrOverrides(input.getBaseProperty(), feature);
                        }
                    });

            if (!overridden.isEmpty()) {
                allIncludedProperties.add(com.google.common.collect.Iterables.getFirst(overridden, null));
            } else {
                PropertyRealization includedProperty = com.reprezen.rapidml.RapidmlFactory.eINSTANCE
                        .createPropertyRealization();
                includedProperty.setBaseProperty(feature);
                allIncludedProperties.add(includedProperty);
            }
        }
        return allIncludedProperties;
    }

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public RealizationContainer getRealizationContainer() {
		if (eContainerFeatureID() != RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER) return null;
		return (RealizationContainer)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetRealizationContainer(RealizationContainer newRealizationContainer,
            NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRealizationContainer, RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setRealizationContainer(RealizationContainer newRealizationContainer) {
		if (newRealizationContainer != eInternalContainer() || (eContainerFeatureID() != RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER && newRealizationContainer != null)) {
			if (EcoreUtil.isAncestor(this, newRealizationContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRealizationContainer != null)
				msgs = ((InternalEObject)newRealizationContainer).eInverseAdd(this, RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION, RealizationContainer.class, msgs);
			msgs = basicSetRealizationContainer(newRealizationContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER, newRealizationContainer, newRealizationContainer));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.Structure getDataType() {
		if (eContainer() instanceof ServiceDataResource) {
		    return ((ServiceDataResource) eContainer()).getDataType();
		}
		if (eContainer() instanceof TypedMessage) {
		    return ((TypedMessage) eContainer()).getActualType();
		}
		if (eContainer() instanceof ReferenceRealization) {
		    ReferenceRealization realization = (ReferenceRealization) eContainer();
		    ReferenceTreatment treatment = realization != null ? (ReferenceTreatment) realization.eContainer() : null;
		    
		    return treatment != null ? treatment.getReferenceElement().getDataType() : null;
		}
		if (eContainer() instanceof ReferenceTreatment) {
		    return ((ReferenceTreatment) eContainer()).getReferenceElement().getDataType();
		}
		return null;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRealizationContainer((RealizationContainer)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.OBJECT_REALIZATION__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST:
				return ((InternalEList<?>)getExclusivePropertyList()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST:
				return ((InternalEList<?>)getOverriddenPropertyList()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				return basicSetRealizationContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				return eInternalContainer().eInverseRemove(this, RapidmlPackage.REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION, RealizationContainer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.OBJECT_REALIZATION__EXTENSIONS:
				return getExtensions();
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST:
				return getExclusivePropertyList();
			case RapidmlPackage.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST:
				return getOverriddenPropertyList();
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUDED_PROPERTIES:
				return getExcludedProperties();
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				return getRealizationContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RapidmlPackage.OBJECT_REALIZATION__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST:
				getExclusivePropertyList().clear();
				getExclusivePropertyList().addAll((Collection<? extends PropertyRealization>)newValue);
				return;
			case RapidmlPackage.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST:
				getOverriddenPropertyList().clear();
				getOverriddenPropertyList().addAll((Collection<? extends PropertyRealization>)newValue);
				return;
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUDED_PROPERTIES:
				getExcludedProperties().clear();
				getExcludedProperties().addAll((Collection<? extends com.reprezen.rapidml.Feature>)newValue);
				return;
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				setRealizationContainer((RealizationContainer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case RapidmlPackage.OBJECT_REALIZATION__EXTENSIONS:
				getExtensions().clear();
				return;
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST:
				getExclusivePropertyList().clear();
				return;
			case RapidmlPackage.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST:
				getOverriddenPropertyList().clear();
				return;
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUDED_PROPERTIES:
				getExcludedProperties().clear();
				return;
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				setRealizationContainer((RealizationContainer)null);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RapidmlPackage.OBJECT_REALIZATION__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST:
				return exclusivePropertyList != null && !exclusivePropertyList.isEmpty();
			case RapidmlPackage.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST:
				return overriddenPropertyList != null && !overriddenPropertyList.isEmpty();
			case RapidmlPackage.OBJECT_REALIZATION__EXCLUDED_PROPERTIES:
				return excludedProperties != null && !excludedProperties.isEmpty();
			case RapidmlPackage.OBJECT_REALIZATION__REALIZATION_CONTAINER:
				return getRealizationContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} // ObjectRealizationImpl
