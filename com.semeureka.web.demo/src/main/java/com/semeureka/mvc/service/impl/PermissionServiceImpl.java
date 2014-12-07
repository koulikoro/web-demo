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
	public Permission findByValue(String value) {
		return permissionDao.findByValue(value);
	}

	@Override
	public List<Permission> findAll() {
		return permissionDao.findAll();
	}
}
