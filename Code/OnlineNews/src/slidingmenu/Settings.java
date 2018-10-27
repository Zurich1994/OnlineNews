package slidingmenu;

import jerome.news.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Settings extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		View back = findViewById(R.id.icon_SettingsTop);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();

			}
		});

		// View bt2=(Button)findViewById(R.id.button_About);//pyx跳转到关于界面
		// Button bt3=(Button)findViewById(R.id.button_Feedback);//pyx跳转到反馈界面
		// Button
		// bt4=(Button)findViewById(R.id.button_CoverStory);//pyx跳转到封面故事界面
		// bt1.setOnClickListener(new View.OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// finish();
		//
		// }
		// });
		// bt2.setOnClickListener(new View.OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// startActivity(new Intent("com.litreily.About"));
		//
		//
		// }
		// });
		//
		// bt3.setOnClickListener(new View.OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// startActivity(new Intent("com.litreily.Feedback"));
		//
		//
		// }
		// });
		//
		// bt4.setOnClickListener(new View.OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// startActivity(new Intent("com.litreily.Story"));
		//
		//
		// }
		// });
		//
		//
	}

}
