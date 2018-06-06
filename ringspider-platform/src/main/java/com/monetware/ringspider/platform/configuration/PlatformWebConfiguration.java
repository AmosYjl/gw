package com.monetware.ringspider.platform.configuration;

import com.monetware.ringspider.platform.interceptor.InternationalizationInterceptor;
import com.monetware.ringspider.platform.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.DispatcherType;

/**
 * 
 * @author licc
 *
 */
@Configuration
public class PlatformWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternationalizationInterceptor i18nInterceptor() {
		return new InternationalizationInterceptor();
	}



	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(i18nInterceptor()).addPathPatterns("/**");


	}


	/**
	 * 登录认证过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean authenticateFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean(new LoginFilter());
	    registration.setDispatcherTypes(DispatcherType.REQUEST);
	    registration.setName("loginFilter");
	    registration.setOrder(Integer.MAX_VALUE-1);
	    registration.addUrlPatterns("/*");
	    return registration;
	}
}
