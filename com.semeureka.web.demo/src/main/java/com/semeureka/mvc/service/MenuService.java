package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Menu;

public interface MenuService {

	Menu get(Integer id);

	List<Menu> findByUrl(String url);

	List<Menu> find();

}
