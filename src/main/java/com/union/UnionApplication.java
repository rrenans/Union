package com.union;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UnionApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(UnionApplication.class, args);
	}
}
