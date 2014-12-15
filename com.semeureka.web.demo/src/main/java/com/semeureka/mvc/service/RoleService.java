package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Role;

public interface RoleService {
	void save(Role role);

	void delete(Role role);

	void update(Role role);

	Role get(Integer id);

	List<Role> find();
}
