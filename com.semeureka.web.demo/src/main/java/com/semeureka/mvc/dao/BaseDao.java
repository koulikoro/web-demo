package com.semeureka.mvc.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	T save(T entity);

	void delete(T entity);

	T update(T entity);

	T get(Serializable id);

	List<T> find();
}