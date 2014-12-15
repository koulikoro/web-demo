package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.PermissionDao;
import com.semeureka.mvc.entity.Permission;
import com.semeureka.mvc.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;

	@Override
	public Permission get(Integer id) {
		return id != null ? permissionDao.get(id) : null;
	}

	@Override
	public Permission getByValue(String value) {
		return permissionDao.getByValue(value);
	}

	@Override
	public List<Permission> find() {
		return permissionDao.find();
	}
}
