package com.reprezen.rapidml.util;

import static com.google.common.collect.Iterables.getOnlyElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.reprezen.rapidml.CollectionResource;
import com.reprezen.rapidml.ObjectResource;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.Structure;

/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc. All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of
 * ModelSolv, Inc. See the file license.html in the root directory of this
 * project for further information.
 *******************************************************************************/
public class ResourceFinder {

	private final Map<Structure, List<ServiceDataResource>> resourcesMap = new HashMap<>();

	public ResourceFinder(ResourceAPI resourceAPI) {
		if (resourceAPI == null) {
			return;
		}
		Iterable<ResourceDefinition> allDefinitions = Iterables.concat(
				RapidmlModelUtils.getImportedResources(RapidmlModelUtils.getZenModel(resourceAPI)),
				resourceAPI.getOwnedResourceDefinitions());
		Iterable<ServiceDataResource> allServiceDataResources = Iterables.filter(allDefinitions,
				ServiceDataResource.class);
		for (ServiceDataResource serviceDataResource : allServiceDataResources) {
			Structure datatype = serviceDataResource.getDataType();
			List<ServiceDataResource> resources = resourcesMap.get(datatype);
			if (resources == null) {
				resources = new ArrayList<ServiceDataResource>();
				resourcesMap.put(datatype, resources);
			}
			resources.add(serviceDataResource);
		}
	}

	/*
	 * ZEN-3978 if a multi-valued reference does not have a corresponding collection
	 * resource, try to represent it as an array of hyperlinks to the corresponding
	 * object resource
	 */
	public ServiceDataResource tryFindCollectionThenObjectResource(final Structure complexType) {
		ServiceDataResource newTargetResource = findResource(complexType, false);
		if (newTargetResource == null) {
			newTargetResource = findResource(complexType, true);
		}
		return newTargetResource;
	}

	/**
	 * @deprecated Use a RealizationProtocol during model normalization instead
	 * @return
	 */
	public ServiceDataResource findResource(final Structure complexType, final boolean objectNotCollection) {

		Predicate<ServiceDataResource> cardinalityMatches = new Predicate<ServiceDataResource>() {
			@Override
			public boolean apply(ServiceDataResource resource) {
				if (objectNotCollection) {
					return resource instanceof ObjectResource;
				}
				return resource instanceof CollectionResource;
			}
		};
		List<ServiceDataResource> resources = resourcesMap.get(complexType);
		if (resources == null) {
			return null;
		}
		Iterable<ServiceDataResource> definitionsForType = Iterables.filter(resources, cardinalityMatches);
		if (Iterables.size(definitionsForType) == 1) {
			return getOnlyElement(definitionsForType);
		}
		Predicate<ServiceDataResource> isDefault = new Predicate<ServiceDataResource>() {
			@Override
			public boolean apply(ServiceDataResource resource) {
				return resource.isDefault();
			}
		};
		Iterable<ServiceDataResource> defaultDefinitions = Iterables.filter(definitionsForType, isDefault);
		if (Iterables.size(defaultDefinitions) == 1) {
			return getOnlyElement(defaultDefinitions);
		}
		return null;
	}

}
