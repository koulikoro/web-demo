package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Organization;

public interface OrganizationService {
	void save(Organization organization);

	void deleteById(Integer id);

	void update(Organization organization);

	Organization findById(Integer id);

	List<Organization> find(Organization parent);
}
