package com.monetware.ringspider.commons.configuration;

import java.io.File;
import java.util.Locale;

import javax.servlet.DispatcherType;

import com.monetware.ringspider.commons.filter.LoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * 
 * @author licc
 *
 */
@Configuration
public class CommonWebConfiguration extends WebMvcConfigurerAdapter {


	
	@Value("${uploaded.dir}")
	private String uploadedDir;

	
	/** 
	 * 根据cookie选择语言环境
	 * 如果cookie被删除或禁用，会根据系统当前环境自动选择语言
	 * @return
	 */
	@Bean
    public LocaleResolver localeResolver() {
		CookieLocaleResolver clr = new CookieLocaleResolver();
		clr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		clr.setCookieName("lang");
        return clr;
    }

	/**
	 * 添加资源文件映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		File uploadedDirectory = new File(uploadedDir);
		if(!uploadedDirectory.exists()) {
			uploadedDirectory.mkdirs();
		}
		registry.addResourceHandler("/uploaded/**").addResourceLocations("file:" + uploadedDir + File.separator);
		super.addResourceHandlers(registry);
	}
	
	/**
	 * 通用过滤器设置
	 * @return
	 */
	@Bean
	public FilterRegistrationBean loggingFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean(new LoggingFilter());
	    registration.setDispatcherTypes(DispatcherType.REQUEST);
	    registration.setName("loggingFilter");
	    registration.setOrder(Integer.MAX_VALUE);
	    registration.addUrlPatterns("/*");
	    return registration;
	}


	public String getUploadedDir() {
		return uploadedDir;
	}

}
