/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.modelpath;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;
import com.reprezen.rapidml.xtext.modelpath.ImportResolver;
import com.reprezen.rapidml.xtext.modelpath.ModelPath;
import com.reprezen.rapidml.xtext.ui.internal.RepreZenDslActivator;
import com.reprezen.rapidml.xtext.ui.modelpath.ModelPathWidget.ModelPathListener;
import com.reprezen.rapidml.xtext.ui.preferences.GroupedFieldEditorPreferencePage;

public class ModelPathPreferencePage extends GroupedFieldEditorPreferencePage
        implements IWorkbenchPreferencePage, ModelPathListener {

    private static final String REPREZEN_NATURE = "com.reprezen.zenNature";

    public static final String PREF_ACTIVE_MODEL_PATH = "com.reprezen.rapidml.xtext.ui.modelpath.active_model_path";
    public static final String PREF_ALL_MODEL_PATHS = "com.reprezen.rapidml.xtext.ui.modelpath.all_model_paths";
    public static final String PREF_MODEL_PATH_ITEMS_FOR_ID = "com.reprezen.rapidml.xtext.ui.modelpath.model_path_items.";
    public static final String PREF_MODEL_PATH_REBUILD = "com.reprezen.rapidml.xtext.ui.modelpath.model_path_rebuild";

    private ModelPathWidget modelPathsWidget;
    private ModelPathItemsWidget modelPathItemsWidget;

    private List<ModelPath> modelPaths = new LinkedList<>();
    private List<String> deletedModelPaths = new ArrayList<>();
    private int modelPathRebuildChoice = 0; // 0 is prompt, 1 is yes, 2 is no

    public ModelPathPreferencePage() {
        super(RepreZenDslActivator.getInstance().getPreferenceStore());
        setTitle("RAPID-ML Model Path");
    }

    @Override
    protected void createContentGroups(Composite parent) {
        modelPaths = new LinkedList<>(readModelPathsFromPreferences());
        deletedModelPaths = new ArrayList<>();
        parent.setLayout(new GridLayout(1, false));

        addHeader(parent);

        FieldEditorContentGroup g = createFieldEditorContentGroup(2);
        modelPathsWidget = new ModelPathWidget();
        modelPathsWidget.addModelPathListener(this);
        g.addOtherControl(modelPathsWidget.createComposite(g.getComposite()));

        g = createFieldContentGroup();
        modelPathItemsWidget = new ModelPathItemsWidget();
        g.addOtherControl(modelPathItemsWidget.createComposite(g.getComposite(), new ArrayList<>()));

        g = createFieldEditorContentGroup(2);
        addRebuildProjectSelection(g.getComposite());

        initWidgets();
    }

    private void addRebuildProjectSelection(Composite parent) {
        Label label = new Label(parent, SWT.NONE);
        label.setText("Rebuild RAPID-ML projects on change to model path:");

        Combo combo = new Combo(parent, SWT.READ_ONLY);
        combo.setItems(new String[] { "Prompt", "Yes", "No" });
        // Update the variable from value stored in preferences (by default, the stored value is 0)
        combo.select(modelPathRebuildChoice = getPreferenceStore().getInt(PREF_MODEL_PATH_REBUILD));

        combo.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                modelPathRebuildChoice = combo.getSelectionIndex();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    private void initWidgets() {
        modelPathsWidget.setModelPaths(getModelPathNames());
        String activeModelPath = readActiveModelPathNameFromPrefs();
        if (!Strings.isEmpty(activeModelPath)) {
            modelPathsWidget.select(activeModelPath);
            modelPathItemsWidget.setElements(findOrCreateModelPath(activeModelPath).getItems());
        } else {
            modelPathItemsWidget.setElements(Collections.emptyList());
        }
        modelPathItemsWidget.setEnabled(!Strings.isEmpty(activeModelPath));
    }

    private String[] getModelPathNames() {
        String[] mpn = modelPaths.stream().map(it -> it.getName()).toArray(String[]::new);
        return mpn;
    }

    private void addHeader(Composite parent) {
        Composite descriptionControl = new Composite(parent, SWT.NONE);
        descriptionControl.setLayout(new GridLayout(1, false));
        Label description = new Label(descriptionControl, SWT.NONE);
        description.setText("RAPID-ML will resolve imports by looking in each matching model path item.");
        Control link = createLink(descriptionControl, "<a href=\"http://www.reprezen.com\">Learn More</a>");
        link.setLayoutData(new GridData(GridData.END, GridData.CENTER, true, false));
    }

    @Override
    public void onModelPathSelect(String newModelPath, String oldModelPathName) {
        // update old ModelPath with the values from modelPathItemsWidget
        if (oldModelPathName != null) {
            ModelPath oldModelPath = findOrCreateModelPath(oldModelPathName);
            oldModelPath.getItems().clear();
            oldModelPath.getItems().addAll(modelPathItemsWidget.getElements());
        }
        setActiveModelPath(newModelPath);
    }

    @Override
    public void onModelPathNameChanged(String newModelPathName, String oldModelPathName) {
        if (newModelPathName == null) { // delete
            modelPaths.remove(findOrCreateModelPath(oldModelPathName));
            deletedModelPaths.add(oldModelPathName);
        } else if (oldModelPathName == null) {// create
            findOrCreateModelPath(Strings.emptyIfNull(newModelPathName));
        } else {// update
            findOrCreateModelPath(Strings.emptyIfNull(oldModelPathName)).setName(newModelPathName);
        }
        // update modelPathWidget
        modelPathsWidget.setModelPaths(getModelPathNames());
        String elementToSelect = newModelPathName;
        if (newModelPathName == null && !modelPaths.isEmpty()) {
            elementToSelect = modelPaths.get(0).getName();
        }
        modelPathsWidget.select(elementToSelect);
    }

    private void setActiveModelPath(String activeModelPath) {
        if (activeModelPath != null) {
            modelPathItemsWidget.setElements(findOrCreateModelPath(activeModelPath).getItems());
        } else {
            modelPathItemsWidget.setElements(Collections.emptyList());
        }
        modelPathItemsWidget.setEnabled(activeModelPath != null);
    }

    private ModelPath findOrCreateModelPath(String modelPathName) {
        if (modelPathName == null) {
            return createAndRegisterEmptyModelPath(modelPathName);
        }

        Optional<ModelPath> result = modelPaths.stream().filter(mp -> modelPathName.equals(mp.getName())).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            return createAndRegisterEmptyModelPath(modelPathName);
        }
    }

    private ModelPath createAndRegisterEmptyModelPath(String modelPathName) {
        ModelPath result = new ModelPath(new ArrayList<>());
        result.setName(modelPathName);
        modelPaths.add(result);
        return result;
    }

    @Override
    public void init(IWorkbench workbench) {
    }

    private List<ModelPath> readModelPathsFromPreferences() {
        String csModelPaths = getPreferenceStore().getString(PREF_ALL_MODEL_PATHS);
        if (Strings.isEmpty(csModelPaths)) {
            return new ArrayList<>();
        }
        return Arrays.stream(csModelPaths.split(","))//
                .map(modelPathName -> readModelPathFromPreferences(modelPathName))//
                .collect(Collectors.toList());
    }

    private ModelPath readModelPathFromPreferences(String modelPathName) {
        String prefValue = getPreferenceStore().getString(getActiveModelPathPrefName(modelPathName));
        // default preferences value is an empty string, not null
        ModelPath modelPath = prefValue.isEmpty() ? new ModelPath(new ArrayList<>()) : tryParseModelPath(prefValue);
        modelPath.setName(modelPathName);
        return modelPath;
    }

    private ModelPath tryParseModelPath(String prefValue) {
        try {
            return new ModelPath(prefValue);
        } catch (IllegalArgumentException e) {
            setErrorMessage("Error while reading ModelPath from preferences: " + e.getMessage());
        }
        return new ModelPath(new ArrayList<>());
    }

    private String getActiveModelPathPrefName(String activeModelPath) {
        return PREF_MODEL_PATH_ITEMS_FOR_ID + activeModelPath;
    }

    private String readActiveModelPathNameFromPrefs() {
        return getPreferenceStore().getString(PREF_ACTIVE_MODEL_PATH);
    }

    @Override
    public boolean performOk() {
        String activeModelPath = modelPathsWidget.getActiveModelPath();
        if (activeModelPath != null) {
            ModelPath modelPath = findOrCreateModelPath(activeModelPath);
            modelPath.getItems().clear();
            modelPath.getItems().addAll(modelPathItemsWidget.getElements());
            saveSystemProperty(activeModelPath);
        }
        savePreferences(activeModelPath);
        validateRapidModels();
        return super.performOk();
    }

    @Override
    protected void performDefaults() {
        savePreferences(null);
        modelPaths = new LinkedList<>();
        deletedModelPaths = new LinkedList<>();
        initWidgets();
        super.performDefaults();
    }

    private void savePreferences(String activeModelPath) {
        getPreferenceStore().setValue(PREF_ACTIVE_MODEL_PATH, Strings.emptyIfNull(activeModelPath));
        getPreferenceStore().setValue(PREF_ALL_MODEL_PATHS, Joiner.on(",").join(getModelPathNames()));
        for (String modelPath : deletedModelPaths) {
            getPreferenceStore().setToDefault(getActiveModelPathPrefName(modelPath));
        }
        for (ModelPath modelPath : modelPaths) {
            getPreferenceStore().setValue(getActiveModelPathPrefName(modelPath.getName()), modelPath.toString());
        }
        getPreferenceStore().setValue(PREF_MODEL_PATH_REBUILD, modelPathRebuildChoice);
    }

    private void saveSystemProperty(String activeModelPathName) {
        ModelPath activeModelPath = findOrCreateModelPath(activeModelPathName);
        System.setProperty(ImportResolver.SYS_VARIABLE_MODEL_PATH, activeModelPath.toString());
    }

    private void validateRapidModels() {
        // User does not want to rebuild projects
        if (modelPathRebuildChoice == 2)
            return;

        // By default we will launch the rebuild unless the
        // user wants to be prompted and replies no.
        boolean shouldRebuild = true;

        if (modelPathRebuildChoice == 0) {
            MessageDialog dialog = new MessageDialog(getShell(), "Build Project", null,
                    "API Studio needs to rebuild projects containing RAPID-ML models, in order to process and validate the updated model path. Do you want to rebuild now?",
                    MessageDialog.QUESTION, new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL,
                            IDialogConstants.CANCEL_LABEL },
                    2);

            // 0 corresponds to the first button that is the OK button.
            shouldRebuild = dialog.open() == 0;
        }

        if (shouldRebuild) {
            try {
                ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(getShell());
                progressDialog.run(true, true, monitor -> {
                    IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
                    SubMonitor subMonitor = SubMonitor.convert(monitor, projects.length);
                    subMonitor.setTaskName("Building RepreZen Projects...");

                    Arrays.stream(projects) //
                            .filter(Objects::nonNull) //
                            .filter(project -> project.isAccessible()) //
                            .filter(project -> {
                                try {
                                    return project.getNature(REPREZEN_NATURE) != null;
                                } catch (CoreException e) {
                                    return false;
                                }
                            }).forEach(project -> {
                                try {
                                    if (monitor.isCanceled()) {
                                        throw new OperationCanceledException();
                                    }

                                    subMonitor.setTaskName("Building project " + project.getName());
                                    SubMonitor m = subMonitor.newChild(1);
                                    project.build(IncrementalProjectBuilder.CLEAN_BUILD, m);
                                    m.worked(1);
                                } catch (CoreException e) {
                                	RepreZenDslActivator.getInstance().getLog()
                                            .log(new Status(Status.ERROR,
                                            		RepreZenDslActivator.COM_MODELSOLV_REPREZEN_RESTAPI_XTEXT_RAPIDML,
                                                    e.getLocalizedMessage(), e));
                                }
                            });
                });
            } catch (InvocationTargetException | InterruptedException e) {
                RepreZenDslActivator.getInstance().getLog().log(new Status(Status.ERROR,
                		RepreZenDslActivator.COM_MODELSOLV_REPREZEN_RESTAPI_XTEXT_RAPIDML, e.getLocalizedMessage(), e));
            }
        }
    }

    private Control createLink(Composite parent, String text) {
        Link link = new Link(parent, SWT.NONE);
        link.setText(com.google.common.base.Strings.nullToEmpty(text));
        link.addSelectionListener(linkListener);
        return link;
    }

    private static SelectionListener linkListener = new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            try {
                PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(e.text));
            } catch (PartInitException | MalformedURLException e1) {
            }
        }
    };
}
