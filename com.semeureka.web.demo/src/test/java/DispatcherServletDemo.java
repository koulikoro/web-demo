import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class DispatcherServletDemo {
	private List<HandlerMapping> handlerMappings = null;
	private List<HandlerAdapter> handlerAdapters = null;
	private List<HandlerExceptionResolver> handlerExceptionResolvers = null;
	private List<ViewResolver> viewResolvers = null;

	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HandlerExecutionChain handlerChain = null;
		ModelAndView modelAndView = null;
		Exception dispatchException = null;

		try {
			// get handlerChain that consisting of "handler object" and any "handler interceptors"
			handlerChain = getHandler(request);
			if (handlerChain == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			// get handlerAdapter
			HandlerAdapter handlerAdapter = getHandlerAdapter(handlerChain);
			// insert "handler interceptors" preHandle method
			// call "handler object" by handlerAdapter
			modelAndView = handlerAdapter.handle(request, response, handlerChain.getHandler());
			// insert "handler interceptors" postHandle method
		} catch (Exception ex) {
			dispatchException = ex;
		}
		if (dispatchException != null) {
			modelAndView = processHandlerException(request, response, handlerChain.getHandler(), dispatchException);
		}
		if (modelAndView != null) {
			render(modelAndView, request, response);
		}
		// insert "handler interceptors" afterCompletion method
	}

	private HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
		for (HandlerMapping handlerMapping : handlerMappings) {
			HandlerExecutionChain handler = handlerMapping.getHandler(request);
			if (handler != null) {
				return handler;
			}
		}
		return null;
	}

	private HandlerAdapter getHandlerAdapter(HandlerExecutionChain handlerChain) throws ServletException {
		for (HandlerAdapter handlerAdapter : handlerAdapters) {
			if (handlerAdapter.supports(handlerChain)) {
				return handlerAdapter;
			}
		}
		throw new ServletException("No adapter for handler");
	}

	private ModelAndView processHandlerException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception dispatchException) throws Exception {
		ModelAndView exModelAndView = null;
		for (HandlerExceptionResolver handlerExceptionResolver : handlerExceptionResolvers) {
			exModelAndView = handlerExceptionResolver.resolveException(request, response, handler, dispatchException);
			if (exModelAndView != null) {
				break;
			}
		}
		if (exModelAndView != null) {
			return exModelAndView;
		}
		throw dispatchException;
	}

	private void render(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Locale locale = null; // LocaleResolver
		View view = null;
		if (modelAndView.isReference()) {
			for (ViewResolver viewResolver : this.viewResolvers) {
				View v = viewResolver.resolveViewName(modelAndView.getViewName(), locale);
				if (v != null) {
					view = v;
					break;
				}
			}
			if (view == null) {
				throw new ServletException("Could not resolve view with the name");
			}
		} else {
			view = modelAndView.getView();
		}
		view.render(modelAndView.getModel(), request, response);
	}
}
