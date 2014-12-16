package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.OrganizationDao;
import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public void save(Organization organization) {
		organizationDao.save(organization);
	}

	@Override
	public void delete(Organization organization) {
		organizationDao.delete(organization);
	}

	@Override
	public void update(Organization organization) {
		organizationDao.update(organization);
	}

	@Override
	public Organization get(Integer id) {
		return id != null ? organizationDao.get(id) : null;
	}

	@Override
	public List<Organization> find(Organization parent) {
		return organizationDao.find(parent);
	}
}
