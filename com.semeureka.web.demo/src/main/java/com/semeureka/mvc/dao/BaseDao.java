package com.semeureka.mvc.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, K extends Serializable> {
	K save(T entity);

	void delete(T entity);

	T findById(K id);

	List<T> findAll();
}
