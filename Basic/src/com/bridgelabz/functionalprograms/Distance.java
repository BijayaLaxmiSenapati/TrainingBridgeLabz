/**
 * purpose:Prints euclidean distance from the point (x,y) to origin (0,0).
 * @author:Bijaya Laxmi
 * @version:1.0
 * @since:18/05/2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Distance {

	
	public static void main(String[] args)
	{
		int firstPoint=Integer.parseInt(args[0]);
		int secondPoint=Integer.parseInt(args[1]);
		System.out.println(Utility.calEuclideanDistance(firstPoint,secondPoint));

	}

}
