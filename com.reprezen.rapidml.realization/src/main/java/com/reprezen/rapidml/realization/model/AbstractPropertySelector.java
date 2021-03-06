package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;

public interface AbstractPropertySelector extends Base {

	// ReadWritability
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	ReadWriteSelector getReadWritability();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	ReadWriteSelector getReadWritability(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setReadWritability(ReadWriteSelector readWritability);

	// Multiplicity
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MultiplicitySelector getMultiplicity();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MultiplicitySelector getMultiplicity(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMultiplicity(MultiplicitySelector multiplicity);

	// Required
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getRequired();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isRequired();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequired(Boolean required);
}
