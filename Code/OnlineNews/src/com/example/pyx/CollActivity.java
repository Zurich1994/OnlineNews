package com.example.pyx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jerome.news.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CollActivity extends Activity {
	public static String url = "http://172.16.0.1:8080/HttpServer/getCollectServlet?username=lihanlu";
	// http://172.16.0.1:8080/HttpServer/getCollectServlet?username=lihanlu
	String userid = "panyuxin";
	ListView listView;
	List<News> news;
	private ArrayList<HashMap<String, String>> mylist;
	SimpleAdapter smpA;
	public Button brn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Intent intent = getIntent();
		// int typeids = intent.getIntExtra("position", 0);
		// typeid=String.valueOf(typeids);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coll_act);
		// bt1 = (Button) findViewById(R.id.button4);
		brn = (Button) findViewById(R.id.button_reback_collection);
		listView = (ListView) findViewById(R.id.listView_Collection);
		brn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		String url = "http://172.16.0.1:8080/HttpServer/getCollectServlet?username=lihanlu";
		HttpTask0 task = new HttpTask0(CollActivity.this);
		task.execute(url);
	}

	class ListClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			String text = listView.getItemAtPosition(position) + "";
			Log.i("tag", text);
			// 收藏的新闻详情页面请求
			//
			//
			//
		}
	}

	public void updateUI(List<News> news) {

		CollListAdapter adapter = new CollListAdapter(news, this);
		listView.setAdapter(adapter);
		ListClickListener l = new ListClickListener();
		listView.setOnItemClickListener(l);
		// mylist = new ArrayList<HashMap<String, String>>();
		// for (int i = 0; i < news.size(); i++) {
		// HashMap<String, String> map = new HashMap<String, String>();
		// map.put("title", news.get(i).getTitle());
		// map.put("date", news.get(i).getDate());
		//
		// mylist.add(map);
		// }
		// smpA = new SimpleAdapter(this, mylist, R.layout.item_pyx, new
		// String[] {
		// "title", "date" }, new int[] { R.id.collect_title,
		// R.id.collect_date });
		// listView.setAdapter(smpA);

	}
}
