package com.uc.web.forms.ui.flot.line;

import com.uc.web.forms.ui.flot.PlotSeriesCollection;
import com.uc.web.forms.ui.flot.PlotValue;
import com.uc.web.forms.ui.flot.PlotChartImpl;
import com.uc.web.forms.ui.flot.PlotItem;

public class LineChartImpl extends PlotChartImpl implements LineChart {
	public LineChartImpl(PlotValue dataSet, PlotItem options) {
		super(dataSet, options);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PlotSeriesCollection getDataSet() {
		return (PlotSeriesCollection) super.getDataSet();
	}

	@Override
	public void setDataSet(PlotSeriesCollection dataSet) {
		super.setDataSet(dataSet);
	}
}
