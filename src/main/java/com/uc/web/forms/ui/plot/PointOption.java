package com.uc.web.forms.ui.plot;

public class PointOption extends PlotOptionBase{
	private static final String NAME="points";
	private boolean show;
	
	public PointOption() {
		super(NAME);
		show=true;
	}
	
	public PointOption(boolean show){
		super(NAME);
		this.show=show;
	}
		

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	@Override
	protected String dataToJson() {
		return "\"show\":" + isShow();
	}

}
