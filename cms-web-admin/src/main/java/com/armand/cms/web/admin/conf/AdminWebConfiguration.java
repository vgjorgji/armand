package com.armand.cms.web.admin.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.armand.cms.web.admin.model.Page;
import com.armand.cms.web.admin.interceptor.SelectedWebsiteInterceptor;
import com.vcms.web.conf.WebConfiguration;

@Configuration
public class AdminWebConfiguration extends WebConfiguration {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		Page[] pages = Page.values();
		for (Page page : pages) {
			registry.addViewController(page.getUrl()).setViewName(page.getView());
		}
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
