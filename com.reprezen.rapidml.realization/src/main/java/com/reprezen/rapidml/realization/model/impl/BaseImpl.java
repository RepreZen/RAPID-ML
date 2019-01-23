package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.rapidml.realization.model.AbstractPropertySelector;
import com.reprezen.rapidml.realization.model.Base;
import com.reprezen.rapidml.realization.model.ConditionalLink;
import com.reprezen.rapidml.realization.model.ConditionalPropertySet;
import com.reprezen.rapidml.realization.model.Conditions;
import com.reprezen.rapidml.realization.model.ContextPattern;
import com.reprezen.rapidml.realization.model.DefinitionContext;
import com.reprezen.rapidml.realization.model.ExclusivePropertySet;
import com.reprezen.rapidml.realization.model.InclusivePropertySet;
import com.reprezen.rapidml.realization.model.LinkSpec;
import com.reprezen.rapidml.realization.model.LinkStrategy;
import com.reprezen.rapidml.realization.model.LinkSwitch;
import com.reprezen.rapidml.realization.model.MessageDefinitionContext;
import com.reprezen.rapidml.realization.model.ObjectRealizationSpec;
import com.reprezen.rapidml.realization.model.ObjectRealizationStrategy;
import com.reprezen.rapidml.realization.model.PrimitivePropertyRealization;
import com.reprezen.rapidml.realization.model.PrimitivePropertySelector;
import com.reprezen.rapidml.realization.model.PropertyRealization;
import com.reprezen.rapidml.realization.model.PropertySelector;
import com.reprezen.rapidml.realization.model.PropertySet;
import com.reprezen.rapidml.realization.model.PropertySetSwitch;
import com.reprezen.rapidml.realization.model.PropertyTypeRealization;
import com.reprezen.rapidml.realization.model.PropertyTypeSelector;
import com.reprezen.rapidml.realization.model.RealizationModel;
import com.reprezen.rapidml.realization.model.RealizationRule;
import com.reprezen.rapidml.realization.model.ReferenceLevelContext;
import com.reprezen.rapidml.realization.model.ReferencePropertyContext;
import com.reprezen.rapidml.realization.model.ReferencePropertyRealization;
import com.reprezen.rapidml.realization.model.ReferencePropertySelector;
import com.reprezen.rapidml.realization.model.ResourceDefinitionContext;
import com.reprezen.rapidml.realization.model.RootObjectContext;

public class BaseImpl extends PropertiesOverlay<Base> implements Base {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public BaseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public BaseImpl(Base base, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(base, parent, factory, refMgr);
	}

