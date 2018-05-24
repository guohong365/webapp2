package com.uc.utils.export.excel;

import com.uc.utils.export.Exportor;

public interface ExcelRowExportor<EntityType> {
	int export(Exportor exportor, EntityType data, int startRow, int startCol);	
}
