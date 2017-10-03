package com.uc.web.forms.ui.flot.line;

import java.util.ArrayList;
import java.util.List;

import com.uc.web.forms.ui.flot.PlotSeriesImpl;
import com.uc.web.forms.ui.flot.PlotPoint;
import com.uc.web.forms.ui.flot.PlotValue;

public class LineChartSeriesImpl extends PlotSeriesImpl implements LineChartSeries{
	public LineChartSeriesImpl(String name, List<PlotPoint> value) {
		super(name, new ArrayList<PlotValue>(value));
	}
}
