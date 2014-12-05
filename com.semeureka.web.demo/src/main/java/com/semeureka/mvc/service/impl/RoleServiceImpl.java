package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.RoleDao;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.service.RoleService;

@Service
@Transactional
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
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role findById(Integer id) {
		return roleDao.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}
}
