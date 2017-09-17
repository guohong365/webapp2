package com.uc.utils.export.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.uc.utils.LoggerSupportorImpl;

public abstract class AbstractExcelExportor extends LoggerSupportorImpl implements ExcelExportor {	
	static WorkbookFacotry defaultWorkbookFactory=new Excel97WorkbookFacotry(); 
	static FontFactory defaultFontFactory=new DefaultFontFacotry();
	static CellStyleFactory defaultCellStyleFactor=new DefaultCellStyleFactory();
	static ExcelExportOptions defaultExportOptions=new DefaultExcelExportOptions();
	private WorkbookFacotry workbookFacotry;
	private FontFactory fontFactory;
	private CellStyleFactory cellStyleFactory;
	private Workbook workbook;
	private Sheet currentSheet;
	private String fileName;
	private ExcelExportOptions options;
	
	public void setWorkbookFacotry(WorkbookFacotry workbookFacotry) {
		this.workbookFacotry = workbookFacotry;
	}
	public WorkbookFacotry getWorkbookFacotry() {
		if(workbookFacotry !=null) return workbookFacotry;
		return defaultWorkbookFactory;
	}
	public void setCellStyleFactory(CellStyleFactory cellStyleFactory) {
		this.cellStyleFactory = cellStyleFactory;
	}
	public CellStyleFactory getCellStyleFactory() {
		if(cellStyleFactory!=null) return cellStyleFactory;
		return defaultCellStyleFactor;
	}
	public void setFontFactory(FontFactory fontFactory) {
		this.fontFactory = fontFactory;
	}
	public FontFactory getFontFactory() {
		if(fontFactory!=null) return fontFactory;
		return defaultFontFactory;
	}
		
	
	@Override
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public ExcelExportOptions getOptions() {
		if(options==null) return defaultExportOptions;
		return options;
	}
	@Override
	public void setOptions(ExcelExportOptions options) {
		this.options = options;
	}
	
	public Workbook create(){
		return getWorkbookFacotry().create();
	}
	public CellStyle create(CellOptions options) {
		return getCellStyleFactory().create(getWorkbook(), options, getFontFactory());
	}
	public Font create(FontOptions options) {
		return getFontFactory().create(getWorkbook(), options);
	}
	
	protected abstract void exportSheets();
	
	@Override
	public Workbook getWorkbook(){
		synchronized (getClass()) {
			if(workbook==null){
				workbook=create();
			}
		}
		return this.workbook;
	}
	
	public Sheet getSheet() {
		return currentSheet;
	}
		
	public void setSheet(Sheet currentSheet) {
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
				"attachment; filename=\"" + new String(getFileName().getBytes("UTF-8"), "ISO-8859-1")+"\"");
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
