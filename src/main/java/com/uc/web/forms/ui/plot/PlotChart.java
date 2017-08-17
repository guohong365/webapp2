package com.uc.web.forms.ui.plot;

import java.util.List;

import com.uc.web.forms.IJsonString;

public interface PlotChart extends IJsonString{
	List<Series<?, ?>> getData();
	List<Series<?, ?>> add(Series<?, ?> serie);
	PlotOption getOption();
}
