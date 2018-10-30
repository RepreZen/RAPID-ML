/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.reprezen.rapidml.RapidmlPackage
 * @generated
 */
public interface RapidmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RapidmlFactory eINSTANCE = com.reprezen.rapidml.impl.RapidmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method</em>'.
	 * @generated
	 */
	Method createMethod();

	/**
	 * Returns a new object of class '<em>REST Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>REST Element</em>'.
	 * @generated
	 */
	RESTElement createRESTElement();

	/**
	 * Returns a new object of class '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation</em>'.
	 * @generated
	 */
	Documentation createDocumentation();

	/**
	 * Returns a new object of class '<em>Documentable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentable</em>'.
	 * @generated
	 */
	Documentable createDocumentable();

	/**
	 * Returns a new object of class '<em>Media Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Media Type</em>'.
	 * @generated
	 */
	MediaType createMediaType();

	/**
	 * Returns a new object of class '<em>Typed Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Request</em>'.
	 * @generated
	 */
	TypedRequest createTypedRequest();

	/**
	 * Returns a new object of class '<em>Typed Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Response</em>'.
	 * @generated
	 */
	TypedResponse createTypedResponse();

	/**
	 * Returns a new object of class '<em>Matrix Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matrix Parameter</em>'.
	 * @generated
	 */
	MatrixParameter createMatrixParameter();

	/**
	 * Returns a new object of class '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter</em>'.
	 * @generated
	 */
	TemplateParameter createTemplateParameter();

	/**
	 * Returns a new object of class '<em>Collection Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Resource</em>'.
	 * @generated
	 */
	CollectionResource createCollectionResource();

	/**
	 * Returns a new object of class '<em>Object Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Resource</em>'.
	 * @generated
	 */
	ObjectResource createObjectResource();

	/**
	 * Returns a new object of class '<em>Collection Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Parameter</em>'.
	 * @generated
	 */
	CollectionParameter createCollectionParameter();

	/**
	 * Returns a new object of class '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Reference</em>'.
	 * @generated
	 */
	PropertyReference createPropertyReference();

	/**
	 * Returns a new object of class '<em>Message Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Parameter</em>'.
	 * @generated
	 */
	MessageParameter createMessageParameter();

	/**
	 * Returns a new object of class '<em>Zen Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Zen Model</em>'.
	 * @generated
	 */
	ZenModel createZenModel();

	/**
	 * Returns a new object of class '<em>Resource API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource API</em>'.
	 * @generated
	 */
	ResourceAPI createResourceAPI();

	/**
	 * Returns a new object of class '<em>Service Data Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Data Resource</em>'.
	 * @generated
	 */
	ServiceDataResource createServiceDataResource();

	/**
	 * Returns a new object of class '<em>Reference Treatment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Treatment</em>'.
	 * @generated
	 */
	ReferenceTreatment createReferenceTreatment();

	/**
	 * Returns a new object of class '<em>Reference Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Realization</em>'.
	 * @generated
	 */
	ReferenceRealization createReferenceRealization();

	/**
	 * Returns a new object of class '<em>Reference Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Link</em>'.
	 * @generated
	 */
	ReferenceLink createReferenceLink();

	/**
	 * Returns a new object of class '<em>Reference Embed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Embed</em>'.
	 * @generated
	 */
	ReferenceEmbed createReferenceEmbed();

	/**
	 * Returns a new object of class '<em>Named Link Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Link Descriptor</em>'.
	 * @generated
	 */
	NamedLinkDescriptor createNamedLinkDescriptor();

	/**
	 * Returns a new object of class '<em>Primitive Type Source Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Source Reference</em>'.
	 * @generated
	 */
	PrimitiveTypeSourceReference createPrimitiveTypeSourceReference();

	/**
	 * Returns a new object of class '<em>URI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URI</em>'.
	 * @generated
	 */
	URI createURI();

	/**
	 * Returns a new object of class '<em>URI Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URI Segment</em>'.
	 * @generated
	 */
	URISegment createURISegment();

	/**
	 * Returns a new object of class '<em>URI Segment With Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URI Segment With Parameter</em>'.
	 * @generated
	 */
	URISegmentWithParameter createURISegmentWithParameter();

	/**
	 * Returns a new object of class '<em>Property Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Realization</em>'.
	 * @generated
	 */
	PropertyRealization createPropertyRealization();

	/**
	 * Returns a new object of class '<em>Link Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Relation</em>'.
	 * @generated
	 */
	LinkRelation createLinkRelation();

	/**
	 * Returns a new object of class '<em>Inline Example</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inline Example</em>'.
	 * @generated
	 */
	InlineExample createInlineExample();

	/**
	 * Returns a new object of class '<em>External Example</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Example</em>'.
	 * @generated
	 */
	ExternalExample createExternalExample();

	/**
	 * Returns a new object of class '<em>Import Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Declaration</em>'.
	 * @generated
	 */
	ImportDeclaration createImportDeclaration();

	/**
	 * Returns a new object of class '<em>Object Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Realization</em>'.
	 * @generated
	 */
	ObjectRealization createObjectRealization();

	/**
	 * Returns a new object of class '<em>Collection Reference Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Reference Element</em>'.
	 * @generated
	 */
	CollectionReferenceElement createCollectionReferenceElement();

	/**
	 * Returns a new object of class '<em>Security Scheme</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Scheme</em>'.
	 * @generated
	 */
	SecurityScheme createSecurityScheme();

	/**
	 * Returns a new object of class '<em>Authentication Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Authentication Method</em>'.
	 * @generated
	 */
	AuthenticationMethod createAuthenticationMethod();

	/**
	 * Returns a new object of class '<em>Security Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Scope</em>'.
	 * @generated
	 */
	SecurityScope createSecurityScope();

	/**
	 * Returns a new object of class '<em>Security Scheme Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Scheme Parameter</em>'.
	 * @generated
	 */
	SecuritySchemeParameter createSecuritySchemeParameter();

	/**
	 * Returns a new object of class '<em>Security Scheme Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Scheme Library</em>'.
	 * @generated
	 */
	SecuritySchemeLibrary createSecuritySchemeLibrary();

	/**
	 * Returns a new object of class '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension</em>'.
	 * @generated
	 */
	Extension createExtension();

	/**
	 * Returns a new object of class '<em>Realization Model Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Realization Model Location</em>'.
	 * @generated
	 */
	RealizationModelLocation createRealizationModelLocation();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Reference Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Property</em>'.
	 * @generated
	 */
	ReferenceProperty createReferenceProperty();

	/**
	 * Returns a new object of class '<em>Primitive Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Property</em>'.
	 * @generated
	 */
	PrimitiveProperty createPrimitiveProperty();

	/**
	 * Returns a new object of class '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure</em>'.
	 * @generated
	 */
	Structure createStructure();

	/**
	 * Returns a new object of class '<em>Data Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Model</em>'.
	 * @generated
	 */
	DataModel createDataModel();

	/**
	 * Returns a new object of class '<em>Inline Data Example</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inline Data Example</em>'.
	 * @generated
	 */
	InlineDataExample createInlineDataExample();

	/**
	 * Returns a new object of class '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration</em>'.
	 * @generated
	 */
	Enumeration createEnumeration();

	/**
	 * Returns a new object of class '<em>Enum Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Constant</em>'.
	 * @generated
	 */
	EnumConstant createEnumConstant();

	/**
	 * Returns a new object of class '<em>User Defined Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Defined Type</em>'.
	 * @generated
	 */
	UserDefinedType createUserDefinedType();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>Length Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Length Constraint</em>'.
	 * @generated
	 */
	LengthConstraint createLengthConstraint();

	/**
	 * Returns a new object of class '<em>Reg Ex Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Ex Constraint</em>'.
	 * @generated
	 */
	RegExConstraint createRegExConstraint();

	/**
	 * Returns a new object of class '<em>Value Range Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Range Constraint</em>'.
	 * @generated
	 */
	ValueRangeConstraint createValueRangeConstraint();

	/**
	 * Returns a new object of class '<em>Media Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Media Types Library</em>'.
	 * @generated
	 */
	MediaTypesLibrary createMediaTypesLibrary();

	/**
	 * Returns a new object of class '<em>Link Relations Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Relations Library</em>'.
	 * @generated
	 */
	LinkRelationsLibrary createLinkRelationsLibrary();

	/**
	 * Returns a new object of class '<em>Primitive Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Types Library</em>'.
	 * @generated
	 */
	PrimitiveTypesLibrary createPrimitiveTypesLibrary();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RapidmlPackage getRapidmlPackage();

} //RapidmlFactory
