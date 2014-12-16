package com.semeureka.mvc.misc;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionAdvice {
	@ExceptionHandler(HttpException.class)
	public String handler(HttpServletRequest request, HttpServletResponse response, HttpException ex) throws Exception {
		String message = ex.getMessage();
		if (message != null) {
			// Add Error-Message for ajax request
			// reference "/webapp/resources/custom/common.js" $('.confirm-ajax').click()
			response.setHeader("Error-Message", URLEncoder.encode(message, "utf-8"));
			response.sendError(ex.getStatusCode(), message);
		} else {
			response.sendError(ex.getStatusCode());
		}
		return null;
	}
}
