package com.reprezen.rapidml.realization.model;

import java.util.List;

import javax.annotation.Generated;

public interface ExclusivePropertySet extends PropertySet {

	// IncludedProperty
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	List<PropertyRealization> getIncludedProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	List<PropertyRealization> getIncludedProperties(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasIncludedProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertyRealization getIncludedProperty(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setIncludedProperties(List<PropertyRealization> includedProperties);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setIncludedProperty(int index, PropertyRealization includedProperty);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addIncludedProperty(PropertyRealization includedProperty);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertIncludedProperty(int index, PropertyRealization includedProperty);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeIncludedProperty(int index);
}
