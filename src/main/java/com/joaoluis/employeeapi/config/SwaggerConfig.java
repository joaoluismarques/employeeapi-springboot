package com.joaoluis.employeeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
		   .select()
		   .apis(RequestHandlerSelectors.basePackage("com.joaoluis.employeeapi.resources"))
		   .paths(PathSelectors.any())
		   .build()
		   .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Gerenciador de Empregados - Spring Boot REST API")
				.description("Este API possui a função de genreciar trabalhadores através do seu setor e cargo")
				.license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("João Luis", null, "linkedin.com/in/joão-luis-marques-926780220"))
	            .build();
	}
}
