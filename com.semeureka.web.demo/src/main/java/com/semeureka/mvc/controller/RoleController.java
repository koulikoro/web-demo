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

import com.semeureka.mvc.entity.Resource;
import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.misc.HttpException;
import com.semeureka.mvc.service.ResourceService;
import com.semeureka.mvc.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
	private static final int ROOT_RESOURCE_ID = 1;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("resource", resourceService.get(ROOT_RESOURCE_ID));
		return "/role/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Role role, Integer[] resourceIds) {
		if (resourceIds != null) {
			Set<Resource> resources = new HashSet<Resource>();
			for (int i = 0; i < resourceIds.length; i++) {
				CollectionUtils.addIgnoreNull(resources, resourceService.get(resourceIds[i]));
			}
			role.setResources(resources);
		}
		roleService.save(role);
		return "redirect:/role";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Role role = roleService.get(id);
		if (role != null) {
			roleService.delete(role);
		}
		return "redirect:/role";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Role role = roleService.get(id);
		if (role == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		model.addAttribute("role", role);
		model.addAttribute("resource", resourceService.get(ROOT_RESOURCE_ID));
		return "/role/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Role role, Integer[] resourceIds, @PathVariable Integer id, Model model) {
		Role old = roleService.get(id);
		if (old == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		role.setId(id);
		if (resourceIds != null) {
			Set<Resource> resources = new HashSet<Resource>();
			for (int i = 0; i < resourceIds.length; i++) {
				CollectionUtils.addIgnoreNull(resources, resourceService.get(resourceIds[i]));
			}
			role.setResources(resources);
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
