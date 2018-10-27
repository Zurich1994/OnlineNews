package com.news.comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jerome.news.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

@SuppressLint("HandlerLeak")
public class Commentlist extends Activity {
	ListView listView;
	SimpleAdapter Sadp;
	ImageButton bt;
	ArrayList<HashMap<String, String>> mylist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commentlist);
		// TODO Auto-generated method stub
		Bundle bundle = getIntent().getExtras(); // 得到传过来的bundle
		String CommentId = bundle.getString("CommentId");// 读出数据
		String url = "http://172.16.0.1:8080/HttpServer/getCommentServlet?news_id="
				+ "325" + "&page=1";

		listView = (ListView) findViewById(R.id.listView);
		HttpTask1 task = new HttpTask1(this, 2);
		task.execute(url);
		ImageButton bt = (ImageButton) findViewById(R.id.back4);// 返回功能界面
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	public void updateUI(List<Comment0> comment) {
		mylist = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < comment.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("username", comment.get(i).getUser_name());
			map.put("comment_body", comment.get(i).getComment_body());
			mylist.add(map);
		}
		Sadp = new SimpleAdapter(this, mylist, R.layout.commentlistitem,
				new String[] { "username", "comment_body" }, new int[] {
						R.id.text_id, R.id.text_comment });
		listView.setAdapter(Sadp);

	}
}
