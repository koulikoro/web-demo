package com.semeureka.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.UserDao;
import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
	@Override
	public User findByAccount(String account) {
		Criteria criteria = currentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("account", account));
		return (User) criteria.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> find(Organization organization) {
		Criteria criteria = currentSession().createCriteria(User.class);
		criteria.createAlias("organization", "Organization", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.like("Organization.path", organization.getPath() + Organization.PATH_DELIMETER,
				MatchMode.START));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
}
