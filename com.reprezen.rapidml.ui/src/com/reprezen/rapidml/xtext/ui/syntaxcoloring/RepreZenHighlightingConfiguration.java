/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.syntaxcoloring;

import java.util.Arrays;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

import com.reprezen.core.util.RepreZenSystemProperties;

/**
 * @author Konstantin Zaitsev
 * @date Oct 21, 2014
 */
public class RepreZenHighlightingConfiguration extends DefaultHighlightingConfiguration {
    public static final String JAVADOC_ID = "javadoc"; //$NON-NLS-1$
    public static final String NAME_ID = "name"; //$NON-NLS-1$
    public static final String OPTIONAL_KEYWORD_ID = "optional_keyword"; //$NON-NLS-1$
    public static final String RAW_STRING_ID = "raw_string"; //$NON-NLS-1$
    

    @Override
    public void configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor);
        acceptor.acceptDefaultHighlighting(JAVADOC_ID, "Documentation", documentationTextStyle()); //$NON-NLS-1$
        acceptor.acceptDefaultHighlighting(NAME_ID, "Name", nameTextStyle()); //$NON-NLS-1$
        acceptor.acceptDefaultHighlighting(OPTIONAL_KEYWORD_ID, "Optional Keyword", optionalTextStyle()); //$NON-NLS-1$
        acceptor.acceptDefaultHighlighting(RAW_STRING_ID, "Raw String", stringTextStyle()); //$NON-NLS-1$
    }
    
    @Override
    public TextStyle defaultTextStyle() {
        TextStyle result = super.defaultTextStyle();
        FontData fontData = new FontData();
        int height = isInPresentationMode() ? 18 : 12;
        fontData.setHeight(height);
        switch (Platform.getOS()) {
        case Platform.OS_MACOSX:
            fontData.setName("Menlo"); break;
        case Platform.OS_WIN32:
            fontData.setName("Consolas"); break;
        }
        result.setFontData(fontData);
        return result;
    }
    
    public boolean isInPresentationMode() {
        // This method is invoked on first opening of the Zen editor and every
        // time we open the corresponding preferences page.
        // Because of this I don't think we need to optimize this code
        String[] programArguments = Platform.getCommandLineArgs();
        return Arrays.asList(programArguments).contains(RepreZenSystemProperties.UsePresentationMode.getName());
    }

    public TextStyle documentationTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(255, 0, 255));
        return textStyle;
    }
    
    @Override
    public TextStyle keywordTextStyle() {
        TextStyle result = super.keywordTextStyle();
        setFontStyle(result, SWT.BOLD);
        return result;
    }

    public TextStyle nameTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(239, 16, 16));
        setFontStyle(textStyle, SWT.BOLD);
        return textStyle;
    }

    /**
     * Set font style. Simple textStyle.setStyle(style) can be lost after the
     * Restore Defaults action.
     * 
     */
    protected void setFontStyle(TextStyle textStyle, int style) {
        textStyle.setStyle(style);
        for (FontData fd : textStyle.getFontData()) {
            fd.setStyle(style);
        }
    }

    public TextStyle optionalTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(127, 0, 85));
        return textStyle;
    }
}
