package com.bridgelabz.loginandregistrationusingmongodb.services;

import com.bridgelabz.loginandregistrationusingmongodb.models.Trainee;

public interface TraineeService {

	String login(Trainee trainee);

	String register(Trainee trainee);

	Trainee getGivenTrainee(String email);

}
