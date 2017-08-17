package com.uc.web.forms.ui.plot;

public class AixsOption extends PlotOptionBase {
	
    public AixsOption(String name, String position) {
		this(name, position, null);		
	}    
    
    public AixsOption(String name, String position, String ticks ){
    	this(name, position, ticks, null, null, null, null, null, null, null, null);
    }
    
    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength){
    	this(name, position, ticks, min, max, autoScaleMargin, tickDecimals, labelWidth, labelHeight, reserveSpace, tickLength,null, null);
    }

    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength,
    		String mode, String timezone){
    	this(name, position, ticks, min, max, autoScaleMargin, tickDecimals, labelWidth, labelHeight, reserveSpace, tickLength, 
    			mode, timezone, null);
    }

    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength,
    		String mode, String timezone,String tickFormatter){
    	this(name, position, ticks, min, max, autoScaleMargin, tickDecimals, labelWidth, labelHeight, reserveSpace, tickLength, 
    			mode, timezone, tickFormatter, null);
    }

    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength,
    		String mode, String timezone,String tickFormatter,
    		Integer alignTicksWithAxis){
    	this(name, position, ticks, min, max, autoScaleMargin, tickDecimals, labelWidth, labelHeight, reserveSpace, tickLength, 
    			mode, timezone, tickFormatter,
    			alignTicksWithAxis, null, null);
    }

    
    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength,
    		String mode, String timezone,String tickFormatter,
    		Integer alignTicksWithAxis,
    		String tickSize, String minTickSize){
    	this(name, position, ticks, min, max, autoScaleMargin, tickDecimals, labelWidth, labelHeight, reserveSpace, tickLength, 
    			mode, timezone, tickFormatter,
    			alignTicksWithAxis,
    			tickSize, minTickSize, null, null);
    }

    
    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength,
    		String mode, String timezone,String tickFormatter,
    		Integer alignTicksWithAxis,
    		String tickSize, String minTickSize,  
    		String transform, String inverseTransform){
    	this(name, position, ticks, min, max, autoScaleMargin, tickDecimals, labelWidth, labelHeight, reserveSpace, tickLength, 
    			mode, timezone, tickFormatter,
    			alignTicksWithAxis,
    			tickSize, minTickSize, transform, inverseTransform, null, null, null);
    }

    public AixsOption(String name, String position, String ticks, Integer min, Integer max, Integer autoScaleMargin,
    		Integer tickDecimals, Integer labelWidth, Integer labelHeight, Boolean reserveSpace, Integer tickLength,
    		String mode, String timezone,String tickFormatter, 
    		Integer alignTicksWithAxis,
    		String tickSize, String minTickSize, 
    		String transform, String inverseTransform, 
    		String color, String tickColor, String font) {
		super(name);
		this.position=position;
		this.ticks=ticks;
		this.min=min;
		this.max=max;
		this.autoscaleMargin=autoScaleMargin;
		this.tickDecimals=tickDecimals;
		this.labelHeight=labelHeight;
		this.labelWidth=labelWidth;
		this.reserveSpace=reserveSpace;
		this.tickLength=tickLength;
		this.alignTicksWithAxis=alignTicksWithAxis;
		this.tickSize=tickSize;
		this.minTickSize=minTickSize;
		this.tickFormatter=tickFormatter;
		this.transform=transform;
		this.inverseTransform=inverseTransform;
		this.mode=mode;
		this.timezone=timezone;
		this.color=color;
		this.tickColor=tickColor;
		this.font=font;
		
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
