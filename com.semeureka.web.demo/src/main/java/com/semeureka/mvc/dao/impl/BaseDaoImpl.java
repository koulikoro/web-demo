package com.semeureka.mvc.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.semeureka.mvc.dao.BaseDao;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
	protected Class<T> entityClass;
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T save(T entity) {
		return (T) currentSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		currentSession().delete(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) currentSession().get(entityClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = currentSession().createCriteria(entityClass);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
}
