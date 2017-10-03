package com.uc.web.forms.ui.flot.line;

import com.uc.web.forms.ui.flot.PlotValue;

public interface LineChartSeriesOption extends PlotValue {
	Integer getXaxis();
	void setXaxis(Integer xaxis);
	Integer getYaxis();
	void setYaxis(Integer yaxis);
	Boolean getClickable();
	void setClickable(Boolean clickable);
	Boolean getHoverable();
	void setHoverable(Boolean hoverable);
	Integer getShadowSize();
	void setShadowSize(Integer shadowSize);
	String getColor();
	void setColor(String color);
	String getHighlightColor();
	void setHighlightColor(String highlightColor);	
	String getSymbol();
	void setSymbol(String symble);
	
	@Override
	default String toJson() {
		StringBuilder builder=new StringBuilder();
		builder
		.append(getXaxis()==null ? "": ",\"xaxis:\"" + getXaxis().toString())
		.append(getYaxis()==null ? "": ",\"yaxis:\"" + getYaxis().toString())
		.append(getClickable()==null ? "" : ",\"clickable\":" + getClickable().toString())
		.append(getHoverable()==null ? "" : ",\"hoverable\":" + getHoverable().toString())
		.append(getShadowSize()==null ? "" : ",\"shadowSize\":" + getShadowSize())
		.append(getColor()==null ? "" : ",\"color\":" + getColor())
		.append(getHighlightColor()==null ? "" : ",\"hilightColor\":" + getHighlightColor())
		.append(getSymbol()==null ? "" : "\"symbol\":\"" + getSymbol() +"\"");		
		return builder.toString();
	}
}
