package com.uc.web.forms.ui.plot;

import java.util.List;

import com.uc.web.forms.IJsonString;

public interface PlotOption extends IJsonString {
	String getName();
	List<PlotOption> getSubOptions();
	List<PlotOption> add(PlotOption option);
}
