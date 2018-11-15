/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle and logging functionality.
 * 
 * @author Konstantin Zaitsev
 * @date Sep 8, 2014
 */
public class RestApiXtextPlugin extends Plugin {
    /** The plug-in ID. */
    public static final String PLUGIN_ID = "com.reprezen.rapidml"; //$NON-NLS-1$
    /** EMF content type for RepreZen model files. */
    public static final String ZEN_CONTENT_TYPE = "com.modelsolv.reprezen.restapi.xtext.ui.zen"; //$NON-NLS-1$

    /** The shared instance. */
    private static RestApiXtextPlugin plugin;

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     *
     * @return the shared instance
     */
    public static RestApiXtextPlugin getDefault() {
        return plugin;
    }

    /**
     * Logs error message in Eclipse "Error Log" view.
     * 
     * @param message
     *            custom log message can contains NLS pattern, for example <code>error {0} message</code>
     * @param params
     *            optional NLS params for message format
     */
    public static void log(String message, Object... params) {
        getDefault().getLog()
                .log(new Status(Status.ERROR, PLUGIN_ID, params.length > 0 ? NLS.bind(message, params) : message));
    }

    /**
     * Logs error message in Eclipse "Error Log" view.
     * 
     * @param message
     *            custom log message
     * @param e
     *            an exception
     */
    public static void log(String message, Throwable e) {
        getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID, message, e));
    }

    /**
     * Logs exception in Eclipse Error Log view.
     * 
     * @param e
     *            an exception
     */
    public static void log(Throwable e) {
        log(e.getMessage(), e);
    }
}
