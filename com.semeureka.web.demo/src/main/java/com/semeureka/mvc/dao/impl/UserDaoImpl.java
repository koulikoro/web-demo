package com.semeureka.mvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.UserDao;
import com.semeureka.mvc.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User findByUsername(String username) {
		Criteria criteria = currentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}
}
