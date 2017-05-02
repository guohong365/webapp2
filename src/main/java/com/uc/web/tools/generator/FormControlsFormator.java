package com.uc.web.tools.generator;

import java.util.Map;

public interface FormControlsFormator extends FormFieldsFormator {
	Map<String, FormFieldFormator> getComponents();
}