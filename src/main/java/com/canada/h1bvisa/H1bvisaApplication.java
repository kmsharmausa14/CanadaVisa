package com.canada.h1bvisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class H1bvisaApplication {

	public static void main(String[] args) {
		SpringApplication.run(H1bvisaApplication.class, args);
	}

}
