package com.semeureka.mvc.misc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionAdvice {

	@Autowired
	private MessageSource messageSource;

	/**
	 * SET org.apache.coyote.USE_CUSTOM_STATUS_MSG_IN_HEADER=true
	 */
	@ExceptionHandler(Exception.class)
	public String handler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
		int statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		if (ex instanceof HttpException) {
			statusCode = ((HttpException) ex).getStatusCode();
		}
		String reason = ex.getMessage();
		if (reason != null) {
			reason = this.messageSource.getMessage(reason, null, reason, LocaleContextHolder.getLocale());
			response.sendError(statusCode, encodeURI(reason));
		} else {
			response.sendError(statusCode);
		}
		return null;
	}

	/**
	 * Match "java.net.URLEncoder.encode()" and "javaScript decodeURIComponent()"
	 */
	public static String encodeURI(String source) {
		try {
			return URLEncoder.encode(source, "utf-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!")
					.replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")")
					.replaceAll("\\%7E", "~");
		} catch (UnsupportedEncodingException e) {
			// no-op
		}
		return source;
	}
}
