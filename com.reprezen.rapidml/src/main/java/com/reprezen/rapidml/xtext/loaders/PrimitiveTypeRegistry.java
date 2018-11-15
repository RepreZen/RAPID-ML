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
import com.reprezen.rapidml.PrimitiveType;

/**
 * A table of primitive types
 * 
 * @author Tatiana Fesenko
 *
 */
public class PrimitiveTypeRegistry extends LibraryRegistry<PrimitiveType> {
    public PrimitiveTypeRegistry() {
        super(PrimitiveType.class, ZenLibraries.PRIMITIVE_TYPES);
    }

    @Override
    protected Function<PrimitiveType, String> getElementId() {
        return new Function<PrimitiveType, String>() {

            @Override
            public String apply(PrimitiveType element) {
                return element.getName();
            }

        };

    }

}
