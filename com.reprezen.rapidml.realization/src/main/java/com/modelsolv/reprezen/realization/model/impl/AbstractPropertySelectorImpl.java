package com.modelsolv.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.modelsolv.reprezen.realization.model.impl.ReadWriteSelectorImpl;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.modelsolv.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.modelsolv.reprezen.realization.model.impl.MultiplicitySelectorImpl;
import com.reprezen.jsonoverlay.OverlayFactory;

public class AbstractPropertySelectorImpl extends BaseImpl implements AbstractPropertySelector {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public AbstractPropertySelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public AbstractPropertySelectorImpl(AbstractPropertySelector abstractPropertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(abstractPropertySelector, parent, refMgr);
    }

    // ReadWritability
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReadWriteSelector getReadWritability() {
        return _get("readWritability", ReadWriteSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReadWriteSelector getReadWritability(boolean elaborate) {
        return _get("readWritability", elaborate, ReadWriteSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setReadWritability(ReadWriteSelector readWritability) {
        _setScalar("readWritability", readWritability, ReadWriteSelector.class);
    }

    // Multiplicity
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MultiplicitySelector getMultiplicity() {
        return _get("multiplicity", MultiplicitySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MultiplicitySelector getMultiplicity(boolean elaborate) {
        return _get("multiplicity", elaborate, MultiplicitySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setMultiplicity(MultiplicitySelector multiplicity) {
        _setScalar("multiplicity", multiplicity, MultiplicitySelector.class);
    }

    // Required
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Boolean getRequired() {
        return _get("required", Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean isRequired() {
        Boolean bool = _get("required", Boolean.class);
        return bool != null ? bool : false;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRequired(Boolean required) {
        _setScalar("required", required, Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("readWritability", "readWritability", ReadWriteSelectorImpl.factory);
        _createScalar("multiplicity", "multiplicity", MultiplicitySelectorImpl.factory);
        _createScalar("required", "isRequired", BooleanOverlay.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<AbstractPropertySelector> factory = new OverlayFactory<AbstractPropertySelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super AbstractPropertySelector>> getOverlayClass() {
            return AbstractPropertySelectorImpl.class;
        }

        @Override
        public JsonOverlay<AbstractPropertySelector> _create(AbstractPropertySelector abstractPropertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends AbstractPropertySelector> subtype = getSubtypeOf(abstractPropertySelector);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "PropertyRealization":
                    overlay = PropertyRealizationImpl.factory.create((PropertyRealization) abstractPropertySelector, parent, refMgr);
                    break;
                case "PropertySelector":
                    overlay = PropertySelectorImpl.factory.create((PropertySelector) abstractPropertySelector, parent, refMgr);
                    break;
                default:
                    overlay = new AbstractPropertySelectorImpl((AbstractPropertySelector) abstractPropertySelector, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<AbstractPropertySelector> castOverlay = (JsonOverlay<AbstractPropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<AbstractPropertySelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends AbstractPropertySelector> subtype = getSubtypeOf(json);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "PropertyRealization":
                    overlay = PropertyRealizationImpl.factory.create(json, parent, refMgr);
                    break;
                case "PropertySelector":
                    overlay = PropertySelectorImpl.factory.create(json, parent, refMgr);
                    break;
                default:
                    overlay = new AbstractPropertySelectorImpl(json, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<AbstractPropertySelector> castOverlay = (JsonOverlay<AbstractPropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return true;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends AbstractPropertySelector> getSubtypeOf(AbstractPropertySelector abstractPropertySelector) {
        switch(abstractPropertySelector.getClass().getSimpleName()) {
            case "PropertyRealization":
                return PropertyRealization.class;
            case "PropertySelector":
                return PropertySelector.class;
            default:
                return null;
        }
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends AbstractPropertySelector> getSubtypeOf(JsonNode json) {
        switch(json.at(JsonPointer.compile("/_type")).asText()) {
            case "PropertyRealization":
                return PropertyRealization.class;
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
