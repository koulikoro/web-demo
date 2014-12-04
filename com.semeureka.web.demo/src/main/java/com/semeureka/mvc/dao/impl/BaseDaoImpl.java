package com.semeureka.mvc.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.semeureka.mvc.dao.BaseDao;

public class BaseDaoImpl<T, K extends Serializable> implements BaseDao<T, K> {
	private final Class<T> entityClass;
	@Autowired
	private SessionFactory sessionFactory;

	public BaseDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public K save(T entity) {
		return (K) currentSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		currentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(K id) {
		return (T) currentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return currentSession().createCriteria(entityClass).list();
	}
}