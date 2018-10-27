package com.news.dao.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CaptureHtmlUtil {
	/*
	 * strURL  待提取的新闻的地址
	 * begin  从哪开始提取
	 * end  到哪结束
	 * replaced  要被替换掉的字符
	 * replace 用什么字符替换
	 * */
	public static String captureHtml(String strURL, String begin, String end,
			String replaced,String replace) throws Exception {
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		InputStreamReader input = new InputStreamReader(
				httpConn.getInputStream(), "gb2312");
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		//按行读取并拼接到contentBuf中
		while ((line = bufReader.readLine()) != null) {
			contentBuf.append(line);
		}
		String buf = contentBuf.toString();
		int beginIx = buf.indexOf(begin);
		int endIx = buf.indexOf(end);
		String result="";
		if(beginIx>0&&endIx>0){
			result = buf.substring(beginIx, endIx);
		}
		if(!result.equals("")||result!=null){
			//将提取到的内容进行过滤
			result = result.replaceAll(replaced, replace);
			result = result.replaceAll("<style[^>]*?>[\\s\\S]*?<\\/style>", "");
		}
		return result;
	}
}
