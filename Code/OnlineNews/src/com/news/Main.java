package com.news;

import jerome.news.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pyx.CollActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.news.adapter.FragAdapter;
import com.news.pic.ImageLoader2;
import com.news.title.TitleView;
import com.news.util.DepthPageTransformer;
import com.news.util.NetUtil2;

public class Main extends SlidingFragmentActivity {
	private ViewPager vPager;
	private FragAdapter adapter;
	private LinearLayout titleLayout = null;
	private ImageView button;
	private SharedPreferences sp;
	private TextView talk;
	View Mainlog;
	View Collection;
	View Headlines;
	View Settings;
	View Comment;
	View Push;
	View FeedBack;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		initSlidingMenu(savedInstanceState);

		button = (ImageView) findViewById(R.id.title_bar_menu_btn);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				toggle();// 尽心SlidingMenu的打开与关闭
			}
		});
		initLayout();
		initViewPage();
		initTitle();

	}

	/**
	 * 初始化滑动菜单
	 */
	private void initSlidingMenu(Bundle savedInstanceState) {
		// 设置滑动菜单的属性值
		// getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		// getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		getSlidingMenu().setShadowWidthRes(R.dimen.shadow_width);
		getSlidingMenu().setShadowDrawable(R.drawable.shadow);
		getSlidingMenu().setBehindOffsetRes(R.dimen.slidingmenu_offset);
		getSlidingMenu().setFadeDegree(0.35f);

		// 设置滑动菜单的左视图界面
		setBehindContentView(R.layout.menuframe_l);

		talk = (TextView) findViewById(R.id.talk);
		sp = getSharedPreferences("userInfo", 0);
		String name = sp.getString("USER_NAME", "");
		boolean choseAutoLogin = sp.getBoolean("autologin", false);
		if (choseAutoLogin) {
			talk.setVisibility(0);

			talk.setText(name + "自动登录成功");
		}

		Push = findViewById(R.id.Push);
		Push.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("News.MY_SERVICE");
				startService(intent);
			}
		});
		Mainlog = findViewById(R.id.Login);
		Mainlog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Main.this,
						com.news.log.Mainlog.class);
				startActivity(intent);

			}
		});
		// 设置点击跳转
		Collection = findViewById(R.id.Collection);
		Collection.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Main.this, CollActivity.class);
				startActivity(intent);
			}
		});
		Headlines = findViewById(R.id.Headlines);
		Headlines.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent Intent = new Intent(Main.this,
						slidingmenu.Headlines.class);
				startActivity(Intent);
			}
		});

		Settings = findViewById(R.id.Settings);
		Settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent Intent = new Intent(Main.this,
						slidingmenu.Settings.class);
				startActivity(Intent);
			}
		});

		Comment = findViewById(R.id.Comment);
		Comment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent Intent = new Intent(Main.this, slidingmenu.Comment.class);
				startActivity(Intent);
			}
		});

		FeedBack = findViewById(R.id.FeedBacks);
		FeedBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent Intent = new Intent(Main.this,
						slidingmenu.Feedback.class);
				startActivity(Intent);
			}
		});
	}

	/**
	 * 菜单按钮点击事件，通过点击ActionBar的Home图标按钮来打开滑动菜单
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initLayout() {
		vPager = (ViewPager) findViewById(R.id.main_page);
		titleLayout = (LinearLayout) findViewById(R.id.main_title);

	}

	private void initViewPage() {
		Resources res = getResources();
		vPager.setOffscreenPageLimit(8);
		adapter = new FragAdapter(getSupportFragmentManager(),
				res.getStringArray(R.array.channel_names),
				res.getIntArray(R.array.channel_ids));
		vPager.setAdapter(adapter);

		changeTitleState(0);

		vPager.setOnPageChangeListener(new MyVPageChangeListener());
		vPager.setPageTransformer(true, new DepthPageTransformer());
		NetUtil2.getInstance().start();
	}

	private void initTitle() {
		Resources res = getResources();
		String[] names = res.getStringArray(R.array.channel_names);
		int[] ids = res.getIntArray(R.array.channel_ids);
		for (int i = 0; i < names.length; i++) {
			TitleView titleView = new TitleView(this);
			titleView.setText(names[i]);
			titleView.setIndex(ids[i]);
			if (i == 0) {
				titleView.setSelectedState(1);
			}
			titleView.setOnClickListener(titleClick);
			titleLayout.addView(titleView);
		}
	}

	private class MyVPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int state) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int location) {
			changeTitleState(location);
			if (location <= 1 && titleLayout.getScrollX() != 0) {

			}
		}

	}

	private void changeTitleState(int location) {
		// 改变分类状态
		for (int i = 0; i < titleLayout.getChildCount(); i++) {
			TitleView titleView = (TitleView) titleLayout.getChildAt(i);
			if (location == titleView.getIndex()) {
				titleView.setSelectedState(1);
			} else {
				titleView.setSelectedState(0);
			}
		}
		vPager.setCurrentItem(location);
		NetUtil2.getInstance().setCurrentPage(location);
	}

	OnClickListener titleClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			TitleView currentView = (TitleView) arg0;
			changeTitleState(currentView.getIndex());
		}

	};

	@Override
	protected void onPause() {
		NetUtil2.getInstance().onThreadPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		NetUtil2.getInstance().onThreadResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ImageLoader2.getInstance(getApplicationContext()).clearPic();
		System.exit(0);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitAPP();
			return false;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	private void exitAPP() {
		new AlertDialog.Builder(this)
				.setTitle(getString(R.string.exit_title))
				.setMessage(getString(R.string.exit_tip))
				.setPositiveButton(getString(R.string.exit_submit),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								NetUtil2.getInstance().closeThread();
								finish();
							}

						})
				.setNegativeButton(getString(R.string.exit_cancel),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {

							}

						}).show();
	}

	int index = 0;

}
