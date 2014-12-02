package com.semeureka.mvc.service;

import com.semeureka.mvc.entity.Permission;

public interface PermissionService {
	Permission findByName(String name);
}
