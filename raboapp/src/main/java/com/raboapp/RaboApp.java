package com.raboapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RaboApp {
	public static void main(String[] args) {
		SpringApplication.run(RaboApp.class, args);
	}
	

}
