/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.modelsolv.reprezen.restapi.RestapiFactory
 * @model kind="package"
 * @generated
 */
public interface RestapiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "restapi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.modelsolv.com/reprezen/restapi/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "restapi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RestapiPackage eINSTANCE = com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.DocumentableImpl <em>Documentable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.DocumentableImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDocumentable()
	 * @generated
	 */
	int DOCUMENTABLE = 6;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTABLE__DOCUMENTATION = 0;

	/**
	 * The number of structural features of the '<em>Documentable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.RESTElementImpl <em>REST Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.RESTElementImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRESTElement()
	 * @generated
	 */
	int REST_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_ELEMENT__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_ELEMENT__EXTENSIONS = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>REST Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_ELEMENT_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ResourceDefinitionImpl <em>Resource Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ResourceDefinitionImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getResourceDefinition()
	 * @generated
	 */
	int RESOURCE_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__DOCUMENTATION = REST_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__EXTENSIONS = REST_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__EXAMPLES = REST_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__SECURED_BY = REST_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__METHODS = REST_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__MEDIA_TYPES = REST_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__NAME = REST_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>All Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__ALL_MEDIA_TYPES = REST_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>URI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION__URI = REST_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Resource Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFINITION_FEATURE_COUNT = REST_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.Extensible <em>Extensible</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.Extensible
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExtensible()
	 * @generated
	 */
	int EXTENSIBLE = 49;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE__EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Extensible</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.RealizationContainerImpl <em>Realization Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.RealizationContainerImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRealizationContainer()
	 * @generated
	 */
	int REALIZATION_CONTAINER = 48;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__EXTENSIONS = EXTENSIBLE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION = EXTENSIBLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION = EXTENSIBLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__PROPERTIES = EXTENSIBLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__REFERENCE_TREATMENTS = EXTENSIBLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__DATA_TYPE = EXTENSIBLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__REALIZATION_NAME = EXTENSIBLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER__EFFECTIVE_REALIZATION = EXTENSIBLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Realization Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONTAINER_FEATURE_COUNT = EXTENSIBLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.TypedMessageImpl <em>Typed Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.TypedMessageImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTypedMessage()
	 * @generated
	 */
	int TYPED_MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__EXTENSIONS = REALIZATION_CONTAINER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__WITH_DEFAULT_REALIZATION = REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__INLINE_OBJECT_REALIZATION = REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__PROPERTIES = REALIZATION_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__REFERENCE_TREATMENTS = REALIZATION_CONTAINER__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__DATA_TYPE = REALIZATION_CONTAINER__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__REALIZATION_NAME = REALIZATION_CONTAINER__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__EFFECTIVE_REALIZATION = REALIZATION_CONTAINER__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__DOCUMENTATION = REALIZATION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__EXAMPLES = REALIZATION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__PARAMETERS = REALIZATION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__RESOURCE_TYPE = REALIZATION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Use Parent Type Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE = REALIZATION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE__MEDIA_TYPES = REALIZATION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Typed Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MESSAGE_FEATURE_COUNT = REALIZATION_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.MethodImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DOCUMENTATION = REST_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__EXTENSIONS = REST_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__SECURED_BY = REST_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__REQUEST = REST_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Responses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__RESPONSES = REST_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ID = REST_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Http Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__HTTP_METHOD = REST_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Containing Resource Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CONTAINING_RESOURCE_DEFINITION = REST_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = REST_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DOCUMENTATION = REST_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__EXTENSIONS = REST_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = REST_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__REQUIRED = REST_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DEFAULT = REST_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__FIXED = REST_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__SOURCE_REFERENCE = REST_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = REST_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.DocumentationImpl <em>Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.DocumentationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDocumentation()
	 * @generated
	 */
	int DOCUMENTATION = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.MediaTypeImpl <em>Media Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.MediaTypeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMediaType()
	 * @generated
	 */
	int MEDIA_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__DOCUMENTATION = REST_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__EXTENSIONS = REST_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__NAME = REST_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Spec URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__SPEC_URL = REST_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__DERIVED_FROM = REST_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Media Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE_FEATURE_COUNT = REST_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.TypedRequestImpl <em>Typed Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.TypedRequestImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTypedRequest()
	 * @generated
	 */
	int TYPED_REQUEST = 8;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__EXTENSIONS = TYPED_MESSAGE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__WITH_DEFAULT_REALIZATION = TYPED_MESSAGE__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__INLINE_OBJECT_REALIZATION = TYPED_MESSAGE__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__PROPERTIES = TYPED_MESSAGE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__REFERENCE_TREATMENTS = TYPED_MESSAGE__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__DATA_TYPE = TYPED_MESSAGE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__REALIZATION_NAME = TYPED_MESSAGE__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__EFFECTIVE_REALIZATION = TYPED_MESSAGE__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__DOCUMENTATION = TYPED_MESSAGE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__EXAMPLES = TYPED_MESSAGE__EXAMPLES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__PARAMETERS = TYPED_MESSAGE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__RESOURCE_TYPE = TYPED_MESSAGE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Use Parent Type Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__USE_PARENT_TYPE_REFERENCE = TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__MEDIA_TYPES = TYPED_MESSAGE__MEDIA_TYPES;

	/**
	 * The feature id for the '<em><b>Containing Method</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST__CONTAINING_METHOD = TYPED_MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REQUEST_FEATURE_COUNT = TYPED_MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.TypedResponseImpl <em>Typed Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.TypedResponseImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTypedResponse()
	 * @generated
	 */
	int TYPED_RESPONSE = 9;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__EXTENSIONS = TYPED_MESSAGE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__WITH_DEFAULT_REALIZATION = TYPED_MESSAGE__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__INLINE_OBJECT_REALIZATION = TYPED_MESSAGE__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__PROPERTIES = TYPED_MESSAGE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__REFERENCE_TREATMENTS = TYPED_MESSAGE__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__DATA_TYPE = TYPED_MESSAGE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__REALIZATION_NAME = TYPED_MESSAGE__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__EFFECTIVE_REALIZATION = TYPED_MESSAGE__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__DOCUMENTATION = TYPED_MESSAGE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__EXAMPLES = TYPED_MESSAGE__EXAMPLES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__PARAMETERS = TYPED_MESSAGE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__RESOURCE_TYPE = TYPED_MESSAGE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Use Parent Type Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__USE_PARENT_TYPE_REFERENCE = TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__MEDIA_TYPES = TYPED_MESSAGE__MEDIA_TYPES;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__STATUS_CODE = TYPED_MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Containing Method</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE__CONTAINING_METHOD = TYPED_MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESPONSE_FEATURE_COUNT = TYPED_MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.URIParameterImpl <em>URI Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.URIParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURIParameter()
	 * @generated
	 */
	int URI_PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__DOCUMENTATION = PARAMETER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__EXTENSIONS = PARAMETER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__REQUIRED = PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__DEFAULT = PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__FIXED = PARAMETER__FIXED;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__SOURCE_REFERENCE = PARAMETER__SOURCE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Uri Segment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__URI_SEGMENT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Containing URI</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER__CONTAINING_URI = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>URI Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.MatrixParameterImpl <em>Matrix Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.MatrixParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMatrixParameter()
	 * @generated
	 */
	int MATRIX_PARAMETER = 11;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__DOCUMENTATION = URI_PARAMETER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__EXTENSIONS = URI_PARAMETER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__NAME = URI_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__REQUIRED = URI_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__DEFAULT = URI_PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__FIXED = URI_PARAMETER__FIXED;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__SOURCE_REFERENCE = URI_PARAMETER__SOURCE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Uri Segment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__URI_SEGMENT = URI_PARAMETER__URI_SEGMENT;

	/**
	 * The feature id for the '<em><b>Containing URI</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER__CONTAINING_URI = URI_PARAMETER__CONTAINING_URI;

	/**
	 * The number of structural features of the '<em>Matrix Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_PARAMETER_FEATURE_COUNT = URI_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.TemplateParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTemplateParameter()
	 * @generated
	 */
	int TEMPLATE_PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__DOCUMENTATION = URI_PARAMETER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__EXTENSIONS = URI_PARAMETER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__NAME = URI_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__REQUIRED = URI_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__DEFAULT = URI_PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__FIXED = URI_PARAMETER__FIXED;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__SOURCE_REFERENCE = URI_PARAMETER__SOURCE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Uri Segment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__URI_SEGMENT = URI_PARAMETER__URI_SEGMENT;

	/**
	 * The feature id for the '<em><b>Containing URI</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__CONTAINING_URI = URI_PARAMETER__CONTAINING_URI;

	/**
	 * The number of structural features of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_FEATURE_COUNT = URI_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ServiceDataResourceImpl <em>Service Data Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ServiceDataResourceImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getServiceDataResource()
	 * @generated
	 */
	int SERVICE_DATA_RESOURCE = 21;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__EXTENSIONS = REALIZATION_CONTAINER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__WITH_DEFAULT_REALIZATION = REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__INLINE_OBJECT_REALIZATION = REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__PROPERTIES = REALIZATION_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__REFERENCE_TREATMENTS = REALIZATION_CONTAINER__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__DATA_TYPE = REALIZATION_CONTAINER__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__REALIZATION_NAME = REALIZATION_CONTAINER__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__EFFECTIVE_REALIZATION = REALIZATION_CONTAINER__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__DOCUMENTATION = REALIZATION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__EXAMPLES = REALIZATION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__SECURED_BY = REALIZATION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__METHODS = REALIZATION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__MEDIA_TYPES = REALIZATION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__NAME = REALIZATION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>All Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES = REALIZATION_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__URI = REALIZATION_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__DEFAULT = REALIZATION_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Defined Link Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS = REALIZATION_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Service Data Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DATA_RESOURCE_FEATURE_COUNT = REALIZATION_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.CollectionResourceImpl <em>Collection Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.CollectionResourceImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionResource()
	 * @generated
	 */
	int COLLECTION_RESOURCE = 13;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__EXTENSIONS = SERVICE_DATA_RESOURCE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__WITH_DEFAULT_REALIZATION = SERVICE_DATA_RESOURCE__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__INLINE_OBJECT_REALIZATION = SERVICE_DATA_RESOURCE__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__PROPERTIES = SERVICE_DATA_RESOURCE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__REFERENCE_TREATMENTS = SERVICE_DATA_RESOURCE__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__DATA_TYPE = SERVICE_DATA_RESOURCE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__REALIZATION_NAME = SERVICE_DATA_RESOURCE__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__EFFECTIVE_REALIZATION = SERVICE_DATA_RESOURCE__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__DOCUMENTATION = SERVICE_DATA_RESOURCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__EXAMPLES = SERVICE_DATA_RESOURCE__EXAMPLES;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__SECURED_BY = SERVICE_DATA_RESOURCE__SECURED_BY;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__METHODS = SERVICE_DATA_RESOURCE__METHODS;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__MEDIA_TYPES = SERVICE_DATA_RESOURCE__MEDIA_TYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__NAME = SERVICE_DATA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>All Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__ALL_MEDIA_TYPES = SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES;

	/**
	 * The feature id for the '<em><b>URI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__URI = SERVICE_DATA_RESOURCE__URI;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__DEFAULT = SERVICE_DATA_RESOURCE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Defined Link Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__DEFINED_LINK_DESCRIPTORS = SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Collection Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__COLLECTION_PARAMETERS = SERVICE_DATA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__REFERENCE_ELEMENTS = SERVICE_DATA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Realization Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND = SERVICE_DATA_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESOURCE_FEATURE_COUNT = SERVICE_DATA_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ObjectResourceImpl <em>Object Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ObjectResourceImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getObjectResource()
	 * @generated
	 */
	int OBJECT_RESOURCE = 14;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__EXTENSIONS = SERVICE_DATA_RESOURCE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__WITH_DEFAULT_REALIZATION = SERVICE_DATA_RESOURCE__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__INLINE_OBJECT_REALIZATION = SERVICE_DATA_RESOURCE__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__PROPERTIES = SERVICE_DATA_RESOURCE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__REFERENCE_TREATMENTS = SERVICE_DATA_RESOURCE__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__DATA_TYPE = SERVICE_DATA_RESOURCE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__REALIZATION_NAME = SERVICE_DATA_RESOURCE__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__EFFECTIVE_REALIZATION = SERVICE_DATA_RESOURCE__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__DOCUMENTATION = SERVICE_DATA_RESOURCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__EXAMPLES = SERVICE_DATA_RESOURCE__EXAMPLES;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__SECURED_BY = SERVICE_DATA_RESOURCE__SECURED_BY;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__METHODS = SERVICE_DATA_RESOURCE__METHODS;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__MEDIA_TYPES = SERVICE_DATA_RESOURCE__MEDIA_TYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__NAME = SERVICE_DATA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>All Media Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__ALL_MEDIA_TYPES = SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES;

	/**
	 * The feature id for the '<em><b>URI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__URI = SERVICE_DATA_RESOURCE__URI;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__DEFAULT = SERVICE_DATA_RESOURCE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Defined Link Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE__DEFINED_LINK_DESCRIPTORS = SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS;

	/**
	 * The number of structural features of the '<em>Object Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESOURCE_FEATURE_COUNT = SERVICE_DATA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.CollectionParameterImpl <em>Collection Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.CollectionParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionParameter()
	 * @generated
	 */
	int COLLECTION_PARAMETER = 15;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__DOCUMENTATION = PARAMETER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__EXTENSIONS = PARAMETER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__REQUIRED = PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__DEFAULT = PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__FIXED = PARAMETER__FIXED;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__SOURCE_REFERENCE = PARAMETER__SOURCE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Containing Resource Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SourceReferenceImpl <em>Source Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SourceReferenceImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSourceReference()
	 * @generated
	 */
	int SOURCE_REFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Containing Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE__CONTAINING_PARAMETER = 0;

	/**
	 * The number of structural features of the '<em>Source Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PropertyReferenceImpl <em>Property Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PropertyReferenceImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPropertyReference()
	 * @generated
	 */
	int PROPERTY_REFERENCE = 16;

	/**
	 * The feature id for the '<em><b>Containing Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE__CONTAINING_PARAMETER = SOURCE_REFERENCE__CONTAINING_PARAMETER;

	/**
	 * The feature id for the '<em><b>Conceptual Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE__CONCEPTUAL_FEATURE = SOURCE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE_FEATURE_COUNT = SOURCE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.MessageParameterImpl <em>Message Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.MessageParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMessageParameter()
	 * @generated
	 */
	int MESSAGE_PARAMETER = 18;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__DOCUMENTATION = PARAMETER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__EXTENSIONS = PARAMETER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__REQUIRED = PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__DEFAULT = PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__FIXED = PARAMETER__FIXED;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__SOURCE_REFERENCE = PARAMETER__SOURCE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Containing Message</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__CONTAINING_MESSAGE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Http Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER__HTTP_LOCATION = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl <em>Zen Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ZenModelImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getZenModel()
	 * @generated
	 */
	int ZEN_MODEL = 19;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__EXTENSIONS = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__TITLE = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__NAME = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__NAMESPACE = DOCUMENTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource AP Is</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__RESOURCE_AP_IS = DOCUMENTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Data Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__DATA_MODELS = DOCUMENTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Media Types Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__MEDIA_TYPES_LIBRARY = DOCUMENTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Link Relations Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__LINK_RELATIONS_LIBRARY = DOCUMENTABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Primitive Types Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY = DOCUMENTABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__IMPORTS = DOCUMENTABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Security Schemes Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL__SECURITY_SCHEMES_LIBRARY = DOCUMENTABLE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Zen Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZEN_MODEL_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ResourceAPIImpl <em>Resource API</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ResourceAPIImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getResourceAPI()
	 * @generated
	 */
	int RESOURCE_API = 20;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__DOCUMENTATION = REST_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__EXTENSIONS = REST_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__SECURED_BY = REST_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__TITLE = REST_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__NAME = REST_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__VERSION = REST_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__BASE_URI = REST_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Resource Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__OWNED_RESOURCE_DEFINITIONS = REST_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Service Data Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__SERVICE_DATA_MODELS = REST_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Formats</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__FORMATS = REST_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Defined Media Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__DEFINED_MEDIA_TYPES = REST_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Defined Link Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__DEFINED_LINK_RELATIONS = REST_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Default Reference Realizations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS = REST_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Auto Realizations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API__AUTO_REALIZATIONS = REST_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Resource API</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_API_FEATURE_COUNT = REST_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceTreatmentImpl <em>Reference Treatment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ReferenceTreatmentImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceTreatment()
	 * @generated
	 */
	int REFERENCE_TREATMENT = 22;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TREATMENT__EXTENSIONS = EXTENSIBLE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Reference Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TREATMENT__REFERENCE_ELEMENT = EXTENSIBLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TREATMENT__REFERENCE_REALIZATION = EXTENSIBLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Reference Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION = EXTENSIBLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Treatment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TREATMENT_FEATURE_COUNT = EXTENSIBLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceRealizationImpl <em>Reference Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ReferenceRealizationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceRealization()
	 * @generated
	 */
	int REFERENCE_REALIZATION = 23;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__EXTENSIONS = REALIZATION_CONTAINER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__WITH_DEFAULT_REALIZATION = REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__INLINE_OBJECT_REALIZATION = REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__PROPERTIES = REALIZATION_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__REFERENCE_TREATMENTS = REALIZATION_CONTAINER__REFERENCE_TREATMENTS;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__DATA_TYPE = REALIZATION_CONTAINER__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__REALIZATION_NAME = REALIZATION_CONTAINER__REALIZATION_NAME;

	/**
	 * The feature id for the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__EFFECTIVE_REALIZATION = REALIZATION_CONTAINER__EFFECTIVE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Target Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__TARGET_RESOURCE = REALIZATION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Realization Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__REALIZATION_TYPE = REALIZATION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION__MULTI_VALUED = REALIZATION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REALIZATION_FEATURE_COUNT = REALIZATION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceLinkImpl <em>Reference Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ReferenceLinkImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceLink()
	 * @generated
	 */
	int REFERENCE_LINK = 24;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__EXTENSIONS = REFERENCE_TREATMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Reference Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__REFERENCE_ELEMENT = REFERENCE_TREATMENT__REFERENCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Reference Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__REFERENCE_REALIZATION = REFERENCE_TREATMENT__REFERENCE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Owned Reference Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__OWNED_REFERENCE_REALIZATION = REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__NAME = REFERENCE_TREATMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__LINK_RELATION = REFERENCE_TREATMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Collection Realization Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL = REFERENCE_TREATMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LINK_FEATURE_COUNT = REFERENCE_TREATMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceEmbedImpl <em>Reference Embed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ReferenceEmbedImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceEmbed()
	 * @generated
	 */
	int REFERENCE_EMBED = 25;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EMBED__EXTENSIONS = REFERENCE_TREATMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Reference Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EMBED__REFERENCE_ELEMENT = REFERENCE_TREATMENT__REFERENCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Reference Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EMBED__REFERENCE_REALIZATION = REFERENCE_TREATMENT__REFERENCE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Owned Reference Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EMBED__OWNED_REFERENCE_REALIZATION = REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION;

	/**
	 * The number of structural features of the '<em>Reference Embed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EMBED_FEATURE_COUNT = REFERENCE_TREATMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ObjectRealizationImpl <em>Object Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ObjectRealizationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getObjectRealization()
	 * @generated
	 */
	int OBJECT_REALIZATION = 40;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REALIZATION__EXTENSIONS = EXTENSIBLE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Exclusive Property List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST = EXTENSIBLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overridden Property List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST = EXTENSIBLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Excluded Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REALIZATION__EXCLUDED_PROPERTIES = EXTENSIBLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realization Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REALIZATION__REALIZATION_CONTAINER = EXTENSIBLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Object Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REALIZATION_FEATURE_COUNT = EXTENSIBLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.NamedLinkDescriptorImpl <em>Named Link Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.NamedLinkDescriptorImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getNamedLinkDescriptor()
	 * @generated
	 */
	int NAMED_LINK_DESCRIPTOR = 26;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__EXTENSIONS = OBJECT_REALIZATION__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Exclusive Property List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__EXCLUSIVE_PROPERTY_LIST = OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST;

	/**
	 * The feature id for the '<em><b>Overridden Property List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__OVERRIDDEN_PROPERTY_LIST = OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST;

	/**
	 * The feature id for the '<em><b>Excluded Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__EXCLUDED_PROPERTIES = OBJECT_REALIZATION__EXCLUDED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Realization Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__REALIZATION_CONTAINER = OBJECT_REALIZATION__REALIZATION_CONTAINER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__NAME = OBJECT_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR__DEFAULT = OBJECT_REALIZATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Link Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_LINK_DESCRIPTOR_FEATURE_COUNT = OBJECT_REALIZATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PathSegmentImpl <em>Path Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PathSegmentImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPathSegment()
	 * @generated
	 */
	int PATH_SEGMENT = 27;

	/**
	 * The feature id for the '<em><b>Reference Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SEGMENT__REFERENCE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Path Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SEGMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypeSourceReferenceImpl <em>Primitive Type Source Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PrimitiveTypeSourceReferenceImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveTypeSourceReference()
	 * @generated
	 */
	int PRIMITIVE_TYPE_SOURCE_REFERENCE = 28;

	/**
	 * The feature id for the '<em><b>Containing Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_SOURCE_REFERENCE__CONTAINING_PARAMETER = SOURCE_REFERENCE__CONTAINING_PARAMETER;

	/**
	 * The feature id for the '<em><b>Simple Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE = SOURCE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type Source Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_SOURCE_REFERENCE_FEATURE_COUNT = SOURCE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.HasStringValue <em>Has String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.HasStringValue
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHasStringValue()
	 * @generated
	 */
	int HAS_STRING_VALUE = 38;

	/**
	 * The number of structural features of the '<em>Has String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_STRING_VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.URIImpl <em>URI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.URIImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURI()
	 * @generated
	 */
	int URI = 29;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI__SEGMENTS = HAS_STRING_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI__URI_PARAMETERS = HAS_STRING_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_FEATURE_COUNT = HAS_STRING_VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.URISegmentImpl <em>URI Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.URISegmentImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURISegment()
	 * @generated
	 */
	int URI_SEGMENT = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_SEGMENT__NAME = HAS_STRING_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>URI Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_SEGMENT_FEATURE_COUNT = HAS_STRING_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.URISegmentWithParameterImpl <em>URI Segment With Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.URISegmentWithParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURISegmentWithParameter()
	 * @generated
	 */
	int URI_SEGMENT_WITH_PARAMETER = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_SEGMENT_WITH_PARAMETER__NAME = URI_SEGMENT__NAME;

	/**
	 * The number of structural features of the '<em>URI Segment With Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_SEGMENT_WITH_PARAMETER_FEATURE_COUNT = URI_SEGMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.ConstrainableType <em>Constrainable Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.ConstrainableType
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getConstrainableType()
	 * @generated
	 */
	int CONSTRAINABLE_TYPE = 75;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINABLE_TYPE__EXTENSIONS = EXTENSIBLE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINABLE_TYPE__CONSTRAINTS = EXTENSIBLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constrainable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINABLE_TYPE_FEATURE_COUNT = EXTENSIBLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PropertyRealizationImpl <em>Property Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PropertyRealizationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPropertyRealization()
	 * @generated
	 */
	int PROPERTY_REALIZATION = 32;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REALIZATION__EXTENSIONS = CONSTRAINABLE_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REALIZATION__CONSTRAINTS = CONSTRAINABLE_TYPE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REALIZATION__BASE_PROPERTY = CONSTRAINABLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REALIZATION__CARDINALITY = CONSTRAINABLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REALIZATION_FEATURE_COUNT = CONSTRAINABLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.LinkRelationImpl <em>Link Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.LinkRelationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getLinkRelation()
	 * @generated
	 */
	int LINK_RELATION = 33;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATION__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATION__NAME = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Spec URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATION__SPEC_URL = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATION_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.WithExamplesImpl <em>With Examples</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.WithExamplesImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getWithExamples()
	 * @generated
	 */
	int WITH_EXAMPLES = 34;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_EXAMPLES__EXAMPLES = 0;

	/**
	 * The number of structural features of the '<em>With Examples</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_EXAMPLES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ExampleImpl <em>Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ExampleImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExample()
	 * @generated
	 */
	int EXAMPLE = 35;

	/**
	 * The number of structural features of the '<em>Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.InlineExampleImpl <em>Inline Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.InlineExampleImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getInlineExample()
	 * @generated
	 */
	int INLINE_EXAMPLE = 36;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE_EXAMPLE__BODY = EXAMPLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inline Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE_EXAMPLE_FEATURE_COUNT = EXAMPLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ExternalExampleImpl <em>External Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ExternalExampleImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExternalExample()
	 * @generated
	 */
	int EXTERNAL_EXAMPLE = 37;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_EXAMPLE__PATH = EXAMPLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_EXAMPLE_FEATURE_COUNT = EXAMPLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ImportDeclarationImpl <em>Import Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ImportDeclarationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getImportDeclaration()
	 * @generated
	 */
	int IMPORT_DECLARATION = 39;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DECLARATION__IMPORT_URI = 0;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DECLARATION__IMPORTED_NAMESPACE = 1;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DECLARATION__ALIAS = 2;

	/**
	 * The feature id for the '<em><b>Imported Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DECLARATION__IMPORTED_MODEL = 3;

	/**
	 * The number of structural features of the '<em>Import Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DECLARATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ElementImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 70;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CARDINALITY = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceElementImpl <em>Reference Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ReferenceElementImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceElement()
	 * @generated
	 */
	int REFERENCE_ELEMENT = 71;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ELEMENT__CARDINALITY = ELEMENT__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ELEMENT__DATA_TYPE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.CollectionReferenceElementImpl <em>Collection Reference Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.CollectionReferenceElementImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionReferenceElement()
	 * @generated
	 */
	int COLLECTION_REFERENCE_ELEMENT = 41;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REFERENCE_ELEMENT__CARDINALITY = REFERENCE_ELEMENT__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REFERENCE_ELEMENT__DATA_TYPE = REFERENCE_ELEMENT__DATA_TYPE;

	/**
	 * The number of structural features of the '<em>Collection Reference Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REFERENCE_ELEMENT_FEATURE_COUNT = REFERENCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.HasSecurityValueImpl <em>Has Security Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.HasSecurityValueImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHasSecurityValue()
	 * @generated
	 */
	int HAS_SECURITY_VALUE = 42;

	/**
	 * The feature id for the '<em><b>Secured By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_SECURITY_VALUE__SECURED_BY = 0;

	/**
	 * The number of structural features of the '<em>Has Security Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_SECURITY_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl <em>Security Scheme</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecurityScheme()
	 * @generated
	 */
	int SECURITY_SCHEME = 43;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__EXTENSIONS = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__NAME = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__TYPE = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__SCOPES = DOCUMENTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__SETTINGS = DOCUMENTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__PARAMETERS = DOCUMENTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Error Responses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__ERROR_RESPONSES = DOCUMENTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__FLOW = DOCUMENTABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Security Scheme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.AuthenticationMethodImpl <em>Authentication Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.AuthenticationMethodImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getAuthenticationMethod()
	 * @generated
	 */
	int AUTHENTICATION_METHOD = 44;

	/**
	 * The feature id for the '<em><b>Scheme</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATION_METHOD__SCHEME = 0;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATION_METHOD__SCOPES = 1;

	/**
	 * The number of structural features of the '<em>Authentication Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATION_METHOD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SecurityScopeImpl <em>Security Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SecurityScopeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecurityScope()
	 * @generated
	 */
	int SECURITY_SCOPE = 45;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCOPE__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCOPE__NAME = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Security Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCOPE_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeParameterImpl <em>Security Scheme Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SecuritySchemeParameterImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecuritySchemeParameter()
	 * @generated
	 */
	int SECURITY_SCHEME_PARAMETER = 46;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_PARAMETER__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_PARAMETER__NAME = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_PARAMETER__VALUE = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Security Scheme Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_PARAMETER_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeLibraryImpl <em>Security Scheme Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SecuritySchemeLibraryImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecuritySchemeLibrary()
	 * @generated
	 */
	int SECURITY_SCHEME_LIBRARY = 47;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_LIBRARY__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Security Schemes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_LIBRARY__NAME = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Security Scheme Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_LIBRARY_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ExtensionImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.RealizationModelLocationImpl <em>Realization Model Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.RealizationModelLocationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRealizationModelLocation()
	 * @generated
	 */
	int REALIZATION_MODEL_LOCATION = 51;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_MODEL_LOCATION__URI = 0;

	/**
	 * The number of structural features of the '<em>Realization Model Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_MODEL_LOCATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.HasTitleImpl <em>Has Title</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.HasTitleImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHasTitle()
	 * @generated
	 */
	int HAS_TITLE = 52;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TITLE__TITLE = 0;

	/**
	 * The number of structural features of the '<em>Has Title</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TITLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.OperationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 53;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.FeatureImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 54;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CARDINALITY = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXTENSIONS = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Containing Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONTAINING_DATA_TYPE = DOCUMENTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__RESTRICTION = DOCUMENTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__READ_ONLY = DOCUMENTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__KEY = DOCUMENTABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ReferencePropertyImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceProperty()
	 * @generated
	 */
	int REFERENCE_PROPERTY = 55;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__DOCUMENTATION = FEATURE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__CARDINALITY = FEATURE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__EXTENSIONS = FEATURE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Containing Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__CONTAINING_DATA_TYPE = FEATURE__CONTAINING_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__RESTRICTION = FEATURE__RESTRICTION;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__READ_ONLY = FEATURE__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__KEY = FEATURE__KEY;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__DATA_TYPE = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__TYPE = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__INVERSE = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__CONTAINMENT = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__CONTAINER = FEATURE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Reference Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitivePropertyImpl <em>Primitive Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PrimitivePropertyImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveProperty()
	 * @generated
	 */
	int PRIMITIVE_PROPERTY = 56;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__DOCUMENTATION = FEATURE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__CARDINALITY = FEATURE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__EXTENSIONS = FEATURE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Containing Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__CONTAINING_DATA_TYPE = FEATURE__CONTAINING_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__RESTRICTION = FEATURE__RESTRICTION;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__READ_ONLY = FEATURE__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__KEY = FEATURE__KEY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__CONSTRAINTS = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY__TYPE = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PROPERTY_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.DataTypeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 68;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__EXTENSIONS = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.StructureImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 57;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__EXTENSIONS = DATA_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Data Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__DATA_EXAMPLES = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_FEATURES = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_ELEMENTS = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_OPERATIONS = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__SUPERTYPES = DATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>All Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__ALL_SUPERTYPES = DATA_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.DataModelImpl <em>Data Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.DataModelImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDataModel()
	 * @generated
	 */
	int DATA_MODEL = 58;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__TITLE = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__OWNED_DATA_TYPES = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__NAME = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.WithDataExamplesImpl <em>With Data Examples</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.WithDataExamplesImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getWithDataExamples()
	 * @generated
	 */
	int WITH_DATA_EXAMPLES = 59;

	/**
	 * The feature id for the '<em><b>Data Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_DATA_EXAMPLES__DATA_EXAMPLES = 0;

	/**
	 * The number of structural features of the '<em>With Data Examples</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_DATA_EXAMPLES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.DataExampleImpl <em>Data Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.DataExampleImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDataExample()
	 * @generated
	 */
	int DATA_EXAMPLE = 60;

	/**
	 * The number of structural features of the '<em>Data Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXAMPLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.InlineDataExampleImpl <em>Inline Data Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.InlineDataExampleImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getInlineDataExample()
	 * @generated
	 */
	int INLINE_DATA_EXAMPLE = 61;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE_DATA_EXAMPLE__BODY = DATA_EXAMPLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inline Data Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLINE_DATA_EXAMPLE_FEATURE_COUNT = DATA_EXAMPLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ConstraintImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 62;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXTENSIONS = EXTENSIBLE__EXTENSIONS;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = EXTENSIBLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SingleValueTypeImpl <em>Single Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SingleValueTypeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSingleValueType()
	 * @generated
	 */
	int SINGLE_VALUE_TYPE = 69;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_TYPE__EXTENSIONS = DATA_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Single Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.EnumerationImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 63;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__DOCUMENTATION = SINGLE_VALUE_TYPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__EXTENSIONS = SINGLE_VALUE_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = SINGLE_VALUE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Enum Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__ENUM_CONSTANTS = SINGLE_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__BASE_TYPE = SINGLE_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = SINGLE_VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.SimpleTypeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSimpleType()
	 * @generated
	 */
	int SIMPLE_TYPE = 64;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__DOCUMENTATION = SINGLE_VALUE_TYPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__EXTENSIONS = SINGLE_VALUE_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__NAME = SINGLE_VALUE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Simple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_FEATURE_COUNT = SINGLE_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.EnumConstantImpl <em>Enum Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.EnumConstantImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getEnumConstant()
	 * @generated
	 */
	int ENUM_CONSTANT = 65;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CONSTANT__DOCUMENTATION = DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CONSTANT__NAME = DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Integer Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CONSTANT__INTEGER_VALUE = DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CONSTANT__LITERAL_VALUE = DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CONSTANT__ENUMERATION = DOCUMENTABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Enum Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CONSTANT_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.UserDefinedTypeImpl <em>User Defined Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.UserDefinedTypeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getUserDefinedType()
	 * @generated
	 */
	int USER_DEFINED_TYPE = 66;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__DOCUMENTATION = SIMPLE_TYPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__EXTENSIONS = SIMPLE_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__NAME = SIMPLE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__CONSTRAINTS = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__BASE_TYPE = SIMPLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Defined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PrimitiveTypeImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 67;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DOCUMENTATION = SIMPLE_TYPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EXTENSIONS = SIMPLE_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = SIMPLE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.LengthConstraintImpl <em>Length Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.LengthConstraintImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getLengthConstraint()
	 * @generated
	 */
	int LENGTH_CONSTRAINT = 72;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH_CONSTRAINT__EXTENSIONS = CONSTRAINT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH_CONSTRAINT__MIN_LENGTH = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH_CONSTRAINT__MAX_LENGTH = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH_CONSTRAINT__LENGTH = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Length Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.RegExConstraintImpl <em>Reg Ex Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.RegExConstraintImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRegExConstraint()
	 * @generated
	 */
	int REG_EX_CONSTRAINT = 73;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__EXTENSIONS = CONSTRAINT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__PATTERN = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reg Ex Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.ValueRangeConstraintImpl <em>Value Range Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.ValueRangeConstraintImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getValueRangeConstraint()
	 * @generated
	 */
	int VALUE_RANGE_CONSTRAINT = 74;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_CONSTRAINT__EXTENSIONS = CONSTRAINT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_CONSTRAINT__MIN_VALUE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Value Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_CONSTRAINT__MAX_VALUE = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Value Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE = CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Value Range Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.Inheritable <em>Inheritable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.Inheritable
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getInheritable()
	 * @generated
	 */
	int INHERITABLE = 76;

	/**
	 * The number of structural features of the '<em>Inheritable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.MediaTypesLibraryImpl <em>Media Types Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.MediaTypesLibraryImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMediaTypesLibrary()
	 * @generated
	 */
	int MEDIA_TYPES_LIBRARY = 77;

	/**
	 * The feature id for the '<em><b>Media Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPES_LIBRARY__MEDIA_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Media Types Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPES_LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.LinkRelationsLibraryImpl <em>Link Relations Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.LinkRelationsLibraryImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getLinkRelationsLibrary()
	 * @generated
	 */
	int LINK_RELATIONS_LIBRARY = 78;

	/**
	 * The feature id for the '<em><b>Defined Link Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATIONS_LIBRARY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Link Relations Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_RELATIONS_LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypesLibraryImpl <em>Primitive Types Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.PrimitiveTypesLibraryImpl
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveTypesLibrary()
	 * @generated
	 */
	int PRIMITIVE_TYPES_LIBRARY = 79;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPES_LIBRARY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Primitive Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPES_LIBRARY__PRIMITIVE_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Primitive Types Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPES_LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.HTTPMethods <em>HTTP Methods</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.HTTPMethods
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHTTPMethods()
	 * @generated
	 */
	int HTTP_METHODS = 80;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.ReferenceRealizationEnum <em>Reference Realization Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealizationEnum
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceRealizationEnum()
	 * @generated
	 */
	int REFERENCE_REALIZATION_ENUM = 81;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.HttpMessageParameterLocation <em>Http Message Parameter Location</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.HttpMessageParameterLocation
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHttpMessageParameterLocation()
	 * @generated
	 */
	int HTTP_MESSAGE_PARAMETER_LOCATION = 82;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.CollectionRealizationEnum <em>Collection Realization Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.CollectionRealizationEnum
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionRealizationEnum()
	 * @generated
	 */
	int COLLECTION_REALIZATION_ENUM = 83;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.AuthenticationTypes <em>Authentication Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.AuthenticationTypes
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getAuthenticationTypes()
	 * @generated
	 */
	int AUTHENTICATION_TYPES = 84;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.AuthenticationFlows <em>Authentication Flows</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.AuthenticationFlows
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getAuthenticationFlows()
	 * @generated
	 */
	int AUTHENTICATION_FLOWS = 85;

	/**
	 * The meta object id for the '{@link com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum <em>Collection Realization Level Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionRealizationLevelEnum()
	 * @generated
	 */
	int COLLECTION_REALIZATION_LEVEL_ENUM = 86;

	/**
	 * The meta object id for the '<em>Realization Model</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.realization.model.RealizationModel
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRealizationModel()
	 * @generated
	 */
	int REALIZATION_MODEL = 87;

	/**
	 * The meta object id for the '<em>Collection Realization Level Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionRealizationLevelObject()
	 * @generated
	 */
	int COLLECTION_REALIZATION_LEVEL_OBJECT = 88;

	/**
	 * The meta object id for the '<em>Effective Realization</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.realization.processor.EffectiveRealization
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getEffectiveRealization()
	 * @generated
	 */
	int EFFECTIVE_REALIZATION = 89;


	/**
	 * The meta object id for the '<em>Cardinality</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCardinality()
	 * @generated
	 */
	int CARDINALITY = 90;

	/**
	 * The meta object id for the '<em>Cardinality Override</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCardinalityOverride()
	 * @generated
	 */
	int CARDINALITY_OVERRIDE = 91;


	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ResourceDefinition <em>Resource Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Definition</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition
	 * @generated
	 */
	EClass getResourceDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ResourceDefinition#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition#getMethods()
	 * @see #getResourceDefinition()
	 * @generated
	 */
	EReference getResourceDefinition_Methods();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.ResourceDefinition#getMediaTypes <em>Media Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Media Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition#getMediaTypes()
	 * @see #getResourceDefinition()
	 * @generated
	 */
	EReference getResourceDefinition_MediaTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ResourceDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition#getName()
	 * @see #getResourceDefinition()
	 * @generated
	 */
	EAttribute getResourceDefinition_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.ResourceDefinition#getAllMediaTypes <em>All Media Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Media Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition#getAllMediaTypes()
	 * @see #getResourceDefinition()
	 * @generated
	 */
	EReference getResourceDefinition_AllMediaTypes();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.ResourceDefinition#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>URI</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition#getURI()
	 * @see #getResourceDefinition()
	 * @generated
	 */
	EReference getResourceDefinition_URI();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.TypedMessage <em>Typed Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Message</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedMessage
	 * @generated
	 */
	EClass getTypedMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.TypedMessage#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedMessage#getParameters()
	 * @see #getTypedMessage()
	 * @generated
	 */
	EReference getTypedMessage_Parameters();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.TypedMessage#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedMessage#getResourceType()
	 * @see #getTypedMessage()
	 * @generated
	 */
	EReference getTypedMessage_ResourceType();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.TypedMessage#isUseParentTypeReference <em>Use Parent Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Parent Type Reference</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedMessage#isUseParentTypeReference()
	 * @see #getTypedMessage()
	 * @generated
	 */
	EAttribute getTypedMessage_UseParentTypeReference();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.TypedMessage#getMediaTypes <em>Media Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Media Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedMessage#getMediaTypes()
	 * @see #getTypedMessage()
	 * @generated
	 */
	EReference getTypedMessage_MediaTypes();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see com.modelsolv.reprezen.restapi.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.Method#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Request</em>'.
	 * @see com.modelsolv.reprezen.restapi.Method#getRequest()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Request();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.Method#getResponses <em>Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Responses</em>'.
	 * @see com.modelsolv.reprezen.restapi.Method#getResponses()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Responses();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Method#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.modelsolv.reprezen.restapi.Method#getId()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Method#getHttpMethod <em>Http Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http Method</em>'.
	 * @see com.modelsolv.reprezen.restapi.Method#getHttpMethod()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_HttpMethod();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.Method#getContainingResourceDefinition <em>Containing Resource Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Resource Definition</em>'.
	 * @see com.modelsolv.reprezen.restapi.Method#getContainingResourceDefinition()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_ContainingResourceDefinition();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Parameter#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.modelsolv.reprezen.restapi.Parameter#isRequired()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Required();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Parameter#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see com.modelsolv.reprezen.restapi.Parameter#getDefault()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Default();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Parameter#getFixed <em>Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed</em>'.
	 * @see com.modelsolv.reprezen.restapi.Parameter#getFixed()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Fixed();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.Parameter#getSourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Reference</em>'.
	 * @see com.modelsolv.reprezen.restapi.Parameter#getSourceReference()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_SourceReference();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.RESTElement <em>REST Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>REST Element</em>'.
	 * @see com.modelsolv.reprezen.restapi.RESTElement
	 * @generated
	 */
	EClass getRESTElement();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation</em>'.
	 * @see com.modelsolv.reprezen.restapi.Documentation
	 * @generated
	 */
	EClass getDocumentation();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Documentation#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.modelsolv.reprezen.restapi.Documentation#getText()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Text();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Documentable <em>Documentable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentable</em>'.
	 * @see com.modelsolv.reprezen.restapi.Documentable
	 * @generated
	 */
	EClass getDocumentable();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.Documentable#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see com.modelsolv.reprezen.restapi.Documentable#getDocumentation()
	 * @see #getDocumentable()
	 * @generated
	 */
	EReference getDocumentable_Documentation();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.MediaType <em>Media Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.MediaType
	 * @generated
	 */
	EClass getMediaType();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.MediaType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.MediaType#getName()
	 * @see #getMediaType()
	 * @generated
	 */
	EAttribute getMediaType_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.MediaType#getSpecURL <em>Spec URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spec URL</em>'.
	 * @see com.modelsolv.reprezen.restapi.MediaType#getSpecURL()
	 * @see #getMediaType()
	 * @generated
	 */
	EAttribute getMediaType_SpecURL();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.MediaType#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see com.modelsolv.reprezen.restapi.MediaType#getDerivedFrom()
	 * @see #getMediaType()
	 * @generated
	 */
	EReference getMediaType_DerivedFrom();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.TypedRequest <em>Typed Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Request</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedRequest
	 * @generated
	 */
	EClass getTypedRequest();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.TypedRequest#getContainingMethod <em>Containing Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Method</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedRequest#getContainingMethod()
	 * @see #getTypedRequest()
	 * @generated
	 */
	EReference getTypedRequest_ContainingMethod();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.TypedResponse <em>Typed Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Response</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedResponse
	 * @generated
	 */
	EClass getTypedResponse();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.TypedResponse#getStatusCode <em>Status Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Code</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedResponse#getStatusCode()
	 * @see #getTypedResponse()
	 * @generated
	 */
	EAttribute getTypedResponse_StatusCode();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.TypedResponse#getContainingMethod <em>Containing Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Method</em>'.
	 * @see com.modelsolv.reprezen.restapi.TypedResponse#getContainingMethod()
	 * @see #getTypedResponse()
	 * @generated
	 */
	EReference getTypedResponse_ContainingMethod();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.URIParameter <em>URI Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.URIParameter
	 * @generated
	 */
	EClass getURIParameter();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.URIParameter#getUriSegment <em>Uri Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uri Segment</em>'.
	 * @see com.modelsolv.reprezen.restapi.URIParameter#getUriSegment()
	 * @see #getURIParameter()
	 * @generated
	 */
	EReference getURIParameter_UriSegment();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.URIParameter#getContainingURI <em>Containing URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing URI</em>'.
	 * @see com.modelsolv.reprezen.restapi.URIParameter#getContainingURI()
	 * @see #getURIParameter()
	 * @generated
	 */
	EReference getURIParameter_ContainingURI();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.MatrixParameter <em>Matrix Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matrix Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.MatrixParameter
	 * @generated
	 */
	EClass getMatrixParameter();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.TemplateParameter
	 * @generated
	 */
	EClass getTemplateParameter();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.CollectionResource <em>Collection Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Resource</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionResource
	 * @generated
	 */
	EClass getCollectionResource();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.CollectionResource#getCollectionParameters <em>Collection Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Parameters</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionResource#getCollectionParameters()
	 * @see #getCollectionResource()
	 * @generated
	 */
	EReference getCollectionResource_CollectionParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.CollectionResource#getReferenceElements <em>Reference Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Elements</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionResource#getReferenceElements()
	 * @see #getCollectionResource()
	 * @generated
	 */
	EReference getCollectionResource_ReferenceElements();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.CollectionResource#getResourceRealizationKind <em>Resource Realization Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Realization Kind</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionResource#getResourceRealizationKind()
	 * @see #getCollectionResource()
	 * @generated
	 */
	EAttribute getCollectionResource_ResourceRealizationKind();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ObjectResource <em>Object Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Resource</em>'.
	 * @see com.modelsolv.reprezen.restapi.ObjectResource
	 * @generated
	 */
	EClass getObjectResource();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.CollectionParameter <em>Collection Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionParameter
	 * @generated
	 */
	EClass getCollectionParameter();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.CollectionParameter#getContainingResourceDefinition <em>Containing Resource Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Resource Definition</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionParameter#getContainingResourceDefinition()
	 * @see #getCollectionParameter()
	 * @generated
	 */
	EReference getCollectionParameter_ContainingResourceDefinition();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PropertyReference <em>Property Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Reference</em>'.
	 * @see com.modelsolv.reprezen.restapi.PropertyReference
	 * @generated
	 */
	EClass getPropertyReference();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.PropertyReference#getConceptualFeature <em>Conceptual Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conceptual Feature</em>'.
	 * @see com.modelsolv.reprezen.restapi.PropertyReference#getConceptualFeature()
	 * @see #getPropertyReference()
	 * @generated
	 */
	EReference getPropertyReference_ConceptualFeature();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Reference</em>'.
	 * @see com.modelsolv.reprezen.restapi.SourceReference
	 * @generated
	 */
	EClass getSourceReference();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.SourceReference#getContainingParameter <em>Containing Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.SourceReference#getContainingParameter()
	 * @see #getSourceReference()
	 * @generated
	 */
	EReference getSourceReference_ContainingParameter();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.MessageParameter <em>Message Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.MessageParameter
	 * @generated
	 */
	EClass getMessageParameter();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.MessageParameter#getContainingMessage <em>Containing Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Message</em>'.
	 * @see com.modelsolv.reprezen.restapi.MessageParameter#getContainingMessage()
	 * @see #getMessageParameter()
	 * @generated
	 */
	EReference getMessageParameter_ContainingMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.MessageParameter#getHttpLocation <em>Http Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http Location</em>'.
	 * @see com.modelsolv.reprezen.restapi.MessageParameter#getHttpLocation()
	 * @see #getMessageParameter()
	 * @generated
	 */
	EAttribute getMessageParameter_HttpLocation();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ZenModel <em>Zen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Zen Model</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel
	 * @generated
	 */
	EClass getZenModel();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ZenModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getName()
	 * @see #getZenModel()
	 * @generated
	 */
	EAttribute getZenModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ZenModel#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getNamespace()
	 * @see #getZenModel()
	 * @generated
	 */
	EAttribute getZenModel_Namespace();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ZenModel#getResourceAPIs <em>Resource AP Is</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource AP Is</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getResourceAPIs()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_ResourceAPIs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ZenModel#getDataModels <em>Data Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Models</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getDataModels()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_DataModels();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.ZenModel#getMediaTypesLibrary <em>Media Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Media Types Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getMediaTypesLibrary()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_MediaTypesLibrary();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.ZenModel#getLinkRelationsLibrary <em>Link Relations Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Relations Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getLinkRelationsLibrary()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_LinkRelationsLibrary();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.ZenModel#getPrimitiveTypesLibrary <em>Primitive Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primitive Types Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getPrimitiveTypesLibrary()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_PrimitiveTypesLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ZenModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getImports()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_Imports();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.ZenModel#getSecuritySchemesLibrary <em>Security Schemes Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Security Schemes Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.ZenModel#getSecuritySchemesLibrary()
	 * @see #getZenModel()
	 * @generated
	 */
	EReference getZenModel_SecuritySchemesLibrary();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ResourceAPI <em>Resource API</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource API</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI
	 * @generated
	 */
	EClass getResourceAPI();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getName()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EAttribute getResourceAPI_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getVersion()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EAttribute getResourceAPI_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getBaseURI <em>Base URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base URI</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getBaseURI()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EAttribute getResourceAPI_BaseURI();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getOwnedResourceDefinitions <em>Owned Resource Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Resource Definitions</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getOwnedResourceDefinitions()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_OwnedResourceDefinitions();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getServiceDataModels <em>Service Data Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Service Data Models</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getServiceDataModels()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_ServiceDataModels();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getFormats <em>Formats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Formats</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getFormats()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_Formats();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getDefinedMediaTypes <em>Defined Media Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defined Media Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getDefinedMediaTypes()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_DefinedMediaTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getDefinedLinkRelations <em>Defined Link Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defined Link Relations</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getDefinedLinkRelations()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_DefinedLinkRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getDefaultReferenceRealizations <em>Default Reference Realizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Reference Realizations</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getDefaultReferenceRealizations()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_DefaultReferenceRealizations();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ResourceAPI#getAutoRealizations <em>Auto Realizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Auto Realizations</em>'.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI#getAutoRealizations()
	 * @see #getResourceAPI()
	 * @generated
	 */
	EReference getResourceAPI_AutoRealizations();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ServiceDataResource <em>Service Data Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Data Resource</em>'.
	 * @see com.modelsolv.reprezen.restapi.ServiceDataResource
	 * @generated
	 */
	EClass getServiceDataResource();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ServiceDataResource#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see com.modelsolv.reprezen.restapi.ServiceDataResource#isDefault()
	 * @see #getServiceDataResource()
	 * @generated
	 */
	EAttribute getServiceDataResource_Default();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ServiceDataResource#getDefinedLinkDescriptors <em>Defined Link Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defined Link Descriptors</em>'.
	 * @see com.modelsolv.reprezen.restapi.ServiceDataResource#getDefinedLinkDescriptors()
	 * @see #getServiceDataResource()
	 * @generated
	 */
	EReference getServiceDataResource_DefinedLinkDescriptors();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ReferenceTreatment <em>Reference Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Treatment</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceTreatment
	 * @generated
	 */
	EClass getReferenceTreatment();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceTreatment#getReferenceElement <em>Reference Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Element</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceTreatment#getReferenceElement()
	 * @see #getReferenceTreatment()
	 * @generated
	 */
	EReference getReferenceTreatment_ReferenceElement();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceTreatment#getReferenceRealization <em>Reference Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceTreatment#getReferenceRealization()
	 * @see #getReferenceTreatment()
	 * @generated
	 */
	EReference getReferenceTreatment_ReferenceRealization();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.ReferenceTreatment#getOwnedReferenceRealization <em>Owned Reference Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Reference Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceTreatment#getOwnedReferenceRealization()
	 * @see #getReferenceTreatment()
	 * @generated
	 */
	EReference getReferenceTreatment_OwnedReferenceRealization();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ReferenceRealization <em>Reference Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealization
	 * @generated
	 */
	EClass getReferenceRealization();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceRealization#getTargetResource <em>Target Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Resource</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealization#getTargetResource()
	 * @see #getReferenceRealization()
	 * @generated
	 */
	EReference getReferenceRealization_TargetResource();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ReferenceRealization#getRealizationType <em>Realization Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Realization Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealization#getRealizationType()
	 * @see #getReferenceRealization()
	 * @generated
	 */
	EAttribute getReferenceRealization_RealizationType();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ReferenceRealization#isMultiValued <em>Multi Valued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Valued</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealization#isMultiValued()
	 * @see #getReferenceRealization()
	 * @generated
	 */
	EAttribute getReferenceRealization_MultiValued();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ReferenceLink <em>Reference Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Link</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceLink
	 * @generated
	 */
	EClass getReferenceLink();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ReferenceLink#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceLink#getName()
	 * @see #getReferenceLink()
	 * @generated
	 */
	EAttribute getReferenceLink_Name();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceLink#getLinkRelation <em>Link Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link Relation</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceLink#getLinkRelation()
	 * @see #getReferenceLink()
	 * @generated
	 */
	EReference getReferenceLink_LinkRelation();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ReferenceLink#getCollectionRealizationLevel <em>Collection Realization Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Realization Level</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceLink#getCollectionRealizationLevel()
	 * @see #getReferenceLink()
	 * @generated
	 */
	EAttribute getReferenceLink_CollectionRealizationLevel();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ReferenceEmbed <em>Reference Embed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Embed</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceEmbed
	 * @generated
	 */
	EClass getReferenceEmbed();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.NamedLinkDescriptor <em>Named Link Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Link Descriptor</em>'.
	 * @see com.modelsolv.reprezen.restapi.NamedLinkDescriptor
	 * @generated
	 */
	EClass getNamedLinkDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.NamedLinkDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.NamedLinkDescriptor#getName()
	 * @see #getNamedLinkDescriptor()
	 * @generated
	 */
	EAttribute getNamedLinkDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.NamedLinkDescriptor#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see com.modelsolv.reprezen.restapi.NamedLinkDescriptor#isDefault()
	 * @see #getNamedLinkDescriptor()
	 * @generated
	 */
	EAttribute getNamedLinkDescriptor_Default();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PathSegment <em>Path Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Segment</em>'.
	 * @see com.modelsolv.reprezen.restapi.PathSegment
	 * @generated
	 */
	EClass getPathSegment();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.PathSegment#getReferenceElement <em>Reference Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Element</em>'.
	 * @see com.modelsolv.reprezen.restapi.PathSegment#getReferenceElement()
	 * @see #getPathSegment()
	 * @generated
	 */
	EReference getPathSegment_ReferenceElement();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference <em>Primitive Type Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Source Reference</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference
	 * @generated
	 */
	EClass getPrimitiveTypeSourceReference();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference#getSimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Simple Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference#getSimpleType()
	 * @see #getPrimitiveTypeSourceReference()
	 * @generated
	 */
	EReference getPrimitiveTypeSourceReference_SimpleType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI</em>'.
	 * @see com.modelsolv.reprezen.restapi.URI
	 * @generated
	 */
	EClass getURI();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.URI#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segments</em>'.
	 * @see com.modelsolv.reprezen.restapi.URI#getSegments()
	 * @see #getURI()
	 * @generated
	 */
	EReference getURI_Segments();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.URI#getUriParameters <em>Uri Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uri Parameters</em>'.
	 * @see com.modelsolv.reprezen.restapi.URI#getUriParameters()
	 * @see #getURI()
	 * @generated
	 */
	EReference getURI_UriParameters();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.URISegment <em>URI Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI Segment</em>'.
	 * @see com.modelsolv.reprezen.restapi.URISegment
	 * @generated
	 */
	EClass getURISegment();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.URISegment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.URISegment#getName()
	 * @see #getURISegment()
	 * @generated
	 */
	EAttribute getURISegment_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.URISegmentWithParameter <em>URI Segment With Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI Segment With Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.URISegmentWithParameter
	 * @generated
	 */
	EClass getURISegmentWithParameter();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PropertyRealization <em>Property Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.PropertyRealization
	 * @generated
	 */
	EClass getPropertyRealization();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.PropertyRealization#getBaseProperty <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see com.modelsolv.reprezen.restapi.PropertyRealization#getBaseProperty()
	 * @see #getPropertyRealization()
	 * @generated
	 */
	EReference getPropertyRealization_BaseProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.PropertyRealization#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see com.modelsolv.reprezen.restapi.PropertyRealization#getCardinality()
	 * @see #getPropertyRealization()
	 * @generated
	 */
	EAttribute getPropertyRealization_Cardinality();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.LinkRelation <em>Link Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Relation</em>'.
	 * @see com.modelsolv.reprezen.restapi.LinkRelation
	 * @generated
	 */
	EClass getLinkRelation();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.LinkRelation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.LinkRelation#getName()
	 * @see #getLinkRelation()
	 * @generated
	 */
	EAttribute getLinkRelation_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.LinkRelation#getSpecURL <em>Spec URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spec URL</em>'.
	 * @see com.modelsolv.reprezen.restapi.LinkRelation#getSpecURL()
	 * @see #getLinkRelation()
	 * @generated
	 */
	EAttribute getLinkRelation_SpecURL();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.WithExamples <em>With Examples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Examples</em>'.
	 * @see com.modelsolv.reprezen.restapi.WithExamples
	 * @generated
	 */
	EClass getWithExamples();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.WithExamples#getExamples <em>Examples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Examples</em>'.
	 * @see com.modelsolv.reprezen.restapi.WithExamples#getExamples()
	 * @see #getWithExamples()
	 * @generated
	 */
	EReference getWithExamples_Examples();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Example <em>Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Example</em>'.
	 * @see com.modelsolv.reprezen.restapi.Example
	 * @generated
	 */
	EClass getExample();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.InlineExample <em>Inline Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inline Example</em>'.
	 * @see com.modelsolv.reprezen.restapi.InlineExample
	 * @generated
	 */
	EClass getInlineExample();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.InlineExample#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see com.modelsolv.reprezen.restapi.InlineExample#getBody()
	 * @see #getInlineExample()
	 * @generated
	 */
	EAttribute getInlineExample_Body();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ExternalExample <em>External Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Example</em>'.
	 * @see com.modelsolv.reprezen.restapi.ExternalExample
	 * @generated
	 */
	EClass getExternalExample();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ExternalExample#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.modelsolv.reprezen.restapi.ExternalExample#getPath()
	 * @see #getExternalExample()
	 * @generated
	 */
	EAttribute getExternalExample_Path();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.HasStringValue <em>Has String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has String Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.HasStringValue
	 * @generated
	 */
	EClass getHasStringValue();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ImportDeclaration <em>Import Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Declaration</em>'.
	 * @see com.modelsolv.reprezen.restapi.ImportDeclaration
	 * @generated
	 */
	EClass getImportDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ImportDeclaration#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see com.modelsolv.reprezen.restapi.ImportDeclaration#getImportURI()
	 * @see #getImportDeclaration()
	 * @generated
	 */
	EAttribute getImportDeclaration_ImportURI();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see com.modelsolv.reprezen.restapi.ImportDeclaration#getImportedNamespace()
	 * @see #getImportDeclaration()
	 * @generated
	 */
	EAttribute getImportDeclaration_ImportedNamespace();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ImportDeclaration#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see com.modelsolv.reprezen.restapi.ImportDeclaration#getAlias()
	 * @see #getImportDeclaration()
	 * @generated
	 */
	EAttribute getImportDeclaration_Alias();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ImportDeclaration#getImportedModel <em>Imported Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Model</em>'.
	 * @see com.modelsolv.reprezen.restapi.ImportDeclaration#getImportedModel()
	 * @see #getImportDeclaration()
	 * @generated
	 */
	EReference getImportDeclaration_ImportedModel();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ObjectRealization <em>Object Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.ObjectRealization
	 * @generated
	 */
	EClass getObjectRealization();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ObjectRealization#getExclusivePropertyList <em>Exclusive Property List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exclusive Property List</em>'.
	 * @see com.modelsolv.reprezen.restapi.ObjectRealization#getExclusivePropertyList()
	 * @see #getObjectRealization()
	 * @generated
	 */
	EReference getObjectRealization_ExclusivePropertyList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ObjectRealization#getOverriddenPropertyList <em>Overridden Property List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Overridden Property List</em>'.
	 * @see com.modelsolv.reprezen.restapi.ObjectRealization#getOverriddenPropertyList()
	 * @see #getObjectRealization()
	 * @generated
	 */
	EReference getObjectRealization_OverriddenPropertyList();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.ObjectRealization#getExcludedProperties <em>Excluded Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Excluded Properties</em>'.
	 * @see com.modelsolv.reprezen.restapi.ObjectRealization#getExcludedProperties()
	 * @see #getObjectRealization()
	 * @generated
	 */
	EReference getObjectRealization_ExcludedProperties();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.ObjectRealization#getRealizationContainer <em>Realization Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Realization Container</em>'.
	 * @see com.modelsolv.reprezen.restapi.ObjectRealization#getRealizationContainer()
	 * @see #getObjectRealization()
	 * @generated
	 */
	EReference getObjectRealization_RealizationContainer();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.CollectionReferenceElement <em>Collection Reference Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Reference Element</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionReferenceElement
	 * @generated
	 */
	EClass getCollectionReferenceElement();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.HasSecurityValue <em>Has Security Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Security Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.HasSecurityValue
	 * @generated
	 */
	EClass getHasSecurityValue();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.HasSecurityValue#getSecuredBy <em>Secured By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Secured By</em>'.
	 * @see com.modelsolv.reprezen.restapi.HasSecurityValue#getSecuredBy()
	 * @see #getHasSecurityValue()
	 * @generated
	 */
	EReference getHasSecurityValue_SecuredBy();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SecurityScheme <em>Security Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Scheme</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme
	 * @generated
	 */
	EClass getSecurityScheme();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getName()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getType()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scopes</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getScopes()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EReference getSecurityScheme_Scopes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getSettings()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EReference getSecurityScheme_Settings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getParameters()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EReference getSecurityScheme_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getErrorResponses <em>Error Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Responses</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getErrorResponses()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EReference getSecurityScheme_ErrorResponses();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flow</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme#getFlow()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Flow();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.AuthenticationMethod <em>Authentication Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Authentication Method</em>'.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationMethod
	 * @generated
	 */
	EClass getAuthenticationMethod();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.AuthenticationMethod#getScheme <em>Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scheme</em>'.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationMethod#getScheme()
	 * @see #getAuthenticationMethod()
	 * @generated
	 */
	EReference getAuthenticationMethod_Scheme();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.AuthenticationMethod#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scopes</em>'.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationMethod#getScopes()
	 * @see #getAuthenticationMethod()
	 * @generated
	 */
	EReference getAuthenticationMethod_Scopes();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SecurityScope <em>Security Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Scope</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScope
	 * @generated
	 */
	EClass getSecurityScope();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecurityScope#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecurityScope#getName()
	 * @see #getSecurityScope()
	 * @generated
	 */
	EAttribute getSecurityScope_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SecuritySchemeParameter <em>Security Scheme Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Scheme Parameter</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeParameter
	 * @generated
	 */
	EClass getSecuritySchemeParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecuritySchemeParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeParameter#getName()
	 * @see #getSecuritySchemeParameter()
	 * @generated
	 */
	EAttribute getSecuritySchemeParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecuritySchemeParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeParameter#getValue()
	 * @see #getSecuritySchemeParameter()
	 * @generated
	 */
	EAttribute getSecuritySchemeParameter_Value();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SecuritySchemeLibrary <em>Security Scheme Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Scheme Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeLibrary
	 * @generated
	 */
	EClass getSecuritySchemeLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.SecuritySchemeLibrary#getSecuritySchemes <em>Security Schemes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Security Schemes</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeLibrary#getSecuritySchemes()
	 * @see #getSecuritySchemeLibrary()
	 * @generated
	 */
	EReference getSecuritySchemeLibrary_SecuritySchemes();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.SecuritySchemeLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeLibrary#getName()
	 * @see #getSecuritySchemeLibrary()
	 * @generated
	 */
	EAttribute getSecuritySchemeLibrary_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.RealizationContainer <em>Realization Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realization Container</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer
	 * @generated
	 */
	EClass getRealizationContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.RealizationContainer#isWithDefaultRealization <em>With Default Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Default Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#isWithDefaultRealization()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EAttribute getRealizationContainer_WithDefaultRealization();

	/**
	 * Returns the meta object for the containment reference '{@link com.modelsolv.reprezen.restapi.RealizationContainer#getInlineObjectRealization <em>Inline Object Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inline Object Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#getInlineObjectRealization()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EReference getRealizationContainer_InlineObjectRealization();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.RealizationContainer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Properties</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#getProperties()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EReference getRealizationContainer_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.RealizationContainer#getReferenceTreatments <em>Reference Treatments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Treatments</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#getReferenceTreatments()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EReference getRealizationContainer_ReferenceTreatments();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.RealizationContainer#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#getDataType()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EReference getRealizationContainer_DataType();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.RealizationContainer#getRealizationName <em>Realization Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Realization Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#getRealizationName()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EAttribute getRealizationContainer_RealizationName();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.RealizationContainer#getEffectiveRealization <em>Effective Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Realization</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer#getEffectiveRealization()
	 * @see #getRealizationContainer()
	 * @generated
	 */
	EAttribute getRealizationContainer_EffectiveRealization();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Extensible <em>Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extensible</em>'.
	 * @see com.modelsolv.reprezen.restapi.Extensible
	 * @generated
	 */
	EClass getExtensible();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.Extensible#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see com.modelsolv.reprezen.restapi.Extensible#getExtensions()
	 * @see #getExtensible()
	 * @generated
	 */
	EReference getExtensible_Extensions();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see com.modelsolv.reprezen.restapi.Extension
	 * @generated
	 */
	EClass getExtension();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Extension#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.Extension#getName()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Extension#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.Extension#getValue()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Value();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.RealizationModelLocation <em>Realization Model Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realization Model Location</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationModelLocation
	 * @generated
	 */
	EClass getRealizationModelLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.RealizationModelLocation#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see com.modelsolv.reprezen.restapi.RealizationModelLocation#getUri()
	 * @see #getRealizationModelLocation()
	 * @generated
	 */
	EAttribute getRealizationModelLocation_Uri();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.HasTitle <em>Has Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Title</em>'.
	 * @see com.modelsolv.reprezen.restapi.HasTitle
	 * @generated
	 */
	EClass getHasTitle();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.HasTitle#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.modelsolv.reprezen.restapi.HasTitle#getTitle()
	 * @see #getHasTitle()
	 * @generated
	 */
	EAttribute getHasTitle_Title();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see com.modelsolv.reprezen.restapi.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Operation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.Operation#getName()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see com.modelsolv.reprezen.restapi.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.Feature#getContainingDataType <em>Containing Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Data Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.Feature#getContainingDataType()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ContainingDataType();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Feature#isRestriction <em>Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction</em>'.
	 * @see com.modelsolv.reprezen.restapi.Feature#isRestriction()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Restriction();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Feature#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.modelsolv.reprezen.restapi.Feature#isReadOnly()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Feature#isKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see com.modelsolv.reprezen.restapi.Feature#isKey()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Key();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ReferenceProperty <em>Reference Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Property</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceProperty
	 * @generated
	 */
	EClass getReferenceProperty();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceProperty#getType()
	 * @see #getReferenceProperty()
	 * @generated
	 */
	EReference getReferenceProperty_Type();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#getInverse <em>Inverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inverse</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceProperty#getInverse()
	 * @see #getReferenceProperty()
	 * @generated
	 */
	EReference getReferenceProperty_Inverse();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#isContainment <em>Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Containment</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceProperty#isContainment()
	 * @see #getReferenceProperty()
	 * @generated
	 */
	EAttribute getReferenceProperty_Containment();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#isContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceProperty#isContainer()
	 * @see #getReferenceProperty()
	 * @generated
	 */
	EAttribute getReferenceProperty_Container();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PrimitiveProperty <em>Primitive Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Property</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveProperty
	 * @generated
	 */
	EClass getPrimitiveProperty();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.PrimitiveProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveProperty#getType()
	 * @see #getPrimitiveProperty()
	 * @generated
	 */
	EReference getPrimitiveProperty_Type();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see com.modelsolv.reprezen.restapi.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.Structure#getOwnedFeatures <em>Owned Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Features</em>'.
	 * @see com.modelsolv.reprezen.restapi.Structure#getOwnedFeatures()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_OwnedFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.Structure#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elements</em>'.
	 * @see com.modelsolv.reprezen.restapi.Structure#getOwnedElements()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_OwnedElements();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.Structure#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see com.modelsolv.reprezen.restapi.Structure#getOwnedOperations()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_OwnedOperations();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.Structure#getSupertypes <em>Supertypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supertypes</em>'.
	 * @see com.modelsolv.reprezen.restapi.Structure#getSupertypes()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Supertypes();

	/**
	 * Returns the meta object for the reference list '{@link com.modelsolv.reprezen.restapi.Structure#getAllSupertypes <em>All Supertypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Supertypes</em>'.
	 * @see com.modelsolv.reprezen.restapi.Structure#getAllSupertypes()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_AllSupertypes();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.DataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Model</em>'.
	 * @see com.modelsolv.reprezen.restapi.DataModel
	 * @generated
	 */
	EClass getDataModel();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.DataModel#getOwnedDataTypes <em>Owned Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Data Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.DataModel#getOwnedDataTypes()
	 * @see #getDataModel()
	 * @generated
	 */
	EReference getDataModel_OwnedDataTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.DataModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.DataModel#getName()
	 * @see #getDataModel()
	 * @generated
	 */
	EAttribute getDataModel_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.WithDataExamples <em>With Data Examples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Data Examples</em>'.
	 * @see com.modelsolv.reprezen.restapi.WithDataExamples
	 * @generated
	 */
	EClass getWithDataExamples();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.WithDataExamples#getDataExamples <em>Data Examples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Examples</em>'.
	 * @see com.modelsolv.reprezen.restapi.WithDataExamples#getDataExamples()
	 * @see #getWithDataExamples()
	 * @generated
	 */
	EReference getWithDataExamples_DataExamples();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.DataExample <em>Data Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Example</em>'.
	 * @see com.modelsolv.reprezen.restapi.DataExample
	 * @generated
	 */
	EClass getDataExample();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.InlineDataExample <em>Inline Data Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inline Data Example</em>'.
	 * @see com.modelsolv.reprezen.restapi.InlineDataExample
	 * @generated
	 */
	EClass getInlineDataExample();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.InlineDataExample#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see com.modelsolv.reprezen.restapi.InlineDataExample#getBody()
	 * @see #getInlineDataExample()
	 * @generated
	 */
	EAttribute getInlineDataExample_Body();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see com.modelsolv.reprezen.restapi.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see com.modelsolv.reprezen.restapi.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.Enumeration#getEnumConstants <em>Enum Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enum Constants</em>'.
	 * @see com.modelsolv.reprezen.restapi.Enumeration#getEnumConstants()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_EnumConstants();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.Enumeration#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.Enumeration#getBaseType()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_BaseType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.SimpleType
	 * @generated
	 */
	EClass getSimpleType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.EnumConstant <em>Enum Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Constant</em>'.
	 * @see com.modelsolv.reprezen.restapi.EnumConstant
	 * @generated
	 */
	EClass getEnumConstant();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.EnumConstant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.EnumConstant#getName()
	 * @see #getEnumConstant()
	 * @generated
	 */
	EAttribute getEnumConstant_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.EnumConstant#getIntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.EnumConstant#getIntegerValue()
	 * @see #getEnumConstant()
	 * @generated
	 */
	EAttribute getEnumConstant_IntegerValue();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.EnumConstant#getLiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.EnumConstant#getLiteralValue()
	 * @see #getEnumConstant()
	 * @generated
	 */
	EAttribute getEnumConstant_LiteralValue();

	/**
	 * Returns the meta object for the container reference '{@link com.modelsolv.reprezen.restapi.EnumConstant#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see com.modelsolv.reprezen.restapi.EnumConstant#getEnumeration()
	 * @see #getEnumConstant()
	 * @generated
	 */
	EReference getEnumConstant_Enumeration();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.UserDefinedType <em>User Defined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Defined Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.UserDefinedType
	 * @generated
	 */
	EClass getUserDefinedType();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.UserDefinedType#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.UserDefinedType#getBaseType()
	 * @see #getUserDefinedType()
	 * @generated
	 */
	EReference getUserDefinedType_BaseType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.DataType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.DataType#getName()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.SingleValueType <em>Single Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Value Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.SingleValueType
	 * @generated
	 */
	EClass getSingleValueType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see com.modelsolv.reprezen.restapi.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.Element#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see com.modelsolv.reprezen.restapi.Element#getCardinality()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Cardinality();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ReferenceElement <em>Reference Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Element</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceElement
	 * @generated
	 */
	EClass getReferenceElement();

	/**
	 * Returns the meta object for the reference '{@link com.modelsolv.reprezen.restapi.ReferenceElement#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceElement#getDataType()
	 * @see #getReferenceElement()
	 * @generated
	 */
	EReference getReferenceElement_DataType();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.LengthConstraint <em>Length Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Length Constraint</em>'.
	 * @see com.modelsolv.reprezen.restapi.LengthConstraint
	 * @generated
	 */
	EClass getLengthConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.LengthConstraint#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see com.modelsolv.reprezen.restapi.LengthConstraint#getMinLength()
	 * @see #getLengthConstraint()
	 * @generated
	 */
	EAttribute getLengthConstraint_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.LengthConstraint#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see com.modelsolv.reprezen.restapi.LengthConstraint#getMaxLength()
	 * @see #getLengthConstraint()
	 * @generated
	 */
	EAttribute getLengthConstraint_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.LengthConstraint <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.modelsolv.reprezen.restapi.LengthConstraint
	 * @see #getLengthConstraint()
	 * @generated
	 */
	EAttribute getLengthConstraint_Length();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.RegExConstraint <em>Reg Ex Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reg Ex Constraint</em>'.
	 * @see com.modelsolv.reprezen.restapi.RegExConstraint
	 * @generated
	 */
	EClass getRegExConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.RegExConstraint#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see com.modelsolv.reprezen.restapi.RegExConstraint#getPattern()
	 * @see #getRegExConstraint()
	 * @generated
	 */
	EAttribute getRegExConstraint_Pattern();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ValueRangeConstraint <em>Value Range Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Range Constraint</em>'.
	 * @see com.modelsolv.reprezen.restapi.ValueRangeConstraint
	 * @generated
	 */
	EClass getValueRangeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ValueRangeConstraint#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.ValueRangeConstraint#getMinValue()
	 * @see #getValueRangeConstraint()
	 * @generated
	 */
	EAttribute getValueRangeConstraint_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ValueRangeConstraint#isMinValueExclusive <em>Min Value Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value Exclusive</em>'.
	 * @see com.modelsolv.reprezen.restapi.ValueRangeConstraint#isMinValueExclusive()
	 * @see #getValueRangeConstraint()
	 * @generated
	 */
	EAttribute getValueRangeConstraint_MinValueExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ValueRangeConstraint#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see com.modelsolv.reprezen.restapi.ValueRangeConstraint#getMaxValue()
	 * @see #getValueRangeConstraint()
	 * @generated
	 */
	EAttribute getValueRangeConstraint_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.ValueRangeConstraint#isMaxValueExclusive <em>Max Value Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value Exclusive</em>'.
	 * @see com.modelsolv.reprezen.restapi.ValueRangeConstraint#isMaxValueExclusive()
	 * @see #getValueRangeConstraint()
	 * @generated
	 */
	EAttribute getValueRangeConstraint_MaxValueExclusive();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.ConstrainableType <em>Constrainable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrainable Type</em>'.
	 * @see com.modelsolv.reprezen.restapi.ConstrainableType
	 * @generated
	 */
	EClass getConstrainableType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.ConstrainableType#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see com.modelsolv.reprezen.restapi.ConstrainableType#getConstraints()
	 * @see #getConstrainableType()
	 * @generated
	 */
	EReference getConstrainableType_Constraints();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.Inheritable <em>Inheritable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inheritable</em>'.
	 * @see com.modelsolv.reprezen.restapi.Inheritable
	 * @generated
	 */
	EClass getInheritable();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.MediaTypesLibrary <em>Media Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media Types Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.MediaTypesLibrary
	 * @generated
	 */
	EClass getMediaTypesLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.MediaTypesLibrary#getMediaTypes <em>Media Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Media Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.MediaTypesLibrary#getMediaTypes()
	 * @see #getMediaTypesLibrary()
	 * @generated
	 */
	EReference getMediaTypesLibrary_MediaTypes();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.LinkRelationsLibrary <em>Link Relations Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Relations Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.LinkRelationsLibrary
	 * @generated
	 */
	EClass getLinkRelationsLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.LinkRelationsLibrary#getDefinedLinkRelations <em>Defined Link Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defined Link Relations</em>'.
	 * @see com.modelsolv.reprezen.restapi.LinkRelationsLibrary#getDefinedLinkRelations()
	 * @see #getLinkRelationsLibrary()
	 * @generated
	 */
	EReference getLinkRelationsLibrary_DefinedLinkRelations();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.LinkRelationsLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.LinkRelationsLibrary#getName()
	 * @see #getLinkRelationsLibrary()
	 * @generated
	 */
	EAttribute getLinkRelationsLibrary_Name();

	/**
	 * Returns the meta object for class '{@link com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary <em>Primitive Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Types Library</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary
	 * @generated
	 */
	EClass getPrimitiveTypesLibrary();

	/**
	 * Returns the meta object for the attribute '{@link com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary#getName()
	 * @see #getPrimitiveTypesLibrary()
	 * @generated
	 */
	EAttribute getPrimitiveTypesLibrary_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary#getPrimitiveTypes <em>Primitive Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitive Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary#getPrimitiveTypes()
	 * @see #getPrimitiveTypesLibrary()
	 * @generated
	 */
	EReference getPrimitiveTypesLibrary_PrimitiveTypes();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.HTTPMethods <em>HTTP Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HTTP Methods</em>'.
	 * @see com.modelsolv.reprezen.restapi.HTTPMethods
	 * @generated
	 */
	EEnum getHTTPMethods();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.ReferenceRealizationEnum <em>Reference Realization Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reference Realization Enum</em>'.
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealizationEnum
	 * @generated
	 */
	EEnum getReferenceRealizationEnum();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.HttpMessageParameterLocation <em>Http Message Parameter Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Http Message Parameter Location</em>'.
	 * @see com.modelsolv.reprezen.restapi.HttpMessageParameterLocation
	 * @generated
	 */
	EEnum getHttpMessageParameterLocation();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.CollectionRealizationEnum <em>Collection Realization Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Realization Enum</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionRealizationEnum
	 * @generated
	 */
	EEnum getCollectionRealizationEnum();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.AuthenticationTypes <em>Authentication Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Authentication Types</em>'.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationTypes
	 * @generated
	 */
	EEnum getAuthenticationTypes();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.AuthenticationFlows <em>Authentication Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Authentication Flows</em>'.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationFlows
	 * @generated
	 */
	EEnum getAuthenticationFlows();

	/**
	 * Returns the meta object for enum '{@link com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum <em>Collection Realization Level Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Realization Level Enum</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum
	 * @generated
	 */
	EEnum getCollectionRealizationLevelEnum();

	/**
	 * Returns the meta object for data type '{@link com.modelsolv.reprezen.realization.model.RealizationModel <em>Realization Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Realization Model</em>'.
	 * @see com.modelsolv.reprezen.realization.model.RealizationModel
	 * @model instanceClass="com.modelsolv.reprezen.realization.model.RealizationModel" serializeable="false"
	 * @generated
	 */
	EDataType getRealizationModel();

	/**
	 * Returns the meta object for data type '{@link com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum <em>Collection Realization Level Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection Realization Level Object</em>'.
	 * @see com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum
	 * @model instanceClass="com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum"
	 *        extendedMetaData="baseType='CollectionRealizationLevelEnum'"
	 * @generated
	 */
	EDataType getCollectionRealizationLevelObject();

	/**
	 * Returns the meta object for data type '{@link com.modelsolv.reprezen.realization.processor.EffectiveRealization <em>Effective Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Effective Realization</em>'.
	 * @see com.modelsolv.reprezen.realization.processor.EffectiveRealization
	 * @model instanceClass="com.modelsolv.reprezen.realization.processor.EffectiveRealization"
	 * @generated
	 */
	EDataType getEffectiveRealization();

	/**
	 * Returns the meta object for data type '<em>Cardinality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Cardinality</em>'.
	 * @model instanceClass="int[]"
	 * @generated
	 */
	EDataType getCardinality();

	/**
	 * Returns the meta object for data type '<em>Cardinality Override</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Cardinality Override</em>'.
	 * @model instanceClass="int[]"
	 * @generated
	 */
	EDataType getCardinalityOverride();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RestapiFactory getRestapiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ResourceDefinitionImpl <em>Resource Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ResourceDefinitionImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getResourceDefinition()
		 * @generated
		 */
		EClass RESOURCE_DEFINITION = eINSTANCE.getResourceDefinition();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEFINITION__METHODS = eINSTANCE.getResourceDefinition_Methods();

		/**
		 * The meta object literal for the '<em><b>Media Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEFINITION__MEDIA_TYPES = eINSTANCE.getResourceDefinition_MediaTypes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DEFINITION__NAME = eINSTANCE.getResourceDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>All Media Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEFINITION__ALL_MEDIA_TYPES = eINSTANCE.getResourceDefinition_AllMediaTypes();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEFINITION__URI = eINSTANCE.getResourceDefinition_URI();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.TypedMessageImpl <em>Typed Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.TypedMessageImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTypedMessage()
		 * @generated
		 */
		EClass TYPED_MESSAGE = eINSTANCE.getTypedMessage();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MESSAGE__PARAMETERS = eINSTANCE.getTypedMessage_Parameters();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MESSAGE__RESOURCE_TYPE = eINSTANCE.getTypedMessage_ResourceType();

		/**
		 * The meta object literal for the '<em><b>Use Parent Type Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE = eINSTANCE.getTypedMessage_UseParentTypeReference();

		/**
		 * The meta object literal for the '<em><b>Media Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MESSAGE__MEDIA_TYPES = eINSTANCE.getTypedMessage_MediaTypes();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.MethodImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__REQUEST = eINSTANCE.getMethod_Request();

		/**
		 * The meta object literal for the '<em><b>Responses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__RESPONSES = eINSTANCE.getMethod_Responses();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__ID = eINSTANCE.getMethod_Id();

		/**
		 * The meta object literal for the '<em><b>Http Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__HTTP_METHOD = eINSTANCE.getMethod_HttpMethod();

		/**
		 * The meta object literal for the '<em><b>Containing Resource Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__CONTAINING_RESOURCE_DEFINITION = eINSTANCE.getMethod_ContainingResourceDefinition();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__REQUIRED = eINSTANCE.getParameter_Required();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DEFAULT = eINSTANCE.getParameter_Default();

		/**
		 * The meta object literal for the '<em><b>Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__FIXED = eINSTANCE.getParameter_Fixed();

		/**
		 * The meta object literal for the '<em><b>Source Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__SOURCE_REFERENCE = eINSTANCE.getParameter_SourceReference();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.RESTElementImpl <em>REST Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.RESTElementImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRESTElement()
		 * @generated
		 */
		EClass REST_ELEMENT = eINSTANCE.getRESTElement();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.DocumentationImpl <em>Documentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.DocumentationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDocumentation()
		 * @generated
		 */
		EClass DOCUMENTATION = eINSTANCE.getDocumentation();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__TEXT = eINSTANCE.getDocumentation_Text();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.DocumentableImpl <em>Documentable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.DocumentableImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDocumentable()
		 * @generated
		 */
		EClass DOCUMENTABLE = eINSTANCE.getDocumentable();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENTABLE__DOCUMENTATION = eINSTANCE.getDocumentable_Documentation();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.MediaTypeImpl <em>Media Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.MediaTypeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMediaType()
		 * @generated
		 */
		EClass MEDIA_TYPE = eINSTANCE.getMediaType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_TYPE__NAME = eINSTANCE.getMediaType_Name();

		/**
		 * The meta object literal for the '<em><b>Spec URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_TYPE__SPEC_URL = eINSTANCE.getMediaType_SpecURL();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIA_TYPE__DERIVED_FROM = eINSTANCE.getMediaType_DerivedFrom();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.TypedRequestImpl <em>Typed Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.TypedRequestImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTypedRequest()
		 * @generated
		 */
		EClass TYPED_REQUEST = eINSTANCE.getTypedRequest();

		/**
		 * The meta object literal for the '<em><b>Containing Method</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_REQUEST__CONTAINING_METHOD = eINSTANCE.getTypedRequest_ContainingMethod();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.TypedResponseImpl <em>Typed Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.TypedResponseImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTypedResponse()
		 * @generated
		 */
		EClass TYPED_RESPONSE = eINSTANCE.getTypedResponse();

		/**
		 * The meta object literal for the '<em><b>Status Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_RESPONSE__STATUS_CODE = eINSTANCE.getTypedResponse_StatusCode();

		/**
		 * The meta object literal for the '<em><b>Containing Method</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_RESPONSE__CONTAINING_METHOD = eINSTANCE.getTypedResponse_ContainingMethod();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.URIParameterImpl <em>URI Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.URIParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURIParameter()
		 * @generated
		 */
		EClass URI_PARAMETER = eINSTANCE.getURIParameter();

		/**
		 * The meta object literal for the '<em><b>Uri Segment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_PARAMETER__URI_SEGMENT = eINSTANCE.getURIParameter_UriSegment();

		/**
		 * The meta object literal for the '<em><b>Containing URI</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_PARAMETER__CONTAINING_URI = eINSTANCE.getURIParameter_ContainingURI();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.MatrixParameterImpl <em>Matrix Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.MatrixParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMatrixParameter()
		 * @generated
		 */
		EClass MATRIX_PARAMETER = eINSTANCE.getMatrixParameter();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.TemplateParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getTemplateParameter()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER = eINSTANCE.getTemplateParameter();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.CollectionResourceImpl <em>Collection Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.CollectionResourceImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionResource()
		 * @generated
		 */
		EClass COLLECTION_RESOURCE = eINSTANCE.getCollectionResource();

		/**
		 * The meta object literal for the '<em><b>Collection Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RESOURCE__COLLECTION_PARAMETERS = eINSTANCE.getCollectionResource_CollectionParameters();

		/**
		 * The meta object literal for the '<em><b>Reference Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RESOURCE__REFERENCE_ELEMENTS = eINSTANCE.getCollectionResource_ReferenceElements();

		/**
		 * The meta object literal for the '<em><b>Resource Realization Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RESOURCE__RESOURCE_REALIZATION_KIND = eINSTANCE.getCollectionResource_ResourceRealizationKind();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ObjectResourceImpl <em>Object Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ObjectResourceImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getObjectResource()
		 * @generated
		 */
		EClass OBJECT_RESOURCE = eINSTANCE.getObjectResource();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.CollectionParameterImpl <em>Collection Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.CollectionParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionParameter()
		 * @generated
		 */
		EClass COLLECTION_PARAMETER = eINSTANCE.getCollectionParameter();

		/**
		 * The meta object literal for the '<em><b>Containing Resource Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PARAMETER__CONTAINING_RESOURCE_DEFINITION = eINSTANCE.getCollectionParameter_ContainingResourceDefinition();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PropertyReferenceImpl <em>Property Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PropertyReferenceImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPropertyReference()
		 * @generated
		 */
		EClass PROPERTY_REFERENCE = eINSTANCE.getPropertyReference();

		/**
		 * The meta object literal for the '<em><b>Conceptual Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_REFERENCE__CONCEPTUAL_FEATURE = eINSTANCE.getPropertyReference_ConceptualFeature();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SourceReferenceImpl <em>Source Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SourceReferenceImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSourceReference()
		 * @generated
		 */
		EClass SOURCE_REFERENCE = eINSTANCE.getSourceReference();

		/**
		 * The meta object literal for the '<em><b>Containing Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_REFERENCE__CONTAINING_PARAMETER = eINSTANCE.getSourceReference_ContainingParameter();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.MessageParameterImpl <em>Message Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.MessageParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMessageParameter()
		 * @generated
		 */
		EClass MESSAGE_PARAMETER = eINSTANCE.getMessageParameter();

		/**
		 * The meta object literal for the '<em><b>Containing Message</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_PARAMETER__CONTAINING_MESSAGE = eINSTANCE.getMessageParameter_ContainingMessage();

		/**
		 * The meta object literal for the '<em><b>Http Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_PARAMETER__HTTP_LOCATION = eINSTANCE.getMessageParameter_HttpLocation();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl <em>Zen Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ZenModelImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getZenModel()
		 * @generated
		 */
		EClass ZEN_MODEL = eINSTANCE.getZenModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZEN_MODEL__NAME = eINSTANCE.getZenModel_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZEN_MODEL__NAMESPACE = eINSTANCE.getZenModel_Namespace();

		/**
		 * The meta object literal for the '<em><b>Resource AP Is</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__RESOURCE_AP_IS = eINSTANCE.getZenModel_ResourceAPIs();

		/**
		 * The meta object literal for the '<em><b>Data Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__DATA_MODELS = eINSTANCE.getZenModel_DataModels();

		/**
		 * The meta object literal for the '<em><b>Media Types Library</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__MEDIA_TYPES_LIBRARY = eINSTANCE.getZenModel_MediaTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Link Relations Library</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__LINK_RELATIONS_LIBRARY = eINSTANCE.getZenModel_LinkRelationsLibrary();

		/**
		 * The meta object literal for the '<em><b>Primitive Types Library</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY = eINSTANCE.getZenModel_PrimitiveTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__IMPORTS = eINSTANCE.getZenModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Security Schemes Library</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZEN_MODEL__SECURITY_SCHEMES_LIBRARY = eINSTANCE.getZenModel_SecuritySchemesLibrary();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ResourceAPIImpl <em>Resource API</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ResourceAPIImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getResourceAPI()
		 * @generated
		 */
		EClass RESOURCE_API = eINSTANCE.getResourceAPI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_API__NAME = eINSTANCE.getResourceAPI_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_API__VERSION = eINSTANCE.getResourceAPI_Version();

		/**
		 * The meta object literal for the '<em><b>Base URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_API__BASE_URI = eINSTANCE.getResourceAPI_BaseURI();

		/**
		 * The meta object literal for the '<em><b>Owned Resource Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__OWNED_RESOURCE_DEFINITIONS = eINSTANCE.getResourceAPI_OwnedResourceDefinitions();

		/**
		 * The meta object literal for the '<em><b>Service Data Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__SERVICE_DATA_MODELS = eINSTANCE.getResourceAPI_ServiceDataModels();

		/**
		 * The meta object literal for the '<em><b>Formats</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__FORMATS = eINSTANCE.getResourceAPI_Formats();

		/**
		 * The meta object literal for the '<em><b>Defined Media Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__DEFINED_MEDIA_TYPES = eINSTANCE.getResourceAPI_DefinedMediaTypes();

		/**
		 * The meta object literal for the '<em><b>Defined Link Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__DEFINED_LINK_RELATIONS = eINSTANCE.getResourceAPI_DefinedLinkRelations();

		/**
		 * The meta object literal for the '<em><b>Default Reference Realizations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS = eINSTANCE.getResourceAPI_DefaultReferenceRealizations();

		/**
		 * The meta object literal for the '<em><b>Auto Realizations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_API__AUTO_REALIZATIONS = eINSTANCE.getResourceAPI_AutoRealizations();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ServiceDataResourceImpl <em>Service Data Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ServiceDataResourceImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getServiceDataResource()
		 * @generated
		 */
		EClass SERVICE_DATA_RESOURCE = eINSTANCE.getServiceDataResource();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DATA_RESOURCE__DEFAULT = eINSTANCE.getServiceDataResource_Default();

		/**
		 * The meta object literal for the '<em><b>Defined Link Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS = eINSTANCE.getServiceDataResource_DefinedLinkDescriptors();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceTreatmentImpl <em>Reference Treatment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ReferenceTreatmentImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceTreatment()
		 * @generated
		 */
		EClass REFERENCE_TREATMENT = eINSTANCE.getReferenceTreatment();

		/**
		 * The meta object literal for the '<em><b>Reference Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TREATMENT__REFERENCE_ELEMENT = eINSTANCE.getReferenceTreatment_ReferenceElement();

		/**
		 * The meta object literal for the '<em><b>Reference Realization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TREATMENT__REFERENCE_REALIZATION = eINSTANCE.getReferenceTreatment_ReferenceRealization();

		/**
		 * The meta object literal for the '<em><b>Owned Reference Realization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TREATMENT__OWNED_REFERENCE_REALIZATION = eINSTANCE.getReferenceTreatment_OwnedReferenceRealization();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceRealizationImpl <em>Reference Realization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ReferenceRealizationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceRealization()
		 * @generated
		 */
		EClass REFERENCE_REALIZATION = eINSTANCE.getReferenceRealization();

		/**
		 * The meta object literal for the '<em><b>Target Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_REALIZATION__TARGET_RESOURCE = eINSTANCE.getReferenceRealization_TargetResource();

		/**
		 * The meta object literal for the '<em><b>Realization Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_REALIZATION__REALIZATION_TYPE = eINSTANCE.getReferenceRealization_RealizationType();

		/**
		 * The meta object literal for the '<em><b>Multi Valued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_REALIZATION__MULTI_VALUED = eINSTANCE.getReferenceRealization_MultiValued();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceLinkImpl <em>Reference Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ReferenceLinkImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceLink()
		 * @generated
		 */
		EClass REFERENCE_LINK = eINSTANCE.getReferenceLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_LINK__NAME = eINSTANCE.getReferenceLink_Name();

		/**
		 * The meta object literal for the '<em><b>Link Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_LINK__LINK_RELATION = eINSTANCE.getReferenceLink_LinkRelation();

		/**
		 * The meta object literal for the '<em><b>Collection Realization Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_LINK__COLLECTION_REALIZATION_LEVEL = eINSTANCE.getReferenceLink_CollectionRealizationLevel();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceEmbedImpl <em>Reference Embed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ReferenceEmbedImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceEmbed()
		 * @generated
		 */
		EClass REFERENCE_EMBED = eINSTANCE.getReferenceEmbed();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.NamedLinkDescriptorImpl <em>Named Link Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.NamedLinkDescriptorImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getNamedLinkDescriptor()
		 * @generated
		 */
		EClass NAMED_LINK_DESCRIPTOR = eINSTANCE.getNamedLinkDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_LINK_DESCRIPTOR__NAME = eINSTANCE.getNamedLinkDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_LINK_DESCRIPTOR__DEFAULT = eINSTANCE.getNamedLinkDescriptor_Default();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PathSegmentImpl <em>Path Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PathSegmentImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPathSegment()
		 * @generated
		 */
		EClass PATH_SEGMENT = eINSTANCE.getPathSegment();

		/**
		 * The meta object literal for the '<em><b>Reference Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_SEGMENT__REFERENCE_ELEMENT = eINSTANCE.getPathSegment_ReferenceElement();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypeSourceReferenceImpl <em>Primitive Type Source Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PrimitiveTypeSourceReferenceImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveTypeSourceReference()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_SOURCE_REFERENCE = eINSTANCE.getPrimitiveTypeSourceReference();

		/**
		 * The meta object literal for the '<em><b>Simple Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE = eINSTANCE.getPrimitiveTypeSourceReference_SimpleType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.URIImpl <em>URI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.URIImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURI()
		 * @generated
		 */
		EClass URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI__SEGMENTS = eINSTANCE.getURI_Segments();

		/**
		 * The meta object literal for the '<em><b>Uri Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI__URI_PARAMETERS = eINSTANCE.getURI_UriParameters();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.URISegmentImpl <em>URI Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.URISegmentImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURISegment()
		 * @generated
		 */
		EClass URI_SEGMENT = eINSTANCE.getURISegment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_SEGMENT__NAME = eINSTANCE.getURISegment_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.URISegmentWithParameterImpl <em>URI Segment With Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.URISegmentWithParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getURISegmentWithParameter()
		 * @generated
		 */
		EClass URI_SEGMENT_WITH_PARAMETER = eINSTANCE.getURISegmentWithParameter();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PropertyRealizationImpl <em>Property Realization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PropertyRealizationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPropertyRealization()
		 * @generated
		 */
		EClass PROPERTY_REALIZATION = eINSTANCE.getPropertyRealization();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_REALIZATION__BASE_PROPERTY = eINSTANCE.getPropertyRealization_BaseProperty();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_REALIZATION__CARDINALITY = eINSTANCE.getPropertyRealization_Cardinality();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.LinkRelationImpl <em>Link Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.LinkRelationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getLinkRelation()
		 * @generated
		 */
		EClass LINK_RELATION = eINSTANCE.getLinkRelation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_RELATION__NAME = eINSTANCE.getLinkRelation_Name();

		/**
		 * The meta object literal for the '<em><b>Spec URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_RELATION__SPEC_URL = eINSTANCE.getLinkRelation_SpecURL();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.WithExamplesImpl <em>With Examples</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.WithExamplesImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getWithExamples()
		 * @generated
		 */
		EClass WITH_EXAMPLES = eINSTANCE.getWithExamples();

		/**
		 * The meta object literal for the '<em><b>Examples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_EXAMPLES__EXAMPLES = eINSTANCE.getWithExamples_Examples();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ExampleImpl <em>Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ExampleImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExample()
		 * @generated
		 */
		EClass EXAMPLE = eINSTANCE.getExample();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.InlineExampleImpl <em>Inline Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.InlineExampleImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getInlineExample()
		 * @generated
		 */
		EClass INLINE_EXAMPLE = eINSTANCE.getInlineExample();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INLINE_EXAMPLE__BODY = eINSTANCE.getInlineExample_Body();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ExternalExampleImpl <em>External Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ExternalExampleImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExternalExample()
		 * @generated
		 */
		EClass EXTERNAL_EXAMPLE = eINSTANCE.getExternalExample();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_EXAMPLE__PATH = eINSTANCE.getExternalExample_Path();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.HasStringValue <em>Has String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.HasStringValue
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHasStringValue()
		 * @generated
		 */
		EClass HAS_STRING_VALUE = eINSTANCE.getHasStringValue();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ImportDeclarationImpl <em>Import Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ImportDeclarationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getImportDeclaration()
		 * @generated
		 */
		EClass IMPORT_DECLARATION = eINSTANCE.getImportDeclaration();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_DECLARATION__IMPORT_URI = eINSTANCE.getImportDeclaration_ImportURI();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_DECLARATION__IMPORTED_NAMESPACE = eINSTANCE.getImportDeclaration_ImportedNamespace();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_DECLARATION__ALIAS = eINSTANCE.getImportDeclaration_Alias();

		/**
		 * The meta object literal for the '<em><b>Imported Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_DECLARATION__IMPORTED_MODEL = eINSTANCE.getImportDeclaration_ImportedModel();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ObjectRealizationImpl <em>Object Realization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ObjectRealizationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getObjectRealization()
		 * @generated
		 */
		EClass OBJECT_REALIZATION = eINSTANCE.getObjectRealization();

		/**
		 * The meta object literal for the '<em><b>Exclusive Property List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REALIZATION__EXCLUSIVE_PROPERTY_LIST = eINSTANCE.getObjectRealization_ExclusivePropertyList();

		/**
		 * The meta object literal for the '<em><b>Overridden Property List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST = eINSTANCE.getObjectRealization_OverriddenPropertyList();

		/**
		 * The meta object literal for the '<em><b>Excluded Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REALIZATION__EXCLUDED_PROPERTIES = eINSTANCE.getObjectRealization_ExcludedProperties();

		/**
		 * The meta object literal for the '<em><b>Realization Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REALIZATION__REALIZATION_CONTAINER = eINSTANCE.getObjectRealization_RealizationContainer();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.CollectionReferenceElementImpl <em>Collection Reference Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.CollectionReferenceElementImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionReferenceElement()
		 * @generated
		 */
		EClass COLLECTION_REFERENCE_ELEMENT = eINSTANCE.getCollectionReferenceElement();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.HasSecurityValueImpl <em>Has Security Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.HasSecurityValueImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHasSecurityValue()
		 * @generated
		 */
		EClass HAS_SECURITY_VALUE = eINSTANCE.getHasSecurityValue();

		/**
		 * The meta object literal for the '<em><b>Secured By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_SECURITY_VALUE__SECURED_BY = eINSTANCE.getHasSecurityValue_SecuredBy();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl <em>Security Scheme</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecurityScheme()
		 * @generated
		 */
		EClass SECURITY_SCHEME = eINSTANCE.getSecurityScheme();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__NAME = eINSTANCE.getSecurityScheme_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__TYPE = eINSTANCE.getSecurityScheme_Type();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_SCHEME__SCOPES = eINSTANCE.getSecurityScheme_Scopes();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_SCHEME__SETTINGS = eINSTANCE.getSecurityScheme_Settings();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_SCHEME__PARAMETERS = eINSTANCE.getSecurityScheme_Parameters();

		/**
		 * The meta object literal for the '<em><b>Error Responses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_SCHEME__ERROR_RESPONSES = eINSTANCE.getSecurityScheme_ErrorResponses();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__FLOW = eINSTANCE.getSecurityScheme_Flow();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.AuthenticationMethodImpl <em>Authentication Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.AuthenticationMethodImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getAuthenticationMethod()
		 * @generated
		 */
		EClass AUTHENTICATION_METHOD = eINSTANCE.getAuthenticationMethod();

		/**
		 * The meta object literal for the '<em><b>Scheme</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHENTICATION_METHOD__SCHEME = eINSTANCE.getAuthenticationMethod_Scheme();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHENTICATION_METHOD__SCOPES = eINSTANCE.getAuthenticationMethod_Scopes();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SecurityScopeImpl <em>Security Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SecurityScopeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecurityScope()
		 * @generated
		 */
		EClass SECURITY_SCOPE = eINSTANCE.getSecurityScope();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCOPE__NAME = eINSTANCE.getSecurityScope_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeParameterImpl <em>Security Scheme Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SecuritySchemeParameterImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecuritySchemeParameter()
		 * @generated
		 */
		EClass SECURITY_SCHEME_PARAMETER = eINSTANCE.getSecuritySchemeParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME_PARAMETER__NAME = eINSTANCE.getSecuritySchemeParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME_PARAMETER__VALUE = eINSTANCE.getSecuritySchemeParameter_Value();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeLibraryImpl <em>Security Scheme Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SecuritySchemeLibraryImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSecuritySchemeLibrary()
		 * @generated
		 */
		EClass SECURITY_SCHEME_LIBRARY = eINSTANCE.getSecuritySchemeLibrary();

		/**
		 * The meta object literal for the '<em><b>Security Schemes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES = eINSTANCE.getSecuritySchemeLibrary_SecuritySchemes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME_LIBRARY__NAME = eINSTANCE.getSecuritySchemeLibrary_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.RealizationContainerImpl <em>Realization Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.RealizationContainerImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRealizationContainer()
		 * @generated
		 */
		EClass REALIZATION_CONTAINER = eINSTANCE.getRealizationContainer();

		/**
		 * The meta object literal for the '<em><b>With Default Realization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REALIZATION_CONTAINER__WITH_DEFAULT_REALIZATION = eINSTANCE.getRealizationContainer_WithDefaultRealization();

		/**
		 * The meta object literal for the '<em><b>Inline Object Realization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION_CONTAINER__INLINE_OBJECT_REALIZATION = eINSTANCE.getRealizationContainer_InlineObjectRealization();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION_CONTAINER__PROPERTIES = eINSTANCE.getRealizationContainer_Properties();

		/**
		 * The meta object literal for the '<em><b>Reference Treatments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION_CONTAINER__REFERENCE_TREATMENTS = eINSTANCE.getRealizationContainer_ReferenceTreatments();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZATION_CONTAINER__DATA_TYPE = eINSTANCE.getRealizationContainer_DataType();

		/**
		 * The meta object literal for the '<em><b>Realization Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REALIZATION_CONTAINER__REALIZATION_NAME = eINSTANCE.getRealizationContainer_RealizationName();

		/**
		 * The meta object literal for the '<em><b>Effective Realization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REALIZATION_CONTAINER__EFFECTIVE_REALIZATION = eINSTANCE.getRealizationContainer_EffectiveRealization();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.Extensible <em>Extensible</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.Extensible
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExtensible()
		 * @generated
		 */
		EClass EXTENSIBLE = eINSTANCE.getExtensible();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSIBLE__EXTENSIONS = eINSTANCE.getExtensible_Extensions();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ExtensionImpl <em>Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ExtensionImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getExtension()
		 * @generated
		 */
		EClass EXTENSION = eINSTANCE.getExtension();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__NAME = eINSTANCE.getExtension_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__VALUE = eINSTANCE.getExtension_Value();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.RealizationModelLocationImpl <em>Realization Model Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.RealizationModelLocationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRealizationModelLocation()
		 * @generated
		 */
		EClass REALIZATION_MODEL_LOCATION = eINSTANCE.getRealizationModelLocation();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REALIZATION_MODEL_LOCATION__URI = eINSTANCE.getRealizationModelLocation_Uri();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.HasTitleImpl <em>Has Title</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.HasTitleImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHasTitle()
		 * @generated
		 */
		EClass HAS_TITLE = eINSTANCE.getHasTitle();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_TITLE__TITLE = eINSTANCE.getHasTitle_Title();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.OperationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.FeatureImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Containing Data Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CONTAINING_DATA_TYPE = eINSTANCE.getFeature_ContainingDataType();

		/**
		 * The meta object literal for the '<em><b>Restriction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__RESTRICTION = eINSTANCE.getFeature_Restriction();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__READ_ONLY = eINSTANCE.getFeature_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__KEY = eINSTANCE.getFeature_Key();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ReferencePropertyImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceProperty()
		 * @generated
		 */
		EClass REFERENCE_PROPERTY = eINSTANCE.getReferenceProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_PROPERTY__TYPE = eINSTANCE.getReferenceProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Inverse</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_PROPERTY__INVERSE = eINSTANCE.getReferenceProperty_Inverse();

		/**
		 * The meta object literal for the '<em><b>Containment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_PROPERTY__CONTAINMENT = eINSTANCE.getReferenceProperty_Containment();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_PROPERTY__CONTAINER = eINSTANCE.getReferenceProperty_Container();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitivePropertyImpl <em>Primitive Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PrimitivePropertyImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveProperty()
		 * @generated
		 */
		EClass PRIMITIVE_PROPERTY = eINSTANCE.getPrimitiveProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_PROPERTY__TYPE = eINSTANCE.getPrimitiveProperty_Type();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.StructureImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '<em><b>Owned Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__OWNED_FEATURES = eINSTANCE.getStructure_OwnedFeatures();

		/**
		 * The meta object literal for the '<em><b>Owned Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__OWNED_ELEMENTS = eINSTANCE.getStructure_OwnedElements();

		/**
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__OWNED_OPERATIONS = eINSTANCE.getStructure_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Supertypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__SUPERTYPES = eINSTANCE.getStructure_Supertypes();

		/**
		 * The meta object literal for the '<em><b>All Supertypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__ALL_SUPERTYPES = eINSTANCE.getStructure_AllSupertypes();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.DataModelImpl <em>Data Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.DataModelImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDataModel()
		 * @generated
		 */
		EClass DATA_MODEL = eINSTANCE.getDataModel();

		/**
		 * The meta object literal for the '<em><b>Owned Data Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MODEL__OWNED_DATA_TYPES = eINSTANCE.getDataModel_OwnedDataTypes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_MODEL__NAME = eINSTANCE.getDataModel_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.WithDataExamplesImpl <em>With Data Examples</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.WithDataExamplesImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getWithDataExamples()
		 * @generated
		 */
		EClass WITH_DATA_EXAMPLES = eINSTANCE.getWithDataExamples();

		/**
		 * The meta object literal for the '<em><b>Data Examples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_DATA_EXAMPLES__DATA_EXAMPLES = eINSTANCE.getWithDataExamples_DataExamples();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.DataExampleImpl <em>Data Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.DataExampleImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDataExample()
		 * @generated
		 */
		EClass DATA_EXAMPLE = eINSTANCE.getDataExample();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.InlineDataExampleImpl <em>Inline Data Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.InlineDataExampleImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getInlineDataExample()
		 * @generated
		 */
		EClass INLINE_DATA_EXAMPLE = eINSTANCE.getInlineDataExample();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INLINE_DATA_EXAMPLE__BODY = eINSTANCE.getInlineDataExample_Body();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ConstraintImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.EnumerationImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Enum Constants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__ENUM_CONSTANTS = eINSTANCE.getEnumeration_EnumConstants();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__BASE_TYPE = eINSTANCE.getEnumeration_BaseType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SimpleTypeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSimpleType()
		 * @generated
		 */
		EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.EnumConstantImpl <em>Enum Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.EnumConstantImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getEnumConstant()
		 * @generated
		 */
		EClass ENUM_CONSTANT = eINSTANCE.getEnumConstant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_CONSTANT__NAME = eINSTANCE.getEnumConstant_Name();

		/**
		 * The meta object literal for the '<em><b>Integer Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_CONSTANT__INTEGER_VALUE = eINSTANCE.getEnumConstant_IntegerValue();

		/**
		 * The meta object literal for the '<em><b>Literal Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_CONSTANT__LITERAL_VALUE = eINSTANCE.getEnumConstant_LiteralValue();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CONSTANT__ENUMERATION = eINSTANCE.getEnumConstant_Enumeration();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.UserDefinedTypeImpl <em>User Defined Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.UserDefinedTypeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getUserDefinedType()
		 * @generated
		 */
		EClass USER_DEFINED_TYPE = eINSTANCE.getUserDefinedType();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_TYPE__BASE_TYPE = eINSTANCE.getUserDefinedType_BaseType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PrimitiveTypeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.DataTypeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__NAME = eINSTANCE.getDataType_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.SingleValueTypeImpl <em>Single Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.SingleValueTypeImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getSingleValueType()
		 * @generated
		 */
		EClass SINGLE_VALUE_TYPE = eINSTANCE.getSingleValueType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ElementImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__CARDINALITY = eINSTANCE.getElement_Cardinality();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ReferenceElementImpl <em>Reference Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ReferenceElementImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceElement()
		 * @generated
		 */
		EClass REFERENCE_ELEMENT = eINSTANCE.getReferenceElement();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ELEMENT__DATA_TYPE = eINSTANCE.getReferenceElement_DataType();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.LengthConstraintImpl <em>Length Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.LengthConstraintImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getLengthConstraint()
		 * @generated
		 */
		EClass LENGTH_CONSTRAINT = eINSTANCE.getLengthConstraint();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LENGTH_CONSTRAINT__MIN_LENGTH = eINSTANCE.getLengthConstraint_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LENGTH_CONSTRAINT__MAX_LENGTH = eINSTANCE.getLengthConstraint_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LENGTH_CONSTRAINT__LENGTH = eINSTANCE.getLengthConstraint_Length();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.RegExConstraintImpl <em>Reg Ex Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.RegExConstraintImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRegExConstraint()
		 * @generated
		 */
		EClass REG_EX_CONSTRAINT = eINSTANCE.getRegExConstraint();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EX_CONSTRAINT__PATTERN = eINSTANCE.getRegExConstraint_Pattern();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.ValueRangeConstraintImpl <em>Value Range Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.ValueRangeConstraintImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getValueRangeConstraint()
		 * @generated
		 */
		EClass VALUE_RANGE_CONSTRAINT = eINSTANCE.getValueRangeConstraint();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_RANGE_CONSTRAINT__MIN_VALUE = eINSTANCE.getValueRangeConstraint_MinValue();

		/**
		 * The meta object literal for the '<em><b>Min Value Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE = eINSTANCE.getValueRangeConstraint_MinValueExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_RANGE_CONSTRAINT__MAX_VALUE = eINSTANCE.getValueRangeConstraint_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Max Value Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE = eINSTANCE.getValueRangeConstraint_MaxValueExclusive();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.ConstrainableType <em>Constrainable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.ConstrainableType
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getConstrainableType()
		 * @generated
		 */
		EClass CONSTRAINABLE_TYPE = eINSTANCE.getConstrainableType();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINABLE_TYPE__CONSTRAINTS = eINSTANCE.getConstrainableType_Constraints();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.Inheritable <em>Inheritable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.Inheritable
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getInheritable()
		 * @generated
		 */
		EClass INHERITABLE = eINSTANCE.getInheritable();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.MediaTypesLibraryImpl <em>Media Types Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.MediaTypesLibraryImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getMediaTypesLibrary()
		 * @generated
		 */
		EClass MEDIA_TYPES_LIBRARY = eINSTANCE.getMediaTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Media Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIA_TYPES_LIBRARY__MEDIA_TYPES = eINSTANCE.getMediaTypesLibrary_MediaTypes();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.LinkRelationsLibraryImpl <em>Link Relations Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.LinkRelationsLibraryImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getLinkRelationsLibrary()
		 * @generated
		 */
		EClass LINK_RELATIONS_LIBRARY = eINSTANCE.getLinkRelationsLibrary();

		/**
		 * The meta object literal for the '<em><b>Defined Link Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_RELATIONS_LIBRARY__DEFINED_LINK_RELATIONS = eINSTANCE.getLinkRelationsLibrary_DefinedLinkRelations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_RELATIONS_LIBRARY__NAME = eINSTANCE.getLinkRelationsLibrary_Name();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypesLibraryImpl <em>Primitive Types Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.PrimitiveTypesLibraryImpl
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getPrimitiveTypesLibrary()
		 * @generated
		 */
		EClass PRIMITIVE_TYPES_LIBRARY = eINSTANCE.getPrimitiveTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPES_LIBRARY__NAME = eINSTANCE.getPrimitiveTypesLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Primitive Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPES_LIBRARY__PRIMITIVE_TYPES = eINSTANCE.getPrimitiveTypesLibrary_PrimitiveTypes();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.HTTPMethods <em>HTTP Methods</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.HTTPMethods
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHTTPMethods()
		 * @generated
		 */
		EEnum HTTP_METHODS = eINSTANCE.getHTTPMethods();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.ReferenceRealizationEnum <em>Reference Realization Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.ReferenceRealizationEnum
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getReferenceRealizationEnum()
		 * @generated
		 */
		EEnum REFERENCE_REALIZATION_ENUM = eINSTANCE.getReferenceRealizationEnum();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.HttpMessageParameterLocation <em>Http Message Parameter Location</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.HttpMessageParameterLocation
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getHttpMessageParameterLocation()
		 * @generated
		 */
		EEnum HTTP_MESSAGE_PARAMETER_LOCATION = eINSTANCE.getHttpMessageParameterLocation();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.CollectionRealizationEnum <em>Collection Realization Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.CollectionRealizationEnum
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionRealizationEnum()
		 * @generated
		 */
		EEnum COLLECTION_REALIZATION_ENUM = eINSTANCE.getCollectionRealizationEnum();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.AuthenticationTypes <em>Authentication Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.AuthenticationTypes
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getAuthenticationTypes()
		 * @generated
		 */
		EEnum AUTHENTICATION_TYPES = eINSTANCE.getAuthenticationTypes();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.AuthenticationFlows <em>Authentication Flows</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.AuthenticationFlows
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getAuthenticationFlows()
		 * @generated
		 */
		EEnum AUTHENTICATION_FLOWS = eINSTANCE.getAuthenticationFlows();

		/**
		 * The meta object literal for the '{@link com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum <em>Collection Realization Level Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionRealizationLevelEnum()
		 * @generated
		 */
		EEnum COLLECTION_REALIZATION_LEVEL_ENUM = eINSTANCE.getCollectionRealizationLevelEnum();

		/**
		 * The meta object literal for the '<em>Realization Model</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.realization.model.RealizationModel
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getRealizationModel()
		 * @generated
		 */
		EDataType REALIZATION_MODEL = eINSTANCE.getRealizationModel();

		/**
		 * The meta object literal for the '<em>Collection Realization Level Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.CollectionRealizationLevelEnum
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCollectionRealizationLevelObject()
		 * @generated
		 */
		EDataType COLLECTION_REALIZATION_LEVEL_OBJECT = eINSTANCE.getCollectionRealizationLevelObject();

		/**
		 * The meta object literal for the '<em>Effective Realization</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.realization.processor.EffectiveRealization
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getEffectiveRealization()
		 * @generated
		 */
		EDataType EFFECTIVE_REALIZATION = eINSTANCE.getEffectiveRealization();

		/**
		 * The meta object literal for the '<em>Cardinality</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCardinality()
		 * @generated
		 */
		EDataType CARDINALITY = eINSTANCE.getCardinality();

		/**
		 * The meta object literal for the '<em>Cardinality Override</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.modelsolv.reprezen.restapi.impl.RestapiPackageImpl#getCardinalityOverride()
		 * @generated
		 */
		EDataType CARDINALITY_OVERRIDE = eINSTANCE.getCardinalityOverride();

	}

} //RestapiPackage
