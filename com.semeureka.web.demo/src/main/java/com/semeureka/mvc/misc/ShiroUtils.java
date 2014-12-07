package com.semeureka.mvc.misc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.semeureka.mvc.entity.User;

public class ShiroUtils {
	private static final String ROLE_NAMES_DELIMETER = ",";

	public static Subject subject() {
		return SecurityUtils.getSubject();
	}

	public static User principal() {
		return subject() != null ? (User) subject().getPrincipal() : null;
	}

	public static boolean guest() {
		return subject() == null || principal() == null;
	}

	public static boolean user() {
		return subject() != null && principal() != null;
	}

	public static boolean authenticated() {
		return subject() != null && subject().isAuthenticated();
	}

	public static boolean notAuthenticated() {
		return subject() == null || !subject().isAuthenticated();
	}

	public static boolean hasPermission(String permission) {
		return subject() != null ? subject().isPermitted(permission) : false;
	}

	public static boolean lacksPermission(String permission) {
		return !hasPermission(permission);
	}

	public static boolean hasRole(String role) {
		return subject() != null ? subject().hasRole(role) : false;
	}

	public static boolean hasAnyRoles(String roles) {
		Subject subject = subject();
		if (subject != null) {
			for (String role : roles.split(ROLE_NAMES_DELIMETER)) {
				if (subject.hasRole(role.trim())) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean lacksRole(String role) {
		return !hasRole(role);
	}
}
