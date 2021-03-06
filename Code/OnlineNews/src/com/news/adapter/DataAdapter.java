package com.news.adapter;

import java.util.ArrayList;
import java.util.List;

import jerome.news.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.data.NewsBrief;
import com.news.pic.ImageLoader2;

public class DataAdapter extends BaseAdapter {
	Context mContext = null;
	LayoutInflater inflater;
	List<NewsBrief> newsData = new ArrayList<NewsBrief>();

	public DataAdapter(Context context, List<NewsBrief> nList) {
		mContext = context;
		inflater = LayoutInflater.from(context);
		newsData = nList;
	}

	@Override
	public int getCount() {
		return newsData.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HolderView hView = null;
		if (null == convertView) {
			hView = new HolderView();
			convertView = inflater.inflate(R.layout.list_item, null);
			hView.image = (ImageView) convertView.findViewById(R.id.news_image);
			hView.title = (TextView) convertView.findViewById(R.id.news_title);

			hView.where = (TextView) convertView.findViewById(R.id.news_where);
			hView.date = (TextView) convertView.findViewById(R.id.news_time);
			convertView.setTag(hView);
		} else {
			hView = (HolderView) convertView.getTag();
		}

		hView.title.setText(newsData.get(position).getTitle());

		hView.where.setText(newsData.get(position).getSource());
		hView.date.setText(newsData.get(position).getPubDate());

		if (null != newsData.get(position).getImgUrl()
				&& !"".equals(newsData.get(position).getImgUrl())) {
			hView.image.setTag(newsData.get(position).getImgUrl());
			ImageLoader2.getInstance(mContext).loadImage(
					newsData.get(position).getImgUrl(), hView.image);
		} else {
			hView.image.setImageResource(R.drawable.icon_image_default);
		}

		return convertView;
	}

	public class HolderView {
		private ImageView image = null;
		private TextView title = null;
		private TextView where = null;
		private TextView date = null;
	}

}
