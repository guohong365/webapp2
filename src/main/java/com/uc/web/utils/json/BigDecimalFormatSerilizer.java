package com.uc.web.utils.json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class BigDecimalFormatSerilizer  implements ObjectSerializer  {
	
	private DecimalFormat decimalFormat;
	
	public BigDecimalFormatSerilizer(DecimalFormat decimalFormat) {
		this.decimalFormat=decimalFormat;
	}

	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			throws IOException {
		 SerializeWriter out = serializer.getWriter();
		    String value;
	        if(object == null){
	        	value=decimalFormat.format(new BigDecimal(0));
	        }else{
	            BigDecimal bigDecimal = (BigDecimal)object;
	            value = decimalFormat.format(bigDecimal);
	        }
	        out.write(value);
	}

}
