package com.semeureka.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.UserDao;
import com.semeureka.mvc.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User findByUsername(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	@Override
	public User findById(Integer id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
}
