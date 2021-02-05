package com.demo.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.test.controller"))
				.paths(Predicates.not(PathSelectors.regex("/error")))
				.build()
				.pathMapping("/")
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return  new ApiInfoBuilder()
				.title("simple demo project with junit")
				.version("1.0")
				.build();
	}
	
}

