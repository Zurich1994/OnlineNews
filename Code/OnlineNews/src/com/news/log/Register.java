package com.news.log;

import jerome.news.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

	private EditText username;
	private EditText userpassword;
	private EditText userpassword1;
	private String userNameValue, passwordValue, passwordValue1;
	private Button res;
	private Button Up;
	private int match = -1;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		// 初始化用户名、密码、记住密码、自动登录、登录按钮
		username = (EditText) findViewById(R.id.r_username);
		userpassword = (EditText) findViewById(R.id.r_userpassword);
		userpassword1 = (EditText) findViewById(R.id.r_userpassword1);
		res = (Button) findViewById(R.id.register);

		Up = (Button) findViewById(R.id.Up);
		Up.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Register.this, com.news.Main.class);
				Register.this.finish();
				startActivity(intent);
			}
		});
		res.setOnClickListener(new OnClickListener() {// 联网检查账号密码是否匹配

			@Override
			public void onClick(View arg0) {
				userNameValue = username.getText().toString();
				passwordValue = userpassword.getText().toString();
				passwordValue1 = userpassword1.getText().toString();

				SIn(userNameValue, passwordValue);
				if (passwordValue.equals(passwordValue1))
					if (SIn(userNameValue, passwordValue) == 1) {
						Toast.makeText(Register.this, "注册成功",
								Toast.LENGTH_SHORT).show();

						Register.this.finish();

					} else {
						Toast.makeText(Register.this, "用户名已存在!",
								Toast.LENGTH_SHORT).show();
					}

				else {
					Toast.makeText(Register.this, "两次密码不一致，请重新输入!",
							Toast.LENGTH_SHORT).show();
				}

			}

		});

	}

	private int SIn(final String ID, final String PW) {

		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(
							"http://172.16.0.1:8080/HttpServer/LoginOrRegister?what=register&username="
									+ ID + "&password=" + PW);

					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {

						HttpEntity entity1 = httpResponse.getEntity();
						String response = EntityUtils
								.toString(entity1, "utf-8");
						Log.e("response", response);
						if (response.equals("true")) {

							match = 1;
						} else {

							match = 0;
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		return match;

	}
}
