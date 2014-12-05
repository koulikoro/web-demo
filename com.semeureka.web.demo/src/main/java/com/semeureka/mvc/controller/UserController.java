package com.semeureka.mvc.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.OrganizationService;
import com.semeureka.mvc.service.RoleService;
import com.semeureka.mvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("organizations", organizationService.findAll());
		return "user/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user, Integer[] roleIds) {
		Set<Role> roles = new HashSet<Role>();
		for (int i = 0; i < roleIds.length; i++) {
			CollectionUtils.addIgnoreNull(roles, roleService.findById(roleIds[i]));
		}
		user.setRoles(roles);
		userService.save(user);
		return "redirect:/user";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		userService.deleteById(id);
		return "redirect:/user";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("organizations", organizationService.findAll());
		return "user/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(User user, Integer[] roleIds, @PathVariable Integer id, Model model) {
		Set<Role> roles = new HashSet<Role>();
		for (int i = 0; i < roleIds.length; i++) {
			CollectionUtils.addIgnoreNull(roles, roleService.findById(roleIds[i]));
		}
		user.setRoles(roles);
		user.setId(id);
		userService.update(user);
		return "redirect:/user";
	}

	@RequestMapping(value = "")
	public String manage(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/manage";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "user/login";
	}
}
