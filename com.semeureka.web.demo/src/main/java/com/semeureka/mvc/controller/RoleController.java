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

import com.semeureka.mvc.entity.Permission;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.service.PermissionService;
import com.semeureka.mvc.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "/role/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Role role, String[] permission) {
		Set<Permission> permissions = new HashSet<Permission>();
		for (int i = 0; i < permission.length; i++) {
			CollectionUtils.addIgnoreNull(permissions, permissionService.findByName(permission[i]));
		}
		role.setPermissions(permissions);
		roleService.save(role);
		return "redirect:/role";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		roleService.deleteById(id);
		return "redirect:/role";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("role", roleService.findById(id));
		model.addAttribute("permissions", permissionService.findAll());
		return "role/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Role role, String[] permission, @PathVariable Integer id, Model model) {
		role.setId(id);
		Set<Permission> permissions = new HashSet<Permission>();
		for (int i = 0; i < permission.length; i++) {
			CollectionUtils.addIgnoreNull(permissions, permissionService.findByName(permission[i]));
		}
		role.setPermissions(permissions);
		roleService.update(role);
		return "redirect:/role";
	}

	@RequestMapping(value = "")
	public String manage(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "role/manage";
	}
}
