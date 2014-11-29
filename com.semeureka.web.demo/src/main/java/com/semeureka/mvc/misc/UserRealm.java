package com.semeureka.mvc.misc;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.semeureka.mvc.entity.Permission;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.UserService;

@Component
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	@PostConstruct
	public void initHashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
		credentialsMatcher.setStoredCredentialsHexEncoded(false);
		credentialsMatcher.setHashIterations(1024);
		setCredentialsMatcher(credentialsMatcher);
	}

	public void hashedPassword(User user) {
		RandomNumberGenerator numberGenerator = new SecureRandomNumberGenerator();
		String salt = numberGenerator.nextBytes().toBase64();
		String hashedPassword = new Sha256Hash(user.getPassword(), salt, 1024).toBase64();
		user.setPassword(hashedPassword);
		user.setSalt(salt);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = userService.findByUsername(username);
		for (Role role : user.getRoles()) {
			authorizationInfo.addRole(role.getName());
			for (Permission permission : role.getPermissions()) {
				authorizationInfo.addStringPermission(permission.getName());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String name = upToken.getUsername();
		if (name == null) {
			throw new AccountException("Null usernames are not allowed by this realm.");
		}
		User user = userService.findByUsername(name);
		if (user == null) {
			throw new UnknownAccountException("No account found for user [" + name + "].");
		}
		if (user.isLocked()) {
			throw new LockedAccountException("Account [" + name + "] is locked.");
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
				user.getPassword(), getName());
		if (user.getSalt() != null) {
			authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
		}
		return authenticationInfo;
	}
}
