package com.uc.web.forms.ui.plot;

public class SeriesOption extends RootOption {

	public SeriesOption(boolean showLines, boolean showPoints) {
		super("series");
		add(new LineOption(showLines)).add(new PointOption(showPoints));		
	}

}
