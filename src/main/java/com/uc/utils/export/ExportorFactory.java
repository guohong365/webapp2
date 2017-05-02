package com.uc.utils.export;

import java.util.Map;

public interface ExportorFactory {
	Exportor create(Map<String, Object> options);
}
