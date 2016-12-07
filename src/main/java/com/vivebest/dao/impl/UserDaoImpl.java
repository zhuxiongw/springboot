package com.vivebest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vivebest.dao.UserDao;
import com.vivebest.entity.User;
import com.vivebest.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insertUserWithBackId(User user) {
		return userMapper.insertUserWithBackId(user);
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	
	
	
}
