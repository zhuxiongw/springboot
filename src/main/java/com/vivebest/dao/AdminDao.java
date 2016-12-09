package com.vivebest.dao;

import org.springframework.stereotype.Repository;

import com.vivebest.entity.Admin;

public interface AdminDao {
	Admin findByName(String name);
}	
