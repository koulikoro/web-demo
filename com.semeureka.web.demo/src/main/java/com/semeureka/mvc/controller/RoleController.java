package com.semeureka.mvc.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.Permission;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.misc.HttpException;
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
	public String create(Model model) {
		model.addAttribute("root", permissionService.getByValue(Permission.ROOT_PERMISSION));
		return "/role/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Role role, Integer[] permissionIds) {
		if (permissionIds != null) {
			Set<Permission> permissions = new HashSet<Permission>();
			for (int i = 0; i < permissionIds.length; i++) {
				CollectionUtils.addIgnoreNull(permissions, permissionService.get(permissionIds[i]));
			}
			role.setPermissions(permissions);
		}
		roleService.save(role);
		return "redirect:/role";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Role role = roleService.get(id);
		if (role == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		roleService.delete(role);
		return "redirect:/role";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Role role = roleService.get(id);
		if (role == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		model.addAttribute("role", role);
		model.addAttribute("root", permissionService.getByValue(Permission.ROOT_PERMISSION));
		return "/role/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Role role, Integer[] permissionIds, @PathVariable Integer id, Model model) {
		Role old = roleService.get(id);
		if (old == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		role.setId(id);
		if (permissionIds != null) {
			Set<Permission> permissions = new HashSet<Permission>();
			for (int i = 0; i < permissionIds.length; i++) {
				CollectionUtils.addIgnoreNull(permissions, permissionService.get(permissionIds[i]));
			}
			role.setPermissions(permissions);
		}
		roleService.update(role);
		return "redirect:/role";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String view(Model model) {
		model.addAttribute("roles", roleService.find());
		return "/role/view";
	}
}
