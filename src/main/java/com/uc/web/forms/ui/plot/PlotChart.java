package com.uc.web.forms.ui.plot;

import java.util.List;

import com.uc.web.forms.JsonString;

public interface PlotChart extends JsonString{
	List<Series<?, ?>> getData();
	List<Series<?, ?>> add(Series<?, ?> serie);
	PlotOption getOption();
}
