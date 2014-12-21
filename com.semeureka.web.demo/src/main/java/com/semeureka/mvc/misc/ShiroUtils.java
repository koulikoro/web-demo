package com.semeureka.mvc.misc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;

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

	/**
	 * @see org.apache.shiro.web.filter.mgt.DefaultFilterChainManager#toNameConfigPair(String)
	 */
	protected static String[] toNameConfigPair(String token) throws ConfigurationException {
		try {
			String[] pair = token.split("\\[", 2);
			String name = StringUtils.clean(pair[0]);
			if (name == null) {
				throw new IllegalArgumentException("Filter name not found for filter chain definition token: " + token);
			}
			String config = null;
			if (pair.length == 2) {
				config = StringUtils.clean(pair[1]);
				config = config.substring(0, config.length() - 1);
				config = StringUtils.clean(config);
				if (config != null && config.startsWith("\"") && config.endsWith("\"")) {
					String stripped = config.substring(1, config.length() - 1);
					stripped = StringUtils.clean(stripped);
					if (stripped != null && stripped.indexOf('"') == -1) {
						config = stripped;
					}
				}
			}

			return new String[] { name, config };
		} catch (Exception e) {
			String msg = "Unable to parse filter chain definition token: " + token;
			throw new ConfigurationException(msg, e);
		}
	}

	/**
	 * @see org.apache.shiro.web.filter.mgt.DefaultFilterChainManager#createChain(String, String)
	 */
	public static boolean isAccessible(String chainDefinition) {
		if (!StringUtils.hasText(chainDefinition)) {
			return true;
		}
		String[] filterTokens = StringUtils.split(chainDefinition, StringUtils.DEFAULT_DELIMITER_CHAR, '[', ']', true,
				true);
		Map<String, String[]> filterChains = new LinkedHashMap<String, String[]>();
		for (String token : filterTokens) {
			String[] nameConfigPair = toNameConfigPair(token);
			filterChains.put(nameConfigPair[0], StringUtils.split(nameConfigPair[1]));
		}
		Subject subject = SecurityUtils.getSubject();
		for (String filter : filterChains.keySet()) {
			if (filter.equals("perms")) {
				for (String perm : filterChains.get(filter)) {
					if (!subject.isPermitted(perm)) {
						return false;
					}
				}
			}
			// TODO Other filter: anno, roles, authc etc
		}
		return true;
	}
}
