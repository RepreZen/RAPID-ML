/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.validation;

import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.reprezen.rapidml.datatypes.util.ReferenceTreatmentOperations.hasTheSameReferencePath;
import static com.reprezen.rapidml.util.PrimitiveTypes.INT;
import static com.reprezen.rapidml.util.PrimitiveTypes.STRING;
import static com.reprezen.rapidml.util.RapidmlModelUtils.isContainmentReferenceProperty;
import static com.reprezen.rapidml.util.ReferenceTreatmentUtils.getLabel;
import static org.eclipse.xtext.EcoreUtil2.getSiblingsOfType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.SeverityConverter;

import com.fasterxml.jackson.core.JsonParseException;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.reprezen.rapidml.ConstrainableType;
import com.reprezen.rapidml.Constraint;
import com.reprezen.rapidml.DataModel;
import com.reprezen.rapidml.DataType;
import com.reprezen.rapidml.EnumConstant;
import com.reprezen.rapidml.Enumeration;
import com.reprezen.rapidml.ExternalExample;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.HttpMessageParameterLocation;
import com.reprezen.rapidml.ImportDeclaration;
import com.reprezen.rapidml.Inheritable;
import com.reprezen.rapidml.MessageParameter;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.PrimitiveProperty;
import com.reprezen.rapidml.PrimitiveType;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.RealizationModelLocation;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.RegExConstraint;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.SingleValueType;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.TypedMessage;
import com.reprezen.rapidml.TypedRequest;
import com.reprezen.rapidml.TypedResponse;
import com.reprezen.rapidml.UserDefinedType;
import com.reprezen.rapidml.ValueRangeConstraint;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.datatypes.cardinality.Cardinality;
import com.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities;
import com.reprezen.rapidml.datatypes.cardinality.OverrideCardinalities;
import com.reprezen.rapidml.datatypes.util.ConstraintsUtils;
import com.reprezen.rapidml.realization.parser.RealizationModelParser;
import com.reprezen.rapidml.realization.parser.RealizationModelParser.RealizationModelParseException;
import com.reprezen.rapidml.realization.processor.AutoRealizationProcessor;
import com.reprezen.rapidml.realization.processor.EffectiveRealizationRegistry;
import com.reprezen.rapidml.realization.processor.NoRealizationException;
import com.reprezen.rapidml.realization.processor.RealizationProcessor;
import com.reprezen.rapidml.realization.processor.RealizationProcessor.IRealizationProcessor;
import com.reprezen.rapidml.util.ExampleUtils;
import com.reprezen.rapidml.util.ObjectRealizationUtils;
import com.reprezen.rapidml.util.PrimitiveTypes;
import com.reprezen.rapidml.util.RapidmlModelUtils;
import com.reprezen.rapidml.xtext.nls.Messages;
import com.reprezen.rapidml.xtext.preferences.RapidMLPreferences;
import com.reprezen.rapidml.xtext.services.XtextDslGrammarAccess;

public class XtextDslJavaValidator extends AbstractXtextDslJavaValidator {

	@Inject
	private ElementOrderSorter elementOrderSorter;

	@Inject
	private RapidMLPreferences preferences;

	@Inject
	private XtextDslGrammarAccess grammarAccess;

	public static final String INCORRECT_ELEMENT_ORDER = "INCORRECT_ELEMENT_ORDER";

	@Check
	public void checkEnumConstantNameUniquesness(Enumeration enumeration) {
		Set<String> names = new HashSet<>(enumeration.getEnumConstants().size());
		for (EnumConstant enumConstant : enumeration.getEnumConstants()) {
			if (names.contains(enumConstant.getName())) {
				String message = String.format("Enumeration constants must have unique names.");
				error(message, RapidmlPackage.Literals.ENUMERATION__ENUM_CONSTANTS);
			}
			names.add(enumConstant.getName());
		}
	}

	@Check
	public void checkEnumConstantImplicitLiteral(Enumeration enumeration) {
		if (INT.typeName().equals(enumeration.getBaseType().getName())) {
			Collection<EnumConstant> explicitlyAssigned = filter(enumeration.getEnumConstants(), hasIntegerValue());
			Collection<EnumConstant> implicitlyAssigned = filter(enumeration.getEnumConstants(),
					not(hasIntegerValue()));
			if (!explicitlyAssigned.isEmpty() && !implicitlyAssigned.isEmpty()) {
				final Collection<Integer> explicitlyAssignedValues = transform(explicitlyAssigned,
						new Function<EnumConstant, Integer>() {
							@Override
							public Integer apply(EnumConstant elem) {
								return elem.getIntegerValue();
							}
						});
				Collection<EnumConstant> duplicateValues = filter(implicitlyAssigned, new Predicate<EnumConstant>() {
					@Override
					public boolean apply(EnumConstant elem) {
						return explicitlyAssignedValues.contains(elem.getImplicitIntegerValue());
					}
				});
				if (!duplicateValues.isEmpty()) {
					String duplicateNamesAndValues = Joiner.on(", ")
							.join(transform(duplicateValues, new Function<EnumConstant, String>() {

								@Override
								public String apply(EnumConstant elem) {
									return String.format("enumConstant %s has value %s", elem.getName(),
											elem.getImplicitIntegerValue());
								}
							}));
					String message = String.format(
							"This enum contains implicitly assigned integer values which duplicate explicitly assigned values: %s.",
							duplicateNamesAndValues);
					warning(message, RapidmlPackage.Literals.ENUMERATION__ENUM_CONSTANTS);
				}
			}
		}
	}

