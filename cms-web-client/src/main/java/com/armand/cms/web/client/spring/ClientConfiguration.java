package com.armand.cms.web.client.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.armand.cms.web.client.controller.ClientControllers;
import com.armand.cms.web.client.interceptor.ClientInterceptors;
import com.armand.cms.web.client.service.ClientServices;
import com.armand.cms.web.spring.WebConfiguration;

@Configuration
@Import({WebConfiguration.class, ClientMvcConfiguration.class, ClientSecurityConfiguration.class})
@ComponentScan(basePackageClasses = {ClientControllers.class, ClientInterceptors.class, ClientServices.class})
public class ClientConfiguration extends WebMvcConfigurerAdapter {

}
