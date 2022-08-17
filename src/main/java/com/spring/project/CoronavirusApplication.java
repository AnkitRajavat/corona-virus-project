package com.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={
		"com.spring.project", "controller","com.spring.project.services","model"})
@EnableScheduling
@ComponentScan("controller")
public class CoronavirusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusApplication.class, args);
	}

}
