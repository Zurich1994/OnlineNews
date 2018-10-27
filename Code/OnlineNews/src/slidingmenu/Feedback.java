package slidingmenu;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jerome.news.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Feedback extends Activity {

	public static final int SHOW_RESPONSE = 0;
	TextView show;// 显示反馈意见发送成功
	String value1;// 第一次http请求获取的值
	String url0 = "http://172.16.0.1:8080/HttpServer/feedbackServlet";// pyx//
																		// 请求服务器地址

	// http://172.16.0.1:8080/HttpServer/feedbackServlet?feedback=heheh&tel=18611033308

	private Button bt1;
	private Button bt2;
	private EditText et1;
	private EditText et2;
	private String text_1;
	private String text_2;

	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String response = (String) msg.obj;
				show.setText(response + "感谢您的支持您的建议对我们很有用");
			}
		}
	};

	/* pyx将反馈意见发送到服务器 */
	static String httpClientPost1(String url, String feedback, String tel) {
		try {

			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(URI.create(url));
			// 创建请求体
			List<NameValuePair> pairList = new ArrayList<NameValuePair>();
			NameValuePair pair1 = new BasicNameValuePair("feedback", feedback);
			NameValuePair pair2 = new BasicNameValuePair("tel", tel);
			pairList.add(pair1);
			pairList.add(pair2);
			UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(
					pairList, "UTF-8");
			request.setEntity(requestEntity);
			HttpResponse resp = client.execute(request);
			HttpEntity resEntity = resp.getEntity();
			String result = EntityUtils.toString(resEntity);
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);

		bt1 = (Button) findViewById(R.id.button5);
		bt2 = (Button) findViewById(R.id.button6);
		show = (TextView) findViewById(R.id.button_show_back);
		et1 = (EditText) findViewById(R.id.editText);
		et2 = (EditText) findViewById(R.id.editText2);

		bt1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						TextWatcher textWatcher0 = new TextWatcher() {
							public void afterTextChanged(Editable s) {
								String text1 = et1.getText().toString();
								text_1 = text1;
							}

							public void beforeTextChanged(CharSequence s,
									int start, int count, int after) {
							}

							public void onTextChanged(CharSequence s,
									int start, int before, int count) {
							}
						};
						TextWatcher textWatcher1 = new TextWatcher() {
							public void afterTextChanged(Editable s) {
								String text2 = et2.getText().toString();
								text_2 = text2;

							}

							public void beforeTextChanged(CharSequence s,
									int start, int count, int after) {
							}

							public void onTextChanged(CharSequence s,
									int start, int before, int count) {
							}
						};
						et1.addTextChangedListener(textWatcher0);
						et2.addTextChangedListener(textWatcher1);
						value1 = httpClientPost1(url0, text_2, text_1);
						Message message = new Message();
						message.what = SHOW_RESPONSE;
						message.obj = value1.toString();
						handler.sendMessage(message);
					}

				}).start();

			}
		});
		//pyx返回
		 bt2.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                finish();
	            }
	        });
	}
	  
}
