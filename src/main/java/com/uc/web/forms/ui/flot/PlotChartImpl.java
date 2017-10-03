package com.uc.web.forms.ui.flot;

public class PlotChartImpl implements PlotChart {
	private PlotValue dataSet;
	private PlotItem options;	
	
	public PlotChartImpl(PlotValue dataSet, PlotItem options){
		this.dataSet=dataSet;
		this.options=options;
	}

	public PlotValue getDataSet() {
		return dataSet;
	}
	public void setDataSet(PlotValue dataSet) {
		this.dataSet = dataSet;
	}
	public PlotItem getOptions() {
		return options;
	}
	public void setOptions(PlotItem options) {
		this.options = options;
	}


}
