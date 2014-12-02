package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Role;

public interface RoleService {
	void save(Role role);

	void deleteById(Integer id);

	List<Role> findAll();

	Role findById(Integer id);
}
