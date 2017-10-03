package com.uc.web.forms.ui.flot;

import java.util.List;

public interface PlotSeriesCollection extends List<PlotSeries>, PlotValue {
	default PlotSeriesCollection addSeries(PlotSeries series){
		add(series);
		return this;
	}
	default	PlotSeries[] getValue(){
		return toArray(new PlotSeries[size()]);
	}
}
