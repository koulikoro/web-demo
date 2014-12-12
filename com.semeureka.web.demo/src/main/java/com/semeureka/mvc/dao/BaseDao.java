package com.semeureka.mvc.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	T save(T entity);

	void delete(T entity);

	T findById(ID id);

	List<T> findAll();
}
