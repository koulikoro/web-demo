package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.OrganizationDao;
import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.misc.ShiroUtils;
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
	public void deleteById(Integer id) {
		Organization organization = organizationDao.findById(id);
		if (organization != null) {
			organizationDao.delete(organization);
		}
	}

	@Override
	public void update(Organization organization) {
		organizationDao.update(organization);
	}

	@Override
	public Organization findById(Integer id) {
		return organizationDao.findById(id);
	}

	@Override
	public List<Organization> findAll() {
		return organizationDao.find(((User) ShiroUtils.principal()).getOrganization());
	}
}
