/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.CollectionParameter;
import com.reprezen.rapidml.CollectionReferenceElement;
import com.reprezen.rapidml.CollectionResource;
import com.reprezen.rapidml.Constraint;
import com.reprezen.rapidml.DataExample;
import com.reprezen.rapidml.DataModel;
import com.reprezen.rapidml.DataType;
import com.reprezen.rapidml.Documentable;
import com.reprezen.rapidml.Documentation;
import com.reprezen.rapidml.EnumConstant;
import com.reprezen.rapidml.Enumeration;
import com.reprezen.rapidml.Example;
import com.reprezen.rapidml.Extensible;
import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.ExternalExample;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.HasStringValue;
import com.reprezen.rapidml.HasTitle;
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
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.RealizationContainer;
import com.reprezen.rapidml.RealizationModelLocation;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.RegExConstraint;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
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
import com.reprezen.rapidml.URI;
import com.reprezen.rapidml.URIParameter;
import com.reprezen.rapidml.URISegment;
import com.reprezen.rapidml.URISegmentWithParameter;
import com.reprezen.rapidml.UserDefinedType;
import com.reprezen.rapidml.ValueRangeConstraint;
import com.reprezen.rapidml.WithDataExamples;
import com.reprezen.rapidml.WithExamples;
import com.reprezen.rapidml.ZenModel;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see com.reprezen.rapidml.RapidmlPackage
 * @generated
 */