	@Check
	public void checkEnumConstantType(EnumConstant enumConstant) {
		Enumeration enumeration = (Enumeration) enumConstant.eContainer();
		String baseTypeName = enumeration.getBaseType().getName();
		if (INT.typeName().equals(baseTypeName)) {
			if (hasLiteralValue().apply(enumConstant)) {
				String message = String.format("An int enumeration may use only int enum constants.");
				error(message, RapidmlPackage.Literals.ENUM_CONSTANT__LITERAL_VALUE);
			}
		}
		if (STRING.typeName().equals(baseTypeName)) {
			if (hasIntegerValue().apply(enumConstant)) {
				String message = String.format("A string enumeration may use only string enum constants.");
				error(message, RapidmlPackage.Literals.ENUM_CONSTANT__INTEGER_VALUE);
			}
		}
	}

	@Check
	public void checkReferenceTreatmentUniqueness(ReferenceTreatment referenceTreatment) {
		List<ReferenceTreatment> siblingReferenceTreatments = getSiblingsOfType(referenceTreatment,
				ReferenceTreatment.class);
		Collection<ReferenceTreatment> siblindsWithTheSameReference = siblingReferenceTreatments.stream()//
				.filter(hasTheSameReferencePath(referenceTreatment))//
				.collect(Collectors.toList());
		if (!siblindsWithTheSameReference.isEmpty()) {
			String message = String.format(
					"A single reference property may have at most one reference treatment, either a reference embed or a reference link, but not both: '%s'",
					getLabel(referenceTreatment.getReferenceElement()));
			error(message, RapidmlPackage.Literals.REFERENCE_TREATMENT__REFERENCE_ELEMENT);
		}
	}

	@Check
	public void checkIncludedPropertyCardinalityOverride(PropertyRealization includedProperty) {
		OverrideCardinalities overrideCardinalities = OverrideCardinalities.getOverrideCardinalities();
		Collection<Cardinality> allowedOverrides = overrideCardinalities.getAllowedOverride(includedProperty);
		if (includedProperty.getCardinality() == null) {
			// use default value
			return;
		}
		Cardinality currentCardinality = overrideCardinalities.getCardinality(includedProperty);
		Cardinality baseCardinality = FeatureCardinalities.getFeatureCardinalities()
				.getCardinality(includedProperty.getBaseProperty());
		if (!currentCardinality.equalValues(baseCardinality) && !allowedOverrides.contains(currentCardinality)) {
			String allowedOverridesAsList = allowedOverrides.toString();
			String message = String.format(
					"Cardinality override rules violated. Only the following values are allowed for '%s': %s",
					baseCardinality, allowedOverridesAsList);
			error(message, RapidmlPackage.Literals.PROPERTY_REALIZATION__CARDINALITY);
		}

	}

	/**
	 * The inverse keyword and refProp must be specified on both sides of the
	 * inverse pair, and must be consistent such that if DT1.r specifies DT2.r as
	 * its inverse, then DT2.r must specify DT1.r as its inverse.
	 * 
	 * @param referenceProperty
	 */
	@Check
	public void checkInverseReferenceProperty(ReferenceProperty referenceProperty) {
		ReferenceProperty inverse = referenceProperty.getInverse();
		if (inverse != null) {
			ReferenceProperty inverseOfInverse = inverse.getInverse();
			if (inverseOfInverse == null) {
				String message = String.format(
						"The inverse keyword must be specified on both sides of the inverse pair of '%s' and '%s'",
						referenceProperty.getName(), inverse.getName());
				error(message, RapidmlPackage.Literals.REFERENCE_PROPERTY__INVERSE);
				return;
			}
			if (!referenceProperty.equals(inverseOfInverse)) {
				String message = String.format(
						"The inverse keyword and refProp must be consistent on both sides of the inverse pair of '%s' and '%s'",
						referenceProperty.getName(), inverse.getName());
				error(message, RapidmlPackage.Literals.REFERENCE_PROPERTY__INVERSE);
			}
		}
	}

	/**
	 * The container keyword must be used on any reference that is the inverse of a
	 * containing reference. The container keyword must not be used on any reference
	 * that is not the inverse of a containing reference.
	 */
	@Check
	public void checkContainmentReferenceProperty(ReferenceProperty referenceProperty) {
		if (referenceProperty.isContainment()) {
			ReferenceProperty inverse = referenceProperty.getInverse();
			if (inverse != null && !inverse.isContainer()) {
				String message = String.format(
						"The inverse reference property '%s' of the data type '%s' is not a container reference. An inverse containing reference property must specify a container reference as its inverse.",
						inverse.getName(), inverse.getContainingDataType().getName());
				error(message, RapidmlPackage.Literals.REFERENCE_PROPERTY__CONTAINMENT);
			}
		}
	}

