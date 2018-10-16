/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

import com.modelsolv.reprezen.restapi.xtext.ui.internal.RepreZenDslActivator;

/**
 * @author Konstantin Zaitsev
 * @date Nov 17, 2014
 */
public class RepreZenUIImages {
    public static final String IMG_ZEN_FILE = "zen_file"; //$NON-NLS-1$
    public static final String IMG_PACKAGE = "package"; //$NON-NLS-1$

    /** The image registry containing <code>Image</code>s. */
    private static ImageRegistry imageRegistry;

    private final static String ICONS_PATH = "icons/"; //$NON-NLS-1$

    /**
     * Returns the <code>Image<code> identified by the given key,
     * or <code>null</code> if it does not exist.
     */
    public static Image getImage(String key) {
        return getImageRegistry().get(key);
    }

    /**
     * Returns the <code>ImageDescriptor<code> identified by the given key,
     * or <code>null</code> if it does not exist.
     */
    public static ImageDescriptor getImageDescriptor(String key) {
        return getImageRegistry().getDescriptor(key);
    }

    /** Declare all images */
    private static void declareImages() {
        declareRegistryImage(IMG_ZEN_FILE, ICONS_PATH + "file_obj.png"); //$NON-NLS-1$
        declareRegistryImage(IMG_PACKAGE, ICONS_PATH + "package_obj.png"); //$NON-NLS-1$
    }

    private static void declareRegistryImage(String key, String path) {
        ImageDescriptor desc = ImageDescriptor.getMissingImageDescriptor();
        Bundle bundle = Platform.getBundle(RepreZenDslActivator.PLUGIN_ID);
        URL url = null;
        if (bundle != null) {
            url = FileLocator.find(bundle, new Path(path), null);
            desc = ImageDescriptor.createFromURL(url);
        }
        imageRegistry.put(key, desc);
    }

    private static ImageRegistry getImageRegistry() {
        if (imageRegistry == null) {
            initializeImageRegistry();
        }
        return imageRegistry;
    }

    private static ImageRegistry initializeImageRegistry() {
        Display display = Display.getCurrent();
        if (display == null) {
            display = Display.getDefault();
        }
        imageRegistry = new ImageRegistry(display);
        declareImages();
        return imageRegistry;
    }
}