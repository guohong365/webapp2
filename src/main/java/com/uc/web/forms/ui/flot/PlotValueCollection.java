package com.uc.web.forms.ui.flot;

import java.util.List;

public interface PlotValueCollection extends List<PlotValue>, PlotValue {
	default PlotValueCollection addValue(Object value){
		add(value instanceof PlotValue ? (PlotValue)value : new PlotValueImpl(value));
		return this;
	}
	@Override
	default Object getValue() {
		return toArray(new Object[size()]);
	}
}
