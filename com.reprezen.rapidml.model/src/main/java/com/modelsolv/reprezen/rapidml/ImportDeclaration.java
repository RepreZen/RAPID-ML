/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getImportedModel <em>Imported Model</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getImportDeclaration()
 * @model
 * @generated
 */
public interface ImportDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import URI</em>' attribute.
	 * @see #setImportURI(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getImportDeclaration_ImportURI()
	 * @model required="true"
	 * @generated
	 */
	String getImportURI();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getImportURI <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import URI</em>' attribute.
	 * @see #getImportURI()
	 * @generated
	 */
	void setImportURI(String value);

	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' attribute.
	 * @see #setImportedNamespace(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getImportDeclaration_ImportedNamespace()
	 * @model
	 * @generated
	 */
	String getImportedNamespace();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' attribute.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getImportDeclaration_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Imported Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Model</em>' reference.
	 * @see #setImportedModel(ZenModel)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getImportDeclaration_ImportedModel()
	 * @model
	 * @generated
	 */
	ZenModel getImportedModel();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.ImportDeclaration#getImportedModel <em>Imported Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Model</em>' reference.
	 * @see #getImportedModel()
	 * @generated
	 */
	void setImportedModel(ZenModel value);

} // ImportDeclaration
