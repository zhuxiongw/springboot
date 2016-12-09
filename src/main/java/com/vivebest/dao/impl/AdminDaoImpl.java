package com.vivebest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vivebest.dao.AdminDao;
import com.vivebest.entity.Admin;
import com.vivebest.mapper.AdminMapper;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin findByName(String name) {
		return adminMapper.findByName(name);
	}
}
