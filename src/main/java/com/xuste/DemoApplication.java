package com.xuste;

import io.swagger.annotations.SwaggerDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;


@SpringBootApplication
@MapperScan(basePackages = {"com.xuste.dao"})
//@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Value("${name}")
//	String name;
//
//	@PostConstruct
//	public void func() {
//		System.out.println(name);
//	}
}
