package com.tx.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultInteceptor implements HandlerInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultInteceptor.class);

	/**
	 * 预处理1.程序先执行preHandle()方法，如果该方法的返回值为true，则程序会继续向下执行处理器中的方法，否则将不再向下执行。
	 * @return true 通过 false 拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle执行");
		return true;
	}

	/**
	 * 2.在业务处理器（即控制器Controller类）处理完请求后，会执行postHandle()方法，然后会通过DispatcherServlet向客户端返回响应。
	 * 进入Handler之后，返回ModelAndView对象之前执行
	 * 可以修改调整的视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 执行");
	}

	/**
	 * 3.在DispatcherServlet处理完请求后，才会执行afterCompletion()方法。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("afterCompletion 执行");
	}

}
