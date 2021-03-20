package com.xuste.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
@EnableConfigurationProperties(value = {SwaggerProperties.class})
public class SwaggerConfig {

	@Autowired
	private SwaggerProperties properties;

	@Bean
	public Docket backApi() {
		return new Docket(DocumentationType.OAS_30)
				.enable(properties.getBack().getEnable())
				.groupName(properties.getBack().getGroupName())
				.apiInfo(backApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(properties.getBack().getBasePackage()))
				.paths(PathSelectors.any())
				.build();
	}


	private ApiInfo backApiInfo() {
		return new ApiInfoBuilder()
				.title(properties.getBack().getTitle())
				.description(properties.getBack().getDescription())
				.version(properties.getBack().getVersion())
				.contact(
						new Contact(properties.getBack().getContactName(), properties.getBack().getContactUrl(),
								properties.getBack().getContactEmail()))
				.build();
	}

}