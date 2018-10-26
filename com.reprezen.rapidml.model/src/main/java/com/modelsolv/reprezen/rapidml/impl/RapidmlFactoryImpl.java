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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.google.common.base.Strings;
import com.modelsolv.reprezen.realization.processor.EffectiveRealization;
import com.modelsolv.reprezen.rapidml.AuthenticationFlows;
import com.modelsolv.reprezen.rapidml.AuthenticationMethod;
import com.modelsolv.reprezen.rapidml.AuthenticationTypes;
import com.modelsolv.reprezen.rapidml.CollectionParameter;
import com.modelsolv.reprezen.rapidml.CollectionRealizationEnum;
import com.modelsolv.reprezen.rapidml.CollectionRealizationLevelEnum;
import com.modelsolv.reprezen.rapidml.CollectionReferenceElement;
import com.modelsolv.reprezen.rapidml.CollectionResource;
import com.modelsolv.reprezen.rapidml.DataModel;
import com.modelsolv.reprezen.rapidml.Documentable;
import com.modelsolv.reprezen.rapidml.Documentation;
import com.modelsolv.reprezen.rapidml.EnumConstant;
import com.modelsolv.reprezen.rapidml.Enumeration;
import com.modelsolv.reprezen.rapidml.Extension;
import com.modelsolv.reprezen.rapidml.ExternalExample;
import com.modelsolv.reprezen.rapidml.HTTPMethods;
import com.modelsolv.reprezen.rapidml.HttpMessageParameterLocation;
import com.modelsolv.reprezen.rapidml.ImportDeclaration;
import com.modelsolv.reprezen.rapidml.InlineDataExample;
import com.modelsolv.reprezen.rapidml.InlineExample;
import com.modelsolv.reprezen.rapidml.LengthConstraint;
import com.modelsolv.reprezen.rapidml.LinkRelation;
import com.modelsolv.reprezen.rapidml.LinkRelationsLibrary;
import com.modelsolv.reprezen.rapidml.MatrixParameter;
import com.modelsolv.reprezen.rapidml.MediaType;
import com.modelsolv.reprezen.rapidml.MediaTypesLibrary;
import com.modelsolv.reprezen.rapidml.MessageParameter;
import com.modelsolv.reprezen.rapidml.Method;
import com.modelsolv.reprezen.rapidml.NamedLinkDescriptor;
import com.modelsolv.reprezen.rapidml.ObjectRealization;
import com.modelsolv.reprezen.rapidml.ObjectResource;
import com.modelsolv.reprezen.rapidml.Operation;
import com.modelsolv.reprezen.rapidml.PrimitiveProperty;
import com.modelsolv.reprezen.rapidml.PrimitiveType;
import com.modelsolv.reprezen.rapidml.PrimitiveTypeSourceReference;
import com.modelsolv.reprezen.rapidml.PrimitiveTypesLibrary;
import com.modelsolv.reprezen.rapidml.PropertyRealization;
import com.modelsolv.reprezen.rapidml.PropertyReference;
import com.modelsolv.reprezen.rapidml.RESTElement;
import com.modelsolv.reprezen.rapidml.RealizationModelLocation;
import com.modelsolv.reprezen.rapidml.ReferenceEmbed;
import com.modelsolv.reprezen.rapidml.ReferenceLink;
import com.modelsolv.reprezen.rapidml.ReferenceProperty;
import com.modelsolv.reprezen.rapidml.ReferenceRealization;
import com.modelsolv.reprezen.rapidml.ReferenceRealizationEnum;
import com.modelsolv.reprezen.rapidml.ReferenceTreatment;
import com.modelsolv.reprezen.rapidml.RegExConstraint;
import com.modelsolv.reprezen.rapidml.ResourceAPI;
import com.modelsolv.reprezen.rapidml.RapidmlFactory;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.SecurityScheme;
import com.modelsolv.reprezen.rapidml.SecuritySchemeLibrary;
import com.modelsolv.reprezen.rapidml.SecuritySchemeParameter;
import com.modelsolv.reprezen.rapidml.SecurityScope;
import com.modelsolv.reprezen.rapidml.ServiceDataResource;
import com.modelsolv.reprezen.rapidml.Structure;
import com.modelsolv.reprezen.rapidml.TemplateParameter;
import com.modelsolv.reprezen.rapidml.TypedRequest;
import com.modelsolv.reprezen.rapidml.TypedResponse;
import com.modelsolv.reprezen.rapidml.URI;
import com.modelsolv.reprezen.rapidml.URISegment;
import com.modelsolv.reprezen.rapidml.URISegmentWithParameter;
import com.modelsolv.reprezen.rapidml.UserDefinedType;
import com.modelsolv.reprezen.rapidml.ValueRangeConstraint;
import com.modelsolv.reprezen.rapidml.ZenModel;
import com.modelsolv.reprezen.rapidml.datatypes.cardinality.Cardinality;
import com.modelsolv.reprezen.rapidml.datatypes.cardinality.CardinalityDeserializer;
import com.modelsolv.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities;
import com.modelsolv.reprezen.rapidml.datatypes.cardinality.OverrideCardinalities;
import com.modelsolv.reprezen.rapidml.impl.UserDefinedTypeImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class RapidmlFactoryImpl extends EFactoryImpl implements RapidmlFactory {

	/**
	 * @generated NOT
	 */
	private final CardinalityDeserializer featureCardinalities = FeatureCardinalities.getFeatureCardinalities();

	/**
	 * @generated NOT
	 */
	private final CardinalityDeserializer overrideCardinalities = OverrideCardinalities.getOverrideCardinalities();

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static RapidmlFactory init() {
		try {
			RapidmlFactory theRapidmlFactory = (RapidmlFactory) EPackage.Registry.INSTANCE
					.getEFactory(RapidmlPackage.eNS_URI);
			if (theRapidmlFactory != null) {
				return theRapidmlFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RapidmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public RapidmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case RapidmlPackage.METHOD:
			return createMethod();
		case RapidmlPackage.REST_ELEMENT:
			return createRESTElement();
		case RapidmlPackage.DOCUMENTATION:
			return createDocumentation();
		case RapidmlPackage.DOCUMENTABLE:
			return createDocumentable();
		case RapidmlPackage.MEDIA_TYPE:
			return createMediaType();
		case RapidmlPackage.TYPED_REQUEST:
			return createTypedRequest();
		case RapidmlPackage.TYPED_RESPONSE:
			return createTypedResponse();
		case RapidmlPackage.MATRIX_PARAMETER:
			return createMatrixParameter();
		case RapidmlPackage.TEMPLATE_PARAMETER:
			return createTemplateParameter();
		case RapidmlPackage.COLLECTION_RESOURCE:
			return createCollectionResource();
		case RapidmlPackage.OBJECT_RESOURCE:
			return createObjectResource();
		case RapidmlPackage.COLLECTION_PARAMETER:
			return createCollectionParameter();
		case RapidmlPackage.PROPERTY_REFERENCE:
			return createPropertyReference();
		case RapidmlPackage.MESSAGE_PARAMETER:
			return createMessageParameter();
		case RapidmlPackage.ZEN_MODEL:
			return createZenModel();
		case RapidmlPackage.RESOURCE_API:
			return createResourceAPI();
		case RapidmlPackage.SERVICE_DATA_RESOURCE:
			return createServiceDataResource();
		case RapidmlPackage.REFERENCE_TREATMENT:
			return createReferenceTreatment();
		case RapidmlPackage.REFERENCE_REALIZATION:
			return createReferenceRealization();
		case RapidmlPackage.REFERENCE_LINK:
			return createReferenceLink();
		case RapidmlPackage.REFERENCE_EMBED:
			return createReferenceEmbed();
		case RapidmlPackage.NAMED_LINK_DESCRIPTOR:
			return createNamedLinkDescriptor();
		case RapidmlPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE:
			return createPrimitiveTypeSourceReference();
		case RapidmlPackage.URI:
			return createURI();
		case RapidmlPackage.URI_SEGMENT:
			return createURISegment();
		case RapidmlPackage.URI_SEGMENT_WITH_PARAMETER:
			return createURISegmentWithParameter();
		case RapidmlPackage.PROPERTY_REALIZATION:
			return createPropertyRealization();
		case RapidmlPackage.LINK_RELATION:
			return createLinkRelation();
		case RapidmlPackage.INLINE_EXAMPLE:
			return createInlineExample();
		case RapidmlPackage.EXTERNAL_EXAMPLE:
			return createExternalExample();
		case RapidmlPackage.IMPORT_DECLARATION:
			return createImportDeclaration();
		case RapidmlPackage.OBJECT_REALIZATION:
			return createObjectRealization();
		case RapidmlPackage.COLLECTION_REFERENCE_ELEMENT:
			return createCollectionReferenceElement();
		case RapidmlPackage.SECURITY_SCHEME:
			return createSecurityScheme();
		case RapidmlPackage.AUTHENTICATION_METHOD:
			return createAuthenticationMethod();
		case RapidmlPackage.SECURITY_SCOPE:
			return createSecurityScope();
		case RapidmlPackage.SECURITY_SCHEME_PARAMETER:
			return createSecuritySchemeParameter();
		case RapidmlPackage.SECURITY_SCHEME_LIBRARY:
			return createSecuritySchemeLibrary();
		case RapidmlPackage.EXTENSION:
			return createExtension();
		case RapidmlPackage.REALIZATION_MODEL_LOCATION:
			return createRealizationModelLocation();
		case RapidmlPackage.OPERATION:
			return createOperation();
		case RapidmlPackage.REFERENCE_PROPERTY:
			return createReferenceProperty();
		case RapidmlPackage.PRIMITIVE_PROPERTY:
			return createPrimitiveProperty();
		case RapidmlPackage.STRUCTURE:
			return createStructure();
		case RapidmlPackage.DATA_MODEL:
			return createDataModel();
		case RapidmlPackage.INLINE_DATA_EXAMPLE:
			return createInlineDataExample();
		case RapidmlPackage.ENUMERATION:
			return createEnumeration();
		case RapidmlPackage.ENUM_CONSTANT:
			return createEnumConstant();
		case RapidmlPackage.USER_DEFINED_TYPE:
			return createUserDefinedType();
		case RapidmlPackage.PRIMITIVE_TYPE:
			return createPrimitiveType();
		case RapidmlPackage.LENGTH_CONSTRAINT:
			return createLengthConstraint();
		case RapidmlPackage.REG_EX_CONSTRAINT:
			return createRegExConstraint();
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT:
			return createValueRangeConstraint();
		case RapidmlPackage.MEDIA_TYPES_LIBRARY:
			return createMediaTypesLibrary();
		case RapidmlPackage.LINK_RELATIONS_LIBRARY:
			return createLinkRelationsLibrary();
		case RapidmlPackage.PRIMITIVE_TYPES_LIBRARY:
			return createPrimitiveTypesLibrary();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case RapidmlPackage.HTTP_METHODS:
			return createHTTPMethodsFromString(eDataType, initialValue);
		case RapidmlPackage.REFERENCE_REALIZATION_ENUM:
			return createReferenceRealizationEnumFromString(eDataType, initialValue);
		case RapidmlPackage.HTTP_MESSAGE_PARAMETER_LOCATION:
			return createHttpMessageParameterLocationFromString(eDataType, initialValue);
		case RapidmlPackage.COLLECTION_REALIZATION_ENUM:
			return createCollectionRealizationEnumFromString(eDataType, initialValue);
		case RapidmlPackage.AUTHENTICATION_TYPES:
			return createAuthenticationTypesFromString(eDataType, initialValue);
		case RapidmlPackage.AUTHENTICATION_FLOWS:
			return createAuthenticationFlowsFromString(eDataType, initialValue);
		case RapidmlPackage.COLLECTION_REALIZATION_LEVEL_ENUM:
			return createCollectionRealizationLevelEnumFromString(eDataType, initialValue);
		case RapidmlPackage.COLLECTION_REALIZATION_LEVEL_OBJECT:
			return createCollectionRealizationLevelObjectFromString(eDataType, initialValue);
		case RapidmlPackage.EFFECTIVE_REALIZATION:
			return createEffectiveRealizationFromString(eDataType, initialValue);
		case RapidmlPackage.CARDINALITY:
			return createCardinalityFromString(eDataType, initialValue);
		case RapidmlPackage.CARDINALITY_OVERRIDE:
			return createCardinalityOverrideFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case RapidmlPackage.HTTP_METHODS:
			return convertHTTPMethodsToString(eDataType, instanceValue);
		case RapidmlPackage.REFERENCE_REALIZATION_ENUM:
			return convertReferenceRealizationEnumToString(eDataType, instanceValue);
		case RapidmlPackage.HTTP_MESSAGE_PARAMETER_LOCATION:
			return convertHttpMessageParameterLocationToString(eDataType, instanceValue);
		case RapidmlPackage.COLLECTION_REALIZATION_ENUM:
			return convertCollectionRealizationEnumToString(eDataType, instanceValue);
		case RapidmlPackage.AUTHENTICATION_TYPES:
			return convertAuthenticationTypesToString(eDataType, instanceValue);
		case RapidmlPackage.AUTHENTICATION_FLOWS:
			return convertAuthenticationFlowsToString(eDataType, instanceValue);
		case RapidmlPackage.COLLECTION_REALIZATION_LEVEL_ENUM:
			return convertCollectionRealizationLevelEnumToString(eDataType, instanceValue);
		case RapidmlPackage.COLLECTION_REALIZATION_LEVEL_OBJECT:
			return convertCollectionRealizationLevelObjectToString(eDataType, instanceValue);
		case RapidmlPackage.EFFECTIVE_REALIZATION:
			return convertEffectiveRealizationToString(eDataType, instanceValue);
		case RapidmlPackage.CARDINALITY:
			return convertCardinalityToString(eDataType, instanceValue);
		case RapidmlPackage.CARDINALITY_OVERRIDE:
			return convertCardinalityOverrideToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RESTElement createRESTElement() {
		RESTElementImpl restElement = new RESTElementImpl();
		return restElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Documentation createDocumentation() {
		DocumentationImpl documentation = new DocumentationImpl();
		return documentation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Documentable createDocumentable() {
		DocumentableImpl documentable = new DocumentableImpl();
		return documentable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MediaType createMediaType() {
		MediaTypeImpl mediaType = new MediaTypeImpl();
		return mediaType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypedRequest createTypedRequest() {
		TypedRequestImpl typedRequest = new TypedRequestImpl();
		return typedRequest;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypedResponse createTypedResponse() {
		TypedResponseImpl typedResponse = new TypedResponseImpl();
		return typedResponse;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MatrixParameter createMatrixParameter() {
		MatrixParameterImpl matrixParameter = new MatrixParameterImpl();
		return matrixParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TemplateParameter createTemplateParameter() {
		TemplateParameterImpl templateParameter = new TemplateParameterImpl();
		return templateParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionResource createCollectionResource() {
		CollectionResourceImpl collectionResource = new CollectionResourceImpl();
		return collectionResource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectResource createObjectResource() {
		ObjectResourceImpl objectResource = new ObjectResourceImpl();
		return objectResource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionParameter createCollectionParameter() {
		CollectionParameterImpl collectionParameter = new CollectionParameterImpl();
		return collectionParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyReference createPropertyReference() {
		PropertyReferenceImpl propertyReference = new PropertyReferenceImpl();
		return propertyReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MessageParameter createMessageParameter() {
		MessageParameterImpl messageParameter = new MessageParameterImpl();
		return messageParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ZenModel createZenModel() {
		ZenModelImpl zenModel = new ZenModelImpl();
		return zenModel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceAPI createResourceAPI() {
		ResourceAPIImpl resourceAPI = new ResourceAPIImpl();
		return resourceAPI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServiceDataResource createServiceDataResource() {
		ServiceDataResourceImpl serviceDataResource = new ServiceDataResourceImpl();
		return serviceDataResource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceTreatment createReferenceTreatment() {
		ReferenceTreatmentImpl referenceTreatment = new ReferenceTreatmentImpl();
		return referenceTreatment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceRealization createReferenceRealization() {
		ReferenceRealizationImpl referenceRealization = new ReferenceRealizationImpl();
		return referenceRealization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceLink createReferenceLink() {
		ReferenceLinkImpl referenceLink = new ReferenceLinkImpl();
		return referenceLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceEmbed createReferenceEmbed() {
		ReferenceEmbedImpl referenceEmbed = new ReferenceEmbedImpl();
		return referenceEmbed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedLinkDescriptor createNamedLinkDescriptor() {
		NamedLinkDescriptorImpl namedLinkDescriptor = new NamedLinkDescriptorImpl();
		return namedLinkDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimitiveTypeSourceReference createPrimitiveTypeSourceReference() {
		PrimitiveTypeSourceReferenceImpl primitiveTypeSourceReference = new PrimitiveTypeSourceReferenceImpl();
		return primitiveTypeSourceReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URI createURI() {
		URIImpl uri = new URIImpl();
		return uri;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URISegment createURISegment() {
		URISegmentImpl uriSegment = new URISegmentImpl();
		return uriSegment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URISegmentWithParameter createURISegmentWithParameter() {
		URISegmentWithParameterImpl uriSegmentWithParameter = new URISegmentWithParameterImpl();
		return uriSegmentWithParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyRealization createPropertyRealization() {
		PropertyRealizationImpl propertyRealization = new PropertyRealizationImpl();
		return propertyRealization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LinkRelation createLinkRelation() {
		LinkRelationImpl linkRelation = new LinkRelationImpl();
		return linkRelation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InlineExample createInlineExample() {
		InlineExampleImpl inlineExample = new InlineExampleImpl();
		return inlineExample;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExternalExample createExternalExample() {
		ExternalExampleImpl externalExample = new ExternalExampleImpl();
		return externalExample;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImportDeclaration createImportDeclaration() {
		ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
		return importDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectRealization createObjectRealization() {
		ObjectRealizationImpl objectRealization = new ObjectRealizationImpl();
		return objectRealization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionReferenceElement createCollectionReferenceElement() {
		CollectionReferenceElementImpl collectionReferenceElement = new CollectionReferenceElementImpl();
		return collectionReferenceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SecurityScheme createSecurityScheme() {
		SecuritySchemeImpl securityScheme = new SecuritySchemeImpl();
		return securityScheme;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AuthenticationMethod createAuthenticationMethod() {
		AuthenticationMethodImpl authenticationMethod = new AuthenticationMethodImpl();
		return authenticationMethod;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SecurityScope createSecurityScope() {
		SecurityScopeImpl securityScope = new SecurityScopeImpl();
		return securityScope;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SecuritySchemeParameter createSecuritySchemeParameter() {
		SecuritySchemeParameterImpl securitySchemeParameter = new SecuritySchemeParameterImpl();
		return securitySchemeParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SecuritySchemeLibrary createSecuritySchemeLibrary() {
		SecuritySchemeLibraryImpl securitySchemeLibrary = new SecuritySchemeLibraryImpl();
		return securitySchemeLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealizationModelLocation createRealizationModelLocation() {
		RealizationModelLocationImpl realizationModelLocation = new RealizationModelLocationImpl();
		return realizationModelLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceProperty createReferenceProperty() {
		ReferencePropertyImpl referenceProperty = new ReferencePropertyImpl();
		return referenceProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimitiveProperty createPrimitiveProperty() {
		PrimitivePropertyImpl primitiveProperty = new PrimitivePropertyImpl();
		return primitiveProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Structure createStructure() {
		StructureImpl structure = new StructureImpl();
		return structure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DataModel createDataModel() {
		DataModelImpl dataModel = new DataModelImpl();
		return dataModel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InlineDataExample createInlineDataExample() {
		InlineDataExampleImpl inlineDataExample = new InlineDataExampleImpl();
		return inlineDataExample;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumConstant createEnumConstant() {
		EnumConstantImpl enumConstant = new EnumConstantImpl();
		return enumConstant;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UserDefinedType createUserDefinedType() {
		UserDefinedTypeImpl userDefinedType = new UserDefinedTypeImpl();
		return userDefinedType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LengthConstraint createLengthConstraint() {
		LengthConstraintImpl lengthConstraint = new LengthConstraintImpl();
		return lengthConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegExConstraint createRegExConstraint() {
		RegExConstraintImpl regExConstraint = new RegExConstraintImpl();
		return regExConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueRangeConstraint createValueRangeConstraint() {
		ValueRangeConstraintImpl valueRangeConstraint = new ValueRangeConstraintImpl();
		return valueRangeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MediaTypesLibrary createMediaTypesLibrary() {
		MediaTypesLibraryImpl mediaTypesLibrary = new MediaTypesLibraryImpl();
		return mediaTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LinkRelationsLibrary createLinkRelationsLibrary() {
		LinkRelationsLibraryImpl linkRelationsLibrary = new LinkRelationsLibraryImpl();
		return linkRelationsLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimitiveTypesLibrary createPrimitiveTypesLibrary() {
		PrimitiveTypesLibraryImpl primitiveTypesLibrary = new PrimitiveTypesLibraryImpl();
		return primitiveTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HTTPMethods createHTTPMethodsFromString(EDataType eDataType, String initialValue) {
		HTTPMethods result = HTTPMethods.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertHTTPMethodsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceRealizationEnum createReferenceRealizationEnumFromString(EDataType eDataType, String initialValue) {
		ReferenceRealizationEnum result = ReferenceRealizationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertReferenceRealizationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HttpMessageParameterLocation createHttpMessageParameterLocationFromString(EDataType eDataType,
			String initialValue) {
		HttpMessageParameterLocation result = HttpMessageParameterLocation.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertHttpMessageParameterLocationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionRealizationEnum createCollectionRealizationEnumFromString(EDataType eDataType,
			String initialValue) {
		CollectionRealizationEnum result = CollectionRealizationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCollectionRealizationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AuthenticationTypes createAuthenticationTypesFromString(EDataType eDataType, String initialValue) {
		AuthenticationTypes result = AuthenticationTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertAuthenticationTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AuthenticationFlows createAuthenticationFlowsFromString(EDataType eDataType, String initialValue) {
		AuthenticationFlows result = AuthenticationFlows.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertAuthenticationFlowsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionRealizationLevelEnum createCollectionRealizationLevelEnumFromString(EDataType eDataType,
			String initialValue) {
		CollectionRealizationLevelEnum result = CollectionRealizationLevelEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCollectionRealizationLevelEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionRealizationLevelEnum createCollectionRealizationLevelObjectFromString(EDataType eDataType,
			String initialValue) {
		return createCollectionRealizationLevelEnumFromString(RapidmlPackage.Literals.COLLECTION_REALIZATION_LEVEL_ENUM,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCollectionRealizationLevelObjectToString(EDataType eDataType, Object instanceValue) {
		return convertCollectionRealizationLevelEnumToString(RapidmlPackage.Literals.COLLECTION_REALIZATION_LEVEL_ENUM,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectiveRealization createEffectiveRealizationFromString(EDataType eDataType, String initialValue) {
		return (EffectiveRealization) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertEffectiveRealizationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int[] createCardinalityFromString(EDataType eDataType, String cardinalityString) {
		if (Strings.isNullOrEmpty(cardinalityString)) {
			// unset value, use default
			cardinalityString = "[1..1]";
		}
		Cardinality cardinality = featureCardinalities.getCardinality(cardinalityString);
		return cardinality.toIntArray();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertCardinalityToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) {
			return null;
		}
		int[] multiplicity = (int[]) instanceValue;
		Cardinality cardinality = featureCardinalities.getCardinality(multiplicity[0], multiplicity[1]);
		return cardinality.getLabel();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int[] createCardinalityOverrideFromString(EDataType eDataType, String cardinalityString) {
		if (Strings.isNullOrEmpty(cardinalityString)) {
			// unset value, use default
			return null;
		}
		Cardinality cardinality = overrideCardinalities.getCardinality(cardinalityString);
		return cardinality.toIntArray();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertCardinalityOverrideToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) {
			return null;
		}
		int[] multiplicity = (int[]) instanceValue;
		Cardinality cardinality = overrideCardinalities.getCardinality(multiplicity[0], multiplicity[1]);
		return cardinality.getLabel();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RapidmlPackage getRapidmlPackage() {
		return (RapidmlPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RapidmlPackage getPackage() {
		return RapidmlPackage.eINSTANCE;
	}

} // RapidmlFactoryImpl
