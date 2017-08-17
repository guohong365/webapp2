package com.uc.web.forms.ui.plot;

public class PlotItemBase<XType, YType> extends SeriesBase<XType, YType> implements PlotItem<XType, YType>{	
	private String color; //color or number
	private String highlightColor; //color or number
    private Integer xaxis; //1 or 2 
    private Integer yaxis; //1 or 2 
    private Boolean clickable; 
    private Boolean hoverable; 
    private Integer shadowSize; 
    private String label;	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	protected void toJsonOther(StringBuilder builder) {
		builder
		.append(getXaxis()==null ? "": ",\"xaxis:\"" + getXaxis().toString())
		.append(getYaxis()==null ? "": ",\"yaxis:\"" + getYaxis().toString())
		.append(getClickable()==null ? "" : ",\"clickable\":" + getClickable().toString())
		.append(getHoverable()==null ? "" : ",\"hoverable\":" + getHoverable().toString())
		.append(getShadowSize()==null ? "" : ",\"shadowSize\":" + getShadowSize())
		.append(getColor()==null ? "" : ",\"color\":" + getColor())
		.append(getHighlightColor()==null ? "" : ",\"hilightColor\":" + getHighlightColor());
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
}
