package com.uc.web.forms.ui.plot;

public class LineOption extends PlotOptionBase implements PlotOption {
	private static final String NAME="lines";
	
	private boolean show;
	
	public LineOption() {
		super(NAME);
		this.show=true;
	}
	public LineOption(boolean show){
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
