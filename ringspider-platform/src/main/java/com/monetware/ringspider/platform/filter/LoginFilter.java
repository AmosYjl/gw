package com.monetware.ringspider.platform.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monetware.ringspider.commons.constant.UserConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yangjl
 * 登录过滤器
 */
public class LoginFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String uri = httpRequest.getServletPath();
		if (uri == null) {
			uri = "";
		}
		if(uri.startsWith("/resource")
				|| uri.contains("doLogin")
				|| uri.contains("uploaded") 
				|| uri.contains("register")
				|| uri.contains("doRegister")
				|| uri.contains("sendMessage")
				|| uri.contains("forget_password")
				|| uri.contains("updateUserPassword")
				|| uri.equals("/") ) { // 资源文件不进行过滤
			chain.doFilter(request, response);
		}else{
			if(((HttpServletRequest) request).getSession().getAttribute(UserConstants.SESSION_USER)==null){
				chain.doFilter(request, response);
//				//当前用户未登录
//				System.out.print("----------------------uri:"+uri);
//				String path = httpRequest.getContextPath();
//			    httpResponse.sendRedirect(path + "/");
			}else{
				chain.doFilter(request, response);
			}
		}


	}

	@Override
	public void destroy() {
		
	}
	
}
