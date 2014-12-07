package com.semeureka.mvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.RoleDao;
import com.semeureka.mvc.entity.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao {
	@Override
	public Role findByName(String name) {
		Criteria criteria = currentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("name", name));
		return (Role) criteria.uniqueResult();
	}
}
