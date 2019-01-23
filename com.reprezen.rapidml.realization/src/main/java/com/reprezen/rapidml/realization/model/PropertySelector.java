package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;

public interface PropertySelector extends AbstractPropertySelector {

	// PropertyType
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertyTypeSelector getPropertyType();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertyTypeSelector getPropertyType(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setPropertyType(PropertyTypeSelector propertyType);
}
