/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Method#getRequest <em>Request</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Method#getResponses <em>Responses</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Method#getId <em>Id</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Method#getHttpMethod <em>Http Method</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Method#getContainingResourceDefinition <em>Containing Resource Definition</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends RESTElement, HasSecurityValue, Extensible {
	/**
	 * Returns the value of the '<em><b>Request</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.TypedRequest#getContainingMethod <em>Containing Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request</em>' containment reference.
	 * @see #setRequest(TypedRequest)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getMethod_Request()
	 * @see com.modelsolv.reprezen.rapidml.TypedRequest#getContainingMethod
	 * @model opposite="containingMethod" containment="true"
	 * @generated
	 */
	TypedRequest getRequest();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Method#getRequest <em>Request</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request</em>' containment reference.
	 * @see #getRequest()
	 * @generated
	 */
	void setRequest(TypedRequest value);

	/**
	 * Returns the value of the '<em><b>Responses</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.TypedResponse}.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.TypedResponse#getContainingMethod <em>Containing Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responses</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getMethod_Responses()
	 * @see com.modelsolv.reprezen.rapidml.TypedResponse#getContainingMethod
	 * @model opposite="containingMethod" containment="true"
	 * @generated
	 */
	EList<TypedResponse> getResponses();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getMethod_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Method#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Http Method</b></em>' attribute.
	 * The literals are from the enumeration {@link com.modelsolv.reprezen.rapidml.HTTPMethods}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http Method</em>' attribute.
	 * @see com.modelsolv.reprezen.rapidml.HTTPMethods
	 * @see #setHttpMethod(HTTPMethods)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getMethod_HttpMethod()
	 * @model
	 * @generated
	 */
	HTTPMethods getHttpMethod();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Method#getHttpMethod <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http Method</em>' attribute.
	 * @see com.modelsolv.reprezen.rapidml.HTTPMethods
	 * @see #getHttpMethod()
	 * @generated
	 */
	void setHttpMethod(HTTPMethods value);

	/**
	 * Returns the value of the '<em><b>Containing Resource Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.ResourceDefinition#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Resource Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Resource Definition</em>' container reference.
	 * @see #setContainingResourceDefinition(ResourceDefinition)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getMethod_ContainingResourceDefinition()
	 * @see com.modelsolv.reprezen.rapidml.ResourceDefinition#getMethods
	 * @model opposite="methods" transient="false"
	 * @generated
	 */
	ResourceDefinition getContainingResourceDefinition();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Method#getContainingResourceDefinition <em>Containing Resource Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Resource Definition</em>' container reference.
	 * @see #getContainingResourceDefinition()
	 * @generated
	 */
	void setContainingResourceDefinition(ResourceDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getId() == null || Strings.isNullOrEmpty(getId().trim())) {\n    return getHttpMethod().toString().toLowerCase() + getContainingResourceDefinition().getName();\n}\nreturn getId();'"
	 * @generated
	 */
	String getName();

} // Method
