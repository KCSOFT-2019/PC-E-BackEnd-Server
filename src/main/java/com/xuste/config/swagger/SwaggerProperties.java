package com.xuste.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.swagger")
@Data
public class SwaggerProperties {

	private SwaggerEntity back;

	@Data
	public static class SwaggerEntity {
		private String groupName;
		private String basePackage;
		private String title;
		private String description;
		private String contactName;
		private String contactEmail;
		private String contactUrl;
		private String version;
		private Boolean enable;
	}
}