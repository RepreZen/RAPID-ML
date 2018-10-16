/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.implicit;

import static com.modelsolv.reprezen.restapi.util.TagUtils.PROPERTY_INHERITED;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.modelsolv.reprezen.restapi.Documentation;
import com.modelsolv.reprezen.restapi.Extension;
import com.modelsolv.reprezen.restapi.ImportDeclaration;
import com.modelsolv.reprezen.restapi.RestapiFactory;
import com.modelsolv.reprezen.restapi.ZenModel;
import com.modelsolv.reprezen.restapi.Constraint;
import com.modelsolv.reprezen.restapi.Feature;
import com.modelsolv.reprezen.restapi.Inheritable;
import com.modelsolv.reprezen.restapi.PrimitiveProperty;
import com.modelsolv.reprezen.restapi.ReferenceProperty;
import com.modelsolv.reprezen.restapi.Structure;
import com.modelsolv.reprezen.restapi.util.TagUtils;

import reprezen.org.eclipse.xtext.EcoreUtil2;

public class InheritedPropertiesProcessor {
    public void addInheritedProperties(ZenModel model) {
        if (model == null) {
            // can be null when an import declaration is declared, but elements from it are never used
            return;
        }
        if (TagUtils.getTagWithName(model, TagUtils.DATATYPE_PROCESSED).isPresent()) {
            return;
        }
        TagUtils.addTag(model, TagUtils.DATATYPE_PROCESSED).setValue("true");
        for (Structure structure : EcoreUtil2.getAllContentsOfType(model, Structure.class)) {
            addInheritedProperties(structure);
        }
        for (ImportDeclaration import_: model.getImports()) {
            addInheritedProperties(import_.getImportedModel());
        }
    }

    private void addInheritedProperties(Structure structure) {
        if (TagUtils.getTagWithName(structure, TagUtils.DATATYPE_PROCESSED).isPresent()) {
            return;
        }
        TagUtils.addTag(structure, TagUtils.DATATYPE_PROCESSED).setValue("true");

        Multimap<String, Feature> inheritedProperties = buildNameToInheritedPropertiesMap(structure);
        processOverrides(structure, inheritedProperties);

        for (String inheritedPropertyName : inheritedProperties.keySet()) {
            LinkedList<Feature> inheritedPropertiesForName = Lists
                    .newLinkedList(inheritedProperties.get(inheritedPropertyName));
            Feature newProperty = processInheritedProperty(inheritedPropertiesForName);
            structure.getOwnedFeatures().add(newProperty);
        }
    }

