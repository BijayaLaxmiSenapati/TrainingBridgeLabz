package com.bridgelabz.basics;

import java.util.List;
import java.util.Set;

public class Question {
	int id;
	String name;
	List<Answer> answers;
	public Question(){
		
	}
	public Question(int id, String name, List<Answer> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", answers=" + answers + "]";
	}
}
