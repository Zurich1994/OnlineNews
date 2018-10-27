package com.news.dao;

import com.news.bean.StaffBean;
import com.news.bean.UserBean;

public interface StaffDao {
	StaffBean selectUserByUname(String username);
	Boolean isHaveThisUser(String username);
	void addStaff(StaffBean sb);
}
