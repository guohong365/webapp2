package com.uc.web.forms.ui.flot;

import java.util.List;

public class PlotSeriesImpl extends PlotItemImpl  implements PlotSeries {
	public PlotSeriesImpl(String name, List<PlotValue> value) {
		super(name, new PlotValueCollectionImpl(value));
	}
	PlotItem options;
	@Override
	public PlotValueCollection getValue() {
		return (PlotValueCollection)super.getValue();
	}
	@Override
	public PlotItem getOptions() {
		return options;
	}
	public void setOptions(PlotItem options) {
		this.options = options;
	}
	@Override
	public
	String toJson() {		
		return super.toJson() + (getOptions()==null ? "":","+ getOptions().toJson());
	}
}
