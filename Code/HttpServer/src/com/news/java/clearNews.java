package com.news.java;

import com.news.dao.impl.NewsDaoImpl;

public class clearNews {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsDaoImpl ndi = new NewsDaoImpl();
		ndi.deleteNews();
	}
}
