package com.uc.utils.export.excel;

import com.uc.web.forms.ComplexColumn;

public interface ExcelColumn extends ComplexColumn {
	int getWidth();
	void setWidthAdjust(int addWidth);
}