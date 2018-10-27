package slidingmenu;

import jerome.news.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class Comment extends Activity {

	public static final int SHOW_RESPONSE = 0;
	TextView show;// 显示发送成功
	String value1;// 第一次http请求获取的值
	String url = "http://172.16.0.1:8080/HttpServer/commentServlet?";
	// 请求服务器地址

	private ImageButton bt;
	private EditText et;
	private String text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment);
		ImageButton bt1 = (ImageButton) findViewById(R.id.back);// 返回功能界面
		bt1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		bt = (ImageButton) findViewById(R.id.fabu);
		et = (EditText) findViewById(R.id.text_fabu);

		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				httpClientPost1();

			}
		});

	}

	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String response = (String) msg.obj;
				show.setText(response + " ");
			}
		}
	};

	/* 将评论发送到服务器 */
	static void httpClientPost1() {

		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(
							"http://172.16.0.1:8080/HttpServer/commentServlet?username=liu&comment=hehehe&news_id=330");

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

}