    private Feature processInheritedProperty(LinkedList<Feature> inheritedPropertiesForName) {
        Feature inheritedProperty = inheritedPropertiesForName.pop();
        Feature newProperty;
        if (inheritedProperty instanceof PrimitiveProperty) {
            PrimitiveProperty inheritedPrimitiveProperty = (PrimitiveProperty) inheritedProperty;
            PrimitiveProperty newPrimitiveProperty = RestapiFactory.eINSTANCE.createPrimitiveProperty();
            newPrimitiveProperty.setType(inheritedPrimitiveProperty.getType());
            List<Constraint> constraintsToCopy = Lists.newArrayList(inheritedPrimitiveProperty.getAllConstraints());
            for (PrimitiveProperty nextInheritedProperty : Iterables.filter(inheritedPropertiesForName,
                    PrimitiveProperty.class)) {
                constraintsToCopy.addAll(nextInheritedProperty.getAllConstraints());
            }
            for (Constraint next : constraintsToCopy) {
                Constraint newConstraint = EcoreUtil.copy(next);
                newPrimitiveProperty.getAllConstraints().add(newConstraint);
            }

            newProperty = newPrimitiveProperty;
        } else { // ReferenceProperty
            ReferenceProperty inheritedReferenceProperty = (ReferenceProperty) inheritedProperty;
            ReferenceProperty newReferenceProperty = RestapiFactory.eINSTANCE.createReferenceProperty();
            newReferenceProperty.setType(inheritedReferenceProperty.getType());
            newReferenceProperty.setContainer(inheritedReferenceProperty.isContainer());
            newReferenceProperty.setContainment(inheritedReferenceProperty.isContainment());
            newReferenceProperty.setInverse(inheritedReferenceProperty.getInverse());
            newProperty = newReferenceProperty;
        }
        newProperty.setName(inheritedProperty.getName());
        newProperty.setCardinality(inheritedProperty.getCardinality());
        newProperty.setReadOnly(inheritedProperty.isReadOnly());
        newProperty.setKey(inheritedProperty.isKey());
        // no need to copy isRestriction() as it should be defined by the user and means that a property overrides another property

        TagUtils.addTag(newProperty, PROPERTY_INHERITED).setValue("true");
     
        if (inheritedProperty.getDocumentation() != null) {
            Documentation documentation = RestapiFactory.eINSTANCE.createDocumentation();
            documentation.setText(inheritedProperty.getDocumentation().getText());
            newProperty.setDocumentation(documentation);
        }

        for (Extension next : inheritedProperty.getExtensions()) {
            if (next.getName() != null && next.getName().startsWith("gen-")) {
                // ignore markers created by generator
                continue;
            }
            Extension newExtension = EcoreUtil.copy(next);
            newProperty.getExtensions().add(newExtension);
        }
        
        return newProperty;
    }

    private void processOverrides(Structure structure, Multimap<String, Feature> inheritedProperties) {
        for (Feature declaredProperty : structure.getOwnedFeatures()) {
            if (declaredProperty.isRestriction()) {
                Iterable<Feature> overriddenPropertyHierarchy = inheritedProperties.get(declaredProperty.getName());
                processPropertyOverride(declaredProperty, overriddenPropertyHierarchy);
                inheritedProperties.removeAll(declaredProperty.getName());
            }
        }
    }

    private void processPropertyOverride(Feature declaredProperty, Iterable<Feature> overriddenPropertyHierarchy) {
        if (declaredProperty instanceof PrimitiveProperty) {
            PrimitiveProperty declaredPrimitiveProperty = (PrimitiveProperty) declaredProperty;
            for (PrimitiveProperty overriddenProperty : Iterables.filter(overriddenPropertyHierarchy,
                    PrimitiveProperty.class)) {
                EList<Constraint> constraintsToCopy = overriddenProperty.getAllConstraints();
                for (Constraint next : constraintsToCopy) {
                    Constraint newConstraint = EcoreUtil.copy(next);
                    declaredPrimitiveProperty.getAllConstraints().add(newConstraint);
                }
            }
        }
        if (declaredProperty.getDocumentation() == null) {
            for (Feature next : overriddenPropertyHierarchy) {
                if (next.getDocumentation() != null) {
                    Documentation documentation = RestapiFactory.eINSTANCE.createDocumentation();
                    documentation.setText(next.getDocumentation().getText());
                    declaredProperty.setDocumentation(documentation);
                }
            }
        }
        if (declaredProperty.getCardinality() == null) {
            for (Feature next : overriddenPropertyHierarchy) {
                if (next.getCardinality() != null) {
                    declaredProperty.setCardinality(next.getCardinality());
                }
            }
        }
    }

    private Multimap<String, Feature> buildNameToInheritedPropertiesMap(Structure structure) {
        Multimap<String, Feature> inheritedProperties = LinkedHashMultimap.create();
        for (Inheritable next : structure.getSupertypes()) {
            if (next instanceof Structure) {
                Structure supertype = (Structure) next;
                addInheritedProperties(supertype);
                for (Feature inheritedProperty : supertype.getOwnedFeatures()) {
                    inheritedProperties.put(inheritedProperty.getName(), inheritedProperty);
                }
            }
        }
        return inheritedProperties;
    }
}
