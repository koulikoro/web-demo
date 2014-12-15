package com.semeureka.mvc.dao;

import java.util.List;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	User getByAccount(String acount);

	List<User> find(Organization organization);
}
