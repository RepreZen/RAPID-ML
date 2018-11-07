/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.xtext.RapidMLRuntimeModule;

/**
 * Loads the RESTApi model that are in Xtext DSL format.
 * 
 * REVIEW: We should be working with streams, always, not with files.
 * 
 * @author jimleroyer
 * @since 2013/04/26
 */
public class DslRestModelLoader extends RestModelLoader {

    /** Cache for platform models (PrimitiveTypes.zen, etc) for performance purpose. */
    private static final LoadingCache<URI, ZenModel> MODELS_CACHE = CacheBuilder.newBuilder()
            .build(new CacheLoader<URI, ZenModel>() {
                @Override
                public ZenModel load(URI key) throws Exception {
                    return loadInternal(key);
                }
            });

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelPath
     *            Location of the RESTApi metamodel.
     * @return {@link com.reprezen.rapidml.ZenModel}
     */
    @Override
    public ZenModel load(URI modelPath) {
        if (modelPath.isPlatformPlugin()) {
            ZenModel zenModel = MODELS_CACHE.getUnchecked(modelPath);
            // need copy because implicit generator modify this cached model
            if (zenModel != null) {
                ResourceSet newResourceSet = EcoreUtil2.clone(new RepreZenXtextResourceSet(),
                        EcoreUtil2.getResourceSet(zenModel));
                Resource newResource = newResourceSet.getResource(zenModel.eResource().getURI(), true);
                return (ZenModel) newResource.getContents().get(0);
            }
        }
        return loadInternal(modelPath);
    }

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelLocation
     *            Location of the RESTApi metamodel.
     * @return {@link com.reprezen.rapidml.ZenModel}
     */
    @Override
    public ZenModel load(String modelLocation) {
        return load(URI.createFileURI(modelLocation));
    }

    private static ZenModel loadInternal(URI modelPath) {
        Preconditions.checkArgument(modelPath != null, "The model path should not be null"); //$NON-NLS-1$
        validateFile(modelPath);

        // TODO: Remove the next commented code line once reviewed and proven stable:
        // The following line was replaced with the following as the xtext auto builder was throwing an exception with
        // an invalid object set type (i.e.
        // java.lang.IllegalStateException: Passed org.eclipse.xtext.builder.clustering.CurrentDescriptions not of type
        // org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions).
        // The XtextDslStandaloneSetup should only be invoked as a standalone, i.e. outside of an Eclipse context,
        // hence the Guice injector is a better choice within an Eclipse-aware OSGi container such as Equinox.
        // (see: https://bugs.eclipse.org/bugs/show_bug.cgi?format=multiple&id=326024)

        // Injector injector = new XtextDslStandaloneSetup().createInjectorAndDoEMFRegistration();

        Injector injector = Guice.createInjector(new RapidMLRuntimeModule());
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(modelPath, true);
        ZenModel model = (ZenModel) resource.getContents().get(0);
        return model;
    }
}
