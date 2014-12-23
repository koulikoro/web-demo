package com.semeureka.mvc.dao;

import java.util.List;

import com.semeureka.mvc.entity.Organization;

public interface OrganizationDao extends BaseDao<Organization> {

	List<Organization> find(Organization parent);
}
