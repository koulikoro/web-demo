package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

public interface UserService {
	void save(User user);

	void delete(User user);

	void update(User user);

	User get(Integer id);

	User getByAccount(String account);

	List<User> find(Organization parent);
}
