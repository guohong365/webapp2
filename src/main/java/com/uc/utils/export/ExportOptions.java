package com.uc.utils.export;

import java.util.Collection;
import com.uc.utils.export.excel.CellOptions;

public interface ExportOptions {
	<T> T get(String name);
	<T> Collection<CellOptions> getAll();
}
