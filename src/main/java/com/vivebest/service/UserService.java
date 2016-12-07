package com.vivebest.service;

import com.vivebest.entity.User;

public interface UserService {
	public int insertUserWithBackId(User user);
	
	public User findByUsername(String username);
}
