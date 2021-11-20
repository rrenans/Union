package com.union.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
		        .apis(RequestHandlerSelectors.basePackage("com.union"))
		        .paths(PathSelectors.regex("/.*")) 
		        .build()
		        .apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
				 "Union API REST",
	                "API REST da Union.",
	                "1.0",
	                "Terms of Service",
	                new Contact("Renan Silva", "https://github.com/rrenans", "renansantos.silva04@outlook.com"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
		);
		return apiInfo;
	}

}
