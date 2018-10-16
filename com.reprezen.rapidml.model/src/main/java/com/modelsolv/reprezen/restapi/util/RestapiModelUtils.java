/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.util;

import static com.google.common.collect.Collections2.filter;
import static reprezen.org.eclipse.xtext.EcoreUtil2.getResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.modelsolv.reprezen.restapi.CollectionParameter;
import com.modelsolv.reprezen.restapi.HasStringValue;
import com.modelsolv.reprezen.restapi.ImportDeclaration;
import com.modelsolv.reprezen.restapi.MessageParameter;
import com.modelsolv.reprezen.restapi.Method;
import com.modelsolv.reprezen.restapi.NamedLinkDescriptor;
import com.modelsolv.reprezen.restapi.ObjectRealization;
import com.modelsolv.reprezen.restapi.Parameter;
import com.modelsolv.reprezen.restapi.PropertyRealization;
import com.modelsolv.reprezen.restapi.RealizationContainer;
import com.modelsolv.reprezen.restapi.ResourceAPI;
import com.modelsolv.reprezen.restapi.ResourceDefinition;
import com.modelsolv.reprezen.restapi.ServiceDataResource;
import com.modelsolv.reprezen.restapi.SourceReference;
import com.modelsolv.reprezen.restapi.URI;
import com.modelsolv.reprezen.restapi.URIParameter;
import com.modelsolv.reprezen.restapi.URISegment;
import com.modelsolv.reprezen.restapi.URISegmentWithParameter;
import com.modelsolv.reprezen.restapi.ZenModel;
import com.modelsolv.reprezen.restapi.DataModel;
import com.modelsolv.reprezen.restapi.Feature;
import com.modelsolv.reprezen.restapi.PrimitiveProperty;
import com.modelsolv.reprezen.restapi.ReferenceProperty;

