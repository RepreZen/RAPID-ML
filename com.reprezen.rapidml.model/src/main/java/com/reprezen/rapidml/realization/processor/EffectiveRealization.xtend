/*******************************************************************************
 * Copyright � 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Maps
import com.reprezen.rapidml.realization.model.PropertyRealization
import com.reprezen.rapidml.realization.model.RealizationRule
import com.reprezen.rapidml.ObjectRealization
import com.reprezen.rapidml.ReferenceRealization
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.Feature
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.impl.RapidmlFactoryImpl
import com.reprezen.jsonoverlay.Overlay
import java.util.Map
import java.util.concurrent.CompletableFuture
import org.eclipse.emf.common.util.EList

/**
 * The realization to be used for a given structure type, as computed by a given realization rule.
 * 
 * The realization provides all of the following:
 * <ul>
 * <li>A name for the realization</li>
 * <li>
 *   A map of feature names to constrained feature definitions (in the form of
 *   {@link com.reprezen.rapidml.PropertyRealization}s)
 * </li>
 * <li>A map of link relation names to target resources</li>
 * <li>A map of reference property feature names to reference realizations.</li>
 * </ul>
 * 
 * Reference realizations come from two possible sources, depending on whether the rule used
 * for the realization that includes the reference property provides a realization for the
 * property:
 * <ul> 
 * <li>If so, the realization is actually an {@link EffectiveReferenceRealization} 
 *     instance, which builds its realization name by appending the reference property name
 *     to the containing realization's name.</li>
 * <li>Otherwise, the realization by matching the reference realization context in the 
 *     containing API's realization model.
 * </li>
 */
class EffectiveRealization {
	var protected String name = null
	val private Structure type
	val private RealizationRule rule
	val private Map<String, com.reprezen.rapidml.PropertyRealization> properties
	val private Map<String, ServiceDataResource> links

	val private RealizationContainerBuilder emfRealizationBuilder = new RealizationContainerBuilder
	var private ObjectRealization emfObjectRealization
	var private EList<ReferenceTreatment> emfReferenceTreatments
	var private ReferenceRealization emfReferenceRealization

	val private Map<String, CompletableFuture<EffectiveRealization>> refRealizationFutures
	var private Map<String, EffectiveRealization> refRealizations = null

	private new(Structure type, RealizationRule rule, Map<String, ConstrainedFeature> properties,
		Map<String, ServiceDataResource> links,
		Map<String, CompletableFuture<EffectiveRealization>> refRealizationFutures) {
			this.rule = rule
			this.type = type
			this.properties = properties.mapValues[get]
			this.links = links
			this.refRealizationFutures = refRealizationFutures
		}

		def String getName() {
			if (name === null) {
				name = computeName
			}
			return name;
		}

		def Structure getType() {
			return type
		}

		def RealizationRule getRule() {
			return rule
		}

		def Map<String, com.reprezen.rapidml.PropertyRealization> getProperties() {
			return properties
		}

		def com.reprezen.rapidml.PropertyRealization getProperty(String name) {
			return properties.get(name)
		}

		def Map<String, ServiceDataResource> getLinks() {
			return links
		}

		def ServiceDataResource getLink(String relation) {
			return links.get(relation)
		}

		def Map<String, EffectiveRealization> getReferenceRealizations() {
			fillRefRealizations
			return refRealizations
		}

		def EffectiveRealization getReferenceRealization(String name) {
			fillRefRealizations
			return refRealizations.get(name)
		}

		def private fillRefRealizations() {
			if (refRealizations === null) {
				refRealizations = Maps.newHashMap
				refRealizationFutures.entrySet.forEach[refRealizations.put(key, value.get)]
			}
		}

		def protected computeName() {
			return (rule.namingPattern ?: "${TypeName}_${RealizationRuleName}").interpolate
		}

		def private interpolate(String pattern) {
			var result = pattern.replaceAll("\\$\\{TypeName\\}", type.name)
			result = result.replaceAll("\\$\\{RealizationRuleName\\}", Overlay.of(rule).pathInParent)
			return result
		}

