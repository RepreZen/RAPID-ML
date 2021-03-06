package com.reprezen.rapidml.realization.model;

import java.util.List;

import javax.annotation.Generated;

public interface ObjectRealizationSpec extends ObjectRealizationStrategy {

	// PropertySet
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertySet getPropertySet();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	PropertySet getPropertySet(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setPropertySet(PropertySet propertySet);

	// Link
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	List<LinkStrategy> getLinks();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	List<LinkStrategy> getLinks(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasLinks();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	LinkStrategy getLink(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setLinks(List<LinkStrategy> links);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setLink(int index, LinkStrategy link);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addLink(LinkStrategy link);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertLink(int index, LinkStrategy link);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeLink(int index);
}