/**
 * A set of queries for REST API metamodel.
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class RestapiModelUtils {

    public static Predicate<ReferenceProperty> isContainmentReferenceProperty() {
        return new Predicate<ReferenceProperty>() {
            @Override
            public boolean apply(ReferenceProperty input) {
                return input.isContainment();
            }
        };
    }

    public static ResourceDefinition getContainingResourceDefinition(SourceReference sourceReference) {
        Parameter containingParameter = sourceReference.getContainingParameter();
        if (containingParameter instanceof URIParameter) {
            return (ResourceDefinition) ((URIParameter) containingParameter).getContainingURI().eContainer();
        }
        if (containingParameter instanceof CollectionParameter) {
            return ((CollectionParameter) containingParameter).getContainingResourceDefinition();
        }
        if (containingParameter instanceof MessageParameter) {
            MessageParameter messageParemeter = (MessageParameter) containingParameter;
            return ((Method) messageParemeter.getContainingMessage().eContainer()).getContainingResourceDefinition();
        } // current metamodel doesn't support other kinds of containers
        return null;
    }

    public static NamedLinkDescriptor getDefaultLinkDescriptor(ServiceDataResource resource) {
        EList<NamedLinkDescriptor> linkDescriptors = resource.getDefinedLinkDescriptors();
        if (linkDescriptors.size() == 1) {
            return linkDescriptors.get(0);
        }
        Predicate<NamedLinkDescriptor> selectDefault = new Predicate<NamedLinkDescriptor>() {
            @Override
            public boolean apply(NamedLinkDescriptor linkDescriptor) {
                return linkDescriptor.isDefault();
            }
        };
        Collection<NamedLinkDescriptor> defaultLinkDescriptors = filter(linkDescriptors, selectDefault);
        if (defaultLinkDescriptors.size() == 1) {
            return defaultLinkDescriptors.iterator().next();
        }
        return null;
    }

    public static boolean isFeatureIncluded(RealizationContainer resource, Feature feature) {
        return isFeatureIncluded(resource.getProperties(), feature);
    }

    public static boolean isFeatureIncluded(ObjectRealization objectRealization, final Feature feature) {
        if (objectRealization.getAllIncludedProperties() == null) {
            return false;
        }
        return !Collections2.filter(objectRealization.getAllIncludedProperties(), new Predicate<PropertyRealization>() {

            @Override
            public boolean apply(PropertyRealization includedProperty) {
                return InheritanceUtils.sameOrOverrides(includedProperty.getBaseProperty(), feature);
            }
        }).isEmpty();
    }
    

    public static String getStringValue(Object object, StringBuffer result) {
        if (object instanceof HasStringValue) {
            if (object instanceof URI) {
                List<String> segments = new ArrayList<String>(((URI) object).getSegments().size());
                for (URISegment segment : ((URI) object).getSegments()) {
                    segments.add(segment.toString());
                }
                return Joiner.on("/").join(segments); //$NON-NLS-1$
            } else if (object instanceof URISegmentWithParameter) {
                return "{" + ((URISegmentWithParameter) object).getName() + "}"; //$NON-NLS-1$//$NON-NLS-2$
            } else if (object instanceof URISegment) {
                return ((URISegment) object).getName();
            } else if (object instanceof PrimitiveProperty) {
                PrimitiveProperty prop = (PrimitiveProperty) object;
                result.append(" (name: "); //$NON-NLS-1$
                result.append(prop.getName());
                result.append(", cardinality: "); //$NON-NLS-1$
                result.append(prop.getCardinality());
                result.append(", type: "); //$NON-NLS-1$
                result.append(prop.getType());
                result.append(')');
                return result.toString();
            } else {
                return null;
            }
        }
        return object.toString();
    }

    /** Trims beginning and ending double quotes from a string */
    public static String trimQuotes(String string) {
        if (string == null) {
            return null;
        }
        return string.replaceAll("^\"|\"$", ""); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * @param importDeclaration
     *            import declaration
     * @return list of namespaces that available from imported model
     */
    public static List<String> getImportedNamespaces(ImportDeclaration importDeclaration) {
        ZenModel zenModel = importDeclaration.getImportedModel();
        List<String> result = new ArrayList<>();
        if (zenModel != null) {
            String namespace = ((zenModel.getNamespace() != null) ? zenModel.getNamespace() + "." : "")//
                    + zenModel.getName();
      
            result.addAll(zenModel.getResourceAPIs().stream()//
                    .map(rapi -> namespace + "." + rapi.getName()).collect(Collectors.toList()));
            result.addAll(zenModel.getDataModels().stream()//
                    .map(dm -> namespace + "." + dm.getName()).collect(Collectors.toList()));
            Optional.ofNullable(zenModel.getSecuritySchemesLibrary())//
                    .filter(it -> !it.getSecuritySchemes().isEmpty())//
                    .ifPresent(it -> result.add(namespace + "." + it.getName()));
        }
        return Collections.unmodifiableList(result);
    }

    /**
     * @param model
     *            model
     * @return list of resource definitions that imported using import RESTfulInterfaces
     */
    static List<ResourceDefinition> getImportedResources(ZenModel model) {
        ArrayList<ResourceDefinition> result = new ArrayList<>();
        for (ImportDeclaration importDecl : model.getImports()) {
            String uri = importDecl.getImportURI();
            if (!Strings.isNullOrEmpty(uri)) {
                Resource modelResource = importDecl.eResource();
                Resource resource = getResource(modelResource, uri);
                if (resource != null && resource.getErrors().isEmpty() && !resource.getContents().isEmpty()) {
                    ZenModel zenModel = (ZenModel) resource.getContents().get(0);
                    String namespace = Strings.isNullOrEmpty(zenModel.getNamespace()) ? zenModel.getName() : zenModel
                            .getNamespace() + "." + zenModel.getName(); //$NON-NLS-1$

                    for (ResourceAPI resourceAPI : zenModel.getResourceAPIs()) {
                        String ifaceFQN = namespace + "." + resourceAPI.getName(); //$NON-NLS-1$
                        if (ifaceFQN.equals(importDecl.getImportedNamespace())) {
                            result.addAll(resourceAPI.getOwnedResourceDefinitions());
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param obj
     *            object
     * @return ZenModel from given leaf object or <code>null</code>
     */
    public static ZenModel getZenModel(EObject obj) {
        EObject parent = obj.eContainer();
        while (parent != null && !(parent instanceof ZenModel)) {
            parent = parent.eContainer();
        }
        return parent == null ? null : (ZenModel) parent;
    }

}
