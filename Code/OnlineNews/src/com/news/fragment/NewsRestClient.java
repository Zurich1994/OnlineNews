package com.news.fragment;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class NewsRestClient {
	private static final String BASE_URL = "http://172.16.0.1:8080/HttpServer/";
	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void get(String url, RequestParams params,
			BinaryHttpResponseHandler responseHandler) {
		client.get(url, params, responseHandler);
	}

	public static String getAbsoluteUrl(String relativeUrl) {

		return BASE_URL + relativeUrl;
	}
}
