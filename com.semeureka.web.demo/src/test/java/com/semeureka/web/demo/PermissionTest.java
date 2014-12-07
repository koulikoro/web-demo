package com.semeureka.web.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class PermissionTest {
	public static void main(String[] args) {
		Permission permission = new WildcardPermission("user:create,delete");
		Permission permission2 = new WildcardPermission("user");
		Permission permission3 = new WildcardPermission("*");
		System.out.println(permission.implies(permission2));
		System.out.println(permission2.implies(permission));
		System.out.println(permission3.implies(permission));
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.isPermitted(permission3));
		SecurityManager securityManager = SecurityUtils.getSecurityManager();
	}
}
