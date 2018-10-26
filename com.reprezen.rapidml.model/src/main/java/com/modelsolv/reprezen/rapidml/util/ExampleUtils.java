/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.google.common.io.CharStreams;
import com.modelsolv.reprezen.rapidml.Example;
import com.modelsolv.reprezen.rapidml.ExternalExample;
import com.modelsolv.reprezen.rapidml.InlineExample;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;
import com.modelsolv.reprezen.rapidml.RapidmlFactory;
import com.modelsolv.reprezen.rapidml.ServiceDataResource;
import com.modelsolv.reprezen.rapidml.TypedMessage;
import com.modelsolv.reprezen.rapidml.DataExample;
import com.modelsolv.reprezen.rapidml.InlineDataExample;
import com.modelsolv.reprezen.rapidml.Structure;

public class ExampleUtils {
    public static EList<Example> getAllExamples(TypedMessage message) {
        if (!message.getExamples().isEmpty()) {
            return message.getExamples();
        }
        ResourceDefinition resource = message.getResourceType();
        if (resource != null) {
            EList<Example> resourceExamples = resource.getExamples();
            if (!resourceExamples.isEmpty()) {
                return resourceExamples;
            }
            if (resource instanceof ServiceDataResource) {
                Structure dataType = ((ServiceDataResource) resource).getDataType();
                List<Example> result = new ArrayList<Example>(dataType.getDataExamples().size());
                for (DataExample dataExample : dataType.getDataExamples()) {
                    result.add(toExample(dataExample));
                }
                return ECollections.asEList(result);
            }
        }
        return ECollections.emptyEList();
    }

    public static Example toExample(DataExample dataExample) {
        if (dataExample instanceof InlineDataExample) {
            InlineExample result = RapidmlFactory.eINSTANCE.createInlineExample();
            result.setBody(((InlineDataExample) dataExample).getBody());
            return result;
        }
        throw new IllegalStateException("External examples not implemented");
    }

    public static String getBody(ExternalExample example) {
        String body = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getBodyStream(example)));
            try {
                body = CharStreams.toString(reader);
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            // TODO
            // RestApiPlugin.getDefault().getLog()
            // .log(new Status(Status.ERROR, RestApiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
        } catch (Exception e) {
            // RestApiPlugin.getDefault().getLog()
            // .log(new Status(Status.ERROR, RestApiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
        }
        return body;
    }

    public static InputStream getBodyStream(ExternalExample example) throws IOException {
        URI externalExampleUri = getResolvedImportUri(example.eResource(), URI.createURI(example.getPath()));
        URIConverter uriConverter = example.eResource().getResourceSet().getURIConverter();
        return uriConverter.createInputStream(externalExampleUri);
    }

    private static URI getResolvedImportUri(Resource context, URI uri) {
        URI contextURI = context.getURI();
        if (contextURI.isHierarchical() && !contextURI.isRelative() && (uri.isRelative() && !uri.isEmpty())) {
            uri = uri.resolve(contextURI);
        }
        return uri;
    }
}
