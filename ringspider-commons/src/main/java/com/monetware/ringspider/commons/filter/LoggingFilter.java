package com.monetware.ringspider.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.monetware.ringspider.commons.util.RequestUtil;

/**
 * @author licc
 * 日志记录过滤器
 */
public class LoggingFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String uri = httpRequest.getServletPath();
		if (uri == null) {
			uri = "";
		}

		if(!uri.matches("/resources/.*") 
				&& !uri.matches("/uploaded/.*")
				&& !uri.matches("/record/.*")
				&& !uri.matches("/questionnaire-js/.*")) {
			RequestUtil.logRequestMessage(logger, httpRequest);
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
	
}
