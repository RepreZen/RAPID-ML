/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.preferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;

/**
 * This class implements something between a standard {@link PreferencePage} and a {@link FieldEditorPreferencePage},
 * permitting use of {@link FieldEditor}s but with much greater freedom to make use of arbitrary grid layouts.
 * <p>
 * {@link FieldEditorPreferencePage} comes with an extremely limiting restriction that all the {@link FieldEditor}s on
 * the page must be governed by the same {@link GridLayout}. This implies that they must all be immediate children of
 * the same {@link Composite}. The reason for this restriction is that the various {@link FieldEditor} types internally
 * contribute different number of {@link Control}s to their containing {@link Composite}. The
 * {@link FieldEditorPreferencePage} class performs magic after all the field editors have been added, computing the
 * minimum number of columns required by any field editor and setting the containing composite's layout accordingly. It
 * then informs each field editor of the new number of columns, so they can adjust accordingly (e.g. by adjusting span
 * settings in individual controls). This process is liable to fail if the field editors are not each a direct child of
 * the containing composite, leading to bizarre layout results.
 * <p>
 * This class creates its content from a series of {@link FieldEditorContentGroup}s, each of which has its own composite
 * with a grid layout. Field editors and other controls can be added to a group. Once all the groups have been created
 * by the subclass, similar magic as described above is performed on each group individually. It is still crucial that
 * all field editors contained in a group appear as direct children of the group's composite, but now there can be
 * multiple groups spread through a much more flexible control structure.
 * <p>
 * Besides adjusting each of the field editors, other non-field-editor controls that were added to the group are also
 * adjusted, by setting their horizontal span values. When an "other" control is added to a group, it is accompanied
 * with a "span adjustment" value. That value is subtracted from the number of columns set for the group's composite,
 * and the control's horizontal span is set to the result. This way, any "row" of controls appearing in the composite
 * can be created in such a way that it occupies a complete grid row when the final column setting is applied. To
 * accommodate this requirement, each {@link FieldEditorContentGroup} can be created with a designated minimum column
 * count. This should be set to the maximum number of columns required by any grid row not occupied by a field editor. A
 * single control in any such row must be established as an "other" control in the group, so that the row will expand as
 * needed.
 * <p>
 * An ugly aspect of this class is that it must use reflection to invoke the
 * {@link FieldEditor#adjustForNumColumns(int)} methods, which is what informs the individual field editors of the final
 * column setting. This is a protected method in {@link FieldEditor}, and it is visible to
 * {@link FieldEditorPreferencePage} by dint of their belonging to the same package. Since this class is not in that
 * package, we can only invoke that method through reflection, after forcing it to be accessible. This class therefore
 * cannot be used in scenarios where a {@link SecurityManager} would prohibit this accessibility change. In such a
 * scenario, the {@link GroupedFieldEditorPreferencePage} will throw an {@link IllegalStateException} during
 * initialization.
 * 
 * @author Andy Lowry
 *
 */
public abstract class GroupedFieldEditorPreferencePage extends PreferencePage implements IPropertyChangeListener {

    private Composite contents;
    private IPreferenceStore preferenceStore;

    public GroupedFieldEditorPreferencePage(IPreferenceStore preferenceStore) {
        this.preferenceStore = preferenceStore;
        setPreferenceStore(preferenceStore);
    }

    @Override
    protected final Control createContents(Composite parent) {
        contents = new Composite(parent, SWT.NONE);
        GridLayoutFactory.swtDefaults().applyTo(contents);
        GridDataFactory.swtDefaults().applyTo(contents);
        contents.setFont(parent.getFont());
        createContentGroups(contents);
        adjustGroups();
        checkState();
        return contents;
    }

    abstract protected void createContentGroups(Composite parent);

    private void adjustGroups() {
        for (FieldEditorContentGroup group : contentGroups) {
            group.adjustGroup();
        }
    }

    private List<FieldEditorContentGroup> contentGroups = Lists.newArrayList();

    protected FieldEditorContentGroup createFieldContentGroup() {
        return createFieldEditorContentGroup(contents, 1);
    }

    protected FieldEditorContentGroup createFieldEditorContentGroup(Composite parent) {
        return createFieldEditorContentGroup(parent, 1);
    }

    protected FieldEditorContentGroup createFieldEditorContentGroup(int minColumns) {
        return createFieldEditorContentGroup(contents, minColumns);
    }

    protected FieldEditorContentGroup createFieldEditorContentGroup(Composite parent, int minColumns) {
        FieldEditorContentGroup group = new FieldEditorContentGroup(parent, minColumns);
        contentGroups.add(group);
        return group;
    }

    @Override
    protected void performDefaults() {
        for (FieldEditorContentGroup group : contentGroups) {
            group.performDefaults();
        }
        checkState();
        super.performDefaults();
    }