	@Check
	public void checkContainerReferenceProperty(ReferenceProperty referenceProperty) {
		if (referenceProperty.isContainer()) {
			ReferenceProperty inverse = referenceProperty.getInverse();
			if (inverse != null && !inverse.isContainment()) {
				String message = String.format(
						"The inverse reference property '%s' of the data type '%s' is not a containing reference. An inverse container reference property must specify a containing reference as its inverse.",
						inverse.getName(), inverse.getContainingDataType().getName());
				error(message, RapidmlPackage.Literals.REFERENCE_PROPERTY__CONTAINER);
				return;
			}
		}
	}

	@Check
	public void checkCircularContainment(ReferenceProperty referenceProperty) {
		if (referenceProperty.isContainment()) {
			Structure contained = referenceProperty.getType();
			checkCircularContainment(Sets.newHashSet(referenceProperty.getContainingDataType()), contained);
		}
	}

	@Check
	public void checkRESTfulInterfaceNameUniqueness(ZenModel model) {
		Set<String> names = Sets.newHashSet();
		for (ResourceAPI resourceAPI : model.getResourceAPIs()) {
			if (names.contains(resourceAPI.getName())) {
				error(String.format("Duplicate name of resource API '%s'", resourceAPI.getName()), resourceAPI,
						RapidmlPackage.Literals.RESOURCE_API__NAME);
			}
			names.add(resourceAPI.getName());
		}
	}

	@Check
	public void checkResourceNameUniqueness(ResourceAPI resourceAPI) {
		Set<String> names = Sets.newHashSet();
		for (ResourceDefinition type : resourceAPI.getOwnedResourceDefinitions()) {
			if (names.contains(type.getName())) {
				error(String.format("Duplicate name of resource '%s'", type.getName()), type,
						RapidmlPackage.Literals.RESOURCE_DEFINITION__NAME);
			}
			names.add(type.getName());
		}
	}

	@Check
	public void checkDataModelNameUniqueness(ZenModel model) {
		Set<String> names = Sets.newHashSet();
		for (DataModel dataModel : model.getDataModels()) {
			if (names.contains(dataModel.getName())) {
				error(String.format("Duplicate name of data model '%s'", dataModel.getName()), dataModel,
						RapidmlPackage.Literals.DATA_MODEL__NAME);
			}
			names.add(dataModel.getName());
		}
	}

	@Check
	public void checkDataTypeNameUniqueness(DataModel dataModel) {
		Set<String> names = Sets.newHashSet();
		for (DataType type : dataModel.getOwnedDataTypes()) {
			if (names.contains(type.getName())) {
				error(String.format("Duplicate name of data type '%s'", type.getName()), type,
						RapidmlPackage.Literals.DATA_TYPE__NAME);
			}
			names.add(type.getName());
		}
	}

	@Check
	public void checkDuplicatePropertyAndInheritedPropertyHierarchies(Structure structure) {
		Multimap<String, FeatureHierarchy> inheritedFeatures = getInheritedFeaturesMap(structure);

		for (String inheritedFeatureName : inheritedFeatures.keySet()) {
			Collection<FeatureHierarchy> featuresForName = inheritedFeatures.get(inheritedFeatureName);

			checkFeatureNameDuplicates(structure, featuresForName);
			checkForDuplicateFeatureHierarchies(structure, inheritedFeatureName, featuresForName);
		}

		for (Feature property : structure.getOwnedFeatures()) {
			if (property.isRestriction()) {
				Collection<FeatureHierarchy> featuresForName = inheritedFeatures.get(property.getName());
				checkPropertyRestrictionType(property, featuresForName);
			}
		}
	}

	private void checkForDuplicateFeatureHierarchies(Structure structure, String inheritedFeatureName,
			Collection<FeatureHierarchy> featuresForName) {
		if (featuresForName.size() > 1) {
			String datatypeNames = Joiner.on(", ")
					.join(Collections2.transform(featuresForName, new Function<FeatureHierarchy, String>() {

						@Override
						public String apply(FeatureHierarchy input) {
							return input.getRoot().getContainingDataType().getName();
						}
					}));
			String message = String.format(
					"Property '%s' is defined in more than one branch of the inheritance hierarchy: data types %s",
					inheritedFeatureName, datatypeNames);
			error(message, structure, RapidmlPackage.Literals.STRUCTURE__SUPERTYPES);
		}
	}

