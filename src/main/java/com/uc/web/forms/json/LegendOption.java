package com.uc.web.forms.json;

import com.uc.web.forms.JsonString;

public class LegendOption implements JsonString {
	//private static final String NAME="legend";
	public static final String POSITION_NE="ne";
	public static final String POSITION_NW="nw";
	public static final String POSITION_SE="se";
	public static final String POSITION_SW="sw";
	
	public static final String SORTED_TURE="true";
	public static final String SORTED_FALSE="false";
	public static final String SORTED_ASCENDING="\"acending\"";
	public static final String SORTED_DESCENDING="\"descending\"";
	public static final String SORTED_REVERSE="\"reverse\"";
	
	private boolean show;
	private String labelFormatter; //: null or (fn: string, series object -> string)
	private String labelBoxBorderColor; //color
	private Integer noColumns; //: number
	private String position; //: "ne" or "nw" or "se" or "sw"
	private String margin; //: number of pixels or [x margin, y margin]
	private String backgroundColor; //: null or color
	private Float backgroundOpacity; //: number between 0 and 1
	private String container; //: null or jQuery object/DOM element/jQuery expression
	private String sorted; //: null/false, true, "ascending", "descending", "reverse", or a comparator
	
	public LegendOption() {
	}
	
	public String getLabelFormatter() {
		return labelFormatter;
	}
	public void setLabelFormatter(String labelFormatter) {
		this.labelFormatter = labelFormatter;
	}
	public String getLabelBoxBorderColor() {
		return labelBoxBorderColor;
	}
	public void setLabelBoxBorderColor(String labelBoxBorderColor) {
		this.labelBoxBorderColor = labelBoxBorderColor;
	}
	public Integer getNoColumns() {
		return noColumns;
	}
	public void setNoColumns(Integer noColumns) {
		this.noColumns = noColumns;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public Float getBackgroundOpacity() {
		return backgroundOpacity;
	}
	public void setBackgroundOpacity(Float backgroundOpacity) {
		this.backgroundOpacity = backgroundOpacity;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getSorted() {
		return sorted;
	}
	public void setSorted(String sorted) {
		this.sorted = sorted;
	}
	@Override
	public String toJson() {
		StringBuilder builder=new StringBuilder();
		builder
			.append("\"show\":").append(isShow())
			.append(getLabelFormatter()==null ? "" : ",\"labelFormatter\":" + getLabelFormatter())
			.append(getLabelBoxBorderColor() == null ? "" : ",\"labelBoxBorderColor\":" + getLabelBoxBorderColor())
			.append(getNoColumns() == null ? "" : ",\"noColumns\":" + getNoColumns())
			.append(getPosition() == null ? "" : ",\"position\":\"" + getPosition() + "\"")
			.append(getMargin()==null ? "" : ",\"margin\":" + getMargin())
			.append(getBackgroundColor() == null ? "" : ",\"backgroundColor\":" + getBackgroundColor())
			.append(getBackgroundOpacity() ==null ? "" : ",\"backgroundOpacity\":" + getBackgroundOpacity())
			.append(getContainer() == null ? "" : ",\"container\"" + getContainer())
			.append(getSorted()== null ? "" : ",\"sorted\":" + getSorted());
		return builder.toString();
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	
	
}
