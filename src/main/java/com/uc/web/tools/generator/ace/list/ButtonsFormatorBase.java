package com.uc.web.tools.generator.ace.list;

import java.util.List;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.tools.generator.ButtonDescriptor;
import com.uc.web.tools.generator.ButtonsAcceptor;

public class ButtonsFormatorBase extends AbstractUIFormatorBase implements ButtonsAcceptor {
	private List<ButtonDescriptor> rowButtons;
	@Override
	public List<ButtonDescriptor> getRowButtons() {
		return rowButtons;
	}
	@Override
	public void setRowButtons(List<ButtonDescriptor> rowButtons) {
		this.rowButtons = rowButtons;
	}
}
