package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
@SpringBootApplication
public class DatabaseProjectsApplication extends SpringBootServletInitializer{
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	{
		return application.sources(DatabaseProjectsApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(DatabaseProjectsApplication.class, args);
	}

}
