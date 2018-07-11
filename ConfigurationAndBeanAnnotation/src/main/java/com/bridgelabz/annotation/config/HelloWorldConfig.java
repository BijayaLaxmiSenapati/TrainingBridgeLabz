package com.bridgelabz.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.annotation.model.HelloWorld;

@Configuration
public class HelloWorldConfig 
{
	@Bean
	public HelloWorld hello(){
		return new HelloWorld();
	}
}
