package com.uc.web.forms.ui.plot;

import com.uc.web.forms.IJsonString;

public interface PlotPoint<XType, YType> extends IJsonString {
	public XType getX();
	public void setX(XType x);
	public YType getY();
	public void setY(YType y);
}
