package com.armand.cms.web.client.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.armand.cms.web.client.interceptor.ClientVisitorInterceptor;
import com.armand.cms.web.conf.WebConfiguration;

@Configuration
public class ClientWebConfiguration extends WebConfiguration {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getClientVisitorInterceptor());
	}
	
	@Bean
	public ClientVisitorInterceptor getClientVisitorInterceptor() {
		return new ClientVisitorInterceptor();
	}

}
