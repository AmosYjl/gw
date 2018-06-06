package com.monetware.ringspider.platform;


import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/* @SpringBootApplication扫描组件只会从Application所在包开始往下扫描
 * 如果要在每个web项目中单独使用，需要额外声明以下内容告知Spring Boot去指定包下扫描组件：
 * @ComponentScan({"com.monetware.ringspider"})
 * @MapperScan({"com.monetware.ringspider.base.dao", "com.monetware.ringspider.commons.dao"})
 */
@SpringBootApplication
@ComponentScan({"com.monetware.ringspider.*"})
@MapperScan({"com.monetware.ringspider.base.dao", "com.monetware.ringspider.commons.dao"})
public class PlatformApplication extends SpringBootServletInitializer {
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	/**
	 * 添加对程序打war包的支持
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PlatformApplication.class);

	}
	public static void main(String[] args) {
		SpringApplication.run(PlatformApplication.class, args);


	}

	
}
