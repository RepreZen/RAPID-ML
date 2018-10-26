/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.FormColors;

/**
 * This code is used to display a gray gradient color similar to JDT's breadcrumb. <br>
 * It is borrowed from org.eclipse.jdt.internal.ui.javaeditor.breadcrumb.BreadcrumbViewer.
 */
public class EditorToolBarBackgroundUtils {

    public static Image createGradientImage(int height, Display display) {
        int width = 50;

        Image result = new Image(display, width, height);

        GC gc = new GC(result);

        Color colorC = createColor(SWT.COLOR_WIDGET_BACKGROUND, SWT.COLOR_LIST_BACKGROUND, 35, display);
        Color colorD = createColor(SWT.COLOR_WIDGET_BACKGROUND, SWT.COLOR_LIST_BACKGROUND, 45, display);
        Color colorE = createColor(SWT.COLOR_WIDGET_BACKGROUND, SWT.COLOR_LIST_BACKGROUND, 80, display);
        Color colorF = createColor(SWT.COLOR_WIDGET_BACKGROUND, SWT.COLOR_LIST_BACKGROUND, 70, display);
        Color colorG = createColor(SWT.COLOR_WIDGET_BACKGROUND, SWT.COLOR_WHITE, 45, display);
        Color colorH = createColor(SWT.COLOR_WIDGET_NORMAL_SHADOW, SWT.COLOR_LIST_BACKGROUND, 35, display);

        try {
            drawLine(width, 0, colorC, gc);
            drawLine(width, 1, colorC, gc);

            gc.setForeground(colorD);
            gc.setBackground(colorE);
            gc.fillGradientRectangle(0, 2, width, 2 + 8, true);

            gc.setBackground(colorE);
            gc.fillRectangle(0, 2 + 9, width, height - 4);

            drawLine(width, height - 3, colorF, gc);
            drawLine(width, height - 2, colorG, gc);
            drawLine(width, height - 1, colorH, gc);

        } finally {
            gc.dispose();

            colorC.dispose();
            colorD.dispose();
            colorE.dispose();
            colorF.dispose();
            colorG.dispose();
            colorH.dispose();
        }

        return result;
    }

    private static void drawLine(int width, int position, Color color, GC gc) {
        gc.setForeground(color);
        gc.drawLine(0, position, width, position);
    }

    private static Color createColor(int color1, int color2, int ratio, Display display) {
        RGB rgb1 = display.getSystemColor(color1).getRGB();
        RGB rgb2 = display.getSystemColor(color2).getRGB();

        RGB blend = FormColors.blend(rgb2, rgb1, ratio);

        return new Color(display, blend);
    }
}
