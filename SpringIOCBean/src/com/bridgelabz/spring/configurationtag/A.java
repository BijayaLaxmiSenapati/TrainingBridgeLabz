package com.bridgelabz.spring.configurationtag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class A 
{
	@Bean
	public B b() {
		return new B();
	}

}