    @Override
    public boolean performOk() {
        for (FieldEditorContentGroup group : contentGroups) {
            if (!group.performOk()) {
                return false;
            }
            ;
        }
        return super.performOk();
    }

    private static Method fieldEditorAdjuster;
    static {
        try {
            fieldEditorAdjuster = FieldEditor.class.getDeclaredMethod("adjustForNumColumns", int.class);
            fieldEditorAdjuster.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new IllegalStateException("Failed to make FieldEditor#adjustForNumColumns(int) accessible", e);
        }
    }

    @Override
    public void dispose() {
        for (FieldEditorContentGroup group : contentGroups) {
            group.dispose();
        }
    }

    public class FieldEditorContentGroup {
        private Composite composite;
        private List<FieldEditor> fieldEditors = Lists.newArrayList();
        // integer = span-adjustment for this control
        private List<Pair<Control, Integer>> otherControls = Lists.newArrayList();

        private int minColumns;

        public FieldEditorContentGroup(Composite parent, int minColumns) {
            this.composite = new Composite(parent, SWT.NONE);
            GridDataFactory.swtDefaults().applyTo(composite);
            GridLayoutFactory.swtDefaults().applyTo(composite);
            composite.setFont(parent.getFont());
            this.minColumns = minColumns;
        }

        public Composite getComposite() {
            return composite;
        }

        public void addFieldEditor(FieldEditor editor) {
            fieldEditors.add(editor);
            editor.setPage(GroupedFieldEditorPreferencePage.this);
            editor.setPreferenceStore(preferenceStore);
            editor.setPropertyChangeListener(GroupedFieldEditorPreferencePage.this);
            editor.load();
        }

        public void addOtherControl(Control control) {
            addOtherControl(control, 0);
        }

        public void addOtherControl(Control control, int spanAdjustment) {
            otherControls.add(Tuples.create(control, spanAdjustment));
        }

        public void performDefaults() {
            for (FieldEditor editor : fieldEditors) {
                editor.loadDefault();
            }
        }

        public boolean performOk() {
            for (FieldEditor editor : fieldEditors) {
                if (editor.isValid()) {
                    editor.store();
                } else {
                    return false;
                }
            }
            return true;
        }

        public void adjustGroup() {
            int ncol = getColRequirement();
            ((GridLayout) composite.getLayout()).numColumns = ncol;
            fixFieldEditors(ncol);
            fixOtherControls(ncol);
        }

        private int getColRequirement() {
            int minCols = this.minColumns;
            for (FieldEditor editor : fieldEditors) {
                minCols = Math.max(minCols, editor.getNumberOfControls());
            }
            return minCols;
        }

        private void fixFieldEditors(int ncol) {
            for (FieldEditor editor : fieldEditors) {
                try {
                    fieldEditorAdjuster.invoke(editor, ncol);
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    // should not be possible given that fieldEditorAdjuster was successfully created during
                    // initialization of GroupedFieldEditorPage class
                } catch (InvocationTargetException e) {
                    // the FieldEditor threw an exception in its #adjustForNumColumns implementation
                    throw new RuntimeException(e);
                }
            }
        }

        private void fixOtherControls(int ncol) {
            for (Pair<Control, Integer> pair : otherControls) {
                ((GridData) pair.getFirst().getLayoutData()).horizontalSpan = ncol - pair.getSecond();
            }
        }

        public FieldEditor getFirstInvalidFieldEditor() {
            for (FieldEditor editor : fieldEditors) {
                if (!editor.isValid()) {
                    return editor;
                }
            }
            return null;
        }

        public void dispose() {
            for (FieldEditor editor : fieldEditors) {
                editor.dispose();
            }
        }
    }

    // Following code is adapted from FieldEditorsPreferencePage

    /**
     * The first invalid field editor, or <code>null</code> if all field editors are valid.
     */
    private FieldEditor invalidFieldEditor = null;

    /**
     * Recomputes the page's error state by calling <code>isValid</code> for every field editor.
     */
    protected void checkState() {
        for (FieldEditorContentGroup group : contentGroups) {
            FieldEditor invalid = group.getFirstInvalidFieldEditor();
            if (invalid != null) {
                invalid.isValid();
                invalidFieldEditor = invalid;
                setValid(false);
                return;
            }
        }
        // got through all groups with no bad fields
        invalidFieldEditor = null;
        setValid(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(FieldEditor.IS_VALID)) {
            if ((Boolean) event.getNewValue()) {
                // this field became valid - check others
                checkState();
            } else {
                // this field became invalid
                invalidFieldEditor = (FieldEditor) event.getSource();
                setValid(false);
            }
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible && invalidFieldEditor != null) {
            invalidFieldEditor.setFocus();
        }
    }
}