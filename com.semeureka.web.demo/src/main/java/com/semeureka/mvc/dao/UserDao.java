package com.semeureka.mvc.dao;

import java.util.List;

import com.semeureka.mvc.entity.User;

public interface UserDao {
	void save(User user);

	User findByUsername(String username);

	List<User> findAll();

	User findById(Integer id);

	void delete(User user);
}
