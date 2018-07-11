package com.bridgelabz.loginandregistrationusingmongodb.repositories;

import com.bridgelabz.loginandregistrationusingmongodb.models.Trainee;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TraineeRepository {
	
	public MongoCollection getCollection() {
		System.out.println("Creating connection with mongodb server");
		MongoClient mongoClient=new MongoClient("localhost", 27017);
		System.out.println("Connection established with server");
		
		System.out.println("Connecting with database");
		MongoDatabase database=mongoClient.getDatabase("Trainee");
		System.out.println("Connected with database");
		
		System.out.println("Getting the Collection");
		MongoCollection<org.bson.Document> collection=database.getCollection("Trainee");
		System.out.println("Got Collection");
		return collection;
	}

	public Trainee getTraineeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		
	}

}
