/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import com.google.common.base.Function;
import com.reprezen.rapidml.MediaType;

/**
 * A table of standard media types
 * 
 * @author Tatiana Fesenko
 *
 */
public class MediaTypeRegistry extends LibraryRegistry<MediaType> {
    public MediaTypeRegistry() {
        super(MediaType.class, ZenLibraries.STANDARD_MEDIA_TYPES);
    }

    @Override
    protected Function<MediaType, String> getElementId() {
        return new Function<MediaType, String>() {

            @Override
            public String apply(MediaType element) {
                return element.getName();
            }

        };

    }

}
