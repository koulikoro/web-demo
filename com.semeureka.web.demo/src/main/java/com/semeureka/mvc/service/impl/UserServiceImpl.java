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
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User get(Integer id) {
		return id != null ? userDao.get(id) : null;
	}

	@Override
	public User getByAccount(String account) {
		return userDao.getByAccount(account);
	}

	@Override
	public List<User> find(Organization parent) {
		return userDao.find(parent);
	}
}
