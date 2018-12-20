package com.shop.dao;

import java.util.List;

import com.shop.model.User;


public interface UserDao {
	void insertUser(User user);
	List<User> userList();
	User get(String userEmail);

}
