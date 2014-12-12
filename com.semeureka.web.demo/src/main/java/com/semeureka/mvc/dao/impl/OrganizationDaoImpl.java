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
public class OrganizationDaoImpl extends BaseDaoImpl<Organization, Integer> implements OrganizationDao {
	@Override
	public Organization save(Organization entity) {
		if (entity.getId() == null) {
			entity.setCreateTime(new Date());
		} else {
			entity.setUpdateTime(new Date());
		}
		entity = super.save(entity);
		entity.setPath((entity.getParent() != null ? entity.getParent().getPath() : "") + entity.getId()
				+ Organization.PATH_DELIMETER);
		return entity;
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
