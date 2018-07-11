package com.bridgelabz.spring.configurationtag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	@Bean
	public HelloWorl helloWorl() {
		return new HelloWorl();
	}
}
