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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.reprezen.rapidml.realization.model.RealizationModel;
import com.reprezen.rapidml.realization.processor.EffectiveRealization;
import com.reprezen.rapidml.AuthenticationFlows;
import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.AuthenticationTypes;
import com.reprezen.rapidml.CollectionParameter;
import com.reprezen.rapidml.CollectionRealizationEnum;
import com.reprezen.rapidml.CollectionRealizationLevelEnum;
import com.reprezen.rapidml.CollectionReferenceElement;
import com.reprezen.rapidml.CollectionResource;
import com.reprezen.rapidml.ConstrainableType;
import com.reprezen.rapidml.Constraint;
import com.reprezen.rapidml.DataExample;
import com.reprezen.rapidml.DataModel;
import com.reprezen.rapidml.DataType;
import com.reprezen.rapidml.Documentable;
import com.reprezen.rapidml.Documentation;
import com.reprezen.rapidml.Element;
import com.reprezen.rapidml.EnumConstant;
import com.reprezen.rapidml.Enumeration;
import com.reprezen.rapidml.Example;
import com.reprezen.rapidml.Extensible;
import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.ExternalExample;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.HTTPMethods;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.HasStringValue;
import com.reprezen.rapidml.HasTitle;
import com.reprezen.rapidml.HttpMessageParameterLocation;
import com.reprezen.rapidml.ImportDeclaration;
import com.reprezen.rapidml.Inheritable;
import com.reprezen.rapidml.InlineDataExample;
import com.reprezen.rapidml.InlineExample;
import com.reprezen.rapidml.LengthConstraint;
import com.reprezen.rapidml.LinkRelation;
import com.reprezen.rapidml.LinkRelationsLibrary;
import com.reprezen.rapidml.MatrixParameter;
import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.MediaTypesLibrary;
import com.reprezen.rapidml.MessageParameter;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.NamedLinkDescriptor;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.ObjectResource;
import com.reprezen.rapidml.Operation;
import com.reprezen.rapidml.Parameter;
import com.reprezen.rapidml.PathSegment;
import com.reprezen.rapidml.PrimitiveProperty;
import com.reprezen.rapidml.PrimitiveType;
import com.reprezen.rapidml.PrimitiveTypeSourceReference;
import com.reprezen.rapidml.PrimitiveTypesLibrary;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.PropertyReference;
import com.reprezen.rapidml.RESTElement;
import com.reprezen.rapidml.RealizationContainer;
import com.reprezen.rapidml.RealizationModelLocation;
import com.reprezen.rapidml.ReferenceElement;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceRealizationEnum;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.RegExConstraint;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.SecurityScheme;
import com.reprezen.rapidml.SecuritySchemeLibrary;
import com.reprezen.rapidml.SecuritySchemeParameter;
import com.reprezen.rapidml.SecurityScope;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.SimpleType;
import com.reprezen.rapidml.SingleValueType;
import com.reprezen.rapidml.SourceReference;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.TemplateParameter;
import com.reprezen.rapidml.TypedMessage;
import com.reprezen.rapidml.TypedRequest;
import com.reprezen.rapidml.TypedResponse;
import com.reprezen.rapidml.URIParameter;
import com.reprezen.rapidml.URISegment;
import com.reprezen.rapidml.URISegmentWithParameter;
import com.reprezen.rapidml.UserDefinedType;
import com.reprezen.rapidml.ValueRangeConstraint;
import com.reprezen.rapidml.WithDataExamples;
import com.reprezen.rapidml.WithExamples;
import com.reprezen.rapidml.ZenModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RapidmlPackageImpl extends EPackageImpl implements RapidmlPackage {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass resourceDefinitionEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass typedMessageEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass methodEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass parameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass restElementEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass documentationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass documentableEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass mediaTypeEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass typedRequestEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass typedResponseEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass uriParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass matrixParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass templateParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionResourceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass objectResourceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass propertyReferenceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass sourceReferenceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass messageParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass zenModelEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass resourceAPIEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass serviceDataResourceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass referenceTreatmentEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass referenceRealizationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass referenceLinkEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass referenceEmbedEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass namedLinkDescriptorEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass pathSegmentEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass primitiveTypeSourceReferenceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass uriEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass uriSegmentEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass uriSegmentWithParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass propertyRealizationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass linkRelationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass withExamplesEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass exampleEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass inlineExampleEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass externalExampleEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass hasStringValueEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass importDeclarationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass objectRealizationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionReferenceElementEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass hasSecurityValueEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass securitySchemeEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass authenticationMethodEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass securityScopeEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass securitySchemeParameterEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass securitySchemeLibraryEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass realizationContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass extensibleEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass extensionEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass realizationModelLocationEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass hasTitleEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencePropertyEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitivePropertyEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataModelEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withDataExamplesEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataExampleEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inlineDataExampleEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTypeEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumConstantEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDefinedTypeEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleValueTypeEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceElementEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lengthConstraintEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regExConstraintEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueRangeConstraintEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainableTypeEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inheritableEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaTypesLibraryEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkRelationsLibraryEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypesLibraryEClass = null;

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum httpMethodsEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum referenceRealizationEnumEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum httpMessageParameterLocationEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum collectionRealizationEnumEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum authenticationTypesEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum authenticationFlowsEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum collectionRealizationLevelEnumEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EDataType realizationModelEDataType = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EDataType collectionRealizationLevelObjectEDataType = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EDataType effectiveRealizationEDataType = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cardinalityEDataType = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cardinalityOverrideEDataType = null;

				/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.reprezen.rapidml.RapidmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
    private RapidmlPackageImpl() {
		super(eNS_URI, RapidmlFactory.eINSTANCE);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static boolean isInited = false;

    /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link RapidmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
    public static RapidmlPackage init() {
		if (isInited) return (RapidmlPackage)EPackage.Registry.INSTANCE.getEPackage(RapidmlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRapidmlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RapidmlPackageImpl theRapidmlPackage = registeredRapidmlPackage instanceof RapidmlPackageImpl ? (RapidmlPackageImpl)registeredRapidmlPackage : new RapidmlPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theRapidmlPackage.createPackageContents();

		// Initialize created meta-data
		theRapidmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRapidmlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RapidmlPackage.eNS_URI, theRapidmlPackage);
		return theRapidmlPackage;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getResourceDefinition() {
		return resourceDefinitionEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceDefinition_Methods() {
		return (EReference)resourceDefinitionEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceDefinition_MediaTypes() {
		return (EReference)resourceDefinitionEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceDefinition_URI() {
		return (EReference)resourceDefinitionEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getResourceDefinition_Name() {
		return (EAttribute)resourceDefinitionEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceDefinition_AllMediaTypes() {
		return (EReference)resourceDefinitionEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getTypedMessage() {
		return typedMessageEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getTypedMessage_Parameters() {
		return (EReference)typedMessageEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getTypedMessage_ResourceType() {
		return (EReference)typedMessageEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getTypedMessage_UseParentTypeReference() {
		return (EAttribute)typedMessageEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getTypedMessage_MediaTypes() {
		return (EReference)typedMessageEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getMethod() {
		return methodEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getMethod_Request() {
		return (EReference)methodEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getMethod_Responses() {
		return (EReference)methodEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getMethod_Id() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getMethod_HttpMethod() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getMethod_ContainingResourceDefinition() {
		return (EReference)methodEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getParameter() {
		return parameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getParameter_Required() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getParameter_Default() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getParameter_Fixed() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getParameter_SourceReference() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getRESTElement() {
		return restElementEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getDocumentation() {
		return documentationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getDocumentation_Text() {
		return (EAttribute)documentationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getDocumentable() {
		return documentableEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getDocumentable_Documentation() {
		return (EReference)documentableEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getMediaType() {
		return mediaTypeEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getMediaType_Name() {
		return (EAttribute)mediaTypeEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getMediaType_SpecURL() {
		return (EAttribute)mediaTypeEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getMediaType_DerivedFrom() {
		return (EReference)mediaTypeEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getTypedRequest() {
		return typedRequestEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getTypedRequest_ContainingMethod() {
		return (EReference)typedRequestEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getTypedResponse() {
		return typedResponseEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getTypedResponse_StatusCode() {
		return (EAttribute)typedResponseEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getTypedResponse_ContainingMethod() {
		return (EReference)typedResponseEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getURIParameter() {
		return uriParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getURIParameter_UriSegment() {
		return (EReference)uriParameterEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getURIParameter_ContainingURI() {
		return (EReference)uriParameterEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getMatrixParameter() {
		return matrixParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getTemplateParameter() {
		return templateParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionResource() {
		return collectionResourceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionResource_CollectionParameters() {
		return (EReference)collectionResourceEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionResource_ReferenceElements() {
		return (EReference)collectionResourceEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCollectionResource_ResourceRealizationKind() {
		return (EAttribute)collectionResourceEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getObjectResource() {
		return objectResourceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionParameter() {
		return collectionParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionParameter_ContainingResourceDefinition() {
		return (EReference)collectionParameterEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPropertyReference() {
		return propertyReferenceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPropertyReference_ConceptualFeature() {
		return (EReference)propertyReferenceEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSourceReference() {
		return sourceReferenceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSourceReference_ContainingParameter() {
		return (EReference)sourceReferenceEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getMessageParameter() {
		return messageParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getMessageParameter_ContainingMessage() {
		return (EReference)messageParameterEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getMessageParameter_HttpLocation() {
		return (EAttribute)messageParameterEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getZenModel() {
		return zenModelEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getZenModel_Name() {
		return (EAttribute)zenModelEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getZenModel_Namespace() {
		return (EAttribute)zenModelEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_ResourceAPIs() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_DataModels() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_MediaTypesLibrary() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_LinkRelationsLibrary() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_PrimitiveTypesLibrary() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_Imports() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(7);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getZenModel_SecuritySchemesLibrary() {
		return (EReference)zenModelEClass.getEStructuralFeatures().get(8);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getResourceAPI() {
		return resourceAPIEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getResourceAPI_Name() {
		return (EAttribute)resourceAPIEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getResourceAPI_Version() {
		return (EAttribute)resourceAPIEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getResourceAPI_BaseURI() {
		return (EAttribute)resourceAPIEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_OwnedResourceDefinitions() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_ServiceDataModels() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_Formats() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_DefinedMediaTypes() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_DefinedLinkRelations() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(7);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_DefaultReferenceRealizations() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(8);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResourceAPI_AutoRealizations() {
		return (EReference)resourceAPIEClass.getEStructuralFeatures().get(9);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getServiceDataResource() {
		return serviceDataResourceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getServiceDataResource_Default() {
		return (EAttribute)serviceDataResourceEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getServiceDataResource_DefinedLinkDescriptors() {
		return (EReference)serviceDataResourceEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getReferenceTreatment() {
		return referenceTreatmentEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getReferenceTreatment_ReferenceElement() {
		return (EReference)referenceTreatmentEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getReferenceTreatment_ReferenceRealization() {
		return (EReference)referenceTreatmentEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getReferenceTreatment_OwnedReferenceRealization() {
		return (EReference)referenceTreatmentEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getReferenceRealization() {
		return referenceRealizationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getReferenceRealization_TargetResource() {
		return (EReference)referenceRealizationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getReferenceRealization_RealizationType() {
		return (EAttribute)referenceRealizationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getReferenceRealization_MultiValued() {
		return (EAttribute)referenceRealizationEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getReferenceLink() {
		return referenceLinkEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getReferenceLink_Name() {
		return (EAttribute)referenceLinkEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getReferenceLink_LinkRelation() {
		return (EReference)referenceLinkEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getReferenceLink_CollectionRealizationLevel() {
		return (EAttribute)referenceLinkEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getReferenceEmbed() {
		return referenceEmbedEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getNamedLinkDescriptor() {
		return namedLinkDescriptorEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getNamedLinkDescriptor_Name() {
		return (EAttribute)namedLinkDescriptorEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getNamedLinkDescriptor_Default() {
		return (EAttribute)namedLinkDescriptorEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPathSegment() {
		return pathSegmentEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPathSegment_ReferenceElement() {
		return (EReference)pathSegmentEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPrimitiveTypeSourceReference() {
		return primitiveTypeSourceReferenceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPrimitiveTypeSourceReference_SimpleType() {
		return (EReference)primitiveTypeSourceReferenceEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getURI() {
		return uriEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getURI_Segments() {
		return (EReference)uriEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getURI_UriParameters() {
		return (EReference)uriEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getURISegment() {
		return uriSegmentEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getURISegment_Name() {
		return (EAttribute)uriSegmentEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getURISegmentWithParameter() {
		return uriSegmentWithParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPropertyRealization() {
		return propertyRealizationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPropertyRealization_BaseProperty() {
		return (EReference)propertyRealizationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getPropertyRealization_Cardinality() {
		return (EAttribute)propertyRealizationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getLinkRelation() {
		return linkRelationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getLinkRelation_Name() {
		return (EAttribute)linkRelationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getLinkRelation_SpecURL() {
		return (EAttribute)linkRelationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getWithExamples() {
		return withExamplesEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getWithExamples_Examples() {
		return (EReference)withExamplesEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getExample() {
		return exampleEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getInlineExample() {
		return inlineExampleEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getInlineExample_Body() {
		return (EAttribute)inlineExampleEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getExternalExample() {
		return externalExampleEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getExternalExample_Path() {
		return (EAttribute)externalExampleEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getHasStringValue() {
		return hasStringValueEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getImportDeclaration() {
		return importDeclarationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getImportDeclaration_ImportURI() {
		return (EAttribute)importDeclarationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getImportDeclaration_ImportedNamespace() {
		return (EAttribute)importDeclarationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getImportDeclaration_Alias() {
		return (EAttribute)importDeclarationEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getImportDeclaration_ImportedModel() {
		return (EReference)importDeclarationEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getObjectRealization() {
		return objectRealizationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getObjectRealization_ExclusivePropertyList() {
		return (EReference)objectRealizationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getObjectRealization_OverriddenPropertyList() {
		return (EReference)objectRealizationEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getObjectRealization_ExcludedProperties() {
		return (EReference)objectRealizationEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getObjectRealization_RealizationContainer() {
		return (EReference)objectRealizationEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionReferenceElement() {
		return collectionReferenceElementEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getHasSecurityValue() {
		return hasSecurityValueEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getHasSecurityValue_SecuredBy() {
		return (EReference)hasSecurityValueEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSecurityScheme() {
		return securitySchemeEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecurityScheme_Name() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecurityScheme_Type() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSecurityScheme_Scopes() {
		return (EReference)securitySchemeEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSecurityScheme_Settings() {
		return (EReference)securitySchemeEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSecurityScheme_Parameters() {
		return (EReference)securitySchemeEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSecurityScheme_ErrorResponses() {
		return (EReference)securitySchemeEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecurityScheme_Flow() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getAuthenticationMethod() {
		return authenticationMethodEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getAuthenticationMethod_Scheme() {
		return (EReference)authenticationMethodEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getAuthenticationMethod_Scopes() {
		return (EReference)authenticationMethodEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSecurityScope() {
		return securityScopeEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecurityScope_Name() {
		return (EAttribute)securityScopeEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSecuritySchemeParameter() {
		return securitySchemeParameterEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecuritySchemeParameter_Name() {
		return (EAttribute)securitySchemeParameterEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecuritySchemeParameter_Value() {
		return (EAttribute)securitySchemeParameterEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSecuritySchemeLibrary() {
		return securitySchemeLibraryEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSecuritySchemeLibrary_SecuritySchemes() {
		return (EReference)securitySchemeLibraryEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSecuritySchemeLibrary_Name() {
		return (EAttribute)securitySchemeLibraryEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getRealizationContainer() {
		return realizationContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getRealizationContainer_WithDefaultRealization() {
		return (EAttribute)realizationContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getRealizationContainer_InlineObjectRealization() {
		return (EReference)realizationContainerEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getRealizationContainer_Properties() {
		return (EReference)realizationContainerEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getRealizationContainer_ReferenceTreatments() {
		return (EReference)realizationContainerEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getRealizationContainer_DataType() {
		return (EReference)realizationContainerEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getRealizationContainer_RealizationName() {
		return (EAttribute)realizationContainerEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getRealizationContainer_EffectiveRealization() {
		return (EAttribute)realizationContainerEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getExtensible() {
		return extensibleEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getExtensible_Extensions() {
		return (EReference)extensibleEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getExtension() {
		return extensionEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getExtension_Name() {
		return (EAttribute)extensionEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getExtension_Value() {
		return (EAttribute)extensionEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getRealizationModelLocation() {
		return realizationModelLocationEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getRealizationModelLocation_Uri() {
		return (EAttribute)realizationModelLocationEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getHasTitle() {
		return hasTitleEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getHasTitle_Title() {
		return (EAttribute)hasTitleEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Name() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Name() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_ContainingDataType() {
		return (EReference)featureEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Restriction() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_ReadOnly() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Key() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceProperty() {
		return referencePropertyEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceProperty_Type() {
		return (EReference)referencePropertyEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceProperty_Inverse() {
		return (EReference)referencePropertyEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceProperty_Containment() {
		return (EAttribute)referencePropertyEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceProperty_Container() {
		return (EAttribute)referencePropertyEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveProperty() {
		return primitivePropertyEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveProperty_Type() {
		return (EReference)primitivePropertyEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructure() {
		return structureEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_OwnedFeatures() {
		return (EReference)structureEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_OwnedElements() {
		return (EReference)structureEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_OwnedOperations() {
		return (EReference)structureEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_Supertypes() {
		return (EReference)structureEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_AllSupertypes() {
		return (EReference)structureEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataModel() {
		return dataModelEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataModel_OwnedDataTypes() {
		return (EReference)dataModelEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataModel_Name() {
		return (EAttribute)dataModelEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWithDataExamples() {
		return withDataExamplesEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWithDataExamples_DataExamples() {
		return (EReference)withDataExamplesEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataExample() {
		return dataExampleEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInlineDataExample() {
		return inlineDataExampleEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInlineDataExample_Body() {
		return (EAttribute)inlineDataExampleEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_EnumConstants() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_BaseType() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleType() {
		return simpleTypeEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumConstant() {
		return enumConstantEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumConstant_Name() {
		return (EAttribute)enumConstantEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumConstant_IntegerValue() {
		return (EAttribute)enumConstantEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumConstant_LiteralValue() {
		return (EAttribute)enumConstantEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumConstant_Enumeration() {
		return (EReference)enumConstantEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDefinedType() {
		return userDefinedTypeEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserDefinedType_BaseType() {
		return (EReference)userDefinedTypeEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Name() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleValueType() {
		return singleValueTypeEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Cardinality() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceElement() {
		return referenceElementEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceElement_DataType() {
		return (EReference)referenceElementEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLengthConstraint() {
		return lengthConstraintEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLengthConstraint_MinLength() {
		return (EAttribute)lengthConstraintEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLengthConstraint_MaxLength() {
		return (EAttribute)lengthConstraintEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLengthConstraint_Length() {
		return (EAttribute)lengthConstraintEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegExConstraint() {
		return regExConstraintEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegExConstraint_Pattern() {
		return (EAttribute)regExConstraintEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueRangeConstraint() {
		return valueRangeConstraintEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueRangeConstraint_MinValue() {
		return (EAttribute)valueRangeConstraintEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueRangeConstraint_MinValueExclusive() {
		return (EAttribute)valueRangeConstraintEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueRangeConstraint_MaxValue() {
		return (EAttribute)valueRangeConstraintEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueRangeConstraint_MaxValueExclusive() {
		return (EAttribute)valueRangeConstraintEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstrainableType() {
		return constrainableTypeEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstrainableType_Constraints() {
		return (EReference)constrainableTypeEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInheritable() {
		return inheritableEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaTypesLibrary() {
		return mediaTypesLibraryEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediaTypesLibrary_MediaTypes() {
		return (EReference)mediaTypesLibraryEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkRelationsLibrary() {
		return linkRelationsLibraryEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkRelationsLibrary_DefinedLinkRelations() {
		return (EReference)linkRelationsLibraryEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkRelationsLibrary_Name() {
		return (EAttribute)linkRelationsLibraryEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypesLibrary() {
		return primitiveTypesLibraryEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypesLibrary_Name() {
		return (EAttribute)primitiveTypesLibraryEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveTypesLibrary_PrimitiveTypes() {
		return (EReference)primitiveTypesLibraryEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getHTTPMethods() {
		return httpMethodsEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getReferenceRealizationEnum() {
		return referenceRealizationEnumEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getHttpMessageParameterLocation() {
		return httpMessageParameterLocationEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getCollectionRealizationEnum() {
		return collectionRealizationEnumEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getAuthenticationTypes() {
		return authenticationTypesEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getAuthenticationFlows() {
		return authenticationFlowsEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getCollectionRealizationLevelEnum() {
		return collectionRealizationLevelEnumEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EDataType getRealizationModel() {
		return realizationModelEDataType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EDataType getCollectionRealizationLevelObject() {
		return collectionRealizationLevelObjectEDataType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EDataType getEffectiveRealization() {
		return effectiveRealizationEDataType;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCardinality() {
		return cardinalityEDataType;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCardinalityOverride() {
		return cardinalityOverrideEDataType;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public RapidmlFactory getRapidmlFactory() {
		return (RapidmlFactory)getEFactoryInstance();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isCreated = false;

    /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		resourceDefinitionEClass = createEClass(RESOURCE_DEFINITION);
		createEReference(resourceDefinitionEClass, RESOURCE_DEFINITION__METHODS);
		createEReference(resourceDefinitionEClass, RESOURCE_DEFINITION__MEDIA_TYPES);
		createEAttribute(resourceDefinitionEClass, RESOURCE_DEFINITION__NAME);
		createEReference(resourceDefinitionEClass, RESOURCE_DEFINITION__ALL_MEDIA_TYPES);
		createEReference(resourceDefinitionEClass, RESOURCE_DEFINITION__URI);

		typedMessageEClass = createEClass(TYPED_MESSAGE);
		createEReference(typedMessageEClass, TYPED_MESSAGE__PARAMETERS);
		createEReference(typedMessageEClass, TYPED_MESSAGE__RESOURCE_TYPE);
		createEAttribute(typedMessageEClass, TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE);
		createEReference(typedMessageEClass, TYPED_MESSAGE__MEDIA_TYPES);

		methodEClass = createEClass(METHOD);
		createEReference(methodEClass, METHOD__REQUEST);
		createEReference(methodEClass, METHOD__RESPONSES);
		createEAttribute(methodEClass, METHOD__ID);
		createEAttribute(methodEClass, METHOD__HTTP_METHOD);
		createEReference(methodEClass, METHOD__CONTAINING_RESOURCE_DEFINITION);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__REQUIRED);
		createEAttribute(parameterEClass, PARAMETER__DEFAULT);
		createEAttribute(parameterEClass, PARAMETER__FIXED);
		createEReference(parameterEClass, PARAMETER__SOURCE_REFERENCE);

		restElementEClass = createEClass(REST_ELEMENT);

		documentationEClass = createEClass(DOCUMENTATION);
		createEAttribute(documentationEClass, DOCUMENTATION__TEXT);

		documentableEClass = createEClass(DOCUMENTABLE);
		createEReference(documentableEClass, DOCUMENTABLE__DOCUMENTATION);

		mediaTypeEClass = createEClass(MEDIA_TYPE);
		createEAttribute(mediaTypeEClass, MEDIA_TYPE__NAME);
		createEAttribute(mediaTypeEClass, MEDIA_TYPE__SPEC_URL);
		createEReference(mediaTypeEClass, MEDIA_TYPE__DERIVED_FROM);

		typedRequestEClass = createEClass(TYPED_REQUEST);
		createEReference(typedRequestEClass, TYPED_REQUEST__CONTAINING_METHOD);

		typedResponseEClass = createEClass(TYPED_RESPONSE);
		createEAttribute(typedResponseEClass, TYPED_RESPONSE__STATUS_CODE);
		createEReference(typedResponseEClass, TYPED_RESPONSE__CONTAINING_METHOD);

		uriParameterEClass = createEClass(URI_PARAMETER);
		createEReference(uriParameterEClass, URI_PARAMETER__URI_SEGMENT);
		createEReference(uriParameterEClass, URI_PARAMETER__CONTAINING_URI);

		matrixParameterEClass = createEClass(MATRIX_PARAMETER);

		templateParameterEClass = createEClass(TEMPLATE_PARAMETER);

		collectionResourceEClass = createEClass(COLLECTION_RESOURCE);
		createEReference(collectionResourceEClass, COLLECTION_RESOURCE__COLLECTION_PARAMETERS);
		createEReference(collectionResourceEClass, COLLECTION_RESOURCE__REFERENCE_ELEMENTS);
		createEAttribute(collectionResourceEClass, COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND);

		objectResourceEClass = createEClass(OBJECT_RESOURCE);

		collectionParameterEClass = createEClass(COLLECTION_PARAMETER);
		createEReference(collectionParameterEClass, COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION);

		propertyReferenceEClass = createEClass(PROPERTY_REFERENCE);
		createEReference(propertyReferenceEClass, PROPERTY_REFERENCE__CONCEPTUAL_FEATURE);

		sourceReferenceEClass = createEClass(SOURCE_REFERENCE);
		createEReference(sourceReferenceEClass, SOURCE_REFERENCE__CONTAINING_PARAMETER);

		messageParameterEClass = createEClass(MESSAGE_PARAMETER);
		createEReference(messageParameterEClass, MESSAGE_PARAMETER__CONTAINING_MESSAGE);
		createEAttribute(messageParameterEClass, MESSAGE_PARAMETER__HTTP_LOCATION);

		zenModelEClass = createEClass(ZEN_MODEL);
		createEAttribute(zenModelEClass, ZEN_MODEL__NAME);
		createEAttribute(zenModelEClass, ZEN_MODEL__NAMESPACE);
		createEReference(zenModelEClass, ZEN_MODEL__RESOURCE_AP_IS);
		createEReference(zenModelEClass, ZEN_MODEL__DATA_MODELS);
		createEReference(zenModelEClass, ZEN_MODEL__MEDIA_TYPES_LIBRARY);
		createEReference(zenModelEClass, ZEN_MODEL__LINK_RELATIONS_LIBRARY);
		createEReference(zenModelEClass, ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY);
		createEReference(zenModelEClass, ZEN_MODEL__IMPORTS);
		createEReference(zenModelEClass, ZEN_MODEL__SECURITY_SCHEMES_LIBRARY);

		resourceAPIEClass = createEClass(RESOURCE_API);
		createEAttribute(resourceAPIEClass, RESOURCE_API__NAME);
		createEAttribute(resourceAPIEClass, RESOURCE_API__VERSION);
		createEAttribute(resourceAPIEClass, RESOURCE_API__BASE_URI);
		createEReference(resourceAPIEClass, RESOURCE_API__OWNED_RESOURCE_DEFINITIONS);
		createEReference(resourceAPIEClass, RESOURCE_API__SERVICE_DATA_MODELS);
		createEReference(resourceAPIEClass, RESOURCE_API__FORMATS);
		createEReference(resourceAPIEClass, RESOURCE_API__DEFINED_MEDIA_TYPES);
		createEReference(resourceAPIEClass, RESOURCE_API__DEFINED_LINK_RELATIONS);
		createEReference(resourceAPIEClass, RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS);
		createEReference(resourceAPIEClass, RESOURCE_API__AUTO_REALIZATIONS);

		serviceDataResourceEClass = createEClass(SERVICE_DATA_RESOURCE);
		createEAttribute(serviceDataResourceEClass, SERVICE_DATA_RESOURCE__DEFAULT);
		createEReference(serviceDataResourceEClass, SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS);

		referenceTreatmentEClass = createEClass(REFERENCE_TREATMENT);
		createEReference(referenceTreatmentEClass, REFERENCE_TREATMENT__REFERENCE_ELEMENT);
		createEReference(referenceTreatmentEClass, REFERENCE_TREATMENT__REFERENCE_REALIZATION);
		createEReference(referenceTreatmentEClass, REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION);

		referenceRealizationEClass = createEClass(REFERENCE_REALIZATION);
		createEReference(referenceRealizationEClass, REFERENCE_REALIZATION__TARGET_RESOURCE);
		createEAttribute(referenceRealizationEClass, REFERENCE_REALIZATION__REALIZATION_TYPE);
		createEAttribute(referenceRealizationEClass, REFERENCE_REALIZATION__MULTI_VALUED);

		referenceLinkEClass = createEClass(REFERENCE_LINK);
		createEAttribute(referenceLinkEClass, REFERENCE_LINK__NAME);
		createEReference(referenceLinkEClass, REFERENCE_LINK__LINK_RELATION);
		createEAttribute(referenceLinkEClass, REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL);

		referenceEmbedEClass = createEClass(REFERENCE_EMBED);

		namedLinkDescriptorEClass = createEClass(NAMED_LINK_DESCRIPTOR);
		createEAttribute(namedLinkDescriptorEClass, NAMED_LINK_DESCRIPTOR__NAME);
		createEAttribute(namedLinkDescriptorEClass, NAMED_LINK_DESCRIPTOR__DEFAULT);

		pathSegmentEClass = createEClass(PATH_SEGMENT);
		createEReference(pathSegmentEClass, PATH_SEGMENT__REFERENCE_ELEMENT);

		primitiveTypeSourceReferenceEClass = createEClass(PRIMITIVE_TYPE_SOURCE_REFERENCE);
		createEReference(primitiveTypeSourceReferenceEClass, PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE);

		uriEClass = createEClass(URI);
		createEReference(uriEClass, URI__SEGMENTS);
		createEReference(uriEClass, URI__URI_PARAMETERS);

		uriSegmentEClass = createEClass(URI_SEGMENT);
		createEAttribute(uriSegmentEClass, URI_SEGMENT__NAME);

		uriSegmentWithParameterEClass = createEClass(URI_SEGMENT_WITH_PARAMETER);

		propertyRealizationEClass = createEClass(PROPERTY_REALIZATION);
		createEReference(propertyRealizationEClass, PROPERTY_REALIZATION__BASE_PROPERTY);
		createEAttribute(propertyRealizationEClass, PROPERTY_REALIZATION__CARDINALITY);

		linkRelationEClass = createEClass(LINK_RELATION);
		createEAttribute(linkRelationEClass, LINK_RELATION__NAME);
		createEAttribute(linkRelationEClass, LINK_RELATION__SPEC_URL);

		withExamplesEClass = createEClass(WITH_EXAMPLES);
		createEReference(withExamplesEClass, WITH_EXAMPLES__EXAMPLES);

		exampleEClass = createEClass(EXAMPLE);

		inlineExampleEClass = createEClass(INLINE_EXAMPLE);
		createEAttribute(inlineExampleEClass, INLINE_EXAMPLE__BODY);

		externalExampleEClass = createEClass(EXTERNAL_EXAMPLE);
		createEAttribute(externalExampleEClass, EXTERNAL_EXAMPLE__PATH);

		hasStringValueEClass = createEClass(HAS_STRING_VALUE);

		importDeclarationEClass = createEClass(IMPORT_DECLARATION);
		createEAttribute(importDeclarationEClass, IMPORT_DECLARATION__IMPORT_URI);
		createEAttribute(importDeclarationEClass, IMPORT_DECLARATION__IMPORTED_NAMESPACE);
		createEAttribute(importDeclarationEClass, IMPORT_DECLARATION__ALIAS);
		createEReference(importDeclarationEClass, IMPORT_DECLARATION__IMPORTED_MODEL);

		objectRealizationEClass = createEClass(OBJECT_REALIZATION);
		createEReference(objectRealizationEClass, OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST);
		createEReference(objectRealizationEClass, OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST);
		createEReference(objectRealizationEClass, OBJECT_REALIZATION__EXCLUDED_PROPERTIES);
		createEReference(objectRealizationEClass, OBJECT_REALIZATION__REALIZATION_CONTAINER);

		collectionReferenceElementEClass = createEClass(COLLECTION_REFERENCE_ELEMENT);

		hasSecurityValueEClass = createEClass(HAS_SECURITY_VALUE);
		createEReference(hasSecurityValueEClass, HAS_SECURITY_VALUE__SECURED_BY);

		securitySchemeEClass = createEClass(SECURITY_SCHEME);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__NAME);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__TYPE);
		createEReference(securitySchemeEClass, SECURITY_SCHEME__SCOPES);
		createEReference(securitySchemeEClass, SECURITY_SCHEME__SETTINGS);
		createEReference(securitySchemeEClass, SECURITY_SCHEME__PARAMETERS);
		createEReference(securitySchemeEClass, SECURITY_SCHEME__ERROR_RESPONSES);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__FLOW);

		authenticationMethodEClass = createEClass(AUTHENTICATION_METHOD);
		createEReference(authenticationMethodEClass, AUTHENTICATION_METHOD__SCHEME);
		createEReference(authenticationMethodEClass, AUTHENTICATION_METHOD__SCOPES);

		securityScopeEClass = createEClass(SECURITY_SCOPE);
		createEAttribute(securityScopeEClass, SECURITY_SCOPE__NAME);

		securitySchemeParameterEClass = createEClass(SECURITY_SCHEME_PARAMETER);
		createEAttribute(securitySchemeParameterEClass, SECURITY_SCHEME_PARAMETER__NAME);
		createEAttribute(securitySchemeParameterEClass, SECURITY_SCHEME_PARAMETER__VALUE);

		securitySchemeLibraryEClass = createEClass(SECURITY_SCHEME_LIBRARY);
		createEReference(securitySchemeLibraryEClass, SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES);
		createEAttribute(securitySchemeLibraryEClass, SECURITY_SCHEME_LIBRARY__NAME);

		realizationContainerEClass = createEClass(REALIZATION_CONTAINER);
		createEAttribute(realizationContainerEClass, REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION);
		createEReference(realizationContainerEClass, REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION);
		createEReference(realizationContainerEClass, REALIZATION_CONTAINER__PROPERTIES);
		createEReference(realizationContainerEClass, REALIZATION_CONTAINER__REFERENCE_TREATMENTS);
		createEReference(realizationContainerEClass, REALIZATION_CONTAINER__DATA_TYPE);
		createEAttribute(realizationContainerEClass, REALIZATION_CONTAINER__REALIZATION_NAME);
		createEAttribute(realizationContainerEClass, REALIZATION_CONTAINER__EFFECTIVE_REALIZATION);

		extensibleEClass = createEClass(EXTENSIBLE);
		createEReference(extensibleEClass, EXTENSIBLE__EXTENSIONS);

		extensionEClass = createEClass(EXTENSION);
		createEAttribute(extensionEClass, EXTENSION__NAME);
		createEAttribute(extensionEClass, EXTENSION__VALUE);

		realizationModelLocationEClass = createEClass(REALIZATION_MODEL_LOCATION);
		createEAttribute(realizationModelLocationEClass, REALIZATION_MODEL_LOCATION__URI);

		hasTitleEClass = createEClass(HAS_TITLE);
		createEAttribute(hasTitleEClass, HAS_TITLE__TITLE);

		operationEClass = createEClass(OPERATION);
		createEAttribute(operationEClass, OPERATION__NAME);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__NAME);
		createEReference(featureEClass, FEATURE__CONTAINING_DATA_TYPE);
		createEAttribute(featureEClass, FEATURE__RESTRICTION);
		createEAttribute(featureEClass, FEATURE__READ_ONLY);
		createEAttribute(featureEClass, FEATURE__KEY);

		referencePropertyEClass = createEClass(REFERENCE_PROPERTY);
		createEReference(referencePropertyEClass, REFERENCE_PROPERTY__TYPE);
		createEReference(referencePropertyEClass, REFERENCE_PROPERTY__INVERSE);
		createEAttribute(referencePropertyEClass, REFERENCE_PROPERTY__CONTAINMENT);
		createEAttribute(referencePropertyEClass, REFERENCE_PROPERTY__CONTAINER);

		primitivePropertyEClass = createEClass(PRIMITIVE_PROPERTY);
		createEReference(primitivePropertyEClass, PRIMITIVE_PROPERTY__TYPE);

		structureEClass = createEClass(STRUCTURE);
		createEReference(structureEClass, STRUCTURE__OWNED_FEATURES);
		createEReference(structureEClass, STRUCTURE__OWNED_ELEMENTS);
		createEReference(structureEClass, STRUCTURE__OWNED_OPERATIONS);
		createEReference(structureEClass, STRUCTURE__SUPERTYPES);
		createEReference(structureEClass, STRUCTURE__ALL_SUPERTYPES);

		dataModelEClass = createEClass(DATA_MODEL);
		createEReference(dataModelEClass, DATA_MODEL__OWNED_DATA_TYPES);
		createEAttribute(dataModelEClass, DATA_MODEL__NAME);

		withDataExamplesEClass = createEClass(WITH_DATA_EXAMPLES);
		createEReference(withDataExamplesEClass, WITH_DATA_EXAMPLES__DATA_EXAMPLES);

		dataExampleEClass = createEClass(DATA_EXAMPLE);

		inlineDataExampleEClass = createEClass(INLINE_DATA_EXAMPLE);
		createEAttribute(inlineDataExampleEClass, INLINE_DATA_EXAMPLE__BODY);

		constraintEClass = createEClass(CONSTRAINT);

		enumerationEClass = createEClass(ENUMERATION);
		createEReference(enumerationEClass, ENUMERATION__ENUM_CONSTANTS);
		createEReference(enumerationEClass, ENUMERATION__BASE_TYPE);

		simpleTypeEClass = createEClass(SIMPLE_TYPE);

		enumConstantEClass = createEClass(ENUM_CONSTANT);
		createEAttribute(enumConstantEClass, ENUM_CONSTANT__NAME);
		createEAttribute(enumConstantEClass, ENUM_CONSTANT__INTEGER_VALUE);
		createEAttribute(enumConstantEClass, ENUM_CONSTANT__LITERAL_VALUE);
		createEReference(enumConstantEClass, ENUM_CONSTANT__ENUMERATION);

		userDefinedTypeEClass = createEClass(USER_DEFINED_TYPE);
		createEReference(userDefinedTypeEClass, USER_DEFINED_TYPE__BASE_TYPE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__NAME);

		singleValueTypeEClass = createEClass(SINGLE_VALUE_TYPE);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__CARDINALITY);

		referenceElementEClass = createEClass(REFERENCE_ELEMENT);
		createEReference(referenceElementEClass, REFERENCE_ELEMENT__DATA_TYPE);

		lengthConstraintEClass = createEClass(LENGTH_CONSTRAINT);
		createEAttribute(lengthConstraintEClass, LENGTH_CONSTRAINT__MIN_LENGTH);
		createEAttribute(lengthConstraintEClass, LENGTH_CONSTRAINT__MAX_LENGTH);
		createEAttribute(lengthConstraintEClass, LENGTH_CONSTRAINT__LENGTH);

		regExConstraintEClass = createEClass(REG_EX_CONSTRAINT);
		createEAttribute(regExConstraintEClass, REG_EX_CONSTRAINT__PATTERN);

		valueRangeConstraintEClass = createEClass(VALUE_RANGE_CONSTRAINT);
		createEAttribute(valueRangeConstraintEClass, VALUE_RANGE_CONSTRAINT__MIN_VALUE);
		createEAttribute(valueRangeConstraintEClass, VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE);
		createEAttribute(valueRangeConstraintEClass, VALUE_RANGE_CONSTRAINT__MAX_VALUE);
		createEAttribute(valueRangeConstraintEClass, VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE);

		constrainableTypeEClass = createEClass(CONSTRAINABLE_TYPE);
		createEReference(constrainableTypeEClass, CONSTRAINABLE_TYPE__CONSTRAINTS);

		inheritableEClass = createEClass(INHERITABLE);

		mediaTypesLibraryEClass = createEClass(MEDIA_TYPES_LIBRARY);
		createEReference(mediaTypesLibraryEClass, MEDIA_TYPES_LIBRARY__MEDIA_TYPES);

		linkRelationsLibraryEClass = createEClass(LINK_RELATIONS_LIBRARY);
		createEReference(linkRelationsLibraryEClass, LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS);
		createEAttribute(linkRelationsLibraryEClass, LINK_RELATIONS_LIBRARY__NAME);

		primitiveTypesLibraryEClass = createEClass(PRIMITIVE_TYPES_LIBRARY);
		createEAttribute(primitiveTypesLibraryEClass, PRIMITIVE_TYPES_LIBRARY__NAME);
		createEReference(primitiveTypesLibraryEClass, PRIMITIVE_TYPES_LIBRARY__PRIMITIVE_TYPES);

		// Create enums
		httpMethodsEEnum = createEEnum(HTTP_METHODS);
		referenceRealizationEnumEEnum = createEEnum(REFERENCE_REALIZATION_ENUM);
		httpMessageParameterLocationEEnum = createEEnum(HTTP_MESSAGE_PARAMETER_LOCATION);
		collectionRealizationEnumEEnum = createEEnum(COLLECTION_REALIZATION_ENUM);
		authenticationTypesEEnum = createEEnum(AUTHENTICATION_TYPES);
		authenticationFlowsEEnum = createEEnum(AUTHENTICATION_FLOWS);
		collectionRealizationLevelEnumEEnum = createEEnum(COLLECTION_REALIZATION_LEVEL_ENUM);

		// Create data types
		realizationModelEDataType = createEDataType(REALIZATION_MODEL);
		collectionRealizationLevelObjectEDataType = createEDataType(COLLECTION_REALIZATION_LEVEL_OBJECT);
		effectiveRealizationEDataType = createEDataType(EFFECTIVE_REALIZATION);
		cardinalityEDataType = createEDataType(CARDINALITY);
		cardinalityOverrideEDataType = createEDataType(CARDINALITY_OVERRIDE);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isInitialized = false;

    /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		resourceDefinitionEClass.getESuperTypes().add(this.getRESTElement());
		resourceDefinitionEClass.getESuperTypes().add(this.getWithExamples());
		resourceDefinitionEClass.getESuperTypes().add(this.getHasSecurityValue());
		typedMessageEClass.getESuperTypes().add(this.getRealizationContainer());
		typedMessageEClass.getESuperTypes().add(this.getRESTElement());
		typedMessageEClass.getESuperTypes().add(this.getWithExamples());
		methodEClass.getESuperTypes().add(this.getRESTElement());
		methodEClass.getESuperTypes().add(this.getHasSecurityValue());
		methodEClass.getESuperTypes().add(this.getExtensible());
		parameterEClass.getESuperTypes().add(this.getRESTElement());
		parameterEClass.getESuperTypes().add(this.getExtensible());
		restElementEClass.getESuperTypes().add(this.getDocumentable());
		restElementEClass.getESuperTypes().add(this.getExtensible());
		mediaTypeEClass.getESuperTypes().add(this.getRESTElement());
		typedRequestEClass.getESuperTypes().add(this.getTypedMessage());
		typedResponseEClass.getESuperTypes().add(this.getTypedMessage());
		uriParameterEClass.getESuperTypes().add(this.getParameter());
		matrixParameterEClass.getESuperTypes().add(this.getURIParameter());
		templateParameterEClass.getESuperTypes().add(this.getURIParameter());
		collectionResourceEClass.getESuperTypes().add(this.getServiceDataResource());
		objectResourceEClass.getESuperTypes().add(this.getServiceDataResource());
		collectionParameterEClass.getESuperTypes().add(this.getParameter());
		propertyReferenceEClass.getESuperTypes().add(this.getSourceReference());
		messageParameterEClass.getESuperTypes().add(this.getParameter());
		zenModelEClass.getESuperTypes().add(this.getDocumentable());
		zenModelEClass.getESuperTypes().add(this.getExtensible());
		zenModelEClass.getESuperTypes().add(this.getHasTitle());
		resourceAPIEClass.getESuperTypes().add(this.getRESTElement());
		resourceAPIEClass.getESuperTypes().add(this.getHasSecurityValue());
		resourceAPIEClass.getESuperTypes().add(this.getHasTitle());
		serviceDataResourceEClass.getESuperTypes().add(this.getRealizationContainer());
		serviceDataResourceEClass.getESuperTypes().add(this.getResourceDefinition());
		referenceTreatmentEClass.getESuperTypes().add(this.getExtensible());
		referenceRealizationEClass.getESuperTypes().add(this.getRealizationContainer());
		referenceLinkEClass.getESuperTypes().add(this.getReferenceTreatment());
		referenceEmbedEClass.getESuperTypes().add(this.getReferenceTreatment());
		namedLinkDescriptorEClass.getESuperTypes().add(this.getObjectRealization());
		primitiveTypeSourceReferenceEClass.getESuperTypes().add(this.getSourceReference());
		uriEClass.getESuperTypes().add(this.getHasStringValue());
		uriSegmentEClass.getESuperTypes().add(this.getHasStringValue());
		uriSegmentWithParameterEClass.getESuperTypes().add(this.getURISegment());
		propertyRealizationEClass.getESuperTypes().add(this.getConstrainableType());
		linkRelationEClass.getESuperTypes().add(this.getDocumentable());
		inlineExampleEClass.getESuperTypes().add(this.getExample());
		externalExampleEClass.getESuperTypes().add(this.getExample());
		objectRealizationEClass.getESuperTypes().add(this.getExtensible());
		collectionReferenceElementEClass.getESuperTypes().add(this.getReferenceElement());
		securitySchemeEClass.getESuperTypes().add(this.getDocumentable());
		securitySchemeEClass.getESuperTypes().add(this.getRESTElement());
		securityScopeEClass.getESuperTypes().add(this.getDocumentable());
		securitySchemeParameterEClass.getESuperTypes().add(this.getDocumentable());
		securitySchemeLibraryEClass.getESuperTypes().add(this.getDocumentable());
		realizationContainerEClass.getESuperTypes().add(this.getExtensible());
		operationEClass.getESuperTypes().add(this.getDocumentable());
		featureEClass.getESuperTypes().add(this.getDocumentable());
		featureEClass.getESuperTypes().add(this.getElement());
		featureEClass.getESuperTypes().add(this.getExtensible());
		referencePropertyEClass.getESuperTypes().add(this.getFeature());
		referencePropertyEClass.getESuperTypes().add(this.getReferenceElement());
		primitivePropertyEClass.getESuperTypes().add(this.getFeature());
		primitivePropertyEClass.getESuperTypes().add(this.getHasStringValue());
		primitivePropertyEClass.getESuperTypes().add(this.getConstrainableType());
		structureEClass.getESuperTypes().add(this.getDataType());
		structureEClass.getESuperTypes().add(this.getWithDataExamples());
		structureEClass.getESuperTypes().add(this.getInheritable());
		dataModelEClass.getESuperTypes().add(this.getDocumentable());
		dataModelEClass.getESuperTypes().add(this.getHasTitle());
		inlineDataExampleEClass.getESuperTypes().add(this.getDataExample());
		constraintEClass.getESuperTypes().add(this.getExtensible());
		enumerationEClass.getESuperTypes().add(this.getSingleValueType());
		simpleTypeEClass.getESuperTypes().add(this.getSingleValueType());
		enumConstantEClass.getESuperTypes().add(this.getDocumentable());
		userDefinedTypeEClass.getESuperTypes().add(this.getSimpleType());
		userDefinedTypeEClass.getESuperTypes().add(this.getConstrainableType());
		primitiveTypeEClass.getESuperTypes().add(this.getSimpleType());
		dataTypeEClass.getESuperTypes().add(this.getDocumentable());
		dataTypeEClass.getESuperTypes().add(this.getExtensible());
		singleValueTypeEClass.getESuperTypes().add(this.getDataType());
		referenceElementEClass.getESuperTypes().add(this.getElement());
		lengthConstraintEClass.getESuperTypes().add(this.getConstraint());
		regExConstraintEClass.getESuperTypes().add(this.getConstraint());
		valueRangeConstraintEClass.getESuperTypes().add(this.getConstraint());
		constrainableTypeEClass.getESuperTypes().add(this.getExtensible());

		// Initialize classes and features; add operations and parameters
		initEClass(resourceDefinitionEClass, ResourceDefinition.class, "ResourceDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceDefinition_Methods(), this.getMethod(), this.getMethod_ContainingResourceDefinition(), "methods", null, 0, -1, ResourceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDefinition_MediaTypes(), this.getMediaType(), null, "mediaTypes", null, 0, -1, ResourceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResourceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDefinition_AllMediaTypes(), this.getMediaType(), null, "allMediaTypes", null, 0, -1, ResourceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDefinition_URI(), this.getURI(), null, "URI", null, 0, 1, ResourceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedMessageEClass, TypedMessage.class, "TypedMessage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedMessage_Parameters(), this.getMessageParameter(), this.getMessageParameter_ContainingMessage(), "parameters", null, 0, -1, TypedMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedMessage_ResourceType(), this.getResourceDefinition(), null, "resourceType", null, 0, 1, TypedMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedMessage_UseParentTypeReference(), ecorePackage.getEBoolean(), "useParentTypeReference", null, 0, 1, TypedMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedMessage_MediaTypes(), this.getMediaType(), null, "mediaTypes", null, 0, -1, TypedMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(typedMessageEClass, this.getExample(), "getAllExamples", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(typedMessageEClass, ecorePackage.getEBoolean(), "isIncluded", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFeature(), "feature", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(typedMessageEClass, this.getPropertyRealization(), "getIncludedProperties", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(typedMessageEClass, this.getStructure(), "getActualType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(typedMessageEClass, this.getReferenceLink(), "getReferenceLinks", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethod_Request(), this.getTypedRequest(), this.getTypedRequest_ContainingMethod(), "request", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Responses(), this.getTypedResponse(), this.getTypedResponse_ContainingMethod(), "responses", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_Id(), ecorePackage.getEString(), "id", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_HttpMethod(), this.getHTTPMethods(), "httpMethod", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_ContainingResourceDefinition(), this.getResourceDefinition(), this.getResourceDefinition_Methods(), "containingResourceDefinition", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(methodEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Default(), ecorePackage.getEString(), "default", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Fixed(), ecorePackage.getEString(), "fixed", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_SourceReference(), this.getSourceReference(), this.getSourceReference_ContainingParameter(), "sourceReference", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(parameterEClass, this.getSingleValueType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(parameterEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(parameterEClass, this.getConstraint(), "getConstraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(restElementEClass, RESTElement.class, "RESTElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(documentationEClass, Documentation.class, "Documentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentation_Text(), ecorePackage.getEString(), "text", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentableEClass, Documentable.class, "Documentable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocumentable_Documentation(), this.getDocumentation(), null, "documentation", null, 0, 1, Documentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediaTypeEClass, MediaType.class, "MediaType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediaType_Name(), ecorePackage.getEString(), "name", null, 0, 1, MediaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaType_SpecURL(), ecorePackage.getEString(), "specURL", null, 0, 1, MediaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediaType_DerivedFrom(), this.getMediaType(), null, "derivedFrom", null, 0, -1, MediaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mediaTypeEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mediaTypeEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typedRequestEClass, TypedRequest.class, "TypedRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedRequest_ContainingMethod(), this.getMethod(), this.getMethod_Request(), "containingMethod", null, 0, 1, TypedRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedResponseEClass, TypedResponse.class, "TypedResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypedResponse_StatusCode(), ecorePackage.getEInt(), "statusCode", "-1", 0, 1, TypedResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedResponse_ContainingMethod(), this.getMethod(), this.getMethod_Responses(), "containingMethod", null, 0, 1, TypedResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uriParameterEClass, URIParameter.class, "URIParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURIParameter_UriSegment(), this.getURISegmentWithParameter(), null, "uriSegment", null, 0, 1, URIParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURIParameter_ContainingURI(), this.getURI(), this.getURI_UriParameters(), "containingURI", null, 0, 1, URIParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(uriParameterEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(matrixParameterEClass, MatrixParameter.class, "MatrixParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateParameterEClass, TemplateParameter.class, "TemplateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionResourceEClass, CollectionResource.class, "CollectionResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionResource_CollectionParameters(), this.getCollectionParameter(), this.getCollectionParameter_ContainingResourceDefinition(), "collectionParameters", null, 0, -1, CollectionResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionResource_ReferenceElements(), this.getCollectionReferenceElement(), null, "referenceElements", null, 0, -1, CollectionResource.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionResource_ResourceRealizationKind(), this.getCollectionRealizationEnum(), "resourceRealizationKind", null, 0, 1, CollectionResource.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectResourceEClass, ObjectResource.class, "ObjectResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionParameterEClass, CollectionParameter.class, "CollectionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionParameter_ContainingResourceDefinition(), this.getCollectionResource(), this.getCollectionResource_CollectionParameters(), "containingResourceDefinition", null, 0, 1, CollectionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyReferenceEClass, PropertyReference.class, "PropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyReference_ConceptualFeature(), this.getPrimitiveProperty(), null, "conceptualFeature", null, 0, 1, PropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(propertyReferenceEClass, this.getSingleValueType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(propertyReferenceEClass, this.getConstraint(), "getConstraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(sourceReferenceEClass, SourceReference.class, "SourceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceReference_ContainingParameter(), this.getParameter(), this.getParameter_SourceReference(), "containingParameter", null, 0, 1, SourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(sourceReferenceEClass, this.getSingleValueType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sourceReferenceEClass, this.getConstraint(), "getConstraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sourceReferenceEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(messageParameterEClass, MessageParameter.class, "MessageParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageParameter_ContainingMessage(), this.getTypedMessage(), this.getTypedMessage_Parameters(), "containingMessage", null, 0, 1, MessageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageParameter_HttpLocation(), this.getHttpMessageParameterLocation(), "httpLocation", null, 0, 1, MessageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(zenModelEClass, ZenModel.class, "ZenModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getZenModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZenModel_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_ResourceAPIs(), this.getResourceAPI(), null, "resourceAPIs", null, 0, -1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_DataModels(), this.getDataModel(), null, "dataModels", null, 0, -1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_MediaTypesLibrary(), this.getMediaTypesLibrary(), null, "mediaTypesLibrary", null, 0, 1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_LinkRelationsLibrary(), this.getLinkRelationsLibrary(), null, "linkRelationsLibrary", null, 0, 1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_PrimitiveTypesLibrary(), this.getPrimitiveTypesLibrary(), null, "primitiveTypesLibrary", null, 0, 1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_Imports(), this.getImportDeclaration(), null, "imports", null, 0, -1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZenModel_SecuritySchemesLibrary(), this.getSecuritySchemeLibrary(), null, "securitySchemesLibrary", null, 0, 1, ZenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceAPIEClass, ResourceAPI.class, "ResourceAPI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceAPI_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceAPI_Version(), ecorePackage.getEString(), "version", null, 0, 1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceAPI_BaseURI(), ecorePackage.getEString(), "baseURI", null, 0, 1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_OwnedResourceDefinitions(), this.getResourceDefinition(), null, "ownedResourceDefinitions", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_ServiceDataModels(), this.getDataModel(), null, "serviceDataModels", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_Formats(), this.getMediaType(), null, "formats", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_DefinedMediaTypes(), this.getMediaType(), null, "definedMediaTypes", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_DefinedLinkRelations(), this.getLinkRelation(), null, "definedLinkRelations", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_DefaultReferenceRealizations(), this.getReferenceRealization(), null, "defaultReferenceRealizations", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAPI_AutoRealizations(), this.getRealizationModelLocation(), null, "autoRealizations", null, 0, -1, ResourceAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceDataResourceEClass, ServiceDataResource.class, "ServiceDataResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceDataResource_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, ServiceDataResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceDataResource_DefinedLinkDescriptors(), this.getNamedLinkDescriptor(), null, "definedLinkDescriptors", null, 0, -1, ServiceDataResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(serviceDataResourceEClass, this.getNamedLinkDescriptor(), "getDefaultLinkDescriptor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(serviceDataResourceEClass, ecorePackage.getEBoolean(), "isIncluded", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFeature(), "feature", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(serviceDataResourceEClass, this.getReferenceLink(), "getReferenceLinks", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(serviceDataResourceEClass, this.getReferenceTreatment(), "getAllReferenceTreatments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(serviceDataResourceEClass, this.getPropertyRealization(), "getIncludedProperties", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceTreatmentEClass, ReferenceTreatment.class, "ReferenceTreatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceTreatment_ReferenceElement(), this.getReferenceElement(), null, "referenceElement", null, 0, 1, ReferenceTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceTreatment_ReferenceRealization(), this.getReferenceRealization(), null, "referenceRealization", null, 0, 1, ReferenceTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceTreatment_OwnedReferenceRealization(), this.getReferenceRealization(), null, "ownedReferenceRealization", null, 0, 1, ReferenceTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(referenceTreatmentEClass, this.getReferenceEmbed(), "getEmbedHierarchy", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(referenceTreatmentEClass, this.getObjectRealization(), "getLinkDescriptor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceRealizationEClass, ReferenceRealization.class, "ReferenceRealization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceRealization_TargetResource(), this.getResourceDefinition(), null, "targetResource", null, 0, 1, ReferenceRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceRealization_RealizationType(), this.getReferenceRealizationEnum(), "realizationType", null, 0, 1, ReferenceRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceRealization_MultiValued(), ecorePackage.getEBoolean(), "multiValued", "false", 0, 1, ReferenceRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(referenceRealizationEClass, this.getObjectRealization(), "getLinkDescriptor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceLinkEClass, ReferenceLink.class, "ReferenceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceLink_Name(), ecorePackage.getEString(), "name", null, 0, 1, ReferenceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceLink_LinkRelation(), this.getLinkRelation(), null, "linkRelation", null, 0, 1, ReferenceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceLink_CollectionRealizationLevel(), this.getCollectionRealizationLevelObject(), "collectionRealizationLevel", null, 0, 1, ReferenceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(referenceLinkEClass, this.getResourceDefinition(), "getTargetResource", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceEmbedEClass, ReferenceEmbed.class, "ReferenceEmbed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(referenceEmbedEClass, this.getReferenceTreatment(), "getAllNestedReferenceTreatments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(referenceEmbedEClass, this.getReferenceTreatment(), "getNestedReferenceTreatments", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedLinkDescriptorEClass, NamedLinkDescriptor.class, "NamedLinkDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedLinkDescriptor_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedLinkDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedLinkDescriptor_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, NamedLinkDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathSegmentEClass, PathSegment.class, "PathSegment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathSegment_ReferenceElement(), this.getReferenceElement(), null, "referenceElement", null, 0, 1, PathSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeSourceReferenceEClass, PrimitiveTypeSourceReference.class, "PrimitiveTypeSourceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveTypeSourceReference_SimpleType(), this.getPrimitiveType(), null, "simpleType", null, 0, 1, PrimitiveTypeSourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(primitiveTypeSourceReferenceEClass, this.getSingleValueType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(primitiveTypeSourceReferenceEClass, this.getConstraint(), "getConstraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(uriEClass, com.reprezen.rapidml.URI.class, "URI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURI_Segments(), this.getURISegment(), null, "segments", null, 1, -1, com.reprezen.rapidml.URI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURI_UriParameters(), this.getURIParameter(), this.getURIParameter_ContainingURI(), "uriParameters", null, 0, -1, com.reprezen.rapidml.URI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uriSegmentEClass, URISegment.class, "URISegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getURISegment_Name(), ecorePackage.getEString(), "name", null, 0, 1, URISegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uriSegmentWithParameterEClass, URISegmentWithParameter.class, "URISegmentWithParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyRealizationEClass, PropertyRealization.class, "PropertyRealization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyRealization_BaseProperty(), this.getFeature(), null, "baseProperty", null, 1, 1, PropertyRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyRealization_Cardinality(), this.getCardinalityOverride(), "cardinality", null, 0, 1, PropertyRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(propertyRealizationEClass, ecorePackage.getEInt(), "getMinOccurs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(propertyRealizationEClass, ecorePackage.getEInt(), "getMaxOccurs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(propertyRealizationEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(linkRelationEClass, LinkRelation.class, "LinkRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkRelation_Name(), ecorePackage.getEString(), "name", null, 0, 1, LinkRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkRelation_SpecURL(), ecorePackage.getEString(), "specURL", null, 0, 1, LinkRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withExamplesEClass, WithExamples.class, "WithExamples", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWithExamples_Examples(), this.getExample(), null, "examples", null, 0, -1, WithExamples.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleEClass, Example.class, "Example", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(exampleEClass, ecorePackage.getEString(), "getBody", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inlineExampleEClass, InlineExample.class, "InlineExample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInlineExample_Body(), ecorePackage.getEString(), "body", null, 1, 1, InlineExample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalExampleEClass, ExternalExample.class, "ExternalExample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalExample_Path(), ecorePackage.getEString(), "path", null, 1, 1, ExternalExample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(externalExampleEClass, ecorePackage.getEString(), "getBody", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hasStringValueEClass, HasStringValue.class, "HasStringValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(hasStringValueEClass, ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(importDeclarationEClass, ImportDeclaration.class, "ImportDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportDeclaration_ImportURI(), ecorePackage.getEString(), "importURI", null, 1, 1, ImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImportDeclaration_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImportDeclaration_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportDeclaration_ImportedModel(), this.getZenModel(), null, "importedModel", null, 0, 1, ImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectRealizationEClass, ObjectRealization.class, "ObjectRealization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectRealization_ExclusivePropertyList(), this.getPropertyRealization(), null, "exclusivePropertyList", null, 0, -1, ObjectRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectRealization_OverriddenPropertyList(), this.getPropertyRealization(), null, "overriddenPropertyList", null, 0, -1, ObjectRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectRealization_ExcludedProperties(), this.getFeature(), null, "excludedProperties", null, 0, -1, ObjectRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectRealization_RealizationContainer(), this.getRealizationContainer(), this.getRealizationContainer_InlineObjectRealization(), "realizationContainer", null, 0, 1, ObjectRealization.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(objectRealizationEClass, this.getStructure(), "getDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(objectRealizationEClass, this.getPropertyRealization(), "getAllIncludedProperties", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(collectionReferenceElementEClass, CollectionReferenceElement.class, "CollectionReferenceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(collectionReferenceElementEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hasSecurityValueEClass, HasSecurityValue.class, "HasSecurityValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHasSecurityValue_SecuredBy(), this.getAuthenticationMethod(), null, "securedBy", null, 0, -1, HasSecurityValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securitySchemeEClass, SecurityScheme.class, "SecurityScheme", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecurityScheme_Name(), ecorePackage.getEString(), "name", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecurityScheme_Type(), this.getAuthenticationTypes(), "type", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityScheme_Scopes(), this.getSecurityScope(), null, "scopes", null, 0, -1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityScheme_Settings(), this.getSecuritySchemeParameter(), null, "settings", null, 0, -1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityScheme_Parameters(), this.getMessageParameter(), null, "parameters", null, 0, -1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityScheme_ErrorResponses(), this.getTypedResponse(), null, "errorResponses", null, 0, -1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecurityScheme_Flow(), this.getAuthenticationFlows(), "flow", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(authenticationMethodEClass, AuthenticationMethod.class, "AuthenticationMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAuthenticationMethod_Scheme(), this.getSecurityScheme(), null, "scheme", null, 1, 1, AuthenticationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuthenticationMethod_Scopes(), this.getSecurityScope(), null, "scopes", null, 0, -1, AuthenticationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securityScopeEClass, SecurityScope.class, "SecurityScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecurityScope_Name(), ecorePackage.getEString(), "name", null, 0, 1, SecurityScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securitySchemeParameterEClass, SecuritySchemeParameter.class, "SecuritySchemeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecuritySchemeParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, SecuritySchemeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecuritySchemeParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, SecuritySchemeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securitySchemeLibraryEClass, SecuritySchemeLibrary.class, "SecuritySchemeLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSecuritySchemeLibrary_SecuritySchemes(), this.getSecurityScheme(), null, "securitySchemes", null, 0, -1, SecuritySchemeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecuritySchemeLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, SecuritySchemeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realizationContainerEClass, RealizationContainer.class, "RealizationContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealizationContainer_WithDefaultRealization(), ecorePackage.getEBoolean(), "withDefaultRealization", null, 0, 1, RealizationContainer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealizationContainer_InlineObjectRealization(), this.getObjectRealization(), this.getObjectRealization_RealizationContainer(), "inlineObjectRealization", null, 0, 1, RealizationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealizationContainer_Properties(), this.getObjectRealization(), null, "properties", null, 0, 1, RealizationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealizationContainer_ReferenceTreatments(), this.getReferenceTreatment(), null, "referenceTreatments", null, 0, -1, RealizationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealizationContainer_DataType(), this.getStructure(), null, "dataType", null, 0, 1, RealizationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealizationContainer_RealizationName(), ecorePackage.getEString(), "realizationName", null, 0, 1, RealizationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealizationContainer_EffectiveRealization(), this.getEffectiveRealization(), "effectiveRealization", null, 0, 1, RealizationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(realizationContainerEClass, this.getStructure(), "getActualType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(extensibleEClass, Extensible.class, "Extensible", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensible_Extensions(), this.getExtension(), null, "extensions", null, 0, -1, Extensible.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionEClass, Extension.class, "Extension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtension_Name(), ecorePackage.getEString(), "name", null, 0, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtension_Value(), ecorePackage.getEString(), "value", null, 0, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realizationModelLocationEClass, RealizationModelLocation.class, "RealizationModelLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealizationModelLocation_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, RealizationModelLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(realizationModelLocationEClass, this.getRealizationModel(), "getRealizationModel", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hasTitleEClass, HasTitle.class, "HasTitle", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHasTitle_Title(), ecorePackage.getEString(), "title", null, 0, 1, HasTitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_ContainingDataType(), this.getStructure(), this.getStructure_OwnedFeatures(), "containingDataType", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Restriction(), ecorePackage.getEBoolean(), "restriction", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Key(), ecorePackage.getEBoolean(), "key", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(featureEClass, ecorePackage.getEInt(), "getMinOccurs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureEClass, ecorePackage.getEInt(), "getMaxOccurs", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referencePropertyEClass, ReferenceProperty.class, "ReferenceProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceProperty_Type(), this.getStructure(), null, "type", null, 1, 1, ReferenceProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceProperty_Inverse(), this.getReferenceProperty(), null, "inverse", null, 0, 1, ReferenceProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceProperty_Containment(), ecorePackage.getEBoolean(), "containment", null, 0, 1, ReferenceProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceProperty_Container(), ecorePackage.getEBoolean(), "container", null, 0, 1, ReferenceProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitivePropertyEClass, PrimitiveProperty.class, "PrimitiveProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveProperty_Type(), this.getSingleValueType(), null, "type", null, 1, 1, PrimitiveProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(primitivePropertyEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructure_OwnedFeatures(), this.getFeature(), this.getFeature_ContainingDataType(), "ownedFeatures", null, 0, -1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_OwnedElements(), this.getStructure(), null, "ownedElements", null, 0, -1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_OwnedOperations(), this.getOperation(), null, "ownedOperations", null, 0, -1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_Supertypes(), this.getInheritable(), null, "supertypes", null, 0, -1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_AllSupertypes(), this.getInheritable(), null, "allSupertypes", null, 0, -1, Structure.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(structureEClass, this.getReferenceProperty(), "getReferenceProperties", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(structureEClass, this.getPrimitiveProperty(), "getPrimitiveProperties", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(structureEClass, this.getPrimitiveProperty(), "getAllPrimitiveProperties", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataModelEClass, DataModel.class, "DataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataModel_OwnedDataTypes(), this.getDataType(), null, "ownedDataTypes", null, 0, -1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withDataExamplesEClass, WithDataExamples.class, "WithDataExamples", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWithDataExamples_DataExamples(), this.getDataExample(), null, "dataExamples", null, 0, -1, WithDataExamples.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataExampleEClass, DataExample.class, "DataExample", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inlineDataExampleEClass, InlineDataExample.class, "InlineDataExample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInlineDataExample_Body(), ecorePackage.getEString(), "body", null, 1, 1, InlineDataExample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(constraintEClass, ecorePackage.getEBoolean(), "supports", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSimpleType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeration_EnumConstants(), this.getEnumConstant(), this.getEnumConstant_Enumeration(), "enumConstants", null, 0, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumeration_BaseType(), this.getPrimitiveType(), null, "baseType", null, 1, 1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(enumerationEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simpleTypeEClass, SimpleType.class, "SimpleType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumConstantEClass, EnumConstant.class, "EnumConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumConstant_Name(), ecorePackage.getEString(), "name", null, 1, 1, EnumConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumConstant_IntegerValue(), ecorePackage.getEInt(), "integerValue", null, 0, 1, EnumConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumConstant_LiteralValue(), ecorePackage.getEString(), "literalValue", null, 0, 1, EnumConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumConstant_Enumeration(), this.getEnumeration(), this.getEnumeration_EnumConstants(), "enumeration", null, 0, 1, EnumConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(enumConstantEClass, ecorePackage.getEInt(), "getImplicitIntegerValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userDefinedTypeEClass, UserDefinedType.class, "UserDefinedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDefinedType_BaseType(), this.getSimpleType(), null, "baseType", null, 1, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(userDefinedTypeEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(primitiveTypeEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataType_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleValueTypeEClass, SingleValueType.class, "SingleValueType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(singleValueTypeEClass, this.getPrimitiveType(), "getPrimitiveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Cardinality(), this.getCardinality(), "cardinality", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(elementEClass, ecorePackage.getEInt(), "getMinOccurs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(elementEClass, ecorePackage.getEInt(), "getMaxOccurs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(elementEClass, this.getStructure(), "getDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(elementEClass, ecorePackage.getEBoolean(), "isMultiValued", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceElementEClass, ReferenceElement.class, "ReferenceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceElement_DataType(), this.getStructure(), null, "dataType", null, 0, 1, ReferenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(referenceElementEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(lengthConstraintEClass, LengthConstraint.class, "LengthConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLengthConstraint_MinLength(), ecorePackage.getEInt(), "minLength", null, 0, 1, LengthConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLengthConstraint_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1, LengthConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLengthConstraint_Length(), ecorePackage.getEInt(), "length", null, 0, 1, LengthConstraint.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(regExConstraintEClass, RegExConstraint.class, "RegExConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegExConstraint_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, RegExConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueRangeConstraintEClass, ValueRangeConstraint.class, "ValueRangeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueRangeConstraint_MinValue(), ecorePackage.getEString(), "minValue", null, 0, 1, ValueRangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueRangeConstraint_MinValueExclusive(), ecorePackage.getEBoolean(), "minValueExclusive", null, 0, 1, ValueRangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueRangeConstraint_MaxValue(), ecorePackage.getEString(), "maxValue", null, 0, 1, ValueRangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueRangeConstraint_MaxValueExclusive(), ecorePackage.getEBoolean(), "maxValueExclusive", null, 0, 1, ValueRangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constrainableTypeEClass, ConstrainableType.class, "ConstrainableType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainableType_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1, ConstrainableType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(constrainableTypeEClass, this.getConstrainableType(), "getConstrainableParent", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(constrainableTypeEClass, this.getConstraint(), "getAllConstraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(inheritableEClass, Inheritable.class, "Inheritable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mediaTypesLibraryEClass, MediaTypesLibrary.class, "MediaTypesLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMediaTypesLibrary_MediaTypes(), this.getMediaType(), null, "mediaTypes", null, 1, -1, MediaTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkRelationsLibraryEClass, LinkRelationsLibrary.class, "LinkRelationsLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkRelationsLibrary_DefinedLinkRelations(), this.getLinkRelation(), null, "definedLinkRelations", null, 0, -1, LinkRelationsLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkRelationsLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, LinkRelationsLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypesLibraryEClass, PrimitiveTypesLibrary.class, "PrimitiveTypesLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTypesLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrimitiveTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveTypesLibrary_PrimitiveTypes(), this.getPrimitiveType(), null, "primitiveTypes", null, 0, -1, PrimitiveTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(httpMethodsEEnum, HTTPMethods.class, "HTTPMethods");
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.GET);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.PUT);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.POST);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.DELETE);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.HEAD);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.PATCH);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.TRACE);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.OPTIONS);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.CONNECT);

		initEEnum(referenceRealizationEnumEEnum, ReferenceRealizationEnum.class, "ReferenceRealizationEnum");
		addEEnumLiteral(referenceRealizationEnumEEnum, ReferenceRealizationEnum.EMBED);
		addEEnumLiteral(referenceRealizationEnumEEnum, ReferenceRealizationEnum.LINK);

		initEEnum(httpMessageParameterLocationEEnum, HttpMessageParameterLocation.class, "HttpMessageParameterLocation");
		addEEnumLiteral(httpMessageParameterLocationEEnum, HttpMessageParameterLocation.NONE);
		addEEnumLiteral(httpMessageParameterLocationEEnum, HttpMessageParameterLocation.QUERY);
		addEEnumLiteral(httpMessageParameterLocationEEnum, HttpMessageParameterLocation.HEADER);

		initEEnum(collectionRealizationEnumEEnum, CollectionRealizationEnum.class, "CollectionRealizationEnum");
		addEEnumLiteral(collectionRealizationEnumEEnum, CollectionRealizationEnum.EMBEDDED_OBJECT_LIST);
		addEEnumLiteral(collectionRealizationEnumEEnum, CollectionRealizationEnum.REFERENCE_LINK_LIST);

		initEEnum(authenticationTypesEEnum, AuthenticationTypes.class, "AuthenticationTypes");
		addEEnumLiteral(authenticationTypesEEnum, AuthenticationTypes.BASIC);
		addEEnumLiteral(authenticationTypesEEnum, AuthenticationTypes.OAUTH2);
		addEEnumLiteral(authenticationTypesEEnum, AuthenticationTypes.CUSTOM);

		initEEnum(authenticationFlowsEEnum, AuthenticationFlows.class, "AuthenticationFlows");
		addEEnumLiteral(authenticationFlowsEEnum, AuthenticationFlows.IMPLICIT);
		addEEnumLiteral(authenticationFlowsEEnum, AuthenticationFlows.PASSWORD);
		addEEnumLiteral(authenticationFlowsEEnum, AuthenticationFlows.APPLICATION);
		addEEnumLiteral(authenticationFlowsEEnum, AuthenticationFlows.ACCESS_CODE);

		initEEnum(collectionRealizationLevelEnumEEnum, CollectionRealizationLevelEnum.class, "CollectionRealizationLevelEnum");
		addEEnumLiteral(collectionRealizationLevelEnumEEnum, CollectionRealizationLevelEnum.ITEM_LEVEL);
		addEEnumLiteral(collectionRealizationLevelEnumEEnum, CollectionRealizationLevelEnum.COLLECTION_LEVEL);

		// Initialize data types
		initEDataType(realizationModelEDataType, RealizationModel.class, "RealizationModel", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(collectionRealizationLevelObjectEDataType, CollectionRealizationLevelEnum.class, "CollectionRealizationLevelObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(effectiveRealizationEDataType, EffectiveRealization.class, "EffectiveRealization", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cardinalityEDataType, int[].class, "Cardinality", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cardinalityOverrideEDataType, int[].class, "CardinalityOverride", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

    /**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (collectionRealizationLevelObjectEDataType,
		   source,
		   new String[] {
			   "baseType", "CollectionRealizationLevelEnum"
		   });
	}

} //RapidmlPackageImpl

