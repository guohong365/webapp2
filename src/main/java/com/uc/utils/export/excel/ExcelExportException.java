package com.uc.utils.export.excel;

public class ExcelExportException extends Exception {
	private static final long serialVersionUID = 6077039038892076137L;	

	public ExcelExportException(){
		super();
	}
	public ExcelExportException(String msg){
		super(msg);
	}
	
	public ExcelExportException(Throwable other){
		super(other);
	}
	
    public ExcelExportException(String msg, Throwable other){
    	super(msg, other);
    }
}
