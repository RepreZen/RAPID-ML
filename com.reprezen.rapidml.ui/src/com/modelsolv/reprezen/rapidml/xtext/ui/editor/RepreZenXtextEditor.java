/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.modelsolv.reprezen.rapidml.xtext.ui.mockapi.MockServiceContributor;

public class RepreZenXtextEditor extends XtextEditor implements MockServiceContributor {

    // private final MockServiceManager mockServiceManager = MockServiceManager.getInstance();

    // private final ILog log = RepreZenDslActivator.getInstance().getLog();

    // private SwitchButton runMockServiceSwitch;

    // private Label runMockServiceLabel;

    // private Image fGradientBackground;

    private MockServicePanel mockServicePanel;

    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        // FIXME: this had been executed way too many times
        // getSite().getWorkbenchWindow().getPartService().addPartListener(new MockServiceButtonUpdatingPartListener());

    }

    @Override
    protected void createActions() {
        super.createActions();
        markAsContentDependentAction("Format", true); //$NON-NLS-1$
    }

    @Override
    protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
        Composite composite = new Composite(parent, SWT.NONE);

        GridLayout compositeLayout = new GridLayout(1, false);
        compositeLayout.marginHeight = 0;
        compositeLayout.marginWidth = 0;
        compositeLayout.horizontalSpacing = 0;
        compositeLayout.verticalSpacing = 0;
        composite.setLayout(compositeLayout);

        mockServicePanel = new MockServicePanel(composite);
        GridData layoutData = new GridData(SWT.FILL, SWT.TOP, true, false);
        mockServicePanel.setLayoutData(layoutData);

        Composite editorComposite = new Composite(composite, SWT.NONE);
        editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
        fillLayout.marginHeight = 0;
        fillLayout.marginWidth = 0;
        fillLayout.spacing = 0;
        editorComposite.setLayout(fillLayout);

        ISourceViewer result = super.createSourceViewer(editorComposite, ruler, styles);

        return result;
    }

    @Override
    public Composite getMockServicePanel() {
        return mockServicePanel;
    }
    
    @Override
    public IEditorPart getHostEditor() {
        return this;
    }
    
    @Override
    public IFile getMockServiceResource() {
        return (IFile) getResource();
    }
    
    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if (MockServiceContributor.class.isAssignableFrom(adapter)) {
            return this;
        }
        return super.getAdapter(adapter);
    }
    

    // @Subscribe
    // public void handleMockServiceStartedEvent(MockServiceStartedEvent event) {
    // updateMockServiceButtonLabel();
    // }
    //
    // @Subscribe
    // public void handleMockServiceTerminatedEvent(MockServiceTerminatedEvent event) {
    // updateMockServiceButtonLabel(false);
    // }
    //
    // @Subscribe
    // public void handleMockServiceModelActivatedEvent(MockServiceModelActivatedEvent event) {
    // updateMockServiceButtonLabel(equal(event.getActivatedModel(), getResource()));
    // }
    //
    // @Subscribe
    // public void handleMockServiceModelDeactivatedEvent(MockServiceModelDeactivatedEvent event) {
    // updateMockServiceButtonLabel(!equal(event.getDeactivatedModel(), getResource()));
    // }

}
