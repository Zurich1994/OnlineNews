package com.news.title;

import jerome.news.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class TitleView extends TextView {
	private Context mContext;
	private int index;

	public TitleView(Context context) {
		super(context);
		mContext = context;
		initView();
	}

	private void initView() {
		setTextColor(Color.WHITE);
		setTextSize(16);
		setPadding(20, 0, 20, 2);
	}

	public void setSelectedState(int flag) {
		if (flag == 1) {
			setTextColor(Color.rgb(119, 136, 153));
			Drawable index = mContext.getResources().getDrawable(
					R.drawable.title_selected);
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, index);
		} else {
			setTextColor(Color.WHITE);
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
