package com.semeureka.mvc.service;

import java.util.List;

import com.semeureka.mvc.entity.Resource;

public interface ResourceService {

	Resource save(Resource resource);

	void delete(Resource resource);

	Resource update(Resource resource);

	Resource get(Integer id);

	List<Resource> find();

	List<Resource> findByParent(Resource parent);

}
