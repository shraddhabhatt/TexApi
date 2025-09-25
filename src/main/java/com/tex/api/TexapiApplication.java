package com.tex.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.tex.api.repository")
@EntityScan(basePackages = "com.tex.api.entity")
@SpringBootApplication
public class TexapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TexapiApplication.class, args);
	}

}
