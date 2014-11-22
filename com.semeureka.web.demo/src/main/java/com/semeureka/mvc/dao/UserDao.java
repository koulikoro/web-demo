package com.semeureka.mvc.dao;

import com.semeureka.mvc.entity.User;

public interface UserDao {

	User findById(Integer id);

	void save(User user);
}
