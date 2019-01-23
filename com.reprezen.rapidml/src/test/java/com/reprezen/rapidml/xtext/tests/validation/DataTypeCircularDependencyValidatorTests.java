/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider;
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator;

@InjectWith(RapidMLInjectorProvider.class)
@RunWith(XtextRunner.class)
public class DataTypeCircularDependencyValidatorTests {

    @Inject
    private ValidatorTester<XtextDslJavaValidator> tester;
    private RapidmlFactory factory = RapidmlFactory.eINSTANCE;

    @Test
    public void testSelfContainmentReference() {
        ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1");
        Structure datatype1 = reference1.getContainingDataType();
        reference1.setType(datatype1);

        tester.validate(reference1).assertWarningContains("Circular");
    }

    @Test
    public void testTwoLevelContainmentCircularReference() {
        ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1");
        Structure datatype1 = reference1.getContainingDataType();

        ReferenceProperty reference2 = createDataTypeWithContainmentReference("ref2");
        Structure datatype2 = reference2.getContainingDataType();

        reference1.setType(datatype2);
        reference2.setType(datatype1);

        tester.validate(reference1).assertWarningContains("Circular");
    }

    @Test
    public void testThreeLevelContainmentCircularReference() {
        ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1");
        Structure datatype1 = reference1.getContainingDataType();

        ReferenceProperty reference2 = createDataTypeWithContainmentReference("ref2");
        Structure datatype2 = reference2.getContainingDataType();

        ReferenceProperty reference3 = createDataTypeWithContainmentReference("ref3");
        Structure datatype3 = reference3.getContainingDataType();

        reference1.setType(datatype2);
        reference2.setType(datatype3);
        reference3.setType(datatype1);

        tester.validate(reference1).assertWarningContains("Circular");
    }

    @Test
    public void testNoContainmentCircularReference() {
        ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1");
        Structure datatype1 = reference1.getContainingDataType();

        ReferenceProperty reference2 = createDataTypeWithContainmentReference("ref2");
        Structure datatype2 = reference2.getContainingDataType();

        reference1.setType(datatype2);
        // reference2.setType(datatype1);

        tester.validate(reference1).assertOK();
    }

    protected ReferenceProperty createDataTypeWithContainmentReference(String propertyName) {
        Structure datatype1 = factory.createStructure();
        datatype1.setName("DataType_" + propertyName);
        ReferenceProperty reference1 = factory.createReferenceProperty();
        datatype1.getOwnedFeatures().add(reference1);
        reference1.setContainment(true);
        reference1.setName(propertyName);
        return reference1;
    }
}
