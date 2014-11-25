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

	@RequestMapping(value = "/user/login")
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/user/welcome")
	public String welcome() {
		return "user/welcome";
	}

	@RequestMapping(value = "/user/edit/{username}", method = RequestMethod.GET)
	public String edit(@PathVariable String username, Model model) {
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "user/edit";
	}
}
