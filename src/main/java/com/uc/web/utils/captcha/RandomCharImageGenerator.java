package com.uc.web.utils.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class RandomCharImageGenerator implements IRandomCharImageGenerator {
	private static final String[] DEFAULT_FONT_SET={"Fixedsys","宋体","黑体"};
	private static final int DEFAULT_FONT_MIN_SIZE=10;
	private static final int DEFAULT_FONT_MAX_SIZE=20;
	private static final int DEFAULT_LINE_COUNT=4;
	

	private Random random=new Random(Calendar.getInstance().getTimeInMillis());
	
	private int lineCount;
	private int maxFontSize;
	private int minFontSize;
	private List<String> fontSet;
	private List<String> defaultFontSet=new ArrayList<>();
	
	public RandomCharImageGenerator() {
		for (String string : DEFAULT_FONT_SET) {
			defaultFontSet.add(string);
		}
	}
	
	public int getLineCount() {
		if(lineCount<=0)
			return DEFAULT_LINE_COUNT;
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getMaxFontSize() {
		if(maxFontSize<=0)
			return DEFAULT_FONT_MAX_SIZE;
		return maxFontSize;
	}

	public void setMaxFontSize(int maxFontSize) {
		this.maxFontSize = maxFontSize;
	}

	public int getMinFontSize() {
		if(minFontSize<=0)
			return minFontSize=DEFAULT_FONT_MIN_SIZE;
		return minFontSize;
	}

	public void setMinFontSize(int minFontSize) {
		this.minFontSize = minFontSize;
	}

	public List<String> getFontSet() {
		if(fontSet==null || fontSet.size()==0)
			return defaultFontSet;
		return fontSet;
	}

	public void setFontSet(List<String> fontSet) {
		this.fontSet = fontSet;
	}

	protected Font getFont(String fontName, int size){
		Font font=new Font(fontName, Font.BOLD|Font.CENTER_BASELINE, size);
		return font;
	}
	
	protected Color getRandomColor(){
		int r=random.nextInt(255);
		int g=random.nextInt(255);
		int b=random.nextInt(255);
		return new Color(r, g, b);
	}
	
	protected Font getRandomFont(List<String> fontSet, int minFontSize,int maxFontSize){
		String fontName=fontSet.get(random.nextInt(fontSet.size()));
		
		int fontSize= minFontSize +random.nextInt(maxFontSize-minFontSize);
		
		return getFont(fontName, fontSize);
	}
	

	
	public BufferedImage generate(int width, int height, String captcha){
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);					
		Graphics2D graphics=(Graphics2D) image.getGraphics();
		char[] chars=captcha.toCharArray();
		
		int x=0;
		int y=height/2;
		for(int i=0; i< chars.length; i++){
			Font font=getRandomFont(fontSet, minFontSize, maxFontSize);
			Color color=getRandomColor();
			graphics.setColor(color);
			graphics.setFont(font);			
			graphics.drawChars(chars, i, 1, x, y);
		}
		
		return image;
	}
	
}
