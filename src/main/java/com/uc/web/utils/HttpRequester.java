package com.uc.web.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import com.uc.utils.LoggerSupportorImpl;

public class HttpRequester extends LoggerSupportorImpl {
	
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST="POST";

	
	public static String requestGet(String url,String param) throws Exception{
		String fullUrl=url +"?" + param;
		BufferedReader reader=null;
		try{
			URL realUrl=new URL(fullUrl);
			URLConnection connection=realUrl.openConnection();
			
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			connection.connect();
			
			//Map<String, List<String>> map=connection.getHeaderFields();
			
			reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder=new StringBuilder();
			String line;
			while((line=reader.readLine())!=null){
				builder.append(line);
			}
			return builder.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(reader!=null){
				reader.close();
			}
		}				
	}
	
	public static String requestPost(String url,String param) throws Exception{
		BufferedReader reader=null;
		PrintWriter writer=null;
		try{
			URL realUrl=new URL(url);
			URLConnection connection=realUrl.openConnection();
			
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			connection.connect();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			writer=new PrintWriter(connection.getOutputStream());
			writer.println(param);
			writer.flush();
			
			//Map<String, List<String>> map=connection.getHeaderFields();
			
			reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder=new StringBuilder();
			String line;
			while((line=reader.readLine())!=null){
				builder.append(line);
			}
			return builder.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(reader!=null){
				reader.close();
			}
			if(writer!=null){
				writer.close();
			}
		}				
	}
	
	public static String Request(String url,String param, String method) throws Exception{
		if(METHOD_GET.equalsIgnoreCase(method)){
			return requestGet(url, param);
		} else if(METHOD_POST.equalsIgnoreCase(method)){
			return requestPost(url, param);
		}
		throw new Exception("unknown request method.");
	}

}
