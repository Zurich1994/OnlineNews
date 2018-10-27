package com.news.dao;

import com.news.bean.UserBean;

public interface UserDao {
	UserBean selectUserByUname(String username);
	Boolean isHaveThisUser(String username);
	void upadteUser(UserBean ub);
	void addUser(String username, String password);
}
