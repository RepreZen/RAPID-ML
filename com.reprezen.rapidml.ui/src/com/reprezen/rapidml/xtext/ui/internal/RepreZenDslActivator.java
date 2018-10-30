/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;

import com.reprezen.rapidml.ui.internal.RapidmlActivator;

public class RepreZenDslActivator extends RapidmlActivator {

    public static String PLUGIN_ID = "com.reprezen.rapidml.xtext.ui";

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    public static IStatus createErrorStatus(String message) {
        return new Status(IStatus.ERROR, RepreZenDslActivator.PLUGIN_ID, message);
    }

}
