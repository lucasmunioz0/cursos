package com.datajpa;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer{
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		WebMvcConfigurer.super.addResourceHandlers(registry);
//		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
//		log.info(resourcePath);
//		registry.addResourceHandler("/uploads/**")
//		.addResourceLocations(resourcePath);
//	}

}