	/**
	 * Checks for properties with duplicates names within the same structure and
	 * also in the inheritance hierarchy
	 */
	private void checkFeatureNameDuplicates(Structure structure, Collection<FeatureHierarchy> featuresForName) {
		for (FeatureHierarchy hierarchy : featuresForName) {
			Feature root = hierarchy.getRoot();
			if (root.getContainingDataType() == structure && !root.isRestriction()
					&& hierarchy.getFeatures().size() > 1) {
				Feature inheritedFeature = hierarchy.getFeatures().get(1);
				error(String.format("Duplicate name: property '%s' is already defined in '%s'", root.getName(),
						inheritedFeature.getContainingDataType().getName()), root,
						RapidmlPackage.Literals.FEATURE__NAME);
			}
		}
	}

	private void checkPropertyRestrictionType(Feature validatedProperty,
			Collection<FeatureHierarchy> featuresHierarchies) {
		if (!featuresHierarchies.isEmpty()) { // Empty featuresHierarchies or several hierarchies should
			// be processed by another validator
			FeatureHierarchy featureHierarchy = featuresHierarchies.iterator().next();
			if (featureHierarchy.getFeatures().size() == 1) {
				String message = String.format("'%s' restricts a property which does not exist in extended supertypes",
						validatedProperty.getName());
				error(message, validatedProperty, RapidmlPackage.Literals.FEATURE__NAME);
			} else if (featureHierarchy.getFeatures().size() > 1) {
				Feature restrictedProperty = featureHierarchy.getFeatures().get(1);

				checkRestrictionCardinality(validatedProperty, restrictedProperty);

				if (validatedProperty instanceof PrimitiveProperty) {
					checkPrimitivePropertyRestrictionType((PrimitiveProperty) validatedProperty, restrictedProperty);
				}
				if (validatedProperty instanceof ReferenceProperty) {
					checkReferencePropertyRestrictionType((ReferenceProperty) validatedProperty, restrictedProperty);
				}
			}
		}
	}

	private void checkRestrictionCardinality(Feature validatedProperty, Feature overriddenProperty) {
		if (validatedProperty.getMinOccurs() < overriddenProperty.getMinOccurs() || //
				(cardinalityMax(validatedProperty.getMaxOccurs()) > cardinalityMax(
						overriddenProperty.getMaxOccurs()))) {
			FeatureCardinalities cardinalities = FeatureCardinalities.getFeatureCardinalities();
			String message = String.format(
					"The cardinality of property '%s' is incompatible with inherited property cardinality: '%s' ([%s, %s])",
					validatedProperty.getName(), cardinalities.getCardinality(overriddenProperty).getLabel(),
					overriddenProperty.getMinOccurs(),
					cardinalities.getCardinality(overriddenProperty).getUpperLabel());
			error(message, validatedProperty, RapidmlPackage.Literals.ELEMENT__CARDINALITY);
		}
	}

	private int cardinalityMax(int maxOccursValue) {
		return maxOccursValue != -1 ? maxOccursValue : Integer.MAX_VALUE;
	}

	private void checkReferencePropertyRestrictionType(ReferenceProperty validatedProperty,
			Feature overriddenProperty) {
		Structure restrictionType = validatedProperty.getType();
		if (overriddenProperty instanceof ReferenceProperty) {
			Structure overriddenType = ((ReferenceProperty) overriddenProperty).getType();
			if (overriddenType == restrictionType) {// same type
				return;
			}
			if (restrictionType.getAllSupertypes().contains(overriddenType)) {// covariance
				return;
			}
			String message = String.format(
					"The type of property '%s' is incompatible with inherited property type: '%s'",
					validatedProperty.getName(), overriddenType.getName());
			error(message, validatedProperty, RapidmlPackage.Literals.REFERENCE_PROPERTY__TYPE);
		}
	}

	private void checkPrimitivePropertyRestrictionType(PrimitiveProperty validatedProperty,
			Feature overriddenProperty) {
		SingleValueType typeOverride = validatedProperty.getType();
		if (overriddenProperty instanceof PrimitiveProperty) {
			SingleValueType overriddenType = ((PrimitiveProperty) overriddenProperty).getType();
			if (!canSubstitute(typeOverride, overriddenType)) {
				String message = String.format(
						"The type of property '%s' is incompatible with inherited property type: '%s'",
						validatedProperty.getName(), overriddenType.getName());
				error(message, validatedProperty, RapidmlPackage.Literals.PRIMITIVE_PROPERTY__TYPE);
			}
		}
	}

	private boolean canSubstitute(SingleValueType type, SingleValueType typeSubstitute) {
		if (typeSubstitute == type) {// same type
			return true;
		}
		if ((type instanceof UserDefinedType) && ((UserDefinedType) type).getBaseType() != null) {
			type = ((UserDefinedType) type).getBaseType();
			return canSubstitute(type, typeSubstitute);
		}
		return typeSubstitute == type.getPrimitiveType();
	}

