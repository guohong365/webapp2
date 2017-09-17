package com.uc.web.forms;

import java.util.function.Consumer;

public abstract class ColumnAccumulator implements Consumer<ComplexColumn> {
	private int sum;
	
	public int getSum() {
		return sum;
	}
	protected void add(int value){
		sum +=value;
	}
	public ColumnAccumulator reset(){
		sum=0;
		return this;
	}
	public ColumnAccumulator reset(int initalValue){
		this.sum=initalValue;
		return this;
	}
	public ColumnAccumulator() {
		sum=0;
	}
	public ColumnAccumulator(int initalValue){
		sum=initalValue;
	}
}
