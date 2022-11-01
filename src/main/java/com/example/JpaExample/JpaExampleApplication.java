package com.example.JpaExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

}