	private Multimap<String, FeatureHierarchy> getInheritedFeaturesMap(Structure structure) {
		Multimap<String, FeatureHierarchy> result = ArrayListMultimap.create();
		if (structure.getAllSupertypes().contains(structure)) {
			return result;
		}
		for (Inheritable supertype : structure.getSupertypes()) {
			if (supertype instanceof Structure) {
				Multimap<String, FeatureHierarchy> inheritedFeatures = getInheritedFeaturesMap((Structure) supertype);
				for (FeatureHierarchy hierarchy : inheritedFeatures.values()) {
					String hierarchyName = hierarchy.getName();
					if (result.containsKey(hierarchyName)) {
						Collection<FeatureHierarchy> otherHierarchies = Lists.newArrayList(result.get(hierarchyName));
						for (FeatureHierarchy another : otherHierarchies) {
							if (hierarchy.contains(another)) {
								result.remove(hierarchyName, another);
								result.put(hierarchyName, hierarchy);
							} else if (another.contains(hierarchy)) {
								// do nothing
							} else {
								result.put(hierarchyName, hierarchy);
							}
						}
					} else {
						result.put(hierarchy.getName(), hierarchy);
					}
				}
			}
		}
		for (Feature prop : structure.getOwnedFeatures()) {
			if (result.containsKey(prop.getName())) {
				Collection<FeatureHierarchy> otherHierarchies = result.get(prop.getName());
				for (FeatureHierarchy another : otherHierarchies) {
					another.addRoot(prop);
				}
			} else {
				result.put(prop.getName(), new FeatureHierarchy(prop.getName(), prop));
			}
		}
		return result;
	}

	@Check
	public void checkElementOrder(ServiceDataResource serviceDataResource) {
		String settingName = NLS.bind(Messages.RepreZenValidatorConfigurationBlock_random_order_issue_key_all,
				serviceDataResource.eClass().getName());
		String setting = preferences.getString(settingName);
		if (!SeverityConverter.SEVERITY_IGNORE.equals(setting)) {
			List<INode> nodes = elementOrderSorter.getIncorrectOrderChildren(serviceDataResource);
			for (INode n : nodes) {
				if (n.getGrammarElement() instanceof Keyword) {
					settingName = NLS.bind(Messages.RepreZenValidatorConfigurationBlock_random_order_issue_key,
							serviceDataResource.eClass().getName(), ((Keyword) n.getGrammarElement()).getValue());
					setting = preferences.getString(settingName);
					if (!SeverityConverter.SEVERITY_IGNORE.equals(setting)) {
						EObject semanticElement = findActualSemanticObject(n, serviceDataResource);
						if (serviceDataResource != semanticElement) {
							warning(NLS.bind(Messages.XtextDslJavaValidator_incorrect_order_warning,
									((Keyword) n.getGrammarElement()).getValue()),
									semanticElement instanceof EStructuralFeature ? (EStructuralFeature) semanticElement
											: semanticElement.eContainingFeature(),
									INCORRECT_ELEMENT_ORDER, serviceDataResource.getName());
						}
					}
				}
			}
		}
	}

	@Check
	public void checkImportDeclaration(ImportDeclaration importDeclaration) {
		if (!Strings.isNullOrEmpty(importDeclaration.getImportedNamespace())
				&& !Strings.isNullOrEmpty(importDeclaration.getImportURI())) {
			if (!RapidmlModelUtils.getImportedNamespaces(importDeclaration)
					.contains(importDeclaration.getImportedNamespace())) {
				error(Messages.XtextDslJavaValidator_incorrectNamespace, importDeclaration,
						RapidmlPackage.Literals.IMPORT_DECLARATION__IMPORTED_NAMESPACE);
			}
		}
	}

	@Check
	public void checkImportDeclarationUnique(ZenModel model) {
		HashSet<String> aliases = new HashSet<>();
		HashSet<String> namespaces = new HashSet<>();
		for (ImportDeclaration importDecl : model.getImports()) {
			if (!Strings.isNullOrEmpty(importDecl.getAlias()) && !aliases.add(importDecl.getAlias())) {
				error(NLS.bind(Messages.XtextDslJavaValidator_duplicateAlias, importDecl.getAlias()), importDecl,
						RapidmlPackage.Literals.IMPORT_DECLARATION__ALIAS);
			}
			if (!Strings.isNullOrEmpty(importDecl.getImportedNamespace())
					&& !namespaces.add(importDecl.getImportedNamespace())) {
				error(NLS.bind(Messages.XtextDslJavaValidator_duplicateNamespace, importDecl.getImportedNamespace()),
						importDecl, RapidmlPackage.Literals.IMPORT_DECLARATION__IMPORTED_NAMESPACE);
			}
		}
	}

	@Check
	public void checkMessageParameterType(MessageParameter messageParameter) {
		if (messageParameter.getContainingMessage() instanceof TypedResponse
				&& messageParameter.getHttpLocation() == HttpMessageParameterLocation.QUERY) {
			error(NLS.bind(Messages.XtextDslJavaValidator_messageParameterLocation,
					messageParameter.getHttpLocation().getLiteral().toLowerCase()), messageParameter,
					RapidmlPackage.Literals.MESSAGE_PARAMETER__HTTP_LOCATION);
		}
	}

