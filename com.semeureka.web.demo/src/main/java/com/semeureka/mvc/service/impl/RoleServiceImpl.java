package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semeureka.mvc.dao.RoleDao;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
	public void deleteById(Integer id) {
		Role role = roleDao.findById(id);
		if (role != null) {
			roleDao.delete(role);
		}
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}
}
