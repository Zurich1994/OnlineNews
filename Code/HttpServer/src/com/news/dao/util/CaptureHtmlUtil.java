package com.news.dao.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CaptureHtmlUtil {
	/*
	 * strURL  ����ȡ�����ŵĵ�ַ
	 * begin  ���Ŀ�ʼ��ȡ
	 * end  ���Ľ���
	 * replaced  Ҫ���滻�����ַ�
	 * replace ��ʲô�ַ��滻
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
		//���ж�ȡ��ƴ�ӵ�contentBuf��
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
			//����ȡ�������ݽ��й���
			result = result.replaceAll(replaced, replace);
			result = result.replaceAll("<style[^>]*?>[\\s\\S]*?<\\/style>", "");
		}
		return result;
	}
}
