package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Myspringboot3AppApplication {

	public static void main(String[] args) {

		//SpringApplication.run(Myspringboot3AppApplication.class, args);
		SpringApplication application = new SpringApplication(Myspringboot3AppApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
	}


}
