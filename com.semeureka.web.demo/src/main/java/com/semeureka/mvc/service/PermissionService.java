package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Permission;

public interface PermissionService {
	Permission findByValue(String value);

	List<Permission> findAll();
}
