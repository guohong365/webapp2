package com.uc.utils.export;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Exportor {
	public static final short BOLD=1;
	public static final short ITALIC=2;
	public static final short STRIKEOUT=4;
	public static final short UNDERLINE=8;
	public static final int MAX_ROW = 10000;
	
	public void Export(String fileName) throws IOException;
	public void Export(OutputStream outputStream) throws IOException;
	public void Export(HttpServletRequest request, HttpServletResponse response) throws IOException;
	public String getDefaultFileName();
}
