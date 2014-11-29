package com.semeureka.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
	@RequestMapping(value = "/department")
	public String all() {
		return "department/department";
	}
}
