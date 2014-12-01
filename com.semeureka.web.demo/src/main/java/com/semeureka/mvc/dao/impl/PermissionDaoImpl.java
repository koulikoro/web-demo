package com.semeureka.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.PermissionDao;
import com.semeureka.mvc.entity.Permission;

@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission, Integer> implements PermissionDao {
	public PermissionDaoImpl() {
		super(Permission.class);
	}
}
