package com.example.self.self;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class SelfApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SelfApplication.class, args);
	}
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		 .allowedOrigins("*")
	        .allowedMethods("GET", "PUT", "POST","DELETE")
	        .allowedHeaders("*")
	       
	        .allowCredentials(true);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
