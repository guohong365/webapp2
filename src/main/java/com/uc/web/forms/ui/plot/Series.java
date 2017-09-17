package com.uc.web.forms.ui.plot;

import java.util.List;

import com.uc.web.forms.JsonString;

public interface Series<XType, YType> extends JsonString {	
	String getLabel();
	PlotOption getOption();
	void setOption(PlotOption option);
	List<PlotPoint<XType, YType>> getData();
	void add(PlotPoint<XType, YType> point);
}
