package com.semeureka.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semeureka.mvc.dao.ResourceDao;
import com.semeureka.mvc.entity.Resource;
import com.semeureka.mvc.service.ResourceService;

/**
 * For more information, see the <a href="https://github.com/koulikoro">GitHub</a>.
 * 
 * @author koulikoro@sina.com
 * @since 2014-12-24
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public Resource save(Resource resource) {
		return resourceDao.save(resource);
	}

	@Override
	public void delete(Resource resource) {
		resourceDao.delete(resource);
	}

	@Override
	public Resource update(Resource resource) {
		return resourceDao.update(resource);
	}

	@Override
	public Resource get(Integer id) {
		return id != null ? resourceDao.get(id) : null;
	}

	@Override
	public List<Resource> find() {
		return resourceDao.find();
	}

	@Override
	public List<Resource> findByParent(Resource parent) {
		return resourceDao.findByParent(parent);
	}

}
