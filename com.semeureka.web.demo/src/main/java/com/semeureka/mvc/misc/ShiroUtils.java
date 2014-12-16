package com.semeureka.mvc.misc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

public class ShiroUtils {
	public static User user() {
		Subject subject = SecurityUtils.getSubject();
		return subject != null ? subject.getPrincipals().oneByType(User.class) : null;
	}

	public static Organization organization() {
		User user = user();
		return user != null ? user.getOrganization() : null;
	}
}