	// Documentation
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDocumentation() {
		return _get("documentation", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDocumentation(String documentation) {
		_setScalar("documentation", documentation, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("documentation", "_documentation", StringOverlay.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Base> factory = new OverlayFactory<Base>() {

		@Override
		protected Class<? extends JsonOverlay<? super Base>> getOverlayClass() {
			return BaseImpl.class;
		}

		@Override
		public JsonOverlay<Base> _create(Base base, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends Base> subtype = getSubtypeOf(base);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "LinkStrategy":
				overlay = LinkStrategyImpl.factory.create((LinkStrategy) base, parent, refMgr);
				break;
			case "ReferencePropertyContext":
				overlay = ReferencePropertyContextImpl.factory.create((ReferencePropertyContext) base, parent, refMgr);
				break;
			case "PrimitivePropertySelector":
				overlay = PrimitivePropertySelectorImpl.factory.create((PrimitivePropertySelector) base, parent,
						refMgr);
				break;
			case "DefinitionContext":
				overlay = DefinitionContextImpl.factory.create((DefinitionContext) base, parent, refMgr);
				break;
			case "ObjectRealizationStrategy":
				overlay = ObjectRealizationStrategyImpl.factory.create((ObjectRealizationStrategy) base, parent,
						refMgr);
				break;
			case "ConditionalLink":
				overlay = ConditionalLinkImpl.factory.create((ConditionalLink) base, parent, refMgr);
				break;
			case "ConditionalPropertySet":
				overlay = ConditionalPropertySetImpl.factory.create((ConditionalPropertySet) base, parent, refMgr);
				break;
			case "AbstractPropertySelector":
				overlay = AbstractPropertySelectorImpl.factory.create((AbstractPropertySelector) base, parent, refMgr);
				break;
			case "PropertySetSwitch":
				overlay = PropertySetSwitchImpl.factory.create((PropertySetSwitch) base, parent, refMgr);
				break;
			case "PropertyRealization":
				overlay = PropertyRealizationImpl.factory.create((PropertyRealization) base, parent, refMgr);
				break;
			case "RootObjectContext":
				overlay = RootObjectContextImpl.factory.create((RootObjectContext) base, parent, refMgr);
				break;
			case "ResourceDefinitionContext":
				overlay = ResourceDefinitionContextImpl.factory.create((ResourceDefinitionContext) base, parent,
						refMgr);
				break;
			case "ReferencePropertyRealization":
				overlay = ReferencePropertyRealizationImpl.factory.create((ReferencePropertyRealization) base, parent,
						refMgr);
				break;
			case "ContextPattern":
				overlay = ContextPatternImpl.factory.create((ContextPattern) base, parent, refMgr);
				break;
			case "PrimitivePropertyRealization":
				overlay = PrimitivePropertyRealizationImpl.factory.create((PrimitivePropertyRealization) base, parent,
						refMgr);
				break;
			case "ObjectRealizationSpec":
				overlay = ObjectRealizationSpecImpl.factory.create((ObjectRealizationSpec) base, parent, refMgr);
				break;
			case "InclusivePropertySet":
				overlay = InclusivePropertySetImpl.factory.create((InclusivePropertySet) base, parent, refMgr);
				break;
			case "LinkSpec":
				overlay = LinkSpecImpl.factory.create((LinkSpec) base, parent, refMgr);
				break;
			case "PropertyTypeSelector":
				overlay = PropertyTypeSelectorImpl.factory.create((PropertyTypeSelector) base, parent, refMgr);
				break;
			case "PropertySet":
				overlay = PropertySetImpl.factory.create((PropertySet) base, parent, refMgr);
				break;
			case "ReferenceLevelContext":
				overlay = ReferenceLevelContextImpl.factory.create((ReferenceLevelContext) base, parent, refMgr);
				break;
			case "MessageDefinitionContext":
				overlay = MessageDefinitionContextImpl.factory.create((MessageDefinitionContext) base, parent, refMgr);
				break;
			case "LinkSwitch":
				overlay = LinkSwitchImpl.factory.create((LinkSwitch) base, parent, refMgr);
				break;
			case "ExclusivePropertySet":
				overlay = ExclusivePropertySetImpl.factory.create((ExclusivePropertySet) base, parent, refMgr);
				break;
			case "Conditions":
				overlay = ConditionsImpl.factory.create((Conditions) base, parent, refMgr);
				break;
			case "ReferencePropertySelector":
				overlay = ReferencePropertySelectorImpl.factory.create((ReferencePropertySelector) base, parent,
						refMgr);
				break;
			case "RealizationRule":
				overlay = RealizationRuleImpl.factory.create((RealizationRule) base, parent, refMgr);
				break;
			case "RealizationModel":
				overlay = RealizationModelImpl.factory.create((RealizationModel) base, parent, refMgr);
				break;
			case "PropertyTypeRealization":
				overlay = PropertyTypeRealizationImpl.factory.create((PropertyTypeRealization) base, parent, refMgr);
				break;
			case "PropertySelector":
				overlay = PropertySelectorImpl.factory.create((PropertySelector) base, parent, refMgr);
				break;
			default:
				overlay = new BaseImpl((Base) base, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<Base> castOverlay = (JsonOverlay<Base>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Base> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends Base> subtype = getSubtypeOf(json);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "LinkStrategy":
				overlay = LinkStrategyImpl.factory.create(json, parent, refMgr);
				break;
			case "ReferencePropertyContext":
				overlay = ReferencePropertyContextImpl.factory.create(json, parent, refMgr);
				break;
			case "PrimitivePropertySelector":
				overlay = PrimitivePropertySelectorImpl.factory.create(json, parent, refMgr);
				break;
			case "DefinitionContext":
				overlay = DefinitionContextImpl.factory.create(json, parent, refMgr);
				break;
			case "ObjectRealizationStrategy":
				overlay = ObjectRealizationStrategyImpl.factory.create(json, parent, refMgr);
				break;
			case "ConditionalLink":
				overlay = ConditionalLinkImpl.factory.create(json, parent, refMgr);
				break;
			case "ConditionalPropertySet":
				overlay = ConditionalPropertySetImpl.factory.create(json, parent, refMgr);
				break;
			case "AbstractPropertySelector":
				overlay = AbstractPropertySelectorImpl.factory.create(json, parent, refMgr);
				break;
			case "PropertySetSwitch":
				overlay = PropertySetSwitchImpl.factory.create(json, parent, refMgr);
				break;
			case "PropertyRealization":
				overlay = PropertyRealizationImpl.factory.create(json, parent, refMgr);
				break;
			case "RootObjectContext":
				overlay = RootObjectContextImpl.factory.create(json, parent, refMgr);
				break;
			case "ResourceDefinitionContext":
				overlay = ResourceDefinitionContextImpl.factory.create(json, parent, refMgr);
				break;
			case "ReferencePropertyRealization":
				overlay = ReferencePropertyRealizationImpl.factory.create(json, parent, refMgr);
				break;
			case "ContextPattern":
				overlay = ContextPatternImpl.factory.create(json, parent, refMgr);
				break;
			case "PrimitivePropertyRealization":
				overlay = PrimitivePropertyRealizationImpl.factory.create(json, parent, refMgr);
				break;
			case "ObjectRealizationSpec":
				overlay = ObjectRealizationSpecImpl.factory.create(json, parent, refMgr);
				break;
			case "InclusivePropertySet":
				overlay = InclusivePropertySetImpl.factory.create(json, parent, refMgr);
				break;
			case "LinkSpec":
				overlay = LinkSpecImpl.factory.create(json, parent, refMgr);
				break;
			case "PropertyTypeSelector":
				overlay = PropertyTypeSelectorImpl.factory.create(json, parent, refMgr);
				break;
			case "PropertySet":
				overlay = PropertySetImpl.factory.create(json, parent, refMgr);
				break;
			case "ReferenceLevelContext":
				overlay = ReferenceLevelContextImpl.factory.create(json, parent, refMgr);
				break;
			case "MessageDefinitionContext":
				overlay = MessageDefinitionContextImpl.factory.create(json, parent, refMgr);
				break;
			case "LinkSwitch":
				overlay = LinkSwitchImpl.factory.create(json, parent, refMgr);
				break;
			case "ExclusivePropertySet":
				overlay = ExclusivePropertySetImpl.factory.create(json, parent, refMgr);
				break;
			case "Conditions":
				overlay = ConditionsImpl.factory.create(json, parent, refMgr);
				break;
			case "ReferencePropertySelector":
				overlay = ReferencePropertySelectorImpl.factory.create(json, parent, refMgr);
				break;
			case "RealizationRule":
				overlay = RealizationRuleImpl.factory.create(json, parent, refMgr);
				break;
			case "RealizationModel":
				overlay = RealizationModelImpl.factory.create(json, parent, refMgr);
				break;
			case "PropertyTypeRealization":
				overlay = PropertyTypeRealizationImpl.factory.create(json, parent, refMgr);
				break;
			case "PropertySelector":
				overlay = PropertySelectorImpl.factory.create(json, parent, refMgr);
				break;
			default:
				overlay = new BaseImpl(json, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<Base> castOverlay = (JsonOverlay<Base>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return true;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Base> getSubtypeOf(Base base) {
		switch (base.getClass().getSimpleName()) {
		case "LinkStrategy":
			return LinkStrategy.class;
		case "ReferencePropertyContext":
			return ReferencePropertyContext.class;
		case "PrimitivePropertySelector":
			return PrimitivePropertySelector.class;
		case "DefinitionContext":
			return DefinitionContext.class;
		case "ObjectRealizationStrategy":
			return ObjectRealizationStrategy.class;
		case "ConditionalLink":
			return ConditionalLink.class;
		case "ConditionalPropertySet":
			return ConditionalPropertySet.class;
		case "AbstractPropertySelector":
			return AbstractPropertySelector.class;
		case "PropertySetSwitch":
			return PropertySetSwitch.class;
		case "PropertyRealization":
			return PropertyRealization.class;
		case "RootObjectContext":
			return RootObjectContext.class;
		case "Base":
			return Base.class;
		case "ResourceDefinitionContext":
			return ResourceDefinitionContext.class;
		case "ReferencePropertyRealization":
			return ReferencePropertyRealization.class;
		case "ContextPattern":
			return ContextPattern.class;
		case "PrimitivePropertyRealization":
			return PrimitivePropertyRealization.class;
		case "ObjectRealizationSpec":
			return ObjectRealizationSpec.class;
		case "InclusivePropertySet":
			return InclusivePropertySet.class;
		case "LinkSpec":
			return LinkSpec.class;
		case "PropertyTypeSelector":
			return PropertyTypeSelector.class;
		case "PropertySet":
			return PropertySet.class;
		case "ReferenceLevelContext":
			return ReferenceLevelContext.class;
		case "MessageDefinitionContext":
			return MessageDefinitionContext.class;
		case "LinkSwitch":
			return LinkSwitch.class;
		case "ExclusivePropertySet":
			return ExclusivePropertySet.class;
		case "Conditions":
			return Conditions.class;
		case "ReferencePropertySelector":
			return ReferencePropertySelector.class;
		case "RealizationRule":
			return RealizationRule.class;
		case "RealizationModel":
			return RealizationModel.class;
		case "PropertyTypeRealization":
			return PropertyTypeRealization.class;
		case "PropertySelector":
			return PropertySelector.class;
		default:
			return null;
		}
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Base> getSubtypeOf(JsonNode json) {
		switch (json.at(JsonPointer.compile("/_type")).asText()) {
		case "LinkStrategy":
			return LinkStrategy.class;
		case "ReferencePropertyContext":
			return ReferencePropertyContext.class;
		case "PrimitivePropertySelector":
			return PrimitivePropertySelector.class;
		case "DefinitionContext":
			return DefinitionContext.class;
		case "ObjectRealizationStrategy":
			return ObjectRealizationStrategy.class;
		case "conditional":
			return ConditionalLink.class;
		case "ConditionalPropertySet":
			return ConditionalPropertySet.class;
		case "AbstractPropertySelector":
			return AbstractPropertySelector.class;
		case "PropertySetSwitch":
			return PropertySetSwitch.class;
		case "PropertyRealization":
			return PropertyRealization.class;
		case "RootObjectContext":
			return RootObjectContext.class;
		case "Base":
			return Base.class;
		case "ResourceDefinitionContext":
			return ResourceDefinitionContext.class;
		case "ReferencePropertyRealization":
			return ReferencePropertyRealization.class;
		case "ContextPattern":
			return ContextPattern.class;
		case "PrimitivePropertyRealization":
			return PrimitivePropertyRealization.class;
		case "ObjectRealizationSpec":
			return ObjectRealizationSpec.class;
		case "InclusivePropertySet":
			return InclusivePropertySet.class;
		case "specification":
			return LinkSpec.class;
		case "PropertyTypeSelector":
			return PropertyTypeSelector.class;
		case "PropertySet":
			return PropertySet.class;
		case "ReferenceLevelContext":
			return ReferenceLevelContext.class;
		case "MessageDefinitionContext":
			return MessageDefinitionContext.class;
		case "switch":
			return LinkSwitch.class;
		case "ExclusivePropertySet":
			return ExclusivePropertySet.class;
		case "Conditions":
			return Conditions.class;
		case "ReferencePropertySelector":
			return ReferencePropertySelector.class;
		case "RealizationRule":
			return RealizationRule.class;
		case "RealizationModel":
			return RealizationModel.class;
		case "PropertyTypeRealization":
			return PropertyTypeRealization.class;
		case "PropertySelector":
			return PropertySelector.class;
		default:
			return null;
		}
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}
}
