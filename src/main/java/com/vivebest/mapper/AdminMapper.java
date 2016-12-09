package com.vivebest.mapper;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vivebest.entity.Admin;
@Repository
public interface AdminMapper extends MongoRepository<Admin, Long> {
	Admin findByName(String name);
}
