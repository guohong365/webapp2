package com.uc.web.tools.generator;

import java.util.List;

public interface ButtonsAcceptor {
	void setRowButtons(List<ButtonDescriptor> rowButtons);
	List<ButtonDescriptor> getRowButtons();
}
