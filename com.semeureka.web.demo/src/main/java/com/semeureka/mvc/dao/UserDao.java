package com.semeureka.mvc.dao;

import com.semeureka.mvc.entity.User;

public interface UserDao {
	void save(User user);

	User findByUsername(String username);
}
