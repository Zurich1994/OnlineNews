package com.example.pyx;

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpTask0 extends AsyncTask<String, Void, byte[]> {
	private CollActivity activity;
	private int type;

	public HttpTask0(CollActivity activity) {
		super();
		this.activity = activity;
		this.type = type;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		Toast.makeText(activity, "查看我的收藏", Toast.LENGTH_LONG).show();
	}

	@Override
	protected byte[] doInBackground(String... params) {
		// TODO Auto-generated method stub
		byte[] result = httpClientGet(params[0]);
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
			Log.e("xml", json);
			Gson gson = new Gson();
			// News newss = gson.fromJson(json, News.class);
			List<News> newss = gson.fromJson(json, new TypeToken<List<News>>() {
			}.getType());

			activity.updateUI(newss);

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
