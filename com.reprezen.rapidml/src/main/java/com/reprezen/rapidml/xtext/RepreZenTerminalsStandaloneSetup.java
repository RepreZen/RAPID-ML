/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/

package com.reprezen.rapidml.xtext;

/**
 * Initialization support for running Xtext languages without equinox extension registry
 */
public class RepreZenTerminalsStandaloneSetup extends RepreZenTerminalsStandaloneSetupGenerated {

    public static void doSetup() {
        new RepreZenTerminalsStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
