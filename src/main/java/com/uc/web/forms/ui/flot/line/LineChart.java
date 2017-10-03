package com.uc.web.forms.ui.flot.line;

import com.uc.web.forms.ui.flot.PlotSeriesCollection;
import com.uc.web.forms.ui.flot.PlotChart;

public interface LineChart extends PlotChart {
	PlotSeriesCollection getDataSet();
	void setDataSet(PlotSeriesCollection dataSet);
}
