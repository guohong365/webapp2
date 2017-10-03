package com.uc.web.forms.json;

import java.util.HashMap;
import java.util.Map;

public class AixsOptions  {
	Map<Class<?>, JsonItem> items;
	public AixsOptions(String name, JsonItem[] options){
		items=new HashMap<>();
		for(JsonItem item:options){
			items.put(item.getClass(), item);
		}		
	}
	
    public enum AIXS_POSITION{
    	BOTTOM("bottom"),
    	TOP("top"),
    	LEFT("left"),
    	RIGHT("right");
    	private String value;
    	AIXS_POSITION(String value){
    		this.value=value;
    	}
    	public String value(){
    		return value;
    	}
    }
	public class Position extends JsonItemImpl{
		public Position(AIXS_POSITION position){
			super("position", position.value);
		}
	}
	public enum AIXS_MODE{
		TIME("time"),
		NONE(null);
		private String value;
		AIXS_MODE(String value){
			this.value=value;
		}
		public String value(){
			return value;
		}
	}
	public class Mode extends JsonItemImpl {
		public Mode(AIXS_MODE mode){
			super("mode", mode.value());
		}
	}
	
	private String position; //"bottom" or "top" or "left" or "right"
	private String mode; //null or "time" ("time" requires jquery.flot.time.js plugin)
	private String timezone; //null, "browser" or timezone (only makes sense for mode: "time")

	private String color; //null or color spec
	private String tickColor; //: null or color spec
	private String font; //null or font spec object

	private Integer min; //null or number
	private Integer max; //null or number
	private Integer autoscaleMargin; //null or number
    
	private String transform; //null or fn: number -> number
	private String inverseTransform; //null or fn: number -> number
    
	private String ticks; //: null or number or ticks array or (fn: axis -> ticks array)
	private String tickSize; //: number or array
	private String minTickSize; //number or array
	private String tickFormatter; //: (fn: number, object -> string) or string
	private Integer tickDecimals; //: null or number

	private Integer labelWidth; //null or number
	private Integer labelHeight; //null or number
	private Boolean reserveSpace; //null or true
    
	private Integer tickLength; //null or number

	private Integer alignTicksWithAxis; //null or number

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTickColor() {
		return tickColor;
	}

	public void setTickColor(String tickColor) {
		this.tickColor = tickColor;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getAutoscaleMargin() {
		return autoscaleMargin;
	}

	public void setAutoscaleMargin(Integer autoscaleMargin) {
		this.autoscaleMargin = autoscaleMargin;
	}

	public String getTransform() {
		return transform;
	}

	public void setTransform(String transform) {
		this.transform = transform;
	}

	public String getInverseTransform() {
		return inverseTransform;
	}

	public void setInverseTransform(String inverseTransform) {
		this.inverseTransform = inverseTransform;
	}

	public String getTicks() {
		return ticks;
	}

	public void setTicks(String ticks) {
		this.ticks = ticks;
	}

	public String getTickSize() {
		return tickSize;
	}

	public void setTickSize(String tickSize) {
		this.tickSize = tickSize;
	}

	public String getMinTickSize() {
		return minTickSize;
	}

	public void setMinTickSize(String minTickSize) {
		this.minTickSize = minTickSize;
	}

	public String getTickFormatter() {
		return tickFormatter;
	}

	public void setTickFormatter(String tickFormatter) {
		this.tickFormatter = tickFormatter;
	}

	public Integer getTickDecimals() {
		return tickDecimals;
	}

	public void setTickDecimals(Integer tickDecimals) {
		this.tickDecimals = tickDecimals;
	}

	public Integer getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(Integer labelWidth) {
		this.labelWidth = labelWidth;
	}

	public Integer getLabelHeight() {
		return labelHeight;
	}

	public void setLabelHeight(Integer labelHeight) {
		this.labelHeight = labelHeight;
	}

	public Boolean getReserveSpace() {
		return reserveSpace;
	}

	public void setReserveSpace(Boolean reserveSpace) {
		this.reserveSpace = reserveSpace;
	}

	public Integer getTickLength() {
		return tickLength;
	}

	public void setTickLength(Integer tickLength) {
		this.tickLength = tickLength;
	}

	public Integer getAlignTicksWithAxis() {
		return alignTicksWithAxis;
	}

	public void setAlignTicksWithAxis(Integer alignTicksWithAxis) {
		this.alignTicksWithAxis = alignTicksWithAxis;
	}
}
