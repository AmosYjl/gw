package com.monetware.ringspider.commons.property;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义属性类，加载属性文件
 * @author licc
 *
 */
@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix = "i18n")
@PropertySource("classpath:i18n/messages.properties")
public class InternationalizationProperties {

	private Map<String, String> messages;

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	
}
