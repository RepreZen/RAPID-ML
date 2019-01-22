/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.scoping;

import static com.reprezen.rapidml.xtext.RestApiXtextPlugin.ZEN_CONTENT_TYPE;
import static com.reprezen.rapidml.xtext.modelpath.DebugModelPath.debug;
import static com.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option.DEFAULT;
import static com.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option.RESOLUTION;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.scoping.impl.LoadOnDemandResourceDescriptions;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.reprezen.rapidml.ImportDeclaration;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.xtext.modelpath.ImportResolver;
import com.reprezen.rapidml.xtext.modelpath.ModelPath;
import com.reprezen.rapidml.xtext.nls.Messages;

/**
 * @author Konstantin Zaitsev
 * @date Nov 18, 2014
 */
public class RepreZenImportUriGlobalScopeProvider extends AbstractGlobalScopeProvider {

    @Inject
    private ImportUriResolver importResolver;

    @Inject
    private Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions;

    @Inject
    private IResourceScopeCache cache;

    @Inject
    private IResourceServiceProvider.Registry serviceProviderRegistry;

    private ModelPath getModelPath() {
        return ImportResolver.getActiveModelPath();
    }

    public ImportUriResolver getImportUriResolver() {
        return importResolver;
    }

    public void setImportResolver(ImportUriResolver importResolver) {
        this.importResolver = importResolver;
    }

    public void setCache(IResourceScopeCache cache) {
        this.cache = cache;
    }

    public IResourceDescriptions getResourceDescriptions(Resource resource, Collection<URI> importUris) {
        IResourceDescriptions result = getResourceDescriptions(resource);
        LoadOnDemandResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions.get();
        demandResourceDescriptions.initialize(result, importUris, resource);
        return demandResourceDescriptions;
    }

    @Override
    protected IScope getScope(Resource resource, boolean ignoreCase, EClass type,
            Predicate<IEObjectDescription> filter) {
        final LinkedHashSet<URI> uniqueImportURIs = getImportedUris(resource);
        IResourceDescriptions descriptions = getResourceDescriptions(resource, uniqueImportURIs);
        List<URI> urisAsList = Lists.newArrayList(uniqueImportURIs);
        Collections.reverse(urisAsList);
        IScope scope = IScope.NULLSCOPE;
        for (URI uri : urisAsList) {
            scope = createLazyResourceScope(resource, scope, uri, descriptions, type, filter, ignoreCase);
        }
        return scope;
    }

    protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
        return cache.get(ImportUriGlobalScopeProvider.class.getName(), resource, new Provider<LinkedHashSet<URI>>() {
            @Override
            public LinkedHashSet<URI> get() {
                TreeIterator<EObject> iterator = resource.getAllContents();
                final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(10);
                while (iterator.hasNext()) {
                    EObject object = iterator.next();
                    if (object instanceof ImportDeclaration) {
                        ImportDeclaration importDeclaration = (ImportDeclaration) object;
                        processImportDeclaration(importDeclaration, resource, uniqueImportURIs);
                    }
                }
                return uniqueImportURIs;
            }
        });
    }

    private void processImportDeclaration(ImportDeclaration importDeclaration, final Resource resource,
            HashSet<URI> uniqueImportURIs) {
        String importUriString = importDeclaration.getImportURI();
        if (Strings.isEmpty(importUriString)) {
            return;
        }

            URI containerUri = hasRelativeUri(resource) ? null : resource.getURI();
            String fqModelName = importDeclaration.getImportedNamespace();
            ModelPath modelPath = getModelPath();
            ImportResolver importResolver = new ImportResolver(modelPath, containerUri, fqModelName, importUriString);
            // TODO This should silently ignore failing URL proposals and only add an error if all of them fail
            for (URI nextResolvedUri : importResolver.resolve()) {
                debug(RESOLUTION, ":Proposed URI: " + nextResolvedUri.toString());
                URI importUri = URI.createURI(nextResolvedUri.toString());
                Resource importedResource = getResource(resource, importUri);

                if (importedResource instanceof XtextResource) {
                    XtextResource xResource = (XtextResource) importedResource;
                    if (xResource.getErrors().isEmpty()) {
                        debug(RESOLUTION, DEFAULT, ":Import resolved to " + nextResolvedUri.toString(), "Model Path=",
                                modelPath, "FQ Model Name=", fqModelName, "Container=", containerUri, "Import URI=",
                                importUriString);
                        importDeclaration.setImportedModel((ZenModel) xResource.getContents().get(0));
                        uniqueImportURIs.add(importUri);
                    } else {
                        String msg = NLS.bind(Messages.RepreZenImportUriGlobalScopeProvider_importModelSyntaxError,
                                importedResource.getURI());
                        debug(RESOLUTION, ":Failed resolution for URI " + nextResolvedUri.toString(), "Reason=", msg);
                        addError(resource, importDeclaration, msg);
                    }
                } else {
                    String msg = NLS.bind(Messages.RepreZenImportUriGlobalScopeProvider_importIncorrectFormat,
                            importUriString);
                    debug(RESOLUTION, ":Failed resolution fro URI " + nextResolvedUri.toString(), "Reason=", msg);
                    addError(resource, importDeclaration, msg);
                }
            }
        
    }

    private boolean hasRelativeUri(Resource resource) {
        return resource.getURI() != null && resource.getURI().isRelative();
    }

    private Resource getResource(Resource context, URI newURI) {
        try {
            return context.getResourceSet().getResource(newURI, true);
        } catch (RuntimeException e) { // thrown by org.eclipse.emf.ecore.resource.ResourceSet#getResource(URI, boolean)
            // log.trace("Cannot load resource: " + newURI, e);
        }
        return null;
    }

    protected IScope createLazyResourceScope(Resource resource, IScope parent, final URI uri,
            final IResourceDescriptions descriptions, EClass type, final Predicate<IEObjectDescription> filter,
            boolean ignoreCase) {

        IResourceDescription description = null;
        try {
            description = descriptions.getResourceDescription(uri);
        } catch (IllegalStateException ex) {
            Resource res = EcoreUtil2.getResource(resource, uri.toString());
            if (res != null) {
                // fallback for ZEN resource description in case of shorten url
                IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(uri,
                        ZEN_CONTENT_TYPE);
                if (serviceProvider != null) {
                    Manager descriptionManager = serviceProvider.getResourceDescriptionManager();
                    if (descriptionManager != null) {
                        description = descriptionManager.getResourceDescription(res);
                    }
                }
            }
            if (description == null) {
                throw ex;
            }
        }
        return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
    }

    public void setLoadOnDemandDescriptions(Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions) {
        this.loadOnDemandDescriptions = loadOnDemandDescriptions;
    }

    public Provider<LoadOnDemandResourceDescriptions> getLoadOnDemandDescriptions() {
        return loadOnDemandDescriptions;
    }

    /**
     * Added error indication to import declaration URI
     * 
     * @param resource
     *            zen model
     * @param importDeclaration
     *            import declaration statement
     * @param message
     *            error message
     */
    private void addError(Resource resource, EObject importDeclaration, String message) {
        resource.getErrors().add(new EObjectDiagnosticImpl(Severity.ERROR, "", //$NON-NLS-1$
                message, importDeclaration, RapidmlPackage.Literals.IMPORT_DECLARATION__IMPORT_URI, -1, null));
    }
}
