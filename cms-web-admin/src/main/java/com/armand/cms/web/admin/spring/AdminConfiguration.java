package com.armand.cms.web.admin.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.armand.cms.web.admin.controller.AdminControllers;
import com.armand.cms.web.admin.interceptor.AdminInterceptors;
import com.armand.cms.web.admin.service.AdminServices;
import com.armand.cms.web.spring.WebConfiguration;

@Configuration
@Import({WebConfiguration.class, AdminMvcConfiguration.class, AdminSecurityConfiguration.class})
@ComponentScan(basePackageClasses = {AdminControllers.class, AdminInterceptors.class, AdminServices.class})
public class AdminConfiguration {

}
