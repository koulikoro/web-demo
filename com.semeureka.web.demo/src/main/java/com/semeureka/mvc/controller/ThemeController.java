package com.semeureka.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThemeController {
	@RequestMapping(value = "/theme")
	public String theme() {
		return "theme/theme";
	}
}
