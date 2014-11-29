package com.semeureka.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.User;
import com.semeureka.mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String toCreate() {
		return "user/create";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String create(User user) {
		userService.save(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String read(@PathVariable Integer id, Model model) {
		// TODO find the user.
		return "user/edit";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Integer id, Model model) {
		// TODO update the user.
		return "redirect:/users";
	}

	@RequestMapping(value = "/user/{id}/delete")
	public String delete(@PathVariable Integer id) {
		userService.deleteById(id);
		return "redirect:/users";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String manage(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/manage";
	}

	@RequestMapping(value = "/user/login")
	public String toLogin() {
		return "user/login";
	}
}
