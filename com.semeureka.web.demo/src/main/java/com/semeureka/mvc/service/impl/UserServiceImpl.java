package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.UserDao;
import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		User user = userDao.findById(id);
		if (user != null) {
			userDao.delete(user);
		}
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public User findByAccount(String account) {
		return userDao.findByAccount(account);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> find(Organization parent) {
		return userDao.find(parent);
	}
}
