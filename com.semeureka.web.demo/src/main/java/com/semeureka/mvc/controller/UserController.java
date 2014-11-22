package com.semeureka.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.semeureka.mvc.entity.User;

@Controller
public class UserController {

	@RequestMapping(value = "/login")
	public String login(User user) {

		return "home";
	}
}
