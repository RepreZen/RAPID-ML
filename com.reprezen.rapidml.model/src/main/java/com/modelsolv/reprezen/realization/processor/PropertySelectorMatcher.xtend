/*******************************************************************************
 * Copyright � 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.realization.processor

import com.modelsolv.reprezen.realization.model.AbstractPropertySelector
import com.modelsolv.reprezen.realization.model.ContainmentSelector
import com.modelsolv.reprezen.realization.model.MultiplicitySelector
import com.modelsolv.reprezen.realization.model.PrimitivePropertyRealization
import com.modelsolv.reprezen.realization.model.PrimitivePropertySelector
import com.modelsolv.reprezen.realization.model.PropertyRealization
import com.modelsolv.reprezen.realization.model.PropertySelector
import com.modelsolv.reprezen.realization.model.PropertyTypeRealization
import com.modelsolv.reprezen.realization.model.PropertyTypeSelector
import com.modelsolv.reprezen.realization.model.ReadWriteSelector
import com.modelsolv.reprezen.realization.model.ReferencePropertyRealization
import com.modelsolv.reprezen.realization.model.ReferencePropertySelector
import com.modelsolv.reprezen.restapi.Feature
import com.modelsolv.reprezen.restapi.PrimitiveProperty
import com.modelsolv.reprezen.restapi.ReferenceProperty
import com.reprezen.jsonoverlay.Overlay

import static extension com.modelsolv.reprezen.realization.processor.ContextMatcher.isAutoLinkableToCollectionResource
import static extension com.modelsolv.reprezen.realization.processor.ContextMatcher.isAutoLinkableToObjectResource

class PropertySelectorMatcher {

	val RealizationContext context

	new() {
		this.context = null
	}

	new(RealizationContext context) {
		this.context = context
	}

	def matches(Feature prop, AbstractPropertySelector selector) {
		return checkMultiplicity(prop, selector.multiplicity) //
		&& checkReadWrite(prop, selector.readWritability) //
		&& checkRequired(prop, selector.getRequired) //
		&& switch (selector) {
			PropertySelector: {
				checkPropertyType(prop, selector.propertyType)
			}
			PropertyRealization:
				checkPropertyType(prop, selector.propertyType)
			default:
				false
		}
	}

	def private checkPropertyType(Feature prop, PropertyTypeSelector propType) {
		return !Overlay.of(propType).isPresent|| switch (propType) {
			PrimitivePropertySelector:
				checkPrimitivePropertyType(prop, propType)
			ReferencePropertySelector:
				checkReferencePropertyType(prop, propType)
			default:
				false
		}

	}

	def private checkPropertyType(Feature prop, PropertyTypeRealization propType) {
		return !Overlay.of(propType).isPresent || switch (propType) {
			PrimitivePropertyRealization:
				checkPrimitivePropertyType(prop, propType)
			ReferencePropertyRealization:
				checkReferencePropertyType(prop, propType)
			default:
				false
		}
	}

	def private checkPrimitivePropertyType(Feature prop, PrimitivePropertySelector selector) {
		if (prop instanceof PrimitiveProperty) {
			val primProp = prop as PrimitiveProperty
			return checkIsKey(primProp, selector.getIsKey)
		} else {
			return false
		}
	}

	def private checkPrimitivePropertyType(Feature prop, PrimitivePropertyRealization selector) {
		if (prop instanceof PrimitiveProperty) {
			val primProp = prop as PrimitiveProperty
			return checkIsKey(primProp, selector.getIsKey)
		} else {
			return false
		}
	}

	def private checkReferencePropertyType(Feature prop, ReferencePropertySelector selector) {
		return prop instanceof ReferenceProperty && {
			val refProp = prop as ReferenceProperty
			checkContainment(refProp, selector.containment) //
			&& checkHasKeys(refProp, selector.getHasKeys) //
			&& checkAutoLinkableToObject(refProp, selector.getAutoLinkableToObjectResource) //
			&& checkAutoLinkableToCollection(refProp, selector.getAutoLinkableToCollectionResource)
		}
	}

	def private checkReferencePropertyType(Feature prop, ReferencePropertyRealization selector) {
		return prop instanceof ReferenceProperty && {
			val refProp = prop as ReferenceProperty
			checkContainment(refProp, selector.containment) //
			&& checkHasKeys(refProp, selector.getHasKeys) //
			&& checkAutoLinkableToObject(refProp, selector.getAutoLinkableToObjectResource) //
			&& checkAutoLinkableToCollection(refProp, selector.getAutoLinkableToCollectionResource)
		}
	}

	def boolean checkMultiplicity(Feature prop, MultiplicitySelector multiplicity) {
		return multiplicity === null || switch (multiplicity) {
			case SINGLE_VALUED: prop.maxOccurs == 1
			case MULTI_VALUED: prop.maxOccurs != 1
		}
	}

	def boolean checkReadWrite(Feature prop, ReadWriteSelector readWrite) {
		val readOnly = prop.isReadOnly
		return readWrite == null || switch (readWrite) {
			case READABLE: true
			case READ_ONLY: readOnly
			case WRITABLE: !readOnly
			case WRITE_ONLY: false
			case READ_WRITE: !readOnly
		}
	}

	def boolean checkRequired(Feature prop, Boolean required) {
		return required == null || required == (prop.minOccurs > 0);
	}

	def boolean checkContainment(ReferenceProperty refProp, ContainmentSelector containment) {
		return containment == null || switch containment {
			case CONTAINING: refProp.isContainment
			case NON_CONTAINING: !refProp.isContainment
			case CONTAINER: refProp.isContainer
			case NON_CONTAINER: !refProp.isContainer
			case CONTAINMENT: refProp.isContainer || refProp.isContainment
			case NON_CONTAINMENT: !refProp.isContainer && !refProp.isContainment
		}
	}

	def boolean checkIsKey(PrimitiveProperty prop, Boolean isKey) {
		return isKey === null || isKey == prop.isKey
	}

	def boolean checkHasKeys(ReferenceProperty prop, Boolean hasKeys) {
		return hasKeys === null || hasKeys == prop.type.ownedFeatures.exists[isKey]
	}

	def boolean checkAutoLinkableToObject(ReferenceProperty prop, Boolean autoLinkable) {
		if (autoLinkable === null) {
			return true
		}
		return autoLinkable == prop.type.isAutoLinkableToObjectResource(context.api)
	}

	def boolean checkAutoLinkableToCollection(ReferenceProperty prop, Boolean autoLinkable) {
		if (autoLinkable === null) {
			return true
		}
		return autoLinkable == prop.type.isAutoLinkableToCollectionResource(context.api)
	}
}
