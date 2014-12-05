package com.semeureka.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.service.OrganizationService;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("organizations", organizationService.findAll());
		return "organization/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Organization organization) {
		organizationService.save(organization);
		return "redirect:/organization";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		organizationService.deleteById(id);
		return "redirect:/organization";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("organizations", organizationService.findAll());
		model.addAttribute("organization", organizationService.findById(id));
		return "organization/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Organization organization, @PathVariable Integer id, Model model) {
		organization.setId(id);
		organizationService.save(organization);
		return "redirect:/organization";
	}

	@RequestMapping(value = "")
	public String manage(Model model) {
		model.addAttribute("organizations", organizationService.findAll());
		return "organization/manage";
	}
}
