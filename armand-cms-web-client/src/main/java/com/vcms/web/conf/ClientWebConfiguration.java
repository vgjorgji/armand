package com.vcms.web.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.vcms.web.interceptor.ClientVisitorInterceptor;

@Configuration
public class ClientWebConfiguration extends WebConfiguration {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getVisitorWebsiteInterceptor());
	}
	
	@Bean
	public ClientVisitorInterceptor getVisitorWebsiteInterceptor() {
		return new ClientVisitorInterceptor();
	}

}
