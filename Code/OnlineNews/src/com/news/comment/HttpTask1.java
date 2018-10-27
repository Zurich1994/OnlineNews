package com.news.comment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpTask1 extends AsyncTask<String, Void, byte[]> {
	private Commentlist activity;
	private int type;

	public HttpTask1(Commentlist activity, int type) {
		super();
		this.activity = activity;
		this.type = type;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		// Toast.makeText(activity, "我要发请求了", Toast.LENGTH_LONG).show();
	}

	@Override
	protected byte[] doInBackground(String... params) {
		// TODO Auto-generated method stub
		byte[] result = httpClientGet(params[0]);
		Log.e("EEEEEEEEEEEEEEEEEE", new String(result));
		return result;
	}

	@Override
	protected void onPostExecute(byte[] result) {
		if (result == null)
			return;
		super.onPostExecute(result);

		handleJson(result);

	}

	private void handleJson(byte[] result) {
		try {
			String json = new String(result, "UTF-8");
			Gson gson = new Gson();
			List<Comment0> comment = gson.fromJson(json,
					new TypeToken<List<Comment0>>() {
					}.getType());
			HttpTask1 task = new HttpTask1(activity, 1);
			activity.updateUI(comment);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private byte[] httpClientGet(String url) {

		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(URI.create(url));
			HttpResponse resp = client.execute(request);
			HttpEntity resEntity = resp.getEntity();
			byte[] result = EntityUtils.toByteArray(resEntity);
			return result;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
