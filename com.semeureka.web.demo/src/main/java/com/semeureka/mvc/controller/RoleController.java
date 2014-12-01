package com.semeureka.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.Role;
import com.semeureka.mvc.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "/role/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Role role) {
		roleService.save(role);
		return "redirect:/role";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		roleService.deleteById(id);
		return "redirect:/role";
	}

	@RequestMapping(value = "")
	public String manage(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "role/manage";
	}
}
