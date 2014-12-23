package com.semeureka.mvc.controller;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

@Controller
public class MiscController implements ServletContextAware {
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		servletContext.setAttribute("theme", ".united"); // default theme
	}

	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	public String theme() {
		return "/misc/theme";
	}

	@RequestMapping(value = "/theme", method = RequestMethod.POST)
	public String theme(String theme) {
		servletContext.setAttribute("theme", theme);
		return "redirect:/theme";
	}
}
