package com.reprezen.rapidml.xtext.tests.normalizer

import com.google.inject.Inject
import com.reprezen.rapidml.LengthConstraint
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.util.TagUtils
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class InheritedPropertiesTest {

	@Inject extension ZenModelUtils

	def String textualModel() {
		'''rapidModel Employees

	dataModel EmployeesDataModel
		structure Root
			rootProp1: string*
			/** documentation2*/
			rootProp2: string
			rootProp3: readOnly string
			rootProp4: key string
			rootProp5: readOnly key string
		structure Subtype1 extends Root
			subtype1prop: string
			restrict rootProp1: string
				of length from 5 to 15
		structure Subtype2 extends Root
			subtype2prop: string
			restrict rootProp2: string
				of length from 6 to 7

		structure Subtype3 extends Subtype1, Subtype2
			subtype3prop: string
			
		structure Subtype4 extends Root
			ref4: reference to Subtype1
			
		structure Subtype5 extends Subtype4
		
		structure Manager
			multiFoo: string*
		
		structure Director extends Manager

'''
	}

	ZenModel model

	@Test
	def void testRootType() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Root") as Structure

		assertThat(datatype.primitiveProperties.size, equalTo(5))

		val rootProp1 = datatype.requireFeature("rootProp1") as PrimitiveProperty
		assertFalse(TagUtils::getTagWithName(rootProp1, TagUtils::PROPERTY_INHERITED).present)
		assertTrue(rootProp1.allConstraints.isEmpty)
		assertThat(rootProp1.minOccurs, equalTo(0))
		assertThat(rootProp1.maxOccurs, equalTo(-1))

		val rootProp2 = datatype.requireFeature("rootProp2") as PrimitiveProperty
		assertFalse(TagUtils::getTagWithName(rootProp2, TagUtils::PROPERTY_INHERITED).present)
		assertThat(rootProp2.documentation.text.trim, equalTo("documentation2"))

	}

	@Test
	def void testInheritedPropertyOrder() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype3") as Structure

		val propertyNames = datatype.primitiveProperties.map[it.name]
		assertThat(propertyNames,
			equalTo(
				#["subtype3prop", "subtype1prop", "rootProp1", "rootProp2", "rootProp3", "rootProp4", "rootProp5",
					"subtype2prop"]))
	}

	@Test
	def void testDirectSubtype() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure

		assertThat(datatype.primitiveProperties.size, equalTo(6))

		val rootProp1 = datatype.requireFeature("rootProp1") as PrimitiveProperty
		// assertFalse(TagUtils::getTagWithName(rootProp1, TagUtils::PROPERTY_INHERITED).present)
		val constraint = rootProp1.allConstraints.get(0) as LengthConstraint
		assertThat(constraint.minLength, equalTo(5))
		assertThat(constraint.maxLength, equalTo(15))
		assertThat(rootProp1.minOccurs, equalTo(0))
		assertThat(rootProp1.maxOccurs, equalTo(-1))

		val rootProp2 = datatype.requireFeature("rootProp2") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(rootProp2, TagUtils::PROPERTY_INHERITED).present)
		assertThat(rootProp2.documentation.text.trim, equalTo("documentation2"))

		val subtype1prop = datatype.requireFeature("subtype1prop") as PrimitiveProperty
		assertFalse(TagUtils::getTagWithName(subtype1prop, TagUtils::PROPERTY_INHERITED).present)

	}
	
	@Test
	def void testReadOnlyAttribute() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure

		assertThat(datatype.primitiveProperties.size, equalTo(6))

		assertFalse(datatype.requireFeature("rootProp1").isReadOnly)
		assertFalse(datatype.requireFeature("rootProp2").isReadOnly)
		assertFalse(datatype.requireFeature("rootProp4").isReadOnly)
		assertTrue(datatype.requireFeature("rootProp3").isReadOnly)
		assertTrue(datatype.requireFeature("rootProp5").isReadOnly)
	}
	
	@Test
	def void testKeyAttribute() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure

		assertThat(datatype.primitiveProperties.size, equalTo(6))

		assertFalse(datatype.requireFeature("rootProp1").isKey)
		assertFalse(datatype.requireFeature("rootProp2").isKey)
		assertFalse(datatype.requireFeature("rootProp3").isKey)
		assertTrue(datatype.requireFeature("rootProp4").isKey)
		assertTrue(datatype.requireFeature("rootProp5").isReadOnly)
	}
	
	@Test
	def void testDiamondSubtype() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype3") as Structure
		assertThat(datatype.primitiveProperties.size, equalTo(8))

		val rootProp1 = datatype.requireFeature("rootProp1") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(rootProp1, TagUtils::PROPERTY_INHERITED).present)
		val constraint1 = rootProp1.allConstraints.get(0) as LengthConstraint
		assertThat(constraint1.minLength, equalTo(5))
		assertThat(constraint1.maxLength, equalTo(15))

		val rootProp2 = datatype.requireFeature("rootProp2") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(rootProp2, TagUtils::PROPERTY_INHERITED).present)
		assertThat(rootProp2.documentation.text.trim, equalTo("documentation2"))
		val constraint2 = rootProp2.allConstraints.get(0) as LengthConstraint
		assertThat(constraint2.minLength, equalTo(6))
		assertThat(constraint2.maxLength, equalTo(7))

		val subtype1prop = datatype.requireFeature("subtype1prop") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(subtype1prop, TagUtils::PROPERTY_INHERITED).present)

		val subtype2prop = datatype.requireFeature("subtype2prop") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(subtype2prop, TagUtils::PROPERTY_INHERITED).present)

		val subtype3prop = datatype.requireFeature("subtype3prop") as PrimitiveProperty
		assertFalse(TagUtils::getTagWithName(subtype3prop, TagUtils::PROPERTY_INHERITED).present)

	}

	@Test
	def void testInheritedReferences() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype5") as Structure

		val rootProp1 = datatype.requireFeature("rootProp1") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(rootProp1, TagUtils::PROPERTY_INHERITED).present)
		assertTrue(rootProp1.allConstraints.isEmpty)

		val rootProp2 = datatype.requireFeature("rootProp2") as PrimitiveProperty
		assertTrue(TagUtils::getTagWithName(rootProp2, TagUtils::PROPERTY_INHERITED).present)
		assertThat(rootProp2.documentation.text.trim, equalTo("documentation2"))

		val ref4 = datatype.requireFeature("ref4") as ReferenceProperty
		assertTrue(TagUtils::getTagWithName(ref4, TagUtils::PROPERTY_INHERITED).present)

		assertThat(datatype.ownedFeatures.size, equalTo(6))
	}

	@Test
	def void testInheritedCardinality() {
		model = loadModelAndNormalize(textualModel())

		val datatype = model.firstInterfaceDataModel.requireDataType("Director") as Structure

		val multiProp1 = datatype.requireFeature("multiFoo") as PrimitiveProperty

		assertThat(multiProp1.minOccurs, equalTo(0))
		assertThat(multiProp1.maxOccurs, equalTo(-1))

		assertTrue(TagUtils::getTagWithName(multiProp1, TagUtils::PROPERTY_INHERITED).present)
		assertTrue(multiProp1.allConstraints.isEmpty)
	}

	@Test
	def void testDocumentation() {
		val modelText = '''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure Type1
			/** documentation 1 */
			prop1 : string
			/** documentation 2 */
			prop2 : string
			/** documentation 3 */
			prop3 : string
	
		structure Type2 extends Type1 
			restrict prop1: string
			/** restrict 2 */
			restrict prop2: string
			 
		structure Type3 extends Type1 
			/** restict 3 */
			restrict prop3: string

		structure Type4 extends Type3, Type2
			restrict prop1: string
			restrict prop2: string
			/** Type3 restrict 3 */
			restrict prop3: string			
'''
		model = loadModelAndNormalize(modelText)

		val datatype = model.firstInterfaceDataModel.requireDataType("Type4") as Structure

		val prop1 = datatype.requireFeature("prop1") as PrimitiveProperty
		assertThat(prop1.documentation.text.trim, equalTo("documentation 1"))

		val prop2 = datatype.requireFeature("prop2") as PrimitiveProperty
		assertThat(prop2.documentation.text.trim, equalTo("restrict 2"))

		val prop3 = datatype.requireFeature("prop3") as PrimitiveProperty
		assertThat(prop3.documentation.text.trim, equalTo("Type3 restrict 3"))

	}

	@Test
	def void testContainer() {
		val modelText = '''
rapidModel InheritedProperties

	dataModel InheritedProperties2
		
		structure Supertype1
			containerRef: container reference Supertype2
		
		structure Supertype2
			
		structure Subtype1 extends Supertype1
'''
		model = loadModelAndNormalize(modelText)

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure

		val prop1 = datatype.requireFeature("containerRef") as ReferenceProperty
		assertTrue(prop1.container)
		assertFalse(prop1.containment)
		assertNull(prop1.inverse)
	}

	@Test
	def void testContaining() {
		val modelText = '''
rapidModel InheritedProperties

	dataModel InheritedProperties2
		
		structure Supertype1
			containingRef: containing reference Supertype2
		
		structure Supertype2
			
		structure Subtype1 extends Supertype1
'''
		model = loadModelAndNormalize(modelText)

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure

		val prop1 = datatype.requireFeature("containingRef") as ReferenceProperty
		assertFalse(prop1.container)
		assertTrue(prop1.containment)
		assertNull(prop1.inverse)
	}

	@Test
	def void testInverse() {
		val modelText = '''
rapidModel InheritedProperties

	dataModel InheritedProperties2
		
		structure Supertype1
			refToSupertype2 : reference Supertype2 inverse refToSupertype1
		
		structure Supertype2
			refToSupertype1 : reference Supertype1 inverse refToSupertype2
			
		structure Subtype1 extends Supertype1

		structure Subtype2 extends Supertype2
'''
		model = loadModelAndNormalize(modelText)

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure
		val prop1 = datatype.requireFeature("refToSupertype2") as ReferenceProperty
		assertFalse(prop1.container)
		assertFalse(prop1.containment)
		assertNotNull(prop1.inverse)
		assertEquals("refToSupertype1", prop1.inverse.name)

		val datatype2 = model.firstInterfaceDataModel.requireDataType("Subtype2") as Structure
		val prop2 = datatype2.requireFeature("refToSupertype1") as ReferenceProperty
		assertFalse(prop2.container)
		assertFalse(prop2.containment)
		assertNotNull(prop2.inverse)
		assertEquals("refToSupertype2", prop2.inverse.name)
	}

	@Test
	def void testExtensions() {
		val modelText = '''
rapidModel InheritedProperties

	dataModel InheritedProperties2
		
		structure Supertype1
			ref1: reference Supertype2
				extensions
					ext1: value1
			ref2: reference Supertype2
				extensions
					ext2: value2
		
		structure Supertype2
			
		structure Subtype1 extends Supertype1
			restrict ref2: reference to Supertype2
				extensions
					ext2: value2override
					ext3: value3
'''
		model = loadModelAndNormalize(modelText)

		val datatype = model.firstInterfaceDataModel.requireDataType("Subtype1") as Structure

		val prop1 = datatype.requireFeature("ref1") as ReferenceProperty
		val ext1 = prop1.extensions.get(1)// the first one is "gen-inherited"
		assertEquals("ext1", ext1.name)
		assertEquals("value1", ext1.value)
		
		val prop2 = datatype.requireFeature("ref2") as ReferenceProperty

		val ext2 = prop2.extensions.get(0)
		assertEquals("ext2", ext2.name)
		assertEquals("value2override", ext2.value)

		val ext3 = prop2.extensions.get(1)
		assertEquals("ext3", ext3.name)
		assertEquals("value3", ext3.value)
		
	}

}
