/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class MockServicePanel extends Composite {
    private Image gradient;

    public MockServicePanel(Composite parent) {
        super(parent, SWT.NONE);

        GridLayout buttonsLayout = new GridLayout(1, false);
        buttonsLayout.marginHeight = 0;
        buttonsLayout.marginWidth = 0;
        buttonsLayout.horizontalSpacing = 0;
        buttonsLayout.verticalSpacing = 0;
        setLayout(buttonsLayout);
        
        this.addListener(SWT.Resize, new Listener() {
            @Override
            public void handleEvent(Event event) {
                recomputeBackground();
            }
        });
        recomputeBackground();
    }

    @Override
    public void dispose() {
        if (gradient != null) {
            gradient.dispose();
            gradient = null;
        }
        super.dispose();
    }

    private void recomputeBackground() {
        int height = getClientArea().height;
        if (gradient == null || gradient.getBounds().height != height) {
            Image image = createGradient(height);
            setBackgroundImage(image);
            if (gradient != null) {
                gradient.dispose();
            }
            gradient = image;
        }
    }

    private Image createGradient(int height) {
        if (height == 0) {
            return null;
        }
        return EditorToolBarBackgroundUtils.createGradientImage(height, getDisplay());
    }

}
