package com.semeureka.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.Organization;
import com.semeureka.mvc.misc.ShiroUtils;
import com.semeureka.mvc.service.OrganizationService;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("organizations", organizationService.find(ShiroUtils.organization()));
		return "/organization/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Organization organization) {
		organizationService.save(organization);
		return "redirect:/organization";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Organization organization = organizationService.get(id);
		if (organization == null) {
			// TODO 404
		}
		organizationService.delete(organization);
		return "redirect:/organization";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Organization organization = organizationService.get(id);
		if (organization == null) {
			// TODO 404
		}
		model.addAttribute("organization", organization);
		return "/organization/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Organization organization, @PathVariable Integer id, Model model) {
		Organization old = organizationService.get(id);
		if (old == null) {
			// TODO 404
		}
		organization.setId(id);
		// Fixed "parent" field
		if (organization.getParent().getId() == null) {
			organization.setParent(null);
		}
		// Unmodifiable fields
		organization.setParent(old.getParent());
		organization.setPath(old.getPath());
		organizationService.update(organization);
		return "redirect:/organization";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String view(Model model) {
		model.addAttribute("organizations", organizationService.find(ShiroUtils.organization()));
		return "/organization/view";
	}
}
