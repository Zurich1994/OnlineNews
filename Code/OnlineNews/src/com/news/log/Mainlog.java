package com.news.log;

import jerome.news.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Mainlog extends Activity {
	private EditText username;
	private EditText userpassword;
	private CheckBox remember;
	private CheckBox autologin;
	private Button login;
	private SharedPreferences sp;
	private String userNameValue, passwordValue;
	private Button res;
	private boolean match;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// 初始化用户名、密码、记住密码、自动登录、登录按钮
		username = (EditText) findViewById(R.id.username);
		userpassword = (EditText) findViewById(R.id.userpassword);
		remember = (CheckBox) findViewById(R.id.remember);
		autologin = (CheckBox) findViewById(R.id.autologin);
		login = (Button) findViewById(R.id.login);
		res = (Button) findViewById(R.id.res1);
		sp = getSharedPreferences("userInfo", 0);
		String name = sp.getString("USER_NAME", "");
		String pass = sp.getString("PASSWORD", "");

		boolean choseRemember = sp.getBoolean("remember", false);
		boolean choseAutoLogin = sp.getBoolean("autologin", false);

		if (choseRemember) {
			username.setText(name);
			userpassword.setText(pass);
			remember.setChecked(true);
		}
		if (choseAutoLogin) {
			autologin.setChecked(true);
		}
		res.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Mainlog.this,
						com.news.log.Register.class);
				Mainlog.this.finish();
				startActivity(intent);
			}
		});
		login.setOnClickListener(new OnClickListener() {// 联网检查账号密码是否匹配

			@Override
			public void onClick(View arg0) {
				userNameValue = username.getText().toString();
				passwordValue = userpassword.getText().toString();
				SharedPreferences.Editor editor = sp.edit();
				if (LogIn(userNameValue, passwordValue))
					Toast.makeText(Mainlog.this, "校验中", Toast.LENGTH_SHORT)
							.show();
				if (LogIn(userNameValue, passwordValue)) {
					Toast.makeText(Mainlog.this, "登录成功", Toast.LENGTH_SHORT)
							.show();

					// 保存用户名和密码
					editor.putString("USER_NAME", userNameValue);
					editor.putString("PASSWORD", passwordValue);

					// 是否记住密码
					if (remember.isChecked()) {
						editor.putBoolean("remember", true);
					} else {
						editor.putBoolean("remember", false);
					}

					// 是否自动登录
					if (autologin.isChecked()) {
						editor.putBoolean("autologin", true);
					} else {
						editor.putBoolean("autologin", false);
					}
					editor.commit();
					Intent Intent = new Intent(Mainlog.this,
							com.news.Main.class);

					Mainlog.this.finish();
					startActivity(Intent);

				} else {
					Toast.makeText(Mainlog.this, "用户名或密码错误，请重新登录!",
							Toast.LENGTH_SHORT).show();
				}

			}

		});

	}

	private boolean LogIn(final String ID, final String PW) {

		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(
							"http://172.16.0.1:8080/HttpServer/LoginOrRegister?what=login&username="
									+ ID + "&password=" + PW);

					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {

						HttpEntity entity1 = httpResponse.getEntity();
						String response = EntityUtils
								.toString(entity1, "utf-8");
						Log.e("response", response);
						if (response.equals("true")) {

							match = true;
						} else {

							match = false;
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
