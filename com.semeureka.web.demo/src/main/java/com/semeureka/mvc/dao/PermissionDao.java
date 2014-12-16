package com.semeureka.mvc.dao;

import com.semeureka.mvc.entity.Permission;

public interface PermissionDao extends BaseDao<Permission> {
	Permission getByValue(String value);
}
