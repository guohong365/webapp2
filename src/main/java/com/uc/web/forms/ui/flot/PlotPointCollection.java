package com.uc.web.forms.ui.flot;

import java.util.List;

public interface PlotPointCollection extends List<PlotPoint>, PlotValue {
	@Override
	default Object getValue() {
		return toArray(new PlotPoint[size()]);
	}

}
