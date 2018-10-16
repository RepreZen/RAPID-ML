/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.nls;

import org.eclipse.osgi.util.NLS;

/**
 * @author Konstantin Zaitsev
 * @date Dec 29, 2014
 */
public class Messages extends NLS {
    private static final String BUNDLE_NAME = "com.modelsolv.reprezen.restapi.xtext.ui.nls.messages"; //$NON-NLS-1$

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
