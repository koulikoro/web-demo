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
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "user/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user) {
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
		// TODO find the user.
		return "user/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(User user, @PathVariable Integer id, Model model) {
		// TODO update the user.
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
