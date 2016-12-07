package com.vivebest.dao;

import com.vivebest.entity.User;

public interface UserDao {
	int insertUserWithBackId(User user);
	
	User findByUsername(String username);
}
