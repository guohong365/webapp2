package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public interface IExcelCellOptions {
	public String getFontName();
	public short getFontSize();
	public short getFontStyle();
	public IndexedColors getBkColor();
	public IndexedColors getColor();
	public HorizontalAlignment getHAlignment();
	public VerticalAlignment getVAlignment();
}
