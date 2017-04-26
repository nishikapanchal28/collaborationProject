package com.niit.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
// to create beans for all the classes under the package com.****....
@ComponentScan(basePackages="com.niit")
public class WebAppConfig extends WebMvcConfigurerAdapter {



public void addResourceHandlers(ResourceHandlerRegistry registry){
	registry.addResourceHandler("/resources/**")
	.addResourceLocations("/WEB-INF/resources/");
}


}