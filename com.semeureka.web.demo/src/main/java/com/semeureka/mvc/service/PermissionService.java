package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Permission;

public interface PermissionService {
	Permission findByName(String name);

	List<Permission> findAll();
}
