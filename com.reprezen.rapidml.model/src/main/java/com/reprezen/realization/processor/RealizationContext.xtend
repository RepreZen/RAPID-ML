/*******************************************************************************
 * Copyright � 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.realization.processor

import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.TypedRequest
import com.reprezen.rapidml.TypedResponse
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.Structure

public abstract class RealizationContext {

	def abstract Structure getStructure()

	def abstract ResourceAPI getApi()

	def abstract Object getSubject()

	def abstract ServiceDataResource getResource()

	def static of(ServiceDataResource resource) {
		return new ResourceRealizationContext(resource)
	}

	def static of(TypedMessage message) {
		return if (message.resourceType !== null)
			new ResourceRealizationContext(message.resourceType as ServiceDataResource)
		else
			new MessageRealizationContext(message)
	}

	def static of(ReferenceProperty refProp, ServiceDataResource rootResource) {
		return new ReferencePropertyRealizationContext(refProp, rootResource)
	}

	public static class ResourceRealizationContext extends RealizationContext {

		val private ServiceDataResource resource

		private new(ServiceDataResource resource) {
			this.resource = resource
		}

		override getStructure() {
			return resource.actualType
		}

		override getApi() {
			return resource.eContainer as ResourceAPI
		}

		override getResource() {
			return this.resource
		}

		override getSubject() {
			return resource
		}
	}

	public static class MessageRealizationContext extends RealizationContext {
		val private TypedMessage message

		private new(TypedMessage message) {
			if (message.dataType === null) {
				throw new IllegalArgumentException("Only a type-bound message may be used as a realization context")
			}
			this.message = message
		}

		override getStructure() {
			message.actualType
		}

		override getApi() {
			resource.eContainer as ResourceAPI
		}

		override getSubject() {
			return message
		}

		override getResource() {
			message.method.containingResourceDefinition as ServiceDataResource
		}

		def private getMethod(TypedMessage message) {
			switch (message) {
				TypedRequest: message.containingMethod
				TypedResponse: message.containingMethod
			}
		}
	}

	public static class ReferencePropertyRealizationContext extends RealizationContext {
		val private ReferenceProperty refProp
		val private ServiceDataResource rootResource

		private new(ReferenceProperty refProp, ServiceDataResource rootResource) {
			this.refProp = refProp
			this.rootResource = rootResource
		}

		override getStructure() {
			return refProp.type
		}

		override getResource() {
			return rootResource
		}

		override getApi() {
			return rootResource.eContainer as ResourceAPI
		}

		def getRootResource() {
			return rootResource
		}

		override getSubject() {
			return refProp
		}
	}
}
