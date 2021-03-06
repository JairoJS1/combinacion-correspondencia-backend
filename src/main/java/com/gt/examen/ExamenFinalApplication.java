package com.gt.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ExamenFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalApplication.class, args);
	}
         @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://correspondenciafrontend.herokuapp.com").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}


