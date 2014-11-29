package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);

	List<User> findAll();

	void deleteById(Integer id);
}
