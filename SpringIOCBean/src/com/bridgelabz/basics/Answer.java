package com.bridgelabz.basics;

public class Answer {
	int answerId;
	String answer;
	String postedBy;
	public Answer(){
		
	}
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + ", postedBy=" + postedBy + "]";
	}
	public Answer(int answerId, String answer, String postedBy) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.postedBy = postedBy;
	}
}
