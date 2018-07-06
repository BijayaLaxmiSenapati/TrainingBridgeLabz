/**
 * ..
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class Quadratic {

	
	public static void main(String[] args) {
		System.out.println("The structure of Quadratic equation is \"a*x*x+b*x+c=0\"");
		System.out.println("enter the constant with \"x*x\" in the equation");
		int firstConstant=Utility.retInt();
		System.out.println("enter the constant with \"x\" in the equation");
		int secondConstant=Utility.retInt();
		System.out.println("enter the last constant");
		int lastConstant=Utility.retInt();
		double[] rootArray=Utility.calRootsOfQuadraticEquation(firstConstant,secondConstant,lastConstant);
		double root1=rootArray[0];
		double root2=rootArray[1];
		System.out.println("root1= "+root1);
		System.out.println("root2= "+root2);
	}

}