	@Check
	public void checkIncludedPropertiesDuplicate(ObjectRealization includedProperties) {
		for (int i = 0; i < includedProperties.getOverriddenPropertyList().size(); i++) {
			PropertyRealization property = includedProperties.getOverriddenPropertyList().get(i);
			int excludedIdx = includedProperties.getExcludedProperties().indexOf(property.getBaseProperty());
			if (excludedIdx >= 0) {
				error(NLS.bind(Messages.XtextDslJavaValidator_includedPropsDuplicate,
						property.getBaseProperty().getName()), includedProperties,
						RapidmlPackage.Literals.OBJECT_REALIZATION__OVERRIDDEN_PROPERTY_LIST, i);
				error(NLS.bind(Messages.XtextDslJavaValidator_excludedPropsDuplicate,
						property.getBaseProperty().getName()), includedProperties,
						RapidmlPackage.Literals.OBJECT_REALIZATION__EXCLUDED_PROPERTIES, excludedIdx);
			}
		}
	}

	// @Check
	public void checkMandatoryProperties(ObjectRealization includedProperties) {
		List<PrimitiveProperty> mandatoryProperties = ObjectRealizationUtils.getMandatoryProperties(includedProperties);
		List<Feature> excludedMandatoryProperties = Lists.newArrayList(includedProperties.getExcludedProperties());
		excludedMandatoryProperties.retainAll(mandatoryProperties);
		if (!excludedMandatoryProperties.isEmpty()) {
			error("This property is mandatory and cannot be excluded",
					RapidmlPackage.Literals.OBJECT_REALIZATION__EXCLUDED_PROPERTIES);
		}
	}

	@Check
	public void checkTypedMessageBody(TypedMessage message) {
		if (message.getActualType() == null) {
			if (message.getInlineObjectRealization() != null) {
				error(Messages.XtextDslJavaValidator_typedMessageBody, message,
						RapidmlPackage.Literals.REALIZATION_CONTAINER__PROPERTIES);
			}
			if (!message.getReferenceTreatments().isEmpty()) {
				error(Messages.XtextDslJavaValidator_typedMessageBody, message,
						RapidmlPackage.Literals.REALIZATION_CONTAINER__REFERENCE_TREATMENTS);
			}
		}
	}

	@Check
	public void checkTypedMessageUsingThisKeyword(TypedMessage message) {
		if (message.isUseParentTypeReference()) {
			// `this` keyword is not supported when the typed message is message-defined
			// (using type keyword).
			if (message.getDataType() != null) {
				error(Messages.XtextDslJavaValidator_typedMessageThisNotAllowedOnType, message,
						RapidmlPackage.Literals.REALIZATION_CONTAINER__DATA_TYPE);
			} else {
				final EStructuralFeature feature = RapidmlPackage.Literals.TYPED_MESSAGE__RESOURCE_TYPE;

				// Property sets and reference treatments are not allowed when this keyword is
				// used
				// and the typed message is not message-defined.
				if (message.getInlineObjectRealization() != null || !message.getReferenceTreatments().isEmpty()) {
					error(Messages.XtextDslJavaValidator_typedMessagePropertySetNotAllowed, message, feature);
				} else {
					ResourceDefinition resourceDefinition = ((Method) message.eContainer())
							.getContainingResourceDefinition();

					if (resourceDefinition instanceof ServiceDataResource) {
						ServiceDataResource dataResource = (ServiceDataResource) resourceDefinition;

						final String actualTypeName = message.getResourceType().getName();
						final String expectedTypeName = dataResource.getName();

						// The `this` keyword should be followed by the same type as the resource when
						// the typed message is not message-defined.
						if (expectedTypeName != null && !expectedTypeName.equals(actualTypeName)) {
							error(NLS.bind(Messages.XtextDslJavaValidator_typedMessageInvalidParentTypeReference,
									message instanceof TypedRequest ? "request" : "response", expectedTypeName),
									message, feature);
						}
					}
				}
			}
		}
	}

	@Check
	public void checkRegexConstraint(RegExConstraint regExConstraint) {
		String pattern = Strings.nullToEmpty(regExConstraint.getPattern());
		if (pattern.startsWith("^") || pattern.endsWith("$")) { //$NON-NLS-1$ //$NON-NLS-2$
			error(Messages.XtextDslJavaValidator_regexPatternAnchors, regExConstraint,
					RapidmlPackage.Literals.REG_EX_CONSTRAINT__PATTERN);
		}
	}

	@Check
	public void checkCircularBaseTypeReference(UserDefinedType userDefinedType) {
		if (ConstraintsUtils.isCircularBaseTypeReference(userDefinedType)) {
			String message = NLS.bind(Messages.XtextDslJavaValidator_circularBaseType,
					userDefinedType.getBaseType().getName());
			error(message, userDefinedType, RapidmlPackage.Literals.USER_DEFINED_TYPE__BASE_TYPE);
		}
	}