		override toString() {
			#[
				'''EffectivevRealization[type: «type.name»''',
				'''rule: «Overlay.of(rule).pathInParent»''',
				'''properties: [«FOR name : properties.keySet SEPARATOR ", "»«name»«ENDFOR»]''',
				'''links: [«FOR link : links.keySet SEPARATOR ", "»«link» > «links.get(link).name»«ENDFOR»]'''
			].join("; ") + "]"
		}

		def ObjectRealization getPropertiesAsObjectRealization() {
			if (emfObjectRealization == null) {
				emfObjectRealization = emfRealizationBuilder.buildObjectRealization(this)
			}
			return emfObjectRealization
		}

		def EList<ReferenceTreatment> getReferenceTreatments() {
			if (emfReferenceTreatments == null) {
				emfReferenceTreatments = emfRealizationBuilder.buildReferenceTreatmentsList(this)
			}
			return emfReferenceTreatments;
		}

		def ReferenceRealization asReferenceRealization() {
			if (emfReferenceRealization == null) {
				emfReferenceRealization = emfRealizationBuilder.buildReferenceRealization(this)
			}
			return emfReferenceRealization
		}

		static class NestedEffectiveRealization extends EffectiveRealization {
			var private EffectiveRealization parent = null
			var private String propInParent = null

			private new(Structure type, RealizationRule rule, Map<String, ConstrainedFeature> properties,
				Map<String, ServiceDataResource> links,
				Map<String, CompletableFuture<EffectiveRealization>> refRealizationFutures) {
					super(type, rule, properties, links, refRealizationFutures)
				}

				def setParent(EffectiveRealization parent, String propInParent) {
					this.parent = parent
					this.propInParent = propInParent
				}

				override computeName() {
					if (name === null) {
						name = '''«parent.name»_«propInParent»'''
					}
				}
			}

			static class Builder {
				private Structure type
				val private RealizationRule rule
				val private EffectiveRealizationProvider provider
				val private Map<String, PropertyRealization> includedProperties = Maps.newHashMap
				val private Map<String, ServiceDataResource> links = Maps.newLinkedHashMap
				val private Map<String, NestedEffectiveRealization> nestedRefRealizations = Maps.newHashMap

				new(RealizationContext context, RealizationRule rule, EffectiveRealizationProvider provider) {
					this.type = context.structure
					this.rule = rule
					this.provider = provider
				}

				def EffectiveRealization build() {
					build(false)
				}

				def EffectiveRealization build(boolean isRefRealization) {
					val Map<String, ConstrainedFeature> constrainedFeatures = Maps.newLinkedHashMap
					val Map<String, CompletableFuture<EffectiveRealization>> refRealizationFutures = Maps.newHashMap

					// order included features according to their order in the containing type
					for (feature : type.ownedFeatures) {
						if (includedProperties.containsKey(feature.name)) {
							val constrainedFeature = feature.constrainFeature(includedProperties.get(feature.name))
							constrainedFeatures.put(feature.name, constrainedFeature)
						}
					}
					for (refProp : type.ownedFeatures.filter[it instanceof ReferenceProperty]) {
						if (includedProperties.containsKey(refProp.name)) {
							if (nestedRefRealizations.containsKey(refProp.name)) {
								val future = new CompletableFuture<EffectiveRealization>
								future.complete(nestedRefRealizations.get(refProp.name))
								refRealizationFutures.put(refProp.name, future)
							} else {
								refRealizationFutures.put(refProp.name,
									provider.getPropertyRealization(refProp as ReferenceProperty).get)
							}
						}
					}
					val result = if (isRefRealization) {
							new NestedEffectiveRealization(type, rule, constrainedFeatures, links,
								refRealizationFutures)
						} else {
							new EffectiveRealization(type, rule, constrainedFeatures, links, refRealizationFutures)
						}
					for (refPropName : nestedRefRealizations.keySet) {
						nestedRefRealizations.get(refPropName).setParent(result, refPropName)
					}
					return result
				}

				def void includeProperty(String name, PropertyRealization property) {
					includedProperties.put(name, property)
				}

				def void addNestedRealization(String name, NestedEffectiveRealization nestedRealization) {
					nestedRefRealizations.put(name, nestedRealization)
				}

				def void addLink(String relationName, ServiceDataResource resource) {
					if (relationName != null && resource != null) {
						links.put(relationName, resource)
					}
				}

				def private constrainFeature(Feature feature, PropertyRealization propertyRealization) {
					val constrainedFeature = new ConstrainedFeature(feature)
					// realization rules aren't currently capable of expressing narrowing constraints on included
					// properties, but this is planned. Here and in the ConstrainedFeature class are where they 
					// should be implemnted.
					return constrainedFeature
				}
			}

			/**
			 * This class is a wrapper for a <code>cmr.rapidml.PropertyRealization</code>.
			 * 
			 * Its name does not conflict with <code>cmr.realization.model.PropertyRealization</code>, which helps keep other
			 * code more concise.
			 * 
			 * But more importantly, it provides methods to specify narrowing constraints imposed by a realization rule.
			 * (Currently, none are defined, because there is no provision yet for specifying them in realization rules, but
			 * this is where they should be implemented when they're supported.)
			 * 
			 * @author Andy Lowry
			 */
			static class ConstrainedFeature {

				com.reprezen.rapidml.PropertyRealization property

				new(Feature feature) {
					this.property = RapidmlFactoryImpl.eINSTANCE.createPropertyRealization
					property.baseProperty = feature
				}

				def com.reprezen.rapidml.PropertyRealization get() {
					return property
				}

				// example of an implementation of a possible narrowing constraint method
				def void setRequired(boolean required) {
					property.cardinality = #[if(required) 1 else 0, property.maxOccurs]
				}
			}
		}
		