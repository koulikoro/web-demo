package com.semeureka.mvc.misc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.entity.User;

public class ShiroUtils {
	private static final String ROLE_NAMES_DELIMETER = ",";

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

	public static boolean guest() {
		Subject subject = subject();
		return subject == null || subject.getPrincipal() == null;
	}

	public static boolean user() {
		Subject subject = subject();
		return subject != null && subject.getPrincipal() != null;
	}

	public static boolean authenticated() {
		Subject subject = subject();
		return subject != null && subject.isAuthenticated();
	}

	public static boolean notAuthenticated() {
		Subject subject = subject();
		return subject == null || !subject.isAuthenticated();
	}

	public static boolean hasPermission(String permission) {
		Subject subject = subject();
		return subject != null ? subject.isPermitted(permission) : false;
	}

	public static boolean lacksPermission(String permission) {
		return !hasPermission(permission);
	}

	public static boolean hasRole(String role) {
		Subject subject = subject();
		return subject != null ? subject.hasRole(role) : false;
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

	public static void check(Organization organization) {
		if (organization() != null && !organization.getPath().startsWith(organization().getPath())) {
			throw new UnauthorizedException("Subject does not access to [" + organization.getName() + "]");
		}
	}
}
