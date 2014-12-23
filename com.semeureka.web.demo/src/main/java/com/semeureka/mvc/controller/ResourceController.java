package com.semeureka.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.semeureka.mvc.entity.Resource;
import com.semeureka.mvc.misc.HttpException;
import com.semeureka.mvc.service.ResourceService;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController extends HandlerInterceptorAdapter implements ServletContextAware {
	private PatternMatcher matcher = new AntPathMatcher();
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private AbstractShiroFilter shiroFilter;

	@Override
	public void setServletContext(ServletContext servletContext) {
		FilterChainResolver fcr = shiroFilter.getFilterChainResolver();
		if (fcr instanceof PathMatchingFilterChainResolver) {
			PathMatchingFilterChainResolver pmfcr = (PathMatchingFilterChainResolver) fcr;
			FilterChainManager fcm = pmfcr.getFilterChainManager();
			if (fcm instanceof DefaultFilterChainManager) {
				DefaultFilterChainManager dfcm = (DefaultFilterChainManager) fcm;
				servletContext.setAttribute("dfcm", dfcm);
				List<Resource> resources = resourceService.find();
				for (Resource resource : resources) {
					String permission = resource.getPermission();
					if (permission != null) {
						dfcm.createChain(resource.getPath(), "perms[" + permission + "]");
					}
				}
			}
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("resources", resourceService.find());
		return "/resource/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Resource resource, Integer parentId, Model model) {
		resource.setParent(resourceService.get(parentId));
		resourceService.save(resource);
		return "redirect:/resource";
	}

	@RequestMapping(value = "/delete/{id}")
	public String create(@PathVariable Integer id) {
		Resource resource = resourceService.get(id);
		if (resource != null) {
			resourceService.delete(resource);
		}
		return "redirect:/resource";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Resource resource = resourceService.get(id);
		if (resource == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		model.addAttribute("resource", resource);
		model.addAttribute("resources", resourceService.find());
		return "/resource/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Resource resource, Integer parentId, @PathVariable Integer id, Model model) {
		Resource old = resourceService.get(id);
		if (old == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		resource.setId(id);
		resource.setParent(resourceService.get(parentId));
		resourceService.update(resource);
		return "redirect:/resource";
	}

	@RequestMapping(value = "")
	public String view(Model model) {
		model.addAttribute("resources", resourceService.find());
		return "/resource/view";
	}

	@RequestMapping(value = "/{id}")
	public String redirect(@PathVariable Integer id) {
		Resource resource = resourceService.get(id);
		if (resource == null) {
			throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
		}
		return "redirect:" + resource.getPath();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		List<Resource> resources = resourceService.find();
		for (Resource resource : resources) {
			String path = resource.getPath();
			if (path != null && matcher.matches(path, uri)) {
				List<Resource> navs = new ArrayList<Resource>();
				while (resource != null) {
					navs.add(0, resource);
					resource = resource.getParent();
				}
				request.getSession().setAttribute("navs", navs);
				break;
			}
		}
	}
}
