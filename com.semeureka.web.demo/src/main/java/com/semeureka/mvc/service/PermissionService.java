package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Permission;

public interface PermissionService {
	Permission get(Integer id);

	Permission getByValue(String value);

	List<Permission> find();
}