	@Check
	public void checkContraintsType(ConstrainableType constrainableType) {
		if (!constrainableType.getConstraints().isEmpty()) {
			PrimitiveType primitiveType = ConstraintsUtils.getBasePrimitiveType(constrainableType);
			if (primitiveType == null) {
				error(Messages.XtextDslJavaValidator_constraintsPrimitiveType, constrainableType,
						RapidmlPackage.Literals.CONSTRAINABLE_TYPE__CONSTRAINTS);
			} else {
				for (int i = 0; i < constrainableType.getConstraints().size(); i++) {
					Constraint constraint = constrainableType.getConstraints().get(i);
					if (PrimitiveTypes.isNumberBaseType(primitiveType)
							&& !(constraint instanceof ValueRangeConstraint)) {
						error(Messages.XtextDslJavaValidator_constraintsStringType, constrainableType,
								RapidmlPackage.Literals.CONSTRAINABLE_TYPE__CONSTRAINTS, i);
					}
					if (PrimitiveTypes.isStringBaseType(primitiveType) && constraint instanceof ValueRangeConstraint) {
						error(Messages.XtextDslJavaValidator_constraintsNumericType, constrainableType,
								RapidmlPackage.Literals.CONSTRAINABLE_TYPE__CONSTRAINTS, i);
					}
				}
			}
		}
	}

