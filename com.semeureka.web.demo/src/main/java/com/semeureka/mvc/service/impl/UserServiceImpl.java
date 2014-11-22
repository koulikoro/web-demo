package com.semeureka.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semeureka.mvc.dao.UserDao;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

}
