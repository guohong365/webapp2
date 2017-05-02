package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public interface IExcelCellOptionsEditor {
		public void setFontName(String fontName);
		public void setFontSize(short fontSize);
		public void setFontStyle(short fontStyle);
		public void setBkColor(IndexedColors colorIndex);
		public void setColor(IndexedColors colorIndex);
		public void setHAlignment(HorizontalAlignment HAlignment);
		public void setVAlignment(VerticalAlignment VAlignment);
}
