package com.semeureka.mvc.dao;

import com.semeureka.mvc.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	User findByUsername(String username);
}
