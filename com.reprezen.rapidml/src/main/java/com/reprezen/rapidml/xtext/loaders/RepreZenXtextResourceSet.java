/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * @author Konstantin Zaitsev
 * @date Nov 11, 2014
 */
public class RepreZenXtextResourceSet extends XtextResourceSet {

    public RepreZenXtextResourceSet() {
        super();

        // ZEN-971 (https://www.eclipse.org/forums/index.php/t/835760/)
        // Improve receiving changes from imported model file
        getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
    }
}
