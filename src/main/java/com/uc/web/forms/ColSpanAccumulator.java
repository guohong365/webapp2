package com.uc.web.forms;

public class ColSpanAccumulator extends ColumnAccumulator {

	@Override
	public void accept(ComplexColumn t) {
		if(t.isShow()){
			add(t.getColSpan());
		}
	}

}
