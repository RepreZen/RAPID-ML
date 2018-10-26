/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.internal;

import org.eclipse.jface.text.formatter.FormattingContext;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer.Factory;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * Custom implementation of XTextSourceViewer to disable Format functionality on editor errors.
 * 
 * @author Konstantin Zaitsev
 * @date Oct 1, 2014
 */
public class RepreZenSourceViewerFactory implements Factory {

    public static final String FORMATTING_CURSOR_POSITION = "formatting.cursor.position";

    @Override
    public XtextSourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
            boolean showsAnnotationOverview, int styles) {
        return new XtextSourceViewer(parent, ruler, overviewRuler, showsAnnotationOverview, styles) {
            @Override
            public boolean canDoOperation(int operation) {
                // in case of format action we check errors in document
                if (FORMAT == operation) {
                    return super.canDoOperation(operation) && isDocumentValid();
                }
                return super.canDoOperation(operation);
            }

            @SuppressWarnings("unchecked")
            private boolean isDocumentValid() {
                // We cannot use document.readOnly->XtextResource.errors because it invoke reconcile and validation
                return this.getAnnotationModel() == null || this.getAnnotationModel().getAnnotationIterator() == null
                        || !Iterators.any(this.getAnnotationModel().getAnnotationIterator(), new Predicate<Object>() {
                            @Override
                            public boolean apply(Object input) {
                                return input instanceof XtextAnnotation
                                        && ((XtextAnnotation) input).getType()
                                                .equals(XtextEditor.ERROR_ANNOTATION_TYPE);
                            }
                        });
            }

            @Override
            protected IFormattingContext createFormattingContext() {
                FormattingContext context = new FormattingContext();
                context.setProperty(FORMATTING_CURSOR_POSITION, getSelectedRange().x);
                return context;
            }
        };
    }
}
