package com.semeureka.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semeureka.mvc.entity.User;

@Controller
public class UserController {
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(User user) {
		return "user/login";
	}
}
