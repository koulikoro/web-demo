package com.semeureka.mvc.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	void save(T entity);

	void delete(T entity);

	void update(T entity);

	T findById(ID id);

	List<T> findAll();
}
