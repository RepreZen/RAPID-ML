/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui;

import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Binder;
import com.google.inject.Module;

public class RepreZenGlobalModule implements Module {

    @Override
    public void configure(Binder binder) {
        /*
         * ZEN-3726: Bind a modified IStorage2UriMapper implementation that creates URI from file schemes instead of
         * platform schemes (file system vs workspace).
         */
        binder.bind(IStorage2UriMapper.class).to(Storage2FileUriMapperImpl.class);
    }
}
