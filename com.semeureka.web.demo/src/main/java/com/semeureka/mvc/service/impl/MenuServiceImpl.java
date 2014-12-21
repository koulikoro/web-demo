package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.MenuDao;
import com.semeureka.mvc.entity.Menu;
import com.semeureka.mvc.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public Menu get(Integer id) {
		return menuDao.get(id);
	}

	@Override
	public List<Menu> findByUrl(String url) {
		return menuDao.findByUrl(url);
	}

	@Override
	public List<Menu> find() {
		return menuDao.find();
	}

}
