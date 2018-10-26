/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.validation;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.SeverityConverter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.xtext.nls.Messages;
import com.modelsolv.reprezen.rapidml.xtext.validation.ElementOrderSorter;

@SuppressWarnings("restriction")
public class RepreZenValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

    @Inject
    private ElementOrderSorter orderSorter;

    private List<EClass> elementWithRandomOrder = Lists.newArrayList(RapidmlPackage.Literals.COLLECTION_RESOURCE,
            RapidmlPackage.Literals.OBJECT_RESOURCE);

    @Override
    protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
        Composite randomOrderProblems = createSection(
                Messages.RepreZenValidatorConfigurationBlock_random_order_section_title, composite, nColumns);
        fillRandomOrderSection(new ComboBoxBuilder(this, randomOrderProblems, defaultIndent, nColumns));

    }

    protected void fillRandomOrderSection(ComboBoxBuilder comboBoxBuilder) {
        for (EClass eClazz : elementWithRandomOrder) {
            comboBoxBuilder.addRandomOrderComboBox(eClazz);
        }
    }

    protected Combo addComboBox(String prefKey, String label, Composite parent, int indent) {
        return addComboBox(parent, label, prefKey, indent, getValues(), getValueLabels());
    }

    private String[] getValues() {
        return new String[] { SeverityConverter.SEVERITY_IGNORE, SeverityConverter.SEVERITY_WARNING };
    }

    private String[] getValueLabels() {
        return new String[] { Messages.RepreZenValidatorConfigurationBlock_ignore,
                Messages.RepreZenValidatorConfigurationBlock_warning };

    }

    @Override
    protected Job getBuildJob(IProject project) {
        return null;
    }

    @Override
    protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
        return null;
    }

    @Override
    protected void validateSettings(String changedKey, String oldValue, String newValue) {
        // Clients may override
    }

    protected final class ComboBoxBuilder {
        private int defaultIndent;
        private int nColumns;
        private Composite section;
        private final RepreZenValidatorConfigurationBlock confBlock;

        public ComboBoxBuilder(RepreZenValidatorConfigurationBlock xbaseConfBlock, Composite section,
                int defaultIndent, int nColumns) {
            this.section = section;
            this.confBlock = xbaseConfBlock;
            this.defaultIndent = defaultIndent;
            this.nColumns = nColumns;
        }

        public ComboBoxBuilder addRandomOrderComboBox(EClass eClass) {
            ExpandableComposite excomposite = confBlock.createStyleSection(section, eClass.getName(), nColumns);
            final Combo combo = confBlock
                    .newComboControl(
                            excomposite,
                            NLS.bind(Messages.RepreZenValidatorConfigurationBlock_random_order_issue_key_all,
                                    eClass.getName()), getValues(), getValueLabels());
            excomposite.setTextClient(combo);
            final Composite part = new Composite(excomposite, SWT.NONE);
            part.setFont(section.getFont());
            GridLayoutFactory.fillDefaults().extendedMargins(5, 0, 5, 5).spacing(5, 5).equalWidth(false)
                    .numColumns(nColumns).applyTo(part);
            excomposite.setClient(part);
            combo.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    boolean ignore = Messages.RepreZenValidatorConfigurationBlock_ignore.equals(combo.getText());
                    for (Control c : part.getChildren()) {
                        if (c instanceof Combo) {
                            ((Combo) c).select(combo.getSelectionIndex());
                            controlChanged(c);
                            ((Combo) c).setEnabled(!ignore);
                        }
                    }
                }

            });
            boolean ignore = Messages.RepreZenValidatorConfigurationBlock_ignore.equals(combo.getText());
            for (Keyword keyword : orderSorter.getChildren(eClass)) {
                Combo child = confBlock.addComboBox(NLS.bind(
                        Messages.RepreZenValidatorConfigurationBlock_random_order_issue_key, eClass.getName(),
                        keyword.getValue()), keyword.getValue(), part, defaultIndent);
                child.setEnabled(!ignore);
            }
            return this;
        }
    }

}
