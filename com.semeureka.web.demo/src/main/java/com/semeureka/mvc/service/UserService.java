package com.semeureka.mvc.service;

import com.semeureka.mvc.entity.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
