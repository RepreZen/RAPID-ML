package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;

public interface ConditionalPropertySet extends PropertySet, ConditionedItem {

	// Where
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Conditions getWhere();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Conditions getWhere(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setWhere(Conditions where);

	// PropertySet
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertySet getPropertySet();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertySet getPropertySet(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setPropertySet(PropertySet propertySet);
}
