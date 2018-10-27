package com.news;
 
	import jerome.news.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
	public class SplashActivity extends Activity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			setContentView(R.layout.activity_splash);
			View view = findViewById(R.id.title);
		 
			view.postDelayed(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					     Intent in = new Intent(SplashActivity.this,Main.class);
					     
				         startActivity(in);
				         overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
				         finish();
				}
			}, 1500);
		}

	}

