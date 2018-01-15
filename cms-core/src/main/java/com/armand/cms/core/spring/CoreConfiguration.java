package com.armand.cms.core.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.armand.cms.core.*.service", "com.armand.cms.core.*.stub"})
public class CoreConfiguration {

}
