/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.modelpath;

import com.reprezen.core.debug.Debug;
import com.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option;
import com.reprezen.core.ConfigVariable;

public class DebugModelPath extends Debug<Option> {

    public DebugModelPath() {
        super(Option.class);
    }

    @Override
    protected String getName() {
        return "ModelPath";
    }

    @Override
    protected ConfigVariable getDebugVar() {
        return ConfigVariable.REPREZEN_DEBUG_MODELPATH;
    }

    private static DebugModelPath instance = new DebugModelPath();

    public static void debug(Object... args) {
        instance._debug(args);
    }

    public static enum Option {
        RESOLUTION, MATCHING, INTERPOLATION, DEFAULT
    }
}
