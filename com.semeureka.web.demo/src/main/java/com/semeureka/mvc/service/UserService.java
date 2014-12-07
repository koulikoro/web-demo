package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.User;

public interface UserService {
	void save(User user);

	void deleteById(Integer id);

	void update(User user);

	User findByAccount(String account);

	User findById(Integer id);

	List<User> findAll();
}
