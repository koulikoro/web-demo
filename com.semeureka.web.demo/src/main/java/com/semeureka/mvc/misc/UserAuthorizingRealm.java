package com.semeureka.mvc.misc;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.semeureka.mvc.entity.Permission;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.UserService;

public class UserAuthorizingRealm extends AuthorizingRealm {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String account = upToken.getUsername();
		// Null account is invalid
		if (account == null || account.isEmpty()) {
			throw new AccountException("Null accounts are not allowed by this realm.");
		}
		User user = userService.findByAccount(account);
		if (user == null) {
			throw new UnknownAccountException("No account found for user [" + account + "]");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// null accounts are invalid
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		User user = (User) principals.getPrimaryPrincipal();
		user = userService.findById(user.getId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (user != null && CollectionUtils.isNotEmpty(user.getRoles())) {
			for (Role role : user.getRoles()) {
				info.addRole(role.getValue());
				if (CollectionUtils.isNotEmpty(role.getPermissions())) {
					for (Permission permission : role.getPermissions()) {
						info.addStringPermission(permission.getValue());
					}
				}
			}
		}
		return info;
	}
}
