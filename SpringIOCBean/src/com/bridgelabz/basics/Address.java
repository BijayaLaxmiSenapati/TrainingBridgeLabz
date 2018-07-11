package com.bridgelabz.basics;

public class Address {
	String city;
	String state;
	String country;
	public Address() {
		System.out.println("in address");
	}
	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + "]";
	}
}
