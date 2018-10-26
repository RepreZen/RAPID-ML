/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.modelsolv.reprezen.rapidml.xtext.nls.Messages;
import com.modelsolv.reprezen.rapidml.xtext.ui.internal.RepreZenDslActivator;

public class RepreZenPreferenceInitializer extends AbstractPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        IEclipsePreferences defaultPreferences = DefaultScope.INSTANCE
                .getNode(RepreZenDslActivator.COM_MODELSOLV_REPREZEN_RESTAPI_XTEXT_RAPIDML); // language name
                                                                                           // "com.modelsolv.reprezen.rapidml.xtext.XtextDsl"

        defaultPreferences.putBoolean(Messages.FormatterPreferencePage_incorrect_order_pref_key, true);
    }
}
