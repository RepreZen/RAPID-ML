/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Maps
import com.google.common.collect.Sets
import com.reprezen.jsonoverlay.Overlay
import com.reprezen.rapidml.RealizationContainer
import com.reprezen.rapidml.ReferenceRealization
import com.reprezen.rapidml.ResourceDefinition
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.realization.model.RealizationRule
import com.reprezen.rapidml.realization.processor.EffectiveRealizationRegistry.EffectiveRealizationKey
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.Set
import junit.framework.AssertionFailedError
import org.junit.Assert
import org.junit.rules.ErrorCollector

abstract class ModelChecker<T> extends Assert {

	val protected ErrorCollector errors
	val private Map<String, T> bookmarks = Maps.newHashMap
	val private Map<String, (RootChecker<T>)=>void> bookmarkedCode = Maps.newHashMap
	var private T root

	new(ErrorCollector errors) {
		this.errors = errors
	}

	var private boolean ranDone = false

	def final void done() {
		if (!ranDone) {
			_done
		}
		ranDone = true
	}

	def protected void _done() {
	}

	def getErrors() {
		errors
	}

	def getBookmarks() {
		bookmarks
	}

	def getRoot() {
		root
	}

	def check(RealizationContainer rznContainer, (RootChecker<T>)=>void code) {
		if (rznContainer == null) {
			errors.addError(new IllegalArgumentException("Attempted to check null realization container"))
		} else if (rznContainer instanceof ReferenceRealization) {
			errors.addError(
				new IllegalArgumentException("Reference realization cannot be used as a root for model checker"))
		} else {
			this.root = rznContainer.realization
			if (root != null) {
				this.createRootChecker(root, this, code).exec
				this.root = null
			} else {
				errors.addError(new IllegalStateException("No realiazation value to check from realization container"))
			}
		}
		return this
	}

	def check(ResourceDefinition resource, (RootChecker<T>)=>void code) {
		return check((resource as ServiceDataResource) as RealizationContainer, code)
	}

	def abstract T getRealization(RealizationContainer rznContainer)

	def abstract String getRealizationName(T rzn)

	def thenCheck(RealizationContainer rzn, (RootChecker<T>)=>void code) {
		check(rzn, code)
	}

	def thenCheck(ResourceDefinition resource, (RootChecker<T>)=>void code) {
		check(resource, code)
	}

	def abstract RootChecker<T> createRootChecker(T rzn, ModelChecker<T> base, (RootChecker<T>)=>void code)

	static abstract class RootChecker<T> extends Assert {
		var protected T rzn
		var protected ModelChecker<T> base
		var protected (RootChecker<T>)=>void code
		var protected Set<String> checkedLinks = Sets.newHashSet

		new(T rzn, ModelChecker<T> base, (RootChecker<T>)=>void code) {
			this.rzn = rzn
			this.base = base
			this.code = code
		}

		def getErrors() {
			base.errors
		}

		def getBookmarks() {
			base.bookmarks
		}

		def getRoot() {
			base.root
		}

		def exec() {
			code.apply(this)
			return base
		}

		def bookmark(String tag) {
			if (!bookmarks.containsKey(tag)) {
				bookmarks.put(tag, rzn)
				base.bookmarkedCode.put(tag, code)
			}
			// otherwise we're probably replaying on a failed identity check
			return this
		}

		def shares(String tag) {
			return shares(tag, null)
		}

		def shares(String tag, String instance) {
			var boolean unshared = false
			if (bookmarks.containsKey(tag)) {
				try {
					assertTrue(sharesRealization(this.rzn, bookmarks.get(tag)))
				} catch (Throwable t) {
					unshared = true
				}
			} else {
				try {
					fail('''No bookmarked realization with tag "«tag»"''')
				} catch (Throwable t) {
					errors.addError(t)
				}
			}
			if (unshared) {
				val instanceLabel = if (instance != null) ''' («instance»)''' else ""
				try {
					errors.addError(
						new AssertionFailedError(''' Shared realization tagged "«tag»"«instanceLabel» is different object, applying same tests to this realization'''))
					tryBookmarkedCode(
						tag)
					println('''Realization passed same tests as realization that created bookmark "«tag»"«instanceLabel»"''')
				} catch (Throwable t) {
					println('''Realization failed some tests for realization that created bookmark "«tag»"«instanceLabel»''')
				}
			}
			return this
		}

		def boolean sharesRealization(T current, T bookmarked) {
			current === bookmarked
		}

		def private tryBookmarkedCode(String tag) {
			base.bookmarkedCode.get(tag)?.apply(this)
		}

		def named(String name) {
			try {
				assertEquals("Incorrect realization name", name, rzn.getRealizationName)
			} catch (Throwable t) {
				errors.addError(t)
			}
			return this
		}

		def void withProps((PropertiesChecker<T>)=>void code) {
			createPropertiesChecker(base, rzn, code).exec
		}

