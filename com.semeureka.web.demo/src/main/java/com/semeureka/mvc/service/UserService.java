package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.User;

public interface UserService {
	void save(User user);

	void deleteById(Integer id);

	void update(User user);

	User findByUsername(String username);

	User findById(Integer id);

	List<User> findAll();
}
