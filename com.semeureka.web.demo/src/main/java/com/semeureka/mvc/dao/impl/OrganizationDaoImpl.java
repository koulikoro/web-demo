package com.semeureka.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.OrganizationDao;
import com.semeureka.mvc.entity.Organization;

@Repository
public class OrganizationDaoImpl extends BaseDaoImpl<Organization, Integer> implements OrganizationDao {
	public OrganizationDaoImpl() {
		super(Organization.class);
	}
}
