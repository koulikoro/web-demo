package com.semeureka.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.semeureka.mvc.entity.Menu;
import com.semeureka.mvc.misc.HttpException;
import com.semeureka.mvc.service.MenuService;

@Controller
@RequestMapping(value = "/menu")
public class MenuController extends HandlerInterceptorAdapter implements ServletContextAware {

	@Autowired
	private MenuService menuService;
	@Autowired
	private AbstractShiroFilter shiroFilter;

	@Override
	public void setServletContext(ServletContext servletContext) {
		PathMatchingFilterChainResolver chainResolver = (PathMatchingFilterChainResolver) shiroFilter
				.getFilterChainResolver();
		FilterChainManager chainManager = chainResolver.getFilterChainManager();
		List<Menu> menus = menuService.find();
		for (Menu menu : menus) {
			if (menu.getPermission() != null) {
				chainManager.createChain(menu.getUrl(), menu.getPermission());
			}
		}
	}

	@RequestMapping(value = "/{id}")
	public String redirect(@PathVariable Integer id) {
		Menu menu = menuService.get(id);
		if (menu == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		while (menu.getUrl() == null && menu.getChildren().size() > 0) {
			menu = menu.getChildren().iterator().next();
		}
		if (menu.getUrl() == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		return "redirect:" + menu.getUrl();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String url = request.getRequestURI().substring(request.getContextPath().length());
		// TODO make a cache map<url, menu>
		while (url.lastIndexOf('/') > -1) {
			List<Menu> menus = menuService.findByUrl(url);
			if (!menus.isEmpty()) {
				Menu menu = null;
				for (Menu m : menus) {
					if (url.equals(m.getUrl())) { // Extra match
						menu = m;
					}
				}
				if (menu == null) { // If not exist extra match, get the last
					menu = menus.get(menus.size() - 1);
				}
				List<Menu> navs = new ArrayList<Menu>();
				while (menu != null) {
					navs.add(0, menu);
					menu = menu.getParent();
				}
				request.getSession().setAttribute("navs", navs);
				request.getSession().setAttribute("subject", SecurityUtils.getSubject());
				break;
			}
			url = url.substring(0, url.lastIndexOf('/'));
		}
	}

}