	@Check
	public void checkExternalExampleCanReadBody(ExternalExample example) {
		InputStream stream = null;
		try {
			stream = ExampleUtils.getBodyStream(example);
		} catch (IOException e) {
			String path = example.getPath();
			warning(NLS.bind(Messages.XtextDslJavaValidator_externalExampleCantReadBody, path), example,
					RapidmlPackage.Literals.EXTERNAL_EXAMPLE__PATH);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException ignoreInFinallyBlock) {
					//
				}
			}
		}
	}

	@Check
	public void checkCircularInheritance(Structure type) {
		if (type.getAllSupertypes().contains(type)) {
			error("Circular inheritance, please check that the supertype hierarchy does not contain loops", type,
					RapidmlPackage.Literals.STRUCTURE__SUPERTYPES);
		}
	}

	@Check
	public void checkRealization(ServiceDataResource resource) {
		if (isWithAutoRealizations(resource)) {
			try {
				new EffectiveRealizationRegistry().getRealization(resource);
			} catch (NoRealizationException e) {
				error(String.format("Cannot find an auto-realization rule matching data structure %s in this context.",
						resource.getActualType().getName()), resource,
						RapidmlPackage.Literals.RESOURCE_DEFINITION__NAME);
			}
		}
	}

	@Check
	public void checkRealization(TypedMessage message) {
		if (message.getDataType() != null && isWithAutoRealizations(message)) {
			try {
				new EffectiveRealizationRegistry().getRealization(message);
			} catch (NoRealizationException e) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(message);

				StreamSupport.stream(node.getAsTreeIterable().spliterator(), false)
						.filter(isTypeMessageKeyword(message)).findAny()
						.ifPresent(n -> getMessageAcceptor().acceptError(
								String.format("Cannot find an auto-realization rule matching this %s.",
										message instanceof TypedRequest ? "request" : "response"),
								message, n.getOffset(), n.getLength(), null));
			}
		}
	}

	@Check
	public void checkAutoRealizationFileExistsAndIsValid(ResourceAPI resourceAPI) {
		URI baseURI = resourceAPI.eResource().getURI();
		for (RealizationModelLocation location : resourceAPI.getAutoRealizations()) {
			try {

				URI uri;
				if (baseURI.isPlatformPlugin() || baseURI.isPlatformResource()) {
					uri = URI.createURI(location.getUri(), true).resolve(baseURI);
				} else {
					uri = URI.createFileURI(location.getUri()).resolve(baseURI);
				}

				if (!resourceAPI.eResource().getResourceSet().getURIConverter().exists(uri, null)) {
					error("Cannot find file named " + location.getUri(), location,
							RapidmlPackage.Literals.REALIZATION_MODEL_LOCATION__URI);
				} else {
					URL realizationUrl = new URL(uri.toString());
					String content = "";
					try (BufferedReader reader = new BufferedReader(
							new InputStreamReader(realizationUrl.openStream(), StandardCharsets.UTF_8))) {
						content = reader.lines().collect(Collectors.joining("\n"));
					}
					if (content.trim().isEmpty() || content.trim().equals("---")) {
						error("Realization model is empty", location,
								RapidmlPackage.Literals.REALIZATION_MODEL_LOCATION__URI);
					} else {
						new RealizationModelParser().parse(content, realizationUrl);
					}
				}

			} catch (Exception e) {
				List<String> msgs = Lists.newArrayList();
				if (e instanceof JsonParseException) {
					msgs.add("Realization model is not valid JSON or YAML: " + e.getLocalizedMessage());
				} else if (e instanceof RealizationModelParseException) {
					for (String parseError : ((RealizationModelParseException) e).getMessages()) {
						msgs.add(parseError);
					}
				} else {
					msgs.add(e.getLocalizedMessage());
				}
				for (String msg : msgs) {
					error(msg, location, RapidmlPackage.Literals.REALIZATION_MODEL_LOCATION__URI);
				}
			}
			// The fact that we ahve an array of locations is a mistake - only the first is
			// ever used, so we
			// should not check any others that might be there.
			break;
		}
	}

	// @Check
	public void checkAutoRealizationNameCollisions(ZenModel model) {
		for (ResourceAPI resourceAPI : model.getResourceAPIs()) {
			RealizationProcessor processor = new RealizationProcessor(resourceAPI);
			try {
				processor.generateAutoRealizations();
			} catch (RealizationModelParseException e) {
				// ignore
				return;
			}

			IRealizationProcessor realizationProcessor = processor.getRealizationProcessor();

			if (realizationProcessor instanceof AutoRealizationProcessor) {
				((AutoRealizationProcessor) realizationProcessor) //
						.getRegistry() //
						.getNameCollisions() //
						.ifPresent(collisions -> {
							String message = collisions.keySet() //
									.stream() //
									.map(key -> key + " for realizations " + collisions.get(key)) //
									.collect(Collectors.joining(" and "));

							error("Name collisions detected, " + message, model,
									RapidmlPackage.Literals.ZEN_MODEL__RESOURCE_AP_IS);
						});
			}
		}
	}

	private boolean isWithAutoRealizations(EObject object) {
		ResourceAPI resourceAPI = getResourceAPI(object);
		return resourceAPI != null && !resourceAPI.getAutoRealizations().isEmpty();
	}

	private ResourceAPI getResourceAPI(EObject object) {
		while (object != null) {
			if (object instanceof ResourceAPI) {
				return (ResourceAPI) object;
			}
			object = object.eContainer();
		}
		return null;
	}

	private java.util.function.Predicate<? super INode> isTypeMessageKeyword(TypedMessage message) {

		Keyword keyword = message instanceof TypedRequest ? grammarAccess.getTypedRequestAccess().getRequestKeyword_3()
				: grammarAccess.getTypedResponseAccess().getResponseKeyword_3();

		return n -> n.getGrammarElement() instanceof Keyword && n.getGrammarElement().equals(keyword);
	}

	protected EObject findActualSemanticObject(INode node, EObject parent) {
		while (parent == node.getSemanticElement() && node.hasNextSibling()) {
			Assignment assignment = GrammarUtil.containingAssignment(node.getGrammarElement());
			if (assignment != null) {
				return findSemanticObjectForStructuralFeature(assignment.getFeature(), parent);
			}
			node = node.getNextSibling();
		}
		return node.getSemanticElement();
	}

	protected EObject findSemanticObjectForStructuralFeature(String feature, EObject parent) {
		for (EStructuralFeature sf : parent.eClass().getEAllStructuralFeatures()) {
			if (feature.equals(sf.getName())) {
				return sf;
			}
		}
		return parent;
	}

	protected void checkCircularContainment(Set<Structure> containmentChain, Structure currentDataType) {
		if (currentDataType == null) {
			return;
		}
		if (containmentChain.contains(currentDataType)) {
			String dataTypeNames = Joiner.on(", ").join(transform(containmentChain, getName()));
			String message = String.format("Circular containment dependencies: %s and %s", dataTypeNames,
					currentDataType.getName());
			warning(message, RapidmlPackage.Literals.REFERENCE_PROPERTY__CONTAINER);
			return;
		}
		containmentChain.add(currentDataType);
		for (Structure type : getContainmentReferencePropertyTypes(currentDataType)) {
			checkCircularContainment(containmentChain, type);
		}
	}

	protected static Set<Structure> getContainmentReferencePropertyTypes(Structure type) {
		Set<Structure> result = Sets.newHashSet();
		for (ReferenceProperty prop : filter(type.getReferenceProperties(), isContainmentReferenceProperty())) {
			result.add(prop.getType());
		}
		return result;
	}

	private static Function<Structure, String> getName() {
		return new Function<Structure, String>() {

			@Override
			public String apply(Structure element) {
				return element.getName() != null ? element.getName() : "";
			}
		};
	}

	private static Predicate<EnumConstant> hasLiteralValue() {
		return new Predicate<EnumConstant>() {

			@Override
			public boolean apply(EnumConstant enumConstant) {
				return !Strings.isNullOrEmpty(enumConstant.getLiteralValue());
			}
		};
	}

	private static Predicate<EnumConstant> hasIntegerValue() {
		return new Predicate<EnumConstant>() {

			@Override
			public boolean apply(EnumConstant enumConstant) {
				return enumConstant.isSetIntegerValue();
			}
		};
	}

	private static class FeatureHierarchy {
		final String name;
		final LinkedList<Feature> features = Lists.newLinkedList();

		private FeatureHierarchy(String name, Feature feature) {
			this.name = name;
			features.add(feature);
		}

		public String getName() {
			return name;
		}

		public List<Feature> getFeatures() {
			return features;
		}

		public boolean contains(FeatureHierarchy another) {
			return features.contains(another.getRoot());
		}

		public Feature getRoot() {
			return features.get(0);
		}

		public void addRoot(Feature feature) {
			features.addFirst(feature);
		}
	}

}