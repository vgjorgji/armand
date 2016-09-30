package com.vcms.web.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class AdminWebConfiguration extends WebConfiguration {
	
	@Bean
	protected MultipartResolver multipartResolver() {
		MultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}

}
