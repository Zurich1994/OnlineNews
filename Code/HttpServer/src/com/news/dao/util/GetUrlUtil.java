package com.news.dao.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetUrlUtil {
	//RSS��ַ
	String htmlUrl;
	//�û���Ŵ�RSS����ȡ��ÿ�����ŵĵ�ַ
	ArrayList<String> hrefList = new ArrayList();
	//
	String charSet;

	public GetUrlUtil(String htmlUrl) {
		// TODO �Զ����ɵĹ��캯�����
		this.htmlUrl = htmlUrl;
	}
	//����ÿ�����ŵĵ�ַ�ĺ���
	public ArrayList<String> getHrefList() throws IOException {
		parser();//��RSS����ȡ��ÿ�����ŵĵ�ַ�ĺ���
		return hrefList;
	}

	private void parser() throws IOException {
		URL url = new URL(htmlUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		String contenttype = connection.getContentType();
		charSet = getCharset(contenttype);
		InputStreamReader isr = new InputStreamReader(
				connection.getInputStream(), charSet);
		BufferedReader br = new BufferedReader(isr);
		String str = null, rs = null;
		while ((str = br.readLine()) != null) {
			rs = getHref(str); //java����ʽ��������url
			if (rs != null)
				hrefList.add(rs);
		}
	}
	//java����ʽ���˱��뷽ʽ
	private String getCharset(String str) {
		Pattern pattern = Pattern.compile("charset=.*");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())
			return matcher.group(0).split("charset=")[1];
		return null;
	}
    //java����ʽ��������url
	private String getHref(String str) {
		//��������������ʽ���뵽ģʽ��
		Pattern pattern = Pattern.compile("http://news.qq.com/a/.*htm");
		//����ƥ������������ģʽ��ƥ����
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())//���Բ������ģʽƥ����������е���һ��������
			return matcher.group(0);
		return null;
	}
}