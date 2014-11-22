package com.semeureka.mvc.service;

import com.semeureka.mvc.entity.User;

public interface UserService {

	User findById(Integer id);

	void save(User user);
}
