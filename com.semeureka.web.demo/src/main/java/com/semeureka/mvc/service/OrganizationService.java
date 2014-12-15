package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Organization;

public interface OrganizationService {
	void save(Organization organization);

	void delete(Organization organization);

	void update(Organization organization);

	Organization get(Integer id);

	List<Organization> find(Organization parent);
}
