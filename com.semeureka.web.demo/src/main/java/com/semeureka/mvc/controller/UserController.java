package com.semeureka.mvc.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.misc.ShiroUtils;
import com.semeureka.mvc.service.OrganizationService;
import com.semeureka.mvc.service.RoleService;
import com.semeureka.mvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("roles", roleService.find());
		model.addAttribute("organizations", organizationService.find(ShiroUtils.organization()));
		return "/user/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user, Integer[] roleIds) {
		Set<Role> roles = new HashSet<Role>();
		for (int i = 0; i < roleIds.length; i++) {
			CollectionUtils.addIgnoreNull(roles, roleService.get(roleIds[i]));
		}
		user.setRoles(roles);
		user.setPassword(passwordService.encryptPassword(user.getPassword()));
		userService.save(user);
		return "redirect:/user";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		User user = userService.get(id);
		if (user == null) {
			// TODO 404
		}
		userService.delete(user);
		return "redirect:/user";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		User user = userService.get(id);
		if (user == null) {
			// TODO 404
		}
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.find());
		model.addAttribute("organizations", organizationService.find(ShiroUtils.organization()));
		return "/user/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(User user, Integer[] roleIds, @PathVariable Integer id, Model model) {
		User old = userService.get(id);
		if (old == null) {
			// TODO 404
		}
		user.setId(id);
		Set<Role> roles = new HashSet<Role>();
		for (int i = 0; i < roleIds.length; i++) {
			CollectionUtils.addIgnoreNull(roles, roleService.get(roleIds[i]));
		}
		user.setRoles(roles);
		// If password is empty, retain the original password
		if (StringUtils.isEmpty(user.getPassword())) {
			user.setPassword(userService.get(id).getPassword());
		} else {
			user.setPassword(passwordService.encryptPassword(user.getPassword()));
		}
		userService.update(user);
		return "redirect:/user";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String view(Model model) {
		model.addAttribute("users", userService.find(ShiroUtils.organization()));
		return "user/view";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "/user/login";
	}

	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String password(Model model) {
		model.addAttribute("user", userService.get(ShiroUtils.principal().getId()));
		return "/user/password";
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String password(String oldPassword, String newPassword) {
		User user = userService.get(ShiroUtils.principal().getId());
		if (passwordService.passwordsMatch(oldPassword, user.getPassword())) {
			user.setPassword(passwordService.encryptPassword(newPassword));
			userService.save(user);
		}
		return "redirect:/";
	}
}
