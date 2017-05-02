package com.uc.utils.export.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.uc.utils.LoggerSupportorImpl;
import com.uc.utils.export.Exportor;

public abstract class ExcelExportorBase extends LoggerSupportorImpl implements Exportor {	
	
	private Workbook workbook;
	private Sheet currentSheet;
	
	private IExcelExportOptions exportOptions;
	
	public IExcelExportOptions getExportOptions() {
		return exportOptions;
	}
	
	public void setExportOptions(IExcelExportOptions exportOptions) {
		this.exportOptions = exportOptions;
	}
	
	protected abstract Workbook createWorkbook();
	
	protected abstract void exportSheets();
	
	public Workbook getWorkbook(){
		synchronized (getClass()) {
			if(workbook==null){
				workbook=createWorkbook();
			}
		}
		return this.workbook;
	}
	
	public Sheet getCurrentSheet() {
		return currentSheet;
	}
	
	public void setCurrentSheet(Sheet currentSheet) {
		this.currentSheet = currentSheet;
	}
	
	@Override
	public void Export(String fileName) throws IOException {
		exportSheets();
		FileOutputStream fileOutputStream=new FileOutputStream(fileName);
		getWorkbook().write(fileOutputStream);
		fileOutputStream.flush();
		fileOutputStream.close();		
	}			

	@Override
	public void Export(OutputStream outputStream) throws IOException {
		exportSheets();
		getWorkbook().write(outputStream);
		outputStream.flush();
	}
	
	@Override
	public void Export(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.reset();
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("multipart/form-data");
		response.setHeader(
				"Content-disposition",
				"attachment; filename=\"" + new String(getDefaultFileName().getBytes("UTF-8"), "ISO-8859-1")+"\"");
		response.setContentType("application/msexcel");// 定义输出类型
		OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			Export(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
