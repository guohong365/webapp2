package com.uc.utils.export.excel;

public interface FontOptionsSetter {
	void setBold(boolean bold);
	void setColor(short color);
	void setFontHeightInPoints(short fontHeightInPoints);
	void setFontName(String fontName);
	void setItalic(boolean italic);
	void setStrikeout(boolean strikeout);
	void setTypeOffset(short typeOffset);
	void setUnderline(byte underline);
}
