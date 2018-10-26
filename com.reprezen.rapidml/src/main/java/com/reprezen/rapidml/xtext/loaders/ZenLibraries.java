/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import org.eclipse.emf.common.util.URI;

/**
 * References to all ZEN libraries used throughout RepreZen should be registered in this class.
 * 
 * @author jimleroyer
 */
public abstract class ZenLibraries {

    public static final URI LIBRARIES_URI = URI.createPlatformPluginURI(
            "/com.reprezen.rapidml.xtext/libraries", false);
    public static final URI PRIMITIVE_TYPES = LIBRARIES_URI.appendSegment("PrimitiveTypes.rapid");
    public static final URI STANDARD_MEDIA_TYPES = LIBRARIES_URI.appendSegment("StandardMediaTypes.rapid");
    public static final URI IANA_LINK_RELATIONS = LIBRARIES_URI.appendSegment("IANALinkRelations.rapid");

}
