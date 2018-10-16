/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.formatting;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage;

import com.modelsolv.reprezen.restapi.xtext.nls.Messages;

public class FormatterPreferencePage extends AbstractPreferencePage {

    @Override
    protected void createFieldEditors() {
        BooleanFieldEditor bed = new BooleanFieldEditor(Messages.FormatterPreferencePage_incorrect_order_pref_key,
                Messages.FormatterPreferencePage_incorrect_order_checkbox_text, getFieldEditorParent());
        addField(bed);

    }

}
