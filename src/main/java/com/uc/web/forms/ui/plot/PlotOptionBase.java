package com.uc.web.forms.ui.plot;

public abstract class PlotOptionBase extends RootOption{
	private boolean show;
	
	protected PlotOptionBase(String name) {
		super(name);
	}	
	protected String dataToJson(){
		return "\"show\":" + isShow();
	}
	
	@Override
	public String toJson() {
		return "{\""+ getName() +"\" :{" + dataToJson() + "}";
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

}
