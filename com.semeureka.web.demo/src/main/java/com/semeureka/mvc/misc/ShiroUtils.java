package com.semeureka.mvc.misc;

import org.apache.shiro.SecurityUtils;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

public class ShiroUtils {

	public static User user() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}

	public static Organization organization() {
		User user = user();
		return user != null ? user.getOrganization() : null;
	}

}
