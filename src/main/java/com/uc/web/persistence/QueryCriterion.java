package com.uc.web.persistence;

public interface QueryCriterion {
	public String getCondition();
	public Object getValue();
	public Object getSecondValue();
	public boolean isNoValue();
	public boolean isSingleValue();
	public boolean isBetweenValue();
	public boolean isListValue();
	public String getTypeHandler();
}
