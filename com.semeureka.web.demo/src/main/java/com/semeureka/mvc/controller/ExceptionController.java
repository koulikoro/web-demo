package com.semeureka.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ExceptionController {
	@RequestMapping(value = "unauthorized")
	public String unauthorized() {
		return "error/unauthorized";
	}
}
