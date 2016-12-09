package com.vivebest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivebest.dao.AdminDao;
import com.vivebest.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Override
	public Admin findByName(String name) {
		return adminDao.findByName(name);
	}

}
