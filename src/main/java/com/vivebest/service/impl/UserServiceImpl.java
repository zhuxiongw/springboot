package com.vivebest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivebest.dao.UserDao;
import com.vivebest.entity.User;
import com.vivebest.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public int insertUserWithBackId(User user) {
		return userDao.insertUserWithBackId(user);
	}
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
