package com.semeureka.mvc.service.impl;

import java.util.List;

import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.UserDao;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordService passwordService;

	@Override
	public void save(User user) {
		user.setPassword(passwordService.encryptPassword(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		User user = userDao.findById(id);
		if (user != null) {
			userDao.delete(user);
		}
	}
}
