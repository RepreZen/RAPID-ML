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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.google.common.collect.Sets;
import com.modelsolv.reprezen.restapi.DataExample;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.Feature;
import com.modelsolv.reprezen.restapi.Inheritable;
import com.modelsolv.reprezen.restapi.Operation;
import com.modelsolv.reprezen.restapi.PrimitiveProperty;
import com.modelsolv.reprezen.restapi.ReferenceProperty;
import com.modelsolv.reprezen.restapi.Structure;
import com.modelsolv.reprezen.restapi.WithDataExamples;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.StructureImpl#getDataExamples <em>Data Examples</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.StructureImpl#getOwnedFeatures <em>Owned Features</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.StructureImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.StructureImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.StructureImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.StructureImpl#getAllSupertypes <em>All Supertypes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructureImpl extends DataTypeImpl implements Structure {
    
    /**
     * The cached value of the '{@link #getDataExamples() <em>Data Examples</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataExamples()
     * @generated
     * @ordered
     */
    protected EList<DataExample> dataExamples;

    /**
     * The cached value of the '{@link #getOwnedFeatures() <em>Owned Features</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedFeatures()
     * @generated
     * @ordered
     */
    protected EList<Feature> ownedFeatures;

    /**
     * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedElements()
     * @generated
     * @ordered
     */
    protected EList<Structure> ownedElements;

    /**
     * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedOperations()
     * @generated
     * @ordered
     */
    protected EList<Operation> ownedOperations;

    /**
     * The cached value of the '{@link #getSupertypes() <em>Supertypes</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSupertypes()
     * @generated
     * @ordered
     */
    protected EList<Inheritable> supertypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StructureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RestapiPackage.Literals.STRUCTURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataExample> getDataExamples() {
        if (dataExamples == null) {
            dataExamples = new EObjectContainmentEList<DataExample>(DataExample.class, this, RestapiPackage.STRUCTURE__DATA_EXAMPLES);
        }
        return dataExamples;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Feature> getOwnedFeatures() {
        if (ownedFeatures == null) {
            ownedFeatures = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, RestapiPackage.STRUCTURE__OWNED_FEATURES, RestapiPackage.FEATURE__CONTAINING_DATA_TYPE);
        }
        return ownedFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Structure> getOwnedElements() {
        if (ownedElements == null) {
            ownedElements = new EObjectContainmentEList<Structure>(Structure.class, this, RestapiPackage.STRUCTURE__OWNED_ELEMENTS);
        }
        return ownedElements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Operation> getOwnedOperations() {
        if (ownedOperations == null) {
            ownedOperations = new EObjectContainmentEList<Operation>(Operation.class, this, RestapiPackage.STRUCTURE__OWNED_OPERATIONS);
        }
        return ownedOperations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Inheritable> getSupertypes() {
        if (supertypes == null) {
            supertypes = new EObjectResolvingEList<Inheritable>(Inheritable.class, this, RestapiPackage.STRUCTURE__SUPERTYPES);
        }
        return supertypes;
    }

    private static final ThreadLocal<Set<Inheritable>> SUPERTYPE_COMPUTATION_IN_PROGRESS = new ThreadLocal<Set<Inheritable>>() {
        @Override
        protected java.util.Set<Inheritable> initialValue() {
            return new HashSet<Inheritable>();
        }
    };

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<Inheritable> getAllSupertypes() {
        Set<Inheritable> allSupertypes = Sets.newLinkedHashSet();
        Set<Inheritable> supertypeComputationInProgress = SUPERTYPE_COMPUTATION_IN_PROGRESS.get();
        if (supertypeComputationInProgress.add(this)) { // does not contain the current type
            try {
                allSupertypes.addAll(getSupertypes());
                if (!allSupertypes.contains(this)) { // StackOverflow otherwise
                    for (Inheritable supertype : getSupertypes()) {
                        if (supertype instanceof Structure) {
                            allSupertypes.addAll(((Structure) supertype).getAllSupertypes());
                        }
                    }
                }
            } finally {
                supertypeComputationInProgress.remove(this);
            }
        }
        // We need an org.eclipse.emf.ecore.util.InternalEList for proper Eclipse rename refactoring
        // Apparently InternalEList is expected for multi-valued features, see https://www.eclipse.org/forums/index.php/t/130207/
        return new EcoreEList.UnmodifiableEList.FastCompare<Inheritable>
          (this, RestapiPackage.eINSTANCE.getStructure_AllSupertypes(), allSupertypes.size(), allSupertypes.toArray());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ReferenceProperty> getReferenceProperties() {
        Collection<ReferenceProperty> referenceProperties = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getOwnedFeatures(), com.modelsolv.reprezen.restapi.ReferenceProperty.class));
        return new BasicEList<ReferenceProperty>(referenceProperties);
        
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PrimitiveProperty> getPrimitiveProperties() {
        Collection<PrimitiveProperty> primitiveProperties = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getOwnedFeatures(), com.modelsolv.reprezen.restapi.PrimitiveProperty.class));
        return new BasicEList<PrimitiveProperty>(primitiveProperties);
        
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PrimitiveProperty> getAllPrimitiveProperties() {
        Collection<PrimitiveProperty> primitiveProperties = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getOwnedFeatures(), com.modelsolv.reprezen.restapi.PrimitiveProperty.class));
        return new BasicEList<PrimitiveProperty>(primitiveProperties);
        
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RestapiPackage.STRUCTURE__OWNED_FEATURES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedFeatures()).basicAdd(otherEnd, msgs);
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
            case RestapiPackage.STRUCTURE__DATA_EXAMPLES:
                return ((InternalEList<?>)getDataExamples()).basicRemove(otherEnd, msgs);
            case RestapiPackage.STRUCTURE__OWNED_FEATURES:
                return ((InternalEList<?>)getOwnedFeatures()).basicRemove(otherEnd, msgs);
            case RestapiPackage.STRUCTURE__OWNED_ELEMENTS:
                return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
            case RestapiPackage.STRUCTURE__OWNED_OPERATIONS:
                return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
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
            case RestapiPackage.STRUCTURE__DATA_EXAMPLES:
                return getDataExamples();
            case RestapiPackage.STRUCTURE__OWNED_FEATURES:
                return getOwnedFeatures();
            case RestapiPackage.STRUCTURE__OWNED_ELEMENTS:
                return getOwnedElements();
            case RestapiPackage.STRUCTURE__OWNED_OPERATIONS:
                return getOwnedOperations();
            case RestapiPackage.STRUCTURE__SUPERTYPES:
                return getSupertypes();
            case RestapiPackage.STRUCTURE__ALL_SUPERTYPES:
                return getAllSupertypes();
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
            case RestapiPackage.STRUCTURE__DATA_EXAMPLES:
                getDataExamples().clear();
                getDataExamples().addAll((Collection<? extends DataExample>)newValue);
                return;
            case RestapiPackage.STRUCTURE__OWNED_FEATURES:
                getOwnedFeatures().clear();
                getOwnedFeatures().addAll((Collection<? extends Feature>)newValue);
                return;
            case RestapiPackage.STRUCTURE__OWNED_ELEMENTS:
                getOwnedElements().clear();
                getOwnedElements().addAll((Collection<? extends Structure>)newValue);
                return;
            case RestapiPackage.STRUCTURE__OWNED_OPERATIONS:
                getOwnedOperations().clear();
                getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
                return;
            case RestapiPackage.STRUCTURE__SUPERTYPES:
                getSupertypes().clear();
                getSupertypes().addAll((Collection<? extends Inheritable>)newValue);
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
            case RestapiPackage.STRUCTURE__DATA_EXAMPLES:
                getDataExamples().clear();
                return;
            case RestapiPackage.STRUCTURE__OWNED_FEATURES:
                getOwnedFeatures().clear();
                return;
            case RestapiPackage.STRUCTURE__OWNED_ELEMENTS:
                getOwnedElements().clear();
                return;
            case RestapiPackage.STRUCTURE__OWNED_OPERATIONS:
                getOwnedOperations().clear();
                return;
            case RestapiPackage.STRUCTURE__SUPERTYPES:
                getSupertypes().clear();
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
            case RestapiPackage.STRUCTURE__DATA_EXAMPLES:
                return dataExamples != null && !dataExamples.isEmpty();
            case RestapiPackage.STRUCTURE__OWNED_FEATURES:
                return ownedFeatures != null && !ownedFeatures.isEmpty();
            case RestapiPackage.STRUCTURE__OWNED_ELEMENTS:
                return ownedElements != null && !ownedElements.isEmpty();
            case RestapiPackage.STRUCTURE__OWNED_OPERATIONS:
                return ownedOperations != null && !ownedOperations.isEmpty();
            case RestapiPackage.STRUCTURE__SUPERTYPES:
                return supertypes != null && !supertypes.isEmpty();
            case RestapiPackage.STRUCTURE__ALL_SUPERTYPES:
                return !getAllSupertypes().isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == WithDataExamples.class) {
            switch (derivedFeatureID) {
                case RestapiPackage.STRUCTURE__DATA_EXAMPLES: return RestapiPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES;
                default: return -1;
            }
        }
        if (baseClass == Inheritable.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == WithDataExamples.class) {
            switch (baseFeatureID) {
                case RestapiPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES: return RestapiPackage.STRUCTURE__DATA_EXAMPLES;
                default: return -1;
            }
        }
        if (baseClass == Inheritable.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //StructureImpl