		def withOnlyProps(String... props) {
			withProps[including(props).checkedAll]
		}

		def withNoProps() {
			withOnlyProps
		}

		def abstract PropertiesChecker<T> createPropertiesChecker(ModelChecker<T> base, T rzn,
			(PropertiesChecker<T>)=>void code)

		def withLinks(String... links) {
			val allLinks = getAllLinks.removeWhitespace
			for (link : links) {
				checkedLinks.add(link)
				val found = allLinks.contains(link.removeWhitespace)
				if (link.removeWhitespace.exempt) {
					if (!found) {
						link.announceExempt
					}
				} else {
					try {
						assertTrue('''«rzn.realizationName»: Missing link «link»''', found)
					} catch (Throwable t) {
						errors.addError(t)
					}
				}
			}
			return this
		}

		def withLink(String link) {
			return withLinks(link)
		}

		def withOnlyLinks(String... links) {
			return withLinks(links).checkedAllLinks
		}

		def withOnlyLink(String link) {
			return withOnlyLinks(link)
		}

		def withNoLinks() {
			return checkedAllLinks
		}

		def getRealizationName(T rzn) {
			base.getRealizationName(rzn)
		}

		def abstract List<String> getAllLinks()

		def isExempt(String link) {
			return false
		}

		def announceExempt(String link) {
		}

		def private removeWhitespace(String string) {
			return string.replaceAll("\\s+", "")
		}

		def private removeWhitespace(List<String> strings) {
			return strings.map[removeWhitespace]
		}

		def public checkedAllLinks() {
			for (link : allLinks) {
				try {
					assertTrue('''«rzn.realizationName»: Link «link» unchecked''', checkedLinks.contains(link))
				} catch (Throwable t) {
					errors.addError(t)
				}
			}
			return this
		}

		def selects(String ruleName) {
			val rule = matchingRule
			try {
				assertEquals('''«rzn.realizationName»: Incorrect realization rule selected''', ruleName,
					Overlay.of(rule).pathInParent)
			} catch (Throwable t) {
				errors.addError(t)
			}
			return this
		}

		def abstract RealizationRule getMatchingRule()
	}

	static abstract class PropertiesChecker<T> extends Assert {

		val protected ModelChecker<T> base
		val protected T rzn
		val protected (PropertiesChecker<T>)=>void code
		val protected Set<String> checked = Sets.newHashSet
		val protected Set<String> checkedRef = Sets.newHashSet

		new(ModelChecker<T> base, T rzn, (PropertiesChecker<T>)=>void code) {
			this.base = base
			this.rzn = rzn
			this.code = code
		}

		def void exec() {
			code.apply(this)
		}

		def including(String... propNames) {
			for (propName : propNames) {
				try {
					assertTrue('''«rzn.realizationName»: Missing property: «propName»''', propName.propertyExists)
					checked.add(propName)
				} catch (Throwable t) {
					base.errors.addError(t)
				}
			}
			return this
		}

		def getRealizationName(T rzn) {
			base.getRealizationName(rzn)
		}

		def abstract boolean propertyExists(String propName)

		def includingRef(String propName, (RootChecker<T>)=>void code) {
			including(propName)
			checkedRef.add(propName)
			val propRzn = propName.propRealization
			try {
				assertNotNull('''«rzn.realizationName»: Missing reference realization: «propName»''', propRzn)
				base.createRootChecker(propRzn, base, code).exec
			} catch (Throwable t) {
				base.errors.addError(t)
			}
			return this
		}

		def abstract T getPropRealization(String propName)

		def checkedAll() {
			val allPropNames = allPropertyNames
			for (propName : allPropNames) {
				if (!checked.contains(propName)) {
					try {
						fail('''«rzn.realizationName»: Unchecked property: «propName»''')
					} catch (Throwable t) {
						base.errors.addError(t)
					}
				}
			}
			for (propName : allPropNames.filter[it.propRealization != null]) {
				if (!checkedRef.contains(propName)) {
					try {
						fail('''«rzn.realizationName»: Ref prop's realization unchecked: «propName»''')
					} catch (Throwable t) {
						base.errors.addError(t)
					}
				}
			}
			return this
		}

		def abstract Collection<String> getAllPropertyNames()

		def size(int n) {
			try {
				assertEquals('''«rzn.realizationName»: Wrong number of properties''', n, propertiesSize)
			} catch (Throwable t) {
				base.errors.addError(t)
			}
			return this
		}

		def abstract int getPropertiesSize()

	}

}

class NameCollisionException extends RuntimeException {
	val String name
	val List<EffectiveRealizationKey> keys

	new(String name, List<EffectiveRealizationKey> keys) {
		this.name = name
		this.keys = keys
	}

	def getName() {
		return name
	}

	def getKeys() {
		return keys
	}

	def matches(String name, List<String> keyStrings) {
		return this.name == name && keyStrings.toSet == keys.map[toString].toSet
	}
}
