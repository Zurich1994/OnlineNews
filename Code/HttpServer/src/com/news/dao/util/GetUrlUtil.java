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
	//RSS地址
	String htmlUrl;
	//用户存放从RSS中提取的每条新闻的地址
	ArrayList<String> hrefList = new ArrayList();
	//
	String charSet;

	public GetUrlUtil(String htmlUrl) {
		// TODO 自动生成的构造函数存根
		this.htmlUrl = htmlUrl;
	}
	//返回每条新闻的地址的函数
	public ArrayList<String> getHrefList() throws IOException {
		parser();//从RSS中提取的每条新闻的地址的函数
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
			rs = getHref(str); //java正则式过滤新闻url
			if (rs != null)
				hrefList.add(rs);
		}
	}
	//java正则式过滤编码方式
	private String getCharset(String str) {
		Pattern pattern = Pattern.compile("charset=.*");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())
			return matcher.group(0).split("charset=")[1];
		return null;
	}
    //java正则式过滤新闻url
	private String getHref(String str) {
		//将给定的正则表达式编译到模式中
		Pattern pattern = Pattern.compile("http://news.qq.com/a/.*htm");
		//创建匹配给定输入与此模式的匹配器
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())//尝试查找与该模式匹配的输入序列的下一个子序列
			return matcher.group(0);
		return null;
	}
}