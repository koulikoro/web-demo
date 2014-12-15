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
	public void delete(Role role) {
		roleDao.delete(role);
	}

	@Override
	public Role get(Integer id) {
		return id != null ? roleDao.get(id) : null;
	}

	@Override
	public void update(Role role) {
		roleDao.save(role);
	}

	@Override
	public List<Role> find() {
		return roleDao.find();
	}
}
