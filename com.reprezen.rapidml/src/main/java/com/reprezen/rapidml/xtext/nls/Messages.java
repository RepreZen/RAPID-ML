/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.nls;

import org.eclipse.osgi.util.NLS;

/**
 * @author Konstantin Zaitsev
 * @date Oct 30, 2014
 */
public class Messages extends NLS {
    private static final String BUNDLE_NAME = "com.reprezen.rapidml.xtext.nls.messages"; //$NON-NLS-1$
    public static String CustomSyntaxErrorMessageProvider_lineBeak;
    public static String CustomSyntaxErrorMessageProvider_aValidName;
    public static String CustomSyntaxErrorMessageProvider_endOfFile;
    public static String CustomSyntaxErrorMessageProvider_msgMissingToken;
    public static String CustomSyntaxErrorMessageProvider_msgMissingTokenId;
    public static String CustomSyntaxErrorMessageProvider_msgNotAllowedAttribute;
    public static String CustomSyntaxErrorMessageProvider_msgUnclosedMultilineComment;
    public static String CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel;
    public static String CustomSyntaxErrorMessageProvider_msgInvalidIndentNextLine;
    public static String RepreZenImportUriGlobalScopeProvider_importModelSyntaxError;
    public static String RepreZenImportUriGlobalScopeProvider_importIncorrectFormat;
    public static String RepreZenImportUriGlobalScopeProvider_importUriIncorrect;
    public static String UserCredentialsDialog_message;
    public static String UserCredentialsDialog_password;
    public static String UserCredentialsDialog_title;
    public static String UserCredentialsDialog_userName;
    public static String CustomSyntaxErrorMessageProvider_msgRequiredAttributes;
    public static String CustomSyntaxErrorMessageProvider_msgUnexpectedToken;
    public static String CustomSyntaxErrorMessageProvider_msgUnexpectedTokenId;
    public static String CustomSyntaxErrorMessageProvider_nameIsMissing;
    public static String CustomSyntaxErrorMessageProvider_unknownElement;
    public static String XtextDslJavaValidator_circularBaseType;
    public static String XtextDslJavaValidator_constraintsNumericType;
    public static String XtextDslJavaValidator_constraintsPrimitiveType;
    public static String XtextDslJavaValidator_constraintsStringType;
    public static String XtextDslJavaValidator_duplicateAlias;
    public static String XtextDslJavaValidator_duplicateNamespace;
    public static String XtextDslJavaValidator_excludedPropsDuplicate;
    public static String XtextDslJavaValidator_includedPropsDuplicate;
    public static String XtextDslJavaValidator_incorrectNamespace;
    public static String FormatterPreferencePage_incorrect_order_checkbox_text;
    public static String FormatterPreferencePage_incorrect_order_pref_key;
    public static String RepreZenValidatorConfigurationBlock_random_order_section_title;
    public static String RepreZenValidatorConfigurationBlock_warning;
    public static String RepreZenValidatorConfigurationBlock_ignore;
    public static String RepreZenValidatorConfigurationBlock_random_order_issue_key;
    public static String RepreZenValidatorConfigurationBlock_random_order_issue_key_all;

    public static String XtextDslJavaValidator_incorrect_order_warning;
    public static String XtextDslJavaValidator_messageParameterLocation;
    public static String XtextDslJavaValidator_regexPatternAnchors;
    public static String XtextDslJavaValidator_typedMessageBody;
    public static String XtextDslJavaValidator_typedMessageThisNotAllowedOnType;
    public static String XtextDslJavaValidator_typedMessagePropertySetNotAllowed;
    public static String XtextDslJavaValidator_typedMessageInvalidParentTypeReference;
    public static String XtextDslJavaValidator_externalExampleCantReadBody;

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
