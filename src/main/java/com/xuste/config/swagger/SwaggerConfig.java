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
	/**
	 * 配置属性
	 */
	@Autowired
	private SwaggerProperties properties;
	/**
	 * 后台API
	 */
	@Bean
	public Docket backApi() {
		return new Docket(DocumentationType.OAS_30)
				//是否开启，根据环境配置
				.enable(properties.getBack().getEnable())
				.groupName(properties.getBack().getGroupName())
				.apiInfo(backApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(properties.getBack().getBasePackage()))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 后台API信息
	 */
	private ApiInfo backApiInfo() {
		return new ApiInfoBuilder()
				.title(properties.getBack().getTitle())
				.description(properties.getBack().getDescription())
				.version(properties.getBack().getVersion())
				.contact(    //添加开发者的一些信息
						new Contact(properties.getBack().getContactName(), properties.getBack().getContactUrl(),
								properties.getBack().getContactEmail()))
				.build();
	}

}