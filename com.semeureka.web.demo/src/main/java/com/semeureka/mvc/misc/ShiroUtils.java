package com.semeureka.mvc.misc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

public class ShiroUtils {
	public static Subject subject() {
		return SecurityUtils.getSubject();
	}

	public static User principal() {
		Subject subject = subject();
		return subject != null ? (User) subject.getPrincipal() : null;
	}

	public static Organization organization() {
		User principal = principal();
		return principal != null ? principal.getOrganization() : null;
	}
}
