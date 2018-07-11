package com.bridgelabz.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.bridgelabz.*"})
public class WelcomeApp {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeApp.class, args);
	}
}
