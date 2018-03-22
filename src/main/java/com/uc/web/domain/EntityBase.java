package com.uc.web.domain;

import com.uc.utils.ObjectPropertyFormator;

public abstract class EntityBase implements Cloneable{
	
	/**
	 *输出程度， 0——默认，1——本级类型定义，2——所有，包括父类  
	 */
	public static int OUTPUT_DETAIL=1;	
	@Override
	public String toString() {
		switch(OUTPUT_DETAIL){
		case 2 :
		  return ObjectPropertyFormator.format(this, "", true, false, false, false);
		case 1 :
		  return ObjectPropertyFormator.format(this, "", true, false, false, true);	
		}
		return super.toString();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String toString(boolean withClassName, boolean flat, boolean singleLinePerValue, boolean justThis){
		return ObjectPropertyFormator.format(this, "", flat, withClassName, singleLinePerValue, justThis);
	}
	
}
