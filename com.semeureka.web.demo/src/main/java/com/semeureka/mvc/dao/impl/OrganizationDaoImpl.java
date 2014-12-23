package com.semeureka.mvc.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.OrganizationDao;
import com.semeureka.mvc.entity.Organization;

@Repository
public class OrganizationDaoImpl extends BaseDaoImpl<Organization> implements OrganizationDao {

	// calculate the organization's path
	private Organization calculatePath(Organization organization) {
		Organization parent = organization.getParent();
		organization.setPath((parent != null ? parent.getPath() : "") + organization.getId()
				+ Organization.PATH_DELIMETER);
		return organization;
	}

	@Override
	public Organization save(Organization entity) {
		entity.setCreateTime(new Date());
		// Must calculate path after a entity has a ID
		return calculatePath(super.save(entity));
	}

	@Override
	public Organization update(Organization entity) {
		entity.setUpdateTime(new Date());
		calculatePath(entity);
		return super.update(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Organization> find(Organization parent) {
		Criteria criteria = currentSession().createCriteria(Organization.class);
		if (parent != null) {
			criteria.add(Restrictions.like("path", parent.getPath(), MatchMode.START));
		}
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
}
