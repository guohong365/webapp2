package com.uc.web.utils.json;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.alibaba.fastjson.serializer.ValueFilter;

public class BigDecimalValueFilter implements ValueFilter {
	
	private DecimalFormat decimalFormat;
	
	public BigDecimalValueFilter(DecimalFormat decimalFormat) {
		this.decimalFormat=decimalFormat;
	}

	public BigDecimalValueFilter(String decimalFormat2) {
		this.decimalFormat=new DecimalFormat(decimalFormat2);
	}

	@Override
	public Object process(Object object, String name, Object value) {
		if(value!=null && value instanceof BigDecimal){
			BigDecimal bigDecimal=(BigDecimal)value;
			if(decimalFormat!=null)
				return decimalFormat.format(bigDecimal);
			return bigDecimal.toString();
		}
		return value;
	}

}
