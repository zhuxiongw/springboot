package com.vivebest.mapper;

import com.vivebest.entity.User;

public interface UserMapper {
	int insertUserWithBackId(User user);
	
	User findByUsername(String username);
}
