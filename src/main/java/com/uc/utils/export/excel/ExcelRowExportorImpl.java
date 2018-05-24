package com.uc.utils.export.excel;


import org.apache.poi.ss.usermodel.Sheet;

import com.uc.utils.export.Exportor;
import com.uc.utils.export.ValueFormatter;

public class ExcelRowExportorImpl<EntityType> implements ExcelRowExportor<EntityType>{

	private ValueFormatter<EntityType> formatter;
	
	public ValueFormatter<EntityType> getFormatter() {
		return formatter;
	}
	public void setFormatter(ValueFormatter<EntityType> formatter) {
		this.formatter = formatter;
	}
	
	@Override
	public int export(Exportor exportor, EntityType data, int startRow, int startCol) {
		ExcelExportor excelExportor=(ExcelExportor) exportor;
		Sheet sheet= excelExportor.getWorkbook().getSheetAt(0);
		
		return 0;
	}

}
