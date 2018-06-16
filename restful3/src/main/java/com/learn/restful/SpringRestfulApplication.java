package com.learn.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulApplication.class, args);
	}
}
