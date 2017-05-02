package com.uc.utils;

public class StringUtils {
	public static String leftPad(String src, char ch, int count){
		StringBuffer buffer=new StringBuffer();
		for(int i=0; i< count; i++){
			buffer.append(ch);
		}
		buffer.append(src);
		return buffer.toString();
	}
	
	public static String leftPad(String src, String padding, int count){
		StringBuffer buffer=new StringBuffer();
		for(int i=0; i< count; i++){
			buffer.append(padding);
		}
		buffer.append(src);
		return buffer.toString();
	}
	
	public static String rightPad(String src, char ch, int count){
		StringBuffer buffer=new StringBuffer();
		buffer.append(src);
		for(int i=0; i<count; i++){
			buffer.append(ch);
		}
		return buffer.toString();
	}
	public static String rightPad(String src, String padding, int length){
		StringBuffer buffer=new StringBuffer();
		buffer.append(src);
		for(int i=0; i<length; i++){
			buffer.append(padding);
		}
		return buffer.toString();
	}
}
