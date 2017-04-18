package com.vcms.web.admin.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.vcms.web.admin.interceptor.SelectedWebsiteInterceptor;
import com.vcms.web.conf.WebConfiguration;

@Configuration
public class AdminWebConfiguration extends WebConfiguration {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/admin/dashboard").setViewName("/admin/dashboard");
		registry.addViewController("/websites/dashboard").setViewName("/websites/dashboard");
		registry.addViewController("/website/{websiteId}/dashboard").setViewName("/website/dashboard");
		registry.addViewController("/website/{websiteId}/design").setViewName("/website/design");
		registry.addViewController("/website/{websiteId}/design/theme").setViewName("/website/design/theme");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getSelectedWebsiteInterceptor());
	}
	
	@Bean
	public SelectedWebsiteInterceptor getSelectedWebsiteInterceptor() {
		return new SelectedWebsiteInterceptor();
	}
	
	@Bean
	protected MultipartResolver multipartResolver() {
		MultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}

}
