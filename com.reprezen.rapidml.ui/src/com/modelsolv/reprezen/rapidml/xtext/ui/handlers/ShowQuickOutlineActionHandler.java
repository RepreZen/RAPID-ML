/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlinePopup;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * See ZEN-3861 Quick Outline View: sticky size & position
 * 
 * @author Peter Friese - Initial contribution and API
 */
public class ShowQuickOutlineActionHandler extends AbstractHandler {

    @Inject
    private Injector injector;

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
        if (xtextEditor != null) {
            final IXtextDocument document = xtextEditor.getDocument();
            document.priorityReadOnly(new IUnitOfWork.Void<XtextResource>() {
                @Override
                public void process(XtextResource state) throws Exception {
                    final QuickOutlinePopup quickOutlinePopup = createPopup(xtextEditor.getEditorSite().getShell());
                    quickOutlinePopup.setEditor(xtextEditor);
                    quickOutlinePopup.setInput(document);
                    quickOutlinePopup.setEvent((Event) event.getTrigger());
                    quickOutlinePopup.open();
                }
            });
        }
        return null;
    }

    /**
     * ZEN-3861
     * 
     * We override the default size provider to make sure to have to larger default width.
     * 
     * @since 2.2
     */
    protected QuickOutlinePopup createPopup(Shell parent) {
        QuickOutlinePopup result = new QuickOutlinePopup(parent) {
            @Override
            protected Point getDefaultSize() {
                return new Point(480, 320);
            }
        };
        injector.injectMembers(result);
        return result;
    }

}
