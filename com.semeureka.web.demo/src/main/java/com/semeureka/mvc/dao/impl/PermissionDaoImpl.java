package com.semeureka.mvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.PermissionDao;
import com.semeureka.mvc.entity.Permission;

@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission, Integer> implements PermissionDao {
	public PermissionDaoImpl() {
		super(Permission.class);
	}

	@Override
	public Permission findByName(String name) {
		Criteria criteria = currentSession().createCriteria(Permission.class);
		criteria.add(Restrictions.eq("name", name));
		return (Permission) criteria.uniqueResult();
	}
}
