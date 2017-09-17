package com.uc.web.forms.ui.plot;

import java.util.List;

import com.uc.web.forms.JsonString;

public interface PlotOption extends JsonString {
	String getName();
	List<PlotOption> getSubOptions();
	List<PlotOption> add(PlotOption option);
}
