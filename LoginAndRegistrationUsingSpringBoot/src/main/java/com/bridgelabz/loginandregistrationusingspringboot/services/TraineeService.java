package com.bridgelabz.loginandregistrationusingspringboot.services;

import com.bridgelabz.loginandregistrationusingspringboot.models.Trainee;

public interface TraineeService {

	String login(Trainee trainee);

	String register(Trainee trainee);

	Trainee getGivenTrainee(String email);

}
