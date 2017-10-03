package com.uc.web.forms.ui.flot.line;

import com.uc.web.forms.ui.flot.PlotValueImpl;

public class LineChartSeriesOptionImpl extends PlotValueImpl implements LineChartSeriesOption{
	protected LineChartSeriesOptionImpl() {
	}
	private String color; //color or number
	private String highlightColor; //color or number
    private Integer xaxis; //1 or 2 
    private Integer yaxis; //1 or 2 
    private Boolean clickable; 
    private Boolean hoverable; 
    private Integer shadowSize;
    private String symbol;
    
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getHighlightColor() {
		return highlightColor;
	}
	public void setHighlightColor(String highlightColor) {
		this.highlightColor = highlightColor;
	}
	public Integer getXaxis() {
		return xaxis;
	}
	public void setXaxis(Integer xaxis) {
		this.xaxis = xaxis;
	}
	public Integer getYaxis() {
		return yaxis;
	}
	public void setYaxis(Integer yaxis) {
		this.yaxis = yaxis;
	}
	public Boolean getClickable() {
		return clickable;
	}
	public void setClickable(Boolean clickable) {
		this.clickable = clickable;
	}
	public Boolean getHoverable() {
		return hoverable;
	}
	public void setHoverable(Boolean hoverable) {
		this.hoverable = hoverable;
	}
	public Integer getShadowSize() {
		return shadowSize;
	}
	public void setShadowSize(Integer shadowSize) {
		this.shadowSize = shadowSize;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
