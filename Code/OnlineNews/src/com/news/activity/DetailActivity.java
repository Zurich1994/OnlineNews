package com.news.activity;

import jerome.news.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.news.comment.Commentlist;
import com.news.pic.ImageLoader2;
import com.news.util.NetUtil2;

public class DetailActivity extends Activity {

	TextView mTitle = null;
	TextView mWhere = null;
	TextView mContent = null;
	ImageView mImage = null;
	private String result = "";
	private String urlStr = "";
	private String imgUrl = "";
	ScrollView mScrollView = null;
	Button reload = null;
	Button coll = null;
	Button tak = null;
	TextView loadTip = null;
	LinearLayout detailLayout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.detail);
		init();

		Bundle bundle = getIntent().getExtras();
		if (null != bundle) {
			final String[] values = bundle.getStringArray("data");

			for (int i = 0; i < values.length; i++) {
				Log.e("value" + i, values[i]);
			}
			mTitle.setText(values[0]);
			mWhere.setText(values[1] + " " + values[2]);
			int beginIx = values[4].indexOf("http");
			int endIx = values[4].indexOf("jpg");
			if (beginIx != -1) {
				result = values[4].substring(beginIx, endIx);
				result = values[4].replaceAll(result, "");
				result = result.replace("jpg", "");
			} else
				result = values[4];
			mContent.setText(result);
			urlStr = values[3];
			final String Ul = urlStr
					.replace(
							"http://172.16.0.1:8080/HttpServer/getNewsServlet?news_id=",
							"");
			imgUrl = values[5];
			if (!"".equals(imgUrl)) {
				mImage.setTag(imgUrl);
				ImageLoader2.getInstance(null).loadImage(imgUrl, mImage);
			}
			if ("".equals(values[4].trim()) && !"".equals(values[3])) {
				reloadData();
			} else {
				mScrollView.setVisibility(View.VISIBLE);
				detailLayout.setVisibility(View.GONE);
			}
			Button coll = (Button) findViewById(R.id.coll);
			Button tak = (Button) findViewById(R.id.tak);
			coll.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Colle("http://172.16.0.1:8080/HttpServer/addCollectServlet?username=lihanlu&news_id="
							+ Ul);
					Toast.makeText(DetailActivity.this, "收藏成功",
							Toast.LENGTH_SHORT).show();
				}
			});
			tak.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Bundle mBundle = new Bundle();
					mBundle.putString("CommentId", Ul);
					Intent intent = new Intent();
					intent.setClass(DetailActivity.this, Commentlist.class);
					intent.putExtras(mBundle);

					startActivity(intent);
				}
			});

		}
	}

	private void Colle(final String url) {

		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(url);

					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {

						HttpEntity entity1 = httpResponse.getEntity();
						String response = EntityUtils
								.toString(entity1, "utf-8");
						Log.e("response", response);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	private void reloadData() {
		new Thread() {
			public void run() {
				Message msg = new Message();
				msg.what = 0;
				msg.obj = NetUtil2.getNewsContentByUrl(urlStr);
				mHandler.sendMessage(msg);
			}
		}.start();
	}

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				String textString = (String) msg.obj;
				if (null != textString && !"".equals(textString)) {
					// 判断是否接收到新闻
					mContent.setText(textString);
					mScrollView.setVisibility(View.VISIBLE);
					detailLayout.setVisibility(View.GONE);
				} else {
					mScrollView.setVisibility(View.GONE);
					detailLayout.setVisibility(View.VISIBLE);
					loadTip.setText(getString(R.string.tip_text_data_fail));
					reload.setVisibility(View.VISIBLE);
				}
				break;
			}
		}
	};

	private void init() {
		// 初始化各个组件
		mTitle = (TextView) findViewById(R.id.detail_title);
		mWhere = (TextView) findViewById(R.id.detail_where_time);
		mContent = (TextView) findViewById(R.id.detail_content);
		loadTip = (TextView) findViewById(R.id.detail_loading);
		mScrollView = (ScrollView) findViewById(R.id.main_scroll);
		mImage = (ImageView) findViewById(R.id.detail_image);
		reload = (Button) findViewById(R.id.detail_reload);

		detailLayout = (LinearLayout) findViewById(R.id.detail_load_layout);

		reload.setOnClickListener(new OnClickListener() {
			// 重新加载按钮的监听
			@Override
			public void onClick(View arg0) {
				mScrollView.setVisibility(View.GONE);
				detailLayout.setVisibility(View.VISIBLE);
				loadTip.setText(getString(R.string.tip_text_data_loading));
				reload.setVisibility(View.GONE);// 如果没有读取到新闻则显示
				reloadData();
			}

		});
	}
}
