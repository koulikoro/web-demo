package com.semeureka.mvc.dao;

import java.util.List;

import com.semeureka.mvc.entity.Resource;

public interface ResourceDao extends BaseDao<Resource> {

	List<Resource> findByParent(Resource parent);
}
