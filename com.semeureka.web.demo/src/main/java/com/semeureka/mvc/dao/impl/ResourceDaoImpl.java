package com.semeureka.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semeureka.mvc.dao.ResourceDao;
import com.semeureka.mvc.entity.Resource;

@Repository
public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements ResourceDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Resource> findByParent(Resource parent) {
		Criteria criteria = currentSession().createCriteria(Resource.class);
		if (parent != null) {
			criteria.add(Restrictions.eq("parent", parent));
		} else {
			criteria.add(Restrictions.isNull("parent"));
		}
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

}
