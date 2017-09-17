package com.uc.web.forms.ui.plot;

import com.uc.web.forms.JsonString;

public interface PlotPoint<XType, YType> extends JsonString {
	public XType getX();
	public void setX(XType x);
	public YType getY();
	public void setY(YType y);
}
