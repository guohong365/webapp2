package com.uc.web.forms.ui.plot;

public interface PlotItem<XType, YType> extends Series<XType, YType>{	
	public String getLabel();
	public void setLabel(String label);
	public Integer getXaxis();
	public void setXaxis(Integer xaxis);
	public Integer getYaxis();
	public void setYaxis(Integer yaxis);
	public Boolean getClickable();
	public void setClickable(Boolean clickable);
	public Boolean getHoverable();
	public void setHoverable(Boolean hoverable);
	public Integer getShadowSize();
	public void setShadowSize(Integer shadowSize);
	public String getColor();
	public void setColor(String color);
	public String getHighlightColor();
	public void setHighlightColor(String highlightColor);		
}

