package com.example.pyx;

import java.util.List;

import jerome.news.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CollListAdapter extends BaseAdapter {
	List<News> data;
	Context ctx;
	LayoutInflater inflater;
	TextView textView1;
	TextView textView2;

	public CollListAdapter(List<News> data, Context ctx) {
		super();
		this.data = data;
		this.ctx = ctx;
		// System.out.println(this.data.get(1).getGoods_name()+"****");
		inflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public News getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub

		return data.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// System.out.println(position+data.get(position).getGoods_name());
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_pyx, null);
		}

		// textView = (TextView) view.findViewById(R.id.list_item_title);
		News item = data.get(position);
		// Log.e("IMAGE_URL",url);
		// ImageView imageView1 = (ImageView)
		// convertView.findViewById(R.id.imageView1);
		textView1 = (TextView) convertView.findViewById(R.id.collect_title);
		textView2 = (TextView) convertView.findViewById(R.id.collect_date);
		textView1.setText(data.get(position).getTitle());
		textView2.setText(data.get(position).getDate());
		// convertView.setTag(item);
		// Button button1 = (Button) convertView.findViewById(R.id.button1);
		// button1.setTag(item);
		// button1.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View btn) {
		// // TODO Auto-generated method stub
		// News newss = (News) btn.getTag();
		//
		// }
		// });
		// textView.setText(data.get(position).getGoods_name());

		return convertView;
	}

}