public class RapidmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static RapidmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public RapidmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RapidmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!--
	 * begin-user-doc --> This implementation returns <code>true</code> if the
	 * object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RapidmlSwitch<Adapter> modelSwitch = new RapidmlSwitch<Adapter>() {
		@Override
		public Adapter caseResourceDefinition(ResourceDefinition object) {
			return createResourceDefinitionAdapter();
		}

		@Override
		public Adapter caseTypedMessage(TypedMessage object) {
			return createTypedMessageAdapter();
		}

		@Override
		public Adapter caseMethod(Method object) {
			return createMethodAdapter();
		}

		@Override
		public Adapter caseParameter(Parameter object) {
			return createParameterAdapter();
		}

		@Override
		public Adapter caseRESTElement(RESTElement object) {
			return createRESTElementAdapter();
		}

		@Override
		public Adapter caseDocumentation(Documentation object) {
			return createDocumentationAdapter();
		}

		@Override
		public Adapter caseDocumentable(Documentable object) {
			return createDocumentableAdapter();
		}

		@Override
		public Adapter caseMediaType(MediaType object) {
			return createMediaTypeAdapter();
		}

		@Override
		public Adapter caseTypedRequest(TypedRequest object) {
			return createTypedRequestAdapter();
		}

		@Override
		public Adapter caseTypedResponse(TypedResponse object) {
			return createTypedResponseAdapter();
		}

		@Override
		public Adapter caseURIParameter(URIParameter object) {
			return createURIParameterAdapter();
		}

		@Override
		public Adapter caseMatrixParameter(MatrixParameter object) {
			return createMatrixParameterAdapter();
		}

		@Override
		public Adapter caseTemplateParameter(TemplateParameter object) {
			return createTemplateParameterAdapter();
		}

		@Override
		public Adapter caseCollectionResource(CollectionResource object) {
			return createCollectionResourceAdapter();
		}

		@Override
		public Adapter caseObjectResource(ObjectResource object) {
			return createObjectResourceAdapter();
		}

		@Override
		public Adapter caseCollectionParameter(CollectionParameter object) {
			return createCollectionParameterAdapter();
		}

		@Override
		public Adapter casePropertyReference(PropertyReference object) {
			return createPropertyReferenceAdapter();
		}

		@Override
		public Adapter caseSourceReference(SourceReference object) {
			return createSourceReferenceAdapter();
		}

		@Override
		public Adapter caseMessageParameter(MessageParameter object) {
			return createMessageParameterAdapter();
		}

		@Override
		public Adapter caseZenModel(ZenModel object) {
			return createZenModelAdapter();
		}

		@Override
		public Adapter caseResourceAPI(ResourceAPI object) {
			return createResourceAPIAdapter();
		}

		@Override
		public Adapter caseServiceDataResource(ServiceDataResource object) {
			return createServiceDataResourceAdapter();
		}

		@Override
		public Adapter caseReferenceTreatment(ReferenceTreatment object) {
			return createReferenceTreatmentAdapter();
		}

		@Override
		public Adapter caseReferenceRealization(ReferenceRealization object) {
			return createReferenceRealizationAdapter();
		}

		@Override
		public Adapter caseReferenceLink(ReferenceLink object) {
			return createReferenceLinkAdapter();
		}

		@Override
		public Adapter caseReferenceEmbed(ReferenceEmbed object) {
			return createReferenceEmbedAdapter();
		}

		@Override
		public Adapter caseNamedLinkDescriptor(NamedLinkDescriptor object) {
			return createNamedLinkDescriptorAdapter();
		}

		@Override
		public Adapter casePathSegment(PathSegment object) {
			return createPathSegmentAdapter();
		}

		@Override
		public Adapter casePrimitiveTypeSourceReference(PrimitiveTypeSourceReference object) {
			return createPrimitiveTypeSourceReferenceAdapter();
		}

		@Override
		public Adapter caseURI(URI object) {
			return createURIAdapter();
		}

		@Override
		public Adapter caseURISegment(URISegment object) {
			return createURISegmentAdapter();
		}

		@Override
		public Adapter caseURISegmentWithParameter(URISegmentWithParameter object) {
			return createURISegmentWithParameterAdapter();
		}

		@Override
		public Adapter casePropertyRealization(PropertyRealization object) {
			return createPropertyRealizationAdapter();
		}

		@Override
		public Adapter caseLinkRelation(LinkRelation object) {
			return createLinkRelationAdapter();
		}

		@Override
		public Adapter caseWithExamples(WithExamples object) {
			return createWithExamplesAdapter();
		}

		@Override
		public Adapter caseExample(Example object) {
			return createExampleAdapter();
		}

		@Override
		public Adapter caseInlineExample(InlineExample object) {
			return createInlineExampleAdapter();
		}

		@Override
		public Adapter caseExternalExample(ExternalExample object) {
			return createExternalExampleAdapter();
		}

		@Override
		public Adapter caseHasStringValue(HasStringValue object) {
			return createHasStringValueAdapter();
		}

		@Override
		public Adapter caseImportDeclaration(ImportDeclaration object) {
			return createImportDeclarationAdapter();
		}

		@Override
		public Adapter caseObjectRealization(ObjectRealization object) {
			return createObjectRealizationAdapter();
		}

		@Override
		public Adapter caseCollectionReferenceElement(CollectionReferenceElement object) {
			return createCollectionReferenceElementAdapter();
		}

		@Override
		public Adapter caseHasSecurityValue(HasSecurityValue object) {
			return createHasSecurityValueAdapter();
		}

		@Override
		public Adapter caseSecurityScheme(SecurityScheme object) {
			return createSecuritySchemeAdapter();
		}

		@Override
		public Adapter caseAuthenticationMethod(AuthenticationMethod object) {
			return createAuthenticationMethodAdapter();
		}

		@Override
		public Adapter caseSecurityScope(SecurityScope object) {
			return createSecurityScopeAdapter();
		}

		@Override
		public Adapter caseSecuritySchemeParameter(SecuritySchemeParameter object) {
			return createSecuritySchemeParameterAdapter();
		}

		@Override
		public Adapter caseSecuritySchemeLibrary(SecuritySchemeLibrary object) {
			return createSecuritySchemeLibraryAdapter();
		}

		@Override
		public Adapter caseRealizationContainer(RealizationContainer object) {
			return createRealizationContainerAdapter();
		}

		@Override
		public Adapter caseExtensible(Extensible object) {
			return createExtensibleAdapter();
		}

		@Override
		public Adapter caseExtension(Extension object) {
			return createExtensionAdapter();
		}

		@Override
		public Adapter caseRealizationModelLocation(RealizationModelLocation object) {
			return createRealizationModelLocationAdapter();
		}

		@Override
		public Adapter caseHasTitle(HasTitle object) {
			return createHasTitleAdapter();
		}

		@Override
		public Adapter caseOperation(Operation object) {
			return createOperationAdapter();
		}

		@Override
		public Adapter caseFeature(Feature object) {
			return createFeatureAdapter();
		}

		@Override
		public Adapter caseReferenceProperty(ReferenceProperty object) {
			return createReferencePropertyAdapter();
		}

		@Override
		public Adapter casePrimitiveProperty(PrimitiveProperty object) {
			return createPrimitivePropertyAdapter();
		}

		@Override
		public Adapter caseStructure(Structure object) {
			return createStructureAdapter();
		}

		@Override
		public Adapter caseDataModel(DataModel object) {
			return createDataModelAdapter();
		}

		@Override
		public Adapter caseWithDataExamples(WithDataExamples object) {
			return createWithDataExamplesAdapter();
		}

		@Override
		public Adapter caseDataExample(DataExample object) {
			return createDataExampleAdapter();
		}

		@Override
		public Adapter caseInlineDataExample(InlineDataExample object) {
			return createInlineDataExampleAdapter();
		}

		@Override
		public Adapter caseConstraint(Constraint object) {
			return createConstraintAdapter();
		}

		@Override
		public Adapter caseEnumeration(Enumeration object) {
			return createEnumerationAdapter();
		}

		@Override
		public Adapter caseSimpleType(SimpleType object) {
			return createSimpleTypeAdapter();
		}

		@Override
		public Adapter caseEnumConstant(EnumConstant object) {
			return createEnumConstantAdapter();
		}

		@Override
		public Adapter caseUserDefinedType(UserDefinedType object) {
			return createUserDefinedTypeAdapter();
		}

		@Override
		public Adapter casePrimitiveType(PrimitiveType object) {
			return createPrimitiveTypeAdapter();
		}

		@Override
		public Adapter caseDataType(DataType object) {
			return createDataTypeAdapter();
		}

		@Override
		public Adapter caseSingleValueType(SingleValueType object) {
			return createSingleValueTypeAdapter();
		}

		@Override
		public Adapter caseElement(com.reprezen.rapidml.Element object) {
			return createElementAdapter();
		}

		@Override
		public Adapter caseReferenceElement(com.reprezen.rapidml.ReferenceElement object) {
			return createReferenceElementAdapter();
		}

		@Override
		public Adapter caseLengthConstraint(LengthConstraint object) {
			return createLengthConstraintAdapter();
		}

		@Override
		public Adapter caseRegExConstraint(RegExConstraint object) {
			return createRegExConstraintAdapter();
		}

		@Override
		public Adapter caseValueRangeConstraint(ValueRangeConstraint object) {
			return createValueRangeConstraintAdapter();
		}

		@Override
		public Adapter caseConstrainableType(com.reprezen.rapidml.ConstrainableType object) {
			return createConstrainableTypeAdapter();
		}

		@Override
		public Adapter caseInheritable(Inheritable object) {
			return createInheritableAdapter();
		}

		@Override
		public Adapter caseMediaTypesLibrary(MediaTypesLibrary object) {
			return createMediaTypesLibraryAdapter();
		}

		@Override
		public Adapter caseLinkRelationsLibrary(LinkRelationsLibrary object) {
			return createLinkRelationsLibraryAdapter();
		}

		@Override
		public Adapter casePrimitiveTypesLibrary(PrimitiveTypesLibrary object) {
			return createPrimitiveTypesLibraryAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ResourceDefinition <em>Resource
	 * Definition</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ResourceDefinition
	 * @generated
	 */
	public Adapter createResourceDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.TypedMessage <em>Typed Message</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.TypedMessage
	 * @generated
	 */
	public Adapter createTypedMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Method <em>Method</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Method
	 * @generated
	 */
	public Adapter createMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Parameter <em>Parameter</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.RESTElement <em>REST Element</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.RESTElement
	 * @generated
	 */
	public Adapter createRESTElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Documentation <em>Documentation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Documentation
	 * @generated
	 */
	public Adapter createDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Documentable <em>Documentable</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Documentable
	 * @generated
	 */
	public Adapter createDocumentableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.MediaType <em>Media Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.MediaType
	 * @generated
	 */
	public Adapter createMediaTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.TypedRequest <em>Typed Request</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.TypedRequest
	 * @generated
	 */
	public Adapter createTypedRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.TypedResponse <em>Typed Response</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.TypedResponse
	 * @generated
	 */
	public Adapter createTypedResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.URIParameter <em>URI Parameter</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.URIParameter
	 * @generated
	 */
	public Adapter createURIParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.MatrixParameter <em>Matrix Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.MatrixParameter
	 * @generated
	 */
	public Adapter createMatrixParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.TemplateParameter
	 * @generated
	 */
	public Adapter createTemplateParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.CollectionResource <em>Collection
	 * Resource</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.CollectionResource
	 * @generated
	 */
	public Adapter createCollectionResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ObjectResource <em>Object Resource</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ObjectResource
	 * @generated
	 */
	public Adapter createObjectResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.CollectionParameter <em>Collection
	 * Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.CollectionParameter
	 * @generated
	 */
	public Adapter createCollectionParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PropertyReference <em>Property Reference</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PropertyReference
	 * @generated
	 */
	public Adapter createPropertyReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SourceReference
	 * @generated
	 */
	public Adapter createSourceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.MessageParameter <em>Message Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.MessageParameter
	 * @generated
	 */
	public Adapter createMessageParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ZenModel <em>Zen Model</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ZenModel
	 * @generated
	 */
	public Adapter createZenModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ResourceAPI <em>Resource API</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ResourceAPI
	 * @generated
	 */
	public Adapter createResourceAPIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ServiceDataResource <em>Service Data
	 * Resource</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ServiceDataResource
	 * @generated
	 */
	public Adapter createServiceDataResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ReferenceTreatment <em>Reference
	 * Treatment</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ReferenceTreatment
	 * @generated
	 */
	public Adapter createReferenceTreatmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ReferenceRealization <em>Reference
	 * Realization</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ReferenceRealization
	 * @generated
	 */
	public Adapter createReferenceRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ReferenceLink <em>Reference Link</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ReferenceLink
	 * @generated
	 */
	public Adapter createReferenceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ReferenceEmbed <em>Reference Embed</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ReferenceEmbed
	 * @generated
	 */
	public Adapter createReferenceEmbedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.NamedLinkDescriptor <em>Named Link
	 * Descriptor</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.NamedLinkDescriptor
	 * @generated
	 */
	public Adapter createNamedLinkDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PathSegment <em>Path Segment</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PathSegment
	 * @generated
	 */
	public Adapter createPathSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PrimitiveTypeSourceReference <em>Primitive Type
	 * Source Reference</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PrimitiveTypeSourceReference
	 * @generated
	 */
	public Adapter createPrimitiveTypeSourceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.reprezen.rapidml.URI
	 * <em>URI</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.URI
	 * @generated
	 */
	public Adapter createURIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.URISegment <em>URI Segment</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.URISegment
	 * @generated
	 */
	public Adapter createURISegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.URISegmentWithParameter <em>URI Segment With
	 * Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.URISegmentWithParameter
	 * @generated
	 */
	public Adapter createURISegmentWithParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PropertyRealization <em>Property
	 * Realization</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PropertyRealization
	 * @generated
	 */
	public Adapter createPropertyRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.LinkRelation <em>Link Relation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.LinkRelation
	 * @generated
	 */
	public Adapter createLinkRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.WithExamples <em>With Examples</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.WithExamples
	 * @generated
	 */
	public Adapter createWithExamplesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Example <em>Example</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Example
	 * @generated
	 */
	public Adapter createExampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.InlineExample <em>Inline Example</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.InlineExample
	 * @generated
	 */
	public Adapter createInlineExampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ExternalExample <em>External Example</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ExternalExample
	 * @generated
	 */
	public Adapter createExternalExampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.HasStringValue <em>Has String Value</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.HasStringValue
	 * @generated
	 */
	public Adapter createHasStringValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ImportDeclaration <em>Import Declaration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ImportDeclaration
	 * @generated
	 */
	public Adapter createImportDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ObjectRealization <em>Object Realization</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ObjectRealization
	 * @generated
	 */
	public Adapter createObjectRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.CollectionReferenceElement <em>Collection
	 * Reference Element</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.CollectionReferenceElement
	 * @generated
	 */
	public Adapter createCollectionReferenceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.HasSecurityValue <em>Has Security Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.HasSecurityValue
	 * @generated
	 */
	public Adapter createHasSecurityValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SecurityScheme <em>Security Scheme</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SecurityScheme
	 * @generated
	 */
	public Adapter createSecuritySchemeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.AuthenticationMethod <em>Authentication
	 * Method</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.AuthenticationMethod
	 * @generated
	 */
	public Adapter createAuthenticationMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SecurityScope <em>Security Scope</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SecurityScope
	 * @generated
	 */
	public Adapter createSecurityScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SecuritySchemeParameter <em>Security Scheme
	 * Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SecuritySchemeParameter
	 * @generated
	 */
	public Adapter createSecuritySchemeParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SecuritySchemeLibrary <em>Security Scheme
	 * Library</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SecuritySchemeLibrary
	 * @generated
	 */
	public Adapter createSecuritySchemeLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.RealizationContainer <em>Realization
	 * Container</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.RealizationContainer
	 * @generated
	 */
	public Adapter createRealizationContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Extensible <em>Extensible</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Extensible
	 * @generated
	 */
	public Adapter createExtensibleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Extension <em>Extension</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Extension
	 * @generated
	 */
	public Adapter createExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.RealizationModelLocation <em>Realization Model
	 * Location</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.RealizationModelLocation
	 * @generated
	 */
	public Adapter createRealizationModelLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.HasTitle <em>Has Title</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.HasTitle
	 * @generated
	 */
	public Adapter createHasTitleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Operation <em>Operation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Feature <em>Feature</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ReferenceProperty <em>Reference Property</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ReferenceProperty
	 * @generated
	 */
	public Adapter createReferencePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PrimitiveProperty <em>Primitive Property</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PrimitiveProperty
	 * @generated
	 */
	public Adapter createPrimitivePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Structure <em>Structure</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Structure
	 * @generated
	 */
	public Adapter createStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.DataModel <em>Data Model</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.DataModel
	 * @generated
	 */
	public Adapter createDataModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.WithDataExamples <em>With Data Examples</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.WithDataExamples
	 * @generated
	 */
	public Adapter createWithDataExamplesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.DataExample <em>Data Example</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.DataExample
	 * @generated
	 */
	public Adapter createDataExampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.InlineDataExample <em>Inline Data
	 * Example</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.InlineDataExample
	 * @generated
	 */
	public Adapter createInlineDataExampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Constraint <em>Constraint</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Enumeration <em>Enumeration</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Enumeration
	 * @generated
	 */
	public Adapter createEnumerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SimpleType <em>Simple Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SimpleType
	 * @generated
	 */
	public Adapter createSimpleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.EnumConstant <em>Enum Constant</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.EnumConstant
	 * @generated
	 */
	public Adapter createEnumConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.UserDefinedType <em>User Defined Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.UserDefinedType
	 * @generated
	 */
	public Adapter createUserDefinedTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PrimitiveType <em>Primitive Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.DataType <em>Data Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.SingleValueType <em>Single Value Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.SingleValueType
	 * @generated
	 */
	public Adapter createSingleValueTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ConstrainableType <em>Constrainable Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ConstrainableType
	 * @generated
	 */
	public Adapter createConstrainableTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Inheritable <em>Inheritable</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Inheritable
	 * @generated
	 */
	public Adapter createInheritableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.MediaTypesLibrary <em>Media Types
	 * Library</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.MediaTypesLibrary
	 * @generated
	 */
	public Adapter createMediaTypesLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.LinkRelationsLibrary <em>Link Relations
	 * Library</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.LinkRelationsLibrary
	 * @generated
	 */
	public Adapter createLinkRelationsLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.PrimitiveTypesLibrary <em>Primitive Types
	 * Library</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.PrimitiveTypesLibrary
	 * @generated
	 */
	public Adapter createPrimitiveTypesLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.Element <em>Element</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ReferenceElement <em>Reference Element</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ReferenceElement
	 * @generated
	 */
	public Adapter createReferenceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.LengthConstraint <em>Length Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.LengthConstraint
	 * @generated
	 */
	public Adapter createLengthConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.RegExConstraint <em>Reg Ex Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.RegExConstraint
	 * @generated
	 */
	public Adapter createRegExConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link com.reprezen.rapidml.ValueRangeConstraint <em>Value Range
	 * Constraint</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.reprezen.rapidml.ValueRangeConstraint
	 * @generated
	 */
	public Adapter createValueRangeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // RapidmlAdapterFactory
