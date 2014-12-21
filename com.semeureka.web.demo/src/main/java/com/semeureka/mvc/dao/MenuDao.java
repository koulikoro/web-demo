package com.semeureka.mvc.dao;

import java.util.List;

import com.semeureka.mvc.entity.Menu;

public interface MenuDao extends BaseDao<Menu> {

	List<Menu> findByUrl(String url);

}
