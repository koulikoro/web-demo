package com.semeureka.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.MenuDao;
import com.semeureka.mvc.entity.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {
	// calculate the menu's path
	private Menu calculatePath(Menu menu) {
		Menu parent = menu.getParent();
		menu.setPath((parent != null ? parent.getPath() : "") + menu.getId() + Menu.PATH_DELIMETER);
		return menu;
	}

	@Override
	public Menu save(Menu entity) {
		// Must calculate path after a entity has a ID
		return calculatePath(super.save(entity));
	}

	@Override
	public Menu update(Menu entity) {
		calculatePath(entity);
		return super.update(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Menu> findByUrl(String url) {
		Criteria criteria = currentSession().createCriteria(Menu.class);
		criteria.add(Restrictions.like("url", url, MatchMode.START));
		criteria.addOrder(Order.asc("path"));
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Menu> find() {
		Criteria criteria = currentSession().createCriteria(Menu.class);
		criteria.addOrder(Order.asc("path"));
		return criteria.list();
	}

}
