/**
 * ..
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class WindChill {

	public static void main(String[] args) {
		double tempratureInfahrenheit=Double.parseDouble(args[0]);
		System.out.println("temprature given by the user is "+tempratureInfahrenheit+" fahrenheit");
		double windSpeedInMilesPerHour=Double.parseDouble(args[1]);
		System.out.println("wind speed given by the user is "+windSpeedInMilesPerHour+" Miles/Hour");
		double weather=Utility.defineWeather(tempratureInfahrenheit,windSpeedInMilesPerHour);
		if(weather==0.0)
		{
			System.out.println("you have entered the invalid range of inputs");
		}
		else
			System.out.println("the effective temprature or weather given by National Weather Service is "+weather);
	}

}
