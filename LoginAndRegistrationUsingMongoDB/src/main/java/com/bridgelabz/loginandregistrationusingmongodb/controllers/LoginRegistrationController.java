package com.bridgelabz.loginandregistrationusingmongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.loginandregistrationusingmongodb.models.Trainee;
import com.bridgelabz.loginandregistrationusingmongodb.services.TraineeService;

public class LoginRegistrationController {

	@RestController
	@RequestMapping("/LoginRegister")
	public class LoginAndRegistrationController {
		@Autowired
		TraineeService traineeService;

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String login(@RequestBody Trainee trainee) {
			System.out.println(trainee.getEmail());
			return traineeService.login(trainee);
		}

		@RequestMapping(method=RequestMethod.POST,value="/register")
		public String register(@RequestBody Trainee trainee)
		{
			return traineeService.register(trainee);
		}

		@RequestMapping(method=RequestMethod.GET, value="/register")
		public Trainee getGivenTrainee(@RequestHeader("email") String email)
		{
			System.out.println(email);
			System.out.println(email);
			return traineeService.getGivenTrainee(email);
		}
		
	}

}
