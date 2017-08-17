package com.uc.web.forms.ui.plot;

import com.uc.web.domain.EntityBase;

public class PlotDataRow<XType, YType> extends EntityBase{
	private String label;
	private XType x;
	private YType y;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public XType getX() {
		return x;
	}
	public void setX(XType x) {
		this.x = x;
	}
	public YType getY() {
		return y;
	}
	public void setY(YType y) {
		this.y = y;
	}
	
}
