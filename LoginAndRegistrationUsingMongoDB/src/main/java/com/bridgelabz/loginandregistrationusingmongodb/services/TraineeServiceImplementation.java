package com.bridgelabz.loginandregistrationusingmongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.loginandregistrationusingmongodb.models.Trainee;
import com.bridgelabz.loginandregistrationusingmongodb.repositories.TraineeRepository;

@Service
public class TraineeServiceImplementation implements TraineeService {
	@Autowired
	TraineeRepository traineeRepository;

	public String login(Trainee trainee) {
		Trainee trainee2;
		trainee2 = traineeRepository.getTraineeByEmail(trainee.getEmail());
		if (trainee2 != null) {
			if (trainee2.getPassword().equals(trainee.getPassword())) {
				return "You are successfully logged in";
			}
			return "Given password is incorrect";
		} else {
			return "Given Email ID does not exist";
		}
	}

	public String register(Trainee trainee) {
		Trainee trainee2;
		trainee2 = traineeRepository.getTraineeByEmail(trainee.getEmail());
		if (trainee2 == null) {
			traineeRepository.addTrainee(trainee);
		} else {
			return "Given Email Id already in use, which you have entered";
		}
		return "You are successfully registered";
	}

	public Trainee getGivenTrainee(String email) {
		Trainee trainee2;
		trainee2 = traineeRepository.getTraineeByEmail(email);
		trainee2.setPassword("*******");
		return trainee2;
	}
}
