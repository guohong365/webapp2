package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public interface FontFactory {
	Font create(Workbook workbook, FontOptions options);
}
