/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.scoping;

import static java.util.Collections.singletonList;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.reprezen.rapidml.DataModel;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.ImportDeclaration;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.SecuritySchemeLibrary;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.util.RapidmlModelUtils;

public class ImportedNamespaceScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

    @Inject
    private IQualifiedNameConverter qualifiedNameConverter;

    @Override
    protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
        // import XSD Primitive Types package
        return singletonList(new ImportNormalizer(QualifiedName.create("PrimitiveTypes"), true, ignoreCase)); //$NON-NLS-1$
    }

    @Override
    protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, boolean ignoreCase) {
        List<ImportNormalizer> importedNamespaceResolvers = Lists.newArrayList();
        EList<EObject> eContents = context.eContents();
        for (EObject child : eContents) {
            String value = getImportedNamespace(child);
            ImportNormalizer resolver = null;
            if (!Strings.isEmpty(value)) {
                if (child instanceof ImportDeclaration) {
                    ImportDeclaration importDecl = (ImportDeclaration) child;
                    QualifiedName qname = qualifiedNameConverter.toQualifiedName(importDecl.getImportedNamespace());
                    resolver = new RepreZenImportNormalizer(importDecl.getAlias(), qname);
                } else {
                    resolver = createImportedNamespaceResolver(value, ignoreCase);
                }

            }
            if (resolver != null) {
                importedNamespaceResolvers.add(resolver);
            }
        }
        return importedNamespaceResolvers;
    }

    @Override
    protected IScope getLocalElementsScope(IScope parent, final EObject context, final EReference reference) {
        IScope local = super.getLocalElementsScope(parent, context, reference);
        Optional<QualifiedName> localElementsQN = getLocalElementsQualifiedName(context, reference);
        if (localElementsQN.isPresent()) {
            QualifiedName importedNamespace = localElementsQN.get();
            ZenModel model = context instanceof ZenModel ? (ZenModel) context : RapidmlModelUtils.getZenModel(context);
            if (!Strings.isEmpty(model.getNamespace())) {
                importedNamespace = qualifiedNameConverter.toQualifiedName(model.getNamespace())
                        .append(importedNamespace);
            }
            List<ImportNormalizer> namespaceResolvers = singletonList(
                    new ImportNormalizer(importedNamespace, true, isIgnoreCase(reference)));
            ImportScope importScope = new ImportScope(namespaceResolvers, local, null, reference.getEReferenceType(),
                    isIgnoreCase(reference));
            return importScope;
        }
        return local;
    }

    protected Optional<QualifiedName> getLocalElementsQualifiedName(final EObject context, final EReference reference) {
        // ZEN-445 Xtext editor: do not show the entire qualified name for
        // references to data types
        if (reference.equals(RapidmlPackage.Literals.REALIZATION_CONTAINER__DATA_TYPE)
                && ((context instanceof ZenModel) || (context instanceof Method))) {
            ZenModel model = context instanceof ZenModel ? (ZenModel) context : RapidmlModelUtils.getZenModel(context);
            // only use short names if there is a single data model in the ZEN
            // model
            if (model.getDataModels().size() == 1) {
                DataModel firstInterfaceDataModel = model.getDataModels().get(0);
                // ZEN-466 'Segment cannot be null' error when editing
                // Stripe.zen
                // when we edit a model and the model is in incomplete state the
                // values following the edited
                // element,
                // including the interface data model are not initialized.
                if (firstInterfaceDataModel.getName() != null && model.getName() != null) {
                    QualifiedName importedNamespace = QualifiedName.create(model.getName(),
                            firstInterfaceDataModel.getName());
                    return Optional.of(importedNamespace);
                }
            }
        }
        if (reference.equals(RapidmlPackage.Literals.AUTHENTICATION_METHOD__SCHEME)
                && (context instanceof HasSecurityValue)) {
            ZenModel model = context instanceof ZenModel ? (ZenModel) context : RapidmlModelUtils.getZenModel(context);
            SecuritySchemeLibrary securitySchemeLibrary = model.getSecuritySchemesLibrary();
            if (securitySchemeLibrary != null && securitySchemeLibrary.getName() != null && model.getName() != null) {
                QualifiedName importedNamespace = QualifiedName.create(model.getName(),
                        securitySchemeLibrary.getName());
                return Optional.of(importedNamespace);
            }
        }
        return Optional.absent();
    }
}